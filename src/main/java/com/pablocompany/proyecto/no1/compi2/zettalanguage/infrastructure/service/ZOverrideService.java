package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.MethodDeclarationNodeZ;

import java.util.ArrayList;
import java.util.List;

/**
 * Overridable methods service checker class
 *
 */
public class ZOverrideService {

    private final ZSemanticErrorReporter reporter;

    public ZOverrideService(ZSemanticErrorReporter reporter) {
        this.reporter = reporter;
    }

    /**
     * Validates the @Override constraint.
     */
    public void validate(MethodDeclarationNodeZ node,
                         Symbol parentClass,
                         Symbol thisClass) {

        if (parentClass == null) {
            if (node.isOverride()) {
                reporter.reportTypeError(node.getName(),
                        "El metodo '" + node.getName()
                                + "' esta marcado con @Override pero la clase '"
                                + (thisClass != null ? thisClass.getName() : "?")
                                + "' no extiende ninguna superclase", node);
            }
            return;
        }

        Symbol parentMethod = findMethodInClass(parentClass, node.getName(), paramTypes(node));

        if (node.isOverride()) {
            if (parentMethod == null) {
                reporter.reportTypeError(node.getName(),
                        "El metodo '" + node.getName()
                                + "' esta marcado con @Override pero la superclase '"
                                + parentClass.getName()
                                + "' no tiene un metodo con esa firma", node);
            }
        } else {
            if (parentMethod != null) {
                reporter.reportTypeError(node.getName(),
                        "El metodo '" + node.getName()
                                + "' sobreescribe un metodo de la superclase '"
                                + parentClass.getName()
                                + "' pero no tiene la anotacion @Override", node);
            }
        }
    }

    // -------- helpers --------

    private Symbol findMethodInClass(Symbol classSymbol, String name, List<String> paramTypes) {
        if (classSymbol == null || classSymbol.getMembers() == null) return null;
        for (Symbol m : classSymbol.getMembers()) {
            if (m.getKind() != SymbolKind.METHOD) continue;
            if (!m.getName().equals(name)) continue;
            if (m.getParameterTypes().equals(paramTypes)) return m;
        }
        return null;
    }

    /**
     * Param types helper method
     *
     */
    private List<String> paramTypes(MethodDeclarationNodeZ node) {
        List<String> result = new ArrayList<>();
        if (node.getParams() != null) {
            for (var p : node.getParams()) {
                if (p == null) continue;
                String t = resolveParamType(p);
                if (p.isArray()) t = t + "[]".repeat(p.getDimensions());
                result.add(t);
            }
        }
        return result;
    }

    /**
     * Helper method to resolve the param type
     *
     */
    private String resolveParamType(ParameterNodeZ p) {
        var t = p.getType();
        if (t == null) return "?";
        if (t.getCustomTypeName() != null) return t.getCustomTypeName();
        if (t.getDataType() != null) return t.getDataType().getValue();
        return "?";
    }
}