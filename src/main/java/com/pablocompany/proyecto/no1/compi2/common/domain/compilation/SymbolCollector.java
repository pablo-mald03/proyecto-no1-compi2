package com.pablocompany.proyecto.no1.compi2.common.domain.compilation;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

/**
 * Principal contest symbol collector for any language
 *
 */
public interface SymbolCollector {

    /**
     * Collects all declarations from the given file context into the shared table.
     */
    void collect(EditorContext context, GlobalSymbolTable table);


}