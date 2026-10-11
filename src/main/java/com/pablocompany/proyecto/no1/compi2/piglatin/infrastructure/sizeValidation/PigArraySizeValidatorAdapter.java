package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.sizeValidation;

import com.pablocompany.proyecto.no1.compi2.common.domain.arraySize.ArraySizeValidator;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.ProgramNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.walkers.PigArraySizeValidatorVisitor;

/**
 * Principal pig array size validator port
 *
 */
public class PigArraySizeValidatorAdapter implements ArraySizeValidator {

    @Override
    public void validate(EditorContext ctx, GlobalSymbolTable table) {
        if (ctx.getAstNode() == null) return;

        PigArraySizeValidatorVisitor visitor =
                new PigArraySizeValidatorVisitor(table, ctx);
        if (ctx.getAstNode() instanceof ProgramNodePigLatin program) {
            program.accept(visitor);
        }
    }
}