package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.utils.WorkspacePaths;
import lombok.Getter;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

/**
 * Panel that contains the file tree with all its functionality
 * @author pablo03
 */
@Getter
public class FileTreePanel extends JPanel {

    private final WorkspaceNotifier notifier;
    private final WorkspacePanel workspacePanel;
    private final JTree fileTree;
    private final DefaultTreeModel treeModel;
    private final DefaultMutableTreeNode rootNode;
    private final Map<String, DefaultMutableTreeNode> fileNodes;
    private final FileTreePopupMenu popupMenu;

    // Context for menu operations
    private DefaultMutableTreeNode selectedNode;
    private FileNode selectedFileNode;

    /**
     * Constructor with default project name
     */
    public FileTreePanel(WorkspaceNotifier notifier, WorkspacePanel workspacePanel) {
        this(notifier, workspacePanel, "Project");
    }

    /**
     * Constructor with custom project name
     */
    public FileTreePanel(WorkspaceNotifier notifier, WorkspacePanel workspacePanel, String projectName) {
        this.notifier = notifier;
        this.workspacePanel = workspacePanel;
        this.fileNodes = new HashMap<>();

        setLayout(new BorderLayout());
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());

        // Create root node with custom project name
        FileNode rootFileNode = new FileNode(projectName, true);
        rootFileNode.setFilePath("");
        rootNode = new DefaultMutableTreeNode(rootFileNode);
        treeModel = new DefaultTreeModel(rootNode);
        fileTree = new JTree(treeModel);

        // Initialize popup menu
        popupMenu = new FileTreePopupMenu(notifier, workspacePanel);

        // Configure tree
        configureTree();
        setupTreeListeners();

        // Create scroll pane
        JScrollPane treeScroll = new JScrollPane(fileTree);
        treeScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        treeScroll.setBackground(Theme.SIDEBAR_DARKT.getColorSet());
        treeScroll.getViewport().setBackground(Theme.AUXILIARY_BACKGROUND_DARK.getColorSet());

