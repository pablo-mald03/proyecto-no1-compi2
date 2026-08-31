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
 * Principal class to define the workspace with the files tree
 * @author pablo03
 */
@Getter
public class WorkspacePanel extends JPanel {

    private final WorkspaceNotifier notifier;
    private final JSplitPane splitPane;
    private final JTree fileTree;
    private final DefaultTreeModel treeModel;
    private final DefaultMutableTreeNode rootNode;
    private final JTabbedPane tabbedPane;
    private final Map<String, CodeEditorPanel> openEditors;
    private final Map<String, DefaultMutableTreeNode> fileNodes;
    private String currentProjectPath;

    public WorkspacePanel(WorkspaceNotifier notifier) {
        this.notifier = notifier;
        this.openEditors = new HashMap<>();
        this.fileNodes = new HashMap<>();

        setLayout(new BorderLayout());
        setBackground(Theme.BACKGROUND_DARK.getColorSet());

        // Create root node for the tree
        rootNode = new DefaultMutableTreeNode("Project");
        treeModel = new DefaultTreeModel(rootNode);
        fileTree = new JTree(treeModel);

        // Configure the tree
        configureTree();

        // Create tree panel with scroll
        JScrollPane treeScroll = new JScrollPane(fileTree);
        treeScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        treeScroll.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        treeScroll.getViewport().setBackground(Theme.BACKGROUND_DARK.getColorSet());

        // Create tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
        tabbedPane.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        tabbedPane.setUI(new CustomTabbedPaneUI());

        // Configure rounded tabs
        tabbedPane.putClientProperty("JTabbedPane.tabType", "rounded");

        // Create split pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, tabbedPane);
        splitPane.setDividerLocation(250);
        splitPane.setDividerSize(4);
        splitPane.setBorder(BorderFactory.createEmptyBorder());
        splitPane.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        add(splitPane, BorderLayout.CENTER);

        setupTreeListeners();
    }

    /**
     * Principal method to configure the tree
     */
    private void configureTree() {
        // Set our custom renderer
        fileTree.setCellRenderer(new CustomTreeCellRenderer());

        // IMPORTANT: Set our model explicitly
        fileTree.setModel(treeModel);

        // Configure selection
        fileTree.setSelectionRow(0);
        fileTree.setRootVisible(true);
        fileTree.setShowsRootHandles(true);

        // Configure background
        fileTree.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        fileTree.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        fileTree.setOpaque(true);

        // Configure selection colors
       // fileTree.setSelectionBackground(Theme.SURFACE_DARK.getColorSet());
      //  fileTree.setSelectionForeground(Theme.FOREGROUND_DARK.getColorSet());

        // Support for name editing
        fileTree.setEditable(true);

        // Set row height for better visibility
        fileTree.setRowHeight(20);

        // CRITICAL FIX: Disable tooltips completely
        fileTree.setToolTipText(null);
        ToolTipManager.sharedInstance().unregisterComponent(fileTree);

        // Remove any default renderer tooltips
        fileTree.setCellRenderer(new CustomTreeCellRenderer());

        // Use a simple UI without extra decorations
        fileTree.setUI(new javax.swing.plaf.metal.MetalTreeUI());
    }

    /**
     * Setup mouse listeners for the tree
     */
    private void setupTreeListeners() {
        fileTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    TreePath path = fileTree.getPathForLocation(e.getX(), e.getY());
                    if (path != null) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                        Object userObject = node.getUserObject();

                        if (userObject instanceof FileNode) {
                            FileNode fileNode = (FileNode) userObject;
                            if (!fileNode.isDirectory()) {
                                openFileInTab(fileNode);
                            }
                        }
                    }
                }
            }
        });

        // Add keyboard listener for enter key to open files
        fileTree.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    TreePath path = fileTree.getSelectionPath();
                    if (path != null) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                        Object userObject = node.getUserObject();

                        if (userObject instanceof FileNode) {
                            FileNode fileNode = (FileNode) userObject;
                            if (!fileNode.isDirectory()) {
                                openFileInTab(fileNode);
                            }
                        }
                    }
                }
            }
        });

        // CRITICAL FIX: Prevent tooltips from showing on mouse movement
        fileTree.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                // Do nothing - prevents default tooltip behavior
            }
        });
    }

    /**
     * Method to manage the file creation
     */
    public void createNewFile(String fileName, boolean isDirectory) {
        createNewFile(fileName, isDirectory, null);
    }

    /**
     * Method to manage the file creation with parent path
     */
    public void createNewFile(String fileName, boolean isDirectory, String parentPath) {
        FileNode newNode = new FileNode(fileName, isDirectory);
        String fullPath = parentPath != null ? parentPath + "/" + fileName : fileName;
        newNode.setFilePath(fullPath);

        DefaultMutableTreeNode parentNode;
        if (parentPath == null || parentPath.isEmpty()) {
            parentNode = rootNode;
        } else {
            parentNode = findNodeByPath(parentPath);
            if (parentNode == null) {
                parentNode = rootNode;
            }
        }

        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(newNode);
        parentNode.add(treeNode);
        treeModel.reload(parentNode);

        expandNode(parentNode);

        fileNodes.put(fullPath, treeNode);

        if (!isDirectory) {
            FileNode fileNode = (FileNode) treeNode.getUserObject();
            openFileInTab(fileNode);
        }
    }

    /**
     * Find a node by its path
     */
    private DefaultMutableTreeNode findNodeByPath(String path) {
        return findNodeByPath(rootNode, path);
    }

    /**
     * Find a node by its path recursively
     */
    private DefaultMutableTreeNode findNodeByPath(DefaultMutableTreeNode node, String path) {
        Object userObj = node.getUserObject();
        if (userObj instanceof FileNode) {
            FileNode fileNode = (FileNode) userObj;
            if (path.equals(fileNode.getFilePath())) {
                return node;
            }
        }

        for (int i = 0; i < node.getChildCount(); i++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) node.getChildAt(i);
            DefaultMutableTreeNode result = findNodeByPath(child, path);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    /**
     * Expand a node in the tree
     */
    private void expandNode(DefaultMutableTreeNode node) {
        TreePath path = new TreePath(node.getPath());
        fileTree.expandPath(path);
        fileTree.scrollPathToVisible(path);
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

        // Hover effect for close button
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
     * Close a tab by file path
     */
    public void closeTab(String filePath) {
        if (openEditors.containsKey(filePath)) {
            CodeEditorPanel editor = openEditors.get(filePath);
            int index = tabbedPane.indexOfComponent(editor);
            if (index != -1) {
                tabbedPane.remove(index);
                openEditors.remove(filePath);
                notifier.logInfo("File closed: " + filePath);
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