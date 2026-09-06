parser grammar YParser;

options {
    tokenVocab=YLexer;
}

/*Initial production*/
program
    : skip_lines? structures_region? functions_region skip_lines? EOF
    ;


/*---*******---- STRUCTURES PRODUCTIONS ----*******---*/
structures_region
    : STRUCTURES_REGION NEWLINE+ struct_declaration*
    ;

/*** STRUCT DECLARATION ****/
struct_declaration
    : STRUCT ID TWO_POINTS NEWLINE INDENT struct_field* DEDENT skip_lines?
    ;

/*** STRUCT FIELDS ****/
struct_field
    : type ID NEWLINE+
    | type ID INIT_BRACKET INT FINAL_BRACKET NEWLINE+
    ;


/*---*******---- FUNCTIONS PRODUCTIONS ----*******---*/

functions_region
    : FUNCTION_REGION NEWLINE+ function_declaration*
    ;

/*** FUNCION DECLARATION FIELDS ****/

function_declaration
    : DEFINE ID INIT_PARENT parameter_list? FINAL_PARENT (LAMBDA type)? TWO_POINTS NEWLINE INDENT statement* DEDENT skip_lines?
    ;

/*** PARAMETER FIELDS ****/
parameter_list
    : parameter (COMMA parameter)*
    ;

/*** FUNCTION PARAMETER FIELDS ****/

parameter
    : type ID
    | INIT_BRACKET FINAL_BRACKET type ID
    | INIT_BRACE FINAL_BRACE ID ID
    ;


/*---*******---- INSTRUCTION AND TYPES PRODUCTIONS ----*******---*/

/*** VARIABLE STATEMENTS ****/
statement
    : variable_declaration NEWLINE+
    | assignment NEWLINE+
    | RETURN expression NEWLINE+
    | expression NEWLINE+
    ;

/*** VARIABLE DECLARATIONS ****/
variable_declaration
    : type ID
    | type ID EQUAL expression
    ;


/*** ASSIGNMENT DECLARATIONS ****/
assignment
    : accessor EQUAL expression
    ;


/*** TYPES PRODUCTIONS ****/
type
    : INTEGER
    | STRING
    | FLOAT
    | CHARACTER
    | BOOLEAN
    | ID
    ;


/*** EXPRESSION PRODUCTIONS ****/
expression
    : INIT_BRACE expression_list FINAL_BRACE
    | accessor
    | INT
    | DECIMAL
    | CHAR
    // ... más reglas de expresiones
    ;

/*--------****--- PRINCIPAL VALUES DATA ---****--------*/
normal_values
    : STRING                    # ValueString
    | CHAR                      # ValueChar
    | DECIMAL                   # ValueDecimal
    | INT                       # ValueInt
    | boolean_values            # ValueBool
    | array_call                # ValueArrayCall
    | function_call             # ValueFunctionCall
    | struct_values             # ValueStructNestValue
    | struct_literal            # ValueStructPropertyLiteral
    | array_initialization      # ValueArrayLiteral
    | ID                        # ValueIdCall
    ;


/*** EXPRESSION LIST ****/

expression_list
    : expression (COMMA expression)*
    ;

/*** ACCESSOR DECLARATIONS  (NESTED VALUES) ****/
accessor
    : ID (DOT ID)*
    ;

/*** NEW LINE PRODUCTION ****/
skip_lines
    : NEWLINE+
    ;



