package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import com.pablocompany.proyecto.no1.compi2.app.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.errors.CompilerError;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    //Context per node
    private EditorContext editorContext;

    public FileNode(String name, boolean isDirectory) {
        this.name = name;
        this.isDirectory = isDirectory;
        this.content = "";
        this.isModified = false;
        this.editorContext = new EditorContext();
    }

    public boolean isFile() {
        return !isDirectory;
    }

    public String getExtension() {
        if (isDirectory) {
            return "";
        }
        int lastDot = name.lastIndexOf('.');
        return lastDot > 0 ? name.substring(lastDot) : "";
    }

    public String getNameWithoutExtension() {
        if (isDirectory) {
            return name;
        }
        int lastDot = name.lastIndexOf('.');
        return lastDot > 0 ? name.substring(0, lastDot) : name;
    }

    // ==========================================
    // Context management
    // ==========================================

    public void updateContextFromContent() {
        if (!isDirectory && content != null) {
            editorContext.setSourceCode(content);
        }
    }

    public void clearCompilationData() {
        this.editorContext.clearAll();
        this.editorContext.clearParsingErrors();
    }


    public void addAllCompilationErrors(List<CompilerError> errors) {
        this.editorContext.getAllCompilerErrors();
    }

    @Override
    public String toString() {
        return name;
    }
}