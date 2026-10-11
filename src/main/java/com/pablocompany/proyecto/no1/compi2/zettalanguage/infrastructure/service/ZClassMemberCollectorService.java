package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;
import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.enums.SymbolKind;

import java.util.ArrayList;
import java.util.List;

/**
 * Member class collector service class
 *
 */
public class ZClassMemberCollectorService {

    private final List<Symbol> members = new ArrayList<>();

    /**
     * Starts a fresh class-member collection. Called at the beginning of a class.
     */
    public void begin() {
        members.clear();
    }

    /**
     * Registers a member (attribute, method, constructor) for the current class.
     */
    public void add(Symbol member) {
        if (member != null) members.add(member);
    }

    /**
     * Ends collection and, if `parentClass` is not null, merges inherited members.
     */
    public List<Symbol> end(Symbol parentClass) {
        List<Symbol> result = new ArrayList<>(members);

        if (parentClass != null && parentClass.getMembers() != null) {
            for (Symbol inherited : parentClass.getMembers()) {
                if (inherited.getKind() == SymbolKind.CONSTRUCTOR) continue;
                boolean overridden = false;
                for (Symbol own : members) {
                    if (own.getKind() == inherited.getKind()
                            && own.getName().equals(inherited.getName())
                            && own.getParameterTypes().equals(inherited.getParameterTypes())) {
                        overridden = true;
                        break;
                    }
                }
                if (!overridden) result.add(inherited);
            }
        }

        members.clear();
        return result;
    }
}