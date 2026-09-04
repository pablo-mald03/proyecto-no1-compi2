lexer grammar YLexer;

//VIRTUAL TOKENS
tokens {
    INDENT,
    DEDENT
}


// IGNORED CHARACTERS
COMMENT
    : '//' ~[\r\n]*
      -> channel(HIDDEN)
    ;

BLOCK_COMMENT
    : '/*' .*? '*/'
      -> channel(HIDDEN)
    ;

// El NEWLINE solo consume the first enter.
// This is the principal flag to init the stack analysis.
NEWLINE
    : ( '\r'? '\n' | '\r' )
    ;

WS
    : [ \t]+
      -> channel(HIDDEN)
    ;


//SECTION OF CODE BLOCK
STRUCTURES_REGION:'%estructuras';
FUNCTION_REGION: '%funciones';


//SECTION OF SPECIAL OPERATORS
LAMBDA: '->';


//SECTION OF FUNCTION ACTIONS
PRINT: 'imprimir';
READ: 'leer';



//SECTION OF KEYWORDS

//--- IF-ELSE
DEFINE: 'definir';
IF: 'si';
ELSE_IF: 'sino';
ELSE: 'contrario';
SO: 'entonces';

//--- SWITCH-CASE
SWITCH:'elegir';
CASE:'caso';
BREAK:'romper';
ALWAYS:'siempre';

//--- FOR-LOOP
FOR: 'para';

//--- WHILE-LOOP
WHILE: 'mientras';

//--- DO-WHILE-LOOP
DO: 'hacer';

//--- BREAK FLOW ACTIONS
RETURN: 'retornar';
CONTINUE: 'continuar';



//SECTION OF VARIABLE TYPES
INTEGER: 'entero';
STRING: 'cadena';
FLOAT: 'flotante';
CHARACTER: 'caracter';
BOOLEAN: 'bool';


//BOOLEAN VALUES
TRUE: 'verdadero';
FALSE: 'falso';


//SECTION OF SPECIAL OPERATORS OR PUNCTUATION
EQUAL: '=';
COMMA: ',';
DOT_COMMA: ';';
TWO_POINTS: ':';
DOT: '.';

//SECTION OF THE GROUPING SYMBOLS
INIT_BRACE: '{';
FINAL_BRACE: '}';

INIT_BRACKET: '[';
FINAL_BRACKET: ']';

INIT_PARENT: '(';
FINAL_PARENT: ')';

//SECTION TO THE ABREVIATION OPERATORS

ABREV_PLUS: '++';
ABREV_MINUS: '--';


//SECTION OF ARITHMETIC OPERATORS

PLUS: '+';
MINUS: '-';
MULTIPLICATION: '*';
DIVIDE: '/';


//SECTION OF RELATIONAL OPERATORS

EQUALS: '==';
GREATER_EQUALS: '>=';
LESS_EQUALS: '<=';
DIFERENCE: '!=';
LESS: '<';
GREATER: '>';

//SECTION OF LOGIC OPERATORS

AND: '&&';
OR: '||';
NOT: '!';


//SECTION OF VALUES
ID: [a-zA-Z_] [a-zA-Z0-9_]* ;

INT: [0-9]+ ;

DECIMAL: [0-9]+ '.' [0-9]+ ;

TEXT: '"' ( '\\' . | ~["\\\r\n] )* '"' ;

CHAR: '\'' ( '\\' . | ~['\\\r\n] ) '\'' ;


ERROR_TOKEN
    : .
    ;