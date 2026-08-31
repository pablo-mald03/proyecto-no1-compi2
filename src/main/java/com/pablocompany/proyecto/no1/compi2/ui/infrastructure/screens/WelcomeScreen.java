package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.screens;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.domain.TextConstants;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.dialogs.CustomInputDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.function.Consumer;

/**
 * Welcome screen with options to create or open a project
 *
 * @author pablo03
 */
public class WelcomeScreen extends JPanel {

    private final java.util.function.Consumer<String> onProjectCreated;
    private final java.util.function.Consumer<File> onProjectOpened;

    public WelcomeScreen(
            Consumer<String> onProjectCreated,
            Consumer<File> onProjectOpened
    ) {
        this.onProjectCreated = onProjectCreated;
        this.onProjectOpened = onProjectOpened;

        setLayout(new GridBagLayout());
        setBackground(Theme.BACKGROUND_DARK.getColorSet());

        initializeComponents();
    }

    /**
     * Handle create project action
     */
    private void handleCreateProject() {
        String projectName = CustomInputDialog.showInputDialog(
                this,
                "Crear Proyecto",
                "Ingresa el nombre del proyecto:"
        );

        if (projectName != null && !projectName.trim().isEmpty()) {
            projectName = projectName.trim().replaceAll("\\s+", "_");
            if (onProjectCreated != null) {
                onProjectCreated.accept(projectName);
            }
        }
    }

    /**
     * Handle open project action
     */
    private void handleOpenProject() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar proyecto");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDir = fileChooser.getSelectedFile();
            if (onProjectOpened != null) {
                onProjectOpened.accept(selectedDir);
            }
        }
    }

    private void initializeComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);


        // Title
        JLabel titleLabel = new JLabel("3xtrat3rr3str3D Compiler");
        titleLabel.setFont(new Font("Liberation Mono", Font.BOLD, 32));
        titleLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        add(titleLabel, gbc);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Compilador para el lenguaje 3xtrat3rr3str3D");
        subtitleLabel.setFont(new Font("Liberation Mono", Font.PLAIN, TextConstants.EMPHASIS_TEXT.getSize()));
        subtitleLabel.setForeground(new Color(180, 185, 195));
        add(subtitleLabel, gbc);

        // Spacer
        gbc.insets = new Insets(30, 10, 20, 10);
        add(Box.createVerticalStrut(20), gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false);

        // Create Project Button
        JButton createButton = createStyledButton(
                "Crear Proyecto",
                e -> handleCreateProject(),
                new Color(50, 150, 200)
        );

        // Open Project Button
        JButton openButton = createStyledButton(
                "Abrir Proyecto",
                e -> handleOpenProject(),
                new Color(100, 180, 100)
        );

        buttonPanel.add(createButton);
        buttonPanel.add(openButton);

        gbc.insets = new Insets(10, 10, 10, 10);
        add(buttonPanel, gbc);

        // Version info
        JLabel versionLabel = new JLabel("Version 1.0.0");
        versionLabel.setFont(new Font("Liberation Mono", Font.PLAIN, TextConstants.SMALL_EMPHASIS_TEXT.getSize()));
        versionLabel.setForeground(new Color(100, 105, 115));
        gbc.insets = new Insets(40, 10, 10, 10);
        add(versionLabel, gbc);
    }

    /**
     * Create a styled button
     */
    private JButton createStyledButton(String text, ActionListener action, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Liberation Mono", Font.BOLD, 14));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(bgColor.darker()),
                BorderFactory.createEmptyBorder(12, 30, 12, 30)
        ));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.addActionListener(action);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(bgColor.brighter());
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(bgColor);
            }
        });

        return button;
    }


}
