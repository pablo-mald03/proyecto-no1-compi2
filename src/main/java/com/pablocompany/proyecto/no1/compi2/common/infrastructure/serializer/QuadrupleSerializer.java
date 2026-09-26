package com.pablocompany.proyecto.no1.compi2.common.infrastructure.serializer;

import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.Quadruple;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;

/**
 * Principal class to serialize a list of quadruples into valid C code.
 */
public class QuadrupleSerializer {

    private final CodeGeneratorOutput output;
    private final StringPool stringPool;
    private final StringBuilder sb;

    public QuadrupleSerializer(CodeGeneratorOutput output, StringPool stringPool) {
        this.output = output;
        this.stringPool = stringPool;
        this.sb = new StringBuilder();
    }

    public String serialize() {
        emitPrelude();
        emitStructDefinitions();
        emitStringConstants();
        emitGlobals();
        emitFunctions();
        return sb.toString();
    }

    // ============================================================
    // PRELUDE
    // ============================================================

    private void emitPrelude() {
        sb.append("#include <stdio.h>\n");
        sb.append("#include <stdlib.h>\n");
        sb.append("#include <string.h>\n\n");
    }

    private void emitStructDefinitions() {
        // Not implemented yet. Structs in .y are user-defined.
        // For the first version, we skip this.
        // TODO: emit struct definitions from the StructDeclaration nodes.
    }

    private void emitStringConstants() {
        for (String literal : stringPool.getLiteralsInOrder()) {
            String id = stringPool.getId(literal);
            sb.append("const char* ").append(id)
                    .append(" = \"").append(escapeCString(literal)).append("\";\n");
        }
        if (!stringPool.getLiteralsInOrder().isEmpty()) {
            sb.append("\n");
        }
    }

    private void emitGlobals() {
        // For now, nothing. Variables are declared inside functions.
    }

    // ============================================================
    // FUNCTIONS
    // ============================================================

    private void emitFunctions() {
        boolean insideFunction = false;

        for (Quadruple q : output.getQuadruples()) {
            if ("label".equals(q.getOp()) && output.getFunctionNames().contains(q.getArg1())) {
                if (insideFunction) sb.append("}\n\n");
                sb.append("void ").append(q.getArg1()).append("() {\n");
                insideFunction = true;
                continue;
            }

            if (!insideFunction) continue;

            emitQuadruple(q);
        }

        if (insideFunction) sb.append("}\n");
    }

    private void emitQuadruple(Quadruple q) {
        String op = q.getOp();
        String a1 = q.getArg1();
        String a2 = q.getArg2();
        String res = q.getResult();

        switch (op) {
            case "=":
                sb.append("  ").append(res).append(" = ").append(a1).append(";\n");
                break;
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
            case "==":
            case "!=":
            case "<":
            case ">":
            case "<=":
            case ">=":
            case "&&":
            case "||":
                sb.append("  ").append(res).append(" = ")
                        .append(a1).append(" ").append(op).append(" ").append(a2).append(";\n");
                break;
            case "!":
                sb.append("  ").append(res).append(" = !").append(a1).append(";\n");
                break;
            case "goto":
                sb.append("  goto ").append(res).append(";\n");
                break;
            case "ifFalse":
                sb.append("  if (!").append(a1).append(") goto ").append(res).append(";\n");
                break;
            case "ifTrue":
                sb.append("  if (").append(a1).append(") goto ").append(res).append(";\n");
                break;
            case "label":
                sb.append(res).append(":;\n");
                break;
            case "print":
                sb.append("  printf(\"%d\\n\", ").append(a1).append(");\n");
                break;
            case "read":
                sb.append("  scanf(\"%d\", &").append(res).append(");\n");
                break;
            case "param":
                sb.append("  // param ").append(a1).append("\n");
                break;
            case "call":
                sb.append("  ").append(res).append(" = ")
                        .append(a1).append("();\n");
                break;
            case "return":
                if (a1 != null) {
                    sb.append("  return ").append(a1).append(";\n");
                } else {
                    sb.append("  return;\n");
                }
                break;
            case "array_get":
                sb.append("  ").append(res).append(" = ")
                        .append(a1).append("[").append(a2).append("];\n");
                break;
            case "array_set":
                sb.append("  ").append(a1).append("[").append(a2).append("] = ")
                        .append(res).append(";\n");
                break;
            case "get_field":
                sb.append("  ").append(res).append(" = ")
                        .append(a1).append(".").append(a2).append(";\n");
                break;
            case "set_field":
                sb.append("  ").append(a1).append(".").append(a2)
                        .append(" = ").append(res).append(";\n");
                break;
            case "alloc_struct":
                sb.append("  // TODO: alloc struct ").append(a1)
                        .append(" -> ").append(res).append("\n");
                break;
            default:
                sb.append("  // unknown op: ").append(op).append("\n");
        }
    }

    private String escapeCString(String s) {
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }
}