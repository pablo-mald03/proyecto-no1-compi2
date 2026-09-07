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
    | function_call NEWLINE+                    #StatementFunctionCall
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
    | accessor EQUAL expression  #ForInitAssign
    ;

/*** FOR UPDATE STATEMENT PRODUCTION ****/
for_update
    : accessor ABREV_PLUS         #ForUpdateIncrement
    | accessor ABREV_MINUS        #ForUpdateDecrement
    | ABREV_PLUS accessor         #ForUpdatePrefixIncrement
    | ABREV_MINUS accessor        #ForUpdatePrefixDecrement
    | accessor EQUAL expression   #ForUpdateAssign
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

/*---*******---- INCREMENT / DECREMENT PRODUCTIONS (SUFIX AND PREFIX) ----*******---*/
abbreviated_operation
    : accessor ABREV_PLUS NEWLINE+    #IncOperation
    | accessor ABREV_MINUS NEWLINE+   #DecOperation
    | ABREV_PLUS accessor NEWLINE+    #IncPrevOperation
    | ABREV_MINUS accessor NEWLINE+   #DecPrevOperation
    ;

/*---*******---- COMPOUND ASSIGNMENT PRODUCTIONS ----*******---*/
compound_assignment
    : accessor BY_ONE_ADD expression NEWLINE+             #CompoundAddAssignment
    | accessor BY_ONE_MINUS expression NEWLINE+           #CompoundSubAssignment
    | accessor BY_ONE_MULTIPLICATION expression NEWLINE+  #CompoundMulAssignment
    | accessor BY_ONE_DIVISION expression NEWLINE+        #CompoundDivAssignment
    | accessor BY_ONE_PERCENT expression NEWLINE+         #CompoundModAssignment
    ;

/*---*******---- FUNCTION CALLING PRODUCTIONS ----*******---*/
function_call
    : ID INIT_PARENT expression_list? FINAL_PARENT   #FunctionCalling
    ;

/*** VARIABLE DECLARATIONS MULTI-DIMENSIONAL ARRAYS ALLOWED ****/

variable_declaration
    : type ID                                                             #NotDefiniedVariable
    | type ID EQUAL expression                                            #DefiniedVariable
    | type ID (INIT_BRACKET expression FINAL_BRACKET)+                    #NotDefiniedArrayVariable
    | type ID (INIT_BRACKET expression FINAL_BRACKET)+ EQUAL expression   #DefiniedArrayVariable
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
    : TEXT                                          # ValueString
    | CHAR                                          # ValueChar
    | DECIMAL                                       # ValueDecimal
    | INT                                           # ValueInt
    | boolean_values                                # ValueBool
    | function_call                                 # ValueFunctionCall
    | read_call                                     # ValueReadCall
    | accessor                                      # ValueAccessorCall
    | INIT_BRACE expression_list FINAL_BRACE        # InitValueArrayLiteral
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
    : accessor DOT ID                                       #AccessorPropertyChain
    | accessor INIT_BRACKET expression FINAL_BRACKET        #AccessorArrayChain
    | ID                                                    #AccessorBase
    ;

/*** NEW LINE PRODUCTION ****/
skip_lines
    : NEWLINE+
    ;