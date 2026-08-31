package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.modals;


import com.pablocompany.proyecto.no1.compi2.ui.application.common.ConfirmationCallback;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ConfirmationNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums.ModalType;

//This is the principal confirmation manager of the modal
public class ConfirmationManager implements ConfirmationNotifier {

    private final ConfirmationContainer container;

    public ConfirmationManager(ConfirmationContainer container) {

        this.container = container;
    }

    @Override
    public void confirm(ModalType type, String title, String message, ConfirmationCallback callback) {

        ConfirmationModal modal = new ConfirmationModal();

        modal.configure(type, title, message, confirmed -> {

            container.removeModal(modal);

            callback.onResult(confirmed);
        });

        container.showModal(modal);
    }
}