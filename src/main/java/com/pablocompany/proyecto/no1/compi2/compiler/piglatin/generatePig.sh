#!/bin/bash

ANTLR_JAR="/home/pablo03/compilator_java_resources/antlr-4.13.2-complete.jar"

GRAMMAR_PARSER="CodexLatinusParser.g4"

GRAMMAR_LEXER="CodexLatinusLexer.g4"

PACKAGE="com.pablocompany.proyecto.no1.compi2.compiler.piglatin"

OUTPUT_DIR="logic"

echo "======================================"
echo " Generando parser de Pig Latin con ANTLR4"
echo "======================================"

java -jar "$ANTLR_JAR" \
    -visitor \
    -listener \
    -long-messages \
    -package "$PACKAGE" \
    -o "$OUTPUT_DIR" \
    "$GRAMMAR_LEXER" \
    "$GRAMMAR_PARSER"


echo ""
echo "Generación de Pig Latin finalizada."
