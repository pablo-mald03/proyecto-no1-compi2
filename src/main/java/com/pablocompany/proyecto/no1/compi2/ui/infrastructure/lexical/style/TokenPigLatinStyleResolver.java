package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.lexical.style;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyle;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyleProvider;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinLexer;
import org.antlr.v4.runtime.Token;

/**
 * This class provides the color for the tokens
 * @author pablo03
 */
public class TokenPigLatinStyleResolver implements TokenStyleProvider {

    @Override
    public TokenStyle style(Token token) {

        return switch (token.getType()) {
            case PigLatinLexer.BLOCK_COMMENT, PigLatinLexer.COMMENT -> TokenStyle.COMMENT;
            case PigLatinLexer.INT, PigLatinLexer.DECIMAL -> TokenStyle.NUMBER;
            case Token.INVALID_TYPE -> TokenStyle.ERROR;
            case PigLatinLexer.ID -> TokenStyle.IDENTIFIER;
            case PigLatinLexer.ABREV_MINUS, PigLatinLexer.ABREV_PLUS, PigLatinLexer.PLUS,
                 PigLatinLexer.MINUS, PigLatinLexer.DIVIDE, PigLatinLexer.MULTIPLICATION,
                 PigLatinLexer.EQUALS, PigLatinLexer.GREATER_EQUALS, PigLatinLexer.LESS_EQUALS,
                 PigLatinLexer.DIFERENCE,
                 PigLatinLexer.LESS, PigLatinLexer.GREATER, PigLatinLexer.AND, PigLatinLexer.OR,
                 PigLatinLexer.NOT, PigLatinLexer.EQUAL,
                 PigLatinLexer.MUNERA, PigLatinLexer.MAIOR, PigLatinLexer.VARIABILES,
                 PigLatinLexer.FINIS_SEPARATOR,
                 PigLatinLexer.VERUM, PigLatinLexer.FALSUS -> TokenStyle.OPERATOR;
            case PigLatinLexer.NUMERUS, PigLatinLexer.LITTERA,
                 PigLatinLexer.DECIMALIS, PigLatinLexer.TEXTUM, PigLatinLexer.ESTO,
                 PigLatinLexer.BOOLEAN,
                 PigLatinLexer.SERIES, PigLatinLexer.STRUCTURE, PigLatinLexer.FINIS,
                 PigLatinLexer.DUM, PigLatinLexer.PER, PigLatinLexer.FACERE, PigLatinLexer.SI,
                 PigLatinLexer.ALITER, PigLatinLexer.ACTIO,
                 PigLatinLexer.REDDERE, PigLatinLexer.RATIO, PigLatinLexer.READ, PigLatinLexer.PRINT,
                 PigLatinLexer.INTERRUMPE, PigLatinLexer.PERGE ->
                    TokenStyle.KEYWORD;

            case PigLatinLexer.STRING, PigLatinLexer.CHAR -> TokenStyle.STRING;

            case PigLatinLexer.INIT_BRACE, PigLatinLexer.FINAL_BRACE, PigLatinLexer.INIT_PARENT,
                 PigLatinLexer.FINAL_PARENT,
                 PigLatinLexer.INIT_BRACKET, PigLatinLexer.FINAL_BRACKET -> TokenStyle.PUNCTUATION;

            case PigLatinLexer.COMMA, PigLatinLexer.DOT_COMMA, PigLatinLexer.TWO_POINTS,
                 PigLatinLexer.DOT -> TokenStyle.SEPARATOR;
            case PigLatinLexer.ERROR_TOKEN -> TokenStyle.ERROR;

            default -> TokenStyle.DEFAULT;
        };

    }
}
