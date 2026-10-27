package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;

import java.util.*;

public class ZClassLayoutService {

    /**
     * Name of the hidden slot 0 that stores the pointer to the vtable.
     */
    public static final String VPTR = "__vptr";

    /**
     * One row of a class' virtual table.
     */
    public record VTableEntry(int index,
                              String methodName,
                              String signature,
                              String declaringClass,
                              String codeLabel,
                              boolean overridesParent) {
    }

    private final GlobalSymbolTable table;
    private final ZInheritanceService inheritance;

    public ZClassLayoutService(GlobalSymbolTable table, ZInheritanceService inheritance) {
        this.table = table;
        this.inheritance = inheritance;
    }

    // ------------------------------------------------------------------
    // CLASSES
    // ------------------------------------------------------------------

    /**
     * Every CLASS symbol of every file, linked, sorted by name (deterministic order).
     */
    public List<Symbol> collectLinkedClasses() {
        List<Symbol> classes = new ArrayList<>();
        for (SymbolScope fileScope : table.getFileScopes().values()) {
            for (List<Symbol> bucket : fileScope.getSymbols().values()) {
                for (Symbol s : bucket) {
                    if (s.getKind() == SymbolKind.CLASS) classes.add(s);
                }
            }
        }
        classes.sort(Comparator.comparing(Symbol::getName));
        for (Symbol c : classes) inheritance.link(c);
        return classes;
    }

    /**
     * Gives every class a stable, unique id (position in alphabetical order). Useful for a type
     * tag in the object header or for an instanceof-style check.
     */
    public void assignClassIds(List<Symbol> classes) {
        int id = 0;
        for (Symbol c : classes) c.setClassId(id++);
    }

    // ------------------------------------------------------------------
    // OBJECT LAYOUT (compatible with Map<String, List<String>> classLayouts)
    // ------------------------------------------------------------------

    /**
     * Ordered field names of a class: [__vptr?][inherited...][own...].
     * The position in the list is the slot used by heap_alloc / heap_load / heap_store, and a
     * child list always starts with its parent's list, so a Perro can be used as an Animal.
     * <p>
     * A parent field hidden by a descendant redeclaration is renamed "Parent::name" so that
     * indexOf("name") finds the MOST DERIVED one (this.x) and indexOf("Parent::name") finds the
     * parent's one (super.x).
     */
    public List<String> buildFieldLayout(Symbol cls, boolean includeVptr) {
        inheritance.link(cls);
        List<String> layout = new ArrayList<>();
        if (includeVptr) layout.add(VPTR);

        List<Symbol> slots = cls.getFieldSlots();
        for (int i = 0; i < slots.size(); i++) {
            Symbol s = slots.get(i);
            boolean hidden = false;
            for (int j = i + 1; j < slots.size(); j++) {
                if (slots.get(j).getName().equals(s.getName())) {
                    hidden = true;
                    break;
                }
            }
            layout.add(hidden ? hiddenFieldKey(s) : s.getName());
        }
        return layout;
    }

    public static String hiddenFieldKey(Symbol field) {
        return field.getDeclaringClass() + "::" + field.getName();
    }

    /**
     * Layouts for all the classes. Drop-in replacement for the classLayouts map of the generator.
     */
    public Map<String, List<String>> buildAllLayouts(List<Symbol> classes, boolean includeVptr) {
        Map<String, List<String>> result = new LinkedHashMap<>();
        for (Symbol c : classes) result.put(c.getName(), buildFieldLayout(c, includeVptr));
        return result;
    }

    // ------------------------------------------------------------------
    // VIRTUAL TABLE
    // ------------------------------------------------------------------

    /**
     * Rows of the vtable of `cls` in slot order. codeLabel is the function that must be stored in
     * that slot of the table (already the overriding implementation when the child overrides it).
     */
    public List<VTableEntry> buildVTable(Symbol cls) {
        inheritance.link(cls);
        List<VTableEntry> rows = new ArrayList<>();
        List<Symbol> vt = cls.getVtable();
        for (int i = 0; i < vt.size(); i++) {
            Symbol m = vt.get(i);
            rows.add(new VTableEntry(
                    i,
                    m.getName(),
                    m.getSignatureKey(),
                    m.getDeclaringClass(),
                    m.getCodeLabel(),
                    m.getOverriddenMethod() != null));
        }
        return rows;
    }

    /**
     * Slot to use for a virtual call: the method symbol the checker resolved on the STATIC type
     * already carries it (an override shares the slot of the method it overrides).
     * Returns -1 when the call must be static (private method, super.m(), constructor).
     */
    public int virtualSlotOf(Symbol resolvedMethod) {
        if (resolvedMethod == null || !resolvedMethod.isVirtual()) return -1;
        return resolvedMethod.getVtableIndex();
    }

    /**
     * Method for debug dump
     */
    public String describe(Symbol cls) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getVtableLabel()).append(" (classId=").append(cls.getClassId()).append(")\n");
        for (VTableEntry e : buildVTable(cls)) {
            sb.append("  [").append(e.index()).append("] ")
                    .append(e.signature()).append(" -> ").append(e.codeLabel())
                    .append(e.overridesParent() ? "   (override)" : "")
                    .append('\n');
        }
        return sb.toString();
    }
}
