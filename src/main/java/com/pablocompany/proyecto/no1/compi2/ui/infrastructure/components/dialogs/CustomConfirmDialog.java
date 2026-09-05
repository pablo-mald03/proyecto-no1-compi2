package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.dialogs;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;

import javax.swing.*;
import java.awt.*;

/**
 * Custom confirm dialog with dark theme support
 * @author pablo03
 */
public class CustomConfirmDialog extends JDialog {

    private int result = JOptionPane.NO_OPTION;

    public CustomConfirmDialog(Component parent, String title, String message, String confirmText) {
        super(parent != null ? SwingUtilities.getWindowAncestor(parent) : null, title, ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Setup main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(Theme.SURFACE_DARK.getColorSet());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Message label with icon
        JPanel messagePanel = new JPanel(new BorderLayout(10, 0));
        messagePanel.setBackground(Theme.SURFACE_DARK.getColorSet());

        // Warning icon
        JLabel iconLabel = new JLabel(UIManager.getIcon("OptionPane.warningIcon"));
        iconLabel.setBackground(Theme.SURFACE_DARK.getColorSet());

        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        messageLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 13));

        messagePanel.add(iconLabel, BorderLayout.WEST);
        messagePanel.add(messageLabel, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        buttonPanel.setBackground(Theme.SURFACE_DARK.getColorSet());

        JButton confirmButton = createStyledButton(confirmText != null ? confirmText : "Confirm", true);
        JButton cancelButton = createStyledButton("Cancel", false);

        confirmButton.addActionListener(e -> {
            result = JOptionPane.YES_OPTION;
            dispose();
        });

        cancelButton.addActionListener(e -> {
            result = JOptionPane.NO_OPTION;
            dispose();
        });

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        mainPanel.add(messagePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setSize(400, 130);
        setLocationRelativeTo(parent);
    }

    /**
     * Create a styled button
     */
    private JButton createStyledButton(String text, boolean isConfirm) {
        JButton button = new JButton(text);
        button.setBackground(isConfirm ? Theme.STATUS_BAR_DARK.getColorSet() : Theme.BACKGROUND_DARK.getColorSet());
        button.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        button.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Theme.BORDER_DARK.getColorSet()),
                BorderFactory.createEmptyBorder(8, 20, 8, 20)
        ));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(isConfirm ? Theme.SURFACE_DARK.getColorSet() : Theme.SURFACE_DARK.getColorSet());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(isConfirm ? Theme.STATUS_BAR_DARK.getColorSet() : Theme.BACKGROUND_DARK.getColorSet());
            }
        });

        return button;
    }

    /**
     * Show the dialog and return the result
     */
    public int showDialog() {
        setVisible(true);
        return result;
    }

    /**
     * Static method to show confirm dialog
     */
    public static boolean showConfirmDialog(Component parent, String title, String message) {
        return showConfirmDialog(parent, title, message, "Confirm");
    }

    /**
     * Static method to show confirm dialog with custom confirm text
     */
    public static boolean showConfirmDialog(Component parent, String title, String message, String confirmText) {
        CustomConfirmDialog dialog = new CustomConfirmDialog(parent, title, message, confirmText);
        return dialog.showDialog() == JOptionPane.YES_OPTION;
    }
}