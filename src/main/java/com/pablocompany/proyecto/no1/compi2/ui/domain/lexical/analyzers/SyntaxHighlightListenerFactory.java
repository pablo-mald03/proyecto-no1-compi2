package com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.analyzers;

import com.pablocompany.proyecto.no1.compi2.app.domain.highlight.SyntaxHighlightListener;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;

public class SyntaxHighlightListenerFactory {
    /**
     * Create the appropriate syntax highlight listener based on file extension
     */
    public static SyntaxHighlightListener createListener(String extension, WorkspaceNotifier notifier) {
        if (extension == null || extension.isEmpty()) {
            return null;
        }

        switch (extension.toLowerCase()) {
            case ".z":
                return new ZettaradianAntlrAnalyzer(notifier);
            case ".pig":
                return new PigLatinAntlrAnalyzer(notifier);
            case ".y":
                return new YAntlrAnalyzer(notifier);
            default:
                return null;
        }
    }
}