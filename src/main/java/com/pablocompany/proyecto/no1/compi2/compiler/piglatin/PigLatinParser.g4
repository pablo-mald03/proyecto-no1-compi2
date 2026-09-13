parser grammar PigLatinParser;

options {
    tokenVocab=PigLatinLexer;
}

program
    : body? EOF
    ;

/*===*****========*****===== BODY SECTION ===*****==========*****===*/

body
    : import_list* variable_section? maior_section FINIS_SEPARATOR DOT_COMMA
    ;

/*===*****========*****===== BODY SECTION ===*****==========*****===*/

/*------ IMPORT LIST PRODUCTION ------*/
import_list
    : IMPORT accessor       #ImportLists
    ;

/*------ IMPORT ACCESSOR PRODUCTION ------*/
accessor
    : ID (DOT ID)*          #AccessorInstruction
    ;

/*===*****===== MAIOR SECTION =====*****===*/

/*===*****========*****===== MAIOR SECTION ===*****==========*****===*/
maior_section
    : MAIOR GREATER code_body # MaiorSection
    ;

code_body
    : statement*        #CodeBodyStatement
    ;

statement
    : block_code                            # BlockCode
    | console_actions                       # ConsoleActions
    | loop_control                          # LoopControlAction
    | return_control                        # ReturnControlAction
    | abbreviated_operation                 # LocalAbbreviatedOperation
    | assignment                            # LocalAssignment
    | object_values DOT_COMMA               # StatementObjectPropertyCalling
    ;

/*===*****===== COMMON CODE SECTION =====*****===*/

block_code
    : if_statement              # CodeBlockIf
    | while_statement           # CodeBlockWhile
    | do_while_statement        # CodeBlockDoWhile
    | for_statement             # CodeBlockFor
    ;

/*------ IF STATEMENT PRODUCTION ------*/

if_statement
    : SI INIT_PARENT expression FINAL_PARENT INIT_BRACE code_body FINAL_BRACE else_if_list? else_statement FINIS DOT_COMMA # IfStatement
    ;

/*------ ELSE IF LIST STATEMENT PRODUCTION ------*/
else_if_list
    : else_if_clause+       #ElseIfList
    ;

else_if_clause
    : ALITER INIT_PARENT expression FINAL_PARENT INIT_BRACE code_body FINAL_BRACE      # ElseIfClause
    ;

else_statement
    : (ALITER INIT_BRACE code_body FINAL_BRACE)?       # ElseStatement
    ;

/*------ LOOPS ------*/

while_statement
    : DUM INIT_PARENT expression FINAL_PARENT INIT_BRACE code_body FINAL_BRACE FINIS DOT_COMMA # WhileStatement
    ;

do_while_statement
    : FACERE INIT_BRACE code_body FINAL_BRACE DUM INIT_PARENT expression FINAL_PARENT DOT_COMMA # DoWhileStatement
    ;

for_statement
    : PER INIT_PARENT for_init DOT_COMMA expression DOT_COMMA for_update FINAL_PARENT INIT_BRACE code_body FINAL_BRACE  # ForStatement
    ;

for_init
    : ESTO ID TWO_POINTS variable_type expression # ForInitVarDecl
    | ID EQUAL expression                         # ForInitAssign
    ;

for_update
    : nest_variable ABREV_PLUS         #ForUpdateIncrement
    | nest_variable ABREV_MINUS        #ForUpdateDecrement
    | ABREV_PLUS nest_variable         #ForUpdatePrefixIncrement
    | ABREV_MINUS nest_variable        #ForUpdatePrefixDecrement
    | nest_variable EQUAL expression   #ForUpdateAssign
    | compound_assignment               # ComPoundAssingment
    ;

/*------ RETURN STATEMENT ------*/

return_control
    : REDDERE expression? DOT_COMMA         # ReturnStatement
    ;

/*------ LOOP CONTROL STATEMENTS ------*/

loop_control
    : PERGE DOT_COMMA               # LoopContinue
    | INTERRUMPE DOT_COMMA          # LoopBreak
    ;

/*===*****===== CONSOLE ACTIONS SECTION =====*****===*/

console_actions
    : nest_variable READ                    # ReadVariableInput
    | READ                                  # ReadInput
    | PRINT print_function DOT_COMMA        # PrintAction
    ;

print_function
    : print_function PRINT expression # PrintMultipleExpr
    | expression                      # PrintSingleExpr
    ;

/*===*****===== VARIABILES SECTION =====*****===*/

variable_section
    : VARIABILES GREATER variabiles_body    #VariablesSection
    ;

/*------ DECLARATE VARIABILES SECTION ------*/

variabiles_body
    : declaration+          #VariabilesBody
    ;

/*------ DECLARATIONS PRODUCTIONS SECTION------*/

declaration
    : variable_declaration          # VariableInstance
    | assignment                    # VariableAssignment
    | array_declaration             # NormalArrayInstance
    | struct_instance               # StructVariableInstance
    | abbreviated_operation         # GlobalAbbreviatedOperation
    | compound_assignment DOT_COMMA          # CompoundAssignment
    ;

/*-----VARIABLE PRODUCTIONS-----*/

variable_declaration
    : ESTO ID TWO_POINTS variable_type? expression DOT_COMMA         # VariableDeclaration
    ;

