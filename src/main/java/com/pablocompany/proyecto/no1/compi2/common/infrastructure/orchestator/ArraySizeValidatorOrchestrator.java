package com.pablocompany.proyecto.no1.compi2.common.infrastructure.orchestator;

import com.pablocompany.proyecto.no1.compi2.common.domain.arraySize.ArraySizeValidator;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.factory.ArraySizeValidatorFactory;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;

import java.util.List;
import java.util.Map;

/**
 * Orchestrator to validate the array size
 *
 */
public class ArraySizeValidatorOrchestrator {

    /**
     * Principal method to validate all sizes of array
     *
     */
    public void validateAll(Map<String, EditorContext> fileContexts,
                            List<String> topologicalOrder,
                            GlobalSymbolTable table) {
        for (String filePath : topologicalOrder) {
            EditorContext ctx = fileContexts.get(filePath);
            if (ctx == null || ctx.getAstNode() == null) continue;

            ArraySizeValidator validator = ArraySizeValidatorFactory.create(ctx.getFileExtension());
            if (validator == null) continue;

            validator.validate(ctx, table);
        }
    }
}