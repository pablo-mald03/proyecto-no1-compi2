package com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Directed graph of file dependencies built from .pig imports.
 * Key = filePath of the .pig, value = list of filePaths it imports.
 */
@Data
public class DependencyGraph {

    private Map<String, List<String>> adjacency;
    private List<String> topologicalOrder;
    private List<CompilerError> errors;

    private Map<String, String> importResolutionMap;

    public DependencyGraph() {
        this.adjacency = new HashMap<>();
        this.topologicalOrder = new ArrayList<>();
        this.errors = new ArrayList<>();
        this.importResolutionMap = new HashMap<>();
    }
    /**
     * Method to add another dependency
     *
     */
    public void addDependency(String fromPath, String toPath) {
        adjacency.computeIfAbsent(fromPath, k -> new ArrayList<>()).add(toPath);
    }

    /**
     * Method to get any dependency
     *
     */
    public List<String> getDependenciesOf(String filePath) {
        return adjacency.getOrDefault(filePath, new ArrayList<>());
    }

    /**
     * Method to get any error
     *
     */
    public void addError(CompilerError error) {
        errors.add(error);
    }


    /**
     * Flag to verify if the list has errors
     *
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}