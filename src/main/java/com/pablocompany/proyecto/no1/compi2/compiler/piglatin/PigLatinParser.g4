parser grammar PigLatinParser;

options {
    tokenVocab=PigLatinLexer;
}

program
    : body* EOF # ProgramRoot
    ;

    
body:   variable_section?
        munera_section?
        maior_section 
        FINIS_SEPARATOR DOT_COMMA
    ;

/*===*****===== MAIOR SECTION =====*****===*/
/*===*****========*****===== MAIOR SECTION (FUNCTIONS) ===*****==========*****===*/

munera_section
    : MUNERA GREATER munera_body # MuneraSection
    ;

munera_body
    : munera_body functions_block # FunctionsBlockList
    | functions_block            # FunctionsSingleBlock
    ;

functions_block
    : function_declaration  # FuncDeclBlock
    | procedure_declaration # ProcDeclBlock
    ;

/*------ FUNCTION & PROCEDURE DECLARATIONS ------*/

function_declaration
    : RATIO variable_function_type ID INIT_PARENT function_arguments? FINAL_PARENT INIT_BRACE function_body? code_body? FINAL_BRACE FINIS DOT_COMMA # FunctionDeclaration
    ;

/*------Return values------*/
variable_function_type
    : variable_type     #FunctionReturNormalType
    ;


procedure_declaration
    : ACTIO ID INIT_PARENT function_arguments? FINAL_PARENT INIT_BRACE procedure_body? code_body? FINAL_BRACE FINIS DOT_COMMA    # ProcedureDeclaration
    ;

function_body
    : VARIABILES INIT_BRACKET local_variable_list? FINAL_BRACKET          # FunctionBody
    ;

procedure_body
    : VARIABILES INIT_BRACKET local_variable_list? FINAL_BRACKET           # ProcedureBody
    ;

/*------ ARGUMENTS & LOCAL VARIABLES ------*/

local_variable_list
    : local_variable_list local_variable    # LocalVariablesList
    | local_variable                        # LocalSingleVariable
    ;

local_variable
    : variable_declaration                  # LocalVarDeclaration
    | normal_array_declaration              # LocalArrayDeclaration
    | struct_instance                       # LocalStructInstance
    ;

function_arguments
    : function_arguments COMMA argument # FunctionArgsList
    | argument                         # FunctionSingleArg
    ;

argument
    : ESTO ID TWO_POINTS argument_variable_type         # ArgumentVariableDeclaration
    | SERIES ID TWO_POINTS argument_series_type         # ArgumentArrayDeclarationn
    ;

argument_variable_type
    : variable_type         # ArgumentNormalDeclaration
    ;

argument_series_type
    : variable_type         # ArgumentArrayNormalDeclaration
    ;

/*===*****========*****===== MUNERA SECTION ===*****==========*****===*/
maior_section
    : MAIOR GREATER code_body # MaiorSection
    ;

code_body
    : code_body control_block # BlockControlList
    | control_block           # BlockSingleControl
    ;

control_block
    : block_code                            # BlockCode
    | console_actions                       # ConsoleActions
    | function_call DOT_COMMA               # FunctionSingleCall
    | loop_control                          # LoopControlAction
    | return_control                        # ReturnControlAction
    | abbreviated_operation                 # LocalAbbreviatedOperation
    | variable_ussage                       # LocalVariableRedefinition
    | array_redefined_ussage                # LocalArrayRedefinedUssage
    | nested_variables_usage                # LocalNestedVariableUsage
    ;

/*------ RETURN STATEMENT ------*/

return_control
    : REDDERE expression DOT_COMMA # ReturnWithValue
    | REDDERE DOT_COMMA            # ReturnVoid
    ;

/*------ LOOP CONTROL STATEMENTS ------*/

loop_control
    : PERGE DOT_COMMA      # LoopContinue
    | INTERRUMPE DOT_COMMA # LoopBreak
    ;

console_actions
    : nest_variable READ             # ReadVariableInput
    | READ                           # ReadInput
    | PRINT print_function DOT_COMMA # PrintAction
    ;

print_function
    : print_function PRINT expression # PrintMultipleExpr
    | expression                      # PrintSingleExpr
    ;

/*===*****===== COMMON CODE SECTION =====*****===*/

