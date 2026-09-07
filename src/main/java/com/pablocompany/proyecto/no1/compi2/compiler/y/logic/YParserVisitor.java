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
	 * Visit a parse tree produced by the {@code AssingmentStatement}
	 * labeled alternative in {@link YParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssingmentStatement(YParser.AssingmentStatementContext ctx);
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
	 * Visit a parse tree produced by the {@code ValueBool}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueBool(YParser.ValueBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InitValueArrayLiteral}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitValueArrayLiteral(YParser.InitValueArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValueIdCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueIdCall(YParser.ValueIdCallContext ctx);
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
	 * Visit a parse tree produced by the {@code AccessNested}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessNested(YParser.AccessNestedContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#skip_lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip_lines(YParser.Skip_linesContext ctx);
}