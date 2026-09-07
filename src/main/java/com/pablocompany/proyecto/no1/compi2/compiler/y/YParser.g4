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
    : STRUCTURES_REGION NEWLINE+ struct_declaration*                #StructRegionDeclaration
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
    : block_statement                           #StatementBlock
    | console_actions                           #StatementConsoleAction
    | loop_control                              #StatementLoopControl
    | abbreviated_operation                     #StatementAbbreviatedOperation
    | compound_assignment                       #StatementCompoundAssignment
    | struct_declaration                        #StatementStructDeclaration
    | variable_declaration NEWLINE+             #VariableDeclarationStatement
    | assignment NEWLINE+                       #AssignmentVariableStatement
    | RETURN expression? NEWLINE+               #ReturnStatement
    ;

/*---*******---- CONTROL FLOW PRODUCTIONS ----*******---*/

block_statement
    : if_statement                      #BlockIf
    | switch_statement                  #BlockSwitch
    | while_statement                   #BlockWhile
    | do_while_statement                #BlockDoWhile
    | for_statement                     #BlockFor
    ;

/*** IF PRODUCTIONS ****/
if_statement
    : IF INIT_PARENT expression FINAL_PARENT SO NEWLINE INDENT statement* DEDENT else_if_list? else_block?   #IfStatement
    ;

/*** ELSE-IF LIST PRODUCTION ****/
else_if_list
    : else_if_clause+       #ElseIfList
    ;

/*** ELSE-IF CLAUSULE PRODUCTION ****/
else_if_clause
    : ELSE_IF INIT_PARENT expression FINAL_PARENT SO NEWLINE INDENT statement* DEDENT   #ElseIfClause
    ;

/*** ELSE PRODUCTION ****/
else_block
    : ELSE NEWLINE INDENT statement* DEDENT     #ElseBlock
    ;

/*** SWITCH PRODUCTIONS ****/
switch_statement
    : SWITCH INIT_PARENT expression FINAL_PARENT TWO_POINTS NEWLINE INDENT switch_case* always_case? DEDENT   #SwitchStatement
    ;

/*** CASE PRODUCTION ****/
switch_case
    : CASE expression TWO_POINTS NEWLINE INDENT statement* DEDENT   #SwitchCase
    ;

/*** DEFAULT PRODUCTION ****/
always_case
    : ALWAYS TWO_POINTS NEWLINE INDENT statement* DEDENT   #AlwaysCase
    ;

/*** LOOPS PRODUCTIONS ****/

while_statement
    : WHILE INIT_PARENT expression FINAL_PARENT DO NEWLINE INDENT statement* DEDENT   #WhileStatement
    ;

/*** DO WHILE PRODUCTION ****/

do_while_statement
    : DO TWO_POINTS NEWLINE INDENT statement* DEDENT WHILE INIT_PARENT expression FINAL_PARENT NEWLINE+   #DoWhileStatement
    ;

/*** FOR PRODUCTIONS STATEMENTS ****/
for_statement
    : FOR INIT_PARENT for_init? DOT_COMMA expression? DOT_COMMA for_update? FINAL_PARENT TWO_POINTS NEWLINE INDENT statement* DEDENT   #ForStatement
    ;

/*** FOR INIT STATEMENT PRODUCTION ****/
for_init
    : type ID EQUAL expression   #ForInitVarDecl
    | nest_variable EQUAL expression  #ForInitAssign
    ;

/*** FOR UPDATE STATEMENT PRODUCTION ****/
for_update
    : nest_variable ABREV_PLUS         #ForUpdateIncrement
    | nest_variable ABREV_MINUS        #ForUpdateDecrement
    | ABREV_PLUS nest_variable         #ForUpdatePrefixIncrement
    | ABREV_MINUS nest_variable        #ForUpdatePrefixDecrement
    | nest_variable EQUAL expression   #ForUpdateAssign
    ;

/*** BREAK FLOW PRODUCTIONS ****/
loop_control
    : CONTINUE NEWLINE+   #LoopContinue
    | BREAK NEWLINE+      #LoopBreak
    ;

