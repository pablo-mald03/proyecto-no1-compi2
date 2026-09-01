/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.pablocompany.proyecto.no1.compi2.ui.frame;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.common.ConfirmationCallback;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ConfirmationNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ProgressCallback;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.editor.CodeEditorPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.modals.ConfirmationContainer;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.modals.ConfirmationManager;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.toast.ToastNotification;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums.ModalType;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.layers.RootLayer;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.screens.ManagementScreen;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.screens.WelcomeScreen;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.ProjectImporterExporterService;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.ProjectService;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Main frame with navigation between welcome and management screens
 * @author pablo03
 */
public class MainFrame extends JFrame implements WorkspaceNotifier, ConfirmationNotifier {

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel contentPanel = new JPanel(cardLayout);

    private WelcomeScreen welcomeScreen;
    private ManagementScreen managementScreen;

    // Confirmation system
    private final ConfirmationContainer confirmationContainer;
    private final ConfirmationManager confirmationManager;
    private String currentProjectName = "Project";

    // Root layer
    private RootLayer rootPanel;

    //Project I/O services
    private final ProjectService projectService;
    private final ProjectImporterExporterService projectImporterExporter;
    private File currentProjectDir;

    public MainFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Codex Compiler");
        setMinimumSize(new Dimension(1200, 800));
        setBackground(Theme.BACKGROUND_DARK.getColorSet());
        // ==========================
        // Export services Project Setup
        // ==========================
        this.projectService = new ProjectService();
        this.projectImporterExporter = new ProjectImporterExporterService();

        // ==========================
        // Confirmation System Setup
        // ==========================
        this.confirmationContainer = new ConfirmationContainer();
        this.confirmationManager = new ConfirmationManager(confirmationContainer);

        // ==========================
        // Initialize Screens
        // ==========================
        initializeScreens();

        // ==========================
        // Root Layer Setup
        // ==========================
        setupRootLayer();

        // ==========================
        // Final Setup
        // ==========================
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Called when a project is created
     */
    private void onProjectCreated(String projectName) {
        this.currentProjectName = projectName;

        // Create project directory in user home (cross-platform)
        String userHome = System.getProperty("user.home");
        File projectsDir = new File(userHome, "CodexProjects");
        if (!projectsDir.exists()) {
            projectsDir.mkdirs();
        }

        File projectDir = new File(projectsDir, projectName);
        try {
            projectService.createProject(projectName, projectsDir);
            this.currentProjectDir = projectDir;

            // Create management screen with callbacks
            managementScreen = createManagementScreen(projectName);
            contentPanel.remove(managementScreen);
            contentPanel.add(managementScreen, "MANAGEMENT");

            // Show management screen
            cardLayout.show(contentPanel, "MANAGEMENT");

            // Load project structure
            projectService.loadProjectFromDirectory(projectDir,
                    managementScreen.getWorkspacePanel().getFileTreePanel(),
                    projectName);

            alertToast("Proyecto '" + projectName + "' creado exitosamente", false);
        } catch (IOException e) {
            logError("Error al crear el proyecto: " + e.getMessage());
            alertToast("Error al crear el proyecto: " + e.getMessage(), true);
        }
    }

    /**
     * Called when a project is opened
     */
    private void onProjectOpened(File projectDir) {
        // Validate that it's a valid project
        if (!projectService.isValidProject(projectDir)) {
            alertToast("El directorio seleccionado no es un proyecto Codex válido", true);
            return;
        }

        this.currentProjectName = projectDir.getName();
        this.currentProjectDir = projectDir;

        // Create management screen with callbacks
        managementScreen = createManagementScreen(currentProjectName);
        contentPanel.remove(managementScreen);
        contentPanel.add(managementScreen, "MANAGEMENT");

        // Load project structure
        projectService.loadProjectFromDirectory(projectDir,
                managementScreen.getWorkspacePanel().getFileTreePanel(),
                currentProjectName);

        // Show management screen
        cardLayout.show(contentPanel, "MANAGEMENT");

        alertToast("Proyecto '" + currentProjectName + "' abierto exitosamente", false);
    }

    // ==========================================
    // CALLBACK METHODS FOR TOP PANEL
    // ==========================================

    private void onNewProject() {
        // Show welcome screen to create new project
        cardLayout.show(contentPanel, "WELCOME");
        if (welcomeScreen != null) {
            welcomeScreen.requestFocus();
        }
    }

