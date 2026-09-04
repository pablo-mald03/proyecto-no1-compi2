package com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.analyzers;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.SyntaxHighlightListener;

public class SyntaxHighlightListenerFactory {
    /**
     * Create the appropriate syntax highlight listener based on file extension
     */
    public static SyntaxHighlightListener createListener(String extension, String filePath, String fileName) {
        if (extension == null || extension.isEmpty()) {
            return null;
        }

        return switch (extension.toLowerCase()) {
            case ".z" -> new ZettaradianAntlrAnalyzer(filePath, fileName);
            case ".pig" -> new PigLatinAntlrAnalyzer(filePath, fileName);
            case ".y" -> new YAntlrAnalyzer(filePath, fileName);
            default -> null;
        };
    }
}