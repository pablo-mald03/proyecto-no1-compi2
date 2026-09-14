// Generated from PigLatinParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PigLatinParser}.
 */
public interface PigLatinParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PigLatinParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PigLatinParser.ProgramContext ctx);
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
	 * Enter a parse tree produced by the {@code ImportLists}
	 * labeled alternative in {@link PigLatinParser#import_list}.
	 * @param ctx the parse tree
	 */
	void enterImportLists(PigLatinParser.ImportListsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportLists}
	 * labeled alternative in {@link PigLatinParser#import_list}.
	 * @param ctx the parse tree
	 */
	void exitImportLists(PigLatinParser.ImportListsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AccessorInstruction}
	 * labeled alternative in {@link PigLatinParser#accessor}.
	 * @param ctx the parse tree
	 */
	void enterAccessorInstruction(PigLatinParser.AccessorInstructionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AccessorInstruction}
	 * labeled alternative in {@link PigLatinParser#accessor}.
	 * @param ctx the parse tree
	 */
	void exitAccessorInstruction(PigLatinParser.AccessorInstructionContext ctx);
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
	 * Enter a parse tree produced by the {@code CodeBodyStatement}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 */
	void enterCodeBodyStatement(PigLatinParser.CodeBodyStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CodeBodyStatement}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 */
	void exitCodeBodyStatement(PigLatinParser.CodeBodyStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockCode}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockCode(PigLatinParser.BlockCodeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockCode}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockCode(PigLatinParser.BlockCodeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConsoleActions}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterConsoleActions(PigLatinParser.ConsoleActionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConsoleActions}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitConsoleActions(PigLatinParser.ConsoleActionsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopControlAction}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLoopControlAction(PigLatinParser.LoopControlActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopControlAction}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLoopControlAction(PigLatinParser.LoopControlActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnControlAction}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnControlAction(PigLatinParser.ReturnControlActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnControlAction}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnControlAction(PigLatinParser.ReturnControlActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLocalAbbreviatedOperation(PigLatinParser.LocalAbbreviatedOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLocalAbbreviatedOperation(PigLatinParser.LocalAbbreviatedOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalAssignment}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterLocalAssignment(PigLatinParser.LocalAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalAssignment}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitLocalAssignment(PigLatinParser.LocalAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementObjectPropertyCalling}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementObjectPropertyCalling(PigLatinParser.StatementObjectPropertyCallingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementObjectPropertyCalling}
	 * labeled alternative in {@link PigLatinParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementObjectPropertyCalling(PigLatinParser.StatementObjectPropertyCallingContext ctx);
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
	 * Enter a parse tree produced by the {@code ElseStatement}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(PigLatinParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseStatement}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(PigLatinParser.ElseStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code ForUpdatePrefixIncrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdatePrefixIncrement(PigLatinParser.ForUpdatePrefixIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdatePrefixIncrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdatePrefixIncrement(PigLatinParser.ForUpdatePrefixIncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdatePrefixDecrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdatePrefixDecrement(PigLatinParser.ForUpdatePrefixDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdatePrefixDecrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdatePrefixDecrement(PigLatinParser.ForUpdatePrefixDecrementContext ctx);
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
	 * Enter a parse tree produced by the {@code ComPoundAssingment}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterComPoundAssingment(PigLatinParser.ComPoundAssingmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComPoundAssingment}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitComPoundAssingment(PigLatinParser.ComPoundAssingmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(PigLatinParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(PigLatinParser.ReturnStatementContext ctx);
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
	 * Enter a parse tree produced by the {@code VariabilesBody}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 */
	void enterVariabilesBody(PigLatinParser.VariabilesBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariabilesBody}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 */
	void exitVariabilesBody(PigLatinParser.VariabilesBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableInstance}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableInstance(PigLatinParser.VariableInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableInstance}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableInstance(PigLatinParser.VariableInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableAssignment}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignment(PigLatinParser.VariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableAssignment}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignment(PigLatinParser.VariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalArrayInstance}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalArrayInstance(PigLatinParser.NormalArrayInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalArrayInstance}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalArrayInstance(PigLatinParser.NormalArrayInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructVariableInstance}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterStructVariableInstance(PigLatinParser.StructVariableInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructVariableInstance}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitStructVariableInstance(PigLatinParser.StructVariableInstanceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterGlobalAbbreviatedOperation(PigLatinParser.GlobalAbbreviatedOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitGlobalAbbreviatedOperation(PigLatinParser.GlobalAbbreviatedOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundAssignment}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAssignment(PigLatinParser.CompoundAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundAssignment}
	 * labeled alternative in {@link PigLatinParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAssignment(PigLatinParser.CompoundAssignmentContext ctx);
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
	 * Enter a parse tree produced by the {@code StructAssignment}
	 * labeled alternative in {@link PigLatinParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterStructAssignment(PigLatinParser.StructAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructAssignment}
	 * labeled alternative in {@link PigLatinParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitStructAssignment(PigLatinParser.StructAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundAddAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAddAssignment(PigLatinParser.CompoundAddAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundAddAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAddAssignment(PigLatinParser.CompoundAddAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundSubAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundSubAssignment(PigLatinParser.CompoundSubAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundSubAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundSubAssignment(PigLatinParser.CompoundSubAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundMulAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundMulAssignment(PigLatinParser.CompoundMulAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundMulAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundMulAssignment(PigLatinParser.CompoundMulAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundDivAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundDivAssignment(PigLatinParser.CompoundDivAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundDivAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundDivAssignment(PigLatinParser.CompoundDivAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundModAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundModAssignment(PigLatinParser.CompoundModAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundModAssignment}
	 * labeled alternative in {@link PigLatinParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundModAssignment(PigLatinParser.CompoundModAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalArrayDeclaration}
	 * labeled alternative in {@link PigLatinParser#array_declaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalArrayDeclaration(PigLatinParser.NormalArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalArrayDeclaration}
	 * labeled alternative in {@link PigLatinParser#array_declaration}.
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
	 * Enter a parse tree produced by {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 */
	void enterValues_array_list(PigLatinParser.Values_array_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 */
	void exitValues_array_list(PigLatinParser.Values_array_listContext ctx);
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
	 * Enter a parse tree produced by the {@code StructDataList}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 */
	void enterStructDataList(PigLatinParser.StructDataListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructDataList}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 */
	void exitStructDataList(PigLatinParser.StructDataListContext ctx);
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
	 * Enter a parse tree produced by the {@code NestedVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void enterNestedVariable(PigLatinParser.NestedVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void exitNestedVariable(PigLatinParser.NestedVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectMethodChain}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterObjectMethodChain(PigLatinParser.ObjectMethodChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectMethodChain}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitObjectMethodChain(PigLatinParser.ObjectMethodChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectArrayAccessChain}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterObjectArrayAccessChain(PigLatinParser.ObjectArrayAccessChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectArrayAccessChain}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitObjectArrayAccessChain(PigLatinParser.ObjectArrayAccessChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectPropertyChain}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterObjectPropertyChain(PigLatinParser.ObjectPropertyChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectPropertyChain}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitObjectPropertyChain(PigLatinParser.ObjectPropertyChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseFunctionCall}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterBaseFunctionCall(PigLatinParser.BaseFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseFunctionCall}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitBaseFunctionCall(PigLatinParser.BaseFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterBaseIdentifier(PigLatinParser.BaseIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link PigLatinParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitBaseIdentifier(PigLatinParser.BaseIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentsList}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsList(PigLatinParser.ArgumentsListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentsList}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsList(PigLatinParser.ArgumentsListContext ctx);
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
	 * Enter a parse tree produced by the {@code ValArrayInitialLiteral}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValArrayInitialLiteral(PigLatinParser.ValArrayInitialLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValArrayInitialLiteral}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValArrayInitialLiteral(PigLatinParser.ValArrayInitialLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValNewInstance}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValNewInstance(PigLatinParser.ValNewInstanceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValNewInstance}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValNewInstance(PigLatinParser.ValNewInstanceContext ctx);
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