        add(treeScroll, BorderLayout.CENTER);
    }

    /**
     * Update the project name (for rename operations)
     */
    public void updateProjectName(String newName) {
        if (rootNode != null && rootNode.getUserObject() instanceof FileNode rootFileNode) {
            rootFileNode.setName(newName);
            treeModel.reload(rootNode);
            notifier.logInfo("Project renamed to: " + newName);
        }
    }

    /**
     * Configure the tree appearance and behavior
     */
    private void configureTree() {
        fileTree.setCellRenderer(new FileTreeCellRenderer());
        fileTree.setModel(treeModel);
        fileTree.setSelectionRow(0);
        fileTree.setRootVisible(true);
        fileTree.setShowsRootHandles(true);
        fileTree.setBackground(Theme.SIDEBAR_DARKT.getColorSet());
        fileTree.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        fileTree.setOpaque(true);
        fileTree.setEditable(false);
        fileTree.setRowHeight(24);

        // Disable tooltips
        fileTree.setToolTipText(null);
        ToolTipManager.sharedInstance().unregisterComponent(fileTree);

        // Use a simple UI
        fileTree.setUI(new javax.swing.plaf.metal.MetalTreeUI());
    }

    /**
     * Setup all tree listeners
     */
    private void setupTreeListeners() {
        // Mouse listener for double click and context menu
        fileTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    handleDoubleClick(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    handlePopupTrigger(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    handlePopupTrigger(e);
                }
            }
        });

        // Keyboard shortcuts
        fileTree.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleEnterKey();
                } else if (e.getKeyCode() == KeyEvent.VK_F2) {
                    workspacePanel.renameSelectedNode();
                } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    workspacePanel.deleteSelectedNode();
                }
            }
        });

        // Tree selection listener to update context
        fileTree.addTreeSelectionListener(e -> updateSelectionContext());
    }

    /**
     * Handle double click on tree node
     */
    private void handleDoubleClick(MouseEvent e) {
        TreePath path = fileTree.getPathForLocation(e.getX(), e.getY());
        if (path != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object userObject = node.getUserObject();

            if (userObject instanceof FileNode) {
                FileNode fileNode = (FileNode) userObject;
                if (!fileNode.isDirectory()) {
                    workspacePanel.openFileInTab(fileNode);
                }
            }
        }
    }

    /**
     * Handle popup trigger event
     */
    private void handlePopupTrigger(MouseEvent e) {
        TreePath path = fileTree.getPathForLocation(e.getX(), e.getY());
        if (path != null) {
            fileTree.setSelectionPath(path);
            updateSelectionContext();
            showPopupMenu(e);
        } else {
            fileTree.clearSelection();
            // Show menu with root context
            selectedNode = rootNode;
            selectedFileNode = (FileNode) rootNode.getUserObject();
            showPopupMenu(e);
        }
    }

    /**
     * Handle enter key press
     */
    private void handleEnterKey() {
        TreePath path = fileTree.getSelectionPath();
        if (path != null) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object userObject = node.getUserObject();

            if (userObject instanceof FileNode) {
                FileNode fileNode = (FileNode) userObject;
                if (!fileNode.isDirectory()) {
                    workspacePanel.openFileInTab(fileNode);
                }
            }
        }
    }

    /**
     * Update selection context for menu
     */
    private void updateSelectionContext() {
        TreePath path = fileTree.getSelectionPath();
        if (path != null) {
            selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object userObject = selectedNode.getUserObject();

            if (userObject instanceof FileNode) {
                selectedFileNode = (FileNode) userObject;
            }
        }
    }

    /**
     * Show popup menu with correct context
     */
    private void showPopupMenu(MouseEvent e) {
        boolean isRoot = selectedNode == rootNode;
        boolean isDirectory = selectedFileNode != null && selectedFileNode.isDirectory();
        boolean isFile = selectedFileNode != null && !selectedFileNode.isDirectory();

        boolean isPigFile = isFile && selectedFileNode.getExtension().equals(".pig");

        popupMenu.showPopup(fileTree, e, isRoot, isDirectory, isFile, isPigFile);
    }

    /**
     * Get the currently selected node
     */
    public DefaultMutableTreeNode getSelectedNode() {
        TreePath path = fileTree.getSelectionPath();
        if (path != null) {
            return (DefaultMutableTreeNode) path.getLastPathComponent();
        }
        return null;
    }

    /**
     * Get the currently selected file node
     */
    public FileNode getSelectedFileNode() {
        DefaultMutableTreeNode node = getSelectedNode();
        if (node != null && node.getUserObject() instanceof FileNode) {
            return (FileNode) node.getUserObject();
        }
        return null;
    }

    /**
     * Get the parent path for new file/folder creation
     */
    public String getSelectedParentPath() {
        DefaultMutableTreeNode node = getSelectedNode();
        if (node != null && node.getUserObject() instanceof FileNode) {
            FileNode fileNode = (FileNode) node.getUserObject();
            if (fileNode.isDirectory()) {
                return fileNode.getFilePath();
            } else {
                // If file selected, use its parent
                DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
                if (parent != null && parent.getUserObject() instanceof FileNode) {
                    return ((FileNode) parent.getUserObject()).getFilePath();
                }
            }
        }
        return "";
    }

    /**
     * Get the parent node for new file/folder creation
     */
    public DefaultMutableTreeNode getSelectedParentNode() {
        DefaultMutableTreeNode node = getSelectedNode();
        if (node != null) {
            Object userObject = node.getUserObject();
            if (userObject instanceof FileNode fileNode) {
                if (fileNode.isDirectory()) {
                    return node;
                } else {
                    // If file selected, use its parent
                    DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
                    if (parent != null) {
                        return parent;
                    }
                }
            }
        }
        return rootNode;
    }

    // Delegate methods for file operations

    public void createNewFile(String fileName, boolean isDirectory, String parentPath) {
        FileNode newNode = new FileNode(fileName, isDirectory);
        String fullPath = parentPath != null && !parentPath.isEmpty() ? parentPath + "/" + fileName : fileName;
        newNode.setFilePath(fullPath);

        DefaultMutableTreeNode parentNode = findNodeByPath(parentPath);
        if (parentNode == null) {
            parentNode = rootNode;
        }

        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(newNode);
        parentNode.add(treeNode);
        treeModel.reload(parentNode);
        expandNode(parentNode);

        fileNodes.put(fullPath, treeNode);
    }

    public void createNewFile(String fileName, boolean isDirectory) {
        createNewFile(fileName, isDirectory, null);
    }

    public DefaultMutableTreeNode findNodeByPath(String path) {
        if (path == null || path.isEmpty()) {
            return rootNode;
        }
        return findNodeByPath(rootNode, path);
    }

    private DefaultMutableTreeNode findNodeByPath(DefaultMutableTreeNode node, String path) {
        Object userObj = node.getUserObject();
        if (userObj instanceof FileNode fileNode) {
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

    public void expandNode(DefaultMutableTreeNode node) {
        TreePath path = new TreePath(node.getPath());
        fileTree.expandPath(path);
        fileTree.scrollPathToVisible(path);
    }

    public void reloadTree() {
        treeModel.reload(rootNode);
    }


    /**
     * Method to rename a node keeping its FileNode (content, context) and re-key all descendants.
     */
    public void renamePathPrefix(String oldPath, String newPath, String newName) {
        DefaultMutableTreeNode node = fileNodes.get(oldPath);
        if (node == null || !(node.getUserObject() instanceof FileNode fileNode)) {
            return;
        }

        Set<String> expanded = captureExpandedPaths();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
        treeModel.removeNodeFromParent(node);

        fileNode.setName(newName);
        rekeySubtree(node, oldPath, newPath);

        treeModel.insertNodeInto(node, parent, sortedIndex(parent, fileNode));
        restoreExpandedPaths(expanded, oldPath, newPath);
        fileTree.setSelectionPath(new TreePath(node.getPath()));
    }

    /**
     * Method to remove a node and every descendant from the tree and from the path map.
     */
    public void removeSubtree(String path) {
        DefaultMutableTreeNode node = fileNodes.get(path);
        if (node == null || node == rootNode) {
            return;
        }
        unregisterSubtree(node);
        treeModel.removeNodeFromParent(node);
    }

    /**
     * Method to add a node discovered on disk (sorted, without expanding folders). Parent must already exist.
     */
    public FileNode addNodeFromDisk(String path, boolean isDirectory) {
        int slash = path.lastIndexOf('/');
        String parentPath = slash == -1 ? "" : path.substring(0, slash);
        DefaultMutableTreeNode parentNode = parentPath.isEmpty() ? rootNode : fileNodes.get(parentPath);
        if (parentNode == null) {
            return null;
        }

        FileNode fileNode = new FileNode(WorkspacePaths.nameOf(path), isDirectory);
        fileNode.setFilePath(path);

        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(fileNode);
        treeModel.insertNodeInto(treeNode, parentNode, sortedIndex(parentNode, fileNode));
        fileNodes.put(path, treeNode);
        return fileNode;
    }

    /**
     * Method to rekey the subtree
     *
     */
    private void rekeySubtree(DefaultMutableTreeNode node, String oldBase, String newBase) {
        if (node.getUserObject() instanceof FileNode fileNode) {
            String oldPath = fileNode.getFilePath();
            String updated = WorkspacePaths.replacePrefix(oldPath, oldBase, newBase);
            fileNodes.remove(oldPath);
            fileNode.setFilePath(updated);
            fileNodes.put(updated, node);
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            rekeySubtree((DefaultMutableTreeNode) node.getChildAt(i), oldBase, newBase);
        }
    }

    /**
     * Helper method for unregistered subtrees
     *
     */
    private void unregisterSubtree(DefaultMutableTreeNode node) {
        if (node.getUserObject() instanceof FileNode fileNode) {
            fileNodes.remove(fileNode.getFilePath());
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            unregisterSubtree((DefaultMutableTreeNode) node.getChildAt(i));
        }
    }

    /**
     * Method for folders first, then alphabetical (same order used when loading from disk).
     */
    private int sortedIndex(DefaultMutableTreeNode parent, FileNode newNode) {
        int index = 0;
        for (; index < parent.getChildCount(); index++) {
            DefaultMutableTreeNode child = (DefaultMutableTreeNode) parent.getChildAt(index);
            FileNode sibling = (FileNode) child.getUserObject();
            boolean before = newNode.isDirectory() != sibling.isDirectory()
                    ? newNode.isDirectory()
                    : newNode.getName().compareToIgnoreCase(sibling.getName()) < 0;
            if (before) break;
        }
        return index;
    }

    /**
     * Method to capture the expanded paths
     *
     */
    private Set<String> captureExpandedPaths() {
        Set<String> paths = new HashSet<>();
        Enumeration<TreePath> expanded = fileTree.getExpandedDescendants(new TreePath(rootNode.getPath()));
        while (expanded != null && expanded.hasMoreElements()) {
            Object last = expanded.nextElement().getLastPathComponent();
            if (last instanceof DefaultMutableTreeNode n && n.getUserObject() instanceof FileNode f) {
                paths.add(f.getFilePath());
            }
        }
        return paths;
    }

    /**
     * Method to restore the expanded paths
     *
     */
    private void restoreExpandedPaths(Set<String> expanded, String oldPath, String newPath) {
        for (String path : expanded) {
            String current = WorkspacePaths.isSameOrInside(path, oldPath)
                    ? WorkspacePaths.replacePrefix(path, oldPath, newPath)
                    : path;
            DefaultMutableTreeNode node = fileNodes.get(current);
            if (node != null) {
                fileTree.expandPath(new TreePath(node.getPath()));
            }
        }
    }

}