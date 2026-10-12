package com.pablocompany.proyecto.no1.compi2.common.domain.models;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.semantic.AstNode;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

import java.util.Map;

/**
 * Principal contest for the code generator
 *
 */
public interface CodeGenerator {
    void generate(EditorContext context, GlobalSymbolTable table, Map<AstNode, Type> typeAnnotations,
                  IntermediateBuilder intermediate, CodeGenContext labels);

    default void declare(EditorContext context, CodeGenContext codeGen) {
    }
}