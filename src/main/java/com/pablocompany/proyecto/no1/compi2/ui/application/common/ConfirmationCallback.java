package com.pablocompany.proyecto.no1.compi2.ui.application.common;

//This is a functional interface to execute the action
@FunctionalInterface
public interface ConfirmationCallback {

    void onResult(
            boolean confirmed
    );
}
