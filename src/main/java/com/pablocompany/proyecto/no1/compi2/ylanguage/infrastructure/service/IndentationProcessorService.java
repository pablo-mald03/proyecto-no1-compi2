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

    /**
     * Processes raw lexer tokens to inject virtual INDENT and DEDENT tokens based in line indentation.
     */
    public List<Token> processTokens(List<Token> rawTokens) {
        List<Token> result = new ArrayList<>();
        Stack<Integer> indentStack = new Stack<>();
        indentStack.push(0); // Base indentation level (column 0)

        boolean isStartOfLine = true;

        for (Token token : rawTokens) {

            // Discard hidden channel tokens (whitespace/comments) for parsing execution
            if (token.getChannel() != Token.DEFAULT_CHANNEL) {
                continue;
            }

            // At EOF, close all remaining open indentation blocks
            if (token.getType() == eofTokenType) {
                while (indentStack.size() > 1) {
                    indentStack.pop();
                    result.add(createSyntheticToken(dedentTokenType, "DEDENT", token));
                }
                result.add(token);
                break;
            }

            // Flag the next non-hidden token to evaluate line column alignment
            if (token.getType() == newLineTokenType) {
                result.add(token);
                isStartOfLine = true;
                continue;
            }

            // Evaluate indentation level on the first default channel token of a line
            if (isStartOfLine) {
                int currentColumn = token.getCharPositionInLine();
                int previousColumn = indentStack.peek();

                if (currentColumn > previousColumn) {
                    // Open a new block
                    indentStack.push(currentColumn);
                    result.add(createSyntheticToken(indentTokenType, "INDENT", token));
                } else if (currentColumn < previousColumn) {
                    // Close matching blocks
                    while (currentColumn < indentStack.peek()) {
                        indentStack.pop();
                        result.add(createSyntheticToken(dedentTokenType, "DEDENT", token));
                    }
                    // Validate indentation alignment
                    if (currentColumn != indentStack.peek()) {
                        throw new RuntimeException("Error de identacion en la linea: " + token.getLine() +
                                ". Se esperaba una identacion al mismo nivel del ambito abierto.");
                    }
                }
                isStartOfLine = false;
            }

            result.add(token);
        }

        return result;
    }

    /**
     * Creates a synthetic token for INDENT / DEDENT insertion.
     */
    private Token createSyntheticToken(int type, String text, Token referenceToken) {
        CommonToken token = new CommonToken(type, text);
        token.setLine(referenceToken.getLine());
        token.setCharPositionInLine(referenceToken.getCharPositionInLine());
        return token;
    }
}
