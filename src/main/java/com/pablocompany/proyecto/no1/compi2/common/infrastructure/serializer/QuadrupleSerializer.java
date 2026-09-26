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
    // HEADER (no function context)
    // ============================================================

    private void emitPrelude() {
        sb.append("#include <stdio.h>\n");
        sb.append("#include <stdlib.h>\n");
        sb.append("#include <string.h>\n\n");
    }

    private void emitStructDefinitions() {
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
        // TODO: emit global variables.
    }

    // ============================================================
    // FUNCTIONS
    // ============================================================

    private void emitFunctions() {
        // insideFunction tells us if we are currently inside a function body.
        // It is initially false (we are in the "header" of the file).
        boolean insideFunction = false;

        for (Quadruple q : output.getQuadruples()) {
            String op = q.getOp();

            // Handle function boundaries BEFORE dispatching to emitQuadruple.
            if ("function_start".equals(op)) {
                // Close the previous function if there was one.
                if (insideFunction) {
                    sb.append("}\n\n");
                }

                // Open the new function.
                String returnType = q.getArg2() != null ? q.getArg2() : "void";
                sb.append(returnType).append(" ").append(q.getArg1()).append("() {\n");
                insideFunction = true;
                continue;
            }

            // Skip anything that is outside a function context.
            if (!insideFunction) continue;

            emitQuadruple(q);
        }

        // Close the last function if we opened one.
        if (insideFunction) {
            sb.append("}\n");
        }
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
                // Internal labels are always in arg1.
                sb.append(a1).append(":;\n");
                break;

            case "print": {
                String format = switch (a2 != null ? a2 : "int") {
                    case "string" -> "%s";
                    case "float" -> "%f";
                    case "char" -> "%c";
                    default -> "%d";
                };
                sb.append("  printf(\"").append(format).append("\\n\", ")
                        .append(a1).append(");\n");
                break;
            }

            case "read":
                sb.append("  scanf(\"%d\", &").append(res).append(");\n");
                break;

            case "param":
                sb.append("  // param ").append(a1).append("\n");
                break;

            case "call":
                sb.append("  ").append(res).append(" = ").append(a1).append("();\n");
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