/*-----ASSIGNMENT PRODUCTIONS-----*/

assignment
    : nest_variable EQUAL expression DOT_COMMA # StructAssignment
    ;

/*------ COMPOUND ASSIGNMENT PRODUCTIONS ------*/
compound_assignment
    : nest_variable BY_ONE_ADD expression                 # CompoundAddAssignment
    | nest_variable BY_ONE_MINUS expression               # CompoundSubAssignment
    | nest_variable BY_ONE_MULTIPLICATION expression      # CompoundMulAssignment
    | nest_variable BY_ONE_DIVISION expression            # CompoundDivAssignment
    | nest_variable BY_ONE_PERCENT expression             # CompoundModAssignment
    ;

/*-----ARRAY PRODUCTIONS-----*/

array_declaration
    : SERIES ID INIT_BRACKET expression FINAL_BRACKET TWO_POINTS variable_type array_initialization? DOT_COMMA      # NormalArrayDeclaration
    ;

array_initialization
    : INIT_BRACE values_array_list FINAL_BRACE      # ArrayInitWithValues
    ;

values_array_list
    : expression (COMMA expression)*
    ;

/*---****------****--- STRUCT VARIABLES DECLARATION DEFINITION SECTION ---****------****---*/

struct_attribute
    : variable_without_value            # NormalVariableStruct
    | array_variable_struct             # ArrayVariableStruct
    ;

variable_without_value
    : ESTO ID TWO_POINTS variable_type      # InternalStructNormalVariable
    ;

array_variable_struct
    : SERIES ID TWO_POINTS variable_type           # InternalStructArray
    ;

/*-----STRUCT INSTANCE PRODUCTIONS-----*/

struct_instance
    : ESTO ID TWO_POINTS ID struct_literal DOT_COMMA # StructInstance
    ;

struct_literal
    : INIT_BRACE struct_data_list FINAL_BRACE  # StructLiteralValue
    ;

struct_data_list
    : struct_data_value (COMMA struct_data_value)*      #StructDataList
    ;

struct_data_value
    : ID TWO_POINTS expression                 # StructDataNormal
    ;

/*-----STRUCT PROPERTY ACCESS -----*/

/*--------****--- ASSIGNMENT / OPERATION TARGET ---****--------*/
nest_variable
    : object_values   # NestedVariable
    ;

/*--------****--- OBJECT AND ARRAY ACCESS CHAINS ---****--------*/
object_values
    : object_values DOT ID                                                  # ObjectPropertyChain
    | object_values DOT ID INIT_PARENT arguments_list? FINAL_PARENT         # ObjectMethodChain
    | object_values INIT_BRACKET expression FINAL_BRACKET                   # ObjectArrayAccessChain
    | ID INIT_PARENT arguments_list? FINAL_PARENT                          # BaseFunctionCall
    | ID                                                                    # BaseIdentifier
    ;

arguments_list
    : expression (COMMA expression)*            #ArgumentsList
    ;

/*--******-------****--- OPERATION SECTION ---****-------******--*/

expression
    : INIT_PARENT expression FINAL_PARENT                                           # ExpressionParents
    | op=(NOT | MINUS) expression                                                   # ExpressionUnary
    | expression op=(MULTIPLICATION | DIVIDE | PERCENT) expression                  # ExpressionMultDiv
    | expression op=(PLUS | MINUS) expression                                       # ExpressionAddSub
    | expression op=(LESS | GREATER | LESS_EQUALS | GREATER_EQUALS) expression      # ExpressionRelational
    | expression op=(EQUALS | DIFERENCE) expression                                 # ExpressionEquality
    | expression AND expression                                                     # ExpressionAnd
    | expression OR expression                                                      # ExpressionOr
    | normal_values                                                                 # ExpressionValue
    ;

/*--------****--- VALUES AND TYPES SECTION ---****--------*/

variable_type
    : TEXTUM    # TypeText
    | NUMERUS   # TypeInt
    | DECIMALIS # TypeDecimal
    | LITTERA   # TypeChar
    | BOOLEAN   # TypeBoolean
    | ID        # TypeCustomId
    ;

/*--------****--- PRINCIPAL VALUES DATA ---****--------*/

normal_values
    : STRING                                            # ValString
    | CHAR                                              # ValChar
    | DECIMAL                                           # ValDecimal
    | INT                                               # ValInt
    | boolean_values                                    # ValBool
    | object_values                                     # ValStructNestValue
    | struct_literal                                    # ValStructPropertyLiteral
    | array_initialization                              # ValArrayInitialLiteral
    | NOVUS ID INIT_PARENT arguments_list? FINAL_PARENT # ValNewInstance
    ;

boolean_values
    : VERUM     # BoolTrue
    | FALSUS    # BoolFalse
    ;

/*-----ABBREVIATED OPERATIONS-----*/

abbreviated_operation
    : nest_variable ABREV_PLUS DOT_COMMA        # IncOperation
    | nest_variable ABREV_MINUS DOT_COMMA       # DecOperation
    | ABREV_PLUS nest_variable  DOT_COMMA       # IncPrevOperation
    | ABREV_MINUS nest_variable  DOT_COMMA      # DecPrevOperation
    ;