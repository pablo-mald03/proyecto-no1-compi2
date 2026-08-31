package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.screens;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.theme.Theme;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.ConfirmationNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.bottom.BottomTabbedPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.top.TopPanel;
import com.pablocompany.proyecto.no1.compi2.ui.infrastructure.components.workspace.WorkspacePanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

/**
 * Management screen with workspace, side panel and bottom panel
 *
 * @author pablo03
 */
@Getter
public class ManagementScreen extends JPanel {

    private final TopPanel topPanel;
    private final WorkspacePanel workspacePanel;
    private final BottomTabbedPanel bottomPanel;

    public ManagementScreen(
            WorkspaceNotifier workspaceNotifier,
            ConfirmationNotifier confirmationNotifier,
            String projectName,
            Runnable onNewProject,
            Runnable onOpenProject,
            Runnable onCloseProject,
            Runnable onSave,
            Runnable onSaveAs,
            Runnable onCompile,
            Runnable onExecute,
            Runnable onExit
    ) {
        setLayout(new BorderLayout());
        setBackground(Theme.BACKGROUND_DARK.getColorSet());

        // Create top panel with all actions
        this.topPanel = new TopPanel(
                workspaceNotifier,
                onNewProject,
                onOpenProject,
                onCloseProject,
                onSave,
                onSaveAs,
                onCompile,
                onExecute,
                onExit
        );

        // Create components
        this.workspacePanel = new WorkspacePanel(workspaceNotifier, confirmationNotifier, projectName);
        this.bottomPanel = new BottomTabbedPanel();


        // Create vertical split with main content and bottom panel
        JSplitPane verticalSplit = new JSplitPane(
                JSplitPane.VERTICAL_SPLIT,
                workspacePanel,
                bottomPanel
        );
        verticalSplit.setDividerLocation(520);
        verticalSplit.setDividerSize(4);
        verticalSplit.setBorder(BorderFactory.createEmptyBorder());
        verticalSplit.setBackground(Theme.BACKGROUND_DARK.getColorSet());

        // Add components to screen
        add(topPanel, BorderLayout.NORTH);
        add(verticalSplit, BorderLayout.CENTER);
    }

    /**
     * Update the project name
     */
    public void updateProjectName(String newName) {
        if (workspacePanel != null) {
            workspacePanel.updateProjectName(newName);
        }
    }

}
