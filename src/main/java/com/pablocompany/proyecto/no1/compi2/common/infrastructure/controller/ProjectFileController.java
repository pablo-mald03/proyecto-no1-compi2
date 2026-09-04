
package com.pablocompany.practica.no1.compi2.infrastructure.controller;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.service.FileExportService;
import com.pablocompany.proyecto.no1.compi2.common.domain.service.FileOpenService;
import com.pablocompany.proyecto.no1.compi2.common.domain.service.FileSaveService;

import java.awt.*;

/**
 *
 * @author pablo03
 */
public class ProjectFileController {
    
    private final FileOpenService openService;
    private final FileSaveService saveService;
    private final FileExportService exportService;

    public ProjectFileController() {
        this.openService = new FileOpenService();
        this.saveService = new FileSaveService();
        this.exportService = new FileExportService();
    }

    public void handleOpen(Component parent, EditorContext context, Runnable onFileLoaded) {
        if (openService.openFile(parent, context)) {
            if (onFileLoaded != null) {
                onFileLoaded.run();
            }
        }
    }

    public void handleSave(Component parent, EditorContext context) {
        saveService.saveFile(parent, context);
    }

    public void handleExport(Component parent, EditorContext context) {
        exportService.exportCompiledCode(parent, context);
    }
}
