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
	 * Enter a parse tree produced by {@link YParser#structures_region}.
	 * @param ctx the parse tree
	 */
	void enterStructures_region(YParser.Structures_regionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#structures_region}.
	 * @param ctx the parse tree
	 */
	void exitStructures_region(YParser.Structures_regionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void enterStruct_declaration(YParser.Struct_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void exitStruct_declaration(YParser.Struct_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void enterStruct_field(YParser.Struct_fieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 */
	void exitStruct_field(YParser.Struct_fieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#functions_region}.
	 * @param ctx the parse tree
	 */
	void enterFunctions_region(YParser.Functions_regionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#functions_region}.
	 * @param ctx the parse tree
	 */
	void exitFunctions_region(YParser.Functions_regionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunction_declaration(YParser.Function_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#function_declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunction_declaration(YParser.Function_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(YParser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(YParser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(YParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(YParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(YParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(YParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariable_declaration(YParser.Variable_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariable_declaration(YParser.Variable_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(YParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(YParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(YParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(YParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(YParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(YParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void enterExpression_list(YParser.Expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#expression_list}.
	 * @param ctx the parse tree
	 */
	void exitExpression_list(YParser.Expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void enterAccessor(YParser.AccessorContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#accessor}.
	 * @param ctx the parse tree
	 */
	void exitAccessor(YParser.AccessorContext ctx);
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