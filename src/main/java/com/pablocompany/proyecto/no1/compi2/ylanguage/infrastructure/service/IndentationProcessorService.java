package com.pablocompany.proyecto.no1.compi2.ylanguage.infrastructure.service;


import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Principal class to determinate the idents in the flux tokens of ANTLR Y analysis
 *
 */
@AllArgsConstructor
public class IndentationProcessorService {
    private final int indentTokenType;
    private final int dedentTokenType;
    private final int newLineTokenType;
    private final int eofTokenType;

    //Principal method to process the idents
    public List<Token> processTokens(List<Token> rawTokens) {
        List<Token> result = new ArrayList<>();
        Stack<Integer> indentStack = new Stack<>();
        indentStack.push(0); //base ident

        boolean isStartOfLine = true;

        for (Token token : rawTokens) {

            //ignore hidden tokens
            if (token.getChannel() != Token.DEFAULT_CHANNEL) {
                result.add(token);
                continue;
            }

            // If we found the EOF closes the open block
            if (token.getType() == eofTokenType) {
                while (indentStack.size() > 1) {
                    indentStack.pop();
                    result.add(createSyntheticToken(dedentTokenType, "DEDENT", token));
                }
                result.add(token);
                break;
            }

            // If the token is a new line prepare the start line ( scope)
            if (token.getType() == newLineTokenType) {
                result.add(token);
                isStartOfLine = true;
                continue;
            }

            // if we found a new start line evaluate the column (compares if its not the same column)
            if (isStartOfLine) {
                int currentColumn = token.getCharPositionInLine();
                int previousColumn = indentStack.peek();

                if (currentColumn > previousColumn) {
                    //Open new block
                    indentStack.push(currentColumn);
                    result.add(createSyntheticToken(indentTokenType, "INDENT", token));
                } else if (currentColumn < previousColumn) {
                    // closes the block
                    while (currentColumn < indentStack.peek()) {
                        indentStack.pop();
                        result.add(createSyntheticToken(dedentTokenType, "DEDENT", token));
                    }
                    // if before to get the peek the column doesnt match with the stack column is an error
                    if (currentColumn != indentStack.peek()) {
                        throw new RuntimeException("Error de indentacion, línea: " + token.getLine() + ". Se esperaba alineacion con un bloque superior.");
                    }
                }
                isStartOfLine = false;
            }

            result.add(token);
        }

        return result;
    }

    //Auxiliary method to create the virtual token
    private Token createSyntheticToken(int type, String text, Token referenceToken) {
        CommonToken token = new CommonToken(type, text);
        token.setLine(referenceToken.getLine());
        token.setCharPositionInLine(referenceToken.getCharPositionInLine());
        return token;
    }
}
