package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.MemberLookupResult;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.SymbolScope;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Symbol look up helper service class
 *
 */
public class ZSymbolLookupService {

    private final GlobalSymbolTable table;
    private final EditorContext context;
    private final ZAccessControlService access;

    public ZSymbolLookupService(GlobalSymbolTable table,
                                EditorContext context,
                                ZAccessControlService access) {
        this.table = table;
        this.context = context;
        this.access = access;
        if (access != null) access.setTypeResolver(this::findType);
    }

    public ZSymbolLookupService(GlobalSymbolTable table, EditorContext context) {
        this(table, context, new ZAccessControlService(context));
    }

    /**
     * Method for the global constructor for use when there is no single file context,
     */
    public ZSymbolLookupService(GlobalSymbolTable table) {
        this.table = table;
        this.context = null;
        this.access = null;
    }

    /**
     * Method to evaluates the direct superclass of `cls`, or null if it has none / it is not declared.
     */
    public Symbol getParentClass(Symbol cls) {
        if (cls == null || cls.getParentName() == null || cls.getParentName().isBlank()) return null;
        Symbol parent = findType(cls.getParentName());
        return (parent != null && parent.getKind() == SymbolKind.CLASS) ? parent : null;
    }


    public List<Symbol> resolveByName(String name) {
        return table.resolveByName(name);
    }

    /**
     * Method to looks up a class or struct by name, first in the current file, then globally.
     */
    public Symbol findType(String typeName) {
        if (typeName == null) return null;

        // Per-file priority lookup — only when we have a file context
        if (context != null) {
            List<Symbol> inFile = table.resolveDeepInFile(context.getFilePath(), typeName);
            for (Symbol s : inFile) {
                if (s.getKind() == SymbolKind.CLASS || s.getKind() == SymbolKind.STRUCT) {
                    return s;
                }
            }
        }

        for (SymbolScope fileScope : table.getFileScopes().values()) {
            for (List<Symbol> bucket : fileScope.getSymbols().values()) {
                for (Symbol symbol : bucket) {
                    if ((symbol.getKind() == SymbolKind.CLASS
                            || symbol.getKind() == SymbolKind.STRUCT)
                            && symbol.getName().equals(typeName)) {
                        return symbol;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the class symbol declared in the current file, if any.
     */
    public Symbol getCurrentClassSymbol() {
        SymbolScope fileScope = table.getFileScope(context.getFilePath());
        if (fileScope == null) return null;
        for (List<Symbol> bucket : fileScope.getSymbols().values()) {
            for (Symbol s : bucket) {
                if (s.getKind() == SymbolKind.CLASS) return s;
            }
        }
        return null;
    }

    public MemberLookupResult findMemberInType(Type type, String memberName, Symbol accessingClass) {
        if (type == null || !type.isCustom() || memberName == null) {
            return MemberLookupResult.notFound();
        }

        Symbol owner = findType(type.getCustomName());
        if (owner == null) return MemberLookupResult.notFound();

        Symbol member = findMemberInHierarchy(owner, memberName);
        if (member == null) return MemberLookupResult.notFound();

        if (!access.isAccessible(member, accessingClass)) {
            return MemberLookupResult.inaccessible(member);
        }
        return MemberLookupResult.found(member);
    }

    /**
     * Finds a member (attribute or method) inside a custom type.
     */
    public Symbol findMemberInType(Type type, String memberName) {
        if (type == null || !type.isCustom() || memberName == null) return null;

        Symbol owner = findType(type.getCustomName());
        if (owner == null) return null;

        return findMemberInHierarchy(owner, memberName);
    }

    /**
     * Method to look up at the class first
     */
    private List<Symbol> classChain(Symbol cls) {
        List<Symbol> chain = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Symbol current = cls;
        while (current != null && current.getName() != null && seen.add(current.getName())) {
            chain.add(current);
            if (current.getParentName() == null || current.getParentName().isBlank()) break;
            Symbol next = getParentClass(current);
            if (next == null) next = current.getParentSymbol();
            current = next;
        }
        return chain;
    }

    /**
     * Find a member by name at the class and its ancestors
     */
    private Symbol findMemberInHierarchy(Symbol cls, String memberName) {
        for (Symbol c : classChain(cls)) {
            if (c.getMembers() == null) continue;
            for (Symbol m : c.getMembers()) {
                if (memberName.equals(m.getName())) return m;
            }
        }
        return null;
    }

    /**
     * Method who finds all methods with the given name inside a class.
     */
    public List<Symbol> findMethodsInClass(Symbol classSymbol, String methodName) {
        List<Symbol> result = new ArrayList<>();
        if (classSymbol == null) return result;

        Set<String> seenSignatures = new HashSet<>();
        for (Symbol c : classChain(classSymbol)) {
            if (c.getMembers() == null) continue;
            for (Symbol m : c.getMembers()) {
                if (m.getKind() == SymbolKind.METHOD && m.getName().equals(methodName)) {
                    String key = m.getName() + "(" + String.valueOf(m.getParameterTypes()) + ")";
                    if (seenSignatures.add(key)) result.add(m);
                }
            }
        }
        return result;
    }

    /**
     * Method to find all constructors of a class.
     */
    public List<Symbol> findConstructors(Symbol classSymbol) {
        List<Symbol> result = new ArrayList<>();
        if (classSymbol == null || classSymbol.getMembers() == null) return result;
        for (Symbol m : classSymbol.getMembers()) {
            if (m.getKind() == SymbolKind.CONSTRUCTOR) result.add(m);
        }
        return result;
    }

    /**
     * Method to resolves `this` inside a method/constructor body.
     */
    public Symbol resolveThis() {
        List<Symbol> found = table.resolveByName("this");
        return found.isEmpty() ? null : found.get(0);
    }
}