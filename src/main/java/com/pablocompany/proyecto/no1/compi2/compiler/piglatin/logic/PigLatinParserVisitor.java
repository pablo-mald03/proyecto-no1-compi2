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
	 * Visit a parse tree produced by the {@code ProgramRoot}
	 * labeled alternative in {@link PigLatinParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramRoot(PigLatinParser.ProgramRootContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(PigLatinParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MuneraSection}
	 * labeled alternative in {@link PigLatinParser#munera_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuneraSection(PigLatinParser.MuneraSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionsBlockList}
	 * labeled alternative in {@link PigLatinParser#munera_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionsBlockList(PigLatinParser.FunctionsBlockListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionsSingleBlock}
	 * labeled alternative in {@link PigLatinParser#munera_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionsSingleBlock(PigLatinParser.FunctionsSingleBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncDeclBlock}
	 * labeled alternative in {@link PigLatinParser#functions_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclBlock(PigLatinParser.FuncDeclBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProcDeclBlock}
	 * labeled alternative in {@link PigLatinParser#functions_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcDeclBlock(PigLatinParser.ProcDeclBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDeclaration}
	 * labeled alternative in {@link PigLatinParser#function_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PigLatinParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionReturNormalType}
	 * labeled alternative in {@link PigLatinParser#variable_function_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturNormalType(PigLatinParser.FunctionReturNormalTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProcedureDeclaration}
	 * labeled alternative in {@link PigLatinParser#procedure_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureDeclaration(PigLatinParser.ProcedureDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionBody}
	 * labeled alternative in {@link PigLatinParser#function_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(PigLatinParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ProcedureBody}
	 * labeled alternative in {@link PigLatinParser#procedure_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureBody(PigLatinParser.ProcedureBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalVariablesList}
	 * labeled alternative in {@link PigLatinParser#local_variable_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariablesList(PigLatinParser.LocalVariablesListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalSingleVariable}
	 * labeled alternative in {@link PigLatinParser#local_variable_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalSingleVariable(PigLatinParser.LocalSingleVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalVarDeclaration}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVarDeclaration(PigLatinParser.LocalVarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalArrayDeclaration}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalArrayDeclaration(PigLatinParser.LocalArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalStructInstance}
	 * labeled alternative in {@link PigLatinParser#local_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalStructInstance(PigLatinParser.LocalStructInstanceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionSingleArg}
	 * labeled alternative in {@link PigLatinParser#function_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSingleArg(PigLatinParser.FunctionSingleArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionArgsList}
	 * labeled alternative in {@link PigLatinParser#function_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArgsList(PigLatinParser.FunctionArgsListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentVariableDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentVariableDeclaration(PigLatinParser.ArgumentVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentArrayDeclarationn}
	 * labeled alternative in {@link PigLatinParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentArrayDeclarationn(PigLatinParser.ArgumentArrayDeclarationnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentNormalDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument_variable_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentNormalDeclaration(PigLatinParser.ArgumentNormalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentArrayNormalDeclaration}
	 * labeled alternative in {@link PigLatinParser#argument_series_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentArrayNormalDeclaration(PigLatinParser.ArgumentArrayNormalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaiorSection}
	 * labeled alternative in {@link PigLatinParser#maior_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaiorSection(PigLatinParser.MaiorSectionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockControlList}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockControlList(PigLatinParser.BlockControlListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockSingleControl}
	 * labeled alternative in {@link PigLatinParser#code_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSingleControl(PigLatinParser.BlockSingleControlContext ctx);
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
	 * Visit a parse tree produced by the {@code ReturnWithValue}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnWithValue(PigLatinParser.ReturnWithValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnVoid}
	 * labeled alternative in {@link PigLatinParser#return_control}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnVoid(PigLatinParser.ReturnVoidContext ctx);
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
	 * Visit a parse tree produced by the {@code ElseIfSingle}
	 * labeled alternative in {@link PigLatinParser#else_if_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfSingle(PigLatinParser.ElseIfSingleContext ctx);
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
	 * Visit a parse tree produced by the {@code ElseBlock}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseBlock(PigLatinParser.ElseBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseEmpty}
	 * labeled alternative in {@link PigLatinParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseEmpty(PigLatinParser.ElseEmptyContext ctx);
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
	 * Visit a parse tree produced by the {@code DeclarationsVariablesList}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationsVariablesList(PigLatinParser.DeclarationsVariablesListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclarationsSingleVariable}
	 * labeled alternative in {@link PigLatinParser#variabiles_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationsSingleVariable(PigLatinParser.DeclarationsSingleVariableContext ctx);
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
	 * Visit a parse tree produced by the {@code ArraySingleValue}
	 * labeled alternative in {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySingleValue(PigLatinParser.ArraySingleValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayValueList}
	 * labeled alternative in {@link PigLatinParser#values_array_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayValueList(PigLatinParser.ArrayValueListContext ctx);
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
	 * Visit a parse tree produced by the {@code StructNormalBodyList}
	 * labeled alternative in {@link PigLatinParser#struct_normal_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructNormalBodyList(PigLatinParser.StructNormalBodyListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructNormalBodySingle}
	 * labeled alternative in {@link PigLatinParser#struct_normal_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructNormalBodySingle(PigLatinParser.StructNormalBodySingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructCommaBodySingle}
	 * labeled alternative in {@link PigLatinParser#struct_comma_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructCommaBodySingle(PigLatinParser.StructCommaBodySingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructCommaBodyList}
	 * labeled alternative in {@link PigLatinParser#struct_comma_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructCommaBodyList(PigLatinParser.StructCommaBodyListContext ctx);
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
	 * Visit a parse tree produced by the {@code StructValueList}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructValueList(PigLatinParser.StructValueListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StructSingleValue}
	 * labeled alternative in {@link PigLatinParser#struct_data_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructSingleValue(PigLatinParser.StructSingleValueContext ctx);
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
	 * Visit a parse tree produced by the {@code ArgumentSingleFunction}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentSingleFunction(PigLatinParser.ArgumentSingleFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentFunctionList}
	 * labeled alternative in {@link PigLatinParser#arguments_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentFunctionList(PigLatinParser.ArgumentFunctionListContext ctx);
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