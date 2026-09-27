package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.enums.ParameterKind;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal class who represents a declared entity in the program.
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
    private boolean isArray;
    private ParameterKind parameterKind;
    private int dimensions;
    //Null dynamic dimensions
    private List<Integer> dimensionSizes;

    // For callables: signature support (overload)
    private List<String> parameterTypes;

    private String qualifiedName;

    //Struct attributes
    private List<Symbol> members;

    private String returnType;

    public Symbol() {
        this.parameterTypes = new ArrayList<>();
    }

    /**
     * Signature key for overload resolution.
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

    /**
     * Builds a dimensions label
     */
    private String formatDimensions() {
        if (dimensionSizes == null || dimensionSizes.isEmpty()) {
            return dimensions + "D";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dimensionSizes.size(); i++) {
            if (i > 0) sb.append("x");
            sb.append(dimensionSizes.get(i));
        }
        return sb.toString();
    }

    /**
     * Method to pulls every column value needed to render this symbol as a row in the
     */
    public Object[] toTableRow() {
        String dataType = isCallable()
                ? (returnType != null ? returnType : "void")
                : type;

        return new Object[]{
                name,
                kind,
                dataType,
                isArray ? "Sí" : "No",
                isArray ? formatDimensions() : "-",
                isCallable() ? parameterTypes.size() : "-",
                fileName,
                line,
                column
        };
    }
}
