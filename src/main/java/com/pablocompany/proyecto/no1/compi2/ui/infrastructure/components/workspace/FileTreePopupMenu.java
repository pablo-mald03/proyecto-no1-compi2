package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Popup menu for the file tree with dark theme support
 * @author pablo03
 */
@Getter
public class FileTreePopupMenu extends JPopupMenu {

    private final WorkspaceNotifier notifier;
    private final WorkspacePanel workspacePanel;

    // Menu items
    private final JMenu newFileMenu;
    private final JMenuItem newFolderMenuItem;
    private final JMenuItem renameMenuItem;
    private final JMenuItem deleteMenuItem;
    private JMenuItem createYFileMenuItem;
    private JMenuItem createZFileMenuItem;
    private JMenuItem createPigFileMenuItem;

    // Context information
    private boolean isRootSelected;
    private boolean isDirectorySelected;
    private boolean isFileSelected;

    public FileTreePopupMenu(WorkspaceNotifier notifier, WorkspacePanel workspacePanel) {
        this.notifier = notifier;
        this.workspacePanel = workspacePanel;

        setBackground(Theme.SURFACE_DARK.getColorSet());
        setForeground(Theme.FOREGROUND_DARK.getColorSet());
        setBorder(BorderFactory.createLineBorder(Theme.BORDER_DARK.getColorSet()));

        // Initialize menu items
        newFileMenu = createNewFileMenu();
        newFolderMenuItem = createMenuItem("New Folder", e -> workspacePanel.createNewFolder());
        renameMenuItem = createMenuItem("Rename (F2)", e -> workspacePanel.renameSelectedNode());
        deleteMenuItem = createMenuItem("Delete", e -> workspacePanel.deleteSelectedNode());

        // Add to popup
        add(newFileMenu);
        add(newFolderMenuItem);
        addSeparator();
        add(renameMenuItem);
        add(deleteMenuItem);
    }

    /**
     * Create the New File submenu with presets
     */
    private JMenu createNewFileMenu() {
        JMenu menu = new JMenu("New File");
        menu.setBackground(Theme.SURFACE_DARK.getColorSet());
        menu.setForeground(Theme.FOREGROUND_DARK.getColorSet());

        createZFileMenuItem = createMenuItem("Zetariano File (.z)",
                e -> workspacePanel.createNewFileWithExtension(".z"));
        createYFileMenuItem = createMenuItem("Y File (.y)",
                e -> workspacePanel.createNewFileWithExtension(".y"));
        createPigFileMenuItem = createMenuItem("Pig Latin File (.pig)",
                e -> workspacePanel.createNewFileWithExtension(".pig"));

        menu.add(createZFileMenuItem);
        menu.add(createYFileMenuItem);
        menu.add(createPigFileMenuItem);

        return menu;
    }

    /**
     * Create a styled menu item
     */
    private JMenuItem createMenuItem(String text, java.awt.event.ActionListener action) {
        JMenuItem item = new JMenuItem(text);
        item.setBackground(Theme.SURFACE_DARK.getColorSet());
        item.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        item.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        item.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        item.addActionListener(action);

        // Hover effect
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                item.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                item.setBackground(Theme.SURFACE_DARK.getColorSet());
            }
        });

        return item;
    }

    /**
     * Update menu visibility based on selection context
     */
    public void updateContext(boolean isRoot, boolean isDirectory, boolean isFile) {
        this.isRootSelected = isRoot;
        this.isDirectorySelected = isDirectory;
        this.isFileSelected = isFile;

        // Root and directories can create files and folders
        boolean canCreate = isRoot || isDirectory;
        newFileMenu.setEnabled(canCreate);
        newFolderMenuItem.setEnabled(canCreate);

        // Can rename everyone (including root)
        renameMenuItem.setEnabled(true);

        // Can delete only if not root
        deleteMenuItem.setEnabled(!isRoot);

        // Files can't create new items
        if (isFile) {
            newFileMenu.setEnabled(false);
            newFolderMenuItem.setEnabled(false);
        }
    }

    /**
     * Show the popup with updated context
     */
    public void showPopup(JTree tree, MouseEvent e, boolean isRoot, boolean isDirectory, boolean isFile) {
        updateContext(isRoot, isDirectory, isFile);
        show(tree, e.getX(), e.getY());
    }
}