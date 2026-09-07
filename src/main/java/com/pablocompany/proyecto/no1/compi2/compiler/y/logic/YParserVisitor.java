// Generated from YParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.y.logic;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link YParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(YParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructRegionDeclaration}
	 * labeled alternative in {@link YParser#structures_region}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructRegionDeclaration(YParser.StructRegionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructDeclaration}
	 * labeled alternative in {@link YParser#struct_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(YParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructNormalProperty}
	 * labeled alternative in {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructNormalProperty(YParser.StructNormalPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructArrayProperty}
	 * labeled alternative in {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructArrayProperty(YParser.StructArrayPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionSection}
	 * labeled alternative in {@link YParser#functions_region}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSection(YParser.FunctionSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link YParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(YParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link YParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(YParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrimitiveParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitiveParameter(YParser.PrimitiveParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayParameter(YParser.ArrayParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructParameter}
	 * labeled alternative in {@link YParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructParameter(YParser.StructParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(YParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementConsoleAction}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementConsoleAction(YParser.StatementConsoleActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementLoopControl}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementLoopControl(YParser.StatementLoopControlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementAbbreviatedOperation}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAbbreviatedOperation(YParser.StatementAbbreviatedOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementCompoundAssignment}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementCompoundAssignment(YParser.StatementCompoundAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementStructDeclaration}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementStructDeclaration(YParser.StatementStructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclarationStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationStatement(YParser.VariableDeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentVariableStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentVariableStatement(YParser.AssignmentVariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(YParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockIf}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockIf(YParser.BlockIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockSwitch}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSwitch(YParser.BlockSwitchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockWhile}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockWhile(YParser.BlockWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockDoWhile}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockDoWhile(YParser.BlockDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockFor}
	 * labeled alternative in {@link YParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockFor(YParser.BlockForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link YParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(YParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseIfList}
	 * labeled alternative in {@link YParser#else_if_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfList(YParser.ElseIfListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link YParser#else_if_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfClause(YParser.ElseIfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link YParser#else_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(YParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SwitchStatement}
	 * labeled alternative in {@link YParser#switch_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(YParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SwitchCase}
	 * labeled alternative in {@link YParser#switch_case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCase(YParser.SwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AlwaysCase}
	 * labeled alternative in {@link YParser#always_case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlwaysCase(YParser.AlwaysCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link YParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(YParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link YParser#do_while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(YParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link YParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(YParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link YParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitVarDecl(YParser.ForInitVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link YParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitAssign(YParser.ForInitAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateIncrement(YParser.ForUpdateIncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateDecrement(YParser.ForUpdateDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdatePrefixIncrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdatePrefixIncrement(YParser.ForUpdatePrefixIncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdatePrefixDecrement}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdatePrefixDecrement(YParser.ForUpdatePrefixDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link YParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateAssign(YParser.ForUpdateAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link YParser#loop_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopContinue(YParser.LoopContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link YParser#loop_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopBreak(YParser.LoopBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link YParser#console_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintAction(YParser.PrintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadAction}
	 * labeled alternative in {@link YParser#console_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadAction(YParser.ReadActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadCall}
	 * labeled alternative in {@link YParser#read_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadCall(YParser.ReadCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncSufixOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncSufixOperation(YParser.IncSufixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecSufixOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecSufixOperation(YParser.DecSufixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncPrefixOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncPrefixOperation(YParser.IncPrefixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecPrefixOperation}
	 * labeled alternative in {@link YParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecPrefixOperation(YParser.DecPrefixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundAddAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundAddAssignment(YParser.CompoundAddAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundSubAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundSubAssignment(YParser.CompoundSubAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundMulAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundMulAssignment(YParser.CompoundMulAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundDivAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundDivAssignment(YParser.CompoundDivAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundModAssignment}
	 * labeled alternative in {@link YParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundModAssignment(YParser.CompoundModAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssingmentStatement}
	 * labeled alternative in {@link YParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssingmentStatement(YParser.AssingmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedVariable}
	 * labeled alternative in {@link YParser#nest_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedVariable(YParser.NestedVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectArrayAccessChain}
	 * labeled alternative in {@link YParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectArrayAccessChain(YParser.ObjectArrayAccessChainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectPropertyChain}
	 * labeled alternative in {@link YParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPropertyChain(YParser.ObjectPropertyChainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseFunctionCall}
	 * labeled alternative in {@link YParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseFunctionCall(YParser.BaseFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BaseIdentifier}
	 * labeled alternative in {@link YParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseIdentifier(YParser.BaseIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentsList}
	 * labeled alternative in {@link YParser#arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsList(YParser.ArgumentsListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLiteralValue}
	 * labeled alternative in {@link YParser#array_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralValue(YParser.ArrayLiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValuesList}
	 * labeled alternative in {@link YParser#array_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValuesList(YParser.ArrayValuesListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotDefiniedVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotDefiniedVariable(YParser.NotDefiniedVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefiniedVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniedVariable(YParser.DefiniedVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotDefiniedArrayVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotDefiniedArrayVariable(YParser.NotDefiniedArrayVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefiniedArrayVariable}
	 * labeled alternative in {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefiniedArrayVariable(YParser.DefiniedArrayVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntValue(YParser.IntValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(YParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatValue(YParser.FloatValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharValue(YParser.CharValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(YParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CustomTypeValue}
	 * labeled alternative in {@link YParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomTypeValue(YParser.CustomTypeValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionParents(YParser.ExpressionParentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnary(YParser.ExpressionUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEquality(YParser.ExpressionEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionRelational(YParser.ExpressionRelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionValue(YParser.ExpressionValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAnd(YParser.ExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOr(YParser.ExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMultDiv(YParser.ExpressionMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddSub(YParser.ExpressionAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueString}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueString(YParser.ValueStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueChar}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueChar(YParser.ValueCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueDecimal}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueDecimal(YParser.ValueDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueInt}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueInt(YParser.ValueIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValBool}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValBool(YParser.ValBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValObjectAccess}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValObjectAccess(YParser.ValObjectAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValArrayLiteral}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValArrayLiteral(YParser.ValArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValReadCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValReadCall(YParser.ValReadCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link YParser#boolean_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrue(YParser.BoolTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link YParser#boolean_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFalse(YParser.BoolFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionList}
	 * labeled alternative in {@link YParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(YParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#skip_lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip_lines(YParser.Skip_linesContext ctx);
}