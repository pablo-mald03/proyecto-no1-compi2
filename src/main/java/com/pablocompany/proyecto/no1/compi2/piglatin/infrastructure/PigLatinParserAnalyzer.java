package com.pablocompany.proyecto.no1.compi2.piglatin.infrastructure;

import com.pablocompany.proyecto.no1.compi2.common.domain.contex.EditorContext;
import com.pablocompany.proyecto.no1.compi2.common.domain.parsingstep.ParserAnalyzer;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinLexer;
import com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic.PigLatinParser;
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

        PigLatinLexer lexer = new PigLatinLexer(CharStreams.fromString(context.getSourceCode()));
        CommonTokenStream tokens = new CommonTokenStream(lexer);


        context.clearParsingErrors();

        PigLatinParser parser = new PigLatinParser(tokens);

        ParseTree yParseTree = parser.program();

        // Update context execution state
        context.setParseTree(yParseTree);
        /*
        context.setParserErrors(errors);*/
        context.setParsed(true);
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
