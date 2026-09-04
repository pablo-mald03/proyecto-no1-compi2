package com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.stylers;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyle;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyleProvider;
import org.antlr.v4.runtime.Token;

/**
 * This class provides the color for the tokens
 * @author pablo03
 */
//This class provides the color for the tokens
public class TokenYStyleResolver implements TokenStyleProvider {

    @Override
    public TokenStyle style(Token token) {

        return switch (token.getType()) {
            /*case CodexLatinusLexer.BLOCK_COMMENT, CodexLatinusLexer.COMMENT -> TokenStyle.COMMENT;
            case CodexLatinusLexer.INT, CodexLatinusLexer.DECIMAL -> TokenStyle.NUMBER;
            case Token.INVALID_TYPE -> TokenStyle.ERROR;
            case CodexLatinusLexer.ID -> TokenStyle.IDENTIFIER;
            case CodexLatinusLexer.ABREV_MINUS, CodexLatinusLexer.ABREV_PLUS, CodexLatinusLexer.PLUS,
                 CodexLatinusLexer.MINUS, CodexLatinusLexer.DIVIDE, CodexLatinusLexer.MULTIPLICATION,
                 CodexLatinusLexer.EQUALS, CodexLatinusLexer.GREATER_EQUALS, CodexLatinusLexer.LESS_EQUALS,
                 CodexLatinusLexer.DIFERENCE,
                 CodexLatinusLexer.LESS, CodexLatinusLexer.GREATER, CodexLatinusLexer.AND, CodexLatinusLexer.OR,
                 CodexLatinusLexer.NOT, CodexLatinusLexer.EQUAL,
                 CodexLatinusLexer.MUNERA, CodexLatinusLexer.MAIOR, CodexLatinusLexer.VARIABILES,
                 CodexLatinusLexer.FINIS_SEPARATOR,
                 CodexLatinusLexer.VERUM, CodexLatinusLexer.FALSUS -> TokenStyle.OPERATOR;
            case CodexLatinusLexer.NUMERUS, CodexLatinusLexer.LITTERA,
                 CodexLatinusLexer.DECIMALIS, CodexLatinusLexer.TEXTUM, CodexLatinusLexer.ESTO,
                 CodexLatinusLexer.BOOLEAN,
                 CodexLatinusLexer.SERIES, CodexLatinusLexer.STRUCTURE, CodexLatinusLexer.FINIS,
                 CodexLatinusLexer.DUM, CodexLatinusLexer.PER, CodexLatinusLexer.FACERE, CodexLatinusLexer.SI,
                 CodexLatinusLexer.ALITER, CodexLatinusLexer.ACTIO,
                 CodexLatinusLexer.REDDERE, CodexLatinusLexer.RATIO, CodexLatinusLexer.READ, CodexLatinusLexer.PRINT,
                 CodexLatinusLexer.INTERRUMPE, CodexLatinusLexer.PERGE->
                    TokenStyle.KEYWORD;

            case CodexLatinusLexer.STRING, CodexLatinusLexer.CHAR -> TokenStyle.STRING;

            case CodexLatinusLexer.INIT_BRACE, CodexLatinusLexer.FINAL_BRACE, CodexLatinusLexer.INIT_PARENT,
                 CodexLatinusLexer.FINAL_PARENT,
                 CodexLatinusLexer.INIT_BRACKET, CodexLatinusLexer.FINAL_BRACKET -> TokenStyle.PUNCTUATION;

            case CodexLatinusLexer.COMMA, CodexLatinusLexer.DOT_COMMA, CodexLatinusLexer.TWO_POINTS,
                 CodexLatinusLexer.DOT -> TokenStyle.SEPARATOR;
            case CodexLatinusLexer.ERROR_TOKEN -> TokenStyle.ERROR;*/

            default -> TokenStyle.DEFAULT;
        };

    }
}
