package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.errors;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.errors.ErrorsTable;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 *
 * @author pablo03
 */
//This clas can show the errors
public class ErrorsPanel extends JPanel {

    private final ErrorsTable errorsTable;

    public ErrorsPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());

        errorsTable = new ErrorsTable();

        JScrollPane scrollPane = new JScrollPane(errorsTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Theme.SIDEBAR_DARKT.getColorSet());

        add(scrollPane, BorderLayout.CENTER);
    }

    // Delegate the load errors action to the table
    public void loadErrors(List<CompilerError> errors) {
        errorsTable.loadErrors(errors);
    }

    //Delegate the clear 
    public void clear() {
        errorsTable.clear();
    }
}
