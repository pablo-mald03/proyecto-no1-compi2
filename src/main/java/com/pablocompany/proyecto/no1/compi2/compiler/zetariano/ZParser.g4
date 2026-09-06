parser grammar ZParser;

options {
    tokenVocab=ZLexer;
}

program:
    code*
    ;

code
    : RETURN
    ;



/*
munera_body
    : munera_body functions_block # FunctionsBlockList
    | functions_block            # FunctionsSingleBlock
    ;

functions_block
    : function_declaration  # FuncDeclBlock
    | procedure_declaration # ProcDeclBlock
    ;

*/
/*------ FUNCTION & PROCEDURE DECLARATIONS ------*//*


function_declaration
    : RATIO variable_function_type ID INIT_PARENT function_arguments? FINAL_PARENT INIT_BRACE function_body? code_body? FINAL_BRACE FINIS DOT_COMMA # FunctionDeclaration
    ;

*/
/*------Return values------*//*

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

*/
/*------ ARGUMENTS & LOCAL VARIABLES ------*//*


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
*/
