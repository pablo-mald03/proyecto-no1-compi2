package com.pablocompany.proyecto.no1.compi2.common.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Linker helper service class with the instances
 *
 */
public class SymbolInheritanceLinkerService {

    /**
     * Resolves a class name to its symbol (each front end plugs its own search).
     */
    private final Function<String, Symbol> typeResolver;

    public SymbolInheritanceLinkerService(Function<String, Symbol> typeResolver) {
        this.typeResolver = typeResolver;
    }

    // ------------------------------------------------------------------
    // PUBLIC API
    // ------------------------------------------------------------------

    /**
     * Method to links `cls` and every ancestor. Returns true when the hierarchy is valid.
     */
    public boolean link(Symbol cls) {
        if (cls == null) return false;
        return doLink(cls, new ArrayList<>());
    }

    /**
     * Method to finds a member (attribute or method, never constructors) by simple name
     */
    public Symbol findMemberByName(Symbol cls, String name) {
        if (cls == null || name == null) return null;
        link(cls);
        if (cls.getMembers() == null) return null;
        for (Symbol m : cls.getMembers()) {
            if (m.getKind() == SymbolKind.CONSTRUCTOR) continue;
            if (name.equals(m.getName())) return m;
        }
        return null;
    }

    /**
     * Direct superclass symbol or null.
     */
    public Symbol parentOf(Symbol cls) {
        if (cls == null || cls.getParentName() == null || cls.getParentName().isBlank()) return null;
        Symbol p = typeResolver.apply(cls.getParentName());
        return (p != null && p.getKind() == SymbolKind.CLASS) ? p : null;
    }


    /**
     * Method to do the link with another classes
     *
     */
    private boolean doLink(Symbol cls, List<Symbol> path) {
        if (cls.isInheritanceLinked()) return cls.getInheritanceError() == null;

        int cycleStart = indexOfIdentity(path, cls);
        if (cycleStart >= 0) {
            List<Symbol> cycle = new ArrayList<>(path.subList(cycleStart, path.size()));
            StringBuilder chain = new StringBuilder();
            for (Symbol s : cycle) chain.append(s.getName()).append(" -> ");
            chain.append(cls.getName());
            for (Symbol s : cycle) {
                s.setInheritanceError("Herencia ciclica detectada: " + chain);
                s.setInheritanceLinked(true);
            }
            return false;
        }

        path.add(cls);
        Symbol parent = null;
        boolean parentOk = true;
        String parentName = cls.getParentName();
        if (parentName != null && !parentName.isBlank()) {
            Symbol found = typeResolver.apply(parentName);
            if (found != null && found.getKind() == SymbolKind.CLASS) {
                parent = found;
                parentOk = doLink(parent, path);
            }
        }
        path.remove(path.size() - 1);

        if (cls.isInheritanceLinked()) return cls.getInheritanceError() == null;

        if (!parentOk) {
            cls.setInheritanceError("La clase '" + cls.getName() + "' hereda de '" + parentName
                    + "', que pertenece a una jerarquia de herencia invalida");
            cls.setInheritanceLinked(true);
            return false;
        }

        cls.setParentSymbol(parent);
        mergeMembers(cls, parent);
        buildFieldSlots(cls, parent);
        buildVTable(cls, parent);
        cls.setVtableLabel("vtable_" + cls.getName());
        cls.setInheritanceLinked(true);
        return true;
    }

    /**
     * Method to evaluate the own members first validation for the classes
     */
    private void mergeMembers(Symbol cls, Symbol parent) {
        if (cls.getMembers() == null) cls.setMembers(new ArrayList<>());
        if (parent == null || parent.getMembers() == null) return;

        List<Symbol> own = new ArrayList<>(cls.getMembers());
        for (Symbol inherited : parent.getMembers()) {
            if (inherited.getKind() == SymbolKind.CONSTRUCTOR) continue;

            boolean redeclared = false;
            for (Symbol o : own) {
                if (o.getKind() == inherited.getKind()
                        && o.getName().equals(inherited.getName())
                        && o.getParameterTypes().equals(inherited.getParameterTypes())) {
                    redeclared = true;
                    break;
                }
            }
            if (!redeclared) cls.getMembers().add(inherited);
        }
    }

    /**
     * Object layout common resolver helper method
     */
    private void buildFieldSlots(Symbol cls, Symbol parent) {
        List<Symbol> slots = new ArrayList<>();
        if (parent != null && parent.getFieldSlots() != null) slots.addAll(parent.getFieldSlots());

        for (Symbol m : cls.getMembers()) {
            if (m.getKind() != SymbolKind.ATTRIBUTE) continue;
            if (!cls.getName().equals(m.getDeclaringClass())) continue;
            if (indexOfIdentity(slots, m) >= 0) continue;
            m.setFieldIndex(slots.size());
            slots.add(m);
        }
        cls.setFieldSlots(slots);
    }

    /**
     * Virtual table checker method
     */
    private void buildVTable(Symbol cls, Symbol parent) {
        List<Symbol> vt = new ArrayList<>();
        if (parent != null && parent.getVtable() != null) vt.addAll(parent.getVtable());

        for (Symbol m : cls.getMembers()) {
            if (m.getKind() != SymbolKind.METHOD) continue;
            if (!cls.getName().equals(m.getDeclaringClass())) continue;

            if (isPrivate(m)) {
                m.setVirtual(false);
                m.setVtableIndex(-1);
                m.setOverriddenMethod(null);
                continue;
            }

            int slot = indexOfSignature(vt, m);
            if (slot >= 0) {
                m.setOverriddenMethod(vt.get(slot));
                m.setVtableIndex(slot);
                vt.set(slot, m);
            } else {
                m.setOverriddenMethod(null);
                m.setVtableIndex(vt.size());
                vt.add(m);
            }
            m.setVirtual(true);
        }
        cls.setVtable(vt);
    }


    /**
     * Method to evaluate if the variable o attribute is private
     *
     */
    private boolean isPrivate(Symbol m) {
        return m.getAccessModifier() != null && "PRIVATE".equals(m.getAccessModifier().name());
    }

    /**
     * Method to evaluate if the value is out of index signature
     *
     */
    private int indexOfSignature(List<Symbol> vt, Symbol m) {
        for (int i = 0; i < vt.size(); i++) {
            Symbol s = vt.get(i);
            if (s.getName().equals(m.getName()) && s.getParameterTypes().equals(m.getParameterTypes())) return i;
        }
        return -1;
    }

    /**
     * Method to check the identity of the symbol
     *
     */
    private int indexOfIdentity(List<Symbol> list, Symbol target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) return i;
        }
        return -1;
    }
}
