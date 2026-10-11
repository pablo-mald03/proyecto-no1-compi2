package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.structs.declaration.StructAttributeNodeY;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.types.TypeNodeY;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal member collector service
 *
 */
public class YMemberCollectorService {

    private final EditorContext context;
    private final YTypeMapperService types;

    public YMemberCollectorService(EditorContext context, YTypeMapperService types) {
        this.context = context;
        this.types = types;
    }

    /**
     * Principal method to collect the attributes
     *
     */
    public List<Symbol> collectAttributes(List<StructAttributeNodeY> attributes) {
        List<Symbol> members = new ArrayList<>();
        if (attributes == null) return members;

        for (StructAttributeNodeY attr : attributes) {
            if (attr == null) continue;
            members.add(buildAttribute(attr));
        }
        return members;
    }

    /**
     * Principal method to build the attributes
     *
     */
    private Symbol buildAttribute(StructAttributeNodeY attr) {
        Symbol m = base(attr.getIdentifier(), SymbolKind.ATTRIBUTE, attr);
        TypeNodeY typeNode = attr.getType();
        m.setType(resolveTypeName(typeNode));

        if (attr.isArray()) {
            int dims = attr.getDimensions() != null ? attr.getDimensions().size() : 1;
            m.setDimensions(dims);
            m.setArray(true);
        }
        return m;
    }

    /**
     * Principal method to resolve the typename
     *
     */
    private String resolveTypeName(TypeNodeY typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) return typeNode.getCustomTypeName();
        if (typeNode.getDataType() != null) return typeNode.getDataType().getValue();
        return null;
    }

    /**
     * Principal method to resolve the base types
     *
     */
    private Symbol base(String name, SymbolKind kind, YAstNode node) {
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