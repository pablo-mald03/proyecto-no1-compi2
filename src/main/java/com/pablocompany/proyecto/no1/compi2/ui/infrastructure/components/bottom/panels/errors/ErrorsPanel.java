package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.errors;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;

import javax.swing.*;
import java.awt.*;
import java.util.List;
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
