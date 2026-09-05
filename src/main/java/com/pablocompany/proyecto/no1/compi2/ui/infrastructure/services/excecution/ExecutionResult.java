package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.services.excecution;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Result class for execution
 */
@Setter
@Getter
public class ExecutionResult {

    private boolean success;
    private String output;
    private final List<String> steps;

    public ExecutionResult() {
        this.success = false;
        this.output = "";
        this.steps = new ArrayList<>();
    }

    public void addStep(String step) {
        steps.add(step);
    }


    public String getFormattedOutput() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (String step : steps) {
            sb.append("> ").append(step).append("\n");
        }
        if (!output.isEmpty()) {
            sb.append("\n--- SALIDA DEL PROGRAMA ---\n");
            sb.append(output);
        }
        return sb.toString();
    }
}