block_code
    : if_statement       # CodeBlockIf
    | while_statement    # CodeBlockWhile
    | do_while_statement # CodeBlockDoWhile
    | for_statement      # CodeBlockFor
    ;

/*------ IF STATEMENT PRODUCTION ------*/

if_statement
    : SI INIT_PARENT expression FINAL_PARENT INIT_BRACE code_body? FINAL_BRACE else_if_list? else_statement FINIS DOT_COMMA # IfStatement
    ;

else_if_list
    : else_if_list else_if_clause # ElseIfList
    | else_if_clause              # ElseIfSingle
    ;

else_if_clause
    : ALITER INIT_PARENT expression FINAL_PARENT INIT_BRACE code_body? FINAL_BRACE # ElseIfClause
    ;

else_statement
    : ALITER INIT_BRACE code_body? FINAL_BRACE   # ElseBlock
    | /* Lambda */                               # ElseEmpty
    ;

/*------ CYCLES ------*/

while_statement
    : DUM INIT_PARENT expression FINAL_PARENT INIT_BRACE code_body? FINAL_BRACE FINIS DOT_COMMA # WhileStatement
    ;

do_while_statement
    : FACERE INIT_BRACE code_body? FINAL_BRACE DUM INIT_PARENT expression FINAL_PARENT DOT_COMMA # DoWhileStatement
    ;

for_statement
    : PER INIT_PARENT for_init DOT_COMMA expression DOT_COMMA for_update FINAL_PARENT INIT_BRACE code_body? FINAL_BRACE  # ForStatement
    ;

for_init
    : ESTO ID TWO_POINTS variable_type expression # ForInitVarDecl
    | ID EQUAL expression                         # ForInitAssign
    ;

for_update
    : ID ABREV_PLUS        # ForUpdateIncrement
    | ID ABREV_MINUS       # ForUpdateDecrement
    | ID EQUAL expression  # ForUpdateAssign
    ;


/*===*****===== VARIABILES SECTION =====*****===*/

variable_section
    : VARIABILES GREATER variabiles_body    #VariablesSection
    ;


/*------ DECLARATE VARIABILES SECTION ------*/

variabiles_body: variabiles_body declarations   # DeclarationsVariablesList
                | declarations                  # DeclarationsSingleVariable
                ;


/*------ DECLARATIONS PRODUCTIONS SECTION------*/
declarations
    : variable_declaration          # VariableInstance
    | variable_ussage               # VariableRedefinedUssage
    | normal_array_declaration      # NormalArrayInstance
    | struct_declaration            # StructDefinition
    | array_redefined_ussage        # ArrayRedefinedUssage
    | struct_instance               # StructVariableInstance
    | abbreviated_operation         # GlobalAbbreviatedOperation
    | nested_variables_usage        # GlobalNestedVariableUsage
    ;


/*-----VARIABLE USAGE PRODUCTIONS-----*/

/*-----STRUCT INSTANCE PRODUCTIONS-----*/
array_redefined_ussage
    : ID INIT_BRACKET expression FINAL_BRACKET EQUAL expression DOT_COMMA   #RedefiniedArrayUssage
    ;

variable_ussage
    : ID EQUAL expression DOT_COMMA                 # NormalVariableRedefiniedUsage
    ;

nested_variables_usage
    : struct_values EQUAL expression DOT_COMMA      #NestedStructRedefiniedValue
    ;

/*-----STRUCT INSTANCE PRODUCTIONS-----*/

struct_instance
    : ESTO ID TWO_POINTS ID struct_literal         # StructInstance
    ;



/*-----VARIABLE PRODUCTIONS-----*/
variable_declaration
    : ESTO ID TWO_POINTS variable_type expression DOT_COMMA # VariableDeclaration
    ;


normal_array_declaration
    : SERIES ID INIT_BRACKET expression FINAL_BRACKET TWO_POINTS variable_type array_initialization? DOT_COMMA   # NormalArrayDeclaration
    ;


/*---****------****--- ARRAY PROPERTIES SECTION ---****------****---*/

array_initialization
    : INIT_BRACE values_array_list FINAL_BRACE      # ArrayInitWithValues
    ;

values_array_list
    : values_array_list COMMA array_value # ArrayValueList
    | array_value                         # ArraySingleValue
    ;

array_value
    : expression  # ArrayNormalValue
    ;


