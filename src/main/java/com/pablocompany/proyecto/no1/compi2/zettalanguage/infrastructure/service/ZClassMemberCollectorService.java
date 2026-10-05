package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.symbols.entity.Symbol;

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
     * Returns the collected members and stops the collection.
     */
    public List<Symbol> end() {
        List<Symbol> result = new ArrayList<>(members);
        members.clear();
        return result;
    }
}