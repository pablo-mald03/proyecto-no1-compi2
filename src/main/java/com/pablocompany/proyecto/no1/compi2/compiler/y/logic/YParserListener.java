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
	 * Enter a parse tree produced by {@link YParser#code}.
	 * @param ctx the parse tree
	 */
	void enterCode(YParser.CodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link YParser#code}.
	 * @param ctx the parse tree
	 */
	void exitCode(YParser.CodeContext ctx);
}