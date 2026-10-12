package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.CompilationContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ConfirmationNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.CodeEditorPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace.WorkspaceCompilationService;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace.WorkspaceEditorService;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace.WorkspaceFileService;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Main workspace panel container coordinating file tree, editor tabs and domain services.
 * @author pablo03
 */
@Getter
public class WorkspacePanel extends JPanel {

    private final WorkspaceNotifier notifier;
    private final ConfirmationNotifier confirmationNotifier;
    private final FileTreePanel fileTreePanel;
    private final JTabbedPane tabbedPane;
    private final JSplitPane splitPane;
    private String projectName;

    //Services
    private final WorkspaceCompilationService compilationService;
    private final WorkspaceEditorService editorService;
    private final WorkspaceFileService fileService;

    /**
     * Constructor with custom project name
     */
    public WorkspacePanel(WorkspaceNotifier notifier, ConfirmationNotifier confirmationNotifier, String projectName) {
        this.notifier = notifier;
        this.confirmationNotifier = confirmationNotifier;
        this.projectName = projectName;

        setLayout(new BorderLayout());
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());

        fileTreePanel = new FileTreePanel(notifier, this, projectName);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
        tabbedPane.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        tabbedPane.setUI(new CustomTabbedPaneUI());
        tabbedPane.putClientProperty("JTabbedPane.tabType", "rounded");

        this.compilationService = new WorkspaceCompilationService(notifier, fileTreePanel);
        this.editorService = new WorkspaceEditorService(tabbedPane, fileTreePanel, notifier, compilationService);
        this.compilationService.setEditorService(editorService);
        this.fileService = new WorkspaceFileService(this, fileTreePanel, editorService, notifier, confirmationNotifier);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, fileTreePanel, tabbedPane);
        splitPane.setDividerLocation(290);
        splitPane.setDividerSize(4);
        splitPane.setBorder(BorderFactory.createEmptyBorder());
        splitPane.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        add(splitPane, BorderLayout.CENTER);
    }

    // ==========================================
    // DELEGATION: FILE TREE OPERATIONS
    // ==========================================

    public void createNewFileWithExtension(String extension) {
        fileService.createNewFileWithExtension(extension);
    }

    public void createNewFolder() {
        fileService.createNewFolder();
    }

    public void renameSelectedNode() {
        fileService.renameSelectedNode();
    }

    public void deleteSelectedNode() {
        fileService.deleteSelectedNode();
    }

    // ==========================================
    // DELEGATION: TAB AND EDITOR OPERATIONS
    // ==========================================

    public void openFileInTab(FileNode fileNode) {
        editorService.openFileInTab(fileNode);
    }

    public void closeTab(String filePath) {
        editorService.closeTab(filePath);
    }

    public void saveCurrentFile() {
        editorService.saveCurrentFile();
    }

    public void saveAllFiles() {
        editorService.saveAllFiles();
    }

    public CodeEditorPanel getCurrentEditor() {
        return editorService.getCurrentEditor();
    }

    public Map<String, CodeEditorPanel> getOpenEditors() {
        return editorService.getOpenEditors();
    }

    public Map<String, String> getAllFileContents() {
        return editorService.getAllFileContents();
    }

    public JPanel getWelcomePanel() {
        return editorService.getWelcomePanel();
    }

    // ==========================================
    // DELEGATION: COMPILATION & CONTEXT
    // ==========================================

    public void setSelectedAsMainClass() {
        compilationService.setSelectedAsMainClass();
    }

    public FileNode getMainClass() {
        return compilationService.getMainClass();
    }

    public boolean hasMainClass() {
        return compilationService.hasMainClass();
    }

    public void clearMainClass() {
        compilationService.clearMainClass();
    }

    public EditorContext getContextForFile(String filePath) {
        return compilationService.getContextForFile(filePath);
    }

    public void updateContextForFile(String filePath, String content) {
        compilationService.updateContextForFile(filePath, content);
    }

    public List<CompilerError> getAllCompilationErrors() {
        return compilationService.getAllCompilationErrors();
    }

    public void clearAllCompilationData() {
        compilationService.clearAllCompilationData();
    }

    public boolean compileAllFiles() {
        return compilationService.compileAllFiles();
    }

    public String getCompiledOutput(Target target) {
        return compilationService.getCompiledOutput(target);
    }

    public boolean isCompiled() {
        return compilationService.isCompiled();
    }

    public CompilationContext getCompilationContext() {
        return compilationService.getCompilationContext();
    }

    public Map<String, EditorContext> getFileContexts() {
        return compilationService.getFileContexts();
    }

    // ==========================================
    // PROJECT MANAGEMENT
    // ==========================================

    public void updateProjectName(String newName) {
        this.projectName = newName;
        fileTreePanel.updateProjectName(newName);
    }
}