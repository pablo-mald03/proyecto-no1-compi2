package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.values.FunctionCallExpressionNodeY;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal function call resolution service helper class
 *
 */
public class YCallResolutionService {

    private final YSymbolLookupService lookup;
    private final YTypeCompatibilityService compatibility;
    private final YSemanticErrorReporter reporter;

    public YCallResolutionService(YSymbolLookupService lookup,
                                  YTypeCompatibilityService compatibility,
                                  YSemanticErrorReporter reporter) {
        this.lookup = lookup;
        this.compatibility = compatibility;
        this.reporter = reporter;
    }

    /**
     * Method to evaluate the return Type of the chosen overload, or Type.unknown() on failure.
     */
    public Type resolve(FunctionCallExpressionNodeY node, List<Type> argTypes) {
        String name = node.getFunctionName();
        List<Symbol> functions = filterFunctions(lookup.resolveByName(name));

        if (functions.isEmpty()) {
            return Type.unknown();
        }

        List<Symbol> arityMatches = filterByArity(functions, argTypes.size());
        if (arityMatches.isEmpty()) {
            reporter.reportTypeError(name,
                    "No existe la funcion '" + name + "' con " + argTypes.size()
                            + " argumento(s)", node);
            return Type.unknown();
        }

        List<Symbol> compatible = new ArrayList<>();
        for (Symbol f : arityMatches) {
            if (compatibility.isCallCompatible(f, argTypes)) {
                compatible.add(f);
            }
        }

        if (compatible.size() == 1) {
            return compatibility.resolveSymbolReturnType(compatible.get(0));
        }
        if (compatible.size() > 1) {
            reporter.reportTypeError(name,
                    "Llamada ambigua a '" + name + "': hay " + compatible.size()
                            + " sobrecargas compatibles", node);
            return Type.unknown();
        }
        reporter.reportTypeError(name,
                "No existe una sobrecarga de '" + name + "' compatible con los argumentos dados",
                node);
        return Type.unknown();
    }

    /**
     * Filter functions helper method
     *
     */
    private List<Symbol> filterFunctions(List<Symbol> candidates) {
        List<Symbol> result = new ArrayList<>();
        for (Symbol s : candidates) {
            if (s.getKind() == SymbolKind.FUNCTION) result.add(s);
        }
        return result;
    }

    /**
     * Filter method helper
     *
     */
    private List<Symbol> filterByArity(List<Symbol> functions, int arity) {
        List<Symbol> result = new ArrayList<>();
        for (Symbol f : functions) {
            if (f.getParameterTypes().size() == arity) result.add(f);
        }
        return result;
    }
}