package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils;

/**
 * Principal utility class for escaping and uncapping string and character literals
 */
public class StringEscapeUtil {

    private StringEscapeUtil() {
    }

    /**
     * Method to escape a string literal value for use inside double quotes in C and RISC-V assembly.
     *
     */
    public static String escape(String string) {
        if (string == null) return "";
        StringBuilder sb = new StringBuilder();
        int len = string.length();
        for (int i = 0; i < len; i++) {
            char c = string.charAt(i);
            if (c == '\\' && i + 1 < len) {
                char next = string.charAt(i + 1);
                switch (next) {
                    case 'n' -> { sb.append("\\n"); i++; }
                    case 't' -> { sb.append("\\t"); i++; }
                    case 'r' -> { sb.append("\\r"); i++; }
                    case '0' -> { sb.append("\\0"); i++; }
                    case '"' -> { sb.append("\\\""); i++; }
                    case '\'' -> { sb.append("'"); i++; }
                    case '\\' -> { sb.append("\\\\"); i++; }
                    default -> { sb.append("\\\\").append(next); i++; }
                }
            } else if (c == '"') {
                sb.append("\\\"");
            } else if (c == '\\') {
                sb.append("\\\\");
            } else if (c == '\n') {
                sb.append("\\n");
            } else if (c == '\t') {
                sb.append("\\t");
            } else if (c == '\r') {
                sb.append("\\r");
            } else if (c == '\0') {
                sb.append("\\0");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Method to parse a character literal token text into its corresponding character value.
     *
     */
    public static char parseCharLiteral(String text) {
        if (text == null || text.isEmpty()) return '\0';
        if (text.startsWith("'") && text.endsWith("'") && text.length() >= 2) {
            text = text.substring(1, text.length() - 1);
        }
        if (text.startsWith("\\") && text.length() >= 2) {
            char next = text.charAt(1);
            return switch (next) {
                case 'n' -> '\n';
                case 't' -> '\t';
                case 'r' -> '\r';
                case '\'' -> '\'';
                case '"' -> '"';
                case '\\' -> '\\';
                case '0' -> '\0';
                default -> next;
            };
        }
        return text.isEmpty() ? '\0' : text.charAt(0);
    }
}
