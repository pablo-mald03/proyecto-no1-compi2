package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.workspace;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author pablo03
 */
// Custom renderer cell tree for the icons to the files
public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {

    private final ImageIcon folderIcon;
    private final ImageIcon fileIcon;
    private final ImageIcon javaIcon;
    private final ImageIcon textIcon;

    public CustomTreeCellRenderer() {
        folderIcon = createFolderIcon();
        fileIcon = createFileIcon();
        javaIcon = createJavaIcon();
        textIcon = createTextIcon();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Component comp = super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        if (comp instanceof JLabel label) {
            label.setBackground(Theme.BACKGROUND_DARK.getColorSet());
            label.setForeground(Theme.FOREGROUND_DARK.getColorSet());

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
                        } else {
                            label.setIcon(fileIcon);
                        }
                    }
                }
            }
        }

        return comp;
    }

    private ImageIcon createFolderIcon() {
        return new ImageIcon(createColorIcon(12, 12, new Color(255, 200, 50)));
    }

    private ImageIcon createFileIcon() {
        return new ImageIcon(createColorIcon(12, 12, new Color(200, 200, 200)));
    }

    private ImageIcon createJavaIcon() {
        return new ImageIcon(createColorIcon(12, 12, new Color(255, 150, 50)));
    }

    private ImageIcon createTextIcon() {
        return new ImageIcon(createColorIcon(12, 12, new Color(100, 200, 255)));
    }

    private BufferedImage createColorIcon(int width, int height, Color color) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(color);
        if (width > 4 && height > 4) {
            g2d.fillRect(1, 1, width - 2, height - 2);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(1, 1, width - 2, height - 2);
        }

        g2d.dispose();
        return image;
    }
}
