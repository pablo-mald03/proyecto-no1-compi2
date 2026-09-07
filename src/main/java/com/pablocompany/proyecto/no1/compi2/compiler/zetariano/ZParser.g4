parser grammar ZParser;

options {
    tokenVocab=ZLexer;
}

/*===*****========*****===== PROGRAM ROOT SECTION ===*****==========*****===*/
program
    : class_declaration EOF
    ;

/*===*****========*****===== CLASS SECTION ===*****==========*****===*/

class_declaration
    : PUBLIC CLASS ID INIT_BRACE class_member* FINAL_BRACE   # ClassDeclaration
    ;

/*------ CLASS MEMBER PRODUCTIONS (CONSTRUCTOR/ATTRIBUTES) ------*/
class_member
    : variable_declaration          # ClassFieldMember
    | constructor_declaration       # ClassConstructorMember
    | method_declaration            # ClassMethodMember
    ;

/*------ CONSTRUCTOR PRODUCTION ------*/
constructor_declaration
    : PUBLIC ID INIT_PARENT parameter_list? FINAL_PARENT INIT_BRACE statement* FINAL_BRACE   # ConstructorDeclaration
    ;

/*------ METHOD PRODUCTION ------*/
method_declaration
    : PUBLIC type ID INIT_PARENT parameter_list? FINAL_PARENT INIT_BRACE statement* FINAL_BRACE   # MethodDeclaration
    ;

/*------ PARAMETER LIST PRODUCTIONS ------*/
parameter_list
    : parameter (COMMA parameter)*   # ParameterList
    ;

/*------ PARAMETER PRODUCTION ------*/
parameter
    : type (INIT_BRACKET FINAL_BRACKET)* ID   # ParameterStatement
    ;

/*===*****===== STATEMENT SECTION =====*****===*/
/*===*****========*****===== STATEMENTS (METHOD/CONSTRUCTOR BODY) ===*****==========*****===*/

statement
    : block_statement                   # StatementBlock
    | console_actions                   # StatementConsoleAction
    | function_call DOT_COMMA           # StatementFunctionCall
    | loop_control                      # StatementLoopControl
    | return_statement                  # StatementReturn
    | abbreviated_operation             # StatementAbbreviatedOperation
    | compound_assignment               # StatementCompoundAssignment
    | nested_variables_usage            # StatementNestedAssignment
    | array_redefined_ussage            # StatementArrayAssignment
    | variable_ussage                   # StatementVariableAssignment
    | variable_declaration              # StatementVariableDeclaration
    ;

/*------ RETURN STATEMENT ------*/
return_statement
    : RETURN expression? DOT_COMMA          # ReturnStatement
    ;

/*------ LOOP CONTROL STATEMENTS ------*/
loop_control
    : CONTINUE DOT_COMMA        # LoopContinue
    | BREAK DOT_COMMA           # LoopBreak
    ;

/*------ OUTPUT ACTIONS ------*/
console_actions
    : PRINTLN INIT_PARENT expression FINAL_PARENT DOT_COMMA         # PrintlnAction
    | PRINT INIT_PARENT expression FINAL_PARENT DOT_COMMA           # PrintAction
    | read_call DOT_COMMA                                           # ReadAction
    ;

/*------ INPUT ACTIONS ------*/
read_call
    : READ INIT_PARENT FINAL_PARENT   # ReadCall
    ;

/*===*****===== COMMON CODE SECTION =====*****===*/

block_statement
    : if_statement              # BlockIf
    | switch_statement          # BlockSwitch
    | while_statement           # BlockWhile
    | do_while_statement        # BlockDoWhile
    | for_statement             # BlockFor
    ;

/*------ STATEMENT BODY PRODUCTION ------*/
statement_body
    : INIT_BRACE statement* FINAL_BRACE   # BracedStatementBody
    | statement                            # SingleStatementBody
    ;

/*------ IF STATEMENT PRODUCTION ------*/
if_statement
    : IF INIT_PARENT expression FINAL_PARENT statement_body else_if_list? else_block?   # IfStatement
    ;

/*------ ELSE IF LIST STATEMENT PRODUCTION ------*/
else_if_list
    : else_if_clause+
    ;

