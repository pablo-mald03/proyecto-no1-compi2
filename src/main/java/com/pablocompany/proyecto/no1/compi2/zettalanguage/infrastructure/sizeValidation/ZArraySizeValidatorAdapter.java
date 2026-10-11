package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.sizeValidation;


import com.pablocompany.proyecto.no1.compi2.common.domain.arraySize.ArraySizeValidator;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ProgramNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers.ZArraySizeValidatorVisitor;

/**
 * Principal size validator adapter for Z language
 *
 */
public class ZArraySizeValidatorAdapter implements ArraySizeValidator {

    @Override
    public void validate(EditorContext ctx, GlobalSymbolTable table) {
        if (ctx.getAstNode() == null) return;

        ZArraySizeValidatorVisitor visitor = new ZArraySizeValidatorVisitor(table, ctx);

        if (ctx.getAstNode() instanceof ProgramNodeZ program) {
            program.accept(visitor);
        }
    }
}