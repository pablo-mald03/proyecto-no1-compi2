package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;


import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/**
 * Z Access Control Service helper class
 *
 */
public class ZAccessControlService {

    private final EditorContext context;

    /**
     * Resolves a class name to its symbol. Wired by ZSymbolLookupService
     */
    private Function<String, Symbol> typeResolver;

    public ZAccessControlService(EditorContext context) {
        this.context = context;
    }


    /**
     * Returns true if `member` is accessible from the given class.
     */
    public boolean isAccessible(Symbol member, Symbol accessingClass) {
        if (member == null) return false;

        if (accessingClass != null
                && accessingClass.getName().equals(member.getDeclaringClass())) {
            return true;
        }

        if (member.getAccessModifier() == null) return false;

        switch (member.getAccessModifier().name()) {
            case "PUBLIC":
                return true;
            case "PROTECTED":
                return isSubclassOf(accessingClass, member.getDeclaringClass());
            case "PRIVATE":
            default:
                return false;
        }
    }

    /**
     * True if `accessingClass` is a STRICT descendant of `className` (walks the whole chain).
     */
    public boolean isSubclassOf(Symbol accessingClass, String className) {
        if (accessingClass == null || className == null) return false;

        Set<String> seen = new HashSet<>();
        Symbol current = accessingClass;
        while (current != null && seen.add(current.getName())) {
            String parentName = current.getParentName();
            if (parentName == null || parentName.isBlank()) return false;
            if (className.equals(parentName)) return true;

            Symbol next = typeResolver != null ? typeResolver.apply(parentName) : null;
            if (next == null) next = current.getParentSymbol();
            current = next;
        }
        return false;
    }

    /**
     * Method to resolve the visibility ranking used by the override rule
     */
    public static int accessLevel(Object modifier) {
        if (modifier == null) return 2;
        String n = modifier instanceof Enum<?> e ? e.name() : modifier.toString();
        return switch (n) {
            case "PRIVATE" -> 0;
            case "PROTECTED" -> 1;
            default -> 2;
        };
    }

    /**
     * True if `child` gives LESS visibility than `parent`
     */
    public static boolean isWeaker(Object child, Object parent) {
        return accessLevel(child) < accessLevel(parent);
    }

    /**
     * Human readable modifier name for error messages.
     */
    public static String label(Object modifier) {
        if (modifier == null) return "default (private)";
        String n = modifier instanceof Enum<?> e ? e.name() : modifier.toString();
        return n.toLowerCase();
    }

    public void setTypeResolver(Function<String, Symbol> typeResolver) {
        this.typeResolver = typeResolver;
    }
}
