package com.pablocompany.proyecto.no1.compi2.codegen.domain.generatePort;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.ValueType;

public interface Value {
    ValueType type();


    /**
     * Constante de cadena del pool.
     */
    record Text(String poolId) implements Value {
        @Override
        public ValueType type() {
            return ValueType.STRING;
        }
    }

    /**
     * Celda de la pila (variable o temporal).
     */
    record Cell(ValueType type, Address address) implements Value {
    }
}
