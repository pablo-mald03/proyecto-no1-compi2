package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.enums.TypeKind;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;

import java.util.HashSet;
import java.util.Set;

/**
 * Single source of truth for "is a value of type S assignable to a variable
 * of type T?" in PigLatin.
 */
public class PigAssignabilityService {

    private final SymbolPigLookupService lookup;
    private final EditorContext context;

    public PigAssignabilityService(SymbolPigLookupService lookup,
                                   EditorContext context) {
        this.lookup = lookup;
        this.context = context;
    }

    /**
     * Method to verify if the object is assignable
     *
     */
    public boolean isAssignable(Type source, Type target) {
        if (source == null || target == null) return false;
        if (source.isUnknown() || target.isUnknown()) return true;

        if (source.isCustom() && target.isCustom()) {
            return isSubclassOf(source.getCustomName(), target.getCustomName());
        }

        if (source.getKind() == TypeKind.NULL) {
            return target.isCustom()
                    || target.isArray()
                    || target.getKind() == TypeKind.STRING;
        }

        if (source.getKind() == target.getKind()) {
            return true;
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
     * Walks the parent chain of `child` looking for `parent`. Cycle-safe.
     */
    public boolean isSubclassOf(String child, String parent) {
        if (child == null || parent == null) return false;
        if (child.equals(parent)) return true;

        Set<String> seen = new HashSet<>();
        String current = child;

        while (current != null && seen.add(current)) {
            if (parent.equals(current)) return true;

            Symbol s = lookup.findTypeSymbolGlobal(context.getFilePath(), current);
            if (s == null) return false;

            String next = s.getParentName();
            if (next == null || next.isBlank()) return false;
            current = next;
        }
        return false;
    }

    /**
     * Method to verify if it's a compatibility instance
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
     * Method to evaluate if the instance can be promoted
     *
     */
    private boolean canPromote(TypeKind from, TypeKind to) {
        if (from == to) return true;
        if (to == TypeKind.FLOAT) return true;
        return false;
    }
}