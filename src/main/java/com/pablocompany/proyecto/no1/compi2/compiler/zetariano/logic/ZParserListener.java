// Generated from ZParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ZParser}.
 */
public interface ZParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ZParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ZParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ZParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassDeclaration}
	 * labeled alternative in {@link ZParser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(ZParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassDeclaration}
	 * labeled alternative in {@link ZParser#class_declaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(ZParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassFieldMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 */
	void enterClassFieldMember(ZParser.ClassFieldMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassFieldMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 */
	void exitClassFieldMember(ZParser.ClassFieldMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassConstructorMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 */
	void enterClassConstructorMember(ZParser.ClassConstructorMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassConstructorMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 */
	void exitClassConstructorMember(ZParser.ClassConstructorMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassMethodMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 */
	void enterClassMethodMember(ZParser.ClassMethodMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassMethodMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 */
	void exitClassMethodMember(ZParser.ClassMethodMemberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ConstructorDeclaration}
	 * labeled alternative in {@link ZParser#constructor_declaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(ZParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ConstructorDeclaration}
	 * labeled alternative in {@link ZParser#constructor_declaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(ZParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MethodDeclaration}
	 * labeled alternative in {@link ZParser#method_declaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(ZParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MethodDeclaration}
	 * labeled alternative in {@link ZParser#method_declaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(ZParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link ZParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(ZParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link ZParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(ZParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParameterStatement}
	 * labeled alternative in {@link ZParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameterStatement(ZParser.ParameterStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParameterStatement}
	 * labeled alternative in {@link ZParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameterStatement(ZParser.ParameterStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(ZParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(ZParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementConsoleAction}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementConsoleAction(ZParser.StatementConsoleActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementConsoleAction}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementConsoleAction(ZParser.StatementConsoleActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementLoopControl}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementLoopControl(ZParser.StatementLoopControlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementLoopControl}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementLoopControl(ZParser.StatementLoopControlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementReturn(ZParser.StatementReturnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementReturn(ZParser.StatementReturnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementAbbreviatedOperation}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementAbbreviatedOperation(ZParser.StatementAbbreviatedOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementAbbreviatedOperation}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementAbbreviatedOperation(ZParser.StatementAbbreviatedOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementCompoundAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementCompoundAssignment(ZParser.StatementCompoundAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementCompoundAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementCompoundAssignment(ZParser.StatementCompoundAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementNestedAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementNestedAssignment(ZParser.StatementNestedAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementNestedAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementNestedAssignment(ZParser.StatementNestedAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementArrayAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementArrayAssignment(ZParser.StatementArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementArrayAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementArrayAssignment(ZParser.StatementArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementVariableAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementVariableAssignment(ZParser.StatementVariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementVariableAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementVariableAssignment(ZParser.StatementVariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementVariableDeclaration}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementVariableDeclaration(ZParser.StatementVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementVariableDeclaration}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementVariableDeclaration(ZParser.StatementVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatementObjectPropertyCalling}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatementObjectPropertyCalling(ZParser.StatementObjectPropertyCallingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatementObjectPropertyCalling}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatementObjectPropertyCalling(ZParser.StatementObjectPropertyCallingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link ZParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(ZParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link ZParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(ZParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link ZParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void enterLoopContinue(ZParser.LoopContinueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link ZParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void exitLoopContinue(ZParser.LoopContinueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link ZParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void enterLoopBreak(ZParser.LoopBreakContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link ZParser#loop_control}.
	 * @param ctx the parse tree
	 */
	void exitLoopBreak(ZParser.LoopBreakContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintlnAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void enterPrintlnAction(ZParser.PrintlnActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintlnAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void exitPrintlnAction(ZParser.PrintlnActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void enterPrintAction(ZParser.PrintActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void exitPrintAction(ZParser.PrintActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void enterReadAction(ZParser.ReadActionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 */
	void exitReadAction(ZParser.ReadActionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReadCall}
	 * labeled alternative in {@link ZParser#read_call}.
	 * @param ctx the parse tree
	 */
	void enterReadCall(ZParser.ReadCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReadCall}
	 * labeled alternative in {@link ZParser#read_call}.
	 * @param ctx the parse tree
	 */
	void exitReadCall(ZParser.ReadCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockIf}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockIf(ZParser.BlockIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockIf}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockIf(ZParser.BlockIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockSwitch}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockSwitch(ZParser.BlockSwitchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockSwitch}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockSwitch(ZParser.BlockSwitchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockWhile}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockWhile(ZParser.BlockWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockWhile}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockWhile(ZParser.BlockWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockDoWhile}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockDoWhile(ZParser.BlockDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockDoWhile}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockDoWhile(ZParser.BlockDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockFor}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockFor(ZParser.BlockForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockFor}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockFor(ZParser.BlockForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BracedStatementBody}
	 * labeled alternative in {@link ZParser#statement_body}.
	 * @param ctx the parse tree
	 */
	void enterBracedStatementBody(ZParser.BracedStatementBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BracedStatementBody}
	 * labeled alternative in {@link ZParser#statement_body}.
	 * @param ctx the parse tree
	 */
	void exitBracedStatementBody(ZParser.BracedStatementBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleStatementBody}
	 * labeled alternative in {@link ZParser#statement_body}.
	 * @param ctx the parse tree
	 */
	void enterSingleStatementBody(ZParser.SingleStatementBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleStatementBody}
	 * labeled alternative in {@link ZParser#statement_body}.
	 * @param ctx the parse tree
	 */
	void exitSingleStatementBody(ZParser.SingleStatementBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link ZParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ZParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link ZParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ZParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZParser#else_if_list}.
	 * @param ctx the parse tree
	 */
	void enterElse_if_list(ZParser.Else_if_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZParser#else_if_list}.
	 * @param ctx the parse tree
	 */
	void exitElse_if_list(ZParser.Else_if_listContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link ZParser#else_if_clause}.
	 * @param ctx the parse tree
	 */
	void enterElseIfClause(ZParser.ElseIfClauseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link ZParser#else_if_clause}.
	 * @param ctx the parse tree
	 */
	void exitElseIfClause(ZParser.ElseIfClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link ZParser#else_block}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(ZParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link ZParser#else_block}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(ZParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SwitchStatement}
	 * labeled alternative in {@link ZParser#switch_statement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(ZParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SwitchStatement}
	 * labeled alternative in {@link ZParser#switch_statement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(ZParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SwitchCase}
	 * labeled alternative in {@link ZParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCase(ZParser.SwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SwitchCase}
	 * labeled alternative in {@link ZParser#switch_case}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCase(ZParser.SwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefaultCase}
	 * labeled alternative in {@link ZParser#default_case}.
	 * @param ctx the parse tree
	 */
	void enterDefaultCase(ZParser.DefaultCaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefaultCase}
	 * labeled alternative in {@link ZParser#default_case}.
	 * @param ctx the parse tree
	 */
	void exitDefaultCase(ZParser.DefaultCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ZParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(ZParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ZParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(ZParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link ZParser#do_while_statement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(ZParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link ZParser#do_while_statement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(ZParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ZParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(ZParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ZParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(ZParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link ZParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterForInitVarDecl(ZParser.ForInitVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link ZParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitForInitVarDecl(ZParser.ForInitVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link ZParser#for_init}.
	 * @param ctx the parse tree
	 */
	void enterForInitAssign(ZParser.ForInitAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link ZParser#for_init}.
	 * @param ctx the parse tree
	 */
	void exitForInitAssign(ZParser.ForInitAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateIncrement(ZParser.ForUpdateIncrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateIncrement(ZParser.ForUpdateIncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateDecrement(ZParser.ForUpdateDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateDecrement(ZParser.ForUpdateDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 */
	void enterForUpdateAssign(ZParser.ForUpdateAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 */
	void exitForUpdateAssign(ZParser.ForUpdateAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link ZParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(ZParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link ZParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(ZParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalVariableAssignment}
	 * labeled alternative in {@link ZParser#variable_ussage}.
	 * @param ctx the parse tree
	 */
	void enterNormalVariableAssignment(ZParser.NormalVariableAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalVariableAssignment}
	 * labeled alternative in {@link ZParser#variable_ussage}.
	 * @param ctx the parse tree
	 */
	void exitNormalVariableAssignment(ZParser.NormalVariableAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayIndexAssignment}
	 * labeled alternative in {@link ZParser#array_redefined_ussage}.
	 * @param ctx the parse tree
	 */
	void enterArrayIndexAssignment(ZParser.ArrayIndexAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayIndexAssignment}
	 * labeled alternative in {@link ZParser#array_redefined_ussage}.
	 * @param ctx the parse tree
	 */
	void exitArrayIndexAssignment(ZParser.ArrayIndexAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedObjectAssignment}
	 * labeled alternative in {@link ZParser#nested_variables_usage}.
	 * @param ctx the parse tree
	 */
	void enterNestedObjectAssignment(ZParser.NestedObjectAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedObjectAssignment}
	 * labeled alternative in {@link ZParser#nested_variables_usage}.
	 * @param ctx the parse tree
	 */
	void exitNestedObjectAssignment(ZParser.NestedObjectAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundAddAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundAddAssignment(ZParser.CompoundAddAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundAddAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundAddAssignment(ZParser.CompoundAddAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundSubAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundSubAssignment(ZParser.CompoundSubAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundSubAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundSubAssignment(ZParser.CompoundSubAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundMulAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundMulAssignment(ZParser.CompoundMulAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundMulAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundMulAssignment(ZParser.CompoundMulAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundDivAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundDivAssignment(ZParser.CompoundDivAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundDivAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundDivAssignment(ZParser.CompoundDivAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompoundModAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCompoundModAssignment(ZParser.CompoundModAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompoundModAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCompoundModAssignment(ZParser.CompoundModAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncSufixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterIncSufixOperation(ZParser.IncSufixOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncSufixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitIncSufixOperation(ZParser.IncSufixOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecSufixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterDecSufixOperation(ZParser.DecSufixOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecSufixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitDecSufixOperation(ZParser.DecSufixOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncPrefixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterIncPrefixOperation(ZParser.IncPrefixOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncPrefixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitIncPrefixOperation(ZParser.IncPrefixOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecPrefixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void enterDecPrefixOperation(ZParser.DecPrefixOperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecPrefixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 */
	void exitDecPrefixOperation(ZParser.DecPrefixOperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedVariable}
	 * labeled alternative in {@link ZParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void enterNestedVariable(ZParser.NestedVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedVariable}
	 * labeled alternative in {@link ZParser#nest_variable}.
	 * @param ctx the parse tree
	 */
	void exitNestedVariable(ZParser.NestedVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectMethodChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterObjectMethodChain(ZParser.ObjectMethodChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectMethodChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitObjectMethodChain(ZParser.ObjectMethodChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectArrayAccessChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterObjectArrayAccessChain(ZParser.ObjectArrayAccessChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectArrayAccessChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitObjectArrayAccessChain(ZParser.ObjectArrayAccessChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectPropertyChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterObjectPropertyChain(ZParser.ObjectPropertyChainContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectPropertyChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitObjectPropertyChain(ZParser.ObjectPropertyChainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseFunctionCall}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterBaseFunctionCall(ZParser.BaseFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseFunctionCall}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitBaseFunctionCall(ZParser.BaseFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void enterBaseIdentifier(ZParser.BaseIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 */
	void exitBaseIdentifier(ZParser.BaseIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentsList}
	 * labeled alternative in {@link ZParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsList(ZParser.ArgumentsListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentsList}
	 * labeled alternative in {@link ZParser#arguments_list}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsList(ZParser.ArgumentsListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectInstantiation}
	 * labeled alternative in {@link ZParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterObjectInstantiation(ZParser.ObjectInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectInstantiation}
	 * labeled alternative in {@link ZParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitObjectInstantiation(ZParser.ObjectInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayInstantiation}
	 * labeled alternative in {@link ZParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void enterArrayInstantiation(ZParser.ArrayInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayInstantiation}
	 * labeled alternative in {@link ZParser#instantiation}.
	 * @param ctx the parse tree
	 */
	void exitArrayInstantiation(ZParser.ArrayInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayLiteralValue}
	 * labeled alternative in {@link ZParser#array_literal}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralValue(ZParser.ArrayLiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayLiteralValue}
	 * labeled alternative in {@link ZParser#array_literal}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralValue(ZParser.ArrayLiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayValuesList}
	 * labeled alternative in {@link ZParser#array_values}.
	 * @param ctx the parse tree
	 */
	void enterArrayValuesList(ZParser.ArrayValuesListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayValuesList}
	 * labeled alternative in {@link ZParser#array_values}.
	 * @param ctx the parse tree
	 */
	void exitArrayValuesList(ZParser.ArrayValuesListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionParents(ZParser.ExpressionParentsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionParents(ZParser.ExpressionParentsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionTernary(ZParser.ExpressionTernaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionTernary(ZParser.ExpressionTernaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionUnary(ZParser.ExpressionUnaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionUnary(ZParser.ExpressionUnaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionEquality(ZParser.ExpressionEqualityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionEquality(ZParser.ExpressionEqualityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionRelational(ZParser.ExpressionRelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionRelational(ZParser.ExpressionRelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionValue(ZParser.ExpressionValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionValue(ZParser.ExpressionValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAnd(ZParser.ExpressionAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAnd(ZParser.ExpressionAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionOr(ZParser.ExpressionOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionOr(ZParser.ExpressionOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionMultDiv(ZParser.ExpressionMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionMultDiv(ZParser.ExpressionMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpressionAddSub(ZParser.ExpressionAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpressionAddSub(ZParser.ExpressionAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypePrimitive}
	 * labeled alternative in {@link ZParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypePrimitive(ZParser.TypePrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypePrimitive}
	 * labeled alternative in {@link ZParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypePrimitive(ZParser.TypePrimitiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeClassName}
	 * labeled alternative in {@link ZParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeClassName(ZParser.TypeClassNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeClassName}
	 * labeled alternative in {@link ZParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeClassName(ZParser.TypeClassNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(ZParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(ZParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeDouble(ZParser.TypeDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeDouble(ZParser.TypeDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeChar}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeChar(ZParser.TypeCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeChar}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeChar(ZParser.TypeCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeBoolean}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeBoolean(ZParser.TypeBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeBoolean}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeBoolean(ZParser.TypeBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeVoid}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterTypeVoid(ZParser.TypeVoidContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeVoid}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitTypeVoid(ZParser.TypeVoidContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValText}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValText(ZParser.ValTextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValText}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValText(ZParser.ValTextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValChar}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValChar(ZParser.ValCharContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValChar}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValChar(ZParser.ValCharContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValDecimal}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValDecimal(ZParser.ValDecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValDecimal}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValDecimal(ZParser.ValDecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValInt}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValInt(ZParser.ValIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValInt}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValInt(ZParser.ValIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValBool}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValBool(ZParser.ValBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValBool}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValBool(ZParser.ValBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValNull}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValNull(ZParser.ValNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValNull}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValNull(ZParser.ValNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValInstantiation}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValInstantiation(ZParser.ValInstantiationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValInstantiation}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValInstantiation(ZParser.ValInstantiationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValObjectAccess}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValObjectAccess(ZParser.ValObjectAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValObjectAccess}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValObjectAccess(ZParser.ValObjectAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValArrayLiteral}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValArrayLiteral(ZParser.ValArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValArrayLiteral}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValArrayLiteral(ZParser.ValArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ValReadCall}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValReadCall(ZParser.ValReadCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValReadCall}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValReadCall(ZParser.ValReadCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link ZParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrue(ZParser.BoolTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link ZParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrue(ZParser.BoolTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link ZParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalse(ZParser.BoolFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link ZParser#boolean_values}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalse(ZParser.BoolFalseContext ctx);
}