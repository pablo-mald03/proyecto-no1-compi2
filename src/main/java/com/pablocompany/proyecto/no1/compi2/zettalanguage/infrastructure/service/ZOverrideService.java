package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.expressions.types.TypeNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.functions.ParameterNodeZ;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.childs.statements.methods.MethodDeclarationNodeZ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
     * Method to validates the @Override constraint.
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
        boolean inheritable = parentMethod != null && !isPrivate(parentMethod);

        if (node.isOverride()) {
            if (parentMethod == null) {
                reporter.reportTypeError(node.getName(),
                        "El metodo '" + node.getName()
                                + "' esta marcado con @Override pero la superclase '"
                                + parentClass.getName()
                                + "' no tiene un metodo con esa firma", node);
                return;
            }
            if (!inheritable) {
                reporter.reportTypeError(node.getName(),
                        "El metodo '" + node.getName()
                                + "' esta marcado con @Override pero el metodo de la superclase '"
                                + parentMethod.getDeclaringClass()
                                + "' es private y no se hereda", node);
                return;
            }

            validateReturnType(node, parentMethod, parentClass);
            validateVisibility(node, parentMethod);
        } else {
            if (inheritable) {
                reporter.reportTypeError(node.getName(),
                        "El metodo '" + node.getName()
                                + "' sobreescribe un metodo de la superclase '"
                                + parentMethod.getDeclaringClass()
                                + "' pero no tiene la anotacion @Override", node);
            }
        }
    }

    /**
     * Method to validate the overriding method cannot be less visible than the overridden one.
     */
    private void validateVisibility(MethodDeclarationNodeZ node, Symbol parentMethod) {
        if (ZAccessControlService.isWeaker(node.getModifier(), parentMethod.getAccessModifier())) {
            reporter.reportTypeError(node.getName(),
                    "No se puede reducir la visibilidad del metodo '" + node.getName()
                            + "': en la superclase '" + parentMethod.getDeclaringClass() + "' es "
                            + ZAccessControlService.label(parentMethod.getAccessModifier())
                            + " y aqui es " + ZAccessControlService.label(node.getModifier()),
                    node);
        }
    }

    /**
     * Method to validates that the child's return type is compatible with the parent's.
     */
    private void validateReturnType(MethodDeclarationNodeZ node,
                                    Symbol parentMethod,
                                    Symbol parentClass) {

        String childReturn = resolveReturnTypeName(node);
        String parentReturn = parentMethod.getReturnType();
        int childDims = node.getReturnDimensions();
        int parentDims = parentMethod.getReturnDimensions();

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
     * Method to declares the using the SAME canonical names the symbol collector stores.
     */
    private String resolveReturnTypeName(MethodDeclarationNodeZ node) {
        String name = canonicalTypeName(node.getType());
        return name != null ? name : "void";
    }

    /**
     * Method to map the same mapping types that types read from the AST
     */
    private String canonicalTypeName(TypeNodeZ typeNode) {
        if (typeNode == null) return null;
        if (typeNode.getCustomTypeName() != null) return typeNode.getCustomTypeName();
        var dt = typeNode.getDataType();
        if (dt == null) return null;
        return switch (dt) {
            case INT -> "int";
            case DOUBLE -> "float";
            case STRING -> "string";
            case CHAR -> "char";
            case BOOLEAN -> "boolean";
            case VOID -> "void";
            case NULL -> "null";
            case CLASS -> null;
        };
    }

    /**
     * Method to evaluate the covariance checker method. rule: `child` is assignable to `parent` helper.
     */
    private boolean isReturnCovariant(String child, String parent) {
        if (child == null || parent == null) return false;
        if (child.equals(parent)) return true;

        if (isPrimitive(child) || isPrimitive(parent)) return false;

        return isSubclassOf(child, parent);
    }

    /**
     * Method to check if the value is primitive
     *
     */
    private boolean isPrimitive(String typeName) {
        return switch (typeName) {
            case "int", "float", "double", "char", "boolean", "void", "string", "String", "null" -> true;
            default -> false;
        };
    }

    /**
     * Method to check the subclass of the principal class
     *
     */
    private boolean isSubclassOf(String childName, String parentName) {
        String current = childName;
        Set<String> seen = new HashSet<>();
        while (current != null && !seen.contains(current)) {
            seen.add(current);
            if (current.equals(parentName)) return true;
            Symbol s = lookupType(current);
            if (s == null) return false;
            current = s.getParentName();
        }
        return false;
    }

    /**
     * Method to format the type
     * */
    private String formatType(String type, int dims) {
        if (dims <= 0) return type;
        return type + "[]".repeat(dims);
    }


    private boolean isPrivate(Symbol m) {
        return m.getAccessModifier() != null && "PRIVATE".equals(m.getAccessModifier().name());
    }

    /**
     * Method to find in class
     *
     */
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
     * Method for the param types helper method
     */
    private List<String> paramTypes(MethodDeclarationNodeZ node) {
        List<String> result = new ArrayList<>();
        if (node.getParams() != null) {
            for (ParameterNodeZ p : node.getParams()) {
                if (p == null) continue;
                String t = canonicalTypeName(p.getType());
                if (t == null) t = "?";
                if (p.isArray()) t = t + "[]".repeat(p.getDimensions());
                result.add(t);
            }
        }
        return result;
    }
}
