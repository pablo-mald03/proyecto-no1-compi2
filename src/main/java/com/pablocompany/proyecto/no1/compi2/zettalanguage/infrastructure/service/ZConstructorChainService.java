package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.checker.Type;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.domain.semantic.ZAstNode;

import java.util.List;

/**
 * Principal constructor chain service class
 *
 */
public class ZConstructorChainService {

    private final ZSymbolLookupService lookup;
    private final ZAccessControlService access;
    private final ZCallResolutionService calls;
    private final ZSemanticErrorReporter reporter;

    public ZConstructorChainService(ZSymbolLookupService lookup, ZAccessControlService access, ZCallResolutionService calls, ZSemanticErrorReporter reporter) {
        this.lookup = lookup;
        this.access = access;
        this.calls = calls;
        this.reporter = reporter;
    }

    /**
     * Method to resolve super Returns the chosen constructor, or null when it is the implicit
     */
    public Symbol resolveExplicitSuperCall(Symbol currentClass, Symbol parent, List<Type> argTypes, ZAstNode node) {
        List<Symbol> ctors = lookup.findConstructors(parent);

        if (ctors.isEmpty()) {
            if (!argTypes.isEmpty()) {
                reporter.reportTypeError("super", "La superclase '" + parent.getName() + "' no declara constructores: solo tiene el " + "constructor por defecto, que no recibe argumentos (se enviaron " + argTypes.size() + ")", node);
            }
            return null;
        }

        Symbol chosen = calls.resolveOverload(ctors, argTypes, parent.getName(), node);
        if (chosen == null) return null;

        if (!access.isAccessible(chosen, currentClass)) {
            reporter.reportTypeError("super", "El constructor " + signature(chosen) + " de la superclase '" + parent.getName() + "' es " + ZAccessControlService.label(chosen.getAccessModifier()) + " y no es accesible desde '" + (currentClass != null ? currentClass.getName() : "?") + "'", node);
            return null;
        }
        return chosen;
    }

    /**
     * Method to validates the implicit super() of a constructor.
     */
    public void validateImplicitSuper(Symbol currentClass, Symbol parent, ZAstNode node, String what) {
        List<Symbol> ctors = lookup.findConstructors(parent);
        if (ctors.isEmpty()) return;

        Symbol noArg = null;
        for (Symbol c : ctors) {
            if (c.getParameterTypes().isEmpty()) {
                noArg = c;
                break;
            }
        }

        String cur = currentClass != null ? currentClass.getName() : "?";
        String origin = "clase".equals(what) ? "La clase '" + cur + "' no declara constructor, asi que usa el constructor por defecto, " + "que invoca super() de forma implicita" : "El constructor de '" + cur + "' no inicia con super(...), asi que se invoca super() de forma implicita";

        if (noArg == null) {
            reporter.reportTypeError(parent.getName(), origin + ", pero la superclase '" + parent.getName() + "' no tiene un constructor sin argumentos. Agrega una llamada explicita super(...)", node);
            return;
        }

        if (!access.isAccessible(noArg, currentClass)) {
            reporter.reportTypeError(parent.getName(), origin + ", pero el constructor sin argumentos de '" + parent.getName() + "' es " + ZAccessControlService.label(noArg.getAccessModifier()) + " y no es accesible", node);
        }
    }

    /**
     * Method to write the method signature
     *
     */
    private String signature(Symbol ctor) {
        return ctor.getName() + "(" + String.join(", ", ctor.getParameterTypes()) + ")";
    }
}
