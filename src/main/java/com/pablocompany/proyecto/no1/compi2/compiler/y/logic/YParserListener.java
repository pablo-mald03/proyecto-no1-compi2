// Generated from YParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.y.logic;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YParser}.
 */
public interface YParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(YParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(YParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructRegionDeclaration}
	 * labeled alternative in {@link YParser#structures_region}.
	 * @param ctx the parse tree
	 */
	void enterStructRegionDeclaration(YParser.StructRegionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructRegionDeclaration}
	 * labeled alternative in {@link YParser#structures_region}.
	 * @param ctx the parse tree
	 */
	void exitStructRegionDeclaration(YParser.StructRegionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructDeclaration}
	 * labeled alternative in {@link YParser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(YParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructDeclaration}
	 * labeled alternative in {@link YParser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(YParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructNormalProperty}
	 * labeled alternative in {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void enterStructNormalProperty(YParser.StructNormalPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructNormalProperty}
	 * labeled alternative in {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void exitStructNormalProperty(YParser.StructNormalPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructArrayProperty}
	 * labeled alternative in {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void enterStructArrayProperty(YParser.StructArrayPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructArrayProperty}
	 * labeled alternative in {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void exitStructArrayProperty(YParser.StructArrayPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionSection}
	 * labeled alternative in {@link YParser#functions_region}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSection(YParser.FunctionSectionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionSection}
	 * labeled alternative in {@link YParser#functions_region}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSection(YParser.FunctionSectionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link YParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(YParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link YParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(YParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link YParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(YParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link YParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(YParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrimitiveParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveParameter(YParser.PrimitiveParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrimitiveParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveParameter(YParser.PrimitiveParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterArrayParameter(YParser.ArrayParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitArrayParameter(YParser.ArrayParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StructParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterStructParameter(YParser.StructParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StructParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitStructParameter(YParser.StructParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(YParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(YParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementConsoleAction}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementConsoleAction(YParser.StatementConsoleActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementConsoleAction}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementConsoleAction(YParser.StatementConsoleActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementFunctionCall}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementFunctionCall(YParser.StatementFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementFunctionCall}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementFunctionCall(YParser.StatementFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementLoopControl}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementLoopControl(YParser.StatementLoopControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementLoopControl}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementLoopControl(YParser.StatementLoopControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementAbbreviatedOperation}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementAbbreviatedOperation(YParser.StatementAbbreviatedOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementAbbreviatedOperation}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementAbbreviatedOperation(YParser.StatementAbbreviatedOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementCompoundAssignment}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementCompoundAssignment(YParser.StatementCompoundAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementCompoundAssignment}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementCompoundAssignment(YParser.StatementCompoundAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementStructDeclaration}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementStructDeclaration(YParser.StatementStructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementStructDeclaration}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementStructDeclaration(YParser.StatementStructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclarationStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationStatement(YParser.VariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclarationStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationStatement(YParser.VariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentVariableStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentVariableStatement(YParser.AssignmentVariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentVariableStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentVariableStatement(YParser.AssignmentVariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(YParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(YParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockIf}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockIf(YParser.BlockIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockIf}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockIf(YParser.BlockIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockSwitch}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockSwitch(YParser.BlockSwitchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockSwitch}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockSwitch(YParser.BlockSwitchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockWhile}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockWhile(YParser.BlockWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockWhile}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockWhile(YParser.BlockWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockDoWhile}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockDoWhile(YParser.BlockDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockDoWhile}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockDoWhile(YParser.BlockDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockFor}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockFor(YParser.BlockForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockFor}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockFor(YParser.BlockForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link YParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(YParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link YParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(YParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIfList}
	 * labeled alternative in {@link YParser#else_if_list}.
	 * @param ctx the parse tree
	 */
	void enterElseIfList(YParser.ElseIfListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIfList}
	 * labeled alternative in {@link YParser#else_if_list}.
	 * @param ctx the parse tree
	 */
	void exitElseIfList(YParser.ElseIfListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link YParser#else_if_clause}.
	 * @param ctx the parse tree
	 */
	void enterElseIfClause(YParser.ElseIfClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link YParser#else_if_clause}.
	 * @param ctx the parse tree
	 */
	void exitElseIfClause(YParser.ElseIfClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link YParser#else_block}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(YParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link YParser#else_block}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(YParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SwitchStatement}
	 * labeled alternative in {@link YParser#switch_statement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(YParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SwitchStatement}
	 * labeled alternative in {@link YParser#switch_statement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(YParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SwitchCase}
	 * labeled alternative in {@link YParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCase(YParser.SwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SwitchCase}
	 * labeled alternative in {@link YParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCase(YParser.SwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AlwaysCase}
	 * labeled alternative in {@link YParser#always_case}.
	 * @param ctx the parse tree
	 */
	void enterAlwaysCase(YParser.AlwaysCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AlwaysCase}
	 * labeled alternative in {@link YParser#always_case}.
	 * @param ctx the parse tree
	 */
	void exitAlwaysCase(YParser.AlwaysCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link YParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(YParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link YParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(YParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link YParser#do_while_statement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(YParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link YParser#do_while_statement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(YParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link YParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(YParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link YParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(YParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link YParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterForInitVarDecl(YParser.ForInitVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link YParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitForInitVarDecl(YParser.ForInitVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link YParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterForInitAssign(YParser.ForInitAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link YParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitForInitAssign(YParser.ForInitAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateIncrement(YParser.ForUpdateIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateIncrement(YParser.ForUpdateIncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateDecrement(YParser.ForUpdateDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateDecrement(YParser.ForUpdateDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdatePrefixIncrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdatePrefixIncrement(YParser.ForUpdatePrefixIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdatePrefixIncrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdatePrefixIncrement(YParser.ForUpdatePrefixIncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdatePrefixDecrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdatePrefixDecrement(YParser.ForUpdatePrefixDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdatePrefixDecrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdatePrefixDecrement(YParser.ForUpdatePrefixDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateAssign(YParser.ForUpdateAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateAssign(YParser.ForUpdateAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link YParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void enterLoopContinue(YParser.LoopContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link YParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void exitLoopContinue(YParser.LoopContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link YParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void enterLoopBreak(YParser.LoopBreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link YParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void exitLoopBreak(YParser.LoopBreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link YParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void enterPrintAction(YParser.PrintActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link YParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void exitPrintAction(YParser.PrintActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadAction}
	 * labeled alternative in {@link YParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void enterReadAction(YParser.ReadActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadAction}
	 * labeled alternative in {@link YParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void exitReadAction(YParser.ReadActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadCall}
	 * labeled alternative in {@link YParser#read_call}.
	 * @param ctx the parse tree
	 */
	void enterReadCall(YParser.ReadCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadCall}
	 * labeled alternative in {@link YParser#read_call}.
	 * @param ctx the parse tree
	 */
	void exitReadCall(YParser.ReadCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterIncOperation(YParser.IncOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitIncOperation(YParser.IncOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterDecOperation(YParser.DecOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitDecOperation(YParser.DecOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncPrevOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterIncPrevOperation(YParser.IncPrevOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncPrevOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitIncPrevOperation(YParser.IncPrevOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecPrevOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterDecPrevOperation(YParser.DecPrevOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecPrevOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitDecPrevOperation(YParser.DecPrevOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundAddAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAddAssignment(YParser.CompoundAddAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundAddAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAddAssignment(YParser.CompoundAddAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundSubAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundSubAssignment(YParser.CompoundSubAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundSubAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundSubAssignment(YParser.CompoundSubAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundMulAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundMulAssignment(YParser.CompoundMulAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundMulAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundMulAssignment(YParser.CompoundMulAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundDivAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundDivAssignment(YParser.CompoundDivAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundDivAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundDivAssignment(YParser.CompoundDivAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundModAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundModAssignment(YParser.CompoundModAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundModAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundModAssignment(YParser.CompoundModAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionCalling}
	 * labeled alternative in {@link YParser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCalling(YParser.FunctionCallingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionCalling}
	 * labeled alternative in {@link YParser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCalling(YParser.FunctionCallingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotDefiniedVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterNotDefiniedVariable(YParser.NotDefiniedVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotDefiniedVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitNotDefiniedVariable(YParser.NotDefiniedVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefiniedVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterDefiniedVariable(YParser.DefiniedVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefiniedVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitDefiniedVariable(YParser.DefiniedVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotDefiniedArrayVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterNotDefiniedArrayVariable(YParser.NotDefiniedArrayVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotDefiniedArrayVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitNotDefiniedArrayVariable(YParser.NotDefiniedArrayVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefiniedArrayVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterDefiniedArrayVariable(YParser.DefiniedArrayVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefiniedArrayVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitDefiniedArrayVariable(YParser.DefiniedArrayVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssingmentStatement}
	 * labeled alternative in {@link YParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssingmentStatement(YParser.AssingmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssingmentStatement}
	 * labeled alternative in {@link YParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssingmentStatement(YParser.AssingmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntValue(YParser.IntValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntValue(YParser.IntValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(YParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(YParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void enterFloatValue(YParser.FloatValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void exitFloatValue(YParser.FloatValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void enterCharValue(YParser.CharValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void exitCharValue(YParser.CharValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(YParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(YParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CustomTypeValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void enterCustomTypeValue(YParser.CustomTypeValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CustomTypeValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void exitCustomTypeValue(YParser.CustomTypeValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionParents(YParser.ExpressionParentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionParents(YParser.ExpressionParentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnary(YParser.ExpressionUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnary(YParser.ExpressionUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEquality(YParser.ExpressionEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEquality(YParser.ExpressionEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionRelational(YParser.ExpressionRelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionRelational(YParser.ExpressionRelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionValue(YParser.ExpressionValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionValue(YParser.ExpressionValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAnd(YParser.ExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAnd(YParser.ExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOr(YParser.ExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOr(YParser.ExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMultDiv(YParser.ExpressionMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMultDiv(YParser.ExpressionMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAddSub(YParser.ExpressionAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAddSub(YParser.ExpressionAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueString}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueString(YParser.ValueStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueString}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueString(YParser.ValueStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueChar}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueChar(YParser.ValueCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueChar}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueChar(YParser.ValueCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueDecimal}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueDecimal(YParser.ValueDecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueDecimal}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueDecimal(YParser.ValueDecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueInt}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueInt(YParser.ValueIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueInt}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueInt(YParser.ValueIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueBool}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueBool(YParser.ValueBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueBool}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueBool(YParser.ValueBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueFunctionCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueFunctionCall(YParser.ValueFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueFunctionCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueFunctionCall(YParser.ValueFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueReadCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueReadCall(YParser.ValueReadCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueReadCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueReadCall(YParser.ValueReadCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValueAccessorCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueAccessorCall(YParser.ValueAccessorCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueAccessorCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueAccessorCall(YParser.ValueAccessorCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InitValueArrayLiteral}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterInitValueArrayLiteral(YParser.InitValueArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InitValueArrayLiteral}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitInitValueArrayLiteral(YParser.InitValueArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link YParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrue(YParser.BoolTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link YParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrue(YParser.BoolTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link YParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalse(YParser.BoolFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link YParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalse(YParser.BoolFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionList}
	 * labeled alternative in {@link YParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(YParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionList}
	 * labeled alternative in {@link YParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(YParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AccessorPropertyChain}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void enterAccessorPropertyChain(YParser.AccessorPropertyChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AccessorPropertyChain}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void exitAccessorPropertyChain(YParser.AccessorPropertyChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AccessorArrayChain}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void enterAccessorArrayChain(YParser.AccessorArrayChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AccessorArrayChain}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void exitAccessorArrayChain(YParser.AccessorArrayChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AccessorBase}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void enterAccessorBase(YParser.AccessorBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AccessorBase}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void exitAccessorBase(YParser.AccessorBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#skip_lines}.
	 * @param ctx the parse tree
	 */
	void enterSkip_lines(YParser.Skip_linesContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#skip_lines}.
	 * @param ctx the parse tree
	 */
	void exitSkip_lines(YParser.Skip_linesContext ctx);
}