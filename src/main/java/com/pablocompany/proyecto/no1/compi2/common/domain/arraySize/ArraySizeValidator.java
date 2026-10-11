package com.pablocompany.proyecto.no1.compi2.common.domain.arraySize;


import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

/**
 * Contract for language-specific array size validators.
 */
public interface ArraySizeValidator {

    /**
     * Walks the AST of the given context and reports any array-size
     */
    void validate(EditorContext ctx, GlobalSymbolTable table);
}