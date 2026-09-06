package com.pablocompany.proyecto.no1.compi2.common.infrastructure.parsing;

import com.pablocompany.proyecto.no1.compi2.common.domain.parsingstep.ParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.PigLatinParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.parsing.YParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.ZettaradianParserAnalyzer;

/**
 * Principal class factory of the different parser analyzers for languages
 *
 */
public class ParserFactory {

    /**
     * Get the appropriate parser for a file extension
     */
    public static ParserAnalyzer getParser(String extension) {
        if (extension == null || extension.isEmpty()) {
            return null;
        }

        return switch (extension.toLowerCase()) {
            case ".z" -> new YParserAnalyzer();
            case ".pig" -> new ZettaradianParserAnalyzer();
            case ".y" -> new PigLatinParserAnalyzer();
            default -> null;
        };
    }
}
