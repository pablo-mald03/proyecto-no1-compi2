package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Principal tab switcher adapter class
 *
 */
public class TabSwitcher {

    private static final int MAX_VISIBLE_ROWS = 10;
    private static final int MIN_WIDTH = 280;

    private static final Color SELECTION_BG = new Color(38, 79, 120);

    private final JTabbedPane tabs;

    /**
     * Most recently used first
     */
    private final List<Component> mru = new ArrayList<>();

    // State of the popup while it is open
    private JWindow popup;
    private JList<String> list;
    private List<Component> snapshot = List.of();
    private int index;
    private Window ownerWindow;
    private final WindowAdapter ownerListener = new WindowAdapter() {
        @Override
        public void windowDeactivated(WindowEvent e) {
            cancel();
        }
    };

    public TabSwitcher(JTabbedPane tabs) {
        this.tabs = tabs;
        this.tabs.addChangeListener(e -> trackSelection());
    }

    public boolean isOpen() {
        return popup != null;
    }


    /**
     * Method to feed every key event here. Returns true when the event was consumed.
     */
    public boolean handleKeyEvent(KeyEvent e) {
        int code = e.getKeyCode();
        int id = e.getID();

        if (isOpen()) {
            if (id == KeyEvent.KEY_RELEASED && code == KeyEvent.VK_CONTROL) {
                commit();
                return true;
            }

            if (id == KeyEvent.KEY_PRESSED) {
                if (!e.isControlDown() && code != KeyEvent.VK_SHIFT && code != KeyEvent.VK_CONTROL) {
                    commit();
                    return false;
                }
                switch (code) {
                    case KeyEvent.VK_TAB -> move(e.isShiftDown() ? -1 : 1);
                    case KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT -> move(1);
                    case KeyEvent.VK_UP, KeyEvent.VK_LEFT -> move(-1);
                    case KeyEvent.VK_ESCAPE -> cancel();
                    default -> {
                        // swallow everything else while the switcher is open
                    }
                }
                return code != KeyEvent.VK_SHIFT && code != KeyEvent.VK_CONTROL;
            }

            return code == KeyEvent.VK_TAB;
        }

        if (id == KeyEvent.KEY_PRESSED && code == KeyEvent.VK_TAB && e.isControlDown()) {
            if (tabs.getTabCount() >= 2) {
                open(e.isShiftDown());
            }
            return true;
        }
        return false;
    }

    /**
     * Method to track the selection
     *
     */
    private void trackSelection() {
        Component selected = tabs.getSelectedComponent();
        if (selected == null) return;
        mru.remove(selected);
        mru.add(0, selected);
    }

    /**
     * MRU order method, dropping closed tabs and appending tabs never selected
     */
    private List<Component> buildOrderedTabs() {
        List<Component> ordered = new ArrayList<>();
        for (Component c : mru) {
            if (tabs.indexOfComponent(c) >= 0) ordered.add(c);
        }
        mru.retainAll(ordered);

        for (int i = 0; i < tabs.getTabCount(); i++) {
            Component c = tabs.getComponentAt(i);
            if (!ordered.contains(c)) ordered.add(c);
        }

        // Current tab always first
        Component current = tabs.getSelectedComponent();
        if (current != null && ordered.remove(current)) {
            ordered.add(0, current);
        }
        return ordered;
    }

    /**
     * Pop up trigger method to open the modal
     *
     */
    private void open(boolean backwards) {
        snapshot = buildOrderedTabs();
        if (snapshot.size() < 2) return;

        index = backwards ? snapshot.size() - 1 : 1;

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Component c : snapshot) {
            int i = tabs.indexOfComponent(c);
            model.addElement(i >= 0 ? tabs.getTitleAt(i) : "?");
        }

