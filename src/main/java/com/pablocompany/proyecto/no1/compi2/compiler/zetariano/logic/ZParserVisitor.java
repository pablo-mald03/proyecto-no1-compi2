// Generated from ZParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ZParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ZParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ZParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ZParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassDeclaration}
	 * labeled alternative in {@link ZParser#class_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(ZParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassFieldMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassFieldMember(ZParser.ClassFieldMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassConstructorMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassConstructorMember(ZParser.ClassConstructorMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassMethodMember}
	 * labeled alternative in {@link ZParser#class_member}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethodMember(ZParser.ClassMethodMemberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConstructorDeclaration}
	 * labeled alternative in {@link ZParser#constructor_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(ZParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MethodDeclaration}
	 * labeled alternative in {@link ZParser#method_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(ZParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParameterList}
	 * labeled alternative in {@link ZParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(ZParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParameterStatement}
	 * labeled alternative in {@link ZParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterStatement(ZParser.ParameterStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementBlock}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(ZParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementConsoleAction}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementConsoleAction(ZParser.StatementConsoleActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementFunctionCall}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementFunctionCall(ZParser.StatementFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementLoopControl}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementLoopControl(ZParser.StatementLoopControlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementReturn}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementReturn(ZParser.StatementReturnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementAbbreviatedOperation}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementAbbreviatedOperation(ZParser.StatementAbbreviatedOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementCompoundAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementCompoundAssignment(ZParser.StatementCompoundAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementNestedAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementNestedAssignment(ZParser.StatementNestedAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementArrayAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementArrayAssignment(ZParser.StatementArrayAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementVariableAssignment}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementVariableAssignment(ZParser.StatementVariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StatementVariableDeclaration}
	 * labeled alternative in {@link ZParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementVariableDeclaration(ZParser.StatementVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link ZParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ZParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link ZParser#loop_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopContinue(ZParser.LoopContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link ZParser#loop_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopBreak(ZParser.LoopBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintlnAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintlnAction(ZParser.PrintlnActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintAction(ZParser.PrintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadAction}
	 * labeled alternative in {@link ZParser#console_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadAction(ZParser.ReadActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadCall}
	 * labeled alternative in {@link ZParser#read_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadCall(ZParser.ReadCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockIf}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockIf(ZParser.BlockIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockSwitch}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSwitch(ZParser.BlockSwitchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockWhile}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockWhile(ZParser.BlockWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockDoWhile}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockDoWhile(ZParser.BlockDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockFor}
	 * labeled alternative in {@link ZParser#block_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockFor(ZParser.BlockForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BracedStatementBody}
	 * labeled alternative in {@link ZParser#statement_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracedStatementBody(ZParser.BracedStatementBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleStatementBody}
	 * labeled alternative in {@link ZParser#statement_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStatementBody(ZParser.SingleStatementBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link ZParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ZParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZParser#else_if_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_if_list(ZParser.Else_if_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link ZParser#else_if_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfClause(ZParser.ElseIfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link ZParser#else_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(ZParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SwitchStatement}
	 * labeled alternative in {@link ZParser#switch_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(ZParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SwitchCase}
	 * labeled alternative in {@link ZParser#switch_case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCase(ZParser.SwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefaultCase}
	 * labeled alternative in {@link ZParser#default_case}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultCase(ZParser.DefaultCaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link ZParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(ZParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link ZParser#do_while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(ZParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link ZParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(ZParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link ZParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitVarDecl(ZParser.ForInitVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link ZParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitAssign(ZParser.ForInitAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateIncrement(ZParser.ForUpdateIncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateDecrement(ZParser.ForUpdateDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link ZParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateAssign(ZParser.ForUpdateAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link ZParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(ZParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalVariableAssignment}
	 * labeled alternative in {@link ZParser#variable_ussage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalVariableAssignment(ZParser.NormalVariableAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayIndexAssignment}
	 * labeled alternative in {@link ZParser#array_redefined_ussage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayIndexAssignment(ZParser.ArrayIndexAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedObjectAssignment}
	 * labeled alternative in {@link ZParser#nested_variables_usage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedObjectAssignment(ZParser.NestedObjectAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundAddAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundAddAssignment(ZParser.CompoundAddAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundSubAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundSubAssignment(ZParser.CompoundSubAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundMulAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundMulAssignment(ZParser.CompoundMulAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundDivAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundDivAssignment(ZParser.CompoundDivAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompoundModAssignment}
	 * labeled alternative in {@link ZParser#compound_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundModAssignment(ZParser.CompoundModAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncSufixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncSufixOperation(ZParser.IncSufixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecSufixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecSufixOperation(ZParser.DecSufixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncPrefixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncPrefixOperation(ZParser.IncPrefixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecPrefixOperation}
	 * labeled alternative in {@link ZParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecPrefixOperation(ZParser.DecPrefixOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedObjectVariable}
	 * labeled alternative in {@link ZParser#nest_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedObjectVariable(ZParser.NestedObjectVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedArrayVariable}
	 * labeled alternative in {@link ZParser#nest_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedArrayVariable(ZParser.NestedArrayVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedSingleVariable}
	 * labeled alternative in {@link ZParser#nest_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedSingleVariable(ZParser.NestedSingleVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectMethodChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectMethodChain(ZParser.ObjectMethodChainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectArrayAccessChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectArrayAccessChain(ZParser.ObjectArrayAccessChainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectBaseProperty}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBaseProperty(ZParser.ObjectBasePropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectBaseArrayProperty}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBaseArrayProperty(ZParser.ObjectBaseArrayPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectBaseMethodCall}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBaseMethodCall(ZParser.ObjectBaseMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectPropertyChain}
	 * labeled alternative in {@link ZParser#object_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectPropertyChain(ZParser.ObjectPropertyChainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayCall}
	 * labeled alternative in {@link ZParser#array_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCall(ZParser.ArrayCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCalling}
	 * labeled alternative in {@link ZParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCalling(ZParser.FunctionCallingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentsList}
	 * labeled alternative in {@link ZParser#arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsList(ZParser.ArgumentsListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectInstantiation}
	 * labeled alternative in {@link ZParser#instantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectInstantiation(ZParser.ObjectInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayInstantiation}
	 * labeled alternative in {@link ZParser#instantiation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInstantiation(ZParser.ArrayInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLiteralValue}
	 * labeled alternative in {@link ZParser#array_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralValue(ZParser.ArrayLiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValuesList}
	 * labeled alternative in {@link ZParser#array_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValuesList(ZParser.ArrayValuesListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionParents(ZParser.ExpressionParentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionTernary}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionTernary(ZParser.ExpressionTernaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnary(ZParser.ExpressionUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEquality(ZParser.ExpressionEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionRelational(ZParser.ExpressionRelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionValue(ZParser.ExpressionValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAnd(ZParser.ExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOr(ZParser.ExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMultDiv(ZParser.ExpressionMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link ZParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddSub(ZParser.ExpressionAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypePrimitive}
	 * labeled alternative in {@link ZParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypePrimitive(ZParser.TypePrimitiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeClassName}
	 * labeled alternative in {@link ZParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeClassName(ZParser.TypeClassNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(ZParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDouble(ZParser.TypeDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeChar}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeChar(ZParser.TypeCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBoolean}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBoolean(ZParser.TypeBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeVoid}
	 * labeled alternative in {@link ZParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeVoid(ZParser.TypeVoidContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValText}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValText(ZParser.ValTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValChar}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValChar(ZParser.ValCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValDecimal}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValDecimal(ZParser.ValDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValInt}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValInt(ZParser.ValIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValBool}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValBool(ZParser.ValBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValNull}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValNull(ZParser.ValNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValInstantiation}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValInstantiation(ZParser.ValInstantiationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValObjectAccess}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValObjectAccess(ZParser.ValObjectAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValArrayCall}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValArrayCall(ZParser.ValArrayCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValFunctionCall}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFunctionCall(ZParser.ValFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValArrayLiteral}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValArrayLiteral(ZParser.ValArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValReadCall}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValReadCall(ZParser.ValReadCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValIdCall}
	 * labeled alternative in {@link ZParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValIdCall(ZParser.ValIdCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link ZParser#boolean_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrue(ZParser.BoolTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link ZParser#boolean_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFalse(ZParser.BoolFalseContext ctx);
}