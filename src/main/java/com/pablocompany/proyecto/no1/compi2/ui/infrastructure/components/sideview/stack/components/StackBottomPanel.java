package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.sideview.stack.components;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.panels.console.ConsolePanel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author pablo03
 */
//This is the principal panel to show the stack logs
public class StackBottomPanel extends JPanel {

    private final JPanel consoleWrapper;
    private final ConsolePanel stackLogConsole;

    public StackBottomPanel() {

        setLayout(new BorderLayout());

        stackLogConsole = new ConsolePanel();

        consoleWrapper = new JPanel(new BorderLayout());
        consoleWrapper.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        Border lineBorder = BorderFactory.createLineBorder(Theme.SIDEBAR_LIGHT.getColorSet());
        
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                lineBorder,
                "Salida de Procesos",
                TitledBorder.DEFAULT_POSITION,
                TitledBorder.DEFAULT_JUSTIFICATION,
                new Font("Liberation Mono", Font.BOLD, 12),
                Theme.FOREGROUND_DARK.getColorSet()
        );

        CompoundBorder paddedBorder = BorderFactory.createCompoundBorder(
                new EmptyBorder(6, 6, 6, 6), 
                titledBorder
        );

        consoleWrapper.setBorder(paddedBorder);
        consoleWrapper.add(stackLogConsole, BorderLayout.CENTER);

        add(consoleWrapper, BorderLayout.CENTER);
    }

    public ConsolePanel getStackLogConsole() {
        return stackLogConsole;
    }
    
    

}
