package com.pablocompany.proyecto.no1.compi2.app.infrastructure.lexical;

import com.pablocompany.proyecto.no1.compi2.app.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.app.domain.highlight.SyntaxHighlightListener;

/**
 *
 * @author pablo03
 */
/*This class analyze the code and can highlight the code*/
public class AntlrAnalyzer implements SyntaxHighlightListener {

    @Override
    public void highlight(EditorContext context) {
       /* context.clearLexicalErrors();

        if (context.getSourceCode() == null || context.getSourceCode().isEmpty()) {
            context.setTokens(new ArrayList<>());
            return;
        }

        CharStream stream = CharStreams.fromString(context.getSourceCode());
        CodexLatinusLexer lexer = new CodexLatinusLexer(stream);

        List<Token> allTokens = new ArrayList<>();
        Token token = lexer.nextToken();

        while (token.getType() != Token.EOF) {
            allTokens.add(token);

            if (token.getType() == CodexLatinusLexer.ERROR_TOKEN) {
                String lexeme = token.getText();
                int line = token.getLine();
                int column = token.getCharPositionInLine() + 1;

                context.addLexicalError(lexeme, line, column);
            }
            token = lexer.nextToken();
        }

        context.setTokens(allTokens);*/
    }

}
