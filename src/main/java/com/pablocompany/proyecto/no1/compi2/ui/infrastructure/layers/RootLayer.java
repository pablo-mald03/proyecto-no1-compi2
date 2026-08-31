package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.layers;

import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.modals.ConfirmationContainer;

import javax.swing.*;

/**
 * Principal layered panel to show the modal and notifications on top
 * @author pablo03
 */
public class RootLayer extends JLayeredPane {

    private final JPanel contentPanel;
    private final ConfirmationContainer confirmationContainer;

    public RootLayer(
            JPanel contentPanel,
            ConfirmationContainer confirmationContainer
    ) {
        this.contentPanel = contentPanel;
        this.confirmationContainer = confirmationContainer;

        initialize();
    }

    /**
     * Initialize the layout with layers
     */
    private void initialize() {
        setLayout(null);

        // ==========================
        // Content - Bottom layer
        // ==========================
        add(contentPanel, JLayeredPane.DEFAULT_LAYER);

        // ==========================
        // Confirmation modal - Top layer
        // ==========================
        add(confirmationContainer, JLayeredPane.MODAL_LAYER);
    }

    @Override
    public void doLayout() {
        int width = getWidth();
        int height = getHeight();

        // Main application content
        contentPanel.setBounds(0, 0, width, height);
        // Confirmation modal overlay
        confirmationContainer.setBounds(0, 0, width, height);
    }
}
