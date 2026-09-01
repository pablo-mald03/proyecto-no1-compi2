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
    private String content;
    private boolean isModified;

    public FileNode(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.content = "";
        this.isModified = false;
    }

    /**
     * Check if this node represents a file (not a directory)
     */
    public boolean isFile() {
        return !isDirectory;
    }

    /**
     * Get the file extension (if any)
     */
    public String getExtension() {
        if (isDirectory) {
            return "";
        }
        int lastDot = name.lastIndexOf('.');
        return lastDot > 0 ? name.substring(lastDot) : "";
    }

    /**
     * Get the file name without extension
     */
    public String getNameWithoutExtension() {
        if (isDirectory) {
            return name;
        }
        int lastDot = name.lastIndexOf('.');
        return lastDot > 0 ? name.substring(0, lastDot) : name;
    }

    @Override
    public String toString() {
        return name;
    }
}