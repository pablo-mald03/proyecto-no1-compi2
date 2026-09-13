package com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.childs.expressions.imports;

import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.semantic.YAstNode;
import com.pablocompany.proyecto.no1.compi2.ylanguage.domain.visitor.YAstVisitor;
import lombok.Getter;

@Getter
public class ImportNodeY extends YAstNode {

    //The raw path as written in the source (ej. "carpeta.Objeto1.z")
    private final String importPath;

    //The type of imported file, derived from the extension
    private final ImportType importType;

    public ImportNodeY(int line, int column, String importPath, ImportType importType) {
        super(line, column);
        this.importPath = importPath;
        this.importType = importType;
    }

    @Override
    public <T> T accept(YAstVisitor<T> visitor) {
        return visitor.visit(this);
    }
}