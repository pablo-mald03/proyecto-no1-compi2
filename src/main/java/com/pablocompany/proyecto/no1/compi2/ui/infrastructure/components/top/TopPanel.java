package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.top;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.domain.TextConstants;
import com.pablocompany.proyecto.no1.compi2.ui.domain.UIColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Top panel with menu bar and toolbar
 *
 * @author pablo03
 */
public class TopPanel extends JPanel {

    private final WorkspaceNotifier notifier;
    private final Runnable onNewProject;
    private final Runnable onOpenProject;
    private final Runnable onCloseProject;
    private final Runnable onSave;
    private final Runnable onCompile;
    private final Runnable onExecute;
    private final Runnable onExit;
    private final Runnable onSaveAll;

    private final JMenuBar menuBar;
    private final JToolBar toolBar;

    public TopPanel(
            WorkspaceNotifier notifier,
            Runnable onNewProject,
            Runnable onOpenProject,
            Runnable onCloseProject,
            Runnable onSave,
            Runnable onCompile,
            Runnable onExecute,
            Runnable onExit,
            Runnable onSaveAll
    ) {
        this.onSaveAll = onSaveAll;
        this.notifier = notifier;
        this.onNewProject = onNewProject;
        this.onOpenProject = onOpenProject;
        this.onCloseProject = onCloseProject;
        this.onSave = onSave;
        this.onCompile = onCompile;
        this.onExecute = onExecute;
        this.onExit = onExit;

        setLayout(new BorderLayout());
        setBackground(Theme.BORDER_LIGHT.getColorSet());

        // Create menu bar
        menuBar = createMenuBar();

        // Create toolbar
        toolBar = createToolBar();

        // Add components to toolbar
        addToolbarComponents();

        // Add to panel
        add(menuBar, BorderLayout.NORTH);
        add(toolBar, BorderLayout.CENTER);
    }

    /**
     * Add components to toolbar - buttons aligned to the right
     */
    private void addToolbarComponents() {
        // Add spacer to push buttons to the right
        toolBar.add(Box.createHorizontalGlue());

        // ==========================================
        // BUTTONS WITH DIFFERENT COLORS - Aligned right
        // ==========================================

        // Save button - Success/Green
        toolBar.add(createToolbarButton(
                "Guardar",
                e -> onSave(),
                UIColors.ACCEPT_ACCENT_BUTTON.getColorSet(),
                UIColors.ACCEPT_ACCENT_HOVER_BUTTON.getColorSet()
        ));

        // Separator
        toolBar.addSeparator(new Dimension(8, 0));

        // Compile button - Info/Blue
        toolBar.add(createToolbarButton(
                "Compilar",
                e -> onCompile(),
                UIColors.INFO_BACKGROUND.getColorSet(),
                new Color(54, 147, 241).brighter()
        ));

        // Separator
        toolBar.addSeparator(new Dimension(8, 0));

        // Execute button - Success/Green brighter
        toolBar.add(createToolbarButton(
                "Ejecutar",
                e -> onExecute(),
                UIColors.ACCENT.getColorSet(),
                new Color(152, 89, 7).brighter()
        ));
    }

    /**
     * Create the menu bar with all menus
     */
    /**
     * Create the menu bar with all menus
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Theme.BORDER_LIGHT.getColorSet());
        menuBar.setForeground(Theme.FOREGROUND_LIGHT.getColorSet());
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Theme.BORDER_DARK.getColorSet()));

        // File Menu
        JMenu fileMenu = createMenu("Archivo", KeyEvent.VK_A);
        fileMenu.add(createMenuItem("Nuevo Proyecto", KeyEvent.VK_N, e -> onNewProject()));
        fileMenu.add(createMenuItem("Abrir Proyecto", KeyEvent.VK_O, e -> onOpenProject()));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Cerrar Proyecto", KeyEvent.VK_C, e -> onCloseProject()));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Guardar", KeyEvent.VK_S,
                e -> onSave(), KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK)));
        fileMenu.add(createMenuItem("Guardar Todo", KeyEvent.VK_T,
                e -> {
                    if (onSaveAll != null) onSaveAll.run();
                },
                KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK)));
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Salir", KeyEvent.VK_X, e -> onExit()));
        menuBar.add(fileMenu);

        // Edit Menu - Now with compiled code actions
        JMenu editMenu = createMenu("Editar", KeyEvent.VK_E);
        editMenu.add(createMenuItem("Descargar Compilado", KeyEvent.VK_D,
                e -> notifier.notifyDownloadCompiledCode(),
                KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK)));
        editMenu.addSeparator();
        editMenu.add(createMenuItem("Ejecutar Compilado", KeyEvent.VK_R,
                e -> notifier.notifyExecuteCompiledCode(),
                KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK)));

        menuBar.add(editMenu);

        // View Menu
        JMenu viewMenu = createMenu("Ver", KeyEvent.VK_V);
        viewMenu.add(createMenuItem("Consola", 0, e -> notifier.focusConsole()));
        viewMenu.add(createMenuItem("Errores", 0, e -> notifier.focusErrors()));
        viewMenu.add(createMenuItem("Tabla de Símbolos", 0, e -> notifier.focusSymbolsTable()));
        viewMenu.add(createMenuItem("Tabla de Tipos", 0, e -> notifier.focusSymbolsTable()));
        menuBar.add(viewMenu);

        // Tools Menu
        JMenu toolsMenu = createMenu("Herramientas", KeyEvent.VK_H);
        toolsMenu.add(createMenuItem("Compilar", KeyEvent.VK_C, e -> onCompile(), KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_DOWN_MASK)));
        toolsMenu.add(createMenuItem("Ejecutar", KeyEvent.VK_E, e -> onExecute(), KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK)));
        menuBar.add(toolsMenu);

        // Help Menu
        JMenu helpMenu = createMenu("Ayuda", KeyEvent.VK_U);
        helpMenu.add(createMenuItem("Acerca de...", 0, e -> showAboutDialog()));
        menuBar.add(helpMenu);

        return menuBar;
    }


    /**
     * Create a styled menu
     */
    private JMenu createMenu(String text, int mnemonic) {
        JMenu menu = new JMenu(text);
        menu.setBackground(Theme.BORDER_LIGHT.getColorSet());
        menu.setForeground(Theme.FOREGROUND_LIGHT.getColorSet());
        menu.setFont(new Font("Liberation Mono", Font.PLAIN, TextConstants.SMALL_NORMAL_TEXT.getSize()));
        if (mnemonic > 0) {
            menu.setMnemonic(mnemonic);
        }
        return menu;
    }

