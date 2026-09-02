package com.pablocompany.proyecto.no1.compi2.ui.domain;

import java.awt.*;

/**
 *
 * @author pablo03
 */
//This is the principal palette theme
public enum UIColors {

    // ==========================
    // Base
    // ==========================
    BACKGROUND(new Color(237, 214, 192)),
    FIELDS_BACKGROUND(new Color(209, 237, 227)),
    SURFACE(new Color(5, 93, 99)),
    // ==========================
    // Sidebar
    // ==========================

    SIDEBAR_BACKGROUND(new Color(31, 41, 55)),
    SIDEBAR_SECTION(new Color(39, 50, 65)),
    // ==========================
    // Module
    // ==========================

    MODULE_NORMAL(new Color(39, 50, 65)),
    MODULE_HOVER(new Color(55, 69, 88)),
    MODULE_SELECTED(new Color(110, 4, 146)),
    MODULE_DISABLED(new Color(75, 85, 99)),
    // ==========================
    // Deactivate text field constants
    // ==========================

    VIEW_MODE_BACKGROUND(new Color(43, 40, 35)),
    VIEW_MODE_FOREGROUND(new Color(87, 86, 86)),
    VIEW_MODE_BORDER(new Color(175, 156, 140, 255)),


    // ==========================
    // Switch
    // ==========================
    VIEW_ON_COLOR(new Color(76, 175, 80)),
    VIEW_OFF_COLOR(new Color(158, 158, 158)),
    VIEW_ON_BG(new Color(232, 245, 233)),
    VIEW_OFF_BG(new Color(245, 245, 245)),


    // ==========================
    // Text
    // ==========================

    TEXT_PRIMARY_HEADER(new Color(239, 238, 231)),
    TEXT_PRIMARY_BUTTON_DARK(new Color(36, 5, 57)),
    TEXT_PRIMARY_BUTTON_LIGHT(new Color(212, 210, 212)),

    TEXT_SECONDARY_TOAST(new Color(230, 229, 229)),

    TEXT_PRIMARY(new Color(8, 8, 48)),
    TEXT_SECONDARY(new Color(246, 178, 31)),
    SIDEBAR_TEXT(new Color(243, 244, 246)),
    SIDEBAR_TEXT_SECONDARY(new Color(209, 213, 219)),
    // ==========================
    // Accent
    // ==========================

    ACCENT(new Color(223, 148, 7)),
    ACCENT_HOVER(new Color(196, 160, 13)),
    // ==========================
    // Borders
    // ==========================

    SURFACE_VARIANT(new Color(194, 243, 226)),

    BORDER(new Color(64, 6, 60)),
    BACKGROUND_HOVER(new Color(7, 187, 171)),

    //ERROR
    ERROR(new Color(171, 36, 14)),

    //TABLE THEME
    HEADER_COLUMN(new Color(230, 81, 125)),
    ROWS_BACKGROUND(new Color(197, 239, 228)),
    TABLE_BORDER(new Color(2, 12, 21)),
    SELECTED_FIELD(new Color(129, 176, 248)),

    //TOAST CONFIG
    SUCCESS_BACKGROUND(new Color(39, 152, 7)),
    SUCCESS_TOAST(new Color(21, 235, 21)),
    INFO_BACKGROUND(new Color(54, 147, 241)),
    INFO_TOAST(new Color(221, 193, 9)),
    WARNING_BACKGROUND(new Color(164, 132, 4)),
    WARNING_TOAST(new Color(12, 0, 0)),
    ERROR_BACKGROUND(new Color(243, 26, 26)),
    ERROR_TOAST(new Color(237, 184, 8)),

    //BUTTON DOWNLOAD
    DOWNLOAD_ACCENT_BUTTON(new Color(2, 50, 105)),
    DOWNLOAD_ACCENT_HOVER_BUTTON(new Color(7, 129, 134)),
    DOWNLOAD_MODULE_SELECTED_BUTTON(new Color(47, 134, 30)),
    DOWNLOAD_BORDER_BUTTON(new Color(10, 6, 23)),

    //BUTTON CLEAR
    CLEAR_ACCENT_BUTTON(new Color(44, 2, 89)),
    CLEAR_ACCENT_HOVER_BUTTON(new Color(164, 104, 166)),
    CLEAR_MODULE_SELECTED_BUTTON(new Color(49, 127, 98)),
    CLEAR_BORDER_BUTTON(new Color(10, 6, 23)),

    //PICKER BACKGROUND
    PICKER_BACKGROUND(new Color(103, 191, 160)),

    //BUTTON ACCEPT COLORS
    ACCEPT_ACCENT_BUTTON(new Color(18, 66, 3)),
    ACCEPT_ACCENT_HOVER_BUTTON(new Color(24, 162, 3)),
    ACCEPT_MODULE_SELECTED_BUTTON(new Color(41, 168, 124)),
    ACCEPT_BORDER_BUTTON(new Color(10, 6, 23)),

    //BUTTON DECLINE COLORS
    DECLINE_ACCENT_BUTTON(new Color(66, 3, 3)),
    DECLINE_ACCENT_HOVER_BUTTON(new Color(162, 3, 3)),
    DECLINE_MODULE_SELECTED_BUTTON(new Color(204, 68, 241)),
    DECLINE_BORDER_BUTTON(new Color(29, 6, 6)),

    // Colores para los diferentes niveles de log
    INFO_COLOR(new Color(0, 120, 215)),
    SUCCESS_COLOR(new Color(40, 180, 60)),
    ERROR_COLOR(new Color(220, 50, 50)),
    WARNING_COLOR(new Color(230, 150, 30)),
    DEBUG_COLOR(new Color(114, 76, 119, 255)),
    TIMESTAMP_COLOR(new Color(193, 191, 191)),
    DEFAULT_COLOR(new Color(241, 238, 238));

    private final Color theme;

    UIColors(Color theme) {
        this.theme = theme;
    }

    public Color getColorSet() {
        return theme;
    }
}
