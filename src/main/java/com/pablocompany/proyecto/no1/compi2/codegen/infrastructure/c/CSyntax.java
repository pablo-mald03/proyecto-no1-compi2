package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c;


import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Operand;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.*;
import lombok.NoArgsConstructor;

/**
 * Principal syntactic rules for the c code generation
 */
@NoArgsConstructor
public class CSyntax {

    public String registerTo(Register register) {
        return register.legacyName();
    }

    /**
     * Method to generate the operand
     *
     */
    public String operand(Operand operator) {
        return switch (operator) {
            case Register register -> registerTo(register);
            case Immediate immediate -> immediate.getLiteral();
            case StringRef stringRef -> stringRef.getId();
            default -> throw new IllegalStateException("Valor no esperado: " + operator);
        };
    }

    /**
     * Method to generate the address operation
     *
     */
    public String address(Address a) {
        return switch (a) {
            case Frame framePtr -> withOffset("fp", framePtr.getOffset());
            case StackTop stackTop -> withOffset("sptr", stackTop.getOffset());
            case Indirect indirect -> withOffset(registerTo(indirect.getBase()), indirect.getOffset());
            default -> throw new IllegalStateException("Valor no esperado: " + a);
        };
    }

    /**
     * Method to update the offset
     * */
    public String withOffset(String base, int offset) {
        if (offset == 0) return base;
        return offset > 0 ? base + " + " + offset : base + " - " + (-offset);
    }

    /**
     * Arrau global name for array memory method
     */
    public String memory(MemorySpace space, ValueType type) {
        String prefix = space == MemorySpace.STACK ? "stack" : "heap";
        return prefix + switch (type.getStorage()) {
            case WORD -> "integer";
            case FLOAT -> "float";
            case POINTER -> "string";
        };
    }

    /**
     * Method to generate the  cell
     * */
    public String cell(MemorySpace space, ValueType type, Address address) {
        return memory(space, type) + "[" + address(address) + "]";
    }

    /**
     * Method to generate the c type
     * */
    public String cType(ValueType t) {
        return switch (t) {
            case INT, BOOLEAN -> "int";
            case FLOAT -> "float";
            case CHAR -> "char";
            case STRING -> "char*";
        };
    }

    /**
     * Method to print the data value
     * */
    public String printfSpec(ValueType t) {
        return switch (t) {
            case STRING -> "%s";
            case FLOAT -> "%f";
            case CHAR -> "%c";
            case INT, BOOLEAN -> "%d";
        };
    }

    /**
     * Method to scape the text
     * */
    public String escape(String s) {
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }
}
