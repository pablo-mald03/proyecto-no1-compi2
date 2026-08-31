package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import lombok.Getter;
import lombok.Setter;

/**
 * Principal class to represents a file node with the necessary attributes path
 * @author pablo03
 */
@Getter
@Setter
public class FileNode {

    private String name;
    private boolean isDirectory;
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