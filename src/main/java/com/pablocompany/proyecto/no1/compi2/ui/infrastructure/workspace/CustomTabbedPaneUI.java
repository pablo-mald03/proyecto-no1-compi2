package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.workspace;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

/**
 * Custom UI for tabbed pane with dark theme support
 * @author pablo03
 */
public class CustomTabbedPaneUI extends BasicTabbedPaneUI {

    @Override
    protected void installDefaults() {
        super.installDefaults();

        // Set dark theme colors for tabs
        UIManager.put("TabbedPane.selected", Theme.SURFACE_DARK.getColorSet());
        UIManager.put("TabbedPane.background", Theme.STATUS_BAR_DARK.getColorSet());
        UIManager.put("TabbedPane.foreground", Theme.FOREGROUND_DARK.getColorSet());
        UIManager.put("TabbedPane.shadow", Theme.BORDER_DARK.getColorSet());
        UIManager.put("TabbedPane.darkShadow", Theme.BORDER_DARK.getColorSet());
        UIManager.put("TabbedPane.light", Theme.SURFACE_DARK.getColorSet());
        UIManager.put("TabbedPane.highlight", Theme.SURFACE_DARK.getColorSet());
        UIManager.put("TabbedPane.borderHightlightColor", Theme.BORDER_DARK.getColorSet());
        UIManager.put("TabbedPane.tabAreaBackground", Theme.STATUS_BAR_DARK.getColorSet());
        UIManager.put("TabbedPane.unselectedBackground", Theme.STATUS_BAR_DARK.getColorSet());
        UIManager.put("TabbedPane.selectHighlight", Theme.SURFACE_DARK.getColorSet());
    }

    @Override
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex,
                                      int x, int y, int w, int h, boolean isSelected) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isSelected) {
            g2d.setColor(Theme.SURFACE_DARK.getColorSet());
        } else {
            Color bgColor = Theme.STATUS_BAR_DARK.getColorSet();
            g2d.setColor(bgColor);
        }

        g2d.fillRoundRect(x, y + 2, w, h - 2, 8, 8);
        g2d.dispose();
    }

    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex,
                                  int x, int y, int w, int h, boolean isSelected) {
    }

    @Override
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects,
                                       int tabIndex, Rectangle iconRect, Rectangle textRect,
                                       boolean isSelected) {
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics,
                             int tabIndex, String title, Rectangle textRect, boolean isSelected) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (isSelected) {
            g2d.setColor(Theme.FOREGROUND_DARK.getColorSet());
        } else {
            g2d.setColor(new Color(180, 185, 195));
        }

        g2d.setFont(font);
        g2d.drawString(title, textRect.x, textRect.y + metrics.getAscent());
        g2d.dispose();
    }
}
