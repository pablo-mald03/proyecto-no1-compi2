package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.toast;

import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.PrincipalColors;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.theme.Theme;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pablo03
 */
//This class is the toast 
public class ToastNotification extends JDialog {

    public ToastNotification(JFrame parent, String message, boolean isError) {
        super(parent);
        setUndecorated(true); 
        setAlwaysOnTop(true);
        setFocusableWindowState(false); 

        Color bgColor = Theme.SURFACE_DARK.getColorSet();
        Color fgColor = Theme.FOREGROUND_DARK.getColorSet();
        Color accentColor = isError ? PrincipalColors.COLOR_ERROR.getColorSet() : PrincipalColors.COLOR_SUCCESS.getColorSet();

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bgColor);
        
        panel.setBorder(new CompoundBorder(
                BorderFactory.createLineBorder(Theme.BORDER_DARK.getColorSet(), 1),
                BorderFactory.createMatteBorder(0, 5, 0, 0, accentColor)
        ));

        JLabel label = new JLabel(message);
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label.setForeground(fgColor);
        label.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        
        panel.add(label, BorderLayout.CENTER);
        add(panel);
        pack();

        int x = parent.getX() + parent.getWidth() - getWidth() - 20;
        int y = parent.getY() + parent.getHeight() - getHeight() - 20;
        setLocation(x, y);

        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void show(JFrame parent, String message, boolean isError) {
        ToastNotification toast = new ToastNotification(parent, message, isError);
        toast.setVisible(true);
    }
}
