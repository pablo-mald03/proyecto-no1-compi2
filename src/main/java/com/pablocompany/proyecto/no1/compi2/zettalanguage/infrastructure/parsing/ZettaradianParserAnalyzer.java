package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.parsing;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.ParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZParser;
import com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure.errors.ZettaradianErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

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

        context.clearParsingErrors();

        String filePath = context.getFilePath();
        String fileName = context.getFileName();

        // Remove default listeners and add custom structured listener
        ZLexer lexer = new ZLexer(CharStreams.fromString(source));
        lexer.removeErrorListeners();
        ZettaradianErrorListener lexerListener = new ZettaradianErrorListener(ErrorType.LEXIC, filePath, fileName);
        lexer.addErrorListener(lexerListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Remove default listeners and add custom structured listener
        ZParser parser = new ZParser(tokens);
        parser.removeErrorListeners();
        ZettaradianErrorListener parserListener = new ZettaradianErrorListener(ErrorType.SYNTACTIC, filePath, fileName);
        parser.addErrorListener(parserListener);

        ParseTree yParseTree = parser.program();

        //Update context execution state with collected CompilerError objects
        context.setParseTree(yParseTree);
        context.setLexicalErrors(lexerListener.getErrors());
        context.setParserErrors(parserListener.getErrors());

        boolean hasErrors = lexerListener.hasErrors() || parserListener.hasErrors();
        context.setParsed(!hasErrors);
    }

}