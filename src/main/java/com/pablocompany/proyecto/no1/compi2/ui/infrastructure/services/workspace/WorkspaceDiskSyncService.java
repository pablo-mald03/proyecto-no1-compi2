package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace;

import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileNode;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileTreePanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.io.ProjectDiskWatcher;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.io.ProjectService;
import lombok.RequiredArgsConstructor;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Keeps the workspace tree in sync with changes made outside the IDE
 *
 * @author pablo03
 */
@RequiredArgsConstructor
public class WorkspaceDiskSyncService {

    private final FileTreePanel fileTreePanel;
    private final WorkspaceEditorService editorService;
    private final WorkspaceCompilationService compilationService;
    private final WorkspaceNotifier notifier;

    private ProjectService projectService;
    private File projectRoot;
    private ProjectDiskWatcher watcher;

    /**
     * Method to start the watcher
     *
     */
    public void start(File root, ProjectService service) {
        stop();
        this.projectRoot = root;
        this.projectService = service;
        this.watcher = new ProjectDiskWatcher(service, this::reconcile);
        this.watcher.start(root);
    }

    /**
     * Method to stop the watcher
     *
     */
    public void stop() {
        if (watcher != null) {
            watcher.stop();
            watcher = null;
        }
        projectRoot = null;
    }

    /**
     * Method to reconcile the project root
     *
     */
    private void reconcile(Set<String> snapshot) {
        if (projectRoot == null) return;

        Path root = projectRoot.toPath();
        if (!Files.isDirectory(root)) {
            notifier.logWarning("La carpeta del proyecto no esta disponible: " + root);
            return;
        }

        Map<String, DefaultMutableTreeNode> nodes = fileTreePanel.getFileNodes();

        List<String> removed = nodes.keySet().stream()
                .filter(path -> !snapshot.contains(path))
                .filter(path -> Files.notExists(root.resolve(path)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        List<String> added = snapshot.stream()
                .filter(path -> !nodes.containsKey(path))
                .filter(path -> Files.exists(root.resolve(path)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        removed.forEach(this::applyRemoved);
        added.forEach(this::applyAdded);

        if (!removed.isEmpty() || !added.isEmpty()) {
            notifier.logInfo("Workspace sincronizado con el disco");
        }
    }

    /**
     * Method to apply the removed action
     *
     */
    private void applyRemoved(String path) {
        if (!fileTreePanel.getFileNodes().containsKey(path)) return;

        editorService.closeTabsUnder(path);
        compilationService.handlePathRemoved(path);
        fileTreePanel.removeSubtree(path);
        notifier.logWarning("Eliminado fuera del IDE: " + path);
    }

    /**
     * Method to apply the added folder/file
     *
     */
    private void applyAdded(String path) {
        boolean isDirectory = Files.isDirectory(projectRoot.toPath().resolve(path));
        FileNode fileNode = fileTreePanel.addNodeFromDisk(path, isDirectory);

        if (fileNode != null && !isDirectory) {
            try {
                projectService.getFileContent(fileNode, projectRoot);
            } catch (IOException e) {
                notifier.logError("No se pudo leer " + path + ": " + e.getMessage());
            }
        }
    }
}