package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services;

import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileNode;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileTreePanel;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Service for managing projects (create, open, save, import, export)
 *
 * @author pablo03
 */
public class ProjectService {

    private static final String SOURCE_FOLDER = "src";
    private static final String COMPILED_FOLDER = "compiled";

    // File extensions
    private static final String PIG_EXTENSION = ".pig";
    private static final String Y_EXTENSION = ".y";
    private static final String C_EXTENSION = ".c";
    private static final String Z_EXTENSION = ".z";

    /**
     * Create a new project with default structure
     */
    public void createProject(String projectName, File projectDir) throws IOException {
        // Create project directory (works on Windows, Linux, Mac)
        File projectFolder = new File(projectDir, projectName);
        if (!projectFolder.exists()) {
            if (!projectFolder.mkdirs()) {
                throw new IOException("Failed to create project directory: " + projectFolder.getPath());
            }
        }

        // Create source folder
        File srcFolder = new File(projectFolder, SOURCE_FOLDER);
        if (!srcFolder.exists() && !srcFolder.mkdirs()) {
            throw new IOException("Failed to create src directory: " + srcFolder.getPath());
        }

        // Create default files
        createDefaultFiles(projectFolder, srcFolder, projectName);
    }

    /**
     * Create default files for a new project
     */
    private void createDefaultFiles(File projectFolder, File srcFolder, String projectName) throws IOException {
        // Main.pig in root (Pig Latin file)
        File mainPigFile = new File(projectFolder, "main" + PIG_EXTENSION);
        try (FileWriter writer = new FileWriter(mainPigFile)) {
            writer.write("import src.config.y\n\n");
            writer.write("// Main de Pig Latin del proyecto: " + projectName + "\n");
            writer.write("MAIOR>\n");
            writer.write("    >> \"Hola mundo!\" ;\n\n");
            writer.write(">> \"Tu poder estado de animo es: >> \" calcularEstado(10); ");
            writer.write("\n\n");
            writer.write("FINIS;\n");
        }

        // config.y in src folder
        File configFile = new File(srcFolder, "config" + Y_EXTENSION);
        try (FileWriter writer = new FileWriter(configFile)) {
            writer.write("// Archivo de configuracion principal: " + projectName + "\n\n");
            writer.write("definir calcularEstado(entero miEntero) -> entero :\n");
            writer.write("  miEntero = 10 + 10\n");
            writer.write("  retornar miEntero\n");
        }

        // Persona.z in src folder
        File classFile = new File(srcFolder, "Persona" + Z_EXTENSION);

        try (FileWriter writer = new FileWriter(classFile)) {
            writer.write("// Clase principal\"Persona\" del proyecto: " + projectName + "\n\n");
            writer.write("public class Persona {\n\n");
            writer.write("  String nombre;\n");
            writer.write("  int edad;\n\n");
            writer.write("  public Persona(String nombreParametro, int edadParametro) {\n");
            writer.write("      nombre = nombreParametro;\n");
            writer.write("      edad = edadParametro;\n");
            writer.write("  }\n\n");
            writer.write("  public void saludar() {\n");
            writer.write("      println(\"¡Hola! Me llamo \" + nombre + \" y tengo \" + edad + \" años.\");\n");
            writer.write("  }\n\n");
            writer.write("}");
        }

    }

    /**
     * Load a project from directory into the file tree WITH CONTENT
     */
    public void loadProjectFromDirectory(File projectDir, FileTreePanel fileTreePanel, String projectName) {
        // Clear existing tree
        DefaultMutableTreeNode rootNode = fileTreePanel.getRootNode();
        rootNode.removeAllChildren();
        fileTreePanel.getFileNodes().clear();

        if (rootNode.getUserObject() instanceof FileNode) {
            FileNode rootFileNode = (FileNode) rootNode.getUserObject();
            rootFileNode.setName(projectName);
        }

        loadDirectoryWithContent(projectDir, rootNode, "", fileTreePanel);

        fileTreePanel.reloadTree();
    }

    /**
     * Recursively load a directory into the tree WITH FILE CONTENT
     */
    private void loadDirectoryWithContent(File dir, DefaultMutableTreeNode parentNode, String parentPath,
                                          FileTreePanel fileTreePanel) {
        File[] files = dir.listFiles();
        if (files == null) return;

        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) return -1;
            if (!f1.isDirectory() && f2.isDirectory()) return 1;
            return f1.getName().compareToIgnoreCase(f2.getName());
        });

        for (File file : files) {
            // Skip hidden files (optional)
            if (file.getName().startsWith(".")) continue;

            String fileName = file.getName();
            String filePath = parentPath.isEmpty() ? fileName : parentPath + "/" + fileName;

            if (file.isDirectory()) {
                FileNode folderNode = new FileNode(fileName, true);
                folderNode.setFilePath(filePath);
                DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(folderNode);
                parentNode.add(treeNode);
                fileTreePanel.getFileNodes().put(filePath, treeNode);

                loadDirectoryWithContent(file, treeNode, filePath, fileTreePanel);
            } else {
                // Create file node WITH CONTENT
                FileNode fileNode = new FileNode(fileName, false);
                fileNode.setFilePath(filePath);

                try {
                    String content = readFileContent(file);
                    fileNode.setContent(content);
                    fileNode.setModified(false);
                } catch (IOException e) {
                    fileNode.setContent("");
                    fileNode.setModified(false);
                }

                DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(fileNode);
                parentNode.add(treeNode);
                fileTreePanel.getFileNodes().put(filePath, treeNode);
            }
        }
    }

    /**
     * Read file content from filesystem
     */
    private String readFileContent(File file) throws IOException {
        if (!file.exists()) {
            return "";
        }
        return new String(Files.readAllBytes(file.toPath()));
    }

    /**
     * Get the content of a specific file node
     */
    public String getFileContent(FileNode fileNode, File projectDir) throws IOException {
        if (fileNode.isDirectory()) {
            return "";
        }
        File file = new File(projectDir, fileNode.getFilePath());
        if (!file.exists()) {
            return fileNode.getContent();
        }

        String content = readFileContent(file);
        fileNode.setContent(content);
        return content;
    }

    /**
     * Save file content to the filesystem with path
     */
    public void saveFileContent(String filePath, String content, File projectDir) throws IOException {
        File file = new File(projectDir, filePath);
        file.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        }
    }

    /**
     * Check if a directory is a valid Codex project
     */
    public boolean isValidProject(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            return false;
        }

        File[] pigFiles = dir.listFiles((d, name) -> name.endsWith(PIG_EXTENSION));
        return pigFiles != null && pigFiles.length > 0;
    }
}