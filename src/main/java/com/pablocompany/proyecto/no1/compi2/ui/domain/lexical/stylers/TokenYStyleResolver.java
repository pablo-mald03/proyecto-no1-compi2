package com.pablocompany.proyecto.no1.compi2.ui.domain.lexical.stylers;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyle;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.TokenStyleProvider;
import com.pablocompany.proyecto.no1.compi2.compiler.y.logic.YLexer;
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
            case YLexer.BLOCK_COMMENT, YLexer.COMMENT -> TokenStyle.Y_COMMENT;

            case YLexer.INT, YLexer.DECIMAL -> TokenStyle.Y_NUMBER;

            case YLexer.ID -> TokenStyle.Y_IDENTIFIER;

            case YLexer.ABREV_MINUS, YLexer.ABREV_PLUS, YLexer.PLUS,
                 YLexer.MINUS, YLexer.DIVIDE, YLexer.MULTIPLICATION,
                 YLexer.EQUALS, YLexer.GREATER_EQUALS, YLexer.LESS_EQUALS,
                 YLexer.DIFERENCE,
                 YLexer.LESS, YLexer.GREATER, YLexer.AND, YLexer.OR,
                 YLexer.NOT, YLexer.EQUAL,
                 YLexer.STRUCTURES_REGION, YLexer.FUNCTION_REGION,
                 YLexer.LAMBDA -> TokenStyle.Y_OPERATOR;

            case YLexer.INTEGER, YLexer.STRING,
                 YLexer.FLOAT, YLexer.CHARACTER, YLexer.BOOLEAN,
                 YLexer.SWITCH, YLexer.DEFINE,
                 YLexer.RETURN, YLexer.CONTINUE,
                 YLexer.IF, YLexer.ELSE_IF, YLexer.ELSE, YLexer.SO,
                 YLexer.CASE, YLexer.DO,
                 YLexer.BREAK, YLexer.ALWAYS, YLexer.READ, YLexer.PRINT,
                 YLexer.WHILE, YLexer.FOR,
                 YLexer.TRUE, YLexer.FALSE -> TokenStyle.Y_KEYWORD;

            case YLexer.TEXT, YLexer.CHAR -> TokenStyle.Y_STRING;

            case YLexer.INIT_BRACE, YLexer.FINAL_BRACE, YLexer.INIT_PARENT,
                 YLexer.FINAL_PARENT,
                 YLexer.INIT_BRACKET, YLexer.FINAL_BRACKET -> TokenStyle.Y_PUNCTUATION;

            case YLexer.COMMA, YLexer.DOT_COMMA, YLexer.TWO_POINTS,
                 YLexer.DOT -> TokenStyle.Y_SEPARATOR;

            case YLexer.ERROR_TOKEN, Token.INVALID_TYPE -> TokenStyle.ERROR;

            default -> TokenStyle.DEFAULT;
        };

    }
}
