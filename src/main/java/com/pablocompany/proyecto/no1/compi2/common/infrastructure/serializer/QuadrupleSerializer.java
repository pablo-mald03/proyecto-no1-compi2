package com.pablocompany.proyecto.no1.compi2.common.infrastructure.serializer;

import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.CodeGeneratorOutput;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.Quadruple;
import com.pablocompany.proyecto.no1.compi2.common.domain.code3D.StringPool;

/**
 * Principal class to serialize a list of quadruples into valid C code.
 */
public class QuadrupleSerializer {

    private static final int STACK_SIZE = 65536;
    private static final int HEAP_SIZE = 65536;

    private final CodeGeneratorOutput output;
    private final StringPool stringPool;
    private final StringBuilder sb;

    public QuadrupleSerializer(CodeGeneratorOutput output, StringPool stringPool) {
        this.output = output;
        this.stringPool = stringPool;
        this.sb = new StringBuilder();
    }

    public String serialize() {
        emitHeader();
        emitStringConstants();
        emitFunctions();
        emitMainCall();
        return sb.toString();
    }

    // ============================================================
    // HEADER
    // ============================================================

    private void emitHeader() {
        sb.append("#include <stdio.h>\n");
        sb.append("#include <stdlib.h>\n");
        sb.append("#include <string.h>\n\n");

        sb.append("int sptr = 0;\n");
        sb.append("int hptr = 0;\n");
        sb.append("int fp = 0;\n\n");

        sb.append("int stackinteger[" + STACK_SIZE + "];\n");
        sb.append("char* stackstring[" + STACK_SIZE + "];\n");
        sb.append("float stackfloat[" + STACK_SIZE + "];\n");
        sb.append("char stackchar[" + STACK_SIZE + "];\n");
        sb.append("int stackboolean[" + STACK_SIZE + "];\n\n");

        sb.append("int heapinteger[" + HEAP_SIZE + "];\n");
        sb.append("char* heapstring[" + HEAP_SIZE + "];\n");
        sb.append("float heapfloat[" + HEAP_SIZE + "];\n");
        sb.append("char heapchar[" + HEAP_SIZE + "];\n");
        sb.append("int heapboolean[" + HEAP_SIZE + "];\n\n");

        sb.append("int AX_INT, BX_INT, CX_INT;\n");
        sb.append("char* AX_STRING, *BX_STRING, *CX_STRING;\n");
        sb.append("float AX_FLOAT, BX_FLOAT, CX_FLOAT;\n");
        sb.append("char AX_CHAR, BX_CHAR, CX_CHAR;\n");
        sb.append("int AX_BOOLEAN, BX_BOOLEAN, CX_BOOLEAN;\n\n");
    }

    private void emitStringConstants() {
        for (String literal : stringPool.getLiteralsInOrder()) {
            String id = stringPool.getId(literal);
            sb.append("char* ").append(id)
                    .append(" = \"").append(escapeCString(literal)).append("\";\n");
        }
        if (!stringPool.getLiteralsInOrder().isEmpty()) {
            sb.append("\n");
        }
    }

    // ============================================================
    // FUNCTIONS
    // ============================================================

    private void emitFunctions() {
        boolean insideFunction = false;

        for (Quadruple q : output.getQuadruples()) {
            String op = q.getOp();

            if ("function_start".equals(op)) {
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

    private void emitMainCall() {
        String mainFunc = null;
        for (String name : output.getFunctionNames()) {
            if (name.startsWith("main_") || name.equals("main")) {
                mainFunc = name;
                break;
            }
        }
        if (mainFunc != null) {
            sb.append("\nint main() {\n");
            sb.append("  ").append(mainFunc).append("();\n");
            sb.append("  return 0;\n");
            sb.append("}\n");
        }
    }

    // ============================================================
    // QUADRUPLE EMISSION
    // ============================================================

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
                sb.append(a1).append(":;\n");
                break;

            case "print": {
                String fmt = switch (a2 != null ? a2 : "int") {
                    case "string" -> "%s";
                    case "float" -> "%f";
                    case "char" -> "%c";
                    default -> "%d";
                };
                sb.append("  printf(\"").append(fmt).append("\\n\", ").append(a1).append(");\n");
                break;
            }

            case "strcat":
                sb.append("  ").append(res).append(" = strcat(").append(a1).append(", ").append(a2).append(");\n");
                break;

            case "read_int":
                sb.append("  scanf(\"%d\", &").append(res).append(");\n");
                break;

            case "read_string":
                sb.append("  ").append(res).append(" = (char*)malloc(1024);\n");
                sb.append("  scanf(\"%s\", ").append(res).append(");\n");
                break;

            case "return":
                sb.append("  return;\n");
                break;

            case "sptr_inc":
                sb.append("  sptr = sptr + ").append(a1).append(";\n");
                break;

            case "sptr_dec":
                sb.append("  sptr = sptr - ").append(a1).append(";\n");
                break;

            case "load_int":
                sb.append("  ").append(res).append(" = stackinteger[").append(a1).append("];\n");
                break;
            case "load_string":
                sb.append("  ").append(res).append(" = stackstring[").append(a1).append("];\n");
                break;
            case "load_float":
                sb.append("  ").append(res).append(" = stackfloat[").append(a1).append("];\n");
                break;
            case "load_char":
                sb.append("  ").append(res).append(" = stackchar[").append(a1).append("];\n");
                break;
            case "load_boolean":
                sb.append("  ").append(res).append(" = stackboolean[").append(a1).append("];\n");
                break;

            case "store_int":
                sb.append("  stackinteger[").append(a1).append("] = ").append(res).append(";\n");
                break;
            case "store_string":
                sb.append("  stackstring[").append(a1).append("] = ").append(res).append(";\n");
                break;
            case "store_float":
                sb.append("  stackfloat[").append(a1).append("] = ").append(res).append(";\n");
                break;
            case "store_char":
                sb.append("  stackchar[").append(a1).append("] = ").append(res).append(";\n");
                break;
            case "store_boolean":
                sb.append("  stackboolean[").append(a1).append("] = ").append(res).append(";\n");
                break;

            case "fp_push":
                sb.append("  stackinteger[sptr] = fp;\n");
                sb.append("  sptr = sptr + 1;\n");
                break;

            case "fp_set":
                sb.append("  fp = sptr;\n");
                break;

            case "fp_pop":
                sb.append("  sptr = fp;\n");
                sb.append("  sptr = sptr - 1;\n");
                sb.append("  fp = stackinteger[sptr];\n");
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