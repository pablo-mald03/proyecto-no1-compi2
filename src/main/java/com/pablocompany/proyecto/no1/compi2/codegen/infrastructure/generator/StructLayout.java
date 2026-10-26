package com.pablocompany.proyecto.no1.compi2.codegen.infrastructure.generator;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.GlobalSymbolTable;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Principal class for Single source of truth for the EMBEDDED struct memory layout used by .y and PigLatin.
 */
public class StructLayout {

    private final GlobalSymbolTable table;
    private Map<String, List<Symbol>> memberCache;
    private final Map<String, Integer> sizeCache = new HashMap<>();
    private final Map<String, Integer> offsetCellCache = new HashMap<>();

    public StructLayout(GlobalSymbolTable table) {
        this.table = table;
    }

    /**
     * Method for the total number of cells that a struct of this type occupies.
     */
    public int structSizeCells(String structTypeName) {
        return sizeCache.computeIfAbsent(structTypeName, this::computeSize);
    }

    /**
     * Method for the Cell-offset of within the struct
     */
    public int fieldOffsetCells(String structTypeName, String fieldName) {
        String key = structTypeName + "#" + fieldName;
        return offsetCellCache.computeIfAbsent(key, k -> computeOffset(structTypeName, fieldName));
    }

    /**
     * Method for byte offset of a field.
     */
    public int fieldOffsetBytes(String structTypeName, String fieldName) {
        int cells = fieldOffsetCells(structTypeName, fieldName);
        return cells < 0 ? -1 : cells * 4;
    }

    /**
     * Method to calculate the number of cells that a single field occupies
     */
    public int fieldSizeCells(String structTypeName, String fieldName) {
        List<Symbol> members = members(structTypeName);
        if (members == null) return 1;
        for (Symbol m : members) {
            if (m.getName().equals(fieldName)) {
                return memberCells(m);
            }
        }
        return 1;
    }

    /**
     * Method to resolve the member list for a struct type.
     */
    public List<Symbol> members(String structTypeName) {
        if (memberCache == null) buildMemberCache();
        return memberCache.get(structTypeName);
    }

    /**
     * Method to build the member cache
     *
     */
    private void buildMemberCache() {
        memberCache = new HashMap<>();
        for (Symbol s : table.getAllSymbols()) {
            if (s.getKind() == SymbolKind.STRUCT && s.getMembers() != null) {
                memberCache.putIfAbsent(s.getName(), s.getMembers());
            }
        }
    }

    /**
     * Method to compute the size
     *
     */
    private int computeSize(String structTypeName) {
        List<Symbol> members = members(structTypeName);
        if (members == null) return 1;
        int total = 0;
        for (Symbol m : members) total += memberCells(m);
        return total;
    }

    /**
     * Method to compute the offsets
     *
     */
    private int computeOffset(String structTypeName, String fieldName) {
        List<Symbol> members = members(structTypeName);
        if (members == null) return -1;
        int offset = 0;
        for (Symbol m : members) {
            if (m.getName().equals(fieldName)) return offset;
            offset += memberCells(m);
        }
        return -1;
    }

    /**
     * Methot do dterminate the number of cells a member occupies.
     */
    private static int memberCells(Symbol m) {
        if (!m.isArray()) return 1;
        List<Integer> sizes = m.getDimensionSizes();
        if (sizes == null || sizes.isEmpty()) return 1;
        int total = 1;
        for (int s : sizes) total *= (s > 0 ? s : 1);
        return total;
    }
}
