package com.pablocompany.proyecto.no1.compi2.common.domain.wrappers;


import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.TypeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.types.enums.DataType;
import lombok.Getter;
import lombok.Setter;

//This is the principal wrapper to validate the typeChecker
@Getter
@Setter
public class TypeWrapper {

    private final TypeNodePigLatin typeNode;

    private final String value;

    private final String fullExpression;

    public TypeWrapper(TypeNodePigLatin typeNode, String value) {
        this.typeNode = typeNode;
        this.value = value;
        this.fullExpression = value;
    }

    public TypeWrapper(TypeNodePigLatin typeNode, String value, String fullExpression) {
        this.typeNode = typeNode;
        this.value = value;
        this.fullExpression = fullExpression;
    }

    public DataType getDataType() {
        return typeNode != null ? typeNode.getDataType() : null;
    }


    public String getDisplayString() {
        if (value != null && typeNode != null) {
            return "'" + value + "' (tipo: " + typeNode.getDataType().getValue() + ")";
        } else if (typeNode != null) {
            return "tipo: " + typeNode.getDataType().getValue();
        }
        return "desconocido";
    }

    //This method is the principal to return the value of the wrapper
    public String getValue(String constant) {
        return (value == null) ? constant : this.value;
    }
}
