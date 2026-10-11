package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.workspace;

import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ConfirmationNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.dialogs.CustomInputDialog;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileNode;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.FileTreePanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums.ModalType;
import lombok.Getter;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Service responsible for file and directory CRUD operations in the workspace tree.
 *
 * @author pablo03
 */
@Getter
public class WorkspaceFileService {

    private final Component parentComponent;
    private final FileTreePanel fileTreePanel;
    private final WorkspaceEditorService editorService;
    private final WorkspaceNotifier notifier;
    private final ConfirmationNotifier confirmationNotifier;

    public WorkspaceFileService(
            Component parentComponent,
            FileTreePanel fileTreePanel,
            WorkspaceEditorService editorService,
            WorkspaceNotifier notifier,
            ConfirmationNotifier confirmationNotifier
    ) {
        this.parentComponent = parentComponent;
        this.fileTreePanel = fileTreePanel;
        this.editorService = editorService;
        this.notifier = notifier;
        this.confirmationNotifier = confirmationNotifier;
    }

    /**
     * Create a new file with the specified extension
     */
    public void createNewFileWithExtension(String extension) {
        String parentPath = fileTreePanel.getSelectedParentPath();

        String baseName = CustomInputDialog.showInputDialog(
                parentComponent,
                "Crear Nuevo Archivo",
                "Ingresa el nombre del archivo (sin extension):"
        );

        if (baseName == null || baseName.trim().isEmpty()) {
            return;
        }

        baseName = baseName.trim();

        // Check if user tried to add extension manually
        if (baseName.contains(".")) {
            notifier.alertToast("Porfavor no escribas la extension. Esta se coloca automatica.", true);
            return;
        }

        String fullName = baseName + extension;
        String finalPath = parentPath.isEmpty() ? fullName : parentPath + "/" + fullName;

        // Check if file exists and generate unique name
        int counter = 1;
        String originalName = baseName;
        while (fileTreePanel.getFileNodes().containsKey(finalPath)) {
            fullName = originalName + counter + extension;
            finalPath = parentPath.isEmpty() ? fullName : parentPath + "/" + fullName;
            counter++;

            if (counter > 100) break;
        }

        // Create the file in the tree
        fileTreePanel.createNewFile(fullName, false, parentPath.isEmpty() ? null : parentPath);

        // Open the new file in an editor tab
        FileNode fileNode = new FileNode(fullName, false);
        fileNode.setFilePath(finalPath);
        editorService.openFileInTab(fileNode);
    }

    /**
     * Create a new folder
     */
    public void createNewFolder() {
        String parentPath = fileTreePanel.getSelectedParentPath();

        String folderName = CustomInputDialog.showInputDialog(
                parentComponent,
                "Crear nuevo Folder",
                "Ingresa el nombre del folder:"
        );

        if (folderName == null || folderName.trim().isEmpty()) {
            return;
        }

        folderName = folderName.trim();

        if (folderName.contains(".")) {
            notifier.alertToast("Los nombre de los folders no deberian tener extension.", true);
            return;
        }

        String finalPath = parentPath.isEmpty() ? folderName : parentPath + "/" + folderName;

        int counter = 1;
        String originalName = folderName;
        while (fileTreePanel.getFileNodes().containsKey(finalPath)) {
            folderName = originalName + counter;
            finalPath = parentPath.isEmpty() ? folderName : parentPath + "/" + folderName;
            counter++;

            if (counter > 100) break;
        }

        fileTreePanel.createNewFile(folderName, true, parentPath.isEmpty() ? null : parentPath);
    }

    /**
     * Rename the selected node in the file tree
     */
    public void renameSelectedNode() {
        DefaultMutableTreeNode node = fileTreePanel.getSelectedNode();
        if (node == null) {
            return;
        }

        Object userObj = node.getUserObject();
        if (!(userObj instanceof FileNode fileNode)) {
            return;
        }

        String currentName = fileNode.getName();
        String oldPath = fileNode.getFilePath();

        String newName = CustomInputDialog.showInputDialog(
                parentComponent,
                "Renombrar",
                "Ingresa el nuevo nombre:",
                currentName
        );

        if (newName == null || newName.trim().isEmpty()) {
            return;
        }

        newName = newName.trim();

        // For files, check if extension is included
        if (!fileNode.isDirectory()) {
            String currentExtension = "";
            int dotIndex = currentName.lastIndexOf('.');
            if (dotIndex != -1) {
                currentExtension = currentName.substring(dotIndex);
            }

            if (!newName.contains(".") && !currentExtension.isEmpty()) {
                newName = newName + currentExtension;
            } else if (newName.contains(".") && !newName.endsWith(currentExtension)) {
                if (!currentExtension.isEmpty()) {
                    String newExtension = newName.substring(newName.lastIndexOf('.'));
                    if (!newExtension.equals(currentExtension)) {
                        notifier.alertToast("No se puede cambiar la extension del archivo.", true);
                        return;
                    }
                }
            }
        } else {
            if (newName.contains(".")) {
                notifier.alertToast("Los folder no deberian tener extension.", true);
                return;
            }
        }

        String newPath = oldPath.substring(0, oldPath.lastIndexOf('/') + 1) + newName;
        if (oldPath.equals(newPath)) {
            return;
        }

        if (fileTreePanel.getFileNodes().containsKey(newPath)) {
            notifier.alertToast("Ya existe un archivo con este nombre.", true);
            return;
        }

        // Update the file node
        FileNode newFileNode = new FileNode(newName, fileNode.isDirectory());
        newFileNode.setFilePath(newPath);
        node.setUserObject(newFileNode);

        // Update maps in tree
        fileTreePanel.getFileNodes().remove(oldPath);
        fileTreePanel.getFileNodes().put(newPath, node);

        // Update tabs if file is open
        editorService.handleFileRenamed(oldPath, newPath, newName);

        fileTreePanel.reloadTree();
    }

    /**
     * Delete the selected node using the ConfirmationNotifier system
     */
    public void deleteSelectedNode() {
        DefaultMutableTreeNode node = fileTreePanel.getSelectedNode();
        if (node == null) {
            return;
        }

        Object userObj = node.getUserObject();
        if (!(userObj instanceof FileNode fileNode)) {
            return;
        }

        if (node == fileTreePanel.getRootNode()) {
            notifier.logError("No se puede eliminar el proyecto raiz");
            return;
        }

        String type = fileNode.isDirectory() ? "folder" : "archivo";

        confirmationNotifier.confirm(
                ModalType.WARNING,
                "Confirmar eliminacion",
                "Estas seguro que quieres eliminar el " + type + ": " + fileNode.getName() + " ?",
                confirmed -> {
                    if (confirmed) {
                        String filePath = fileNode.getFilePath();

                        if (!fileNode.isDirectory() && editorService.isOpen(filePath)) {
                            editorService.closeTab(filePath);
                        }

                        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
                        if (parent != null) {
                            parent.remove(node);
                            fileTreePanel.getFileNodes().remove(filePath);
                            fileTreePanel.reloadTree();
                        }
                    }
                }
        );
    }
}
