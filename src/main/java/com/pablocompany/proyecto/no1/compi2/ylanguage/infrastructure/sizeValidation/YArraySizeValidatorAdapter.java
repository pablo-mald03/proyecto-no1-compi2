package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.sizeValidation;

import com.pablocompany.proyecto.no1.compi2.common.domain.arraySize.ArraySizeValidator;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.walkers.YArraySizeValidatorVisitor;

/**
 * Principal array size validator port
 *
 */
public class YArraySizeValidatorAdapter implements ArraySizeValidator {

    @Override
    public void validate(EditorContext ctx, GlobalSymbolTable table) {
        if (ctx.getAstNode() == null) return;

        YArraySizeValidatorVisitor visitor = new YArraySizeValidatorVisitor(table, ctx);

        if (ctx.getAstNode() instanceof ProgramNodeY program) {
            program.accept(visitor);
        }
    }
}