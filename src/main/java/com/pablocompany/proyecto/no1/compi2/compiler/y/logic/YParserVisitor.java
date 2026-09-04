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
	 * Visit a parse tree produced by {@link YParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(YParser.CodeContext ctx);
}