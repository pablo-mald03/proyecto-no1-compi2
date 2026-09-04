package com.pablocompany.practica.no1.compi2.domain.wrappers;

import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.TypeNode;
import com.pablocompany.practica.no1.compi2.domain.semantic.childs.expressions.types.enums.DataType;
import lombok.Getter;
import lombok.Setter;

//This is the principal wrapper to validate the typeChecker
@Getter
@Setter
public class TypeWrapper {

    private final TypeNode typeNode;

    private final String value;

    private final String fullExpression;

    public TypeWrapper(TypeNode typeNode, String value) {
        this.typeNode = typeNode;
        this.value = value;
        this.fullExpression = value;
    }

    public TypeWrapper(TypeNode typeNode, String value, String fullExpression) {
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