/*--------****--- VALUES SECTION NESTED PROPERTIES---****--------*/

struct_values
    : struct_values DOT ID                                      # StructPropertyChain
    | struct_values INIT_BRACKET expression FINAL_BRACKET       # StructArrayAccessChain
    | ID DOT ID                                                 # StructBaseProperty
    | ID INIT_BRACKET expression FINAL_BRACKET DOT ID           # StructBaseArrayProperty
    ;


/*---****------****--- STRUCT DEFINITION SECTION ---****------****---*/

struct_declaration
    : STRUCTURE ID INIT_BRACE struct_body FINAL_BRACE FINIS DOT_COMMA # StructDeclaration
    ;

struct_body
    : struct_normal_body    # StructSeparatedBody
    | struct_comma_body     # StructCommaBody
    ;

struct_normal_body
    : struct_normal_body struct_attribute DOT_COMMA             # StructNormalBodyList
    | struct_attribute DOT_COMMA                                # StructNormalBodySingle
    ;

struct_comma_body
    : struct_comma_body COMMA struct_attribute      # StructCommaBodyList
    | struct_attribute                              # StructCommaBodySingle
    ;



/*---****------****--- STRUCT VARIABLES DECLARATION DEFINITION SECTION ---****------****---*/

struct_attribute
    : variable_without_value            # NormalVariableStruct
    | array_variable_struct             # ArrayVariableStruct
    ;


/*-----STRUCT VARIABLE INSTANCE PRODUCTIONS-----*/

variable_without_value
    : ESTO ID TWO_POINTS variable_type      # InternalStructNormalVariable
    ;


array_variable_struct
    : SERIES ID TWO_POINTS variable_type           # InternalStructArray
    ;


/*-----STRUCT INSTANCE VALUES PRODUCTIONS-----*/

struct_literal
    : INIT_BRACE struct_data_list FINAL_BRACE  # StructLiteralValue
    ;

struct_data_list
    : struct_data_list COMMA struct_data_value # StructValueList
    | struct_data_value                        # StructSingleValue
    ;

struct_data_value
    : ID TWO_POINTS expression                 # StructDataNormal
    ;


/*--******-------****--- OPERATION SECTION ---****-------******--*/

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



/*--------****--- VALUES AND TYPES SECTION ---****--------*/
variable_type
    : TEXTUM    # TypeText
    | NUMERUS   # TypeInt
    | DECIMALIS # TypeDecimal
    | LITTERA   # TypeChar
    | BOOLEAN   # TypeBoolean
    | ID        # TypeCustomId
    ;

/*--------****--- ARRAY CALLING SECTION ---****--------*/
array_call
    : ID INIT_BRACKET expression FINAL_BRACKET     # ArrayCall
    ;


/*--------****--- FUNCTION CALLING ---****--------*/

function_call
    : ID INIT_PARENT arguments_list? FINAL_PARENT      # FunctionCalling
    ;

arguments_list
    : arguments_list COMMA expression           # ArgumentFunctionList
    | expression                                # ArgumentSingleFunction
    ;

/*-----STRUCT VARIABLE INSTANCE PRODUCTIONS-----*/
nest_variable
    : struct_values         # NestedValueVariable
    | array_call            # ArrayCallVariable
    | ID                    # SigleValueVariable
    ;

/*--------****--- PRINCIPAL VALUES DATA ---****--------*/
normal_values
    : STRING                    # ValString
    | CHAR                      # ValChar
    | DECIMAL                   # ValDecimal
    | INT                       # ValInt
    | boolean_values            # ValBool
    | array_call                # ValArrayCall
    | function_call             # ValFunctionCall
    | struct_values             # ValStructNestValue
    | struct_literal            # ValStructPropertyLiteral
    | array_initialization      # ValArrayLiteral
    | ID                        # ValIdCall
    ;

boolean_values
    : VERUM     # BoolTrue
    | FALSUS    # BoolFalse
    ;

abbreviated_operation
    : nest_variable ABREV_PLUS DOT_COMMA  # IncOperation
    | nest_variable ABREV_MINUS DOT_COMMA # DecOperation
    | ABREV_PLUS nest_variable  DOT_COMMA  # IncPrevOperation
    | ABREV_MINUS nest_variable  DOT_COMMA # DecPrevOperation
    ;


