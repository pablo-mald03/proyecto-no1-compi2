package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal function call resolution service helper class
 *
 */
public class ZCallResolutionService {

    private final ZTypeCompatibilityService compatibility;
    private final ZSemanticErrorReporter reporter;

    public ZCallResolutionService(ZTypeCompatibilityService compatibility,
                                  ZSemanticErrorReporter reporter) {
        this.compatibility = compatibility;
        this.reporter = reporter;
    }

    /**
     * Method who given a list of candidate symbols (methods or constructors), picks the
     */
    public Symbol resolveOverload(List<Symbol> candidates,
                                  List<Type> argTypes,
                                  String name,
                                  ZAstNode node) {
        List<Symbol> arityMatches = new ArrayList<>();
        for (Symbol s : candidates) {
            if (s.getParameterTypes().size() == argTypes.size()) {
                arityMatches.add(s);
            }
        }

        if (arityMatches.isEmpty()) {
            reporter.reportTypeError(name,
                    "No existe una version de '" + name + "' con " + argTypes.size()
                            + " argumento(s)", node);
            return null;
        }

        List<Symbol> compatible = new ArrayList<>();
        for (Symbol s : arityMatches) {
            if (compatibility.isCallCompatible(s, argTypes)) compatible.add(s);
        }

        if (compatible.size() == 1) return compatible.get(0);
        if (compatible.size() > 1) {
            reporter.reportTypeError(name, "Llamada ambigua a '" + name + "'", null);
            return null;
        }

        reporter.reportTypeError(name,
                "No existe una version de '" + name + "' compatible con los argumentos", node);
        return null;
    }
}