/*------ ELSE IF STATEMENT PRODUCTION ------*/
else_if_clause
    : ELSE IF INIT_PARENT expression FINAL_PARENT statement_body   # ElseIfClause
    ;

/*------ ELSE STATEMENT PRODUCTION ------*/

else_block
    : ELSE statement_body   # ElseBlock
    ;

/*------ SWITCH STATEMENT PRODUCTION ------*/
switch_statement
    : SWITCH INIT_PARENT expression FINAL_PARENT INIT_BRACE switch_case* default_case? FINAL_BRACE   # SwitchStatement
    ;

/*------ CASE INSTRUCTION PRODUCTION ------*/
switch_case
    : CASE expression TWO_POINTS statement*   # SwitchCase
    ;

/*------ DEFAULT INSTRUCTION PRODUCTION ------*/
default_case
    : DEFAULT TWO_POINTS statement*   # DefaultCase
    ;

/*------ LOOPS ------*/

while_statement
    : WHILE INIT_PARENT expression FINAL_PARENT statement_body   # WhileStatement
    ;

/*------ DO WHILE STATEMENT PRODUCTION ------*/
do_while_statement
    : DO statement_body WHILE INIT_PARENT expression FINAL_PARENT DOT_COMMA   # DoWhileStatement
    ;

/*------ FOR STATEMENT PRODUCTION  (ALLOWS THE INFINITE LOOP) ------*/
for_statement
    : FOR INIT_PARENT for_init? DOT_COMMA expression? DOT_COMMA for_update? FINAL_PARENT statement_body   # ForStatement
    ;

/*------ FOR INITIAL STATEMENT PRODUCTION (INITIAL ITERATOR VALUE) ------*/
for_init
    : type (INIT_BRACKET FINAL_BRACKET)* ID EQUAL expression   # ForInitVarDecl
    | ID EQUAL expression                                       # ForInitAssign
    ;

/*------ FOR UPDATE STATEMENT PRODUCTION------*/
for_update
    : ID ABREV_PLUS        # ForUpdateIncrement
    | ID ABREV_MINUS       # ForUpdateDecrement
    | ID EQUAL expression  # ForUpdateAssign
    ;

/*===*****===== VARIABLES AND ASSIGNMENT SECTION =====*****===*/

/*------ VARIABLE DECLARATION PRODUCTION (ALLOW MULTI-DIMENSIONAL ARRAYS)------*/
variable_declaration
    : type (INIT_BRACKET FINAL_BRACKET)* ID (EQUAL expression)? DOT_COMMA   # VariableDeclaration
    ;

/*------ ASSIGNMENT PRODUCTIONS ------*/
variable_ussage
    : ID EQUAL expression DOT_COMMA   # NormalVariableAssignment
    ;

/*------ REDEFINIED PRODUCTION OF ARRAY USSAGE ------*/
array_redefined_ussage
    : ID INIT_BRACKET expression FINAL_BRACKET EQUAL expression DOT_COMMA   # ArrayIndexAssignment
    ;

/*------ NESTED VALUES PRODUCTIONS------*/
nested_variables_usage
    : object_values EQUAL expression DOT_COMMA   # NestedObjectAssignment
    ;


/*------ COMPOUND ASSIGNMENT PRODUCTIONS ------*/
compound_assignment
    : nest_variable BY_ONE_ADD expression DOT_COMMA                 # CompoundAddAssignment
    | nest_variable BY_ONE_MINUS expression DOT_COMMA               # CompoundSubAssignment
    | nest_variable BY_ONE_MULTIPLICATION expression DOT_COMMA      # CompoundMulAssignment
    | nest_variable BY_ONE_DIVISION expression DOT_COMMA            # CompoundDivAssignment
    | nest_variable BY_ONE_PERCENT expression DOT_COMMA             # CompoundModAssignment
    ;

/*------ INCREMENT / DECREMENT PRODUCTIONS (PREFIX AND SUFIX) ------*/
abbreviated_operation
    : nest_variable ABREV_PLUS DOT_COMMA    # IncSufixOperation
    | nest_variable ABREV_MINUS DOT_COMMA   # DecSufixOperation
    | ABREV_PLUS nest_variable  DOT_COMMA   # IncPrefixOperation
    | ABREV_MINUS nest_variable  DOT_COMMA   # DecPrefixOperation
    ;

