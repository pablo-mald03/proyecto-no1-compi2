package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.parsing;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.highlight.ErrorType;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.AstBuilder;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsing.ParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.common.infrastructure.parsing.AstBuilderFactory;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinParser;
import com.pablocompany.proyecto.no1.compi2.piglatin.domain.semantic.PigLatinAstNode;
import com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure.errors.PigLatinErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Principal class to execute the semantic parsing .pig phase
 *
 */
public class PigLatinParserAnalyzer implements ParserAnalyzer {

    /**
     * Principal method to execute the parsing phase
     */
    @Override
    public void parse(EditorContext context) {
        String source = context.getSourceCode();
        if (source == null || source.isEmpty()) {
            return;
        }

        context.clearParsingErrors();

        String filePath = context.getFilePath();
        String fileName = context.getFileName();

        PigLatinLexer lexer = new PigLatinLexer(CharStreams.fromString(source));
        lexer.removeErrorListeners();
        PigLatinErrorListener lexerListener = new PigLatinErrorListener(ErrorType.LEXIC, filePath, fileName);
        lexer.addErrorListener(lexerListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);


        context.clearParsingErrors();

        PigLatinParser parser = new PigLatinParser(tokens);
        parser.removeErrorListeners();
        PigLatinErrorListener parserListener = new PigLatinErrorListener(ErrorType.SYNTACTIC, filePath, fileName);
        parser.addErrorListener(parserListener);

        ParseTree yParseTree = parser.program();

        //Update context execution state with collected CompilerError objects
        context.setParseTree(yParseTree);
        context.setLexicalErrors(lexerListener.getErrors());
        context.setParserErrors(parserListener.getErrors());

        boolean hasErrors = lexerListener.hasErrors() || parserListener.hasErrors();
        context.setParsed(!hasErrors);

        if (hasErrors) {
            return;
        }

        AstBuilder builder = AstBuilderFactory.getBuilder(".pig");
        if (builder != null) {
            PigLatinAstNode ast = builder.build(context);
            context.setAstNode(ast);
        }

    }

    /**
     * Generate C code from the parsed context
     */
    private String generateCCompiledCode(EditorContext context) {
        // this method set the compiled code
        return "#include <stdio.h>\n\n" +
                "int main() {\n" +
                "    int numero;\n" +
                "    printf(\"Ingrese un numero: \");\n" +
                "    scanf(\"%d\", &numero);\n" +
                "    printf(\"El numero ingresado fue: %d\\n\", numero);\n" +
                "    return 0;\n" +
                "}";
    }

}
