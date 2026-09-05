parser grammar ZParser;

options {
    tokenVocab=ZLexer;
}

program:
    code*
    ;

code
    : RETURN
    ;