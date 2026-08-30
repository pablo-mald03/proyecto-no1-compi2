package com.pablocompany.practica.no1.compi2.domain.parsingstep;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author pablo03
 */
@Getter
@Setter
//This class is the principal that contains the base representation of the step by step parsing
public class ParseStep {

    private int stepNumber;
    //This List follow the FIFO rules
    private List<StackElement> stackElements; 
    private String actionLabel;
    private ActionType actionType;

    public ParseStep(int stepNumber, String actionLabel, ActionType actionType) {
        this.stepNumber = stepNumber;
        this.actionLabel = actionLabel;
        this.actionType = actionType;
        this.stackElements = new ArrayList<>();
    }

    public void addElement(StackElement element) {
        this.stackElements.add(element);
    }

}
