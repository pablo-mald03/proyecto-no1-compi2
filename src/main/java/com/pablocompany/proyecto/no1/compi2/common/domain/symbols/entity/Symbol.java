package com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.statements.functions.enums.ParameterKind;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.enums.AccessModifierZ;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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

    AccessModifierZ accessModifier;

    String declaringClass;

    private int returnDimensions;

    boolean overriding;

    String parentName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Symbol parentSymbol;

    private boolean inheritanceLinked;
    /**
     * Non-null when the hierarchy is invalid
     */
    private String inheritanceError;

    /**
     * Unique id of the class
     */
    private int classId = -1;
    /**
     * Label of the class virtual table
     */
    private String vtableLabel;
    /**
     * Virtual table
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Symbol> vtable = new ArrayList<>();
    /**
     * Every attribute of the object in memory order: inherited ones FIRST
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Symbol> fieldSlots = new ArrayList<>();

    /**
     * Label of the emitted function
     */
    private String codeLabel;
    /**
     * true if it goes through the vtable
     */
    private boolean virtual;
    /**
     * Slot in the vtable of its class
     */
    private int vtableIndex = -1;
    /**
     * Method of the superclass that this one overrides
     */
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Symbol overriddenMethod;

    // ---------- ATTRIBUTE ----------
    /**
     * 0-based position among the object's fields -1 if not a field.
     */
    private int fieldIndex = -1;


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
                kind.getValue(),
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