/*--------****--- ASSIGNMENT / OPERATION TARGET ---****--------*/
nest_variable
    : object_values   # NestedObjectVariable
    | array_call       # NestedArrayVariable
    | ID                # NestedSingleVariable
    ;

/*--------****--- OBJECT AND ARRAY ACCESS CHAINS ---****--------*/

object_values
    : object_values DOT ID                                                  # ObjectPropertyChain
    | object_values DOT ID INIT_PARENT arguments_list? FINAL_PARENT         # ObjectMethodChain
    | object_values INIT_BRACKET expression FINAL_BRACKET                   # ObjectArrayAccessChain
    | ID DOT ID                                                             # ObjectBaseProperty
    | ID DOT ID INIT_PARENT arguments_list? FINAL_PARENT                    # ObjectBaseMethodCall
    | ID INIT_BRACKET expression FINAL_BRACKET DOT ID                       # ObjectBaseArrayProperty
    ;

/*--------****--- MULTI-DIMENSIONAL OR NORMAL ARRAY CALLS ---****--------*/
array_call
    : ID (INIT_BRACKET expression FINAL_BRACKET)+           # ArrayCall
    ;

/*--------****--- FUNCTION CALLING ---****--------*/

function_call
    : ID INIT_PARENT arguments_list? FINAL_PARENT           # FunctionCalling
    ;

/*--------****--- ARGUMENT FUNCTION LIST ---****--------*/

arguments_list
    : expression (COMMA expression)*        # ArgumentsList
    ;

/*--------****--- OBJECT / ARRAY INSTANTIATION ---****--------*/

instantiation
    : NEW type INIT_PARENT arguments_list? FINAL_PARENT           # ObjectInstantiation
    | NEW type (INIT_BRACKET expression FINAL_BRACKET)+           # ArrayInstantiation
    ;

/*--------****--- ARRAY LITERAL ---****--------*/

array_literal
    : INIT_BRACE array_values? FINAL_BRACE   # ArrayLiteralValue
    ;

/*--------****--- ARRAY VALUES ---****--------*/

array_values
    : expression (COMMA expression)*   # ArrayValuesList
    ;

/*--******-------****--- OPERATION SECTION ---****-------******--*/
expression
    : INIT_PARENT expression FINAL_PARENT                                          # ExpressionParents
    | op=(NOT | MINUS) expression                                                  # ExpressionUnary
    | expression op=(MULTIPLICATION | DIVIDE | PERCENT) expression                 # ExpressionMultDiv
    | expression op=(PLUS | MINUS) expression                                      # ExpressionAddSub
    | expression op=(LESS | GREATER | LESS_EQUALS | GREATER_EQUALS) expression     # ExpressionRelational
    | expression op=(EQUALS | DIFERENCE) expression                                # ExpressionEquality
    | expression AND expression                                                    # ExpressionAnd
    | expression OR expression                                                     # ExpressionOr
    | <assoc=right> expression QUESTION expression TWO_POINTS expression           # ExpressionTernary
    | normal_values                                                                # ExpressionValue
    ;

/*--------****--- VALUES AND TYPES SECTION ---****--------*/

type
    : primitive_type        # TypePrimitive
    | ID                    # TypeClassName
    ;

/*--------****--- PRIMITIVE TYPES ---****--------*/
primitive_type
    : INTEGER    # TypeInt
    | DOUBLE     # TypeDouble
    | CHARACTER  # TypeChar
    | BOOLEAN    # TypeBoolean
    | VOID       # TypeVoid
    ;

/*--------****--- PRINCIPAL VALUES DATA ---****--------*/
normal_values
    : TEXT                          # ValText
    | CHAR                          # ValChar
    | DECIMAL                       # ValDecimal
    | INT                           # ValInt
    | boolean_values                # ValBool
    | NULL                          # ValNull
    | instantiation                 # ValInstantiation
    | object_values                 # ValObjectAccess
    | array_call                    # ValArrayCall
    | function_call                 # ValFunctionCall
    | array_literal                 # ValArrayLiteral
    | read_call                     # ValReadCall
    | ID                            # ValIdCall
    ;

/*--------****--- BOOLEAN VALUES ---****--------*/
boolean_values
    : TRUE     # BoolTrue
    | FALSE    # BoolFalse
    ;