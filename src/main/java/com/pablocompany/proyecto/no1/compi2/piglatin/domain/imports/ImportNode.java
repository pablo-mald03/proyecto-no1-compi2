package com.pablocompany.proyecto.no1.compi2.piglatin.domain.imports;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a single import declaration found in a .pig file.
 * This is a semantic model, not an AST node.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImportNode {

    // as written in source, e.g. "foo.z"
    private String rawPath;

    // real workspace path if it exists, else null
    private String resolvedPath;
    
    // filePath of the .pig that declares it
    private String declaredIn;

    // fileName of the .pig that declares it
    private String declaredInName;
    private int line;
    private int column;

}