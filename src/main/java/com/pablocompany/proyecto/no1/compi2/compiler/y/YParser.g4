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
    : STRUCTURES_REGION NEWLINE+ struct_declaration*            #StructRegionDeclaration
    ;

/*** STRUCT DECLARATION ****/
struct_declaration
    : STRUCT ID TWO_POINTS NEWLINE INDENT struct_field* DEDENT skip_lines?      #StructDeclaration
    ;

/*** STRUCT FIELDS ****/
struct_field
    : type ID NEWLINE+                                              #StructNormalProperty
    | type ID INIT_BRACKET expression FINAL_BRACKET NEWLINE+        #StructArrayProperty
    ;


/*---*******---- FUNCTIONS PRODUCTIONS ----*******---*/

functions_region
    : FUNCTION_REGION NEWLINE+ function_declaration*        #FunctionSection
    ;

/*** FUNCION DECLARATION FIELDS ****/

function_declaration
    : DEFINE ID INIT_PARENT parameter_list? FINAL_PARENT (LAMBDA type)? TWO_POINTS NEWLINE INDENT statement* DEDENT skip_lines?     #FunctionDeclaration
    ;

/*** PARAMETER FIELDS ****/
parameter_list
    : parameter (COMMA parameter)*      #ParameterList
    ;

/*** FUNCTION PARAMETER FIELDS ****/

parameter
    : type ID                                   #PrimitiveParameter
    | INIT_BRACKET FINAL_BRACKET type ID        #ArrayParameter
    | INIT_BRACE FINAL_BRACE ID ID              #StructParameter
    ;


/*---*******---- INSTRUCTION AND TYPES PRODUCTIONS ----*******---*/

/*** VARIABLE STATEMENTS ****/
statement
    : variable_declaration NEWLINE+         #VariableDeclarationStatement
    | assignment NEWLINE+                   #AssignmentVariableStatement
    | RETURN expression? NEWLINE+           #ReturnStatement
    ;

/*** VARIABLE DECLARATIONS ****/
variable_declaration
    : type ID                       #NotDefiniedVariable
    | type ID EQUAL expression      #DefiniedVariable
    ;


/*** ASSIGNMENT DECLARATIONS ****/
assignment
    : accessor EQUAL expression         #AssingmentStatement
    ;


/*** TYPES PRODUCTIONS ****/
type
    : INTEGER           #IntValue
    | STRING            #StringValue
    | FLOAT             #FloatValue
    | CHARACTER         #CharValue
    | BOOLEAN           #BooleanValue
    | ID                #CustomTypeValue
    ;


/*** EXPRESSION PRODUCTIONS ****/
expression
    : INIT_PARENT expression FINAL_PARENT                                           # ExpressionParents
    | op=(NOT | MINUS) expression                                                   # ExpressionUnary
    | expression op=(MULTIPLICATION | DIVIDE) expression                            # ExpressionMultDiv
    | expression op=(PLUS | MINUS) expression                                       # ExpressionAddSub
    | expression op=(LESS | GREATER | LESS_EQUALS | GREATER_EQUALS) expression      # ExpressionRelational
    | expression op=(EQUALS | DIFERENCE) expression                                 # ExpressionEquality
    | expression AND expression                                                     # ExpressionAnd
    | expression OR expression                                                      # ExpressionOr
    | normal_values                                                                 # ExpressionValue
    ;

/*--------****--- PRINCIPAL VALUES DATA ---****--------*/
normal_values
    : STRING                                        # ValueString
    | CHAR                                          # ValueChar
    | DECIMAL                                       # ValueDecimal
    | INT                                           # ValueInt
    | boolean_values                                # ValueBool
    /*| array_call                                    # ValueArrayCall
    | function_call                                 # ValueFunctionCall
    | struct_values                                 # ValueStructNestValue
    | struct_literal                                # ValueStructPropertyLiteral*/
    | INIT_BRACE expression_list FINAL_BRACE        # InitValueArrayLiteral
    | ID                                            # ValueIdCall
    ;

/*** BOOLEAN VALUES ****/

boolean_values
    : TRUE     # BoolTrue
    | FALSE    # BoolFalse
    ;

/*** EXPRESSION LIST ****/

expression_list
    : expression (COMMA expression)*        #ExpressionList
    ;

/*** ACCESSOR DECLARATIONS  (NESTED VALUES) ****/
accessor
    : ID (DOT ID)*              #AccessNested
    ;

/*** NEW LINE PRODUCTION ****/
skip_lines
    : NEWLINE+
    ;



