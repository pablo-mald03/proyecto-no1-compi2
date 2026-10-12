package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.utils;

/**
 * Principal class to write the code and return the result
 *
 */
public class CodeWriter {

    private final StringBuilder sb = new StringBuilder();
    private final String indent;

    public CodeWriter(String indent) {
        this.indent = indent;
    }

    /**
     * Principal line method writer
     */
    public CodeWriter line(String text) {
        sb.append(indent).append(text).append('\n');
        return this;
    }

    /**
     * Principal method to print the normal line.
     */
    public CodeWriter raw(String text) {
        sb.append(text).append('\n');
        return this;
    }

    /**
     * Principal method to print the blank line
     *
     */
    public CodeWriter blank() {
        sb.append('\n');
        return this;
    }

    /**
     * Principal class to print the expression
     *
     */
    @Override
    public String toString() {
        return sb.toString();
    }
}
