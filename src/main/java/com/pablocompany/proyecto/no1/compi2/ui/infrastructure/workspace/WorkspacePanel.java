package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.workspace;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.CodeEditorPanel;
import lombok.Getter;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

/**
 * Main workspace panel containing file tree and tabbed editor
 * @author pablo03
 */
@Getter
public class WorkspacePanel extends JPanel {

    private final WorkspaceNotifier notifier;
    private final FileTreePanel fileTreePanel;
    private final JTabbedPane tabbedPane;
    private final Map<String, CodeEditorPanel> openEditors;
    private final JSplitPane splitPane;

    public WorkspacePanel(WorkspaceNotifier notifier) {
        this.notifier = notifier;
        this.openEditors = new HashMap<>();

        setLayout(new BorderLayout());
        setBackground(Theme.BACKGROUND_DARK.getColorSet());

        // Create file tree panel
        fileTreePanel = new FileTreePanel(notifier, this);

        // Create tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
        tabbedPane.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        tabbedPane.setUI(new CustomTabbedPaneUI());
        tabbedPane.putClientProperty("JTabbedPane.tabType", "rounded");

        // Create split pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, fileTreePanel, tabbedPane);
        splitPane.setDividerLocation(250);
        splitPane.setDividerSize(4);
        splitPane.setBorder(BorderFactory.createEmptyBorder());
        splitPane.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        add(splitPane, BorderLayout.CENTER);
    }

    /**
     * Create a new file with the specified extension
     */
    public void createNewFileWithExtension(String extension) {
        String parentPath = fileTreePanel.getSelectedParentPath();
        DefaultMutableTreeNode parentNode = fileTreePanel.getSelectedParentNode();

        String baseName = JOptionPane.showInputDialog(this,
                "Ingresa el nombre del archivo (sin extension):",
                "Crear nuevo archivo",
                JOptionPane.PLAIN_MESSAGE);

        if (baseName == null || baseName.trim().isEmpty()) {
            return;
        }

        baseName = baseName.trim();

        if (baseName.contains(".")) {
            notifier.alertToast("Porfavor no escribas la extension. Esta se coloca automatica.", true);
            return;
        }

        String fullName = baseName + extension;
        String finalPath = parentPath.isEmpty() ? fullName : parentPath + "/" + fullName;

        int counter = 1;
        String originalName = baseName;
        while (fileTreePanel.getFileNodes().containsKey(finalPath)) {
            fullName = originalName + counter + extension;
            finalPath = parentPath.isEmpty() ? fullName : parentPath + "/" + fullName;
            counter++;

            if (counter > 100) break;
        }

        fileTreePanel.createNewFile(fullName, false, parentPath.isEmpty() ? null : parentPath);

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

        String folderName = JOptionPane.showInputDialog(this,
                "Ingresa el nombre del folder:",
                "Crear Nuevo Folder",
                JOptionPane.PLAIN_MESSAGE);

        if (folderName == null || folderName.trim().isEmpty()) {
            return;
        }

        folderName = folderName.trim();

        if (folderName.contains(".")) {
            notifier.alertToast("Los nombre de los folders no deberian tener extension.", true);
            return;
        }

        String finalPath = parentPath.isEmpty() ? folderName : parentPath + "/" + folderName;

        // Check if folder exists
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

        String newName = JOptionPane.showInputDialog(this,
                "Ingresar nuevo nombre:",
                "Rename",
                JOptionPane.PLAIN_MESSAGE);

        if (newName == null || newName.trim().isEmpty()) {
            return;
        }

        newName = newName.trim();

        if (!fileNode.isDirectory()) {
            String currentExtension = "";
            int dotIndex = currentName.lastIndexOf('.');
            if (dotIndex != -1) {
                currentExtension = currentName.substring(dotIndex);
            }

            if (!newName.contains(".") && !currentExtension.isEmpty()) {
                newName = newName + currentExtension;
            } else if (newName.contains(".") && !newName.endsWith(currentExtension)) {
                // User changed extension
                if (!currentExtension.isEmpty()) {
                    // Check if new extension matches old one
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

        // Update the node
        String newPath = oldPath.substring(0, oldPath.lastIndexOf('/') + 1) + newName;
        if (oldPath.equals(newPath)) {
            return;
        }

        // Check if new name already exists in same directory
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

            // Update tab title
            int index = tabbedPane.indexOfComponent(editor);
            if (index != -1) {
                tabbedPane.setTabComponentAt(index, createTabComponent(newName, newPath));
            }
        }

        fileTreePanel.reloadTree();
    }

    /**
     * Delete the selected node
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
            notifier.logError("No se puede eliminar la raiz del proyecto");
            return;
        }

        String type = fileNode.isDirectory() ? "folder" : "archivo";
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Estas segurio que quieres eliminar el " + type + ": " + fileNode.getName() + "?",
                "Confirmar eliminacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
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

    /**
     * Open a file in a new tab
     */
    public void openFileInTab(FileNode fileNode) {
        String filePath = fileNode.getFilePath();
        String fileName = fileNode.getName();

        // If already open, just focus the tab
        if (openEditors.containsKey(filePath)) {
            int index = findTabIndexByPath(filePath);
            if (index != -1) {
                tabbedPane.setSelectedIndex(index);
            }
            return;
        }

        CodeEditorPanel editor = new CodeEditorPanel(notifier);
        tabbedPane.addTab(fileName, editor);
        openEditors.put(filePath, editor);

        int index = tabbedPane.indexOfComponent(editor);
        tabbedPane.setSelectedIndex(index);
        tabbedPane.setTabComponentAt(index, createTabComponent(fileName, filePath));

    }

    /**
     * Create a custom tab component with close button
     */
    private Component createTabComponent(String title, String filePath) {
        JPanel tabComponent = new JPanel(new BorderLayout(5, 0));
        tabComponent.setOpaque(false);
        tabComponent.setBackground(Theme.STATUS_BAR_DARK.getColorSet());

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        titleLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());

        JButton closeButton = new JButton("✕");
        closeButton.setFont(new Font("Liberation Mono", Font.BOLD, 10));
        closeButton.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        closeButton.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
        closeButton.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
        closeButton.setFocusable(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setOpaque(true);

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(Theme.SURFACE_DARK.getColorSet());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
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
            }
        }
    }

    /**
     * Close all tabs
     */
    public void closeAllTabs() {
        tabbedPane.removeAll();
        openEditors.clear();
        notifier.logInfo("All files closed");
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