/*---*******---- CONSOLE ACTIONS PRODUCTIONS ----*******---*/
console_actions
    : PRINT INIT_PARENT expression FINAL_PARENT NEWLINE+   #PrintAction
    | read_call NEWLINE+                                    #ReadAction
    ;

/*** READ CALL PRODUCTION ****/
read_call
    : READ INIT_PARENT FINAL_PARENT   #ReadCall
    ;

/*------ INCREMENT / DECREMENT PRODUCTIONS (PREFIX AND SUFIX) ------*/
abbreviated_operation
    : nest_variable ABREV_PLUS DOT_COMMA    # IncSufixOperation
    | nest_variable ABREV_MINUS DOT_COMMA   # DecSufixOperation
    | ABREV_PLUS nest_variable  DOT_COMMA   # IncPrefixOperation
    | ABREV_MINUS nest_variable  DOT_COMMA   # DecPrefixOperation
    ;

/*---*******---- COMPOUND ASSIGNMENT PRODUCTIONS ----*******---*/
/*------ COMPOUND ASSIGNMENT PRODUCTIONS ------*/
compound_assignment
    : nest_variable BY_ONE_ADD expression DOT_COMMA                 # CompoundAddAssignment
    | nest_variable BY_ONE_MINUS expression DOT_COMMA               # CompoundSubAssignment
    | nest_variable BY_ONE_MULTIPLICATION expression DOT_COMMA      # CompoundMulAssignment
    | nest_variable BY_ONE_DIVISION expression DOT_COMMA            # CompoundDivAssignment
    | nest_variable BY_ONE_PERCENT expression DOT_COMMA             # CompoundModAssignment
    ;

/*** ASSIGNMENT DECLARATIONS ****/
assignment
    : nest_variable EQUAL expression         #AssingmentStatement
    ;



/*--------****--- ASSIGNMENT / OPERATION TARGET ---****--------*/
nest_variable
    : object_values   # NestedVariable
    ;

/*--------****--- OBJECT AND ARRAY ACCESS CHAINS ---****--------*/
object_values
    : object_values DOT ID                                                  # ObjectPropertyChain
    | object_values INIT_BRACKET expression FINAL_BRACKET                   # ObjectArrayAccessChain
    | ID INIT_PARENT arguments_list? FINAL_PARENT                           # BaseFunctionCall
    | ID                                                                    # BaseIdentifier
    ;

/*--------****--- ARGUMENTS FOR FUNCTIONS LIST---****--------*/

arguments_list
    : expression (COMMA expression)*            #ArgumentsList
    ;

/*--------****--- OPERATIONS WITH ARRAY VALUES---****--------*/


/*--------****--- ARRAY VALUES ---****--------*/
array_literal
    : INIT_BRACE array_values? FINAL_BRACE   # ArrayLiteralValue
    ;

/*--------****--- ARRAY VALUES ---****--------*/

array_values
    : expression (COMMA expression)*   # ArrayValuesList
    ;


/*** VARIABLE DECLARATIONS MULTI-DIMENSIONAL ARRAYS ALLOWED ****/

variable_declaration
    : type ID                                                             #NotDefiniedVariable
    | type ID EQUAL expression                                            #DefiniedVariable
    | type ID (INIT_BRACKET expression FINAL_BRACKET)+                    #NotDefiniedArrayVariable
    | type ID (INIT_BRACKET expression FINAL_BRACKET)+ EQUAL expression   #DefiniedArrayVariable
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
    : TEXT                                          # ValueString
    | CHAR                                          # ValueChar
    | DECIMAL                                       # ValueDecimal
    | INT                                           # ValueInt
    | boolean_values                # ValBool
    | object_values                 # ValObjectAccess
    | array_literal                 # ValArrayLiteral
    | read_call                     # ValReadCall
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

/*** NEW LINE PRODUCTION ****/
skip_lines
    : NEWLINE+
    ;