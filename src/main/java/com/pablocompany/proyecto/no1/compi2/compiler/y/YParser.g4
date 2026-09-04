parser grammar YParser;

options {
    tokenVocab=YLexer;
}

program:
    code*
    ;

code
    : STRUCTURES_REGION
    ;