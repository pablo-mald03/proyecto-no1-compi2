package com.pablocompany.proyecto.no1.compi2.common.domain.code3D;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Principal class to manage the pool of string literals. Each literal gets a unique id
 */
@Data
public class StringPool {
    private final String prefix;
    private final Map<String, String> literalToId;
    private final List<String> literalsInOrder;
    private int counter = 0;

    public StringPool(String prefix) {
        this.prefix = prefix;
        this.literalToId = new LinkedHashMap<>();
        this.literalsInOrder = new ArrayList<>();
    }

    public StringPool() {
        this("str");
    }

    public String intern(String literal) {
        if (literalToId.containsKey(literal)) return literalToId.get(literal);
        counter++;
        String id = prefix + counter;
        literalToId.put(literal, id);
        literalsInOrder.add(literal);
        return id;
    }

    public String getId(String literal) {
        return literalToId.get(literal);
    }
}