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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

/**
 *
 * @author pablo03
 */
//Principal class to define the workspace with the files tree
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
        
        // Crear nodo raíz del árbol
        rootNode = new DefaultMutableTreeNode("Proyecto");
        treeModel = new DefaultTreeModel(rootNode);
        fileTree = new JTree(treeModel);
        
        // Configurar el árbol
        configureTree();
        
        // Crear panel de árbol con scroll
        JScrollPane treeScroll = new JScrollPane(fileTree);
        treeScroll.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        treeScroll.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        
        // Crear panel de pestañas
        tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
        tabbedPane.setForeground(Theme.FOREGROUND_LIGHT.getColorSet());
        
        // Configurar comportamiento de cierre de pestañas
        tabbedPane.putClientProperty("JTabbedPane.tabType", "rounded");
        
        // Crear split pane
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeScroll, tabbedPane);
        splitPane.setDividerLocation(250);
        splitPane.setDividerSize(4);
        splitPane.setBorder(BorderFactory.createEmptyBorder());
        
        add(splitPane, BorderLayout.CENTER);
        
        setupTreeListeners();
    }

    //Principal method to configure the tree
    private void configureTree() {
        fileTree.setCellRenderer(new CustomTreeCellRenderer());
        
        // Configurar selección
        fileTree.setSelectionRow(0);
        fileTree.setRootVisible(true);
        fileTree.setShowsRootHandles(true);
        
        // Configurar el background
        fileTree.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        fileTree.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        
        // Soporte para edición de nombres
        fileTree.setEditable(true);
    }
    
    private void setupTreeListeners() {
        fileTree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    TreePath path = fileTree.getPathForLocation(e.getX(), e.getY());
                    if (path != null) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                        Object userObject = node.getUserObject();
                        
                        if (userObject instanceof FileNode fileNode) {
                            if (!fileNode.isDirectory()) {
                                openFileInTab(fileNode);
                            }
                        }
                    }
                }
            }
        });
    }
    
    //Method to manage the file
    public void createNewFile(String fileName, boolean isDirectory) {
        createNewFile(fileName, isDirectory, null);
    }
    
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
    
    private DefaultMutableTreeNode findNodeByPath(String path) {
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
    
    private void expandNode(DefaultMutableTreeNode node) {
        TreePath path = new TreePath(node.getPath());
        fileTree.expandPath(path);
        fileTree.scrollPathToVisible(path);
    }
    
    public void openFileInTab(FileNode fileNode) {
        String filePath = fileNode.getFilePath();
        String fileName = fileNode.getName();
        
        // Si ya está abierto, solo enfocar la pestaña
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
        
        notifier.logInfo("Archivo abierto: " + fileName);
    }
    
    private int findTabIndexByPath(String filePath) {
        // Asumiendo que guardamos el path en algún lugar
        // Por ahora, buscar por el nombre del componente
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
    
    private Component createTabComponent(String title, String filePath) {
        JPanel tabComponent = new JPanel(new BorderLayout());
        tabComponent.setOpaque(false);
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        titleLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        
        JButton closeButton = new JButton("✕");
        closeButton.setFont(new Font("Liberation Mono", Font.BOLD, 10));
        closeButton.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        closeButton.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        closeButton.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
        closeButton.setFocusable(false);
        closeButton.setContentAreaFilled(false);
        
        closeButton.addActionListener(e -> closeTab(filePath));
        
        tabComponent.add(titleLabel, BorderLayout.WEST);
        tabComponent.add(closeButton, BorderLayout.EAST);
        
        return tabComponent;
    }
    
    public void closeTab(String filePath) {
        if (openEditors.containsKey(filePath)) {
            CodeEditorPanel editor = openEditors.get(filePath);
            int index = tabbedPane.indexOfComponent(editor);
            if (index != -1) {
                tabbedPane.remove(index);
                openEditors.remove(filePath);
                notifier.logInfo("Archivo cerrado: " + filePath);
            }
        }
    }
    
    public void closeAllTabs() {
        tabbedPane.removeAll();
        openEditors.clear();
        notifier.logInfo("Todos los archivos cerrados");
    }
    
    // Getters
    public CodeEditorPanel getCurrentEditor() {
        Component comp = tabbedPane.getSelectedComponent();
        if (comp instanceof CodeEditorPanel) {
            return (CodeEditorPanel) comp;
        }
        return null;
    }

    
    // Método para obtener el contenido de todos los archivos (para exportar)
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
