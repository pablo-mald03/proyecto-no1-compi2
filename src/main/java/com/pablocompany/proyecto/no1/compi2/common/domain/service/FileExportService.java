/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablocompany.proyecto.no1.compi2.common.domain.service;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.nio.file.Files;

/**
 *
 * @author pablo03
 */
public class FileExportService {
    
    private static final String DEFAULT_EXTENSION = "pig";
    private static final String EXTENSION_DESCRIPTION = "Pig Latin Target (*.pig)";

    public boolean exportCompiledCode(Component parent, EditorContext context) {
        //String compiledCode = context.getCompiledCode();
        String compiledCode = "";

        if (compiledCode == null || compiledCode.isBlank()) {
            JOptionPane.showMessageDialog(
                parent,
                "No hay código compilado disponible para exportar.\nEjecute la compilación primero.",
                "Exportación no disponible",
                JOptionPane.WARNING_MESSAGE
            );
            return false;
        }

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Exportar código Pig Latin");
        chooser.setFileFilter(new FileNameExtensionFilter(EXTENSION_DESCRIPTION, DEFAULT_EXTENSION));

        int option = chooser.showSaveDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            if (!file.getName().toLowerCase().endsWith("." + DEFAULT_EXTENSION)) {
                file = new File(file.getAbsolutePath() + "." + DEFAULT_EXTENSION);
            }

            try {
                Files.writeString(file.toPath(), compiledCode);
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    parent,
                    "Error al exportar el código compilado: " + e.getMessage(),
                    "Error I/O",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return false;
    }
}
