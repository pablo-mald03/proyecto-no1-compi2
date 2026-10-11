package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.c;


import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.MemorySpace;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Address;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.intermediateCode.Operand;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Immediate;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.Register;
import com.pablocompany.proyecto.no1.compi2.codegen.domain.models.StringRef;
import lombok.NoArgsConstructor;

/**
 * Principal syntactic rules for the c code generation
 */
@NoArgsConstructor
public class CSyntax {

    public String registerTo(Register register) {
        return register.legacyName();
    }

    public String operand(Operand operator) {
        return switch (operator) {
            case Register register -> registerTo(register);
            case Immediate immediate -> immediate.getLiteral();
            case StringRef stringRef -> stringRef.getId();
            default -> throw new IllegalStateException("Valor no esperado: " + operator);
        };
    }

 /*   public String address(Address a) {
        return switch (a) {
            case Frame framePtr -> withOffset("fp", framePtr.getOffset());
            case StackTop stackTop -> withOffset("sptr", stackTop.getOffset());
            case Indirect indirect -> withOffset(registerTo(indirect.getBase()), indirect.getOffset());
        };
    }*/

    public String withOffset(String base, int offset) {
        if (offset == 0) return base;
        return offset > 0 ? base + " + " + offset : base + " - " + (-offset);
    }

    /**
     * Nombre del arreglo global que respalda (espacio, tipo): stackinteger, heapfloat, ...
     */
    public String memory(MemorySpace space, ValueType type) {
        String prefix = space == MemorySpace.STACK ? "stack" : "heap";
        return prefix + switch (type.getStorage()) {
            case WORD -> "integer";
            case FLOAT -> "float";
            case POINTER -> "string";
        };
    }

    public String cell(MemorySpace space, ValueType type, Address address) {
        return memory(space, type) + "[" + address(address) + "]";
    }

    public String cType(ValueType t) {
        return switch (t) {
            case INT, BOOLEAN -> "int";
            case FLOAT -> "float";
            case CHAR -> "char";
            case STRING -> "char*";
        };
    }

    public String printfSpec(ValueType t) {
        return switch (t) {
            case STRING -> "%s";
            case FLOAT -> "%f";
            case CHAR -> "%c";
            case INT, BOOLEAN -> "%d";
        };
    }

    public String escape(String s) {
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }
}
