/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pablocompany.practica.no1.compi2.domain.parsingstep;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author pablo03
 */
@Data
@AllArgsConstructor
//This class represents the individual component for the stack
public class StackElement {
    private String symbol;
    private ElementType type;
}
