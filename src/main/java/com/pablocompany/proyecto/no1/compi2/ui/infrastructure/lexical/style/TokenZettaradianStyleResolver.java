package com.pablocompany.proyecto.no1.compi2.ui.infrastructure.lexical.style;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyle;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyleProvider;
import com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic.ZLexer;
import org.antlr.v4.runtime.Token;

/**
 * This class provides the color for the tokens
 *
 * @author pablo03
 */
//This class provides the color for the tokens
public class TokenZettaradianStyleResolver implements TokenStyleProvider {

    @Override
    public TokenStyle style(Token token) {

        return switch (token.getType()) {
            case ZLexer.BLOCK_COMMENT, ZLexer.COMMENT -> TokenStyle.Z_COMMENT;

            case ZLexer.INT, ZLexer.DECIMAL -> TokenStyle.Z_NUMBER;

            case ZLexer.ID -> TokenStyle.Z_IDENTIFIER;

            case ZLexer.ABREV_MINUS, ZLexer.ABREV_PLUS, ZLexer.PLUS,
                 ZLexer.MINUS, ZLexer.DIVIDE, ZLexer.MULTIPLICATION, ZLexer.PERCENT,
                 ZLexer.EQUALS, ZLexer.GREATER_EQUALS, ZLexer.LESS_EQUALS,
                 ZLexer.DIFERENCE,
                 ZLexer.LESS, ZLexer.GREATER, ZLexer.AND, ZLexer.OR,
                 ZLexer.NOT, ZLexer.EQUAL, ZLexer.BY_ONE_ADD, ZLexer.BY_ONE_MINUS ,
                 ZLexer.BY_ONE_MULTIPLICATION, ZLexer.BY_ONE_DIVISION, ZLexer.BY_ONE_PERCENT
                    -> TokenStyle.Z_OPERATOR;

            case ZLexer.INTEGER,
                 ZLexer.DOUBLE, ZLexer.CHARACTER, ZLexer.BOOLEAN,
                 ZLexer.SWITCH,
                 ZLexer.RETURN, ZLexer.CONTINUE,
                 ZLexer.IF, ZLexer.ELSE,
                 ZLexer.CASE, ZLexer.DO,
                 ZLexer.BREAK, ZLexer.DEFAULT,
                 ZLexer.WHILE, ZLexer.FOR,
                 ZLexer.TRUE, ZLexer.FALSE, ZLexer.PUBLIC, ZLexer.VOID, ZLexer.CLASS,
                 ZLexer.NEW, ZLexer.NULL -> TokenStyle.Z_KEYWORD;

            case ZLexer.READ, ZLexer.PRINT, ZLexer.PRINTLN -> TokenStyle.Z_FUNCTIONS;

            case ZLexer.TEXT, ZLexer.CHAR -> TokenStyle.Z_STRING;

            case ZLexer.INIT_BRACE, ZLexer.FINAL_BRACE, ZLexer.INIT_PARENT,
                 ZLexer.FINAL_PARENT,
                 ZLexer.INIT_BRACKET, ZLexer.FINAL_BRACKET -> TokenStyle.Z_PUNCTUATION;

            case ZLexer.COMMA, ZLexer.DOT_COMMA, ZLexer.TWO_POINTS, ZLexer.QUESTION,
                 ZLexer.DOT -> TokenStyle.Z_SEPARATOR;

            case ZLexer.ERROR_TOKEN, Token.INVALID_TYPE -> TokenStyle.ERROR;

            default -> TokenStyle.DEFAULT;
        };

    }
}
