package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.codegen;

import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGenContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.NameMangler;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.ProgramNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.FunctionDeclarationNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.ProcedureDeclarationNodeY;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal delcaration collector helper class
 *
 */
public class YDeclarationCollector {

    /**
     * Method to collect all symbols
     *
     */
    public void collect(ProgramNodeY program, String filePath, CodeGenContext codeGen) {
        if (program.getStructures() != null && program.getStructures().getStructs() != null) {
            for (StructDeclarationNodeY s : program.getStructures().getStructs()) {
                if (s != null) codeGen.registerStruct(s.getStructName(), fieldsOf(s));
            }
        }
        if (program.getFunctions() != null && program.getFunctions().getFunctions() != null) {
            for (YAstNode fn : program.getFunctions().getFunctions()) {
                if (fn instanceof FunctionDeclarationNodeY f) {
                    codeGen.registerFunction(f.getName(),
                            NameMangler.functionName(filePath, f.getName(), f.getLine(), f.getColumn()));
                } else if (fn instanceof ProcedureDeclarationNodeY p) {
                    codeGen.registerFunction(p.getName(),
                            NameMangler.functionName(filePath, p.getName(), p.getLine(), p.getColumn()));
                }
            }
        }
    }

    /**
     * Principal method to get the fields
     *
     */
    private List<String> fieldsOf(StructDeclarationNodeY struct) {
        List<String> fields = new ArrayList<>();
        if (struct.getBody() != null && struct.getBody().getAttributes() != null) {
            for (StructAttributeNodeY attr : struct.getBody().getAttributes()) {
                if (attr != null) fields.add(attr.getIdentifier());
            }
        }
        return fields;
    }
}