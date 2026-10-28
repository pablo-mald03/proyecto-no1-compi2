package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.quadruples;

import com.pablocompany.proyecto.no1.compi2.codegen.domain.parents.IntermediateProgram;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;

import javax.swing.*;
import java.awt.*;

/**
 * Panel container for the quadruples table in the bottom tabbed view.
 *
 * @author pablo03
 */
public class QuadruplesPanel extends JPanel {

    private final QuadruplesTable quadruplesTable;

    public QuadruplesPanel() {
        setLayout(new BorderLayout());
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());

        quadruplesTable = new QuadruplesTable();

        JScrollPane scrollPane = new JScrollPane(quadruplesTable);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Theme.SIDEBAR_DARKT.getColorSet());

        add(scrollPane, BorderLayout.CENTER);
    }

    public void loadProgram(IntermediateProgram program) {
        quadruplesTable.loadProgram(program);
    }

    public void clear() {
        quadruplesTable.clear();
    }

    public QuadruplesTable getTable() {
        return quadruplesTable;
    }
}
