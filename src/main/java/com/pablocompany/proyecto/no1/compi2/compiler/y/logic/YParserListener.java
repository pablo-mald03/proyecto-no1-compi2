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
	 * Enter a parse tree produced by the {@code ValueIdCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void enterValueIdCall(YParser.ValueIdCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ValueIdCall}
	 * labeled alternative in {@link YParser#normal_values}.
	 * @param ctx the parse tree
	 */
	void exitValueIdCall(YParser.ValueIdCallContext ctx);
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
	 * Enter a parse tree produced by the {@code AccessNested}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void enterAccessNested(YParser.AccessNestedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AccessNested}
	 * labeled alternative in {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void exitAccessNested(YParser.AccessNestedContext ctx);
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