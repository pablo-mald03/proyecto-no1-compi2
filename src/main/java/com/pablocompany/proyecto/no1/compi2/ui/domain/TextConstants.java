package com.pablocompany.proyecto.no1.compi2.ui.domain;


//This is the principal constats to manage the different sizes of the texts
public enum TextConstants {

    TITTLE_TEXT(20),
    SUBTITLE_TEXT(18),
    ROLE_LABEL(18),

    EMPHASIS_TEXT(18),
    NORMAL_TEXT(16),

    SMALL_EMPHASIS_TEXT(14),
    SMALL_NORMAL_TEXT(12),

    ADVISE_TEXT(14);


    private final int size;

    TextConstants(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
