package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.sideview.stack;

import com.pablocompany.practica.no1.compi2.domain.parsingstep.ActionType;
import com.pablocompany.practica.no1.compi2.domain.parsingstep.ParseStep;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.sideview.stack.components.StackBottomPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.sideview.stack.components.StackControlsPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.sideview.stack.components.StackGraphicPanel;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 *
 * @author pablo03
 */
//This class is the panel that represents the stack view step by step
public class ParseStackPanel extends JPanel {

    private final JSplitPane splitPane;
    private final JPanel topContainer;

    private final StackGraphicPanel visualPanel;
    private final StackControlsPanel controlsPanel;
    private final StackBottomPanel bottomStackPanel;
    private final JScrollPane visualScrollPane;

    public ParseStackPanel() {
        setLayout(new BorderLayout());

        topContainer = new JPanel(new BorderLayout());
        topContainer.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        visualPanel = new StackGraphicPanel();
        controlsPanel = new StackControlsPanel();
        bottomStackPanel = new StackBottomPanel();

        visualScrollPane = new JScrollPane(visualPanel);
        visualScrollPane.setBorder(null);
        visualScrollPane.getViewport().setBackground(Theme.SIDEBAR_DARKT.getColorSet());
        visualScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        visualScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        topContainer.add(visualScrollPane, BorderLayout.CENTER);
        topContainer.add(controlsPanel, BorderLayout.SOUTH);

        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topContainer, bottomStackPanel);
        splitPane.setDividerLocation(400);
        splitPane.setDividerSize(5);
        splitPane.setContinuousLayout(true);
        splitPane.setBorder(null);

        add(splitPane, BorderLayout.CENTER);

        setupListeners();
    }

    /*
     * Suscribe the service to action listeners buttons
     */
    private void setupListeners() {

        controlsPanel.getBtnReset().addActionListener(e -> {
            this.bottomStackPanel.getStackLogConsole().clear();
            visualPanel.resetSteps();
            logCurrentStepAction();
        });

        controlsPanel.getBtnNext().addActionListener(e -> {
            visualPanel.nextStep();
            logCurrentStepAction();
        });

        controlsPanel.getBtnBack().addActionListener(e -> {
            visualPanel.prevStep();
            logCurrentStepAction();
        });

        controlsPanel.getBtnFinish().addActionListener(e -> {
            this.bottomStackPanel.getStackLogConsole().clear();
            visualPanel.finishSteps();
            logAllStepsUpToCurrent();
        });
    }

    //THIS METHOD LOGS FROM FIRST STEP TO THE FINISH STEP
    private void logAllStepsUpToCurrent() {
        List<ParseStep> steps = visualPanel.getAllSteps();
        int currentIndex = visualPanel.getCurrentVisibleIndex();

        for (int i = 0; i <= currentIndex; i++) {
            ParseStep step = steps.get(i);
            printStepToConsole(step);
        }
    }

    /*
     * This method prints the current action
     */
    private void printStepToConsole(ParseStep step) {
        if (step == null) {
            return;
        }

        String logText = String.format("[Paso %d] -> %s", step.getStepNumber(), step.getActionLabel());

        if (step.getActionType() == ActionType.SHIFT) {
            bottomStackPanel.getStackLogConsole().appendShift(logText);
        } else if (step.getActionType() == ActionType.REDUCE) {
            bottomStackPanel.getStackLogConsole().appendReduce(logText);
        } else {
            bottomStackPanel.getStackLogConsole().appendNormal(logText);
        }
    }

    /*
     * This method prints the action
     */
    private void logCurrentStepAction() {
        ParseStep currentStep = visualPanel.getCurrentStep();
        printStepToConsole(currentStep);
    }

    public StackGraphicPanel getVisualPanel() {
        return visualPanel;
    }

    public StackControlsPanel getControlsPanel() {
        return controlsPanel;
    }

    public StackBottomPanel getBottomStackPanel() {
        return bottomStackPanel;
    }

    public void setStackList(List<ParseStep> steps) {
        this.visualPanel.loadSteps(steps);
        this.bottomStackPanel.getStackLogConsole().clear();

    }

    public void showGraphicStackByStep() {
        this.bottomStackPanel.getStackLogConsole().clear();
        visualPanel.resetSteps();
        logCurrentStepAction();
    }

}
