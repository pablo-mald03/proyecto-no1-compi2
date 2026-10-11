package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.analyzers.SyntaxHighlightListenerFactory;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.CodeEditorPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileNode;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileTreePanel;
import lombok.Getter;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Service responsible for editor tabs lifecycle, active editor state and file saving.
 *
 * @author pablo03
 */
@Getter
public class WorkspaceEditorService {

    private final JTabbedPane tabbedPane;
    private final FileTreePanel fileTreePanel;
    private final WorkspaceNotifier notifier;
    private final WorkspaceCompilationService compilationService;

    private final Map<String, CodeEditorPanel> openEditors;
    private final JPanel welcomePanel;

    public WorkspaceEditorService(
            JTabbedPane tabbedPane,
            FileTreePanel fileTreePanel,
            WorkspaceNotifier notifier,
            WorkspaceCompilationService compilationService
    ) {
        this.tabbedPane = tabbedPane;
        this.fileTreePanel = fileTreePanel;
        this.notifier = notifier;
        this.compilationService = compilationService;
        this.openEditors = new HashMap<>();
        this.welcomePanel = createWelcomePanel();

        initializeWelcomeTab();
    }

    /**
     * Initializes the welcome tab on startup
     */
    private void initializeWelcomeTab() {
        tabbedPane.addTab("Welcome", welcomePanel);
        tabbedPane.setEnabledAt(0, false);
    }

    /**
     * Check if a file is open in an editor tab
     */
    public boolean isOpen(String filePath) {
        return openEditors.containsKey(filePath);
    }

    /**
     * Open a file in a new tab with content and syntax highlighting
     */
    public void openFileInTab(FileNode fileNode) {
        String filePath = fileNode.getFilePath();
        String fileName = fileNode.getName();

        if (openEditors.containsKey(filePath)) {
            int index = findTabIndexByPath(filePath);
            if (index != -1) {
                tabbedPane.setSelectedIndex(index);
            }
            return;
        }

        removeWelcomeTabIfExists();

        boolean isCompiledFile = filePath.endsWith(".c") && filePath.contains("compiled");
        EditorContext context = compilationService.getContextForFile(filePath);

        String content = fileNode.getContent() != null ? fileNode.getContent() : "";
        if (context != null) {
            context.setSourceCode(content);
        }

        CodeEditorPanel editor = new CodeEditorPanel(notifier);
        editor.setCode(content);
        editor.setFileExtension(fileNode.getExtension(), filePath, fileName);
        editor.setEditable(!isCompiledFile);

        editor.getEditor().setEditorContext(context);
        editor.getEditor().setSyntaxHighlightListener(
                SyntaxHighlightListenerFactory.createListener(fileNode.getExtension(), filePath, fileName)
        );

        tabbedPane.addTab(fileName, editor);
        openEditors.put(filePath, editor);

        int index = tabbedPane.indexOfComponent(editor);
        tabbedPane.setSelectedIndex(index);
        tabbedPane.setTabComponentAt(index, createTabComponent(fileName, filePath));
    }

    /**
     * Update editor content and editability if open
     */
    public void updateEditorContentIfOpen(String filePath, String content, boolean editable) {
        if (openEditors.containsKey(filePath)) {
            CodeEditorPanel editor = openEditors.get(filePath);
            if (editor != null) {
                editor.setCode(content);
                editor.setEditable(editable);
            }
        }
    }

    /**
     * Handle updating open editor references when a file is renamed
     */
    public void handleFileRenamed(String oldPath, String newPath, String newName) {
        if (openEditors.containsKey(oldPath)) {
            CodeEditorPanel editor = openEditors.remove(oldPath);
            openEditors.put(newPath, editor);

            int index = tabbedPane.indexOfComponent(editor);
            if (index != -1) {
                tabbedPane.setTabComponentAt(index, createTabComponent(newName, newPath));
            }
        }
    }

    /**
     * Save the current active editor content to the file
     */
    public void saveCurrentFile() {
        CodeEditorPanel editor = getCurrentEditor();
        if (editor == null) {
            notifier.alertToast("No hay ningún archivo abierto para guardar", true);
            return;
        }

        String filePath = null;
        for (Map.Entry<String, CodeEditorPanel> entry : openEditors.entrySet()) {
            if (entry.getValue() == editor) {
                filePath = entry.getKey();
                break;
            }
        }

        if (filePath == null) {
            notifier.alertToast("Error: No se pudo identificar el archivo", true);
            return;
        }

        String content = editor.getCode();

        DefaultMutableTreeNode node = fileTreePanel.getFileNodes().get(filePath);
        if (node != null && node.getUserObject() instanceof FileNode fileNode) {
            fileNode.setContent(content);
            fileNode.setModified(false);
            fileNode.updateContextFromContent();

            compilationService.updateContextForFile(filePath, content);
            notifier.notifySaveFile(filePath, content);
        }
    }

    /**
     * Save all open files
     */
    public void saveAllFiles() {
        int savedCount = 0;
        for (Map.Entry<String, CodeEditorPanel> entry : openEditors.entrySet()) {
            String filePath = entry.getKey();
            CodeEditorPanel editor = entry.getValue();
            String content = editor.getCode();

            DefaultMutableTreeNode node = fileTreePanel.getFileNodes().get(filePath);
            if (node != null && node.getUserObject() instanceof FileNode fileNode) {
                String oldContent = fileNode.getContent();

                if (!content.equals(oldContent)) {
                    fileNode.setContent(content);
                    fileNode.setModified(false);
                    fileNode.updateContextFromContent();
                    compilationService.updateContextForFile(filePath, content);
                    notifier.notifySaveFile(filePath, content);
                    savedCount++;
                }
            }
        }
    }

