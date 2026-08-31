package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.workspace;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * Custom renderer for the file tree with icons and dark theme support
 * @author pablo03
 */
public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {

    private final ImageIcon folderIcon;
    private final ImageIcon fileIcon;
    private final ImageIcon javaIcon;
    private final ImageIcon textIcon;
    private final ImageIcon pigIcon;

    public CustomTreeCellRenderer() {
        // Create icons with dark theme colors
        folderIcon = createFolderIcon();
        fileIcon = createFileIcon();
        javaIcon = createJavaIcon();
        textIcon = createTextIcon();
        pigIcon = createPigIcon();

        // Configure selection colors for dark theme
        setBackgroundNonSelectionColor(Theme.BACKGROUND_DARK.getColorSet());
        setBackgroundSelectionColor(Theme.SURFACE_DARK.getColorSet());
        setTextNonSelectionColor(Theme.FOREGROUND_DARK.getColorSet());
        setTextSelectionColor(Theme.FOREGROUND_DARK.getColorSet());
        setBorderSelectionColor(Theme.BORDER_DARK.getColorSet());

        setOpaque(true);

        setToolTipText(null);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                  boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component comp = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        if (comp instanceof JLabel label) {

            // Set dark theme colors always
            label.setBackground(selected ? Theme.SURFACE_DARK.getColorSet() : Theme.BACKGROUND_DARK.getColorSet());
            label.setForeground(Theme.FOREGROUND_DARK.getColorSet());
            label.setOpaque(true);

            // CRITICAL FIX: Remove any tooltip text
            label.setToolTipText(null);

            if (value instanceof DefaultMutableTreeNode node) {
                Object userObject = node.getUserObject();

                if (userObject instanceof FileNode fileNode) {
                    if (fileNode.isDirectory()) {
                        label.setIcon(folderIcon);
                    } else {
                        String fileName = fileNode.getName().toLowerCase();
                        if (fileName.endsWith(".z")) {
                            label.setIcon(javaIcon);
                        } else if (fileName.endsWith(".y")) {
                            label.setIcon(textIcon);
                        } else if (fileName.endsWith(".pig")) {
                            label.setIcon(pigIcon);
                        } else {
                            label.setIcon(fileIcon);
                        }
                    }
                }
            }
        }

        return comp;
    }

    /**
     * Create a folder icon
     */
    private ImageIcon createFolderIcon() {
        return new ImageIcon(createColorIcon(16, 16, new Color(255, 200, 50)));
    }

    /**
     * Create a generic file icon
     */
    private ImageIcon createFileIcon() {
        return new ImageIcon(createColorIcon(16, 16, new Color(180, 180, 200)));
    }

    /**
     * Create a Java file icon
     */
    private ImageIcon createJavaIcon() {
        return new ImageIcon(createColorIcon(16, 16, new Color(255, 150, 50)));
    }

    /**
     * Create a text file icon
     */
    private ImageIcon createTextIcon() {
        return new ImageIcon(createColorIcon(16, 16, new Color(100, 200, 255)));
    }

    /**
     * Create a Pig Latin file icon
     */
    private ImageIcon createPigIcon() {
        return new ImageIcon(createColorIcon(16, 16, new Color(255, 100, 150)));
    }

    /**
     * Create a colored icon with better quality
     */
    private BufferedImage createColorIcon(int width, int height, Color color) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Draw icon with rounded rectangle
        g2d.setColor(color);
        g2d.fillRoundRect(2, 2, width - 4, height - 4, 3, 3);

        // Add border
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