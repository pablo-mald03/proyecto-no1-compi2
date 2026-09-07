// Generated from PigLatinParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PigLatinParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PigLatinParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PigLatinParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(PigLatinParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportLists}
	 * labeled alternative in {@link PigLatinParser#import_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportLists(PigLatinParser.ImportListsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AccessorInstruction}
	 * labeled alternative in {@link PigLatinParser#accessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessorInstruction(PigLatinParser.AccessorInstructionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaiorSection}
	 * labeled alternative in {@link PigLatinParser#maior_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaiorSection(PigLatinParser.MaiorSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CodeBodyStatement}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBodyStatement(PigLatinParser.CodeBodyStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockCode}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockCode(PigLatinParser.BlockCodeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ConsoleActions}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConsoleActions(PigLatinParser.ConsoleActionsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionSingleCall}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSingleCall(PigLatinParser.FunctionSingleCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopControlAction}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopControlAction(PigLatinParser.LoopControlActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnControlAction}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnControlAction(PigLatinParser.ReturnControlActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalAbbreviatedOperation(PigLatinParser.LocalAbbreviatedOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalVariableRedefinition}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableRedefinition(PigLatinParser.LocalVariableRedefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalArrayRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalArrayRedefinedUssage(PigLatinParser.LocalArrayRedefinedUssageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalNestedVariableUsage}
	 * labeled alternative in {@link PigLatinParser#control_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalNestedVariableUsage(PigLatinParser.LocalNestedVariableUsageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(PigLatinParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopContinue}
	 * labeled alternative in {@link PigLatinParser#loop_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopContinue(PigLatinParser.LoopContinueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopBreak}
	 * labeled alternative in {@link PigLatinParser#loop_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopBreak(PigLatinParser.LoopBreakContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadVariableInput}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadVariableInput(PigLatinParser.ReadVariableInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReadInput}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadInput(PigLatinParser.ReadInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintAction}
	 * labeled alternative in {@link PigLatinParser#console_actions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintAction(PigLatinParser.PrintActionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintSingleExpr}
	 * labeled alternative in {@link PigLatinParser#print_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintSingleExpr(PigLatinParser.PrintSingleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintMultipleExpr}
	 * labeled alternative in {@link PigLatinParser#print_function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintMultipleExpr(PigLatinParser.PrintMultipleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CodeBlockIf}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlockIf(PigLatinParser.CodeBlockIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CodeBlockWhile}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlockWhile(PigLatinParser.CodeBlockWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CodeBlockDoWhile}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlockDoWhile(PigLatinParser.CodeBlockDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CodeBlockFor}
	 * labeled alternative in {@link PigLatinParser#block_code}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBlockFor(PigLatinParser.CodeBlockForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link PigLatinParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(PigLatinParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseIfList}
	 * labeled alternative in {@link PigLatinParser#else_if_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfList(PigLatinParser.ElseIfListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseIfClause}
	 * labeled alternative in {@link PigLatinParser#else_if_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfClause(PigLatinParser.ElseIfClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseStatement}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(PigLatinParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link PigLatinParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(PigLatinParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoWhileStatement}
	 * labeled alternative in {@link PigLatinParser#do_while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(PigLatinParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link PigLatinParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(PigLatinParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInitVarDecl}
	 * labeled alternative in {@link PigLatinParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitVarDecl(PigLatinParser.ForInitVarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInitAssign}
	 * labeled alternative in {@link PigLatinParser#for_init}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitAssign(PigLatinParser.ForInitAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateIncrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateIncrement(PigLatinParser.ForUpdateIncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateDecrement}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateDecrement(PigLatinParser.ForUpdateDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForUpdateAssign}
	 * labeled alternative in {@link PigLatinParser#for_update}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForUpdateAssign(PigLatinParser.ForUpdateAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariablesSection}
	 * labeled alternative in {@link PigLatinParser#variable_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariablesSection(PigLatinParser.VariablesSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariabilesBody}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariabilesBody(PigLatinParser.VariabilesBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableInstance(PigLatinParser.VariableInstanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableRedefinedUssage(PigLatinParser.VariableRedefinedUssageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalArrayInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalArrayInstance(PigLatinParser.NormalArrayInstanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructDefinition}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDefinition(PigLatinParser.StructDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayRedefinedUssage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayRedefinedUssage(PigLatinParser.ArrayRedefinedUssageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructVariableInstance}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructVariableInstance(PigLatinParser.StructVariableInstanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GlobalAbbreviatedOperation}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalAbbreviatedOperation(PigLatinParser.GlobalAbbreviatedOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GlobalNestedVariableUsage}
	 * labeled alternative in {@link PigLatinParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalNestedVariableUsage(PigLatinParser.GlobalNestedVariableUsageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RedefiniedArrayUssage}
	 * labeled alternative in {@link PigLatinParser#array_redefined_ussage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedefiniedArrayUssage(PigLatinParser.RedefiniedArrayUssageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalVariableRedefiniedUsage}
	 * labeled alternative in {@link PigLatinParser#variable_ussage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalVariableRedefiniedUsage(PigLatinParser.NormalVariableRedefiniedUsageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedStructRedefiniedValue}
	 * labeled alternative in {@link PigLatinParser#nested_variables_usage}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedStructRedefiniedValue(PigLatinParser.NestedStructRedefiniedValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructInstance}
	 * labeled alternative in {@link PigLatinParser#struct_instance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructInstance(PigLatinParser.StructInstanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VariableDeclaration}
	 * labeled alternative in {@link PigLatinParser#variable_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(PigLatinParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalArrayDeclaration}
	 * labeled alternative in {@link PigLatinParser#normal_array_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalArrayDeclaration(PigLatinParser.NormalArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayInitWithValues}
	 * labeled alternative in {@link PigLatinParser#array_initialization}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInitWithValues(PigLatinParser.ArrayInitWithValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues_array_list(PigLatinParser.Values_array_listContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayNormalValue}
	 * labeled alternative in {@link PigLatinParser#array_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayNormalValue(PigLatinParser.ArrayNormalValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructBaseProperty}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructBaseProperty(PigLatinParser.StructBasePropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructArrayAccessChain}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructArrayAccessChain(PigLatinParser.StructArrayAccessChainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructBaseArrayProperty}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructBaseArrayProperty(PigLatinParser.StructBaseArrayPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructPropertyChain}
	 * labeled alternative in {@link PigLatinParser#struct_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructPropertyChain(PigLatinParser.StructPropertyChainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructDeclaration}
	 * labeled alternative in {@link PigLatinParser#struct_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(PigLatinParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructSeparatedBody}
	 * labeled alternative in {@link PigLatinParser#struct_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructSeparatedBody(PigLatinParser.StructSeparatedBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructCommaBody}
	 * labeled alternative in {@link PigLatinParser#struct_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructCommaBody(PigLatinParser.StructCommaBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructNormalBody}
	 * labeled alternative in {@link PigLatinParser#struct_normal_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructNormalBody(PigLatinParser.StructNormalBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructCommaStatementBody}
	 * labeled alternative in {@link PigLatinParser#struct_comma_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructCommaStatementBody(PigLatinParser.StructCommaStatementBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NormalVariableStruct}
	 * labeled alternative in {@link PigLatinParser#struct_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalVariableStruct(PigLatinParser.NormalVariableStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayVariableStruct}
	 * labeled alternative in {@link PigLatinParser#struct_attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayVariableStruct(PigLatinParser.ArrayVariableStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InternalStructNormalVariable}
	 * labeled alternative in {@link PigLatinParser#variable_without_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInternalStructNormalVariable(PigLatinParser.InternalStructNormalVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InternalStructArray}
	 * labeled alternative in {@link PigLatinParser#array_variable_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInternalStructArray(PigLatinParser.InternalStructArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructLiteralValue}
	 * labeled alternative in {@link PigLatinParser#struct_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructLiteralValue(PigLatinParser.StructLiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructDataList}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDataList(PigLatinParser.StructDataListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructDataNormal}
	 * labeled alternative in {@link PigLatinParser#struct_data_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDataNormal(PigLatinParser.StructDataNormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionParents}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionParents(PigLatinParser.ExpressionParentsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnary}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnary(PigLatinParser.ExpressionUnaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionEquality}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEquality(PigLatinParser.ExpressionEqualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionRelational}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionRelational(PigLatinParser.ExpressionRelationalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionValue}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionValue(PigLatinParser.ExpressionValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAnd}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAnd(PigLatinParser.ExpressionAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionOr}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionOr(PigLatinParser.ExpressionOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionMultDiv}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMultDiv(PigLatinParser.ExpressionMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAddSub}
	 * labeled alternative in {@link PigLatinParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAddSub(PigLatinParser.ExpressionAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeText}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeText(PigLatinParser.TypeTextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(PigLatinParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDecimal}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDecimal(PigLatinParser.TypeDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeChar}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeChar(PigLatinParser.TypeCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBoolean}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBoolean(PigLatinParser.TypeBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeCustomId}
	 * labeled alternative in {@link PigLatinParser#variable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCustomId(PigLatinParser.TypeCustomIdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayCall}
	 * labeled alternative in {@link PigLatinParser#array_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCall(PigLatinParser.ArrayCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionCalling}
	 * labeled alternative in {@link PigLatinParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCalling(PigLatinParser.FunctionCallingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentsList}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsList(PigLatinParser.ArgumentsListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedValueVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedValueVariable(PigLatinParser.NestedValueVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayCallVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCallVariable(PigLatinParser.ArrayCallVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SigleValueVariable}
	 * labeled alternative in {@link PigLatinParser#nest_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSigleValueVariable(PigLatinParser.SigleValueVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValString}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValString(PigLatinParser.ValStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValChar}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValChar(PigLatinParser.ValCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValDecimal}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValDecimal(PigLatinParser.ValDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValInt}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValInt(PigLatinParser.ValIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValBool}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValBool(PigLatinParser.ValBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValArrayCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValArrayCall(PigLatinParser.ValArrayCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValFunctionCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValFunctionCall(PigLatinParser.ValFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValStructNestValue}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValStructNestValue(PigLatinParser.ValStructNestValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValStructPropertyLiteral}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValStructPropertyLiteral(PigLatinParser.ValStructPropertyLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValArrayLiteral}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValArrayLiteral(PigLatinParser.ValArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ValIdCall}
	 * labeled alternative in {@link PigLatinParser#normal_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValIdCall(PigLatinParser.ValIdCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolTrue}
	 * labeled alternative in {@link PigLatinParser#boolean_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTrue(PigLatinParser.BoolTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolFalse}
	 * labeled alternative in {@link PigLatinParser#boolean_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFalse(PigLatinParser.BoolFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncOperation(PigLatinParser.IncOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecOperation(PigLatinParser.DecOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IncPrevOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncPrevOperation(PigLatinParser.IncPrevOperationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecPrevOperation}
	 * labeled alternative in {@link PigLatinParser#abbreviated_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecPrevOperation(PigLatinParser.DecPrevOperationContext ctx);
}