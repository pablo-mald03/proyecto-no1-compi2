package com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.childs.expressions.imports;

import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.visitor.PigLatinAstVisitor;
import lombok.Getter;

@Getter
public class ImportNodePigLatin extends PigLatinAstNode {

    //The raw path as written in the source (ej. "carpeta.Objeto1.z")
    private final String importPath;

    //The type of imported file, derived from the extension
    private final ImportType importType;

    public ImportNodePigLatin(int line, int column, String importPath, ImportType importType) {
        super(line, column);
        this.importPath = importPath;
        this.importType = importType;
    }

    @Override
    public <T> T accept(PigLatinAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}