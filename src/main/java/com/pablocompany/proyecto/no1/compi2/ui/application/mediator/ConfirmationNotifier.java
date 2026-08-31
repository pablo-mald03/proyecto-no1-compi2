package com.pablocompany.proyecto.no1.compi2.ui.application.mediator;

import com.pablocompany.proyecto.no1.compi2.ui.application.common.ConfirmationCallback;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums.ModalType;

//Principal interface to call the confirmation notifier
public interface ConfirmationNotifier {
    void confirm(ModalType type, String title, String message, ConfirmationCallback callback);
}