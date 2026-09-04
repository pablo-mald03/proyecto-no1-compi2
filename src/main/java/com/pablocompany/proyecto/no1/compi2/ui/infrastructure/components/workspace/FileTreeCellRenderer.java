package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.domain.UIColors;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Custom renderer for the file tree with icons and dark theme support
 * @author pablo03
 */
public class FileTreeCellRenderer extends DefaultTreeCellRenderer {

    private final ImageIcon folderIcon;
    private final ImageIcon fileIcon;
    private final ImageIcon zIcon;
    private final ImageIcon yIcon;
    private final ImageIcon pigIcon;
    private final ImageIcon projectIcon;

    public FileTreeCellRenderer() {
        // Load icons from resources
        folderIcon = createIconFromFile("/com/pablocompany/proyecto/no1/media/folder.png", 16);
        fileIcon = createIconFromFile("/com/pablocompany/proyecto/no1/media/file.png", 16);
        zIcon = createIconFromFile("/com/pablocompany/proyecto/no1/media/z-file.png", 16);
        yIcon = createIconFromFile("/com/pablocompany/proyecto/no1/media/y-file.png", 16);
        pigIcon = createIconFromFile("/com/pablocompany/proyecto/no1/media/pig-file.png", 16);
        projectIcon = createIconFromFile("/com/pablocompany/proyecto/no1/media/project.png", 16);

        // Configure selection colors for dark theme
        setBackgroundNonSelectionColor(Theme.BACKGROUND_DARK.getColorSet());
        setBackgroundSelectionColor(UIColors.ACCEPT_MODULE_SELECTED_BUTTON.getColorSet());
        setTextNonSelectionColor(Theme.FOREGROUND_DARK.getColorSet());
        setTextSelectionColor(Theme.FOREGROUND_DARK.getColorSet());
        setBorderSelectionColor(UIColors.ACCEPT_MODULE_SELECTED_BUTTON.getColorSet());

        setOpaque(true);
        setToolTipText(null);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                  boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component comp = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        if (comp instanceof JLabel label) {

            label.setBackground(selected ? Theme.SURFACE_DARK.getColorSet() : Theme.BACKGROUND_DARK.getColorSet());
            label.setForeground(Theme.FOREGROUND_DARK.getColorSet());
            label.setOpaque(true);
            label.setToolTipText(null);

            if (value instanceof DefaultMutableTreeNode node) {
                Object userObject = node.getUserObject();

                if (userObject instanceof FileNode fileNode) {

                    if (node == tree.getModel().getRoot()) {
                        label.setIcon(projectIcon != null ? projectIcon : createFallbackIcon());
                    } else if (fileNode.isDirectory()) {
                        label.setIcon(folderIcon != null ? folderIcon : createFallbackIcon());
                    } else {
                        String fileName = fileNode.getName().toLowerCase();
                        if (fileName.endsWith(".z")) {
                            label.setIcon(zIcon != null ? zIcon : createFallbackIcon());
                        } else if (fileName.endsWith(".y")) {
                            label.setIcon(yIcon != null ? yIcon : createFallbackIcon());
                        } else if (fileName.endsWith(".pig")) {
                            label.setIcon(pigIcon != null ? pigIcon : createFallbackIcon());
                        } else {
                            label.setIcon(fileIcon != null ? fileIcon : createFallbackIcon());
                        }
                    }
                }
            }
        }

        return comp;
    }

    /**
     * Load icon from resources with fallback
     */
    private ImageIcon createIconFromFile(String path, int size) {
        try {
            java.net.URL url = getClass().getResource(path);
            if (url != null) {
                ImageIcon icon = new ImageIcon(url);
                Image scaledImage = icon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
                return new ImageIcon(scaledImage);
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Create a fallback icon if image not found
     */
    private ImageIcon createFallbackIcon() {
        return new ImageIcon(createColorIcon(16, 16, new Color(200, 200, 200)));
    }

    /**
     * Create a colored icon as fallback
     */
    private BufferedImage createColorIcon(int width, int height, Color color) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(color);
        g2d.fillRoundRect(2, 2, width - 4, height - 4, 3, 3);
        g2d.setColor(Theme.BORDER_DARK.getColorSet());
        g2d.drawRoundRect(2, 2, width - 4, height - 4, 3, 3);

        g2d.dispose();
        return image;
    }

    @Override
    public String getToolTipText(MouseEvent event) {
        return null;
    }
}