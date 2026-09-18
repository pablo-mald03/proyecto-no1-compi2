package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a declared entity in the program.
 * A single class covers all kinds; the SymbolKind enum discriminates.
 * For callables (methods, functions, constructors), the parameterTypes list
 * encodes the signature, allowing overload resolution.
 */
@Data
public class Symbol {

    private String name;
    private SymbolKind kind;
    private String type;
    private String filePath;
    private String fileName;
    private int line;
    private int column;

    // For callables: signature support (overload)
    private List<String> parameterTypes;

    private String qualifiedName;

    public Symbol() {
        this.parameterTypes = new ArrayList<>();
    }

    /**
     * Signature key for overload resolution.
     * For callables: name + parameter types.
     * For everything else: just name.
     */
    public String getSignatureKey() {
        if (parameterTypes == null || parameterTypes.isEmpty()) {
            return name;
        }
        return name + "(" + String.join(",", parameterTypes) + ")";
    }

    /**
     * Method to validate if is calleable
     *
     */
    public boolean isCallable() {
        return kind == SymbolKind.METHOD || kind == SymbolKind.FUNCTION || kind == SymbolKind.CONSTRUCTOR;
    }

}