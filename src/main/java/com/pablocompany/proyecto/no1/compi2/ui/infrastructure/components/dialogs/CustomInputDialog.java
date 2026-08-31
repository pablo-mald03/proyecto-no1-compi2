package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.dialogs;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.domain.TextConstants;
import com.pablocompany.proyecto.no1.compi2.ui.domain.UIColors;

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
        messageLabel.setFont(new Font("Liberation Mono", Font.PLAIN, TextConstants.SMALL_NORMAL_TEXT.getSize()));

        // ==========================================
        // Text field with guaranteed visibility
        // ==========================================
        textField = new JTextField(initialValue != null ? initialValue : "");

        // Set preferred size to ensure visibility
        textField.setPreferredSize(new Dimension(380, 50));
        textField.setMinimumSize(new Dimension(300, 35));
        textField.setMaximumSize(new Dimension(500, 45));

        // High contrast colors
        textField.setBackground(Theme.SURFACE_LIGHT.getColorSet());
        textField.setForeground(Theme.FOREGROUND_LIGHT.getColorSet());
        textField.setCaretColor(Theme.FOREGROUND_LIGHT.getColorSet());
        textField.setSelectedTextColor(Theme.FOREGROUND_LIGHT.getColorSet());
        textField.setSelectionColor(UIColors.BACKGROUND_HOVER.getColorSet());

        textField.setBorder(
                BorderFactory.createLineBorder(Theme.BORDER_DARK.getColorSet())
        );


        textField.setFont(new Font("Liberation Mono", Font.PLAIN, TextConstants.SMALL_NORMAL_TEXT.getSize()));
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

        confirmButton = createStyledButton("Confirmar", true);
        cancelButton = createStyledButton("Cancelar", false);

        confirmButton.addActionListener(e -> confirmAction());
        cancelButton.addActionListener(e -> cancelAction());

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // Assemble dialog with proper layout
        JPanel inputPanel = new JPanel(new BorderLayout(0, 10));
        inputPanel.setBackground(Theme.SURFACE_DARK.getColorSet());
        inputPanel.add(messageLabel, BorderLayout.NORTH);

        // Wrap text field in a panel to ensure it gets space
        JPanel textFieldWrapper = new JPanel(new BorderLayout());
        textFieldWrapper.setBackground(Theme.SURFACE_DARK.getColorSet());
        textFieldWrapper.add(textField, BorderLayout.CENTER);
        inputPanel.add(textFieldWrapper, BorderLayout.CENTER);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setSize(450, 170);
        setLocationRelativeTo(parent);
        setResizable(false);

        // Request focus to text field
        textField.requestFocusInWindow();
    }

    /**
     * Create a styled button
     */
    private JButton createStyledButton(String text, boolean isConfirm) {
        JButton button = new JButton(text);
        button.setBackground(isConfirm ? UIColors.ACCEPT_ACCENT_BUTTON.getColorSet() : UIColors.DECLINE_ACCENT_BUTTON.getColorSet());
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
                button.setBackground(isConfirm ? UIColors.ACCEPT_ACCENT_HOVER_BUTTON.getColorSet() : UIColors.DECLINE_ACCENT_HOVER_BUTTON.getColorSet());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(isConfirm ? UIColors.ACCEPT_ACCENT_BUTTON.getColorSet() : UIColors.DECLINE_ACCENT_BUTTON.getColorSet());
            }
        });

        return button;
    }

    /**
     * Sanitize input text - replace spaces with underscores
     */
    private String sanitizeText(String input) {
        if (input == null) {
            return null;
        }
        return input.trim().replaceAll("\\s+", "_");
    }

    /**
     * Confirm action
     */
    private void confirmAction() {
        String input = textField.getText();
        if (input == null || input.trim().isEmpty()) {
            textField.setBorder(
                    BorderFactory.createLineBorder(Color.RED)
                   );
            return;
        }

        result = sanitizeText(input);
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