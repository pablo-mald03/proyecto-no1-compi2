package com.pablocompany.proyecto.no1.compi2.common.domain.models;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

import java.util.Map;

/**
 * Principal contest for the code generator
 *
 */
public interface CodeGenerator {
    CodeGeneratorOutput generate(EditorContext context, GlobalSymbolTable table, Map<AstNode, Type> typeAnnotations);
}