        list = new JList<>(model);
        list.setFocusable(false);
        list.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        list.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        list.setFont(new Font("Liberation Mono", Font.PLAIN, 13));
        list.setVisibleRowCount(Math.min(snapshot.size(), MAX_VISIBLE_ROWS));
        list.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> l, Object value, int row,
                                                          boolean selected, boolean focus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(l, value, row, selected, false);
                label.setBorder(BorderFactory.createEmptyBorder(5, 12, 5, 12));
                label.setBackground(selected ? SELECTION_BG : Theme.BACKGROUND_DARK.getColorSet());
                label.setForeground(Theme.FOREGROUND_DARK.getColorSet());
                return label;
            }
        });
        list.setSelectedIndex(index);

        FontMetrics fm = list.getFontMetrics(list.getFont());
        int textWidth = 0;
        for (int i = 0; i < model.size(); i++) {
            textWidth = Math.max(textWidth, fm.stringWidth(model.get(i)));
        }

        JScrollPane scroll = new JScrollPane(list,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.getViewport().setBackground(Theme.BACKGROUND_DARK.getColorSet());

        JLabel header = new JLabel("Cambiar de pestaña");
        header.setFont(new Font("Liberation Mono", Font.BOLD, 11));
        header.setForeground(new Color(150, 156, 166));
        header.setBorder(BorderFactory.createEmptyBorder(8, 12, 6, 12));

        JPanel content = new JPanel(new BorderLayout());
        content.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        content.setBorder(BorderFactory.createLineBorder(Theme.BORDER_DARK.getColorSet(), 1));
        content.add(header, BorderLayout.NORTH);
        content.add(scroll, BorderLayout.CENTER);

        ownerWindow = SwingUtilities.getWindowAncestor(tabs);
        popup = new JWindow(ownerWindow);
        popup.setFocusableWindowState(false); // focus stays in the editor
        popup.setContentPane(content);

        int width = Math.max(MIN_WIDTH, textWidth + 24 + 24);
        int rows = Math.min(snapshot.size(), MAX_VISIBLE_ROWS);
        int rowHeight = fm.getHeight() + 10;
        popup.setSize(width, header.getPreferredSize().height + rows * rowHeight + 4);
        popup.setLocationRelativeTo(tabs.isShowing() ? tabs : ownerWindow);

        if (ownerWindow != null) ownerWindow.addWindowListener(ownerListener);
        popup.setVisible(true);
        list.ensureIndexIsVisible(index);
    }

    /**
     * Method to move the tab
     *
     */
    private void move(int delta) {
        if (!isOpen()) return;
        int size = snapshot.size();
        index = ((index + delta) % size + size) % size;
        list.setSelectedIndex(index);
        list.ensureIndexIsVisible(index);
    }

    /**
     * Method to trigger the action
     *
     */
    private void commit() {
        if (!isOpen()) return;
        Component target = snapshot.get(index);
        close();
        if (tabs.indexOfComponent(target) >= 0) {
            tabs.setSelectedComponent(target);
            SwingUtilities.invokeLater(() -> focusTab(target));
        }
    }

    /**
     * Method to cancel the action
     *
     */
    private void cancel() {
        close();
    }

    /**
     * Method to close the window
     *
     */
    private void close() {
        if (popup != null) {
            popup.setVisible(false);
            popup.dispose();
            popup = null;
        }
        if (ownerWindow != null) {
            ownerWindow.removeWindowListener(ownerListener);
            ownerWindow = null;
        }
        list = null;
        snapshot = List.of();
    }

    /**
     * Method to focus the tab
     *
     */
    private void focusTab(Component tab) {
        JTextComponent text = findTextComponent(tab);
        if (text != null) {
            text.requestFocusInWindow();
        } else {
            tab.requestFocusInWindow();
        }
    }

    /**
     * Method to find the text component
     *
     */
    private JTextComponent findTextComponent(Component c) {
        if (c instanceof JTextComponent t) return t;
        if (c instanceof Container container) {
            for (Component child : container.getComponents()) {
                JTextComponent found = findTextComponent(child);
                if (found != null) return found;
            }
        }
        return null;
    }
}