    /**
     * Create a styled menu item
     */
    private JMenuItem createMenuItem(String text, int mnemonic, ActionListener action) {
        return createMenuItem(text, mnemonic, action, null);
    }

    /**
     * Create a styled menu item with shortcut
     */
    private JMenuItem createMenuItem(String text, int mnemonic, ActionListener action, KeyStroke accelerator) {
        JMenuItem item = new JMenuItem(text);
        item.setBackground(Theme.SIDEBAR_LIGHT.getColorSet());
        item.setForeground(Theme.FOREGROUND_LIGHT.getColorSet());
        item.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        if (mnemonic > 0) {
            item.setMnemonic(mnemonic);
        }
        if (accelerator != null) {
            item.setAccelerator(accelerator);
        }
        if (action != null) {
            item.addActionListener(action);
        }
        return item;
    }

    /**
     * Create the toolbar
     */
    private JToolBar createToolBar() {
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        toolbar.setBackground(Theme.STATUS_BAR_LIGHT.getColorSet());
        toolbar.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, UIColors.DECLINE_ACCENT_BUTTON.getColorSet()));
        toolbar.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));

        toolbar.setBorder(BorderFactory.createCompoundBorder(
                toolbar.getBorder(),
                BorderFactory.createEmptyBorder(0, 0, 0, 15)
        ));

        return toolbar;
    }

    /**
     * Create a toolbar button with rounded corners and specific colors
     */
    private JButton createToolbarButton(String text, ActionListener action, Color bgColor, Color hoverColor) {
        JButton button = new JButton(text);

        // Set colors
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Liberation Mono", Font.BOLD, 12));

        // Rounded corners
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(bgColor.darker(), 1, true),
                BorderFactory.createEmptyBorder(8, 16, 8, 16)
        ));

        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);

        if (action != null) {
            button.addActionListener(action);
        }

        // Hover effect with your colors
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setBackground(hoverColor);
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(hoverColor.darker(), 1, true),
                        BorderFactory.createEmptyBorder(8, 16, 8, 16)
                ));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setBackground(bgColor);
                button.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(bgColor.darker(), 1, true),
                        BorderFactory.createEmptyBorder(8, 16, 8, 16)
                ));
            }
        });

        return button;
    }

    // ==========================================
    // ACTION METHODS
    // ==========================================

    private void onNewProject() {
        if (onNewProject != null) onNewProject.run();
    }

    private void onOpenProject() {
        if (onOpenProject != null) onOpenProject.run();
    }

    private void onCloseProject() {
        if (onCloseProject != null) onCloseProject.run();
    }

    private void onSave() {
        if (onSave != null) onSave.run();
    }

    private void onCompile() {
        if (onCompile != null) onCompile.run();
    }

    private void onExecute() {
        if (onExecute != null) onExecute.run();
    }

    private void onExit() {
        if (onExit != null) onExit.run();
    }

    /**
     * Show about dialog
     */
    private void showAboutDialog() {
        JOptionPane.showMessageDialog(
                this,
                "3xtrat3rr3str3D Compiler\nVersion 1.0.0\n\nCompilador para el lenguaje 3xtrat3rr3str3D",
                "Acerca de 3xtrat3rr3str3D Compiler",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}