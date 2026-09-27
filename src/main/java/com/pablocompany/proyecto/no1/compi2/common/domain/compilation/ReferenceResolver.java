package com.pablocompany.proyecto.no1.compi2.common.domain.compilation;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

/**
 * Principal reference resolver contest
 *
 */
public interface ReferenceResolver {
    /**
     * Reference resolver principal method
     *
     */
    void resolve(EditorContext context, GlobalSymbolTable table);
}