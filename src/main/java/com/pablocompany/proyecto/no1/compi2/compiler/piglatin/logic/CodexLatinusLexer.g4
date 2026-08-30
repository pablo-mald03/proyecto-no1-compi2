lexer grammar CodexLatinusLexer;

//======================================
// LEXICAL PART OF THE DOCUMENT
//======================================


//IGNORED CHARACTERS
COMMENT
    : '//' ~[\r\n]*
      -> channel(HIDDEN)
    ;

BLOCK_COMMENT
    : '##'+ .*? '##'+
      -> channel(HIDDEN)
    ;

WS: [ \t\r\n]+
    -> channel(HIDDEN)
    ;


//SECTION OF CODE BLOCK
VARIABILES:'VARIABILES';
MUNERA: 'MUNERA';
MAIOR:'MAIOR';
FINIS_SEPARATOR: 'FINIS';

//SECTION OF FUNCTION ACTIONS
PRINT: '>>';
READ: '<<';


//SECTION OF VARIABLE TYPES
NUMERUS: 'numerus';
TEXTUM: 'textum';
DECIMALIS: 'decimalis';
LITTERA: 'littera';
BOOLEAN: 'bool';

//BOOLEAN VALUES
VERUM: 'verum';
FALSUS: 'falsus';


//SECTION OF SPECIAL CHARACTERS
ESTO: 'esto';
SERIES: 'series';
STRUCTURE: 'structura';
FINIS: 'finis';

DUM: 'dum';
FACERE: 'facere';
PER: 'per';
SI: 'si';
ALITER: 'aliter';
ACTIO: 'actio';
RATIO: 'ratio';
REDDERE: 'reddere';

//BREAK ACTIONS
PERGE: 'perge';
INTERRUMPE: 'interrumpe';

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
NOT: 'non';


//SECTION OF VALUES
ID: [a-zA-Z_] [a-zA-Z0-9_]* ;

INT: [0-9]+ ;

DECIMAL: [0-9]+ '.' [0-9]+ ;

STRING: '"' ( '\\' . | ~["\\\r\n] )* '"' ;

CHAR: '\'' ( '\\' . | ~['\\\r\n] ) '\'' ;


ERROR_TOKEN
    : . 
    ;