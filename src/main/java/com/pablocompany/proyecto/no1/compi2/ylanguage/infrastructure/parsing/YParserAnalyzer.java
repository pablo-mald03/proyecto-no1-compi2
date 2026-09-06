package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.parsing;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsingstep.ParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YParser;
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

    /**
     * Principal method to execute the parsing phase
     */
    @Override
    public void parse(EditorContext context) {
        String source = context.getSourceCode();
        if (source == null || source.isEmpty()) {
            return;
        }

        // Initialize ANTLR Lexer stream
        CharStream input = CharStreams.fromString(source);
        YLexer lexer = new YLexer(input);

        // Fetch all tokens including EOF iteratively (avoids wildcards and includes EOF)
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
        List<Token> processedTokens = indentService.processTokens(rawTokens);

        // Wrap processed token list for ANTLR Parser consumption
        ListTokenSource tokenSource = new ListTokenSource(processedTokens);
        CommonTokenStream tokenStream = new CommonTokenStream(tokenSource);

        // Parse starting from the root rule
        YParser parser = new YParser(tokenStream);
        ParseTree yParseTree = parser.program();

        // Update context execution state
        context.setParseTree(yParseTree);
        /*
        context.setParserErrors(errors);*/
        context.setParsed(true);
    }

}