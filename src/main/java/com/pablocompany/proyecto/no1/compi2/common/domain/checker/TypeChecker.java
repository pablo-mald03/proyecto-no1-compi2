package com.pablocompany.proyecto.no1.compi2.common.domain.checker;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

import java.util.Map;

/**
 * Principal type checker interface
 *
 */
public interface TypeChecker {
    void check(EditorContext context, GlobalSymbolTable table, Map<AstNode, Type> typeAnnotations);
}