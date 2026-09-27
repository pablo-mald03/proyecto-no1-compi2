package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.validator;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.walkers.ClassFileNameValidatorVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Validates that every .z file declares a class with the same name as the file.
 */
public class ClassFileNameValidator {

    /**
     * Method to validate the class filename
     *
     */
    public void validate(Map<String, EditorContext> allContexts) {
        for (EditorContext context : allContexts.values()) {
            if (!".z".equals(context.getFileExtension())) {
                continue;
            }

            if (!(context.getAstNode() instanceof ZAstNode zAst)) {
                continue;
            }

            ClassFileNameValidatorVisitor visitor = new ClassFileNameValidatorVisitor(
                    context.getFileName(),
                    context.getFilePath()
            );
            zAst.accept(visitor);

            List<CompilerError> errors = visitor.getErrors();
            if (!errors.isEmpty()) {
                if (context.getSemanticErrors() == null) {
                    context.setSemanticErrors(new ArrayList<>());
                }
                context.getSemanticErrors().addAll(errors);
            }
        }
    }
}
