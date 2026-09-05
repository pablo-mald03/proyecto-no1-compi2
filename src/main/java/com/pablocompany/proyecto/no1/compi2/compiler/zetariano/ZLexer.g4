lexer grammar ZLexer;

// IGNORED CHARACTERS
COMMENT
    : '//' ~[\r\n]*
      -> channel(HIDDEN)
    ;

BLOCK_COMMENT
    : '/*' .*? '*/'
      -> channel(HIDDEN)
    ;

WS: [ \t\r\n]+
    -> channel(HIDDEN)
    ;


//SPECIAL POINTER OPERATORS
NEW:'new';
NULL: 'null';

//ACCESS MODIFIERS
PUBLIC: 'public';


//SECTION OF FUNCTION ACTIONS

//---Print action:
READ: 'readln';
PRINTLN: 'println';
PRINT: 'print';


//SECTION OF KEYWORDS

//--- IF-ELSE
IF: 'if';
ELSE: 'else';

//--- SWITCH-CASE
SWITCH:'switch';
CASE:'case';
BREAK:'break';
DEFAULT:'default';

//--- FOR-LOOP
FOR: 'for';

//--- WHILE-LOOP
WHILE: 'while';

//--- DO-WHILE-LOOP
DO: 'do';

//--- BREAK FLOW ACTIONS
RETURN: 'return';
CONTINUE: 'continue';

//--- CLASSES
CLASS: 'class';

//SECTION OF VARIABLE TYPES
INTEGER: 'int';
DOUBLE: 'double';
CHARACTER: 'char';
BOOLEAN: 'boolean';
VOID: 'void';


//BOOLEAN VALUES
TRUE: 'true';
FALSE: 'false';


//SECTION OF SPECIAL OPERATORS OR PUNCTUATION

EQUAL: '=';
COMMA: ',';
DOT_COMMA: ';';
TWO_POINTS: ':';
QUESTION: '?';
DOT: '.';


//SECTION OF THE GROUPING SYMBOLS

INIT_BRACE: '{';
FINAL_BRACE: '}';

INIT_BRACKET: '[';
FINAL_BRACKET: ']';

INIT_PARENT: '(';
FINAL_PARENT: ')';


//SECTION TO THE ABREVIATION OPERATORS

BY_ONE_ADD: '+=';
BY_ONE_MINUS: '-=';
BY_ONE_MULTIPLICATION: '*=';
BY_ONE_DIVISION: '/=';
BY_ONE_PERCENT: '%=';


//SECTION TO THE ABREVIATION OPERATORS

ABREV_PLUS: '++';
ABREV_MINUS: '--';


//SECTION OF ARITHMETIC OPERATORS

PLUS: '+';
MINUS: '-';
MULTIPLICATION: '*';
DIVIDE: '/';
PERCENT: '%';


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