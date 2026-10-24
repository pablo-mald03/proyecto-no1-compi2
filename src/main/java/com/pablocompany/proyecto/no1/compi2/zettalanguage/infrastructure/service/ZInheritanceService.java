package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.services.SymbolInheritanceLinkerService;

/**
 * Service to link the classes with its ancestors
 *
 */
public class ZInheritanceService {

    private final SymbolInheritanceLinkerService linker;

    /**
     * Method to evaluate the inheritance
     *
     */
    public ZInheritanceService(ZSymbolLookupService lookup) {
        this.linker = new SymbolInheritanceLinkerService(lookup::findType);
    }

    /**
     * Links `cls` and every ancestor. Returns true when the hierarchy is valid.
     */
    public boolean link(Symbol cls) {
        return linker.link(cls);
    }

    /**
     * Method to finds a member by simple name,
     */
    public Symbol findMemberByName(Symbol cls, String name) {
        return linker.findMemberByName(cls, name);
    }

    /**
     * Direct superclass symbol or null.
     */
    public Symbol parentOf(Symbol cls) {
        return linker.parentOf(cls);
    }
}
