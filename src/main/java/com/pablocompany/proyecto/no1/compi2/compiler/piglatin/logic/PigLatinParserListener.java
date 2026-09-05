// Generated from PigLatinParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PigLatinParser}.
 */
public interface PigLatinParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code ProgramRoot}
	 * labeled alternative in {@link PigLatinParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgramRoot(PigLatinParser.ProgramRootContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramRoot}
	 * labeled alternative in {@link PigLatinParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgramRoot(PigLatinParser.ProgramRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(PigLatinParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(PigLatinParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionsBlockList}
	 * labeled alternative in {@link PigLatinParser#munera_body}.
	 * @param ctx the parse tree
	 */
	void enterFunctionsBlockList(PigLatinParser.FunctionsBlockListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionsBlockList}
	 * labeled alternative in {@link PigLatinParser#munera_body}.
	 * @param ctx the parse tree
	 */
	void exitFunctionsBlockList(PigLatinParser.FunctionsBlockListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionsSingleBlock}
	 * labeled alternative in {@link PigLatinParser#munera_body}.
	 * @param ctx the parse tree
	 */
	void enterFunctionsSingleBlock(PigLatinParser.FunctionsSingleBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionsSingleBlock}
	 * labeled alternative in {@link PigLatinParser#munera_body}.
	 * @param ctx the parse tree
	 */
	void exitFunctionsSingleBlock(PigLatinParser.FunctionsSingleBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncDeclBlock}
	 * labeled alternative in {@link PigLatinParser#functions_block}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclBlock(PigLatinParser.FuncDeclBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncDeclBlock}
	 * labeled alternative in {@link PigLatinParser#functions_block}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclBlock(PigLatinParser.FuncDeclBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProcDeclBlock}
	 * labeled alternative in {@link PigLatinParser#functions_block}.
	 * @param ctx the parse tree
	 */
	void enterProcDeclBlock(PigLatinParser.ProcDeclBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProcDeclBlock}
	 * labeled alternative in {@link PigLatinParser#functions_block}.
	 * @param ctx the parse tree
	 */
	void exitProcDeclBlock(PigLatinParser.ProcDeclBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link PigLatinParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(PigLatinParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link PigLatinParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(PigLatinParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionReturNormalType}
	 * labeled alternative in {@link PigLatinParser#variable_function_type}.
	 * @param ctx the parse tree
	 */
	void enterFunctionReturNormalType(PigLatinParser.FunctionReturNormalTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionReturNormalType}
	 * labeled alternative in {@link PigLatinParser#variable_function_type}.
	 * @param ctx the parse tree
	 */
	void exitFunctionReturNormalType(PigLatinParser.FunctionReturNormalTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProcedureDeclaration}
	 * labeled alternative in {@link PigLatinParser#procedure_declaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(PigLatinParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProcedureDeclaration}
	 * labeled alternative in {@link PigLatinParser#procedure_declaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(PigLatinParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionBody}
	 * labeled alternative in {@link PigLatinParser#function_body}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(PigLatinParser.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionBody}
	 * labeled alternative in {@link PigLatinParser#function_body}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(PigLatinParser.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProcedureBody}
	 * labeled alternative in {@link PigLatinParser#procedure_body}.
	 * @param ctx the parse tree
	 */
	void enterProcedureBody(PigLatinParser.ProcedureBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProcedureBody}
	 * labeled alternative in {@link PigLatinParser#procedure_body}.
	 * @param ctx the parse tree
	 */
	void exitProcedureBody(PigLatinParser.ProcedureBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalVariablesList}
	 * labeled alternative in {@link PigLatinParser#local_variable_list}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariablesList(PigLatinParser.LocalVariablesListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalVariablesList}
	 * labeled alternative in {@link PigLatinParser#local_variable_list}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariablesList(PigLatinParser.LocalVariablesListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalSingleVariable}
	 * labeled alternative in {@link PigLatinParser#local_variable_list}.
	 * @param ctx the parse tree
	 */
	void enterLocalSingleVariable(PigLatinParser.LocalSingleVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalSingleVariable}
	 * labeled alternative in {@link PigLatinParser#local_variable_list}.
	 * @param ctx the parse tree
	 */
	void exitLocalSingleVariable(PigLatinParser.LocalSingleVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalVarDeclaration}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 */
	void enterLocalVarDeclaration(PigLatinParser.LocalVarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalVarDeclaration}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 */
	void exitLocalVarDeclaration(PigLatinParser.LocalVarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalArrayDeclaration}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 */
	void enterLocalArrayDeclaration(PigLatinParser.LocalArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalArrayDeclaration}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 */
	void exitLocalArrayDeclaration(PigLatinParser.LocalArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalStructInstance}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 */
	void enterLocalStructInstance(PigLatinParser.LocalStructInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalStructInstance}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 */
	void exitLocalStructInstance(PigLatinParser.LocalStructInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionSingleArg}
	 * labeled alternative in {@link PigLatinParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSingleArg(PigLatinParser.FunctionSingleArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionSingleArg}
	 * labeled alternative in {@link PigLatinParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSingleArg(PigLatinParser.FunctionSingleArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionArgsList}
	 * labeled alternative in {@link PigLatinParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArgsList(PigLatinParser.FunctionArgsListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionArgsList}
	 * labeled alternative in {@link PigLatinParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArgsList(PigLatinParser.FunctionArgsListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentVariableDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgumentVariableDeclaration(PigLatinParser.ArgumentVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentVariableDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgumentVariableDeclaration(PigLatinParser.ArgumentVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentArrayDeclarationn}
	 * labeled alternative in {@link PigLatinParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgumentArrayDeclarationn(PigLatinParser.ArgumentArrayDeclarationnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentArrayDeclarationn}
	 * labeled alternative in {@link PigLatinParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgumentArrayDeclarationn(PigLatinParser.ArgumentArrayDeclarationnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentNormalDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument_variable_type}.
	 * @param ctx the parse tree
	 */
	void enterArgumentNormalDeclaration(PigLatinParser.ArgumentNormalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentNormalDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument_variable_type}.
	 * @param ctx the parse tree
	 */
	void exitArgumentNormalDeclaration(PigLatinParser.ArgumentNormalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentArrayNormalDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument_series_type}.
	 * @param ctx the parse tree
	 */
	void enterArgumentArrayNormalDeclaration(PigLatinParser.ArgumentArrayNormalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentArrayNormalDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument_series_type}.
	 * @param ctx the parse tree
	 */
	void exitArgumentArrayNormalDeclaration(PigLatinParser.ArgumentArrayNormalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MaiorSection}
	 * labeled alternative in {@link PigLatinParser#maior_section}.
	 * @param ctx the parse tree
	 */
	void enterMaiorSection(PigLatinParser.MaiorSectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MaiorSection}
	 * labeled alternative in {@link PigLatinParser#maior_section}.
	 * @param ctx the parse tree
	 */
	void exitMaiorSection(PigLatinParser.MaiorSectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockControlList}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 */
	void enterBlockControlList(PigLatinParser.BlockControlListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockControlList}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 */
	void exitBlockControlList(PigLatinParser.BlockControlListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockSingleControl}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 */
	void enterBlockSingleControl(PigLatinParser.BlockSingleControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockSingleControl}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 */
	void exitBlockSingleControl(PigLatinParser.BlockSingleControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockCode}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterBlockCode(PigLatinParser.BlockCodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockCode}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitBlockCode(PigLatinParser.BlockCodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConsoleActions}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterConsoleActions(PigLatinParser.ConsoleActionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConsoleActions}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitConsoleActions(PigLatinParser.ConsoleActionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionSingleCall}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSingleCall(PigLatinParser.FunctionSingleCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionSingleCall}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSingleCall(PigLatinParser.FunctionSingleCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopControlAction}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterLoopControlAction(PigLatinParser.LoopControlActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopControlAction}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitLoopControlAction(PigLatinParser.LoopControlActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnControlAction}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterReturnControlAction(PigLatinParser.ReturnControlActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnControlAction}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitReturnControlAction(PigLatinParser.ReturnControlActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterLocalAbbreviatedOperation(PigLatinParser.LocalAbbreviatedOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitLocalAbbreviatedOperation(PigLatinParser.LocalAbbreviatedOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalVariableRedefinition}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableRedefinition(PigLatinParser.LocalVariableRedefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalVariableRedefinition}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableRedefinition(PigLatinParser.LocalVariableRedefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalArrayRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterLocalArrayRedefinedUssage(PigLatinParser.LocalArrayRedefinedUssageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalArrayRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitLocalArrayRedefinedUssage(PigLatinParser.LocalArrayRedefinedUssageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalNestedVariableUsage}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void enterLocalNestedVariableUsage(PigLatinParser.LocalNestedVariableUsageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalNestedVariableUsage}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 */
	void exitLocalNestedVariableUsage(PigLatinParser.LocalNestedVariableUsageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnWithValue}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 */
	void enterReturnWithValue(PigLatinParser.ReturnWithValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnWithValue}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 */
	void exitReturnWithValue(PigLatinParser.ReturnWithValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 */
	void enterReturnVoid(PigLatinParser.ReturnVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 */
	void exitReturnVoid(PigLatinParser.ReturnVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link PigLatinParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void enterLoopContinue(PigLatinParser.LoopContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link PigLatinParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void exitLoopContinue(PigLatinParser.LoopContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link PigLatinParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void enterLoopBreak(PigLatinParser.LoopBreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link PigLatinParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void exitLoopBreak(PigLatinParser.LoopBreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadVariableInput}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void enterReadVariableInput(PigLatinParser.ReadVariableInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadVariableInput}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void exitReadVariableInput(PigLatinParser.ReadVariableInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadInput}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void enterReadInput(PigLatinParser.ReadInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadInput}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void exitReadInput(PigLatinParser.ReadInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void enterPrintAction(PigLatinParser.PrintActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void exitPrintAction(PigLatinParser.PrintActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintSingleExpr}
	 * labeled alternative in {@link PigLatinParser#print_function}.
	 * @param ctx the parse tree
	 */
	void enterPrintSingleExpr(PigLatinParser.PrintSingleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintSingleExpr}
	 * labeled alternative in {@link PigLatinParser#print_function}.
	 * @param ctx the parse tree
	 */
	void exitPrintSingleExpr(PigLatinParser.PrintSingleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintMultipleExpr}
	 * labeled alternative in {@link PigLatinParser#print_function}.
	 * @param ctx the parse tree
	 */
	void enterPrintMultipleExpr(PigLatinParser.PrintMultipleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintMultipleExpr}
	 * labeled alternative in {@link PigLatinParser#print_function}.
	 * @param ctx the parse tree
	 */
	void exitPrintMultipleExpr(PigLatinParser.PrintMultipleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CodeBlockIf}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlockIf(PigLatinParser.CodeBlockIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CodeBlockIf}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlockIf(PigLatinParser.CodeBlockIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CodeBlockWhile}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlockWhile(PigLatinParser.CodeBlockWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CodeBlockWhile}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlockWhile(PigLatinParser.CodeBlockWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CodeBlockDoWhile}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlockDoWhile(PigLatinParser.CodeBlockDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CodeBlockDoWhile}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlockDoWhile(PigLatinParser.CodeBlockDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CodeBlockFor}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 */
	void enterCodeBlockFor(PigLatinParser.CodeBlockForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CodeBlockFor}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 */
	void exitCodeBlockFor(PigLatinParser.CodeBlockForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link PigLatinParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(PigLatinParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link PigLatinParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(PigLatinParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIfSingle}
	 * labeled alternative in {@link PigLatinParser#else_if_list}.
	 * @param ctx the parse tree
	 */
	void enterElseIfSingle(PigLatinParser.ElseIfSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIfSingle}
	 * labeled alternative in {@link PigLatinParser#else_if_list}.
	 * @param ctx the parse tree
	 */
	void exitElseIfSingle(PigLatinParser.ElseIfSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIfList}
	 * labeled alternative in {@link PigLatinParser#else_if_list}.
	 * @param ctx the parse tree
	 */
	void enterElseIfList(PigLatinParser.ElseIfListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIfList}
	 * labeled alternative in {@link PigLatinParser#else_if_list}.
	 * @param ctx the parse tree
	 */
	void exitElseIfList(PigLatinParser.ElseIfListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link PigLatinParser#else_if_clause}.
	 * @param ctx the parse tree
	 */
	void enterElseIfClause(PigLatinParser.ElseIfClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link PigLatinParser#else_if_clause}.
	 * @param ctx the parse tree
	 */
	void exitElseIfClause(PigLatinParser.ElseIfClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(PigLatinParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(PigLatinParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseEmpty}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElseEmpty(PigLatinParser.ElseEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseEmpty}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElseEmpty(PigLatinParser.ElseEmptyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link PigLatinParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(PigLatinParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link PigLatinParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(PigLatinParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link PigLatinParser#do_while_statement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(PigLatinParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link PigLatinParser#do_while_statement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(PigLatinParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link PigLatinParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(PigLatinParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link PigLatinParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(PigLatinParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link PigLatinParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterForInitVarDecl(PigLatinParser.ForInitVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link PigLatinParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitForInitVarDecl(PigLatinParser.ForInitVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link PigLatinParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterForInitAssign(PigLatinParser.ForInitAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link PigLatinParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitForInitAssign(PigLatinParser.ForInitAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateIncrement(PigLatinParser.ForUpdateIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateIncrement(PigLatinParser.ForUpdateIncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateDecrement(PigLatinParser.ForUpdateDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateDecrement(PigLatinParser.ForUpdateDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateAssign(PigLatinParser.ForUpdateAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateAssign(PigLatinParser.ForUpdateAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariablesSection}
	 * labeled alternative in {@link PigLatinParser#variable_section}.
	 * @param ctx the parse tree
	 */
	void enterVariablesSection(PigLatinParser.VariablesSectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariablesSection}
	 * labeled alternative in {@link PigLatinParser#variable_section}.
	 * @param ctx the parse tree
	 */
	void exitVariablesSection(PigLatinParser.VariablesSectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationsVariablesList}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationsVariablesList(PigLatinParser.DeclarationsVariablesListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationsVariablesList}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationsVariablesList(PigLatinParser.DeclarationsVariablesListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclarationsSingleVariable}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationsSingleVariable(PigLatinParser.DeclarationsSingleVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclarationsSingleVariable}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationsSingleVariable(PigLatinParser.DeclarationsSingleVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterVariableInstance(PigLatinParser.VariableInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitVariableInstance(PigLatinParser.VariableInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterVariableRedefinedUssage(PigLatinParser.VariableRedefinedUssageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitVariableRedefinedUssage(PigLatinParser.VariableRedefinedUssageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalArrayInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterNormalArrayInstance(PigLatinParser.NormalArrayInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalArrayInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitNormalArrayInstance(PigLatinParser.NormalArrayInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructDefinition}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterStructDefinition(PigLatinParser.StructDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructDefinition}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitStructDefinition(PigLatinParser.StructDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterArrayRedefinedUssage(PigLatinParser.ArrayRedefinedUssageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitArrayRedefinedUssage(PigLatinParser.ArrayRedefinedUssageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructVariableInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterStructVariableInstance(PigLatinParser.StructVariableInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructVariableInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitStructVariableInstance(PigLatinParser.StructVariableInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterGlobalAbbreviatedOperation(PigLatinParser.GlobalAbbreviatedOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitGlobalAbbreviatedOperation(PigLatinParser.GlobalAbbreviatedOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalNestedVariableUsage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterGlobalNestedVariableUsage(PigLatinParser.GlobalNestedVariableUsageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalNestedVariableUsage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitGlobalNestedVariableUsage(PigLatinParser.GlobalNestedVariableUsageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RedefiniedArrayUssage}
	 * labeled alternative in {@link PigLatinParser#array_redefined_ussage}.
	 * @param ctx the parse tree
	 */
	void enterRedefiniedArrayUssage(PigLatinParser.RedefiniedArrayUssageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RedefiniedArrayUssage}
	 * labeled alternative in {@link PigLatinParser#array_redefined_ussage}.
	 * @param ctx the parse tree
	 */
	void exitRedefiniedArrayUssage(PigLatinParser.RedefiniedArrayUssageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalVariableRedefiniedUsage}
	 * labeled alternative in {@link PigLatinParser#variable_ussage}.
	 * @param ctx the parse tree
	 */
	void enterNormalVariableRedefiniedUsage(PigLatinParser.NormalVariableRedefiniedUsageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalVariableRedefiniedUsage}
	 * labeled alternative in {@link PigLatinParser#variable_ussage}.
	 * @param ctx the parse tree
	 */
	void exitNormalVariableRedefiniedUsage(PigLatinParser.NormalVariableRedefiniedUsageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedStructRedefiniedValue}
	 * labeled alternative in {@link PigLatinParser#nested_variables_usage}.
	 * @param ctx the parse tree
	 */
	void enterNestedStructRedefiniedValue(PigLatinParser.NestedStructRedefiniedValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedStructRedefiniedValue}
	 * labeled alternative in {@link PigLatinParser#nested_variables_usage}.
	 * @param ctx the parse tree
	 */
	void exitNestedStructRedefiniedValue(PigLatinParser.NestedStructRedefiniedValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructInstance}
	 * labeled alternative in {@link PigLatinParser#struct_instance}.
	 * @param ctx the parse tree
	 */
	void enterStructInstance(PigLatinParser.StructInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructInstance}
	 * labeled alternative in {@link PigLatinParser#struct_instance}.
	 * @param ctx the parse tree
	 */
	void exitStructInstance(PigLatinParser.StructInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link PigLatinParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(PigLatinParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link PigLatinParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(PigLatinParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalArrayDeclaration}
	 * labeled alternative in {@link PigLatinParser#normal_array_declaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalArrayDeclaration(PigLatinParser.NormalArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalArrayDeclaration}
	 * labeled alternative in {@link PigLatinParser#normal_array_declaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalArrayDeclaration(PigLatinParser.NormalArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayInitWithValues}
	 * labeled alternative in {@link PigLatinParser#array_initialization}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitWithValues(PigLatinParser.ArrayInitWithValuesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayInitWithValues}
	 * labeled alternative in {@link PigLatinParser#array_initialization}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitWithValues(PigLatinParser.ArrayInitWithValuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArraySingleValue}
	 * labeled alternative in {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 */
	void enterArraySingleValue(PigLatinParser.ArraySingleValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArraySingleValue}
	 * labeled alternative in {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 */
	void exitArraySingleValue(PigLatinParser.ArraySingleValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValueList}
	 * labeled alternative in {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 */
	void enterArrayValueList(PigLatinParser.ArrayValueListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValueList}
	 * labeled alternative in {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 */
	void exitArrayValueList(PigLatinParser.ArrayValueListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayNormalValue}
	 * labeled alternative in {@link PigLatinParser#array_value}.
	 * @param ctx the parse tree
	 */
	void enterArrayNormalValue(PigLatinParser.ArrayNormalValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayNormalValue}
	 * labeled alternative in {@link PigLatinParser#array_value}.
	 * @param ctx the parse tree
	 */
	void exitArrayNormalValue(PigLatinParser.ArrayNormalValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructBaseProperty}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 */
	void enterStructBaseProperty(PigLatinParser.StructBasePropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructBaseProperty}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 */
	void exitStructBaseProperty(PigLatinParser.StructBasePropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructArrayAccessChain}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 */
	void enterStructArrayAccessChain(PigLatinParser.StructArrayAccessChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructArrayAccessChain}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 */
	void exitStructArrayAccessChain(PigLatinParser.StructArrayAccessChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructBaseArrayProperty}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 */
	void enterStructBaseArrayProperty(PigLatinParser.StructBaseArrayPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructBaseArrayProperty}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 */
	void exitStructBaseArrayProperty(PigLatinParser.StructBaseArrayPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructPropertyChain}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 */
	void enterStructPropertyChain(PigLatinParser.StructPropertyChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructPropertyChain}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 */
	void exitStructPropertyChain(PigLatinParser.StructPropertyChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructDeclaration}
	 * labeled alternative in {@link PigLatinParser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(PigLatinParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructDeclaration}
	 * labeled alternative in {@link PigLatinParser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(PigLatinParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructSeparatedBody}
	 * labeled alternative in {@link PigLatinParser#struct_body}.
	 * @param ctx the parse tree
	 */
	void enterStructSeparatedBody(PigLatinParser.StructSeparatedBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructSeparatedBody}
	 * labeled alternative in {@link PigLatinParser#struct_body}.
	 * @param ctx the parse tree
	 */
	void exitStructSeparatedBody(PigLatinParser.StructSeparatedBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructCommaBody}
	 * labeled alternative in {@link PigLatinParser#struct_body}.
	 * @param ctx the parse tree
	 */
	void enterStructCommaBody(PigLatinParser.StructCommaBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructCommaBody}
	 * labeled alternative in {@link PigLatinParser#struct_body}.
	 * @param ctx the parse tree
	 */
	void exitStructCommaBody(PigLatinParser.StructCommaBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructNormalBodyList}
	 * labeled alternative in {@link PigLatinParser#struct_normal_body}.
	 * @param ctx the parse tree
	 */
	void enterStructNormalBodyList(PigLatinParser.StructNormalBodyListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructNormalBodyList}
	 * labeled alternative in {@link PigLatinParser#struct_normal_body}.
	 * @param ctx the parse tree
	 */
	void exitStructNormalBodyList(PigLatinParser.StructNormalBodyListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructNormalBodySingle}
	 * labeled alternative in {@link PigLatinParser#struct_normal_body}.
	 * @param ctx the parse tree
	 */
	void enterStructNormalBodySingle(PigLatinParser.StructNormalBodySingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructNormalBodySingle}
	 * labeled alternative in {@link PigLatinParser#struct_normal_body}.
	 * @param ctx the parse tree
	 */
	void exitStructNormalBodySingle(PigLatinParser.StructNormalBodySingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructCommaBodySingle}
	 * labeled alternative in {@link PigLatinParser#struct_comma_body}.
	 * @param ctx the parse tree
	 */
	void enterStructCommaBodySingle(PigLatinParser.StructCommaBodySingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructCommaBodySingle}
	 * labeled alternative in {@link PigLatinParser#struct_comma_body}.
	 * @param ctx the parse tree
	 */
	void exitStructCommaBodySingle(PigLatinParser.StructCommaBodySingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructCommaBodyList}
	 * labeled alternative in {@link PigLatinParser#struct_comma_body}.
	 * @param ctx the parse tree
	 */
	void enterStructCommaBodyList(PigLatinParser.StructCommaBodyListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructCommaBodyList}
	 * labeled alternative in {@link PigLatinParser#struct_comma_body}.
	 * @param ctx the parse tree
	 */
	void exitStructCommaBodyList(PigLatinParser.StructCommaBodyListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalVariableStruct}
	 * labeled alternative in {@link PigLatinParser#struct_attribute}.
	 * @param ctx the parse tree
	 */
	void enterNormalVariableStruct(PigLatinParser.NormalVariableStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalVariableStruct}
	 * labeled alternative in {@link PigLatinParser#struct_attribute}.
	 * @param ctx the parse tree
	 */
	void exitNormalVariableStruct(PigLatinParser.NormalVariableStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayVariableStruct}
	 * labeled alternative in {@link PigLatinParser#struct_attribute}.
	 * @param ctx the parse tree
	 */
	void enterArrayVariableStruct(PigLatinParser.ArrayVariableStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayVariableStruct}
	 * labeled alternative in {@link PigLatinParser#struct_attribute}.
	 * @param ctx the parse tree
	 */
	void exitArrayVariableStruct(PigLatinParser.ArrayVariableStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InternalStructNormalVariable}
	 * labeled alternative in {@link PigLatinParser#variable_without_value}.
	 * @param ctx the parse tree
	 */
	void enterInternalStructNormalVariable(PigLatinParser.InternalStructNormalVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InternalStructNormalVariable}
	 * labeled alternative in {@link PigLatinParser#variable_without_value}.
	 * @param ctx the parse tree
	 */
	void exitInternalStructNormalVariable(PigLatinParser.InternalStructNormalVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InternalStructArray}
	 * labeled alternative in {@link PigLatinParser#array_variable_struct}.
	 * @param ctx the parse tree
	 */
	void enterInternalStructArray(PigLatinParser.InternalStructArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InternalStructArray}
	 * labeled alternative in {@link PigLatinParser#array_variable_struct}.
	 * @param ctx the parse tree
	 */
	void exitInternalStructArray(PigLatinParser.InternalStructArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructLiteralValue}
	 * labeled alternative in {@link PigLatinParser#struct_literal}.
	 * @param ctx the parse tree
	 */
	void enterStructLiteralValue(PigLatinParser.StructLiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructLiteralValue}
	 * labeled alternative in {@link PigLatinParser#struct_literal}.
	 * @param ctx the parse tree
	 */
	void exitStructLiteralValue(PigLatinParser.StructLiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructValueList}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 */
	void enterStructValueList(PigLatinParser.StructValueListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructValueList}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 */
	void exitStructValueList(PigLatinParser.StructValueListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructSingleValue}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 */
	void enterStructSingleValue(PigLatinParser.StructSingleValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructSingleValue}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 */
	void exitStructSingleValue(PigLatinParser.StructSingleValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructDataNormal}
	 * labeled alternative in {@link PigLatinParser#struct_data_value}.
	 * @param ctx the parse tree
	 */
	void enterStructDataNormal(PigLatinParser.StructDataNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructDataNormal}
	 * labeled alternative in {@link PigLatinParser#struct_data_value}.
	 * @param ctx the parse tree
	 */
	void exitStructDataNormal(PigLatinParser.StructDataNormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionParents(PigLatinParser.ExpressionParentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionParents(PigLatinParser.ExpressionParentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnary(PigLatinParser.ExpressionUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnary(PigLatinParser.ExpressionUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEquality(PigLatinParser.ExpressionEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEquality(PigLatinParser.ExpressionEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionRelational(PigLatinParser.ExpressionRelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionRelational(PigLatinParser.ExpressionRelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionValue(PigLatinParser.ExpressionValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionValue(PigLatinParser.ExpressionValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAnd(PigLatinParser.ExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAnd(PigLatinParser.ExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOr(PigLatinParser.ExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOr(PigLatinParser.ExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMultDiv(PigLatinParser.ExpressionMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMultDiv(PigLatinParser.ExpressionMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAddSub(PigLatinParser.ExpressionAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAddSub(PigLatinParser.ExpressionAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeText}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeText(PigLatinParser.TypeTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeText}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeText(PigLatinParser.TypeTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(PigLatinParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(PigLatinParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDecimal}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeDecimal(PigLatinParser.TypeDecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDecimal}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeDecimal(PigLatinParser.TypeDecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeChar}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeChar(PigLatinParser.TypeCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeChar}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeChar(PigLatinParser.TypeCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeBoolean}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeBoolean(PigLatinParser.TypeBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeBoolean}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeBoolean(PigLatinParser.TypeBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeCustomId}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeCustomId(PigLatinParser.TypeCustomIdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeCustomId}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeCustomId(PigLatinParser.TypeCustomIdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayCall}
	 * labeled alternative in {@link PigLatinParser#array_call}.
	 * @param ctx the parse tree
	 */
	void enterArrayCall(PigLatinParser.ArrayCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayCall}
	 * labeled alternative in {@link PigLatinParser#array_call}.
	 * @param ctx the parse tree
	 */
	void exitArrayCall(PigLatinParser.ArrayCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCalling}
	 * labeled alternative in {@link PigLatinParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCalling(PigLatinParser.FunctionCallingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCalling}
	 * labeled alternative in {@link PigLatinParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCalling(PigLatinParser.FunctionCallingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentSingleFunction}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterArgumentSingleFunction(PigLatinParser.ArgumentSingleFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentSingleFunction}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitArgumentSingleFunction(PigLatinParser.ArgumentSingleFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentFunctionList}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterArgumentFunctionList(PigLatinParser.ArgumentFunctionListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentFunctionList}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitArgumentFunctionList(PigLatinParser.ArgumentFunctionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedValueVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void enterNestedValueVariable(PigLatinParser.NestedValueVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedValueVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void exitNestedValueVariable(PigLatinParser.NestedValueVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayCallVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void enterArrayCallVariable(PigLatinParser.ArrayCallVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayCallVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void exitArrayCallVariable(PigLatinParser.ArrayCallVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SigleValueVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void enterSigleValueVariable(PigLatinParser.SigleValueVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SigleValueVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void exitSigleValueVariable(PigLatinParser.SigleValueVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValString}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValString(PigLatinParser.ValStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValString}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValString(PigLatinParser.ValStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValChar}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValChar(PigLatinParser.ValCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValChar}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValChar(PigLatinParser.ValCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValDecimal}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValDecimal(PigLatinParser.ValDecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValDecimal}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValDecimal(PigLatinParser.ValDecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValInt}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValInt(PigLatinParser.ValIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValInt}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValInt(PigLatinParser.ValIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValBool}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValBool(PigLatinParser.ValBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValBool}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValBool(PigLatinParser.ValBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValArrayCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValArrayCall(PigLatinParser.ValArrayCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValArrayCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValArrayCall(PigLatinParser.ValArrayCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValFunctionCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValFunctionCall(PigLatinParser.ValFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValFunctionCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValFunctionCall(PigLatinParser.ValFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValStructNestValue}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValStructNestValue(PigLatinParser.ValStructNestValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValStructNestValue}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValStructNestValue(PigLatinParser.ValStructNestValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValStructPropertyLiteral}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValStructPropertyLiteral(PigLatinParser.ValStructPropertyLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValStructPropertyLiteral}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValStructPropertyLiteral(PigLatinParser.ValStructPropertyLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValArrayLiteral}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValArrayLiteral(PigLatinParser.ValArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValArrayLiteral}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValArrayLiteral(PigLatinParser.ValArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValIdCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValIdCall(PigLatinParser.ValIdCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValIdCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValIdCall(PigLatinParser.ValIdCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link PigLatinParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrue(PigLatinParser.BoolTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link PigLatinParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrue(PigLatinParser.BoolTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link PigLatinParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalse(PigLatinParser.BoolFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link PigLatinParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalse(PigLatinParser.BoolFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterIncOperation(PigLatinParser.IncOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitIncOperation(PigLatinParser.IncOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterDecOperation(PigLatinParser.DecOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitDecOperation(PigLatinParser.DecOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncPrevOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterIncPrevOperation(PigLatinParser.IncPrevOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncPrevOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitIncPrevOperation(PigLatinParser.IncPrevOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecPrevOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterDecPrevOperation(PigLatinParser.DecPrevOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecPrevOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitDecPrevOperation(PigLatinParser.DecPrevOperationContext ctx);
}