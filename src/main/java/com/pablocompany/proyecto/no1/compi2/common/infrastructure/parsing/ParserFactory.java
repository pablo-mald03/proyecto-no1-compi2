package com.pablocompany.proyecto.no1.compi2.common.infrastructure.parsing;

import com.pablocompany.proyecto.no1.compi2.common.domain.parsingstep.ParserAnalyzer;

import java.util.HashMap;
import java.util.Map;

/**
 * Principal class factory of the different parser analyzers for languages
 *
 */
public class ParserFactory {

    private final Map<String, ParserAnalyzer> parsers;

    public ParserFactory() {

        this.parsers = new HashMap<>();

        /*parsers.put(".y", new YamlParserAnalyzer());
        parsers.put(".z", new ZettaradianParserAnalyzer());
        parsers.put(".pig", new PigLatinParserAnalyzer());*/
    }

    /**
     * Get the appropriate parser for a file extension
     */
    public ParserAnalyzer getParser(String extension) {
        if (extension == null || extension.isEmpty()) {
            return null;
        }
        return parsers.get(extension.toLowerCase());
    }

    /**
     * Register a custom parser
     */
    public void registerParser(String extension, ParserAnalyzer parser) {
        parsers.put(extension.toLowerCase(), parser);
    }
}
