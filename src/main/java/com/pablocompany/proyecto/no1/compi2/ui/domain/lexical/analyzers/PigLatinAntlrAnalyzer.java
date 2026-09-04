package com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.analyzers;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.SyntaxHighlightListener;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinLexer;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal class to do the analysis for the PigLatin language
 *
 */
@AllArgsConstructor
public class PigLatinAntlrAnalyzer implements SyntaxHighlightListener {

    private final String filePath;
    private final String fileName;

    /**
     * Principal method to highlight the code
     *
     */
    @Override
    public void highlight(EditorContext context) {
        context.clearLexicalErrors();

        if (context.getSourceCode() == null || context.getSourceCode().isEmpty()) {
            context.setTokens(new ArrayList<>());
            return;
        }

        CharStream stream = CharStreams.fromString(context.getSourceCode());
        PigLatinLexer lexer = new PigLatinLexer(stream);

        List<Token> allTokens = new ArrayList<>();
        Token token = lexer.nextToken();

        while (token.getType() != Token.EOF) {
            allTokens.add(token);

            if (token.getType() == PigLatinLexer.ERROR_TOKEN) {
                String lexeme = token.getText();
                int line = token.getLine();
                int column = token.getCharPositionInLine() + 1;

                context.addLexicalError(lexeme, line, column, filePath, fileName);
            }
            token = lexer.nextToken();
        }

        context.setTokens(allTokens);
    }
}
