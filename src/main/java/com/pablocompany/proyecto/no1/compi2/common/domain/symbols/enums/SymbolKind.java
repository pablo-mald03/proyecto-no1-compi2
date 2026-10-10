package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums;

import lombok.Getter;

/**
 * Discriminates the kind of symbol stored in the symbol table.
 */
@Getter
public enum SymbolKind {
    CLASS("Clase"),
    METHOD("Metodo"),
    CONSTRUCTOR("Constructor"),
    ATTRIBUTE("Atributo"),
    STRUCT("Struct"),
    FUNCTION("Funcion"),
    PARAMETER("Parametro"),
    GLOBAL_VARIABLE("Variable Global"),
    LOCAL_VARIABLE("Variable Local"),
    IMPORT("Importacion"),
    THIS("Referencia this");

    private final String value;

    SymbolKind(String value) {
        this.value = value;
    }

}