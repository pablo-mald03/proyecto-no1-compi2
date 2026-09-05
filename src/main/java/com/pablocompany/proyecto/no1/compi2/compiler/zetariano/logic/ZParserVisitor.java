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
	 * Visit a parse tree produced by {@link ZParser#code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCode(ZParser.CodeContext ctx);
}