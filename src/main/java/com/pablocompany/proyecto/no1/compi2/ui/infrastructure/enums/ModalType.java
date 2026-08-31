package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.enums;

//This is the principal enum modal to show any message
public enum ModalType {

    SUCCESS(4000),
    ERROR(3000),
    WARNING(6000),
    INFO(4000),
    NONE(0);

    private final int duration;

    ModalType(int duration) {

        this.duration = duration;
    }

    public int getDuration() {

        return duration;
    }
}