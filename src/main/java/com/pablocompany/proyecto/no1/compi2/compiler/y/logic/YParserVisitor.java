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
	 * Visit a parse tree produced by {@link YParser#structures_region}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructures_region(YParser.Structures_regionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#struct_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declaration(YParser.Struct_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#struct_field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_field(YParser.Struct_fieldContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#functions_region}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctions_region(YParser.Functions_regionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_declaration(YParser.Function_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(YParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(YParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(YParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_declaration(YParser.Variable_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(YParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(YParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(YParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_list(YParser.Expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessor(YParser.AccessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link YParser#skip_lines}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip_lines(YParser.Skip_linesContext ctx);
}