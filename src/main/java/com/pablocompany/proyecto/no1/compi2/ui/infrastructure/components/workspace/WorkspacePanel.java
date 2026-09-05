package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.SyntaxHighlightListener;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ConfirmationNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.analyzers.SyntaxHighlightListenerFactory;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.dialogs.CustomInputDialog;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.CodeEditorPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums.ModalType;
import lombok.Getter;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main workspace panel containing file tree and tabbed editor
 *
 * @author pablo03
 */
@Getter
public class WorkspacePanel extends JPanel {

    private final WorkspaceNotifier notifier;
    private final ConfirmationNotifier confirmationNotifier;
    private final FileTreePanel fileTreePanel;
    private final JTabbedPane tabbedPane;
    private final Map<String, CodeEditorPanel> openEditors;
    private final JSplitPane splitPane;
    private final JPanel welcomePanel;
    private String projectName;


    //Compiled code
    private String compiledOutput;
    private boolean isCompiled;

    //Principal reference for the file Contexts
    private final Map<String, EditorContext> fileContexts;

    /**
     * Constructor with custom project name
     */
    public WorkspacePanel(WorkspaceNotifier notifier, ConfirmationNotifier confirmationNotifier, String projectName) {
        this.notifier = notifier;
        this.confirmationNotifier = confirmationNotifier;
        this.projectName = projectName;
        this.openEditors = new HashMap<>();
        this.fileContexts = new HashMap<>();

        this.compiledOutput = "";
        this.isCompiled = false;

        setLayout(new BorderLayout());
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());

        fileTreePanel = new FileTreePanel(notifier, this, projectName);
        welcomePanel = createWelcomePanel();

        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
        tabbedPane.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        tabbedPane.setUI(new CustomTabbedPaneUI());
        tabbedPane.putClientProperty("JTabbedPane.tabType", "rounded");