    /**
     * Close a tab by file path
     */
    public void closeTab(String filePath) {
        if (openEditors.containsKey(filePath)) {
            CodeEditorPanel editor = openEditors.get(filePath);
            int index = tabbedPane.indexOfComponent(editor);
            if (index != -1) {
                tabbedPane.remove(index);
                openEditors.remove(filePath);

                // Show welcome panel if no tabs are open
                if (openEditors.isEmpty()) {
                    addWelcomeTabIfNeeded();
                }
            }
        }
    }

    /**
     * Get the current active editor
     */
    public CodeEditorPanel getCurrentEditor() {
        Component comp = tabbedPane.getSelectedComponent();
        if (comp instanceof CodeEditorPanel) {
            return (CodeEditorPanel) comp;
        }
        return null;
    }

    /**
     * Get all file contents for export
     */
    public Map<String, String> getAllFileContents() {
        Map<String, String> contents = new HashMap<>();
        for (Map.Entry<String, CodeEditorPanel> entry : openEditors.entrySet()) {
            String filePath = entry.getKey();
            CodeEditorPanel editor = entry.getValue();
            if (editor != null) {
                contents.put(filePath, editor.getCode());
            }
        }
        return contents;
    }

    /**
     * Create a custom tab component with close button (X)
     */
    public Component createTabComponent(String title, String filePath) {
        JPanel tabComponent = new JPanel(new BorderLayout(5, 0));
        tabComponent.setOpaque(false);
        tabComponent.setBackground(Theme.STATUS_BAR_DARK.getColorSet());

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
        titleLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());

        JButton closeButton = new JButton("×");
        closeButton.setFont(new Font("Liberation Mono", Font.BOLD, 14));
        closeButton.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        closeButton.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
        closeButton.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));
        closeButton.setFocusable(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setOpaque(true);
        closeButton.setPreferredSize(new Dimension(20, 20));

        // Hover effect with better visibility
        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                closeButton.setBackground(new Color(200, 50, 50));
                closeButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                closeButton.setBackground(Theme.STATUS_BAR_DARK.getColorSet());
                closeButton.setForeground(Theme.FOREGROUND_DARK.getColorSet());
            }
        });

        closeButton.addActionListener(e -> closeTab(filePath));

        tabComponent.add(titleLabel, BorderLayout.WEST);
        tabComponent.add(closeButton, BorderLayout.EAST);

        return tabComponent;
    }

    /**
     * Find tab index by file path
     */
    public int findTabIndexByPath(String filePath) {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            Component comp = tabbedPane.getComponentAt(i);
            if (comp instanceof CodeEditorPanel) {
                if (openEditors.containsKey(filePath) && openEditors.get(filePath) == comp) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Create the welcome panel with a nice message
     */
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title
        JLabel titleLabel = new JLabel("Bienvenido a 3xtrat3rr3str3D Compiler");
        titleLabel.setFont(new Font("Liberation Mono", Font.BOLD, 24));
        titleLabel.setForeground(Theme.FOREGROUND_DARK.getColorSet());
        panel.add(titleLabel, gbc);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Abre un archivo desde el explorador para comenzar a editar");
        subtitleLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(180, 185, 195));
        panel.add(subtitleLabel, gbc);

        // Tips panel
        JPanel tipsPanel = new JPanel(new GridBagLayout());
        tipsPanel.setOpaque(false);

        String[] tips = {
                "Haz doble clic en un archivo para abrirlo",
                "Usa F2 para renombrar archivos y carpetas",
                "Click derecho para crear nuevos archivos o carpetas",
                "Arrastra el divisor para ajustar el tamaño del panel"
        };

        GridBagConstraints tipsGbc = new GridBagConstraints();
        tipsGbc.gridwidth = GridBagConstraints.REMAINDER;
        tipsGbc.anchor = GridBagConstraints.WEST;
        tipsGbc.insets = new Insets(4, 0, 4, 0);

        for (String tip : tips) {
            JLabel tipLabel = new JLabel("• " + tip);
            tipLabel.setFont(new Font("Liberation Mono", Font.PLAIN, 12));
            tipLabel.setForeground(new Color(160, 165, 175));
            tipsPanel.add(tipLabel, tipsGbc);
        }

        gbc.insets = new Insets(20, 10, 10, 10);
        panel.add(tipsPanel, gbc);

        return panel;
    }

    /**
     * Remove welcome tab if it exists
     */
    public void removeWelcomeTabIfExists() {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i).equals("Welcome")) {
                tabbedPane.removeTabAt(i);
                break;
            }
        }
    }

    /**
     * Check if welcome tab exists
     */
    public boolean welcomeTabExists() {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if (tabbedPane.getTitleAt(i).equals("Welcome")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add welcome tab if no tabs are open
     */
    public void addWelcomeTabIfNeeded() {
        if (openEditors.isEmpty() && !welcomeTabExists()) {
            tabbedPane.addTab("Welcome", welcomePanel);
            tabbedPane.setEnabledAt(tabbedPane.indexOfComponent(welcomePanel), false);
            tabbedPane.setSelectedComponent(welcomePanel);
        }
    }
}
