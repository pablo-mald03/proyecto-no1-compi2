package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.parsing;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsingstep.ParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YParser;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.errors.YErrorListener;
import com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service.IndentationProcessorService;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal class to execute the semantic parsing .y phase
 *
 */
public class YParserAnalyzer implements ParserAnalyzer {

    @Override
    public void parse(EditorContext context) {
        String source = context.getSourceCode();
        if (source == null || source.isEmpty()) {
            return;
        }

        context.clearParsingErrors();

        String filePath = context.getFilePath();
        String fileName = context.getFileName();

        // Initialize ANTLR Lexer stream
        CharStream input = CharStreams.fromString(source);
        YLexer lexer = new YLexer(input);
        lexer.removeErrorListeners();
        YErrorListener lexerListener = new YErrorListener(ErrorType.LEXIC, filePath, fileName);
        lexer.addErrorListener(lexerListener);

        // Fetch all tokens including EOF iteratively
        List<Token> rawTokens = new ArrayList<>();
        Token token;
        do {
            token = lexer.nextToken();
            rawTokens.add(token);
        } while (token.getType() != Token.EOF);

        // Process indentation to inject synthetic INDENT/DEDENT tokens
        IndentationProcessorService indentService = new IndentationProcessorService(
                YLexer.INDENT,
                YLexer.DEDENT,
                YLexer.NEWLINE,
                YLexer.EOF
        );

        List<Token> processedTokens = null;
        processedTokens = indentService.processTokens(rawTokens, context.getParserErrors());


        // Wrap processed token list for ANTLR Parser consumption
        ListTokenSource tokenSource = new ListTokenSource(processedTokens);
        CommonTokenStream tokenStream = new CommonTokenStream(tokenSource);

        // Parse starting from the root rule
        YParser parser = new YParser(tokenStream);
        parser.removeErrorListeners();
        YErrorListener parserListener = new YErrorListener(ErrorType.SYNTACTIC, filePath, fileName);
        parser.addErrorListener(parserListener);
        ParseTree yParseTree = parser.program();

        // Update context execution state
        context.setParseTree(yParseTree);

        context.setLexicalErrors(lexerListener.getErrors());
        context.setParserErrors(parserListener.getErrors());

        boolean hasErrors = lexerListener.hasErrors() || parserListener.hasErrors();
        context.setParsed(!hasErrors);
    }
}