package com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.analyzers;

import com.pablocompany.proyecto.no1.compi2.app.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.app.domain.highlight.SyntaxHighlightListener;
import com.pablocompany.proyecto.no1.compi2.ui.application.mediator.WorkspaceNotifier;

/**
 * Principal class to do the analysis for the PigLatin language
 *
 */
public class PigLatinAntlrAnalyzer implements SyntaxHighlightListener {
    private final WorkspaceNotifier notifier;

    public PigLatinAntlrAnalyzer(WorkspaceNotifier notifier) {
        this.notifier = notifier;
    }

    /**
     * Principal method to highlight the code
     *
     */
    @Override
    public void highlight(EditorContext context) {

    }
}
