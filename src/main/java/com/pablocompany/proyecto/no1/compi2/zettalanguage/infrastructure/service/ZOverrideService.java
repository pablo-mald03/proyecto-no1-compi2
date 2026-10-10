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
    private final ZSymbolLookupService lookup;

    public ZOverrideService(ZSemanticErrorReporter reporter,
                            ZSymbolLookupService lookup) {
        this.reporter = reporter;
        this.lookup = lookup;
    }

    private Symbol lookupType(String name) {
        return lookup.findType(name);
    }

    /**
     * Validates the @Override constraint.
     */
    public void validate(MethodDeclarationNodeZ node,
                         Symbol parentClass,
                         String declaredParentName,
                         Symbol thisClass) {

        if (parentClass == null) {
            if (node.isOverride()) {
                if (declaredParentName != null) {
                    return;
                }
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
                return;
            }

            validateReturnType(node, parentMethod, parentClass);
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

    /**
     * Validates that the child's return type is compatible with the parent's.
     */
    private void validateReturnType(MethodDeclarationNodeZ node,
                                    Symbol parentMethod,
                                    Symbol parentClass) {

        String childReturn = resolveReturnTypeName(node);
        String parentReturn = parentMethod.getReturnType();
        int childDims = node.getReturnDimensions();
        int parentDims = parentMethod.getDimensions();

        if (childDims != parentDims) {
            reporter.reportTypeError(node.getName(),
                    "El tipo de retorno del metodo '" + node.getName()
                            + "' no coincide con el de la superclase '" + parentClass.getName()
                            + "': se esperaba " + formatType(parentReturn, parentDims)
                            + " pero es " + formatType(childReturn, childDims),
                    node);
            return;
        }

        if (!isReturnCovariant(childReturn, parentReturn)) {
            reporter.reportTypeError(node.getName(),
                    "El tipo de retorno del metodo '" + node.getName()
                            + "' no coincide con el de la superclase '" + parentClass.getName()
                            + "': se esperaba " + formatType(parentReturn, parentDims)
                            + " pero es " + formatType(childReturn, childDims),
                    node);
        }
    }

    /**
     * Returns the child's declared return type as a string, or "void" if absent.
     */
    private String resolveReturnTypeName(MethodDeclarationNodeZ node) {
        if (node.getType() == null) return "void";
        if (node.getType().getCustomTypeName() != null) {
            return node.getType().getCustomTypeName();
        }
        if (node.getType().getDataType() != null) {
            return node.getType().getDataType().getValue();
        }
        return "void";
    }

    /**
     * Covariance checker method. rule: `child` is assignable to `parent` helper.
     */
    private boolean isReturnCovariant(String child, String parent) {
        if (child == null || parent == null) return false;
        if (child.equals(parent)) return true;

        if (isPrimitive(child) || isPrimitive(parent)) return false;

        return isSubclassOf(child, parent);
    }

    private boolean isPrimitive(String typeName) {
        return switch (typeName) {
            case "int", "double", "char", "boolean", "void", "String" -> true;
            default -> false;
        };
    }

    private boolean isSubclassOf(String childName, String parentName) {
        String current = childName;
        java.util.Set<String> seen = new java.util.HashSet<>();
        while (current != null && !seen.contains(current)) {
            seen.add(current);
            if (current.equals(parentName)) return true;
            Symbol s = lookupType(current);
            if (s == null) return false;
            current = s.getParentName();
        }
        return false;
    }

    private String formatType(String type, int dims) {
        if (dims <= 0) return type;
        return type + "[]".repeat(dims);
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