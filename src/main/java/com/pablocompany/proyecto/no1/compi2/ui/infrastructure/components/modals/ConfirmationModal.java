package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.modals;



import com.pablocompany.proyecto.no1.compi2.ui.application.common.ConfirmationCallback;
import com.pablocompany.proyecto.no1.compi2.ui.domain.TextConstants;
import com.pablocompany.proyecto.no1.compi2.ui.domain.UIColors;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.utils.FormButton;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums.ModalType;

import javax.swing.*;
import java.awt.*;

//This is the class to show the confirmation modal
public class ConfirmationModal extends JPanel {

    private final JLabel iconLabel;
    private final JLabel titleLabel;
    private final JLabel messageLabel;

    private final FormButton cancelButton;
    private final FormButton confirmButton;

    private ModalType type;

    private ConfirmationCallback callback;

    public ConfirmationModal() {

        iconLabel = new JLabel();

        titleLabel = new JLabel();

        messageLabel = new JLabel();

        cancelButton = new FormButton("Cancelar",
                UIColors.DECLINE_ACCENT_BUTTON,
                UIColors.DECLINE_ACCENT_HOVER_BUTTON,
                UIColors.DECLINE_MODULE_SELECTED_BUTTON,
                UIColors.DECLINE_BORDER_BUTTON,
                UIColors.TEXT_PRIMARY_BUTTON_LIGHT);

        confirmButton = new FormButton("Confirmar",
                UIColors.ACCEPT_ACCENT_BUTTON,
                UIColors.ACCEPT_ACCENT_HOVER_BUTTON,
                UIColors.ACCEPT_MODULE_SELECTED_BUTTON,
                UIColors.ACCEPT_BORDER_BUTTON,
                UIColors.TEXT_PRIMARY_BUTTON_LIGHT);

        initialize();
    }

    //Method to initialize the confirmation modal
    private void initialize() {

        setLayout(new BorderLayout(15, 15));

        setOpaque(true);

        setBackground(UIColors.SURFACE.getColorSet());

        setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(UIColors.BORDER.getColorSet()),
                        BorderFactory.createEmptyBorder(20, 20, 20, 20))
        );

        configureLabels();

        JPanel header = createHeader();

        JPanel buttons = createButtons();

        add(header, BorderLayout.NORTH);

        add(messageLabel, BorderLayout.CENTER);

        add(buttons, BorderLayout.SOUTH);

        cancelButton.addActionListener(event -> resolve(false));

        confirmButton.addActionListener(event -> resolve(true));
    }

    //This method returns the decision
    private void resolve(boolean confirmed) {

        if (callback != null) {

            ConfirmationCallback action =
                    callback;

            callback = null;

            action.onResult(
                    confirmed
            );
        }
    }

    //Method to create the header
    private JPanel createHeader() {

        JPanel panel =
                new JPanel(
                        new BorderLayout(
                                12,
                                0
                        )
                );

        panel.setOpaque(false);

        panel.add(
                iconLabel,
                BorderLayout.WEST
        );

        panel.add(
                titleLabel,
                BorderLayout.CENTER
        );

        return panel;
    }

    //Method to configurate the labels
    private void configureLabels() {

        titleLabel.setFont(
                new Font(
                        "Liberation Mono",
                        Font.BOLD,
                        TextConstants.SMALL_EMPHASIS_TEXT.getSize()
                )
        );

        titleLabel.setForeground(
                UIColors.TEXT_PRIMARY.getColorSet()
        );

        messageLabel.setFont(
                new Font(
                        "Liberation Mono",
                        Font.PLAIN,
                        TextConstants.SMALL_NORMAL_TEXT.getSize()
                )
        );

        messageLabel.setForeground(
                UIColors.TEXT_SECONDARY.getColorSet()
        );
    }

    //Method to create the buttons
    private JPanel createButtons() {

        JPanel panel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                10,
                                0
                        )
                );

        panel.setOpaque(false);

        panel.add(
                cancelButton
        );

        panel.add(
                confirmButton
        );

        return panel;
    }

    //This is the principal utilizable method to set the modal type
    public void configure(ModalType type, String title, String message, ConfirmationCallback callback) {

        this.type =
                type;

        this.callback =
                callback;

        titleLabel.setText(
                title
        );

        messageLabel.setText(
                "<html>"
                        + "<div style='width:380px;'>"
                        + message
                        + "</div>"
                        + "</html>"
        );

        configureType(
                type
        );
    }

    //This method configure the modal type
    private void configureType(ModalType type) {

        switch (type) {

            case WARNING:

                confirmButton.setBackground(
                        UIColors.WARNING_BACKGROUND.getColorSet()
                );

                break;

            case ERROR:

                confirmButton.setBackground(
                        UIColors.ERROR_BACKGROUND.getColorSet()
                );

                break;

            case SUCCESS:

                confirmButton.setBackground(
                        UIColors.SUCCESS_BACKGROUND.getColorSet()
                );

                break;

            case INFO:

                confirmButton.setBackground(
                        UIColors.INFO_BACKGROUND.getColorSet()
                );

                break;
        }
    }

}