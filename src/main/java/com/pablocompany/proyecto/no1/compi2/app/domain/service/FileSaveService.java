package com.pablocompany.proyecto.no1.compi2.app.domain.service;

import com.pablocompany.proyecto.no1.compi2.app.domain.contex.EditorContext;
import java.awt.Component;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pablo03
 */
//This service uses fileChooser to save a file
public class FileSaveService {

    private static final String FILE_EXTENSION = "lat";
    private static final String FILE_DESCRIPTION = "Codex Latinus Source (*.lat)";

    public boolean saveFile(Component parent, EditorContext context) {
       /* if (context.getSourceCode() == null) {
            return false;
        }

        if (context.getSourceCode().isBlank()) {
            
            notifyMessage(
                        parent,
                        "El codigo fuente esta vacio",
                        "Codigo vacio",
                        JOptionPane.INFORMATION_MESSAGE
                );
            return false;
        }
*/
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Guardar código fuente Codex Latinus");
        chooser.setFileFilter(new FileNameExtensionFilter(FILE_DESCRIPTION, FILE_EXTENSION));

        int option = chooser.showSaveDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            if (!file.getName().toLowerCase().endsWith("." + FILE_EXTENSION)) {
                file = new File(file.getAbsolutePath() + "." + FILE_EXTENSION);
            }

            try {
                //Files.writeString(file.toPath(), context.getSourceCode());
                return true;
            } catch (Exception e) {
                notifyMessage(
                        parent,
                        "Error al guardar el archivo: " + e.getMessage(),
                        "Error I/O",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        return false;
    }

    public void notifyMessage(Component parent, String meessage, String tittle, int messageType) {
        JOptionPane.showMessageDialog(
                parent,
                meessage,
                tittle,
                messageType
        );
    }

}