    private void onOpenProject() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar proyecto");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File projectDir = fileChooser.getSelectedFile();
            onProjectOpened(projectDir);
        }
    }

    private void onCloseProject() {
        if (managementScreen != null) {
            // Confirm before closing
            confirm(ModalType.WARNING, "Cerrar Proyecto",
                    "¿Estas seguro que quieres cerrar el proyecto '" + currentProjectName + "'?\n" +
                            "Los cambios no guardados se perderán.",
                    confirmed -> {
                        if (confirmed) {
                            managementScreen = null;
                            currentProjectName = "Project";
                            cardLayout.show(contentPanel, "WELCOME");
                        }
                    }
            );
        }
    }

    private void onSave() {
        if (managementScreen != null) {
            CodeEditorPanel editor = managementScreen.getWorkspacePanel().getCurrentEditor();
            if (editor == null) {
                alertToast("No hay ningún archivo abierto para guardar", true);
            }

            managementScreen.getWorkspacePanel().saveCurrentFile();
        } else {
            alertToast("No hay ningún proyecto abierto", true);
        }
    }

    private void onSaveAs() {
        if (managementScreen != null) {
            logInfo("Guardar como...");
        } else {
            alertToast("No hay ningún proyecto abierto", true);
        }
    }

    private void onCompile() {
        if (managementScreen != null) {
            CodeEditorPanel editor = managementScreen.getWorkspacePanel().getCurrentEditor();
            if (editor != null) {
                logInfo("Compilando...");
            } else {
                alertToast("No hay ningún archivo abierto para compilar", true);
            }
        } else {
            alertToast("No hay ningún proyecto abierto", true);
        }
    }

    private void onExecute() {
        if (managementScreen != null) {
            CodeEditorPanel editor = managementScreen.getWorkspacePanel().getCurrentEditor();
            if (editor != null) {
                logInfo("Ejecutando...");
            } else {
                alertToast("No hay ningún archivo abierto para ejecutar", true);
            }
        } else {
            alertToast("No hay ningún proyecto abierto", true);
        }
    }

    private void onExit() {
        confirm(ModalType.WARNING, "Salir",
                "¿Estás seguro que quieres salir de Codex Compiler?",
                confirmed -> {
                    if (confirmed) {
                        System.exit(0);
                    }
                }
        );
    }

    private void onSaveAll() {
        if (managementScreen != null) {
            managementScreen.getWorkspacePanel().saveAllFiles();
        } else {
            alertToast("No hay ningún proyecto abierto", true);
        }
    }

    /**
     * Create a new management screen with all callbacks
     */
    private ManagementScreen createManagementScreen(String projectName) {
        return new ManagementScreen(
                this,
                this,
                projectName,
                this::onNewProject,
                this::onOpenProject,
                this::onCloseProject,
                this::onSave,
                this::onSaveAs,
                this::onCompile,
                this::onExecute,
                this::onExit,
                this::onSaveAll
        );
    }

    /**
     * Load project structure from directory
     */
    private void loadProjectFromDirectory(File projectDir) {
        // TODO: Implement loading of project structure
    }

    /**
     * Initialize the screens
     */
    private void initializeScreens() {
        // Welcome Screen
        welcomeScreen = new WelcomeScreen(
                this::onProjectCreated,
                this::onProjectOpened
        );

        // Management Screen (initially empty, will be recreated with project)
        managementScreen = createManagementScreen(currentProjectName);

        contentPanel.add(welcomeScreen, "WELCOME");
        contentPanel.add(managementScreen, "MANAGEMENT");
        contentPanel.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        // Show welcome screen by default
        cardLayout.show(contentPanel, "WELCOME");
    }

    /**
     * Setup the root layer with all components
     */
    private void setupRootLayer() {
        rootPanel = new RootLayer(
                contentPanel,
                confirmationContainer
        );

        setContentPane(rootPanel);
        rootPanel.setVisible(true);
        rootPanel.revalidate();
        rootPanel.repaint();
    }

    /**
     * Add a default project structure for new projects
     */
    private void addDefaultProjectStructure() {
        if (managementScreen != null) {
            var fileTree = managementScreen.getWorkspacePanel().getFileTreePanel();

            // Create default folders
            fileTree.createNewFile("src", true);
            fileTree.createNewFile("main", true, "src");
            fileTree.createNewFile("Main.z", false, "src/main");
            fileTree.createNewFile("utils", true, "src");
            fileTree.createNewFile("Helper.z", false, "src/utils");
            fileTree.createNewFile("config.y", false, "");
        }
    }

    // ==========================================
    // WORKSPACENOTIFIER IMPLEMENTATION
    // ==========================================
    @Override
    public void logInfo(String message) {
        if (managementScreen != null) {
            managementScreen.getBottomPanel().getConsole().appendInfo(message);
        } else {
            // Fallback cuando no hay managementScreen
            System.out.println("[INFO] " + message);
        }
    }

    @Override
    public void logSuccess(String message) {
        if (managementScreen != null) {
            managementScreen.getBottomPanel().getConsole().appendSuccess(message);
        } else {
            System.out.println("[SUCCESS] " + message);
        }
    }

    @Override
    public void logError(String message) {
        if (managementScreen != null) {
            managementScreen.getBottomPanel().getConsole().appendError(message);
        } else {
            System.out.println("[ERROR] " + message);
        }
    }

    @Override
    public void alertToast(String message, boolean isError) {
        ToastNotification.show(this, message, isError);
    }

    @Override
    public void focusConsole() {
        if (managementScreen != null) {
            managementScreen.getBottomPanel().showConsole();
        }
    }

    @Override
    public void focusErrors() {
        if (managementScreen != null) {
            managementScreen.getBottomPanel().showErrors();
        }
    }

    @Override
    public void focusSymbolsTable() {
        if (managementScreen != null) {
            managementScreen.getBottomPanel().showSymbolsTable();
        }
    }


    @Override
    public void clearLogs() {
        if (managementScreen != null) {
            managementScreen.getBottomPanel().getConsole().clear();
            managementScreen.getBottomPanel().getErrors().clear();
        }
    }

    @Override
    public void notifyErrorsUpdated(List<CompilerError> compilerErrors) {
        // Implementation
    }

    @Override
    public void notifyCompiledCode(String compiledCode) {
        // Implementation
    }

    @Override
    public void notifyImportProject() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar proyecto desde ZIP");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("ZIP files", "zip"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File zipFile = fileChooser.getSelectedFile();

            // Select target directory
            JFileChooser dirChooser = new JFileChooser();
            dirChooser.setDialogTitle("Seleccionar directorio de destino");
            dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            dirChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

            int dirResult = dirChooser.showSaveDialog(this);
            if (dirResult == JFileChooser.APPROVE_OPTION) {
                File targetDir = dirChooser.getSelectedFile();

                try {
                    // Show progress in console
                    logInfo("Importando proyecto desde: " + zipFile.getName());

                    projectImporterExporter.importFromZip(zipFile, targetDir,
                            new ProgressCallback() {
                                @Override
                                public void onProgress(int current, int total, String fileName) {
                                    if (current % 10 == 0 || current == total) {
                                        logInfo("Progreso: " + current + "/" + total + " archivos");
                                    }
                                }

                                @Override
                                public void onComplete() {
                                    logSuccess("Importación completada");
                                }
                            });

                    // Open the imported project
                    onProjectOpened(targetDir);

                } catch (IOException e) {
                    logError("Error al importar el proyecto: " + e.getMessage());
                    alertToast("Error al importar el proyecto: " + e.getMessage(), true);
                }
            }
        }
    }


    @Override
    public void notifyDownloadCompiledCode() {
        if (managementScreen != null && currentProjectDir != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Exportar proyecto");
            fileChooser.setSelectedFile(new File(currentProjectName + ".zip"));

            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File zipFile = fileChooser.getSelectedFile();
                // Ensure .zip extension
                if (!zipFile.getName().toLowerCase().endsWith(".zip")) {
                    zipFile = new File(zipFile.getParentFile(), zipFile.getName() + ".zip");
                }

                try {
                    projectImporterExporter.exportToZip(currentProjectDir, zipFile);
                    logSuccess("Proyecto exportado exitosamente a: " + zipFile.getPath());
                    alertToast("Proyecto exportado exitosamente", false);
                } catch (IOException e) {
                    logError("Error al exportar el proyecto: " + e.getMessage());
                    alertToast("Error al exportar el proyecto: " + e.getMessage(), true);
                }
            }
        } else {
            alertToast("No hay ningún proyecto abierto para exportar", true);
        }
    }

    @Override
    public void notifyExecuteCompiledCode() {
        if (managementScreen != null) {
            CodeEditorPanel editor = managementScreen.getWorkspacePanel().getCurrentEditor();
            if (editor != null) {
                // TODO: Implement execute compiled code logic
                logInfo("Ejecutando código compilado...");
            } else {
                alertToast("No hay ningún archivo abierto para ejecutar", true);
            }
        } else {
            alertToast("No hay ningún proyecto abierto", true);
        }
    }

    @Override
    public void notifySaveFile(String filePath, String content) {
        if (currentProjectDir != null) {
            try {
                projectService.saveFileContent(filePath, content, currentProjectDir);
            } catch (IOException e) {
                alertToast("Error al guardar el archivo: " + e.getMessage(), true);
            }
        } else {
            alertToast("No hay ningún proyecto abierto para guardar", true);
        }
    }

    /**
     * Save all files
     *
     */
    public void notifySaveAllFiles() {
        if (managementScreen != null) {
            managementScreen.getWorkspacePanel().saveAllFiles();
        } else {
            alertToast("No hay ningún proyecto abierto", true);
        }
    }

    @Override
    public void notifyFileOpened(String filePath, String content, String extension) {

    }


    // ==========================================
    // CONFIRMATION NOTIFIER IMPLEMENTATION
    // ==========================================
    @Override
    public void confirm(ModalType type, String title, String message, ConfirmationCallback callback) {
        confirmationManager.confirm(type, title, message, callback);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        mainContainer = new javax.swing.JPanel();
        verticalSplit = new javax.swing.JSplitPane();
        topPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        editorPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Codex Compiler");
        setBackground(new java.awt.Color(220, 229, 196));
        setMinimumSize(new java.awt.Dimension(1400, 900));

        mainPanel.setBackground(new java.awt.Color(225, 221, 166));
        mainPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        mainPanel.setLayout(new java.awt.BorderLayout());

        mainContainer.setBorder(new javax.swing.border.MatteBorder(null));
        mainContainer.setRequestFocusEnabled(false);
        mainContainer.setLayout(new java.awt.BorderLayout());

        verticalSplit.setBackground(new java.awt.Color(0, 0, 0));
        verticalSplit.setBorder(new javax.swing.border.MatteBorder(null));
        verticalSplit.setDividerLocation(600);
        verticalSplit.setDividerSize(4);
        verticalSplit.setForeground(new java.awt.Color(0, 0, 0));
        verticalSplit.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        verticalSplit.setLastDividerLocation(600);
        verticalSplit.setPreferredSize(new java.awt.Dimension(252, 251));

        topPanel.setMinimumSize(new java.awt.Dimension(600, 100));
        topPanel.setPreferredSize(new java.awt.Dimension(600, 100));
        topPanel.setLayout(new java.awt.BorderLayout());
        verticalSplit.setTopComponent(topPanel);

        bottomPanel.setBackground(new java.awt.Color(220, 229, 196));
        bottomPanel.setMinimumSize(new java.awt.Dimension(400, 100));
        bottomPanel.setPreferredSize(new java.awt.Dimension(400, 100));

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1406, Short.MAX_VALUE)
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        verticalSplit.setBottomComponent(bottomPanel);

        editorPanel.setBackground(new java.awt.Color(153, 255, 255));
        editorPanel.setPreferredSize(new java.awt.Dimension(800, 599));

        javax.swing.GroupLayout editorPanelLayout = new javax.swing.GroupLayout(editorPanel);
        editorPanel.setLayout(editorPanelLayout);
        editorPanelLayout.setHorizontalGroup(
            editorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1406, Short.MAX_VALUE)
        );
        editorPanelLayout.setVerticalGroup(
            editorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        verticalSplit.setLeftComponent(editorPanel);

        mainContainer.add(verticalSplit, java.awt.BorderLayout.CENTER);

        mainPanel.add(mainContainer, java.awt.BorderLayout.CENTER);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //This method redirect to the errors
    private void reportMenu2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        focusErrors();
    }

    private void reportMenu1ActionPerformed(java.awt.event.ActionEvent evt) {
        focusSymbolsTable();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel editorPanel;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JSplitPane verticalSplit;
    // End of variables declaration//GEN-END:variables



}
