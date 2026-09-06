package com.pablocompany.proyecto.no1.compi2.common.domain.parsingstep;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;

/**
 * Principal contest to make the analyzer for parsing phase
 *
 */
public interface ParserAnalyzer {
    /**
     * Parse the source code and fill the EditorContext
     */
    void parse(EditorContext context);

}
