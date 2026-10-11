package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodePigLatin;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.structs.declaration.StructBodyNodePigLatin;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal symbol resolver member collector service class
 *
 */
public class SymbolPigMemberCollectorService {

    private final EditorContext context;
    private final TypePigResolutionService types;

    public SymbolPigMemberCollectorService(EditorContext context,
                                           TypePigResolutionService types) {
        this.context = context;
        this.types = types;
    }

    /**
     * Resolve the collection from body
     */
    public List<Symbol> collectFromBody(StructBodyNodePigLatin body) {
        List<Symbol> members = new ArrayList<>();
        if (body == null || body.getAttributes() == null) return members;

        for (StructAttributeNodePigLatin attr : body.getAttributes()) {
            if (attr == null) continue;
            members.add(buildAttribute(attr));
        }
        return members;
    }

    private Symbol buildAttribute(StructAttributeNodePigLatin attr) {
        Symbol m = baseSymbol(attr.getIdentifier(), SymbolKind.ATTRIBUTE, attr);
        m.setType(types.resolveTypeName(attr.getType()));
        m.setArray(attr.isArray());
        return m;
    }

    private Symbol baseSymbol(String name, SymbolKind kind, PigLatinAstNode node) {
        Symbol s = new Symbol();
        s.setName(name);
        s.setKind(kind);
        s.setFilePath(context.getFilePath());
        s.setFileName(context.getFileName());
        s.setLine(node.getLine());
        s.setColumn(node.getColumn());
        return s;
    }
}