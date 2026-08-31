package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.modals;

import javax.swing.*;
import java.awt.*;

//The class to show the confirmation modal
public class ConfirmationContainer extends JPanel {

    private ConfirmationModal currentModal;

    public ConfirmationContainer() {

        setOpaque(false);

        setLayout(new GridBagLayout());

        setVisible(false);
    }

    //This method show the modal confirmation
    public void showModal(ConfirmationModal modal) {

        removeAll();

        currentModal = modal;

        add(modal);

        setVisible(true);

        revalidate();
        repaint();
    }
    //This method remove the modal confirmation
    public void removeModal(ConfirmationModal modal) {

        if (currentModal != modal) {
            return;
        }

        remove(modal);

        currentModal = null;

        setVisible(false);

        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D graphics =
                (Graphics2D) g.create();

        graphics.setColor(
                new Color(
                        0,
                        0,
                        0,
                        110
                )
        );

        graphics.fillRect(
                0,
                0,
                getWidth(),
                getHeight()
        );

        graphics.dispose();

        super.paintComponent(
                g
        );
    }
}