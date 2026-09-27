package com.pablocompany.proyecto.no1.compi2.common.domain.factory;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

/**
 * Principal factory class for symbol table
 *
 */
public class SymbolTableFactory {

    //Dependency
    public static GlobalSymbolTable create() {
        return new GlobalSymbolTable();
    }
}
