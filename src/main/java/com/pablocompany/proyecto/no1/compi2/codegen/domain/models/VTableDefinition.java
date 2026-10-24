package com.pablocompany.proyecto.no1.compi2.codegen.domain.models;

import lombok.Value;

import java.util.List;

/**
 * Model representing a class virtual table definition in the intermediate representation.
 */
@Value
public class VTableDefinition {

    String name;
    List<String> entries;
}
