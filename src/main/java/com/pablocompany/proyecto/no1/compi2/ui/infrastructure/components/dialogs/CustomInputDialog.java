package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.dialogs;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Custom input dialog with dark theme support
 * @author pablo03
 */
public class CustomInputDialog extends JDialog {

    private final JTextField textField;
    private final JLabel messageLabel;
    private final JButton confirmButton;
    private final JButton cancelButton;
    private String result = null;
    private boolean confirmed = false;

    public CustomInputDialog(Component parent, String title, String message, String initialValue) {
        super(parent != null ? SwingUtilities.getWindowAncestor(parent) : null, title, ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Setup main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(Theme.SURFACE_DARK.getColorSet());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Message label
        messageLabel = new JLabel(message);
        messageLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        messageLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 13));

        // Text field
        textField = new JTextField(initialValue != null ? initialValue : "");
        textField.setBackground(Theme.BACKGROUND_DARK.getColorSet());
        textField.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        textField.setCaretColor(Theme.FOREGROUND_DARK.getColorSet());
        textField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Theme.BORDER_DARK.getColorSet()),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));
        textField.setFont(new Font("Liberation Mono", Font.PLAIN, 13));
        textField.selectAll();

        // Key listener for Enter key
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    confirmAction();
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    cancelAction();
                }
            }
        });

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        buttonPanel.setBackground(Theme.SURFACE_DARK.getColorSet());

        confirmButton = createStyledButton("Confirm", true);
        cancelButton = createStyledButton("Cancel", false);

        confirmButton.addActionListener(e -> confirmAction());
        cancelButton.addActionListener(e -> cancelAction());

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // Assemble dialog
        JPanel inputPanel = new JPanel(new BorderLayout(0, 10));
        inputPanel.setBackground(Theme.SURFACE_DARK.getColorSet());
        inputPanel.add(messageLabel, BorderLayout.NORTH);
        inputPanel.add(textField, BorderLayout.CENTER);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setSize(450, 150);
        setLocationRelativeTo(parent);

        // Request focus to text field
        textField.requestFocusInWindow();
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
     * Confirm action
     */
    private void confirmAction() {
        String input = textField.getText();
        if (input == null || input.trim().isEmpty()) {
            // Highlight empty field
            textField.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.RED),
                    BorderFactory.createEmptyBorder(8, 10, 8, 10)
            ));
            return;
        }
        result = input.trim();
        confirmed = true;
        dispose();
    }

    /**
     * Cancel action
     */
    private void cancelAction() {
        confirmed = false;
        result = null;
        dispose();
    }

    /**
     * Show the dialog and return the result
     */
    public String showDialog() {
        setVisible(true);
        return confirmed ? result : null;
    }

    /**
     * Static method to show input dialog
     */
    public static String showInputDialog(Component parent, String title, String message) {
        return showInputDialog(parent, title, message, null);
    }

    /**
     * Static method to show input dialog with initial value
     */
    public static String showInputDialog(Component parent, String title, String message, String initialValue) {
        CustomInputDialog dialog = new CustomInputDialog(parent, title, message, initialValue);
        return dialog.showDialog();
    }
}