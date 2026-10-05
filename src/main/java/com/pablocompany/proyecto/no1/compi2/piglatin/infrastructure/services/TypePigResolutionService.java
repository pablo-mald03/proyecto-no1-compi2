package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.enums.DataType;

/**
 * Principal service pig resolver helper
 *
 */
public class TypePigResolutionService {

    /**
     * Validates the logic type
     */
    public String resolveTypeName(TypeNodePigLatin typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) return typeNode.getCustomTypeName();
        if (typeNode.getDataType() != null) return typeNode.getDataType().getValue();
        return null;
    }

    /**
     * validate if is custom
     *
     */
    public boolean isCustom(TypeNodePigLatin typeNode) {
        return typeNode != null && typeNode.getDataType() == DataType.CUSTOM;
    }

    /**
     * Method to validate if is Builtin
     *
     */
    public boolean isBuiltin(TypeNodePigLatin typeNode) {
        return typeNode != null
                && typeNode.getDataType() != null
                && typeNode.getDataType() != DataType.CUSTOM;
    }
}