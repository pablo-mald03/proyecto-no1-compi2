package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.sideview.stack.components;

import com.pablocompany.practica.no1.compi2.domain.parsingstep.ActionType;
import com.pablocompany.practica.no1.compi2.domain.parsingstep.ElementType;
import com.pablocompany.practica.no1.compi2.domain.parsingstep.ParseStep;
import com.pablocompany.practica.no1.compi2.domain.parsingstep.StackElement;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.StackColors;
import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import lombok.Getter;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author pablo03
 */
@Getter
//This class is the principal graphic panel to ilustrate the STACK
public class StackGraphicPanel extends JPanel {

    //Principal reference
    private List<ParseStep> allSteps = new ArrayList<>();
    private int currentVisibleIndex = -1;

    // Variables de Zoom
    private double zoomFactor = 1.0;
    private static final double ZOOM_MIN = 0.5;
    private static final double ZOOM_MAX = 3.0;
    private static final double ZOOM_STEP = 1.15;

    // Constantes de dimensiones base (sin zoom)
    private static final int STEP_WIDTH = 90;
    private static final int ELEMENT_HEIGHT = 35;
    private static final int SPACING_X = 20;
    private static final int MARGIN_TOP = 40;
    private static final int MARGIN_BOTTOM = 80;

    public StackGraphicPanel() {
        setBackground(Theme.SIDEBAR_DARKT.getColorSet());

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Theme.SIDEBAR_LIGHT.getColorSet()),
                "Visualizador de Pila",
                0, 0,
                new Font("Liberation Mono", Font.BOLD, 12),
                Theme.FOREGROUND_DARK.getColorSet()
        ));

        setAutoscrolls(true);

        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.isControlDown()) {
                    if (e.getPreciseWheelRotation() < 0) {
                        zoomFactor = Math.min(zoomFactor * ZOOM_STEP, ZOOM_MAX);
                    } else {
                        zoomFactor = Math.max(zoomFactor / ZOOM_STEP, ZOOM_MIN);
                    }
                    revalidate();
                    repaint();
                }
            }
        });
    }

    /**
     * This method returns to the initial production
     */
    public void resetSteps() {
        if (!allSteps.isEmpty()) {
            currentVisibleIndex = 0;
            revalidate();
            repaint();
        }
    }

    /*
     * This method loads the parsing steps (setter)
     */
    public void loadSteps(List<ParseStep> steps) {
        this.allSteps = steps;
        this.currentVisibleIndex = steps.isEmpty() ? -1 : 0;
        this.zoomFactor = 1.0;
        revalidate();
        repaint();
    }

    /*
     * This method goes to the next list step
     */
    public void nextStep() {
        if (currentVisibleIndex < allSteps.size() - 1) {
            currentVisibleIndex++;
            revalidate();
            repaint();
        }
    }

    /*
     * This method goes to the previous list step
     */
    public void prevStep() {
        if (currentVisibleIndex > 0) {
            currentVisibleIndex--;
            revalidate();
            repaint();
        }
    }

    /*
     * This method goes to the final step
     */
    public void finishSteps() {
        currentVisibleIndex = allSteps.size() - 1;
        revalidate();
        repaint();
    }

    //This method modify the width acording the text width
    private int calculateDynamicStepWidth(Font boldFont, Font plainFont, Font actionFont) {
        int maxTextWidth = 100;

        FontMetrics fmBold = getFontMetrics(boldFont);
        FontMetrics fmPlain = getFontMetrics(plainFont);
        FontMetrics fmAction = getFontMetrics(actionFont);

        for (int i = 0; i <= currentVisibleIndex && i < allSteps.size(); i++) {
            ParseStep step = allSteps.get(i);

            int numWidth = fmBold.stringWidth(String.valueOf(step.getStepNumber()));
            maxTextWidth = Math.max(maxTextWidth, numWidth);

            for (StackElement element : step.getStackElements()) {
                if (element.getSymbol() != null) {
                    int symWidth = fmPlain.stringWidth(element.getSymbol());
                    maxTextWidth = Math.max(maxTextWidth, symWidth);
                }
            }

            if (step.getActionType() != ActionType.INITIAL && step.getActionLabel() != null) {
                int actWidth = fmAction.stringWidth(step.getActionLabel());
                maxTextWidth = Math.max(maxTextWidth, actWidth);
            }
        }

        return maxTextWidth + 30;
    }

    //THIS IS THE PRINCIPAL METHOD TO DRAW THE STACK LIST
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (allSteps.isEmpty() || currentVisibleIndex < 0) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.scale(zoomFactor, zoomFactor);

        Font boldFont = new Font("Liberation Mono", Font.BOLD, 14);
        Font plainFont = new Font("Liberation Mono", Font.PLAIN, 12);
        Font actionFont = new Font("Liberation Mono", Font.PLAIN, 10);

        int stepWidth = calculateDynamicStepWidth(boldFont, plainFont, actionFont);

        int maxStackSize = 5;
        for (int i = 0; i <= currentVisibleIndex; i++) {
            maxStackSize = Math.max(maxStackSize, allSteps.get(i).getStackElements().size());
        }

        int containerHeight = (maxStackSize * ELEMENT_HEIGHT) + 20;
        int startYContainer = MARGIN_TOP + 20;

        for (int i = 0; i <= currentVisibleIndex; i++) {
            ParseStep step = allSteps.get(i);
            int startX = 20 + (i * (stepWidth + SPACING_X));

            // 1. Draw the step number
            g2d.setFont(boldFont);
            g2d.setColor(Theme.FOREGROUND_DARK.getColorSet());
            drawCenteredString(g2d, String.valueOf(step.getStepNumber()), startX, startX + stepWidth, MARGIN_TOP);

            // 2. Draw the container
            g2d.setColor(StackColors.COLOR_CONTAINER.getColorSet());
            g2d.fillRoundRect(startX, startYContainer, stepWidth, containerHeight, 15, 15);

            // 3. Draw the stack steps from the bottom to the top
            List<StackElement> elements = step.getStackElements();
            int currentY = startYContainer + containerHeight - ELEMENT_HEIGHT - 10;

            g2d.setFont(plainFont);
            for (StackElement element : elements) {
                g2d.setColor(element.getType() == ElementType.TERMINAL ? StackColors.COLOR_TERMINAL.getColorSet() : StackColors.COLOR_NON_TERM.getColorSet());
                g2d.fillRoundRect(startX + 5, currentY, stepWidth - 10, ELEMENT_HEIGHT - 5, 8, 8);

                g2d.setColor(Theme.FOREGROUND_LIGHT.getColorSet());
                g2d.drawRoundRect(startX + 5, currentY, stepWidth - 10, ELEMENT_HEIGHT - 5, 8, 8);
                drawCenteredString(g2d, element.getSymbol(), startX + 5, startX + stepWidth - 5, currentY + 20);

                currentY -= ELEMENT_HEIGHT;
            }

            // 4. Draws the action behind the stack
            if (step.getActionType() != ActionType.INITIAL) {
                int actionY = startYContainer + containerHeight + 15;
                g2d.setColor(step.getActionType() == ActionType.SHIFT ? StackColors.COLOR_ACTION_SHIFT.getColorSet() : StackColors.COLOR_ACTION_REDUCE.getColorSet());
                g2d.fillRect(startX, actionY, stepWidth, 25);

                g2d.setColor(Theme.FOREGROUND_LIGHT.getColorSet());
                g2d.drawRect(startX, actionY, stepWidth, 25);

                g2d.setFont(actionFont);
                drawCenteredString(g2d, step.getActionLabel(), startX, startX + stepWidth, actionY + 16);
            }
        }
    }

    /*
     * This method calculate the space based at the list lenght and zoom
     */
    @Override
    public Dimension getPreferredSize() {
        if (currentVisibleIndex < 0) {
            return new Dimension(400, 300);
        }

        Font boldFont = new Font("Liberation Mono", Font.BOLD, 14);
        Font plainFont = new Font("Liberation Mono", Font.PLAIN, 12);
        Font actionFont = new Font("Liberation Mono", Font.PLAIN, 10);

        int stepWidth = calculateDynamicStepWidth(boldFont, plainFont, actionFont);

        int totalWidth = 40 + ((currentVisibleIndex + 1) * (stepWidth + SPACING_X));

        int maxStackSize = 5;
        for (int i = 0; i <= currentVisibleIndex; i++) {
            maxStackSize = Math.max(maxStackSize, allSteps.get(i).getStackElements().size());
        }
        int totalHeight = MARGIN_TOP + (maxStackSize * ELEMENT_HEIGHT) + MARGIN_BOTTOM + 50;

        return new Dimension((int) (totalWidth * zoomFactor), (int) (totalHeight * zoomFactor));
    }

    //Utility to center the text
    private void drawCenteredString(Graphics2D g2d, String text, int startX, int endX, int y) {
        FontMetrics fm = g2d.getFontMetrics();
        int width = fm.stringWidth(text);
        int x = startX + ((endX - startX) - width) / 2;
        g2d.drawString(text, x, y);
    }

    /*Getters and setters for principal data*/
    public ParseStep getCurrentStep() {
        if (allSteps.isEmpty() || currentVisibleIndex < 0 || currentVisibleIndex >= allSteps.size()) {
            return null;
        }
        return allSteps.get(currentVisibleIndex);
    }

    public int getTotalSteps() {
        return allSteps.size();
    }
}
