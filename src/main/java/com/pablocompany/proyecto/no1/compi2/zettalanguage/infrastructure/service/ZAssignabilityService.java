package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;

import java.util.HashSet;
import java.util.Set;

/**
 * Service to check if the Polymorphism instance is compatible with its parent
 *
 */
public class ZAssignabilityService {

    private final ZSymbolLookupService lookup;

    public ZAssignabilityService(ZSymbolLookupService lookup) {
        this.lookup = lookup;
    }

    /**
     * Method to return true if a value of type `source` can be assigned to a variable
     * of type `target`.
     */
    public boolean isAssignable(Type source, Type target) {
        if (source == null || target == null) return false;
        if (source.isUnknown() || target.isUnknown()) return true;

        if (source.isCustom() && target.isCustom()) {
            return isSubclassOf(source.getCustomName(), target.getCustomName());
        }

        if (source.getKind() == target.getKind()) {
            return true;
        }

        if (source.getKind() == TypeKind.NULL) {
            return target.isCustom()
                    || target.isArray()
                    || target.getKind() == TypeKind.STRING;
        }

        if (isNumeric(source) && isNumeric(target)) {
            return canPromote(source.getKind(), target.getKind());
        }

        if (source.isArray() && target.isArray()) {
            if (source.getDimensions() != target.getDimensions()) return false;
            return isAssignable(source.getElementType(), target.getElementType());
        }

        return false;
    }

    /**
     * Method to walks the parent chain of `child` looking for `parent`.
     */
    public boolean isSubclassOf(String child, String parent) {
        if (child == null || parent == null) return false;
        if (child.equals(parent)) return true;

        Set<String> seen = new HashSet<>();
        String current = child;

        while (current != null && seen.add(current)) {
            if (parent.equals(current)) return true;

            Symbol s = lookup.findType(current);
            if (s == null) return false;

            String next = s.getParentName();
            if (next == null || next.isBlank()) return false;
            current = next;
        }
        return false;
    }

    /**
     * Method to check if the type is numeric
     *
     */
    private boolean isNumeric(Type t) {
        TypeKind k = t.getKind();
        return k == TypeKind.INT
                || k == TypeKind.FLOAT
                || k == TypeKind.CHAR
                || k == TypeKind.BOOLEAN;
    }

    /**
     * Method to check if the type can be promoted
     *
     */
    private boolean canPromote(TypeKind from, TypeKind to) {
        if (from == to) return true;
        if (to == TypeKind.FLOAT) return true;
        return false;
    }
}