package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.enums.Target;
import com.pablocompany.proyecto.no1.compi2.common.domain.compilation.CompilationContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ConfirmationNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.CodeEditorPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.io.ProjectService;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace.WorkspaceCompilationService;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace.WorkspaceDiskSyncService;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace.WorkspaceEditorService;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace.WorkspaceFileService;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
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

    // Ctrl+Tab switcher and shared zoom level
    private static final int ZOOM_MIN = 50;
    private static final int ZOOM_MAX = 300;
    private static final int ZOOM_STEP = 10;
    private static final int ZOOM_DEFAULT = 100;

    private final TabSwitcher tabSwitcher;
    private int zoomPercent = ZOOM_DEFAULT;

    //Services
    private final WorkspaceCompilationService compilationService;
    private final WorkspaceEditorService editorService;
    private final WorkspaceFileService fileService;
    private final WorkspaceDiskSyncService diskSyncService;

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
        this.fileService = new WorkspaceFileService(this, fileTreePanel, editorService, compilationService, notifier, confirmationNotifier);
        this.diskSyncService = new WorkspaceDiskSyncService(fileTreePanel, editorService, compilationService, notifier);
        this.tabSwitcher = new TabSwitcher(tabbedPane);

        // Editors opened later (or lazily created) pick up the current zoom level
        tabbedPane.addChangeListener(e -> SwingUtilities.invokeLater(this::applyZoomToAllEditors));

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

    public void startDiskSync(File projectDir, ProjectService projectService) {
        diskSyncService.start(projectDir, projectService);
    }

    public void stopDiskSync() {
        diskSyncService.stop();
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


    /**
     * Forward key events here . True = consumed.
     */
    public boolean handleTabSwitchKey(KeyEvent e) {
        return tabSwitcher.handleKeyEvent(e);
    }

    public boolean isTabSwitcherOpen() {
        return tabSwitcher.isOpen();
    }

    // ==========================================
    // ZOOM (shared by every open editor)
    // ==========================================

    public void zoomIn() {
        setZoom(zoomPercent + ZOOM_STEP);
    }

    public void zoomOut() {
        setZoom(zoomPercent - ZOOM_STEP);
    }

    public void resetZoom() {
        setZoom(ZOOM_DEFAULT);
    }

    private void setZoom(int percent) {
        this.zoomPercent = Math.max(ZOOM_MIN, Math.min(ZOOM_MAX, percent));
        applyZoomToAllEditors();
    }

    private void applyZoomToAllEditors() {
        Map<String, CodeEditorPanel> editors = editorService.getOpenEditors();
        if (editors == null) return;
        for (CodeEditorPanel editor : editors.values()) {
            editor.setZoomPercent(zoomPercent);
        }
    }

    /**
     * Method to select the next tab
     *
     */
    public void selectNextTab() {
        int count = tabbedPane.getTabCount();
        if (count < 2) return;
        tabbedPane.setSelectedIndex((tabbedPane.getSelectedIndex() + 1) % count);
        focusSelectedTab();
    }

    /**
     * Method to select the previous tab
     *
     */
    public void selectPreviousTab() {
        int count = tabbedPane.getTabCount();
        if (count < 2) return;
        tabbedPane.setSelectedIndex((tabbedPane.getSelectedIndex() - 1 + count) % count);
        focusSelectedTab();
    }

    /**
     * Method to select the focused tab
     * */
    private void focusSelectedTab() {
        Component selected = tabbedPane.getSelectedComponent();
        if (selected != null) selected.requestFocusInWindow();
    }

    /**
     * Method to update the projetct name
     * */
    public void updateProjectName(String newName) {
        this.projectName = newName;
        fileTreePanel.updateProjectName(newName);
    }
}