package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums;

/**
 * Discriminates the kind of symbol stored in the symbol table.
 * Using an enum keeps the model simple and avoids a class hierarchy explosion.
 */
public enum SymbolKind {
    CLASS,
    METHOD,
    CONSTRUCTOR,
    ATTRIBUTE,
    STRUCT,
    FUNCTION,
    PARAMETER,
    GLOBAL_VARIABLE,
    LOCAL_VARIABLE,
    IMPORT
}