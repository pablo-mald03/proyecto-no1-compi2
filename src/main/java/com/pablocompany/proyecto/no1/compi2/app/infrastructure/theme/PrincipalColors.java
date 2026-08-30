/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme;

import java.awt.Color;

/**
 *
 * @author pablo03
 */
public enum PrincipalColors {

    //Exclusive Toast colors
    COLOR_INFO(new Color(125, 207, 255)),
    COLOR_SUCCESS(new Color(130, 226, 120)),
    COLOR_WARN(new Color(255, 200, 85)),
    COLOR_ERROR(new Color(255, 83, 112)),
    COLOR_DEFAULT(new Color(230, 235, 245)),
    
    //Exclusive table colors
    COLOR_ERROR_TABLE(new Color(255, 83, 112)),
    COLOR_NUMBER_TABLE(new Color(125, 207, 255)),
    COLOR_TYPE_TABLE(new Color(255, 200, 85)),
    COLOR_LEXEME_TABLE(new Color(180, 140, 255));

    private final Color colorSet;

    PrincipalColors(Color setColor) {
        this.colorSet = setColor;
    }

    public Color getColorSet() {
        return colorSet;
    }

}