        tabbedPane.addTab("Welcome", welcomePanel);
        tabbedPane.setEnabledAt(0, false);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, fileTreePanel, tabbedPane);
        splitPane.setDividerLocation(250);
        splitPane.setDividerSize(4);
        splitPane.setBorder(BorderFactory.createEmptyBorder());
        splitPane.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        add(splitPane, BorderLayout.CENTER);
    }


    /**
     * Get or create EditorContext for a file
     */
    public EditorContext getContextForFile(String filePath) {
        return fileContexts.computeIfAbsent(filePath, k -> {
            EditorContext context = new EditorContext();

            DefaultMutableTreeNode node = fileTreePanel.getFileNodes().get(filePath);
            if (node != null && node.getUserObject() instanceof FileNode fileNode) {
                if (fileNode.getContent() != null) {
                    context.setSourceCode(fileNode.getContent());
                }
            }
            return context;
        });
    }

    /**
     * Update context for a file with new content
     */
    public void updateContextForFile(String filePath, String content) {
        EditorContext context = getContextForFile(filePath);
        context.setSourceCode(content);

        DefaultMutableTreeNode node = fileTreePanel.getFileNodes().get(filePath);
        if (node != null && node.getUserObject() instanceof FileNode fileNode) {
            fileNode.setContent(content);
            fileNode.updateContextFromContent();
        }
    }

    /**
     * Get all compilation errors from all files
     */
    public List<CompilerError> getAllCompilationErrors() {
        List<CompilerError> allErrors = new ArrayList<>();
        for (Map.Entry<String, EditorContext> entry : fileContexts.entrySet()) {
            String filePath = entry.getKey();
            EditorContext context = entry.getValue();

            List<CompilerError> fileErrors = context.getAllCompilerErrors();
            if (fileErrors != null) {
                for (CompilerError error : fileErrors) {
                    error.setFilePath(filePath);
                    error.setFileName(new File(filePath).getName());
                }
                allErrors.addAll(fileErrors);
            }
        }
        return allErrors;
    }

    /**
     * Clear all compilation data from all files
     */
    public void clearAllCompilationData() {
        for (Map.Entry<String, EditorContext> entry : fileContexts.entrySet()) {
            entry.getValue().clearParsingErrors();
        }

        for (DefaultMutableTreeNode node : fileTreePanel.getFileNodes().values()) {
            if (node.getUserObject() instanceof FileNode fileNode) {
                fileNode.clearCompilationData();
            }
        }
    }

    // ==========================================
    // COMPILATION ORCHESTRATION
    // ==========================================

    /**
     * Compile all files in the project (MOST IMPORTANT METHOD)
     */
    public boolean compileAllFiles() {
        this.clearAllCompilationData();
        compiledOutput = "";
        isCompiled = false;

        // Get all file nodes
        List<FileNode> allFiles = new ArrayList<>();
        collectAllFiles(fileTreePanel.getRootNode(), allFiles);

        List<FileNode> pigLatinFiles = new ArrayList<>();
        List<FileNode> zettaradianFiles = new ArrayList<>();
        List<FileNode> yFiles = new ArrayList<>();

        for (FileNode file : allFiles) {
            if (file.isDirectory()) continue;
            String ext = file.getExtension();
            switch (ext) {
                case ".pig":
                    pigLatinFiles.add(file);
                    break;
                case ".z":
                    zettaradianFiles.add(file);
                    break;
                case ".y":
                    yFiles.add(file);
                    break;
            }
        }

        // Phase 1: Parse all .y files (configurations)
        for (FileNode file : yFiles) {
            parseFile(file);
        }

        // Phase 2: Parse all Zettaradian files (.z)
        for (FileNode file : zettaradianFiles) {
            parseFile(file);
        }

        // Phase 3: Parse all PigLatin files (.pig)
        String finalCompiledCode = "";
        for (FileNode file : pigLatinFiles) {
            parseFile(file);

            String compiled = file.getEditorContext().getCompiledCode();
            if (compiled != null && !compiled.isEmpty()) {
                finalCompiledCode = compiled;
                break;
            }
        }

        // Collect all error
        List<CompilerError> allErrors = getAllCompilationErrors();

        notifier.notifyErrorsUpdated(allErrors);

        if (!allErrors.isEmpty()) {
            notifier.logError("Compilacion completada con " + allErrors.size() + " errores");
            return false;
        }

        finalCompiledCode =
                "#include <stdio.h>\n\n" +
                        "int main() {\n" +
                        "    int numero;\n" +
                        "    printf(\"Ingrese un numero: \");\n" +
                        "    scanf(\"%d\", &numero);\n" +
                        "    printf(\"El numero ingresado fue: %d\\n\", numero);\n" +
                        "    return 0;\n" +
                        "}";


        if (!finalCompiledCode.isEmpty()) {
            this.compiledOutput = finalCompiledCode;
            this.isCompiled = true;

            generateCompiledFile(finalCompiledCode);
        } else {
            notifier.logError("No se genero codigo compilado");

            return false;
        }

        notifier.logSuccess("Compilacion exitosa");
        return true;
    }

    /**
     * Parse a single file TODO
     */
    private void parseFile(FileNode fileNode) {
        if (fileNode.isDirectory()) return;

        String filePath = fileNode.getFilePath();
        String extension = fileNode.getExtension();
        String content = fileNode.getContent();
        String fileName = fileNode.getName();

        if (content == null || content.isEmpty()) {
            return;
        }

        EditorContext context = getContextForFile(filePath);
        context.setSourceCode(content);

        SyntaxHighlightListener listener = SyntaxHighlightListenerFactory.createListener(extension, filePath, fileName);
        if (listener != null) {
            listener.highlight(context);
            fileNode.getEditorContext().setParsed(true);

            String compiledCode = context.getCompiledCode();
            if (compiledCode != null && !compiledCode.isEmpty()) {
                fileNode.getEditorContext().setCompiledCode(compiledCode);
                fileNode.getEditorContext().setParsed(true);
            }

            List<CompilerError> errors = context.getAllCompilerErrors();
            if (errors != null && !errors.isEmpty()) {
                for (CompilerError error : errors) {
                    error.setFilePath(filePath);
                    error.setFileName(fileNode.getName());
                }
                fileNode.addAllCompilationErrors(errors);
            }
        }
    }

    /**
     * Collect all file nodes recursively
     */
    private void collectAllFiles(DefaultMutableTreeNode node, List<FileNode> files) {
        Object userObj = node.getUserObject();
        if (userObj instanceof FileNode fileNode) {
            if (!fileNode.isDirectory()) {
                files.add(fileNode);
            }
        }

        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            collectAllFiles(child, files);
        }
    }

    /**
     * Generate the final .c compiled file in the compiled folder
     */
    private void generateCompiledFile(String compiledCode) {
        try {
            String compiledPath = "compiled/main.c";

            DefaultMutableTreeNode compiledFolderNode = fileTreePanel.findNodeByPath("compiled");
            if (compiledFolderNode == null) {
                fileTreePanel.createNewFile("compiled", true);
            }

            DefaultMutableTreeNode compiledFileNode = fileTreePanel.getFileNodes().get(compiledPath);
            if (compiledFileNode != null && compiledFileNode.getUserObject() instanceof FileNode existingFile) {
                existingFile.setContent(compiledCode);
                existingFile.getEditorContext().setCompiledCode(compiledCode);
                existingFile.getEditorContext().setCompiled(true);
                existingFile.setModified(false);

                updateContextForFile(compiledPath, compiledCode);

                notifier.notifySaveFile(compiledPath, compiledCode);

                if (openEditors.containsKey(compiledPath)) {
                    CodeEditorPanel editor = openEditors.get(compiledPath);
                    if (editor != null) {
                        editor.setCode(compiledCode);
                        editor.setEditable(false);
                    }
                }
            } else {
                FileNode newCompiledFile = new FileNode("main.c", false);
                newCompiledFile.setFilePath(compiledPath);
                newCompiledFile.setContent(compiledCode);
                newCompiledFile.getEditorContext().setCompiledCode(compiledCode);
                newCompiledFile.getEditorContext().setCompiled(true);
                newCompiledFile.setModified(false);

                fileTreePanel.createNewFile("main.c", false, "compiled");

                DefaultMutableTreeNode newNode = fileTreePanel.getFileNodes().get(compiledPath);
                if (newNode != null && newNode.getUserObject() instanceof FileNode node) {
                    node.setContent(compiledCode);
                    node.getEditorContext().setCompiledCode(compiledCode);
                    node.getEditorContext().setCompiled(true);
                    node.setModified(false);

                    updateContextForFile(compiledPath, compiledCode);
                    notifier.notifySaveFile(compiledPath, compiledCode);
                }
            }

            fileTreePanel.reloadTree();
            notifier.logInfo("Codigo compilado generado en: " + compiledPath);

        } catch (Exception e) {
            notifier.logError("Error al generar el archivo compilado: " + e.getMessage());
        }
    }


    /**
     * Update the project name
     */
    public void updateProjectName(String newName) {
        this.projectName = newName;
        fileTreePanel.updateProjectName(newName);
    }

    /**
     * Create the welcome panel with a nice message
     */
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title
        JLabel titleLabel = new JLabel("Bienvenido a 3xtrat3rr3str3D Compiler");
        titleLabel.setFont(new Font("Liberation Mono", Font.BOLD, 24));
        titleLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        panel.add(titleLabel, gbc);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Abre un archivo desde el explorador para comenzar a editar");
        subtitleLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(180, 185, 195));
        panel.add(subtitleLabel, gbc);

        // Tips panel
        JPanel tipsPanel = new JPanel(new GridBagLayout());
        tipsPanel.setOpaque(false);

        String[] tips = {
                "Haz doble clic en un archivo para abrirlo",
                "Usa F2 para renombrar archivos y carpetas",
                "Click derecho para crear nuevos archivos o carpetas",
                "Arrastra el divisor para ajustar el tamaño del panel"
        };

        GridBagConstraints tipsGbc = new GridBagConstraints();
        tipsGbc.gridwidth = GridBagConstraints.REMAINDER;
        tipsGbc.anchor = GridBagConstraints.WEST;
        tipsGbc.insets = new Insets(4, 0, 4, 0);

        for (String tip : tips) {
            JLabel tipLabel = new JLabel("• " + tip);
            tipLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
            tipLabel.setForeground(new Color(160, 165, 175));
            tipsPanel.add(tipLabel, tipsGbc);
        }

        gbc.insets = new Insets(20, 10, 10, 10);
        panel.add(tipsPanel, gbc);

        return panel;
    }

    /**
     * Remove welcome tab if it exists
     */
    private void removeWelcomeTabIfExists() {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i).equals("Welcome")) {
                tabbedPane.removeTabAt(i);
                break;
            }
        }
    }

    /**
     * Check if welcome tab exists
     */
    private boolean welcomeTabExists() {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i).equals("Welcome")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add welcome tab if no tabs are open
     */
    private void addWelcomeTabIfNeeded() {
        if (openEditors.isEmpty() && !welcomeTabExists()) {
            tabbedPane.addTab("Welcome", welcomePanel);
            tabbedPane.setEnabledAt(tabbedPane.indexOfComponent(welcomePanel), false);
            tabbedPane.setSelectedComponent(welcomePanel);
        }
    }

    /**
     * Create a new file with the specified extension
     */
    public void createNewFileWithExtension(String extension) {
        String parentPath = fileTreePanel.getSelectedParentPath();
        DefaultMutableTreeNode parentNode = fileTreePanel.getSelectedParentNode();

        String baseName = CustomInputDialog.showInputDialog(
                this,
                "Crear Nuevo Archivo",
                "Ingresa el nombre del archivo (sin extension):"
        );

        if (baseName == null || baseName.trim().isEmpty()) {
            return;
        }

        baseName = baseName.trim();

        // Check if user tried to add extension manually
        if (baseName.contains(".")) {
            notifier.alertToast("Porfavor no escribas la extension. Esta se coloca automatica.", true);
            return;
        }

        String fullName = baseName + extension;
        String finalPath = parentPath.isEmpty() ? fullName : parentPath + "/" + fullName;

        // Check if file exists and generate unique name
        int counter = 1;
        String originalName = baseName;
        while (fileTreePanel.getFileNodes().containsKey(finalPath)) {
            fullName = originalName + counter + extension;
            finalPath = parentPath.isEmpty() ? fullName : parentPath + "/" + fullName;
            counter++;

            if (counter > 100) break;
        }

        // Create the file
        fileTreePanel.createNewFile(fullName, false, parentPath.isEmpty() ? null : parentPath);

        // Open the new file
        FileNode fileNode = new FileNode(fullName, false);
        fileNode.setFilePath(finalPath);
        openFileInTab(fileNode);
    }

    /**
     * Create a new folder
     */
    public void createNewFolder() {
        String parentPath = fileTreePanel.getSelectedParentPath();
        DefaultMutableTreeNode parentNode = fileTreePanel.getSelectedParentNode();

        String folderName = CustomInputDialog.showInputDialog(
                this,
                "Crear nuevo Folder",
                "Ingresa el nombre del folder:"
        );

        if (folderName == null || folderName.trim().isEmpty()) {
            return;
        }

        folderName = folderName.trim();

        if (folderName.contains(".")) {
            notifier.alertToast("Los nombre de los folders no deberian tener extension.", true);
            return;
        }

        String finalPath = parentPath.isEmpty() ? folderName : parentPath + "/" + folderName;

        int counter = 1;
        String originalName = folderName;
        while (fileTreePanel.getFileNodes().containsKey(finalPath)) {
            folderName = originalName + counter;
            finalPath = parentPath.isEmpty() ? folderName : parentPath + "/" + folderName;
            counter++;

            if (counter > 100) break;
        }

        fileTreePanel.createNewFile(folderName, true, parentPath.isEmpty() ? null : parentPath);
    }

    /**
     * Rename the selected node
     */
    public void renameSelectedNode() {
        DefaultMutableTreeNode node = fileTreePanel.getSelectedNode();
        if (node == null) {
            return;
        }

        Object userObj = node.getUserObject();
        if (!(userObj instanceof FileNode)) {
            return;
        }

        FileNode fileNode = (FileNode) userObj;
        String currentName = fileNode.getName();

        String oldPath = fileNode.getFilePath();

        String newName = CustomInputDialog.showInputDialog(
                this,
                "Renombrar",
                "Ingresa el nuevo nombre:",
                currentName
        );

        if (newName == null || newName.trim().isEmpty()) {
            return;
        }

        newName = newName.trim();

        // For files, check if extension is included
        if (!fileNode.isDirectory()) {
            String currentExtension = "";
            int dotIndex = currentName.lastIndexOf('.');
            if (dotIndex != -1) {
                currentExtension = currentName.substring(dotIndex);
            }

            if (!newName.contains(".") && !currentExtension.isEmpty()) {
                newName = newName + currentExtension;
            } else if (newName.contains(".") && !newName.endsWith(currentExtension)) {
                if (!currentExtension.isEmpty()) {
                    String newExtension = newName.substring(newName.lastIndexOf('.'));
                    if (!newExtension.equals(currentExtension)) {
                        notifier.alertToast("No se puede cambiar la extension del archivo.", true);
                        return;
                    }
                }
            }
        } else {
            if (newName.contains(".")) {
                notifier.alertToast("Los folder no deberian tener extension.", true);
                return;
            }
        }

        String newPath = oldPath.substring(0, oldPath.lastIndexOf('/') + 1) + newName;
        if (oldPath.equals(newPath)) {
            return;
        }

        if (fileTreePanel.getFileNodes().containsKey(newPath)) {
            notifier.alertToast("Ya existe un archivo con este nombre.", true);
            return;
        }

        // Update the file node
        FileNode newFileNode = new FileNode(newName, fileNode.isDirectory());
        newFileNode.setFilePath(newPath);
        node.setUserObject(newFileNode);

        // Update maps
        fileTreePanel.getFileNodes().remove(oldPath);
        fileTreePanel.getFileNodes().put(newPath, node);

        // Update tabs if file is open
        if (openEditors.containsKey(oldPath)) {
            CodeEditorPanel editor = openEditors.remove(oldPath);
            openEditors.put(newPath, editor);

            int index = tabbedPane.indexOfComponent(editor);
            if (index != -1) {
                tabbedPane.setTabComponentAt(index, createTabComponent(newName, newPath));
            }
        }

        fileTreePanel.reloadTree();
    }

    /**
     * Delete the selected node using the ConfirmationNotifier system
     */
    public void deleteSelectedNode() {
        DefaultMutableTreeNode node = fileTreePanel.getSelectedNode();
        if (node == null) {
            return;
        }

        Object userObj = node.getUserObject();
        if (!(userObj instanceof FileNode)) {
            return;
        }

        FileNode fileNode = (FileNode) userObj;

        if (node == fileTreePanel.getRootNode()) {
            notifier.logError("No se puede eliminar el proyecto raiz");
            return;
        }

        String type = fileNode.isDirectory() ? "folder" : "archivo";

        // Use the ConfirmationNotifier system with callback
        confirmationNotifier.confirm(
                ModalType.WARNING,
                "Confirmar eliminacion",
                "Estas seguro que quieres eliminar el " + type + ": " + fileNode.getName() + " ?",
                confirmed -> {
                    if (confirmed) {
                        String filePath = fileNode.getFilePath();

                        if (!fileNode.isDirectory() && openEditors.containsKey(filePath)) {
                            closeTab(filePath);
                        }

                        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
                        if (parent != null) {
                            parent.remove(node);
                            fileTreePanel.getFileNodes().remove(filePath);
                            fileTreePanel.reloadTree();
                        }
                    }
                }
        );
    }

    /**
     * Open a file in a new tab WITH CONTENT AND SYNTAX HIGHLIGHTING
     */
    public void openFileInTab(FileNode fileNode) {
        String filePath = fileNode.getFilePath();
        String fileName = fileNode.getName();

        if (openEditors.containsKey(filePath)) {
            int index = findTabIndexByPath(filePath);
            if (index != -1) {
                tabbedPane.setSelectedIndex(index);
            }
            return;
        }

        removeWelcomeTabIfExists();

        boolean isCompiledFile = filePath.endsWith(".c") && filePath.contains("compiled");

        EditorContext context = getContextForFile(filePath);

        String content = fileNode.getContent() != null ? fileNode.getContent() : "";

        if (context != null) {
            context.setSourceCode(content);
        }

        CodeEditorPanel editor = new CodeEditorPanel(notifier);
        editor.setCode(content);
        editor.setFileExtension(fileNode.getExtension(), filePath, fileName);
        editor.setEditable(!isCompiledFile);

        editor.getEditor().setEditorContext(context);
        editor.getEditor().setSyntaxHighlightListener(
                SyntaxHighlightListenerFactory.createListener(fileNode.getExtension(), filePath, fileName)
        );

        tabbedPane.addTab(fileName, editor);
        openEditors.put(filePath, editor);

        int index = tabbedPane.indexOfComponent(editor);
        tabbedPane.setSelectedIndex(index);
        tabbedPane.setTabComponentAt(index, createTabComponent(fileName, filePath));
    }

    /**
     * Save the current editor content to the file
     */
    public void saveCurrentFile() {
        CodeEditorPanel editor = getCurrentEditor();
        if (editor == null) {
            notifier.alertToast("No hay ningún archivo abierto para guardar", true);
            return;
        }

        String filePath = null;
        for (Map.Entry<String, CodeEditorPanel> entry : openEditors.entrySet()) {
            if (entry.getValue() == editor) {
                filePath = entry.getKey();
                break;
            }
        }

        if (filePath == null) {
            notifier.alertToast("Error: No se pudo identificar el archivo", true);
            return;
        }

        String content = editor.getCode();

        DefaultMutableTreeNode node = fileTreePanel.getFileNodes().get(filePath);
        if (node != null && node.getUserObject() instanceof FileNode fileNode) {
            fileNode.setContent(content);
            fileNode.setModified(false);
            fileNode.updateContextFromContent();

            updateContextForFile(filePath, content);

            notifier.notifySaveFile(filePath, content);
        }
    }


    /**
     * Save all open files
     */
    public void saveAllFiles() {
        int savedCount = 0;
        for (Map.Entry<String, CodeEditorPanel> entry : openEditors.entrySet()) {
            String filePath = entry.getKey();
            CodeEditorPanel editor = entry.getValue();
            String content = editor.getCode();

            DefaultMutableTreeNode node = fileTreePanel.getFileNodes().get(filePath);
            if (node != null && node.getUserObject() instanceof FileNode fileNode) {
                String oldContent = fileNode.getContent();

                if (!content.equals(oldContent)) {
                    fileNode.setContent(content);
                    fileNode.setModified(false);
                    fileNode.updateContextFromContent();
                    updateContextForFile(filePath, content);
                    notifier.notifySaveFile(filePath, content);
                    savedCount++;
                }
            }
        }
    }

    /**
     * Create a custom tab component with close button (X)
     */
    private Component createTabComponent(String title, String filePath) {
        JPanel tabComponent = new JPanel(new BorderLayout(5, 0));
        tabComponent.setOpaque(false);
        tabComponent.setBackground(Theme.STATUS_BAR_DARK.getColorSet());

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        titleLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());

        JButton closeButton = new JButton("×");
        closeButton.setFont(new Font("Liberation Mono", Font.BOLD, 14));
        closeButton.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        closeButton.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
        closeButton.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
        closeButton.setFocusable(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setOpaque(true);
        closeButton.setPreferredSize(new Dimension(20, 20));

        // Hover effect with better visibility
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(new Color(200, 50, 50));
                closeButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
                closeButton.setForeground(Theme.FOREGROUND_DARK.getColorSet());
            }
        });

        closeButton.addActionListener(e -> closeTab(filePath));

        tabComponent.add(titleLabel, BorderLayout.WEST);
        tabComponent.add(closeButton, BorderLayout.EAST);

        return tabComponent;
    }

    /**
     * Find tab index by file path
     */
    private int findTabIndexByPath(String filePath) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            Component comp = tabbedPane.getComponentAt(i);
            if (comp instanceof CodeEditorPanel) {
                if (openEditors.containsKey(filePath) && openEditors.get(filePath) == comp) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Close a tab by file path
     */
    public void closeTab(String filePath) {
        if (openEditors.containsKey(filePath)) {
            CodeEditorPanel editor = openEditors.get(filePath);
            int index = tabbedPane.indexOfComponent(editor);
            if (index != -1) {
                tabbedPane.remove(index);
                openEditors.remove(filePath);

                // Show welcome panel if no tabs are open
                if (openEditors.isEmpty()) {
                    addWelcomeTabIfNeeded();
                }
            }
        }
    }


    /**
     * Get the current active editor
     */
    public CodeEditorPanel getCurrentEditor() {
        Component comp = tabbedPane.getSelectedComponent();
        if (comp instanceof CodeEditorPanel) {
            return (CodeEditorPanel) comp;
        }
        return null;
    }

    /**
     * Get all file contents for export
     */
    public Map<String, String> getAllFileContents() {
        Map<String, String> contents = new HashMap<>();
        for (Map.Entry<String, CodeEditorPanel> entry : openEditors.entrySet()) {
            String filePath = entry.getKey();
            CodeEditorPanel editor = entry.getValue();
            if (editor != null) {
                contents.put(filePath, editor.getCode());
            }
        }
        return contents;
    }
}