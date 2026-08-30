/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablocompany.proyecto.no1.compi2.app.domain.highlight;

/**
 *
 * @author pablo03
 */
public enum ErrorType {
    
    SYNTACTIC("Sintactico"),
    LEXIC("Lexico"),
    SEMANTIC("Semantico");
    
    private String context;

    private ErrorType(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }
    
    
    
}
