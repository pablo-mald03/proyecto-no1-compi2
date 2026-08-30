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
    
    //Signal to change the symbols table
    //void notifySymbolUpdated(List<Symbol> symbols);

    //Signal to change the Types table
    //void notifyTypesUpdated(List<TypeInfo> types);
    
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
}
