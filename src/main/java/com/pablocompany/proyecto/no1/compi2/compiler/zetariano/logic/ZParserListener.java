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
	 * Enter a parse tree produced by {@link ZParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(ZParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(ZParser.CodeContext ctx);
}