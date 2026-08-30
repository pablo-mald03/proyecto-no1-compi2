package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.workspace;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pablo03
 */
// Principal class to represents a file node with the necessary attribuites path
@Getter
@Setter
public class FileNode {

    private final String name;
    private final boolean isDirectory;
    private String filePath;

    public FileNode(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
}
