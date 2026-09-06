package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsingstep.ParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal class to execute the semantic parsing .z phase
 *
 */
public class ZettaradianParserAnalyzer implements ParserAnalyzer {

    /**
     * Principal method to execute the parsing phase
     */
    @Override
    public void parse(EditorContext context) {
        String source = context.getSourceCode();
        if (source == null || source.isEmpty()) {
            return;
        }

        ZLexer lexer = new ZLexer(CharStreams.fromString(context.getSourceCode()));
        CommonTokenStream tokens = new CommonTokenStream(lexer);


        context.clearParsingErrors();

        ZParser parser = new ZParser(tokens);

        ParseTree yParseTree = parser.program();

        // Update context execution state
        context.setParseTree(yParseTree);
        /*
        context.setParserErrors(errors);*/
        context.setParsed(true);
    }

}