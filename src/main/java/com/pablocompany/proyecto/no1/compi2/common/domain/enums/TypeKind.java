package com.pablocompany.proyecto.no1.compi2.common.domain.enums;

/**
 * Principal type kind enum
 *
 */
public enum TypeKind {
    INT("entero"),
    FLOAT("decimal"),
    STRING("cadena"),
    CHAR("caracter"),
    BOOLEAN("booleano"),
    VOID("vacio"),
    CUSTOM("personalizado"),
    ARRAY("arreglo"),
    UNKNOWN("desconocido");

    private final String traduccion;

    TypeKind(String traduccion) {
        this.traduccion = traduccion;
    }

    public String getTranslation() {
        return traduccion;
    }
}