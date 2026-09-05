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
//This service uses fileChooser to open a file
public class FileOpenService {
    
    private static final String FILE_EXTENSION = "lat";
    private static final String FILE_DESCRIPTION = "Codex Latinus Source (*.lat)";

    public boolean openFile(Component parent, EditorContext context) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Abrir código fuente Codex Latinus");
        chooser.setFileFilter(new FileNameExtensionFilter(FILE_DESCRIPTION, FILE_EXTENSION));
        chooser.setAcceptAllFileFilterUsed(false);

        int option = chooser.showOpenDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                String content = Files.readString(file.toPath());
                //context.setSourceCode(content);
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                    parent,
                    "Error al leer el archivo: " + e.getMessage(),
                    "Error I/O",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return false;
    }
}
