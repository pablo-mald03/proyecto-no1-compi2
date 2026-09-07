package com.pablocompany.proyecto.no1.compi2.zettalanguage.infrastructure;

import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.errors.CompilerError;
import lombok.Getter;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Principal class to parse the error with the listener
 *
 */
@Getter
public class ZettaradianErrorListener extends BaseErrorListener {

    private final List<CompilerError> errors = new ArrayList<>();
    private final ErrorType errorType;
    private final String filePath;
    private final String fileName;

    public ZettaradianErrorListener(ErrorType errorType, String filePath, String fileName) {
        this.errorType = errorType;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    /**
     * Principal method to register the syntax error
     *
     */
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
                            int charPositionInLine, String msg, RecognitionException e) {

        String lexeme = "";
        if (offendingSymbol instanceof Token) {
            lexeme = ((Token) offendingSymbol).getText();
        } else if (offendingSymbol != null) {
            lexeme = offendingSymbol.toString();
        }

        CompilerError error = new CompilerError(lexeme, line, charPositionInLine,
                errorType, msg, filePath, fileName);

        errors.add(error);
    }


    /**
     * Checks if any errors were collected.
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }
}