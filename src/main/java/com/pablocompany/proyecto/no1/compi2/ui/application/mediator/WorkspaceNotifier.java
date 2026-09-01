package com.pablocompany.proyecto.no1.compi2.ui.application.mediator;

import com.pablocompany.proyecto.no1.compi2.app.infrastructure.errors.CompilerError;

import java.util.List;

/**
 *
 * @author pablo03
 */
//This interface is the principal port to nofity data to the ui and into the components
public interface WorkspaceNotifier {
    
    /*SECTION OF SIGNALS*/

    void notifyErrorsUpdated(List<CompilerError> compilerErrors);

    
    void notifyCompiledCode(String compiledCode);
    
    //void notifyStackView(List<ParseStep> steps);
    
    void notifyAstRepresentation(String ast);
    
    /*SECTION OF LOGS*/
    void logInfo(String message);

    void logSuccess(String message);

    void logError(String message);

    
    /*SECTION OF ALERTS*/
    
    void alertToast(String message, boolean isError);
    
    /*SECTION OF FOCUS REQUESTS*/

    void focusConsole();

    void focusErrors();
    
    void focusSymbolsTable();
    
    void focusPigLatin();
    
    void focusAstVisualizer();
    
    void focusStackVisualizer();
    
    void focusStackVisualizerByStep();
    
    /*SECTION OF CLEAR METHODS OR RESET DATA*/

    void clearLogs();

    /**
     * Notify that the compiled code needs to be downloaded/exported
     */
    void notifyDownloadCompiledCode();

    /**
     * Notify that the compiled code needs to be executed/run
     */
    void notifyExecuteCompiledCode();

    /**
     * Notify the action to import any project
     */
    void notifyImportProject();

    /**
     * Save file notification
     */
    void notifySaveFile(String filePath, String content);

    /**
     * Notify when a file is opened to update syntax highlighting
     *
     */
    void notifyFileOpened(String filePath, String content, String extension);
}
