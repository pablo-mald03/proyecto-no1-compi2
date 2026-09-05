// Generated from PigLatinParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.piglatin.logic;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PigLatinParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, BLOCK_COMMENT=2, WS=3, VARIABILES=4, MAIOR=5, FINIS_SEPARATOR=6, 
		PRINT=7, READ=8, NUMERUS=9, TEXTUM=10, DECIMALIS=11, LITTERA=12, BOOLEAN=13, 
		VERUM=14, FALSUS=15, IMPORT=16, NOVUS=17, ESTO=18, SERIES=19, STRUCTURE=20, 
		FINIS=21, DUM=22, FACERE=23, PER=24, SI=25, ALITER=26, ACTIO=27, RATIO=28, 
		REDDERE=29, PERGE=30, INTERRUMPE=31, EQUAL=32, COMMA=33, DOT_COMMA=34, 
		TWO_POINTS=35, DOT=36, INIT_BRACE=37, FINAL_BRACE=38, INIT_BRACKET=39, 
		FINAL_BRACKET=40, INIT_PARENT=41, FINAL_PARENT=42, BY_ONE_ADD=43, BY_ONE_MINUS=44, 
		BY_ONE_MULTIPLICATION=45, BY_ONE_DIVISION=46, BY_ONE_PERCENT=47, ABREV_PLUS=48, 
		ABREV_MINUS=49, PLUS=50, MINUS=51, MULTIPLICATION=52, DIVIDE=53, PERCENT=54, 
		EQUALS=55, GREATER_EQUALS=56, LESS_EQUALS=57, DIFERENCE=58, LESS=59, GREATER=60, 
		AND=61, OR=62, NOT=63, ID=64, INT=65, DECIMAL=66, STRING=67, CHAR=68, 
		ERROR_TOKEN=69;
	public static final int
		RULE_program = 0, RULE_body = 1, RULE_munera_body = 2, RULE_functions_block = 3, 
		RULE_function_declaration = 4, RULE_variable_function_type = 5, RULE_procedure_declaration = 6, 
		RULE_function_body = 7, RULE_procedure_body = 8, RULE_local_variable_list = 9, 
		RULE_local_variable = 10, RULE_function_arguments = 11, RULE_argument = 12, 
		RULE_argument_variable_type = 13, RULE_argument_series_type = 14, RULE_maior_section = 15, 
		RULE_code_body = 16, RULE_control_block = 17, RULE_return_control = 18, 
		RULE_loop_control = 19, RULE_console_actions = 20, RULE_print_function = 21, 
		RULE_block_code = 22, RULE_if_statement = 23, RULE_else_if_list = 24, 
		RULE_else_if_clause = 25, RULE_else_statement = 26, RULE_while_statement = 27, 
		RULE_do_while_statement = 28, RULE_for_statement = 29, RULE_for_init = 30, 
		RULE_for_update = 31, RULE_variable_section = 32, RULE_variabiles_body = 33, 
		RULE_declarations = 34, RULE_array_redefined_ussage = 35, RULE_variable_ussage = 36, 
		RULE_nested_variables_usage = 37, RULE_struct_instance = 38, RULE_variable_declaration = 39, 
		RULE_normal_array_declaration = 40, RULE_array_initialization = 41, RULE_values_array_list = 42, 
		RULE_array_value = 43, RULE_struct_values = 44, RULE_struct_declaration = 45, 
		RULE_struct_body = 46, RULE_struct_normal_body = 47, RULE_struct_comma_body = 48, 
		RULE_struct_attribute = 49, RULE_variable_without_value = 50, RULE_array_variable_struct = 51, 
		RULE_struct_literal = 52, RULE_struct_data_list = 53, RULE_struct_data_value = 54, 
		RULE_expression = 55, RULE_variable_type = 56, RULE_array_call = 57, RULE_function_call = 58, 
		RULE_arguments_list = 59, RULE_nest_variable = 60, RULE_normal_values = 61, 
		RULE_boolean_values = 62, RULE_abbreviated_operation = 63;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "body", "munera_body", "functions_block", "function_declaration", 
			"variable_function_type", "procedure_declaration", "function_body", "procedure_body", 
			"local_variable_list", "local_variable", "function_arguments", "argument", 
			"argument_variable_type", "argument_series_type", "maior_section", "code_body", 
			"control_block", "return_control", "loop_control", "console_actions", 
			"print_function", "block_code", "if_statement", "else_if_list", "else_if_clause", 
			"else_statement", "while_statement", "do_while_statement", "for_statement", 
			"for_init", "for_update", "variable_section", "variabiles_body", "declarations", 
			"array_redefined_ussage", "variable_ussage", "nested_variables_usage", 
			"struct_instance", "variable_declaration", "normal_array_declaration", 
			"array_initialization", "values_array_list", "array_value", "struct_values", 
			"struct_declaration", "struct_body", "struct_normal_body", "struct_comma_body", 
			"struct_attribute", "variable_without_value", "array_variable_struct", 
			"struct_literal", "struct_data_list", "struct_data_value", "expression", 
			"variable_type", "array_call", "function_call", "arguments_list", "nest_variable", 
			"normal_values", "boolean_values", "abbreviated_operation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'VARIABILES'", "'MAIOR'", "'FINIS'", "'>>'", 
			"'<<'", "'numerus'", "'textum'", "'decimalis'", "'littera'", "'bool'", 
			"'verum'", "'falsus'", "'import'", "'novus'", "'esto'", "'series'", "'structura'", 
			"'finis'", "'dum'", "'facere'", "'per'", "'si'", "'aliter'", "'actio'", 
			"'ratio'", "'reddere'", "'perge'", "'interrumpe'", "'='", "','", "';'", 
			"':'", "'.'", "'{'", "'}'", "'['", "']'", "'('", "')'", "'+='", "'-='", 
			"'*='", "'/='", "'%='", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'%'", 
			"'=='", "'>='", "'<='", "'!='", "'<'", "'>'", "'&&'", "'||'", "'non'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "BLOCK_COMMENT", "WS", "VARIABILES", "MAIOR", "FINIS_SEPARATOR", 
			"PRINT", "READ", "NUMERUS", "TEXTUM", "DECIMALIS", "LITTERA", "BOOLEAN", 
			"VERUM", "FALSUS", "IMPORT", "NOVUS", "ESTO", "SERIES", "STRUCTURE", 
			"FINIS", "DUM", "FACERE", "PER", "SI", "ALITER", "ACTIO", "RATIO", "REDDERE", 
			"PERGE", "INTERRUMPE", "EQUAL", "COMMA", "DOT_COMMA", "TWO_POINTS", "DOT", 
			"INIT_BRACE", "FINAL_BRACE", "INIT_BRACKET", "FINAL_BRACKET", "INIT_PARENT", 
			"FINAL_PARENT", "BY_ONE_ADD", "BY_ONE_MINUS", "BY_ONE_MULTIPLICATION", 
			"BY_ONE_DIVISION", "BY_ONE_PERCENT", "ABREV_PLUS", "ABREV_MINUS", "PLUS", 
			"MINUS", "MULTIPLICATION", "DIVIDE", "PERCENT", "EQUALS", "GREATER_EQUALS", 
			"LESS_EQUALS", "DIFERENCE", "LESS", "GREATER", "AND", "OR", "NOT", "ID", 
			"INT", "DECIMAL", "STRING", "CHAR", "ERROR_TOKEN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PigLatinParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PigLatinParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProgramRootContext extends ProgramContext {
		public TerminalNode EOF() { return getToken(PigLatinParser.EOF, 0); }
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public ProgramRootContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterProgramRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitProgramRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitProgramRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			_localctx = new ProgramRootContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VARIABILES || _la==MAIOR) {
				{
				{
				setState(128);
				body();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public Maior_sectionContext maior_section() {
			return getRuleContext(Maior_sectionContext.class,0);
		}
		public TerminalNode FINIS_SEPARATOR() { return getToken(PigLatinParser.FINIS_SEPARATOR, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public Variable_sectionContext variable_section() {
			return getRuleContext(Variable_sectionContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABILES) {
				{
				setState(136);
				variable_section();
				}
			}

			setState(139);
			maior_section();
			setState(140);
			match(FINIS_SEPARATOR);
			setState(141);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Munera_bodyContext extends ParserRuleContext {
		public Munera_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_munera_body; }
	 
		public Munera_bodyContext() { }
		public void copyFrom(Munera_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionsBlockListContext extends Munera_bodyContext {
		public Munera_bodyContext munera_body() {
			return getRuleContext(Munera_bodyContext.class,0);
		}
		public Functions_blockContext functions_block() {
			return getRuleContext(Functions_blockContext.class,0);
		}
		public FunctionsBlockListContext(Munera_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionsBlockList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionsBlockList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionsBlockList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionsSingleBlockContext extends Munera_bodyContext {
		public Functions_blockContext functions_block() {
			return getRuleContext(Functions_blockContext.class,0);
		}
		public FunctionsSingleBlockContext(Munera_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionsSingleBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionsSingleBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionsSingleBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Munera_bodyContext munera_body() throws RecognitionException {
		return munera_body(0);
	}

	private Munera_bodyContext munera_body(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Munera_bodyContext _localctx = new Munera_bodyContext(_ctx, _parentState);
		Munera_bodyContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_munera_body, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FunctionsSingleBlockContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(144);
			functions_block();
			}
			_ctx.stop = _input.LT(-1);
			setState(150);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FunctionsBlockListContext(new Munera_bodyContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_munera_body);
					setState(146);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(147);
					functions_block();
					}
					} 
				}
				setState(152);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Functions_blockContext extends ParserRuleContext {
		public Functions_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_block; }
	 
		public Functions_blockContext() { }
		public void copyFrom(Functions_blockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncDeclBlockContext extends Functions_blockContext {
		public Function_declarationContext function_declaration() {
			return getRuleContext(Function_declarationContext.class,0);
		}
		public FuncDeclBlockContext(Functions_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFuncDeclBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFuncDeclBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFuncDeclBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProcDeclBlockContext extends Functions_blockContext {
		public Procedure_declarationContext procedure_declaration() {
			return getRuleContext(Procedure_declarationContext.class,0);
		}
		public ProcDeclBlockContext(Functions_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterProcDeclBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitProcDeclBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitProcDeclBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Functions_blockContext functions_block() throws RecognitionException {
		Functions_blockContext _localctx = new Functions_blockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_functions_block);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RATIO:
				_localctx = new FuncDeclBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				function_declaration();
				}
				break;
			case ACTIO:
				_localctx = new ProcDeclBlockContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				procedure_declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_declarationContext extends ParserRuleContext {
		public Function_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declaration; }
	 
		public Function_declarationContext() { }
		public void copyFrom(Function_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends Function_declarationContext {
		public TerminalNode RATIO() { return getToken(PigLatinParser.RATIO, 0); }
		public Variable_function_typeContext variable_function_type() {
			return getRuleContext(Variable_function_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public Function_argumentsContext function_arguments() {
			return getRuleContext(Function_argumentsContext.class,0);
		}
		public Function_bodyContext function_body() {
			return getRuleContext(Function_bodyContext.class,0);
		}
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public FunctionDeclarationContext(Function_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function_declaration);
		int _la;
		try {
			_localctx = new FunctionDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(RATIO);
			setState(158);
			variable_function_type();
			setState(159);
			match(ID);
			setState(160);
			match(INIT_PARENT);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTO || _la==SERIES) {
				{
				setState(161);
				function_arguments(0);
				}
			}

			setState(164);
			match(FINAL_PARENT);
			setState(165);
			match(INIT_BRACE);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABILES) {
				{
				setState(166);
				function_body();
				}
			}

			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
				{
				setState(169);
				code_body(0);
				}
			}

			setState(172);
			match(FINAL_BRACE);
			setState(173);
			match(FINIS);
			setState(174);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_function_typeContext extends ParserRuleContext {
		public Variable_function_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_function_type; }
	 
		public Variable_function_typeContext() { }
		public void copyFrom(Variable_function_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionReturNormalTypeContext extends Variable_function_typeContext {
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public FunctionReturNormalTypeContext(Variable_function_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionReturNormalType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionReturNormalType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionReturNormalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_function_typeContext variable_function_type() throws RecognitionException {
		Variable_function_typeContext _localctx = new Variable_function_typeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable_function_type);
		try {
			_localctx = new FunctionReturNormalTypeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			variable_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Procedure_declarationContext extends ParserRuleContext {
		public Procedure_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_declaration; }
	 
		public Procedure_declarationContext() { }
		public void copyFrom(Procedure_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureDeclarationContext extends Procedure_declarationContext {
		public TerminalNode ACTIO() { return getToken(PigLatinParser.ACTIO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public Function_argumentsContext function_arguments() {
			return getRuleContext(Function_argumentsContext.class,0);
		}
		public Procedure_bodyContext procedure_body() {
			return getRuleContext(Procedure_bodyContext.class,0);
		}
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public ProcedureDeclarationContext(Procedure_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterProcedureDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitProcedureDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitProcedureDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Procedure_declarationContext procedure_declaration() throws RecognitionException {
		Procedure_declarationContext _localctx = new Procedure_declarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_procedure_declaration);
		int _la;
		try {
			_localctx = new ProcedureDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(ACTIO);
			setState(179);
			match(ID);
			setState(180);
			match(INIT_PARENT);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTO || _la==SERIES) {
				{
				setState(181);
				function_arguments(0);
				}
			}

			setState(184);
			match(FINAL_PARENT);
			setState(185);
			match(INIT_BRACE);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABILES) {
				{
				setState(186);
				procedure_body();
				}
			}

			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
				{
				setState(189);
				code_body(0);
				}
			}

			setState(192);
			match(FINAL_BRACE);
			setState(193);
			match(FINIS);
			setState(194);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_bodyContext extends ParserRuleContext {
		public Function_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_body; }
	 
		public Function_bodyContext() { }
		public void copyFrom(Function_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionBodyContext extends Function_bodyContext {
		public TerminalNode VARIABILES() { return getToken(PigLatinParser.VARIABILES, 0); }
		public TerminalNode INIT_BRACKET() { return getToken(PigLatinParser.INIT_BRACKET, 0); }
		public TerminalNode FINAL_BRACKET() { return getToken(PigLatinParser.FINAL_BRACKET, 0); }
		public Local_variable_listContext local_variable_list() {
			return getRuleContext(Local_variable_listContext.class,0);
		}
		public FunctionBodyContext(Function_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_bodyContext function_body() throws RecognitionException {
		Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_body);
		int _la;
		try {
			_localctx = new FunctionBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(VARIABILES);
			setState(197);
			match(INIT_BRACKET);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTO || _la==SERIES) {
				{
				setState(198);
				local_variable_list(0);
				}
			}

			setState(201);
			match(FINAL_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Procedure_bodyContext extends ParserRuleContext {
		public Procedure_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure_body; }
	 
		public Procedure_bodyContext() { }
		public void copyFrom(Procedure_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ProcedureBodyContext extends Procedure_bodyContext {
		public TerminalNode VARIABILES() { return getToken(PigLatinParser.VARIABILES, 0); }
		public TerminalNode INIT_BRACKET() { return getToken(PigLatinParser.INIT_BRACKET, 0); }
		public TerminalNode FINAL_BRACKET() { return getToken(PigLatinParser.FINAL_BRACKET, 0); }
		public Local_variable_listContext local_variable_list() {
			return getRuleContext(Local_variable_listContext.class,0);
		}
		public ProcedureBodyContext(Procedure_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterProcedureBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitProcedureBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitProcedureBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Procedure_bodyContext procedure_body() throws RecognitionException {
		Procedure_bodyContext _localctx = new Procedure_bodyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_procedure_body);
		int _la;
		try {
			_localctx = new ProcedureBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(VARIABILES);
			setState(204);
			match(INIT_BRACKET);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ESTO || _la==SERIES) {
				{
				setState(205);
				local_variable_list(0);
				}
			}

			setState(208);
			match(FINAL_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Local_variable_listContext extends ParserRuleContext {
		public Local_variable_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_variable_list; }
	 
		public Local_variable_listContext() { }
		public void copyFrom(Local_variable_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariablesListContext extends Local_variable_listContext {
		public Local_variable_listContext local_variable_list() {
			return getRuleContext(Local_variable_listContext.class,0);
		}
		public Local_variableContext local_variable() {
			return getRuleContext(Local_variableContext.class,0);
		}
		public LocalVariablesListContext(Local_variable_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalVariablesList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalVariablesList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalVariablesList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalSingleVariableContext extends Local_variable_listContext {
		public Local_variableContext local_variable() {
			return getRuleContext(Local_variableContext.class,0);
		}
		public LocalSingleVariableContext(Local_variable_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalSingleVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalSingleVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalSingleVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_variable_listContext local_variable_list() throws RecognitionException {
		return local_variable_list(0);
	}

	private Local_variable_listContext local_variable_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Local_variable_listContext _localctx = new Local_variable_listContext(_ctx, _parentState);
		Local_variable_listContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_local_variable_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LocalSingleVariableContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(211);
			local_variable();
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LocalVariablesListContext(new Local_variable_listContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_local_variable_list);
					setState(213);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(214);
					local_variable();
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Local_variableContext extends ParserRuleContext {
		public Local_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_variable; }
	 
		public Local_variableContext() { }
		public void copyFrom(Local_variableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalArrayDeclarationContext extends Local_variableContext {
		public Normal_array_declarationContext normal_array_declaration() {
			return getRuleContext(Normal_array_declarationContext.class,0);
		}
		public LocalArrayDeclarationContext(Local_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalStructInstanceContext extends Local_variableContext {
		public Struct_instanceContext struct_instance() {
			return getRuleContext(Struct_instanceContext.class,0);
		}
		public LocalStructInstanceContext(Local_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalStructInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalStructInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalStructInstance(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalVarDeclarationContext extends Local_variableContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public LocalVarDeclarationContext(Local_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Local_variableContext local_variable() throws RecognitionException {
		Local_variableContext _localctx = new Local_variableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_local_variable);
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new LocalVarDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				variable_declaration();
				}
				break;
			case 2:
				_localctx = new LocalArrayDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				normal_array_declaration();
				}
				break;
			case 3:
				_localctx = new LocalStructInstanceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(222);
				struct_instance();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_argumentsContext extends ParserRuleContext {
		public Function_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_arguments; }
	 
		public Function_argumentsContext() { }
		public void copyFrom(Function_argumentsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionSingleArgContext extends Function_argumentsContext {
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public FunctionSingleArgContext(Function_argumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionSingleArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionSingleArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionSingleArg(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionArgsListContext extends Function_argumentsContext {
		public Function_argumentsContext function_arguments() {
			return getRuleContext(Function_argumentsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PigLatinParser.COMMA, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public FunctionArgsListContext(Function_argumentsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionArgsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionArgsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionArgsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_argumentsContext function_arguments() throws RecognitionException {
		return function_arguments(0);
	}

	private Function_argumentsContext function_arguments(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Function_argumentsContext _localctx = new Function_argumentsContext(_ctx, _parentState);
		Function_argumentsContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_function_arguments, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new FunctionSingleArgContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(226);
			argument();
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FunctionArgsListContext(new Function_argumentsContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_function_arguments);
					setState(228);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(229);
					match(COMMA);
					setState(230);
					argument();
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
	 
		public ArgumentContext() { }
		public void copyFrom(ArgumentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentVariableDeclarationContext extends ArgumentContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public Argument_variable_typeContext argument_variable_type() {
			return getRuleContext(Argument_variable_typeContext.class,0);
		}
		public ArgumentVariableDeclarationContext(ArgumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentArrayDeclarationnContext extends ArgumentContext {
		public TerminalNode SERIES() { return getToken(PigLatinParser.SERIES, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public Argument_series_typeContext argument_series_type() {
			return getRuleContext(Argument_series_typeContext.class,0);
		}
		public ArgumentArrayDeclarationnContext(ArgumentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentArrayDeclarationn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentArrayDeclarationn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentArrayDeclarationn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_argument);
		try {
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
				_localctx = new ArgumentVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(ESTO);
				setState(237);
				match(ID);
				setState(238);
				match(TWO_POINTS);
				setState(239);
				argument_variable_type();
				}
				break;
			case SERIES:
				_localctx = new ArgumentArrayDeclarationnContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(SERIES);
				setState(241);
				match(ID);
				setState(242);
				match(TWO_POINTS);
				setState(243);
				argument_series_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_variable_typeContext extends ParserRuleContext {
		public Argument_variable_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_variable_type; }
	 
		public Argument_variable_typeContext() { }
		public void copyFrom(Argument_variable_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentNormalDeclarationContext extends Argument_variable_typeContext {
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public ArgumentNormalDeclarationContext(Argument_variable_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentNormalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentNormalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentNormalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_variable_typeContext argument_variable_type() throws RecognitionException {
		Argument_variable_typeContext _localctx = new Argument_variable_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argument_variable_type);
		try {
			_localctx = new ArgumentNormalDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			variable_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Argument_series_typeContext extends ParserRuleContext {
		public Argument_series_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_series_type; }
	 
		public Argument_series_typeContext() { }
		public void copyFrom(Argument_series_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentArrayNormalDeclarationContext extends Argument_series_typeContext {
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public ArgumentArrayNormalDeclarationContext(Argument_series_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentArrayNormalDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentArrayNormalDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentArrayNormalDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_series_typeContext argument_series_type() throws RecognitionException {
		Argument_series_typeContext _localctx = new Argument_series_typeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_argument_series_type);
		try {
			_localctx = new ArgumentArrayNormalDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			variable_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Maior_sectionContext extends ParserRuleContext {
		public Maior_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maior_section; }
	 
		public Maior_sectionContext() { }
		public void copyFrom(Maior_sectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MaiorSectionContext extends Maior_sectionContext {
		public TerminalNode MAIOR() { return getToken(PigLatinParser.MAIOR, 0); }
		public TerminalNode GREATER() { return getToken(PigLatinParser.GREATER, 0); }
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public MaiorSectionContext(Maior_sectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterMaiorSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitMaiorSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitMaiorSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Maior_sectionContext maior_section() throws RecognitionException {
		Maior_sectionContext _localctx = new Maior_sectionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_maior_section);
		try {
			_localctx = new MaiorSectionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(MAIOR);
			setState(251);
			match(GREATER);
			setState(252);
			code_body(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Code_bodyContext extends ParserRuleContext {
		public Code_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code_body; }
	 
		public Code_bodyContext() { }
		public void copyFrom(Code_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockControlListContext extends Code_bodyContext {
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public Control_blockContext control_block() {
			return getRuleContext(Control_blockContext.class,0);
		}
		public BlockControlListContext(Code_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBlockControlList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBlockControlList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBlockControlList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockSingleControlContext extends Code_bodyContext {
		public Control_blockContext control_block() {
			return getRuleContext(Control_blockContext.class,0);
		}
		public BlockSingleControlContext(Code_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBlockSingleControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBlockSingleControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBlockSingleControl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Code_bodyContext code_body() throws RecognitionException {
		return code_body(0);
	}

	private Code_bodyContext code_body(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Code_bodyContext _localctx = new Code_bodyContext(_ctx, _parentState);
		Code_bodyContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_code_body, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new BlockSingleControlContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(255);
			control_block();
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BlockControlListContext(new Code_bodyContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_code_body);
					setState(257);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(258);
					control_block();
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Control_blockContext extends ParserRuleContext {
		public Control_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control_block; }
	 
		public Control_blockContext() { }
		public void copyFrom(Control_blockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockCodeContext extends Control_blockContext {
		public Block_codeContext block_code() {
			return getRuleContext(Block_codeContext.class,0);
		}
		public BlockCodeContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBlockCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBlockCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBlockCode(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalArrayRedefinedUssageContext extends Control_blockContext {
		public Array_redefined_ussageContext array_redefined_ussage() {
			return getRuleContext(Array_redefined_ussageContext.class,0);
		}
		public LocalArrayRedefinedUssageContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalArrayRedefinedUssage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalArrayRedefinedUssage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalArrayRedefinedUssage(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalNestedVariableUsageContext extends Control_blockContext {
		public Nested_variables_usageContext nested_variables_usage() {
			return getRuleContext(Nested_variables_usageContext.class,0);
		}
		public LocalNestedVariableUsageContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalNestedVariableUsage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalNestedVariableUsage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalNestedVariableUsage(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConsoleActionsContext extends Control_blockContext {
		public Console_actionsContext console_actions() {
			return getRuleContext(Console_actionsContext.class,0);
		}
		public ConsoleActionsContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterConsoleActions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitConsoleActions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitConsoleActions(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnControlActionContext extends Control_blockContext {
		public Return_controlContext return_control() {
			return getRuleContext(Return_controlContext.class,0);
		}
		public ReturnControlActionContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterReturnControlAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitReturnControlAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitReturnControlAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopControlActionContext extends Control_blockContext {
		public Loop_controlContext loop_control() {
			return getRuleContext(Loop_controlContext.class,0);
		}
		public LoopControlActionContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLoopControlAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLoopControlAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLoopControlAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionSingleCallContext extends Control_blockContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public FunctionSingleCallContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionSingleCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionSingleCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionSingleCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableRedefinitionContext extends Control_blockContext {
		public Variable_ussageContext variable_ussage() {
			return getRuleContext(Variable_ussageContext.class,0);
		}
		public LocalVariableRedefinitionContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalVariableRedefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalVariableRedefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalVariableRedefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalAbbreviatedOperationContext extends Control_blockContext {
		public Abbreviated_operationContext abbreviated_operation() {
			return getRuleContext(Abbreviated_operationContext.class,0);
		}
		public LocalAbbreviatedOperationContext(Control_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalAbbreviatedOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalAbbreviatedOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalAbbreviatedOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Control_blockContext control_block() throws RecognitionException {
		Control_blockContext _localctx = new Control_blockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_control_block);
		try {
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new BlockCodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				block_code();
				}
				break;
			case 2:
				_localctx = new ConsoleActionsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				console_actions();
				}
				break;
			case 3:
				_localctx = new FunctionSingleCallContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
				function_call();
				setState(267);
				match(DOT_COMMA);
				}
				break;
			case 4:
				_localctx = new LoopControlActionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(269);
				loop_control();
				}
				break;
			case 5:
				_localctx = new ReturnControlActionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(270);
				return_control();
				}
				break;
			case 6:
				_localctx = new LocalAbbreviatedOperationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(271);
				abbreviated_operation();
				}
				break;
			case 7:
				_localctx = new LocalVariableRedefinitionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(272);
				variable_ussage();
				}
				break;
			case 8:
				_localctx = new LocalArrayRedefinedUssageContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(273);
				array_redefined_ussage();
				}
				break;
			case 9:
				_localctx = new LocalNestedVariableUsageContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(274);
				nested_variables_usage();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_controlContext extends ParserRuleContext {
		public Return_controlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_control; }
	 
		public Return_controlContext() { }
		public void copyFrom(Return_controlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnVoidContext extends Return_controlContext {
		public TerminalNode REDDERE() { return getToken(PigLatinParser.REDDERE, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public ReturnVoidContext(Return_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterReturnVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitReturnVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitReturnVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnWithValueContext extends Return_controlContext {
		public TerminalNode REDDERE() { return getToken(PigLatinParser.REDDERE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public ReturnWithValueContext(Return_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterReturnWithValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitReturnWithValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitReturnWithValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_controlContext return_control() throws RecognitionException {
		Return_controlContext _localctx = new Return_controlContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_return_control);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ReturnWithValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				match(REDDERE);
				setState(278);
				expression(0);
				setState(279);
				match(DOT_COMMA);
				}
				break;
			case 2:
				_localctx = new ReturnVoidContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				match(REDDERE);
				setState(282);
				match(DOT_COMMA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Loop_controlContext extends ParserRuleContext {
		public Loop_controlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_control; }
	 
		public Loop_controlContext() { }
		public void copyFrom(Loop_controlContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopContinueContext extends Loop_controlContext {
		public TerminalNode PERGE() { return getToken(PigLatinParser.PERGE, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public LoopContinueContext(Loop_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLoopContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLoopContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLoopContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopBreakContext extends Loop_controlContext {
		public TerminalNode INTERRUMPE() { return getToken(PigLatinParser.INTERRUMPE, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public LoopBreakContext(Loop_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLoopBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLoopBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLoopBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_controlContext loop_control() throws RecognitionException {
		Loop_controlContext _localctx = new Loop_controlContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_loop_control);
		try {
			setState(289);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERGE:
				_localctx = new LoopContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				match(PERGE);
				setState(286);
				match(DOT_COMMA);
				}
				break;
			case INTERRUMPE:
				_localctx = new LoopBreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(INTERRUMPE);
				setState(288);
				match(DOT_COMMA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Console_actionsContext extends ParserRuleContext {
		public Console_actionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_console_actions; }
	 
		public Console_actionsContext() { }
		public void copyFrom(Console_actionsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadVariableInputContext extends Console_actionsContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode READ() { return getToken(PigLatinParser.READ, 0); }
		public ReadVariableInputContext(Console_actionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterReadVariableInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitReadVariableInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitReadVariableInput(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintActionContext extends Console_actionsContext {
		public TerminalNode PRINT() { return getToken(PigLatinParser.PRINT, 0); }
		public Print_functionContext print_function() {
			return getRuleContext(Print_functionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public PrintActionContext(Console_actionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPrintAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPrintAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPrintAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadInputContext extends Console_actionsContext {
		public TerminalNode READ() { return getToken(PigLatinParser.READ, 0); }
		public ReadInputContext(Console_actionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterReadInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitReadInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitReadInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Console_actionsContext console_actions() throws RecognitionException {
		Console_actionsContext _localctx = new Console_actionsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_console_actions);
		try {
			setState(299);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new ReadVariableInputContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				nest_variable();
				setState(292);
				match(READ);
				}
				break;
			case READ:
				_localctx = new ReadInputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				match(READ);
				}
				break;
			case PRINT:
				_localctx = new PrintActionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				match(PRINT);
				setState(296);
				print_function(0);
				setState(297);
				match(DOT_COMMA);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Print_functionContext extends ParserRuleContext {
		public Print_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_function; }
	 
		public Print_functionContext() { }
		public void copyFrom(Print_functionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintSingleExprContext extends Print_functionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintSingleExprContext(Print_functionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPrintSingleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPrintSingleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPrintSingleExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintMultipleExprContext extends Print_functionContext {
		public Print_functionContext print_function() {
			return getRuleContext(Print_functionContext.class,0);
		}
		public TerminalNode PRINT() { return getToken(PigLatinParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintMultipleExprContext(Print_functionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterPrintMultipleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitPrintMultipleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitPrintMultipleExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Print_functionContext print_function() throws RecognitionException {
		return print_function(0);
	}

	private Print_functionContext print_function(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Print_functionContext _localctx = new Print_functionContext(_ctx, _parentState);
		Print_functionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_print_function, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrintSingleExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(302);
			expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrintMultipleExprContext(new Print_functionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_print_function);
					setState(304);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(305);
					match(PRINT);
					setState(306);
					expression(0);
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_codeContext extends ParserRuleContext {
		public Block_codeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_code; }
	 
		public Block_codeContext() { }
		public void copyFrom(Block_codeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CodeBlockDoWhileContext extends Block_codeContext {
		public Do_while_statementContext do_while_statement() {
			return getRuleContext(Do_while_statementContext.class,0);
		}
		public CodeBlockDoWhileContext(Block_codeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCodeBlockDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCodeBlockDoWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCodeBlockDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CodeBlockWhileContext extends Block_codeContext {
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public CodeBlockWhileContext(Block_codeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCodeBlockWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCodeBlockWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCodeBlockWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CodeBlockIfContext extends Block_codeContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public CodeBlockIfContext(Block_codeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCodeBlockIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCodeBlockIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCodeBlockIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CodeBlockForContext extends Block_codeContext {
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public CodeBlockForContext(Block_codeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCodeBlockFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCodeBlockFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCodeBlockFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_codeContext block_code() throws RecognitionException {
		Block_codeContext _localctx = new Block_codeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_block_code);
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SI:
				_localctx = new CodeBlockIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				if_statement();
				}
				break;
			case DUM:
				_localctx = new CodeBlockWhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				while_statement();
				}
				break;
			case FACERE:
				_localctx = new CodeBlockDoWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(314);
				do_while_statement();
				}
				break;
			case PER:
				_localctx = new CodeBlockForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				for_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class If_statementContext extends ParserRuleContext {
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
	 
		public If_statementContext() { }
		public void copyFrom(If_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends If_statementContext {
		public TerminalNode SI() { return getToken(PigLatinParser.SI, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public Else_if_listContext else_if_list() {
			return getRuleContext(Else_if_listContext.class,0);
		}
		public IfStatementContext(If_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_if_statement);
		int _la;
		try {
			_localctx = new IfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(SI);
			setState(319);
			match(INIT_PARENT);
			setState(320);
			expression(0);
			setState(321);
			match(FINAL_PARENT);
			setState(322);
			match(INIT_BRACE);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
				{
				setState(323);
				code_body(0);
				}
			}

			setState(326);
			match(FINAL_BRACE);
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(327);
				else_if_list(0);
				}
				break;
			}
			setState(330);
			else_statement();
			setState(331);
			match(FINIS);
			setState(332);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_if_listContext extends ParserRuleContext {
		public Else_if_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_if_list; }
	 
		public Else_if_listContext() { }
		public void copyFrom(Else_if_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfSingleContext extends Else_if_listContext {
		public Else_if_clauseContext else_if_clause() {
			return getRuleContext(Else_if_clauseContext.class,0);
		}
		public ElseIfSingleContext(Else_if_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterElseIfSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitElseIfSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitElseIfSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfListContext extends Else_if_listContext {
		public Else_if_listContext else_if_list() {
			return getRuleContext(Else_if_listContext.class,0);
		}
		public Else_if_clauseContext else_if_clause() {
			return getRuleContext(Else_if_clauseContext.class,0);
		}
		public ElseIfListContext(Else_if_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterElseIfList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitElseIfList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitElseIfList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_listContext else_if_list() throws RecognitionException {
		return else_if_list(0);
	}

	private Else_if_listContext else_if_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Else_if_listContext _localctx = new Else_if_listContext(_ctx, _parentState);
		Else_if_listContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_else_if_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ElseIfSingleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(335);
			else_if_clause();
			}
			_ctx.stop = _input.LT(-1);
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ElseIfListContext(new Else_if_listContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_else_if_list);
					setState(337);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(338);
					else_if_clause();
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_if_clauseContext extends ParserRuleContext {
		public Else_if_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_if_clause; }
	 
		public Else_if_clauseContext() { }
		public void copyFrom(Else_if_clauseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfClauseContext extends Else_if_clauseContext {
		public TerminalNode ALITER() { return getToken(PigLatinParser.ALITER, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public ElseIfClauseContext(Else_if_clauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterElseIfClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitElseIfClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitElseIfClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_clauseContext else_if_clause() throws RecognitionException {
		Else_if_clauseContext _localctx = new Else_if_clauseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_else_if_clause);
		int _la;
		try {
			_localctx = new ElseIfClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(ALITER);
			setState(345);
			match(INIT_PARENT);
			setState(346);
			expression(0);
			setState(347);
			match(FINAL_PARENT);
			setState(348);
			match(INIT_BRACE);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
				{
				setState(349);
				code_body(0);
				}
			}

			setState(352);
			match(FINAL_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Else_statementContext extends ParserRuleContext {
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
	 
		public Else_statementContext() { }
		public void copyFrom(Else_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseEmptyContext extends Else_statementContext {
		public ElseEmptyContext(Else_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterElseEmpty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitElseEmpty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitElseEmpty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseBlockContext extends Else_statementContext {
		public TerminalNode ALITER() { return getToken(PigLatinParser.ALITER, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public ElseBlockContext(Else_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_else_statement);
		int _la;
		try {
			setState(361);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALITER:
				_localctx = new ElseBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(ALITER);
				setState(355);
				match(INIT_BRACE);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
					{
					setState(356);
					code_body(0);
					}
				}

				setState(359);
				match(FINAL_BRACE);
				}
				break;
			case FINIS:
				_localctx = new ElseEmptyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class While_statementContext extends ParserRuleContext {
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
	 
		public While_statementContext() { }
		public void copyFrom(While_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends While_statementContext {
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public WhileStatementContext(While_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_while_statement);
		int _la;
		try {
			_localctx = new WhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
			match(DUM);
			setState(364);
			match(INIT_PARENT);
			setState(365);
			expression(0);
			setState(366);
			match(FINAL_PARENT);
			setState(367);
			match(INIT_BRACE);
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
				{
				setState(368);
				code_body(0);
				}
			}

			setState(371);
			match(FINAL_BRACE);
			setState(372);
			match(FINIS);
			setState(373);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Do_while_statementContext extends ParserRuleContext {
		public Do_while_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_do_while_statement; }
	 
		public Do_while_statementContext() { }
		public void copyFrom(Do_while_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStatementContext extends Do_while_statementContext {
		public TerminalNode FACERE() { return getToken(PigLatinParser.FACERE, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public DoWhileStatementContext(Do_while_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_while_statementContext do_while_statement() throws RecognitionException {
		Do_while_statementContext _localctx = new Do_while_statementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_do_while_statement);
		int _la;
		try {
			_localctx = new DoWhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(FACERE);
			setState(376);
			match(INIT_BRACE);
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
				{
				setState(377);
				code_body(0);
				}
			}

			setState(380);
			match(FINAL_BRACE);
			setState(381);
			match(DUM);
			setState(382);
			match(INIT_PARENT);
			setState(383);
			expression(0);
			setState(384);
			match(FINAL_PARENT);
			setState(385);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_statementContext extends ParserRuleContext {
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
	 
		public For_statementContext() { }
		public void copyFrom(For_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends For_statementContext {
		public TerminalNode PER() { return getToken(PigLatinParser.PER, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public List<TerminalNode> DOT_COMMA() { return getTokens(PigLatinParser.DOT_COMMA); }
		public TerminalNode DOT_COMMA(int i) {
			return getToken(PigLatinParser.DOT_COMMA, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public For_updateContext for_update() {
			return getRuleContext(For_updateContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public ForStatementContext(For_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_for_statement);
		int _la;
		try {
			_localctx = new ForStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(PER);
			setState(388);
			match(INIT_PARENT);
			setState(389);
			for_init();
			setState(390);
			match(DOT_COMMA);
			setState(391);
			expression(0);
			setState(392);
			match(DOT_COMMA);
			setState(393);
			for_update();
			setState(394);
			match(FINAL_PARENT);
			setState(395);
			match(INIT_BRACE);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
				{
				setState(396);
				code_body(0);
				}
			}

			setState(399);
			match(FINAL_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_initContext extends ParserRuleContext {
		public For_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init; }
	 
		public For_initContext() { }
		public void copyFrom(For_initContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForInitAssignContext extends For_initContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(PigLatinParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitAssignContext(For_initContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterForInitAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitForInitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitForInitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForInitVarDeclContext extends For_initContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitVarDeclContext(For_initContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterForInitVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitForInitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitForInitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_for_init);
		try {
			setState(410);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
				_localctx = new ForInitVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				match(ESTO);
				setState(402);
				match(ID);
				setState(403);
				match(TWO_POINTS);
				setState(404);
				variable_type();
				setState(405);
				expression(0);
				}
				break;
			case ID:
				_localctx = new ForInitAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				match(ID);
				setState(408);
				match(EQUAL);
				setState(409);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_updateContext extends ParserRuleContext {
		public For_updateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_update; }
	 
		public For_updateContext() { }
		public void copyFrom(For_updateContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateDecrementContext extends For_updateContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode ABREV_MINUS() { return getToken(PigLatinParser.ABREV_MINUS, 0); }
		public ForUpdateDecrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterForUpdateDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitForUpdateDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitForUpdateDecrement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateAssignContext extends For_updateContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(PigLatinParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateAssignContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterForUpdateAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitForUpdateAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitForUpdateAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateIncrementContext extends For_updateContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode ABREV_PLUS() { return getToken(PigLatinParser.ABREV_PLUS, 0); }
		public ForUpdateIncrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterForUpdateIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitForUpdateIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitForUpdateIncrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_updateContext for_update() throws RecognitionException {
		For_updateContext _localctx = new For_updateContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_for_update);
		try {
			setState(419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new ForUpdateIncrementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(412);
				match(ID);
				setState(413);
				match(ABREV_PLUS);
				}
				break;
			case 2:
				_localctx = new ForUpdateDecrementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				match(ID);
				setState(415);
				match(ABREV_MINUS);
				}
				break;
			case 3:
				_localctx = new ForUpdateAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(416);
				match(ID);
				setState(417);
				match(EQUAL);
				setState(418);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_sectionContext extends ParserRuleContext {
		public Variable_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_section; }
	 
		public Variable_sectionContext() { }
		public void copyFrom(Variable_sectionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariablesSectionContext extends Variable_sectionContext {
		public TerminalNode VARIABILES() { return getToken(PigLatinParser.VARIABILES, 0); }
		public TerminalNode GREATER() { return getToken(PigLatinParser.GREATER, 0); }
		public Variabiles_bodyContext variabiles_body() {
			return getRuleContext(Variabiles_bodyContext.class,0);
		}
		public VariablesSectionContext(Variable_sectionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterVariablesSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitVariablesSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitVariablesSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_sectionContext variable_section() throws RecognitionException {
		Variable_sectionContext _localctx = new Variable_sectionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_variable_section);
		try {
			_localctx = new VariablesSectionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(VARIABILES);
			setState(422);
			match(GREATER);
			setState(423);
			variabiles_body(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variabiles_bodyContext extends ParserRuleContext {
		public Variabiles_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variabiles_body; }
	 
		public Variabiles_bodyContext() { }
		public void copyFrom(Variabiles_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsVariablesListContext extends Variabiles_bodyContext {
		public Variabiles_bodyContext variabiles_body() {
			return getRuleContext(Variabiles_bodyContext.class,0);
		}
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsVariablesListContext(Variabiles_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclarationsVariablesList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclarationsVariablesList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclarationsVariablesList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsSingleVariableContext extends Variabiles_bodyContext {
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public DeclarationsSingleVariableContext(Variabiles_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDeclarationsSingleVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDeclarationsSingleVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDeclarationsSingleVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variabiles_bodyContext variabiles_body() throws RecognitionException {
		return variabiles_body(0);
	}

	private Variabiles_bodyContext variabiles_body(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Variabiles_bodyContext _localctx = new Variabiles_bodyContext(_ctx, _parentState);
		Variabiles_bodyContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_variabiles_body, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new DeclarationsSingleVariableContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(426);
			declarations();
			}
			_ctx.stop = _input.LT(-1);
			setState(432);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DeclarationsVariablesListContext(new Variabiles_bodyContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_variabiles_body);
					setState(428);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(429);
					declarations();
					}
					} 
				}
				setState(434);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationsContext extends ParserRuleContext {
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
	 
		public DeclarationsContext() { }
		public void copyFrom(DeclarationsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GlobalNestedVariableUsageContext extends DeclarationsContext {
		public Nested_variables_usageContext nested_variables_usage() {
			return getRuleContext(Nested_variables_usageContext.class,0);
		}
		public GlobalNestedVariableUsageContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterGlobalNestedVariableUsage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitGlobalNestedVariableUsage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitGlobalNestedVariableUsage(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalArrayInstanceContext extends DeclarationsContext {
		public Normal_array_declarationContext normal_array_declaration() {
			return getRuleContext(Normal_array_declarationContext.class,0);
		}
		public NormalArrayInstanceContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNormalArrayInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNormalArrayInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNormalArrayInstance(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructDefinitionContext extends DeclarationsContext {
		public Struct_declarationContext struct_declaration() {
			return getRuleContext(Struct_declarationContext.class,0);
		}
		public StructDefinitionContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructDefinition(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableRedefinedUssageContext extends DeclarationsContext {
		public Variable_ussageContext variable_ussage() {
			return getRuleContext(Variable_ussageContext.class,0);
		}
		public VariableRedefinedUssageContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterVariableRedefinedUssage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitVariableRedefinedUssage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitVariableRedefinedUssage(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GlobalAbbreviatedOperationContext extends DeclarationsContext {
		public Abbreviated_operationContext abbreviated_operation() {
			return getRuleContext(Abbreviated_operationContext.class,0);
		}
		public GlobalAbbreviatedOperationContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterGlobalAbbreviatedOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitGlobalAbbreviatedOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitGlobalAbbreviatedOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayRedefinedUssageContext extends DeclarationsContext {
		public Array_redefined_ussageContext array_redefined_ussage() {
			return getRuleContext(Array_redefined_ussageContext.class,0);
		}
		public ArrayRedefinedUssageContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArrayRedefinedUssage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArrayRedefinedUssage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArrayRedefinedUssage(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableInstanceContext extends DeclarationsContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public VariableInstanceContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterVariableInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitVariableInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitVariableInstance(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructVariableInstanceContext extends DeclarationsContext {
		public Struct_instanceContext struct_instance() {
			return getRuleContext(Struct_instanceContext.class,0);
		}
		public StructVariableInstanceContext(DeclarationsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructVariableInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructVariableInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructVariableInstance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_declarations);
		try {
			setState(443);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new VariableInstanceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				variable_declaration();
				}
				break;
			case 2:
				_localctx = new VariableRedefinedUssageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				variable_ussage();
				}
				break;
			case 3:
				_localctx = new NormalArrayInstanceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(437);
				normal_array_declaration();
				}
				break;
			case 4:
				_localctx = new StructDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(438);
				struct_declaration();
				}
				break;
			case 5:
				_localctx = new ArrayRedefinedUssageContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(439);
				array_redefined_ussage();
				}
				break;
			case 6:
				_localctx = new StructVariableInstanceContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(440);
				struct_instance();
				}
				break;
			case 7:
				_localctx = new GlobalAbbreviatedOperationContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(441);
				abbreviated_operation();
				}
				break;
			case 8:
				_localctx = new GlobalNestedVariableUsageContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(442);
				nested_variables_usage();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_redefined_ussageContext extends ParserRuleContext {
		public Array_redefined_ussageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_redefined_ussage; }
	 
		public Array_redefined_ussageContext() { }
		public void copyFrom(Array_redefined_ussageContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RedefiniedArrayUssageContext extends Array_redefined_ussageContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_BRACKET() { return getToken(PigLatinParser.INIT_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(PigLatinParser.FINAL_BRACKET, 0); }
		public TerminalNode EQUAL() { return getToken(PigLatinParser.EQUAL, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public RedefiniedArrayUssageContext(Array_redefined_ussageContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterRedefiniedArrayUssage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitRedefiniedArrayUssage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitRedefiniedArrayUssage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_redefined_ussageContext array_redefined_ussage() throws RecognitionException {
		Array_redefined_ussageContext _localctx = new Array_redefined_ussageContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_array_redefined_ussage);
		try {
			_localctx = new RedefiniedArrayUssageContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(ID);
			setState(446);
			match(INIT_BRACKET);
			setState(447);
			expression(0);
			setState(448);
			match(FINAL_BRACKET);
			setState(449);
			match(EQUAL);
			setState(450);
			expression(0);
			setState(451);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_ussageContext extends ParserRuleContext {
		public Variable_ussageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_ussage; }
	 
		public Variable_ussageContext() { }
		public void copyFrom(Variable_ussageContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalVariableRedefiniedUsageContext extends Variable_ussageContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(PigLatinParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public NormalVariableRedefiniedUsageContext(Variable_ussageContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNormalVariableRedefiniedUsage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNormalVariableRedefiniedUsage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNormalVariableRedefiniedUsage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_ussageContext variable_ussage() throws RecognitionException {
		Variable_ussageContext _localctx = new Variable_ussageContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_variable_ussage);
		try {
			_localctx = new NormalVariableRedefiniedUsageContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			match(ID);
			setState(454);
			match(EQUAL);
			setState(455);
			expression(0);
			setState(456);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nested_variables_usageContext extends ParserRuleContext {
		public Nested_variables_usageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nested_variables_usage; }
	 
		public Nested_variables_usageContext() { }
		public void copyFrom(Nested_variables_usageContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedStructRedefiniedValueContext extends Nested_variables_usageContext {
		public Struct_valuesContext struct_values() {
			return getRuleContext(Struct_valuesContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PigLatinParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public NestedStructRedefiniedValueContext(Nested_variables_usageContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNestedStructRedefiniedValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNestedStructRedefiniedValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNestedStructRedefiniedValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nested_variables_usageContext nested_variables_usage() throws RecognitionException {
		Nested_variables_usageContext _localctx = new Nested_variables_usageContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_nested_variables_usage);
		try {
			_localctx = new NestedStructRedefiniedValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			struct_values(0);
			setState(459);
			match(EQUAL);
			setState(460);
			expression(0);
			setState(461);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_instanceContext extends ParserRuleContext {
		public Struct_instanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_instance; }
	 
		public Struct_instanceContext() { }
		public void copyFrom(Struct_instanceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructInstanceContext extends Struct_instanceContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public List<TerminalNode> ID() { return getTokens(PigLatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParser.ID, i);
		}
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public Struct_literalContext struct_literal() {
			return getRuleContext(Struct_literalContext.class,0);
		}
		public StructInstanceContext(Struct_instanceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructInstance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_instanceContext struct_instance() throws RecognitionException {
		Struct_instanceContext _localctx = new Struct_instanceContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_struct_instance);
		try {
			_localctx = new StructInstanceContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(ESTO);
			setState(464);
			match(ID);
			setState(465);
			match(TWO_POINTS);
			setState(466);
			match(ID);
			setState(467);
			struct_literal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_declarationContext extends ParserRuleContext {
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
	 
		public Variable_declarationContext() { }
		public void copyFrom(Variable_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends Variable_declarationContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public VariableDeclarationContext(Variable_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_variable_declaration);
		try {
			_localctx = new VariableDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(ESTO);
			setState(470);
			match(ID);
			setState(471);
			match(TWO_POINTS);
			setState(472);
			variable_type();
			setState(473);
			expression(0);
			setState(474);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Normal_array_declarationContext extends ParserRuleContext {
		public Normal_array_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_array_declaration; }
	 
		public Normal_array_declarationContext() { }
		public void copyFrom(Normal_array_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalArrayDeclarationContext extends Normal_array_declarationContext {
		public TerminalNode SERIES() { return getToken(PigLatinParser.SERIES, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_BRACKET() { return getToken(PigLatinParser.INIT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(PigLatinParser.FINAL_BRACKET, 0); }
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public Array_initializationContext array_initialization() {
			return getRuleContext(Array_initializationContext.class,0);
		}
		public NormalArrayDeclarationContext(Normal_array_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNormalArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNormalArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNormalArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_array_declarationContext normal_array_declaration() throws RecognitionException {
		Normal_array_declarationContext _localctx = new Normal_array_declarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_normal_array_declaration);
		int _la;
		try {
			_localctx = new NormalArrayDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			match(SERIES);
			setState(477);
			match(ID);
			setState(478);
			match(INIT_BRACKET);
			setState(479);
			expression(0);
			setState(480);
			match(FINAL_BRACKET);
			setState(481);
			match(TWO_POINTS);
			setState(482);
			variable_type();
			setState(484);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INIT_BRACE) {
				{
				setState(483);
				array_initialization();
				}
			}

			setState(486);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_initializationContext extends ParserRuleContext {
		public Array_initializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_initialization; }
	 
		public Array_initializationContext() { }
		public void copyFrom(Array_initializationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitWithValuesContext extends Array_initializationContext {
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public Values_array_listContext values_array_list() {
			return getRuleContext(Values_array_listContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public ArrayInitWithValuesContext(Array_initializationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArrayInitWithValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArrayInitWithValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArrayInitWithValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_initializationContext array_initialization() throws RecognitionException {
		Array_initializationContext _localctx = new Array_initializationContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_array_initialization);
		try {
			_localctx = new ArrayInitWithValuesContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(INIT_BRACE);
			setState(489);
			values_array_list(0);
			setState(490);
			match(FINAL_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Values_array_listContext extends ParserRuleContext {
		public Values_array_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values_array_list; }
	 
		public Values_array_listContext() { }
		public void copyFrom(Values_array_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArraySingleValueContext extends Values_array_listContext {
		public Array_valueContext array_value() {
			return getRuleContext(Array_valueContext.class,0);
		}
		public ArraySingleValueContext(Values_array_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArraySingleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArraySingleValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArraySingleValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValueListContext extends Values_array_listContext {
		public Values_array_listContext values_array_list() {
			return getRuleContext(Values_array_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PigLatinParser.COMMA, 0); }
		public Array_valueContext array_value() {
			return getRuleContext(Array_valueContext.class,0);
		}
		public ArrayValueListContext(Values_array_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArrayValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArrayValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArrayValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Values_array_listContext values_array_list() throws RecognitionException {
		return values_array_list(0);
	}

	private Values_array_listContext values_array_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Values_array_listContext _localctx = new Values_array_listContext(_ctx, _parentState);
		Values_array_listContext _prevctx = _localctx;
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_values_array_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArraySingleValueContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(493);
			array_value();
			}
			_ctx.stop = _input.LT(-1);
			setState(500);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayValueListContext(new Values_array_listContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_values_array_list);
					setState(495);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(496);
					match(COMMA);
					setState(497);
					array_value();
					}
					} 
				}
				setState(502);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_valueContext extends ParserRuleContext {
		public Array_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_value; }
	 
		public Array_valueContext() { }
		public void copyFrom(Array_valueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayNormalValueContext extends Array_valueContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayNormalValueContext(Array_valueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArrayNormalValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArrayNormalValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArrayNormalValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_valueContext array_value() throws RecognitionException {
		Array_valueContext _localctx = new Array_valueContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_array_value);
		try {
			_localctx = new ArrayNormalValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_valuesContext extends ParserRuleContext {
		public Struct_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_values; }
	 
		public Struct_valuesContext() { }
		public void copyFrom(Struct_valuesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructBasePropertyContext extends Struct_valuesContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParser.ID, i);
		}
		public TerminalNode DOT() { return getToken(PigLatinParser.DOT, 0); }
		public StructBasePropertyContext(Struct_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructBaseProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructBaseProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructBaseProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructArrayAccessChainContext extends Struct_valuesContext {
		public Struct_valuesContext struct_values() {
			return getRuleContext(Struct_valuesContext.class,0);
		}
		public TerminalNode INIT_BRACKET() { return getToken(PigLatinParser.INIT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(PigLatinParser.FINAL_BRACKET, 0); }
		public StructArrayAccessChainContext(Struct_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructArrayAccessChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructArrayAccessChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructArrayAccessChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructBaseArrayPropertyContext extends Struct_valuesContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParser.ID, i);
		}
		public TerminalNode INIT_BRACKET() { return getToken(PigLatinParser.INIT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(PigLatinParser.FINAL_BRACKET, 0); }
		public TerminalNode DOT() { return getToken(PigLatinParser.DOT, 0); }
		public StructBaseArrayPropertyContext(Struct_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructBaseArrayProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructBaseArrayProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructBaseArrayProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructPropertyChainContext extends Struct_valuesContext {
		public Struct_valuesContext struct_values() {
			return getRuleContext(Struct_valuesContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PigLatinParser.DOT, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public StructPropertyChainContext(Struct_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructPropertyChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructPropertyChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructPropertyChain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_valuesContext struct_values() throws RecognitionException {
		return struct_values(0);
	}

	private Struct_valuesContext struct_values(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Struct_valuesContext _localctx = new Struct_valuesContext(_ctx, _parentState);
		Struct_valuesContext _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_struct_values, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				_localctx = new StructBasePropertyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(506);
				match(ID);
				setState(507);
				match(DOT);
				setState(508);
				match(ID);
				}
				break;
			case 2:
				{
				_localctx = new StructBaseArrayPropertyContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(509);
				match(ID);
				setState(510);
				match(INIT_BRACKET);
				setState(511);
				expression(0);
				setState(512);
				match(FINAL_BRACKET);
				setState(513);
				match(DOT);
				setState(514);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(528);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(526);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new StructPropertyChainContext(new Struct_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_struct_values);
						setState(518);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(519);
						match(DOT);
						setState(520);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new StructArrayAccessChainContext(new Struct_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_struct_values);
						setState(521);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(522);
						match(INIT_BRACKET);
						setState(523);
						expression(0);
						setState(524);
						match(FINAL_BRACKET);
						}
						break;
					}
					} 
				}
				setState(530);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declarationContext extends ParserRuleContext {
		public Struct_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration; }
	 
		public Struct_declarationContext() { }
		public void copyFrom(Struct_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclarationContext extends Struct_declarationContext {
		public TerminalNode STRUCTURE() { return getToken(PigLatinParser.STRUCTURE, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public Struct_bodyContext struct_body() {
			return getRuleContext(Struct_bodyContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public StructDeclarationContext(Struct_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_struct_declaration);
		try {
			_localctx = new StructDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(STRUCTURE);
			setState(532);
			match(ID);
			setState(533);
			match(INIT_BRACE);
			setState(534);
			struct_body();
			setState(535);
			match(FINAL_BRACE);
			setState(536);
			match(FINIS);
			setState(537);
			match(DOT_COMMA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_bodyContext extends ParserRuleContext {
		public Struct_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_body; }
	 
		public Struct_bodyContext() { }
		public void copyFrom(Struct_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructSeparatedBodyContext extends Struct_bodyContext {
		public Struct_normal_bodyContext struct_normal_body() {
			return getRuleContext(Struct_normal_bodyContext.class,0);
		}
		public StructSeparatedBodyContext(Struct_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructSeparatedBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructSeparatedBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructSeparatedBody(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructCommaBodyContext extends Struct_bodyContext {
		public Struct_comma_bodyContext struct_comma_body() {
			return getRuleContext(Struct_comma_bodyContext.class,0);
		}
		public StructCommaBodyContext(Struct_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructCommaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructCommaBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructCommaBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_bodyContext struct_body() throws RecognitionException {
		Struct_bodyContext _localctx = new Struct_bodyContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_struct_body);
		try {
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new StructSeparatedBodyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(539);
				struct_normal_body(0);
				}
				break;
			case 2:
				_localctx = new StructCommaBodyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(540);
				struct_comma_body(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_normal_bodyContext extends ParserRuleContext {
		public Struct_normal_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_normal_body; }
	 
		public Struct_normal_bodyContext() { }
		public void copyFrom(Struct_normal_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructNormalBodyListContext extends Struct_normal_bodyContext {
		public Struct_normal_bodyContext struct_normal_body() {
			return getRuleContext(Struct_normal_bodyContext.class,0);
		}
		public Struct_attributeContext struct_attribute() {
			return getRuleContext(Struct_attributeContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public StructNormalBodyListContext(Struct_normal_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructNormalBodyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructNormalBodyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructNormalBodyList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructNormalBodySingleContext extends Struct_normal_bodyContext {
		public Struct_attributeContext struct_attribute() {
			return getRuleContext(Struct_attributeContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public StructNormalBodySingleContext(Struct_normal_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructNormalBodySingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructNormalBodySingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructNormalBodySingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_normal_bodyContext struct_normal_body() throws RecognitionException {
		return struct_normal_body(0);
	}

	private Struct_normal_bodyContext struct_normal_body(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Struct_normal_bodyContext _localctx = new Struct_normal_bodyContext(_ctx, _parentState);
		Struct_normal_bodyContext _prevctx = _localctx;
		int _startState = 94;
		enterRecursionRule(_localctx, 94, RULE_struct_normal_body, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new StructNormalBodySingleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(544);
			struct_attribute();
			setState(545);
			match(DOT_COMMA);
			}
			_ctx.stop = _input.LT(-1);
			setState(553);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StructNormalBodyListContext(new Struct_normal_bodyContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_struct_normal_body);
					setState(547);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(548);
					struct_attribute();
					setState(549);
					match(DOT_COMMA);
					}
					} 
				}
				setState(555);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_comma_bodyContext extends ParserRuleContext {
		public Struct_comma_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_comma_body; }
	 
		public Struct_comma_bodyContext() { }
		public void copyFrom(Struct_comma_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructCommaBodySingleContext extends Struct_comma_bodyContext {
		public Struct_attributeContext struct_attribute() {
			return getRuleContext(Struct_attributeContext.class,0);
		}
		public StructCommaBodySingleContext(Struct_comma_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructCommaBodySingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructCommaBodySingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructCommaBodySingle(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructCommaBodyListContext extends Struct_comma_bodyContext {
		public Struct_comma_bodyContext struct_comma_body() {
			return getRuleContext(Struct_comma_bodyContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PigLatinParser.COMMA, 0); }
		public Struct_attributeContext struct_attribute() {
			return getRuleContext(Struct_attributeContext.class,0);
		}
		public StructCommaBodyListContext(Struct_comma_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructCommaBodyList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructCommaBodyList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructCommaBodyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_comma_bodyContext struct_comma_body() throws RecognitionException {
		return struct_comma_body(0);
	}

	private Struct_comma_bodyContext struct_comma_body(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Struct_comma_bodyContext _localctx = new Struct_comma_bodyContext(_ctx, _parentState);
		Struct_comma_bodyContext _prevctx = _localctx;
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_struct_comma_body, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new StructCommaBodySingleContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(557);
			struct_attribute();
			}
			_ctx.stop = _input.LT(-1);
			setState(564);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StructCommaBodyListContext(new Struct_comma_bodyContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_struct_comma_body);
					setState(559);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(560);
					match(COMMA);
					setState(561);
					struct_attribute();
					}
					} 
				}
				setState(566);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_attributeContext extends ParserRuleContext {
		public Struct_attributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_attribute; }
	 
		public Struct_attributeContext() { }
		public void copyFrom(Struct_attributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayVariableStructContext extends Struct_attributeContext {
		public Array_variable_structContext array_variable_struct() {
			return getRuleContext(Array_variable_structContext.class,0);
		}
		public ArrayVariableStructContext(Struct_attributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArrayVariableStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArrayVariableStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArrayVariableStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalVariableStructContext extends Struct_attributeContext {
		public Variable_without_valueContext variable_without_value() {
			return getRuleContext(Variable_without_valueContext.class,0);
		}
		public NormalVariableStructContext(Struct_attributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNormalVariableStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNormalVariableStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNormalVariableStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_attributeContext struct_attribute() throws RecognitionException {
		Struct_attributeContext _localctx = new Struct_attributeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_struct_attribute);
		try {
			setState(569);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
				_localctx = new NormalVariableStructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(567);
				variable_without_value();
				}
				break;
			case SERIES:
				_localctx = new ArrayVariableStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(568);
				array_variable_struct();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_without_valueContext extends ParserRuleContext {
		public Variable_without_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_without_value; }
	 
		public Variable_without_valueContext() { }
		public void copyFrom(Variable_without_valueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InternalStructNormalVariableContext extends Variable_without_valueContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public InternalStructNormalVariableContext(Variable_without_valueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterInternalStructNormalVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitInternalStructNormalVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitInternalStructNormalVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_without_valueContext variable_without_value() throws RecognitionException {
		Variable_without_valueContext _localctx = new Variable_without_valueContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_variable_without_value);
		try {
			_localctx = new InternalStructNormalVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			match(ESTO);
			setState(572);
			match(ID);
			setState(573);
			match(TWO_POINTS);
			setState(574);
			variable_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_variable_structContext extends ParserRuleContext {
		public Array_variable_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_variable_struct; }
	 
		public Array_variable_structContext() { }
		public void copyFrom(Array_variable_structContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InternalStructArrayContext extends Array_variable_structContext {
		public TerminalNode SERIES() { return getToken(PigLatinParser.SERIES, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
		public InternalStructArrayContext(Array_variable_structContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterInternalStructArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitInternalStructArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitInternalStructArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_variable_structContext array_variable_struct() throws RecognitionException {
		Array_variable_structContext _localctx = new Array_variable_structContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_array_variable_struct);
		try {
			_localctx = new InternalStructArrayContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			match(SERIES);
			setState(577);
			match(ID);
			setState(578);
			match(TWO_POINTS);
			setState(579);
			variable_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_literalContext extends ParserRuleContext {
		public Struct_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_literal; }
	 
		public Struct_literalContext() { }
		public void copyFrom(Struct_literalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructLiteralValueContext extends Struct_literalContext {
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public Struct_data_listContext struct_data_list() {
			return getRuleContext(Struct_data_listContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public StructLiteralValueContext(Struct_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_literalContext struct_literal() throws RecognitionException {
		Struct_literalContext _localctx = new Struct_literalContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_struct_literal);
		try {
			_localctx = new StructLiteralValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			match(INIT_BRACE);
			setState(582);
			struct_data_list(0);
			setState(583);
			match(FINAL_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_data_listContext extends ParserRuleContext {
		public Struct_data_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_data_list; }
	 
		public Struct_data_listContext() { }
		public void copyFrom(Struct_data_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructValueListContext extends Struct_data_listContext {
		public Struct_data_listContext struct_data_list() {
			return getRuleContext(Struct_data_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PigLatinParser.COMMA, 0); }
		public Struct_data_valueContext struct_data_value() {
			return getRuleContext(Struct_data_valueContext.class,0);
		}
		public StructValueListContext(Struct_data_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructValueList(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructSingleValueContext extends Struct_data_listContext {
		public Struct_data_valueContext struct_data_value() {
			return getRuleContext(Struct_data_valueContext.class,0);
		}
		public StructSingleValueContext(Struct_data_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructSingleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructSingleValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructSingleValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_data_listContext struct_data_list() throws RecognitionException {
		return struct_data_list(0);
	}

	private Struct_data_listContext struct_data_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Struct_data_listContext _localctx = new Struct_data_listContext(_ctx, _parentState);
		Struct_data_listContext _prevctx = _localctx;
		int _startState = 106;
		enterRecursionRule(_localctx, 106, RULE_struct_data_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new StructSingleValueContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(586);
			struct_data_value();
			}
			_ctx.stop = _input.LT(-1);
			setState(593);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StructValueListContext(new Struct_data_listContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_struct_data_list);
					setState(588);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(589);
					match(COMMA);
					setState(590);
					struct_data_value();
					}
					} 
				}
				setState(595);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_data_valueContext extends ParserRuleContext {
		public Struct_data_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_data_value; }
	 
		public Struct_data_valueContext() { }
		public void copyFrom(Struct_data_valueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructDataNormalContext extends Struct_data_valueContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode TWO_POINTS() { return getToken(PigLatinParser.TWO_POINTS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StructDataNormalContext(Struct_data_valueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructDataNormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructDataNormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructDataNormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_data_valueContext struct_data_value() throws RecognitionException {
		Struct_data_valueContext _localctx = new Struct_data_valueContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_struct_data_value);
		try {
			_localctx = new StructDataNormalContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			match(ID);
			setState(597);
			match(TWO_POINTS);
			setState(598);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionParentsContext extends ExpressionContext {
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public ExpressionParentsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionParents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionParents(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionParents(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionUnaryContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PigLatinParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(PigLatinParser.MINUS, 0); }
		public ExpressionUnaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionUnary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionEqualityContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(PigLatinParser.EQUALS, 0); }
		public TerminalNode DIFERENCE() { return getToken(PigLatinParser.DIFERENCE, 0); }
		public ExpressionEqualityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionEquality(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionRelationalContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LESS() { return getToken(PigLatinParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(PigLatinParser.GREATER, 0); }
		public TerminalNode LESS_EQUALS() { return getToken(PigLatinParser.LESS_EQUALS, 0); }
		public TerminalNode GREATER_EQUALS() { return getToken(PigLatinParser.GREATER_EQUALS, 0); }
		public ExpressionRelationalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionRelational(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionValueContext extends ExpressionContext {
		public Normal_valuesContext normal_values() {
			return getRuleContext(Normal_valuesContext.class,0);
		}
		public ExpressionValueContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionAndContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PigLatinParser.AND, 0); }
		public ExpressionAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionOrContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(PigLatinParser.OR, 0); }
		public ExpressionOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionMultDivContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULTIPLICATION() { return getToken(PigLatinParser.MULTIPLICATION, 0); }
		public TerminalNode DIVIDE() { return getToken(PigLatinParser.DIVIDE, 0); }
		public ExpressionMultDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionAddSubContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(PigLatinParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PigLatinParser.MINUS, 0); }
		public ExpressionAddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterExpressionAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitExpressionAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitExpressionAddSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 110;
		enterRecursionRule(_localctx, 110, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INIT_PARENT:
				{
				_localctx = new ExpressionParentsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(601);
				match(INIT_PARENT);
				setState(602);
				expression(0);
				setState(603);
				match(FINAL_PARENT);
				}
				break;
			case MINUS:
			case NOT:
				{
				_localctx = new ExpressionUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(605);
				((ExpressionUnaryContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MINUS || _la==NOT) ) {
					((ExpressionUnaryContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(606);
				expression(8);
				}
				break;
			case VERUM:
			case FALSUS:
			case INIT_BRACE:
			case ID:
			case INT:
			case DECIMAL:
			case STRING:
			case CHAR:
				{
				_localctx = new ExpressionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(607);
				normal_values();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(630);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(628);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMultDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(610);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(611);
						((ExpressionMultDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MULTIPLICATION || _la==DIVIDE) ) {
							((ExpressionMultDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(612);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(613);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(614);
						((ExpressionAddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpressionAddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(615);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionRelationalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(616);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(617);
						((ExpressionRelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1945555039024054272L) != 0)) ) {
							((ExpressionRelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(618);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionEqualityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(619);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(620);
						((ExpressionEqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==DIFERENCE) ) {
							((ExpressionEqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(621);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(622);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(623);
						match(AND);
						setState(624);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(625);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(626);
						match(OR);
						setState(627);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(632);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Variable_typeContext extends ParserRuleContext {
		public Variable_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_type; }
	 
		public Variable_typeContext() { }
		public void copyFrom(Variable_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeCharContext extends Variable_typeContext {
		public TerminalNode LITTERA() { return getToken(PigLatinParser.LITTERA, 0); }
		public TypeCharContext(Variable_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTypeChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTypeChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTypeChar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeBooleanContext extends Variable_typeContext {
		public TerminalNode BOOLEAN() { return getToken(PigLatinParser.BOOLEAN, 0); }
		public TypeBooleanContext(Variable_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTypeBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTypeBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTypeBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeDecimalContext extends Variable_typeContext {
		public TerminalNode DECIMALIS() { return getToken(PigLatinParser.DECIMALIS, 0); }
		public TypeDecimalContext(Variable_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTypeDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTypeDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTypeDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeCustomIdContext extends Variable_typeContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TypeCustomIdContext(Variable_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTypeCustomId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTypeCustomId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTypeCustomId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeIntContext extends Variable_typeContext {
		public TerminalNode NUMERUS() { return getToken(PigLatinParser.NUMERUS, 0); }
		public TypeIntContext(Variable_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTypeInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeTextContext extends Variable_typeContext {
		public TerminalNode TEXTUM() { return getToken(PigLatinParser.TEXTUM, 0); }
		public TypeTextContext(Variable_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterTypeText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitTypeText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitTypeText(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_typeContext variable_type() throws RecognitionException {
		Variable_typeContext _localctx = new Variable_typeContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_variable_type);
		try {
			setState(639);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTUM:
				_localctx = new TypeTextContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(633);
				match(TEXTUM);
				}
				break;
			case NUMERUS:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(634);
				match(NUMERUS);
				}
				break;
			case DECIMALIS:
				_localctx = new TypeDecimalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(635);
				match(DECIMALIS);
				}
				break;
			case LITTERA:
				_localctx = new TypeCharContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(636);
				match(LITTERA);
				}
				break;
			case BOOLEAN:
				_localctx = new TypeBooleanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(637);
				match(BOOLEAN);
				}
				break;
			case ID:
				_localctx = new TypeCustomIdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(638);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array_callContext extends ParserRuleContext {
		public Array_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_call; }
	 
		public Array_callContext() { }
		public void copyFrom(Array_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayCallContext extends Array_callContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_BRACKET() { return getToken(PigLatinParser.INIT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(PigLatinParser.FINAL_BRACKET, 0); }
		public ArrayCallContext(Array_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArrayCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArrayCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArrayCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_callContext array_call() throws RecognitionException {
		Array_callContext _localctx = new Array_callContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_array_call);
		try {
			_localctx = new ArrayCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			match(ID);
			setState(642);
			match(INIT_BRACKET);
			setState(643);
			expression(0);
			setState(644);
			match(FINAL_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_callContext extends ParserRuleContext {
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
	 
		public Function_callContext() { }
		public void copyFrom(Function_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallingContext extends Function_callContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public FunctionCallingContext(Function_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterFunctionCalling(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitFunctionCalling(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitFunctionCalling(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_function_call);
		int _la;
		try {
			_localctx = new FunctionCallingContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(646);
			match(ID);
			setState(647);
			match(INIT_PARENT);
			setState(649);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 35465984647102467L) != 0)) {
				{
				setState(648);
				arguments_list(0);
				}
			}

			setState(651);
			match(FINAL_PARENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arguments_listContext extends ParserRuleContext {
		public Arguments_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments_list; }
	 
		public Arguments_listContext() { }
		public void copyFrom(Arguments_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentSingleFunctionContext extends Arguments_listContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentSingleFunctionContext(Arguments_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentSingleFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentSingleFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentSingleFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentFunctionListContext extends Arguments_listContext {
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PigLatinParser.COMMA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentFunctionListContext(Arguments_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentFunctionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentFunctionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentFunctionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arguments_listContext arguments_list() throws RecognitionException {
		return arguments_list(0);
	}

	private Arguments_listContext arguments_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arguments_listContext _localctx = new Arguments_listContext(_ctx, _parentState);
		Arguments_listContext _prevctx = _localctx;
		int _startState = 118;
		enterRecursionRule(_localctx, 118, RULE_arguments_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ArgumentSingleFunctionContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(654);
			expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(661);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentFunctionListContext(new Arguments_listContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_arguments_list);
					setState(656);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(657);
					match(COMMA);
					setState(658);
					expression(0);
					}
					} 
				}
				setState(663);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Nest_variableContext extends ParserRuleContext {
		public Nest_variableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nest_variable; }
	 
		public Nest_variableContext() { }
		public void copyFrom(Nest_variableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayCallVariableContext extends Nest_variableContext {
		public Array_callContext array_call() {
			return getRuleContext(Array_callContext.class,0);
		}
		public ArrayCallVariableContext(Nest_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArrayCallVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArrayCallVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArrayCallVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedValueVariableContext extends Nest_variableContext {
		public Struct_valuesContext struct_values() {
			return getRuleContext(Struct_valuesContext.class,0);
		}
		public NestedValueVariableContext(Nest_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNestedValueVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNestedValueVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNestedValueVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SigleValueVariableContext extends Nest_variableContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public SigleValueVariableContext(Nest_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterSigleValueVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitSigleValueVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitSigleValueVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nest_variableContext nest_variable() throws RecognitionException {
		Nest_variableContext _localctx = new Nest_variableContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_nest_variable);
		try {
			setState(667);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				_localctx = new NestedValueVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(664);
				struct_values(0);
				}
				break;
			case 2:
				_localctx = new ArrayCallVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(665);
				array_call();
				}
				break;
			case 3:
				_localctx = new SigleValueVariableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(666);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Normal_valuesContext extends ParserRuleContext {
		public Normal_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_values; }
	 
		public Normal_valuesContext() { }
		public void copyFrom(Normal_valuesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValBoolContext extends Normal_valuesContext {
		public Boolean_valuesContext boolean_values() {
			return getRuleContext(Boolean_valuesContext.class,0);
		}
		public ValBoolContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValFunctionCallContext extends Normal_valuesContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public ValFunctionCallContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValStructNestValueContext extends Normal_valuesContext {
		public Struct_valuesContext struct_values() {
			return getRuleContext(Struct_valuesContext.class,0);
		}
		public ValStructNestValueContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValStructNestValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValStructNestValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValStructNestValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValArrayLiteralContext extends Normal_valuesContext {
		public Array_initializationContext array_initialization() {
			return getRuleContext(Array_initializationContext.class,0);
		}
		public ValArrayLiteralContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValIntContext extends Normal_valuesContext {
		public TerminalNode INT() { return getToken(PigLatinParser.INT, 0); }
		public ValIntContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValStructPropertyLiteralContext extends Normal_valuesContext {
		public Struct_literalContext struct_literal() {
			return getRuleContext(Struct_literalContext.class,0);
		}
		public ValStructPropertyLiteralContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValStructPropertyLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValStructPropertyLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValStructPropertyLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValStringContext extends Normal_valuesContext {
		public TerminalNode STRING() { return getToken(PigLatinParser.STRING, 0); }
		public ValStringContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValCharContext extends Normal_valuesContext {
		public TerminalNode CHAR() { return getToken(PigLatinParser.CHAR, 0); }
		public ValCharContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValChar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValIdCallContext extends Normal_valuesContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public ValIdCallContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValIdCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValIdCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValIdCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValArrayCallContext extends Normal_valuesContext {
		public Array_callContext array_call() {
			return getRuleContext(Array_callContext.class,0);
		}
		public ValArrayCallContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValArrayCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValArrayCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValArrayCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValDecimalContext extends Normal_valuesContext {
		public TerminalNode DECIMAL() { return getToken(PigLatinParser.DECIMAL, 0); }
		public ValDecimalContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_valuesContext normal_values() throws RecognitionException {
		Normal_valuesContext _localctx = new Normal_valuesContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_normal_values);
		try {
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				_localctx = new ValStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(669);
				match(STRING);
				}
				break;
			case 2:
				_localctx = new ValCharContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(670);
				match(CHAR);
				}
				break;
			case 3:
				_localctx = new ValDecimalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(671);
				match(DECIMAL);
				}
				break;
			case 4:
				_localctx = new ValIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(672);
				match(INT);
				}
				break;
			case 5:
				_localctx = new ValBoolContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(673);
				boolean_values();
				}
				break;
			case 6:
				_localctx = new ValArrayCallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(674);
				array_call();
				}
				break;
			case 7:
				_localctx = new ValFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(675);
				function_call();
				}
				break;
			case 8:
				_localctx = new ValStructNestValueContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(676);
				struct_values(0);
				}
				break;
			case 9:
				_localctx = new ValStructPropertyLiteralContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(677);
				struct_literal();
				}
				break;
			case 10:
				_localctx = new ValArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(678);
				array_initialization();
				}
				break;
			case 11:
				_localctx = new ValIdCallContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(679);
				match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Boolean_valuesContext extends ParserRuleContext {
		public Boolean_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_values; }
	 
		public Boolean_valuesContext() { }
		public void copyFrom(Boolean_valuesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolFalseContext extends Boolean_valuesContext {
		public TerminalNode FALSUS() { return getToken(PigLatinParser.FALSUS, 0); }
		public BoolFalseContext(Boolean_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBoolFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBoolFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBoolFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTrueContext extends Boolean_valuesContext {
		public TerminalNode VERUM() { return getToken(PigLatinParser.VERUM, 0); }
		public BoolTrueContext(Boolean_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBoolTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBoolTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBoolTrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_valuesContext boolean_values() throws RecognitionException {
		Boolean_valuesContext _localctx = new Boolean_valuesContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_boolean_values);
		try {
			setState(684);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VERUM:
				_localctx = new BoolTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(682);
				match(VERUM);
				}
				break;
			case FALSUS:
				_localctx = new BoolFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(683);
				match(FALSUS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Abbreviated_operationContext extends ParserRuleContext {
		public Abbreviated_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abbreviated_operation; }
	 
		public Abbreviated_operationContext() { }
		public void copyFrom(Abbreviated_operationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncPrevOperationContext extends Abbreviated_operationContext {
		public TerminalNode ABREV_PLUS() { return getToken(PigLatinParser.ABREV_PLUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public IncPrevOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterIncPrevOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitIncPrevOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitIncPrevOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecPrevOperationContext extends Abbreviated_operationContext {
		public TerminalNode ABREV_MINUS() { return getToken(PigLatinParser.ABREV_MINUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public DecPrevOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDecPrevOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDecPrevOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDecPrevOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncOperationContext extends Abbreviated_operationContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_PLUS() { return getToken(PigLatinParser.ABREV_PLUS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public IncOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterIncOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitIncOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitIncOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecOperationContext extends Abbreviated_operationContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_MINUS() { return getToken(PigLatinParser.ABREV_MINUS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public DecOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterDecOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitDecOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitDecOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Abbreviated_operationContext abbreviated_operation() throws RecognitionException {
		Abbreviated_operationContext _localctx = new Abbreviated_operationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_abbreviated_operation);
		try {
			setState(702);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				_localctx = new IncOperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(686);
				nest_variable();
				setState(687);
				match(ABREV_PLUS);
				setState(688);
				match(DOT_COMMA);
				}
				break;
			case 2:
				_localctx = new DecOperationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(690);
				nest_variable();
				setState(691);
				match(ABREV_MINUS);
				setState(692);
				match(DOT_COMMA);
				}
				break;
			case 3:
				_localctx = new IncPrevOperationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(694);
				match(ABREV_PLUS);
				setState(695);
				nest_variable();
				setState(696);
				match(DOT_COMMA);
				}
				break;
			case 4:
				_localctx = new DecPrevOperationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(698);
				match(ABREV_MINUS);
				setState(699);
				nest_variable();
				setState(700);
				match(DOT_COMMA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return munera_body_sempred((Munera_bodyContext)_localctx, predIndex);
		case 9:
			return local_variable_list_sempred((Local_variable_listContext)_localctx, predIndex);
		case 11:
			return function_arguments_sempred((Function_argumentsContext)_localctx, predIndex);
		case 16:
			return code_body_sempred((Code_bodyContext)_localctx, predIndex);
		case 21:
			return print_function_sempred((Print_functionContext)_localctx, predIndex);
		case 24:
			return else_if_list_sempred((Else_if_listContext)_localctx, predIndex);
		case 33:
			return variabiles_body_sempred((Variabiles_bodyContext)_localctx, predIndex);
		case 42:
			return values_array_list_sempred((Values_array_listContext)_localctx, predIndex);
		case 44:
			return struct_values_sempred((Struct_valuesContext)_localctx, predIndex);
		case 47:
			return struct_normal_body_sempred((Struct_normal_bodyContext)_localctx, predIndex);
		case 48:
			return struct_comma_body_sempred((Struct_comma_bodyContext)_localctx, predIndex);
		case 53:
			return struct_data_list_sempred((Struct_data_listContext)_localctx, predIndex);
		case 55:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 59:
			return arguments_list_sempred((Arguments_listContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean munera_body_sempred(Munera_bodyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean local_variable_list_sempred(Local_variable_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean function_arguments_sempred(Function_argumentsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean code_body_sempred(Code_bodyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean print_function_sempred(Print_functionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean else_if_list_sempred(Else_if_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean variabiles_body_sempred(Variabiles_bodyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean values_array_list_sempred(Values_array_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean struct_values_sempred(Struct_valuesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean struct_normal_body_sempred(Struct_normal_bodyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean struct_comma_body_sempred(Struct_comma_bodyContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean struct_data_list_sempred(Struct_data_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 7);
		case 14:
			return precpred(_ctx, 6);
		case 15:
			return precpred(_ctx, 5);
		case 16:
			return precpred(_ctx, 4);
		case 17:
			return precpred(_ctx, 3);
		case 18:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean arguments_list_sempred(Arguments_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001E\u02c1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0001\u0000\u0005\u0000"+
		"\u0082\b\u0000\n\u0000\f\u0000\u0085\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0003\u0001\u008a\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002\u0095\b\u0002\n\u0002\f\u0002\u0098\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0003\u0003\u009c\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004\u00a3\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00a8\b\u0004\u0001\u0004\u0003\u0004\u00ab\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00b7\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00bc\b\u0006\u0001\u0006\u0003"+
		"\u0006\u00bf\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c8\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0003\b\u00cf\b\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00d8\b\t\n\t\f\t\u00db\t\t"+
		"\u0001\n\u0001\n\u0001\n\u0003\n\u00e0\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00e8\b\u000b\n"+
		"\u000b\f\u000b\u00eb\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00f5\b\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0104\b\u0010\n"+
		"\u0010\f\u0010\u0107\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u0114\b\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u011c\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0122\b\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0003\u0014\u012c\b\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0134\b\u0015\n"+
		"\u0015\f\u0015\u0137\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u013d\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0145\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u0149\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u0154\b\u0018\n\u0018\f\u0018\u0157\t\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u015f\b\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0166\b\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u016a\b\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u0172\b\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u017b\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u018e\b\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u019b"+
		"\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0003\u001f\u01a4\b\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0005!\u01af\b!\n!\f!\u01b2\t!\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01bc"+
		"\b\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001"+
		"&\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0003(\u01e5\b(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0005*\u01f3\b*\n*\f*\u01f6\t*\u0001+\u0001"+
		"+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0003,\u0205\b,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0005,\u020f\b,\n,\f,\u0212\t,\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001.\u0001.\u0003.\u021e\b.\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0005/\u0228\b/\n/\f/\u022b\t/\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00050\u0233\b0\n0\f0\u0236\t0\u0001"+
		"1\u00011\u00031\u023a\b1\u00012\u00012\u00012\u00012\u00012\u00013\u0001"+
		"3\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00015\u00015\u0001"+
		"5\u00015\u00015\u00015\u00055\u0250\b5\n5\f5\u0253\t5\u00016\u00016\u0001"+
		"6\u00016\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0003"+
		"7\u0261\b7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0005"+
		"7\u0275\b7\n7\f7\u0278\t7\u00018\u00018\u00018\u00018\u00018\u00018\u0003"+
		"8\u0280\b8\u00019\u00019\u00019\u00019\u00019\u0001:\u0001:\u0001:\u0003"+
		":\u028a\b:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0005"+
		";\u0294\b;\n;\f;\u0297\t;\u0001<\u0001<\u0001<\u0003<\u029c\b<\u0001="+
		"\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0003=\u02a9\b=\u0001>\u0001>\u0003>\u02ad\b>\u0001?\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0003?\u02bf\b?\u0001?\u0000\u000e\u0004\u0012\u0016 "+
		"*0BTX^`jnv@\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt"+
		"vxz|~\u0000\u0005\u0002\u000033??\u0001\u000045\u0001\u000023\u0002\u0000"+
		"89;<\u0002\u000077::\u02df\u0000\u0083\u0001\u0000\u0000\u0000\u0002\u0089"+
		"\u0001\u0000\u0000\u0000\u0004\u008f\u0001\u0000\u0000\u0000\u0006\u009b"+
		"\u0001\u0000\u0000\u0000\b\u009d\u0001\u0000\u0000\u0000\n\u00b0\u0001"+
		"\u0000\u0000\u0000\f\u00b2\u0001\u0000\u0000\u0000\u000e\u00c4\u0001\u0000"+
		"\u0000\u0000\u0010\u00cb\u0001\u0000\u0000\u0000\u0012\u00d2\u0001\u0000"+
		"\u0000\u0000\u0014\u00df\u0001\u0000\u0000\u0000\u0016\u00e1\u0001\u0000"+
		"\u0000\u0000\u0018\u00f4\u0001\u0000\u0000\u0000\u001a\u00f6\u0001\u0000"+
		"\u0000\u0000\u001c\u00f8\u0001\u0000\u0000\u0000\u001e\u00fa\u0001\u0000"+
		"\u0000\u0000 \u00fe\u0001\u0000\u0000\u0000\"\u0113\u0001\u0000\u0000"+
		"\u0000$\u011b\u0001\u0000\u0000\u0000&\u0121\u0001\u0000\u0000\u0000("+
		"\u012b\u0001\u0000\u0000\u0000*\u012d\u0001\u0000\u0000\u0000,\u013c\u0001"+
		"\u0000\u0000\u0000.\u013e\u0001\u0000\u0000\u00000\u014e\u0001\u0000\u0000"+
		"\u00002\u0158\u0001\u0000\u0000\u00004\u0169\u0001\u0000\u0000\u00006"+
		"\u016b\u0001\u0000\u0000\u00008\u0177\u0001\u0000\u0000\u0000:\u0183\u0001"+
		"\u0000\u0000\u0000<\u019a\u0001\u0000\u0000\u0000>\u01a3\u0001\u0000\u0000"+
		"\u0000@\u01a5\u0001\u0000\u0000\u0000B\u01a9\u0001\u0000\u0000\u0000D"+
		"\u01bb\u0001\u0000\u0000\u0000F\u01bd\u0001\u0000\u0000\u0000H\u01c5\u0001"+
		"\u0000\u0000\u0000J\u01ca\u0001\u0000\u0000\u0000L\u01cf\u0001\u0000\u0000"+
		"\u0000N\u01d5\u0001\u0000\u0000\u0000P\u01dc\u0001\u0000\u0000\u0000R"+
		"\u01e8\u0001\u0000\u0000\u0000T\u01ec\u0001\u0000\u0000\u0000V\u01f7\u0001"+
		"\u0000\u0000\u0000X\u0204\u0001\u0000\u0000\u0000Z\u0213\u0001\u0000\u0000"+
		"\u0000\\\u021d\u0001\u0000\u0000\u0000^\u021f\u0001\u0000\u0000\u0000"+
		"`\u022c\u0001\u0000\u0000\u0000b\u0239\u0001\u0000\u0000\u0000d\u023b"+
		"\u0001\u0000\u0000\u0000f\u0240\u0001\u0000\u0000\u0000h\u0245\u0001\u0000"+
		"\u0000\u0000j\u0249\u0001\u0000\u0000\u0000l\u0254\u0001\u0000\u0000\u0000"+
		"n\u0260\u0001\u0000\u0000\u0000p\u027f\u0001\u0000\u0000\u0000r\u0281"+
		"\u0001\u0000\u0000\u0000t\u0286\u0001\u0000\u0000\u0000v\u028d\u0001\u0000"+
		"\u0000\u0000x\u029b\u0001\u0000\u0000\u0000z\u02a8\u0001\u0000\u0000\u0000"+
		"|\u02ac\u0001\u0000\u0000\u0000~\u02be\u0001\u0000\u0000\u0000\u0080\u0082"+
		"\u0003\u0002\u0001\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0085"+
		"\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0000\u0000\u0001\u0087\u0001"+
		"\u0001\u0000\u0000\u0000\u0088\u008a\u0003@ \u0000\u0089\u0088\u0001\u0000"+
		"\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0003\u001e\u000f\u0000\u008c\u008d\u0005\u0006"+
		"\u0000\u0000\u008d\u008e\u0005\"\u0000\u0000\u008e\u0003\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0006\u0002\uffff\uffff\u0000\u0090\u0091\u0003\u0006"+
		"\u0003\u0000\u0091\u0096\u0001\u0000\u0000\u0000\u0092\u0093\n\u0002\u0000"+
		"\u0000\u0093\u0095\u0003\u0006\u0003\u0000\u0094\u0092\u0001\u0000\u0000"+
		"\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0005\u0001\u0000\u0000"+
		"\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009c\u0003\b\u0004\u0000"+
		"\u009a\u009c\u0003\f\u0006\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u009a\u0001\u0000\u0000\u0000\u009c\u0007\u0001\u0000\u0000\u0000\u009d"+
		"\u009e\u0005\u001c\u0000\u0000\u009e\u009f\u0003\n\u0005\u0000\u009f\u00a0"+
		"\u0005@\u0000\u0000\u00a0\u00a2\u0005)\u0000\u0000\u00a1\u00a3\u0003\u0016"+
		"\u000b\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0005*\u0000"+
		"\u0000\u00a5\u00a7\u0005%\u0000\u0000\u00a6\u00a8\u0003\u000e\u0007\u0000"+
		"\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u00aa\u0001\u0000\u0000\u0000\u00a9\u00ab\u0003 \u0010\u0000\u00aa"+
		"\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005&\u0000\u0000\u00ad\u00ae"+
		"\u0005\u0015\u0000\u0000\u00ae\u00af\u0005\"\u0000\u0000\u00af\t\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0003p8\u0000\u00b1\u000b\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0005\u001b\u0000\u0000\u00b3\u00b4\u0005@\u0000\u0000"+
		"\u00b4\u00b6\u0005)\u0000\u0000\u00b5\u00b7\u0003\u0016\u000b\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005*\u0000\u0000\u00b9\u00bb"+
		"\u0005%\u0000\u0000\u00ba\u00bc\u0003\u0010\b\u0000\u00bb\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00be\u0001"+
		"\u0000\u0000\u0000\u00bd\u00bf\u0003 \u0010\u0000\u00be\u00bd\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0005&\u0000\u0000\u00c1\u00c2\u0005\u0015\u0000"+
		"\u0000\u00c2\u00c3\u0005\"\u0000\u0000\u00c3\r\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0005\u0004\u0000\u0000\u00c5\u00c7\u0005\'\u0000\u0000\u00c6"+
		"\u00c8\u0003\u0012\t\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00ca"+
		"\u0005(\u0000\u0000\u00ca\u000f\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005"+
		"\u0004\u0000\u0000\u00cc\u00ce\u0005\'\u0000\u0000\u00cd\u00cf\u0003\u0012"+
		"\t\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000"+
		"\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005(\u0000\u0000"+
		"\u00d1\u0011\u0001\u0000\u0000\u0000\u00d2\u00d3\u0006\t\uffff\uffff\u0000"+
		"\u00d3\u00d4\u0003\u0014\n\u0000\u00d4\u00d9\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d6\n\u0002\u0000\u0000\u00d6\u00d8\u0003\u0014\n\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u0013"+
		"\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00e0"+
		"\u0003N\'\u0000\u00dd\u00e0\u0003P(\u0000\u00de\u00e0\u0003L&\u0000\u00df"+
		"\u00dc\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00de\u0001\u0000\u0000\u0000\u00e0\u0015\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0006\u000b\uffff\uffff\u0000\u00e2\u00e3\u0003\u0018\f\u0000\u00e3"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e4\u00e5\n\u0002\u0000\u0000\u00e5\u00e6"+
		"\u0005!\u0000\u0000\u00e6\u00e8\u0003\u0018\f\u0000\u00e7\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000\u00ea\u0017\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005"+
		"\u0012\u0000\u0000\u00ed\u00ee\u0005@\u0000\u0000\u00ee\u00ef\u0005#\u0000"+
		"\u0000\u00ef\u00f5\u0003\u001a\r\u0000\u00f0\u00f1\u0005\u0013\u0000\u0000"+
		"\u00f1\u00f2\u0005@\u0000\u0000\u00f2\u00f3\u0005#\u0000\u0000\u00f3\u00f5"+
		"\u0003\u001c\u000e\u0000\u00f4\u00ec\u0001\u0000\u0000\u0000\u00f4\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f5\u0019\u0001\u0000\u0000\u0000\u00f6\u00f7"+
		"\u0003p8\u0000\u00f7\u001b\u0001\u0000\u0000\u0000\u00f8\u00f9\u0003p"+
		"8\u0000\u00f9\u001d\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005\u0005\u0000"+
		"\u0000\u00fb\u00fc\u0005<\u0000\u0000\u00fc\u00fd\u0003 \u0010\u0000\u00fd"+
		"\u001f\u0001\u0000\u0000\u0000\u00fe\u00ff\u0006\u0010\uffff\uffff\u0000"+
		"\u00ff\u0100\u0003\"\u0011\u0000\u0100\u0105\u0001\u0000\u0000\u0000\u0101"+
		"\u0102\n\u0002\u0000\u0000\u0102\u0104\u0003\"\u0011\u0000\u0103\u0101"+
		"\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105\u0103"+
		"\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106!\u0001"+
		"\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u0114\u0003"+
		",\u0016\u0000\u0109\u0114\u0003(\u0014\u0000\u010a\u010b\u0003t:\u0000"+
		"\u010b\u010c\u0005\"\u0000\u0000\u010c\u0114\u0001\u0000\u0000\u0000\u010d"+
		"\u0114\u0003&\u0013\u0000\u010e\u0114\u0003$\u0012\u0000\u010f\u0114\u0003"+
		"~?\u0000\u0110\u0114\u0003H$\u0000\u0111\u0114\u0003F#\u0000\u0112\u0114"+
		"\u0003J%\u0000\u0113\u0108\u0001\u0000\u0000\u0000\u0113\u0109\u0001\u0000"+
		"\u0000\u0000\u0113\u010a\u0001\u0000\u0000\u0000\u0113\u010d\u0001\u0000"+
		"\u0000\u0000\u0113\u010e\u0001\u0000\u0000\u0000\u0113\u010f\u0001\u0000"+
		"\u0000\u0000\u0113\u0110\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000"+
		"\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114#\u0001\u0000\u0000"+
		"\u0000\u0115\u0116\u0005\u001d\u0000\u0000\u0116\u0117\u0003n7\u0000\u0117"+
		"\u0118\u0005\"\u0000\u0000\u0118\u011c\u0001\u0000\u0000\u0000\u0119\u011a"+
		"\u0005\u001d\u0000\u0000\u011a\u011c\u0005\"\u0000\u0000\u011b\u0115\u0001"+
		"\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011c%\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0005\u001e\u0000\u0000\u011e\u0122\u0005\"\u0000"+
		"\u0000\u011f\u0120\u0005\u001f\u0000\u0000\u0120\u0122\u0005\"\u0000\u0000"+
		"\u0121\u011d\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000"+
		"\u0122\'\u0001\u0000\u0000\u0000\u0123\u0124\u0003x<\u0000\u0124\u0125"+
		"\u0005\b\u0000\u0000\u0125\u012c\u0001\u0000\u0000\u0000\u0126\u012c\u0005"+
		"\b\u0000\u0000\u0127\u0128\u0005\u0007\u0000\u0000\u0128\u0129\u0003*"+
		"\u0015\u0000\u0129\u012a\u0005\"\u0000\u0000\u012a\u012c\u0001\u0000\u0000"+
		"\u0000\u012b\u0123\u0001\u0000\u0000\u0000\u012b\u0126\u0001\u0000\u0000"+
		"\u0000\u012b\u0127\u0001\u0000\u0000\u0000\u012c)\u0001\u0000\u0000\u0000"+
		"\u012d\u012e\u0006\u0015\uffff\uffff\u0000\u012e\u012f\u0003n7\u0000\u012f"+
		"\u0135\u0001\u0000\u0000\u0000\u0130\u0131\n\u0002\u0000\u0000\u0131\u0132"+
		"\u0005\u0007\u0000\u0000\u0132\u0134\u0003n7\u0000\u0133\u0130\u0001\u0000"+
		"\u0000\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000"+
		"\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136+\u0001\u0000\u0000"+
		"\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u013d\u0003.\u0017\u0000"+
		"\u0139\u013d\u00036\u001b\u0000\u013a\u013d\u00038\u001c\u0000\u013b\u013d"+
		"\u0003:\u001d\u0000\u013c\u0138\u0001\u0000\u0000\u0000\u013c\u0139\u0001"+
		"\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013c\u013b\u0001"+
		"\u0000\u0000\u0000\u013d-\u0001\u0000\u0000\u0000\u013e\u013f\u0005\u0019"+
		"\u0000\u0000\u013f\u0140\u0005)\u0000\u0000\u0140\u0141\u0003n7\u0000"+
		"\u0141\u0142\u0005*\u0000\u0000\u0142\u0144\u0005%\u0000\u0000\u0143\u0145"+
		"\u0003 \u0010\u0000\u0144\u0143\u0001\u0000\u0000\u0000\u0144\u0145\u0001"+
		"\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146\u0148\u0005"+
		"&\u0000\u0000\u0147\u0149\u00030\u0018\u0000\u0148\u0147\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000\u0000"+
		"\u0000\u014a\u014b\u00034\u001a\u0000\u014b\u014c\u0005\u0015\u0000\u0000"+
		"\u014c\u014d\u0005\"\u0000\u0000\u014d/\u0001\u0000\u0000\u0000\u014e"+
		"\u014f\u0006\u0018\uffff\uffff\u0000\u014f\u0150\u00032\u0019\u0000\u0150"+
		"\u0155\u0001\u0000\u0000\u0000\u0151\u0152\n\u0002\u0000\u0000\u0152\u0154"+
		"\u00032\u0019\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0154\u0157\u0001"+
		"\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0155\u0156\u0001"+
		"\u0000\u0000\u0000\u01561\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000"+
		"\u0000\u0000\u0158\u0159\u0005\u001a\u0000\u0000\u0159\u015a\u0005)\u0000"+
		"\u0000\u015a\u015b\u0003n7\u0000\u015b\u015c\u0005*\u0000\u0000\u015c"+
		"\u015e\u0005%\u0000\u0000\u015d\u015f\u0003 \u0010\u0000\u015e\u015d\u0001"+
		"\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u0160\u0001"+
		"\u0000\u0000\u0000\u0160\u0161\u0005&\u0000\u0000\u01613\u0001\u0000\u0000"+
		"\u0000\u0162\u0163\u0005\u001a\u0000\u0000\u0163\u0165\u0005%\u0000\u0000"+
		"\u0164\u0166\u0003 \u0010\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167"+
		"\u016a\u0005&\u0000\u0000\u0168\u016a\u0001\u0000\u0000\u0000\u0169\u0162"+
		"\u0001\u0000\u0000\u0000\u0169\u0168\u0001\u0000\u0000\u0000\u016a5\u0001"+
		"\u0000\u0000\u0000\u016b\u016c\u0005\u0016\u0000\u0000\u016c\u016d\u0005"+
		")\u0000\u0000\u016d\u016e\u0003n7\u0000\u016e\u016f\u0005*\u0000\u0000"+
		"\u016f\u0171\u0005%\u0000\u0000\u0170\u0172\u0003 \u0010\u0000\u0171\u0170"+
		"\u0001\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0173"+
		"\u0001\u0000\u0000\u0000\u0173\u0174\u0005&\u0000\u0000\u0174\u0175\u0005"+
		"\u0015\u0000\u0000\u0175\u0176\u0005\"\u0000\u0000\u01767\u0001\u0000"+
		"\u0000\u0000\u0177\u0178\u0005\u0017\u0000\u0000\u0178\u017a\u0005%\u0000"+
		"\u0000\u0179\u017b\u0003 \u0010\u0000\u017a\u0179\u0001\u0000\u0000\u0000"+
		"\u017a\u017b\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000"+
		"\u017c\u017d\u0005&\u0000\u0000\u017d\u017e\u0005\u0016\u0000\u0000\u017e"+
		"\u017f\u0005)\u0000\u0000\u017f\u0180\u0003n7\u0000\u0180\u0181\u0005"+
		"*\u0000\u0000\u0181\u0182\u0005\"\u0000\u0000\u01829\u0001\u0000\u0000"+
		"\u0000\u0183\u0184\u0005\u0018\u0000\u0000\u0184\u0185\u0005)\u0000\u0000"+
		"\u0185\u0186\u0003<\u001e\u0000\u0186\u0187\u0005\"\u0000\u0000\u0187"+
		"\u0188\u0003n7\u0000\u0188\u0189\u0005\"\u0000\u0000\u0189\u018a\u0003"+
		">\u001f\u0000\u018a\u018b\u0005*\u0000\u0000\u018b\u018d\u0005%\u0000"+
		"\u0000\u018c\u018e\u0003 \u0010\u0000\u018d\u018c\u0001\u0000\u0000\u0000"+
		"\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000"+
		"\u018f\u0190\u0005&\u0000\u0000\u0190;\u0001\u0000\u0000\u0000\u0191\u0192"+
		"\u0005\u0012\u0000\u0000\u0192\u0193\u0005@\u0000\u0000\u0193\u0194\u0005"+
		"#\u0000\u0000\u0194\u0195\u0003p8\u0000\u0195\u0196\u0003n7\u0000\u0196"+
		"\u019b\u0001\u0000\u0000\u0000\u0197\u0198\u0005@\u0000\u0000\u0198\u0199"+
		"\u0005 \u0000\u0000\u0199\u019b\u0003n7\u0000\u019a\u0191\u0001\u0000"+
		"\u0000\u0000\u019a\u0197\u0001\u0000\u0000\u0000\u019b=\u0001\u0000\u0000"+
		"\u0000\u019c\u019d\u0005@\u0000\u0000\u019d\u01a4\u00050\u0000\u0000\u019e"+
		"\u019f\u0005@\u0000\u0000\u019f\u01a4\u00051\u0000\u0000\u01a0\u01a1\u0005"+
		"@\u0000\u0000\u01a1\u01a2\u0005 \u0000\u0000\u01a2\u01a4\u0003n7\u0000"+
		"\u01a3\u019c\u0001\u0000\u0000\u0000\u01a3\u019e\u0001\u0000\u0000\u0000"+
		"\u01a3\u01a0\u0001\u0000\u0000\u0000\u01a4?\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a6\u0005\u0004\u0000\u0000\u01a6\u01a7\u0005<\u0000\u0000\u01a7\u01a8"+
		"\u0003B!\u0000\u01a8A\u0001\u0000\u0000\u0000\u01a9\u01aa\u0006!\uffff"+
		"\uffff\u0000\u01aa\u01ab\u0003D\"\u0000\u01ab\u01b0\u0001\u0000\u0000"+
		"\u0000\u01ac\u01ad\n\u0002\u0000\u0000\u01ad\u01af\u0003D\"\u0000\u01ae"+
		"\u01ac\u0001\u0000\u0000\u0000\u01af\u01b2\u0001\u0000\u0000\u0000\u01b0"+
		"\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1"+
		"C\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b3\u01bc"+
		"\u0003N\'\u0000\u01b4\u01bc\u0003H$\u0000\u01b5\u01bc\u0003P(\u0000\u01b6"+
		"\u01bc\u0003Z-\u0000\u01b7\u01bc\u0003F#\u0000\u01b8\u01bc\u0003L&\u0000"+
		"\u01b9\u01bc\u0003~?\u0000\u01ba\u01bc\u0003J%\u0000\u01bb\u01b3\u0001"+
		"\u0000\u0000\u0000\u01bb\u01b4\u0001\u0000\u0000\u0000\u01bb\u01b5\u0001"+
		"\u0000\u0000\u0000\u01bb\u01b6\u0001\u0000\u0000\u0000\u01bb\u01b7\u0001"+
		"\u0000\u0000\u0000\u01bb\u01b8\u0001\u0000\u0000\u0000\u01bb\u01b9\u0001"+
		"\u0000\u0000\u0000\u01bb\u01ba\u0001\u0000\u0000\u0000\u01bcE\u0001\u0000"+
		"\u0000\u0000\u01bd\u01be\u0005@\u0000\u0000\u01be\u01bf\u0005\'\u0000"+
		"\u0000\u01bf\u01c0\u0003n7\u0000\u01c0\u01c1\u0005(\u0000\u0000\u01c1"+
		"\u01c2\u0005 \u0000\u0000\u01c2\u01c3\u0003n7\u0000\u01c3\u01c4\u0005"+
		"\"\u0000\u0000\u01c4G\u0001\u0000\u0000\u0000\u01c5\u01c6\u0005@\u0000"+
		"\u0000\u01c6\u01c7\u0005 \u0000\u0000\u01c7\u01c8\u0003n7\u0000\u01c8"+
		"\u01c9\u0005\"\u0000\u0000\u01c9I\u0001\u0000\u0000\u0000\u01ca\u01cb"+
		"\u0003X,\u0000\u01cb\u01cc\u0005 \u0000\u0000\u01cc\u01cd\u0003n7\u0000"+
		"\u01cd\u01ce\u0005\"\u0000\u0000\u01ceK\u0001\u0000\u0000\u0000\u01cf"+
		"\u01d0\u0005\u0012\u0000\u0000\u01d0\u01d1\u0005@\u0000\u0000\u01d1\u01d2"+
		"\u0005#\u0000\u0000\u01d2\u01d3\u0005@\u0000\u0000\u01d3\u01d4\u0003h"+
		"4\u0000\u01d4M\u0001\u0000\u0000\u0000\u01d5\u01d6\u0005\u0012\u0000\u0000"+
		"\u01d6\u01d7\u0005@\u0000\u0000\u01d7\u01d8\u0005#\u0000\u0000\u01d8\u01d9"+
		"\u0003p8\u0000\u01d9\u01da\u0003n7\u0000\u01da\u01db\u0005\"\u0000\u0000"+
		"\u01dbO\u0001\u0000\u0000\u0000\u01dc\u01dd\u0005\u0013\u0000\u0000\u01dd"+
		"\u01de\u0005@\u0000\u0000\u01de\u01df\u0005\'\u0000\u0000\u01df\u01e0"+
		"\u0003n7\u0000\u01e0\u01e1\u0005(\u0000\u0000\u01e1\u01e2\u0005#\u0000"+
		"\u0000\u01e2\u01e4\u0003p8\u0000\u01e3\u01e5\u0003R)\u0000\u01e4\u01e3"+
		"\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000\u01e5\u01e6"+
		"\u0001\u0000\u0000\u0000\u01e6\u01e7\u0005\"\u0000\u0000\u01e7Q\u0001"+
		"\u0000\u0000\u0000\u01e8\u01e9\u0005%\u0000\u0000\u01e9\u01ea\u0003T*"+
		"\u0000\u01ea\u01eb\u0005&\u0000\u0000\u01ebS\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ed\u0006*\uffff\uffff\u0000\u01ed\u01ee\u0003V+\u0000\u01ee\u01f4"+
		"\u0001\u0000\u0000\u0000\u01ef\u01f0\n\u0002\u0000\u0000\u01f0\u01f1\u0005"+
		"!\u0000\u0000\u01f1\u01f3\u0003V+\u0000\u01f2\u01ef\u0001\u0000\u0000"+
		"\u0000\u01f3\u01f6\u0001\u0000\u0000\u0000\u01f4\u01f2\u0001\u0000\u0000"+
		"\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000\u01f5U\u0001\u0000\u0000\u0000"+
		"\u01f6\u01f4\u0001\u0000\u0000\u0000\u01f7\u01f8\u0003n7\u0000\u01f8W"+
		"\u0001\u0000\u0000\u0000\u01f9\u01fa\u0006,\uffff\uffff\u0000\u01fa\u01fb"+
		"\u0005@\u0000\u0000\u01fb\u01fc\u0005$\u0000\u0000\u01fc\u0205\u0005@"+
		"\u0000\u0000\u01fd\u01fe\u0005@\u0000\u0000\u01fe\u01ff\u0005\'\u0000"+
		"\u0000\u01ff\u0200\u0003n7\u0000\u0200\u0201\u0005(\u0000\u0000\u0201"+
		"\u0202\u0005$\u0000\u0000\u0202\u0203\u0005@\u0000\u0000\u0203\u0205\u0001"+
		"\u0000\u0000\u0000\u0204\u01f9\u0001\u0000\u0000\u0000\u0204\u01fd\u0001"+
		"\u0000\u0000\u0000\u0205\u0210\u0001\u0000\u0000\u0000\u0206\u0207\n\u0004"+
		"\u0000\u0000\u0207\u0208\u0005$\u0000\u0000\u0208\u020f\u0005@\u0000\u0000"+
		"\u0209\u020a\n\u0003\u0000\u0000\u020a\u020b\u0005\'\u0000\u0000\u020b"+
		"\u020c\u0003n7\u0000\u020c\u020d\u0005(\u0000\u0000\u020d\u020f\u0001"+
		"\u0000\u0000\u0000\u020e\u0206\u0001\u0000\u0000\u0000\u020e\u0209\u0001"+
		"\u0000\u0000\u0000\u020f\u0212\u0001\u0000\u0000\u0000\u0210\u020e\u0001"+
		"\u0000\u0000\u0000\u0210\u0211\u0001\u0000\u0000\u0000\u0211Y\u0001\u0000"+
		"\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0213\u0214\u0005\u0014"+
		"\u0000\u0000\u0214\u0215\u0005@\u0000\u0000\u0215\u0216\u0005%\u0000\u0000"+
		"\u0216\u0217\u0003\\.\u0000\u0217\u0218\u0005&\u0000\u0000\u0218\u0219"+
		"\u0005\u0015\u0000\u0000\u0219\u021a\u0005\"\u0000\u0000\u021a[\u0001"+
		"\u0000\u0000\u0000\u021b\u021e\u0003^/\u0000\u021c\u021e\u0003`0\u0000"+
		"\u021d\u021b\u0001\u0000\u0000\u0000\u021d\u021c\u0001\u0000\u0000\u0000"+
		"\u021e]\u0001\u0000\u0000\u0000\u021f\u0220\u0006/\uffff\uffff\u0000\u0220"+
		"\u0221\u0003b1\u0000\u0221\u0222\u0005\"\u0000\u0000\u0222\u0229\u0001"+
		"\u0000\u0000\u0000\u0223\u0224\n\u0002\u0000\u0000\u0224\u0225\u0003b"+
		"1\u0000\u0225\u0226\u0005\"\u0000\u0000\u0226\u0228\u0001\u0000\u0000"+
		"\u0000\u0227\u0223\u0001\u0000\u0000\u0000\u0228\u022b\u0001\u0000\u0000"+
		"\u0000\u0229\u0227\u0001\u0000\u0000\u0000\u0229\u022a\u0001\u0000\u0000"+
		"\u0000\u022a_\u0001\u0000\u0000\u0000\u022b\u0229\u0001\u0000\u0000\u0000"+
		"\u022c\u022d\u00060\uffff\uffff\u0000\u022d\u022e\u0003b1\u0000\u022e"+
		"\u0234\u0001\u0000\u0000\u0000\u022f\u0230\n\u0002\u0000\u0000\u0230\u0231"+
		"\u0005!\u0000\u0000\u0231\u0233\u0003b1\u0000\u0232\u022f\u0001\u0000"+
		"\u0000\u0000\u0233\u0236\u0001\u0000\u0000\u0000\u0234\u0232\u0001\u0000"+
		"\u0000\u0000\u0234\u0235\u0001\u0000\u0000\u0000\u0235a\u0001\u0000\u0000"+
		"\u0000\u0236\u0234\u0001\u0000\u0000\u0000\u0237\u023a\u0003d2\u0000\u0238"+
		"\u023a\u0003f3\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u0239\u0238\u0001"+
		"\u0000\u0000\u0000\u023ac\u0001\u0000\u0000\u0000\u023b\u023c\u0005\u0012"+
		"\u0000\u0000\u023c\u023d\u0005@\u0000\u0000\u023d\u023e\u0005#\u0000\u0000"+
		"\u023e\u023f\u0003p8\u0000\u023fe\u0001\u0000\u0000\u0000\u0240\u0241"+
		"\u0005\u0013\u0000\u0000\u0241\u0242\u0005@\u0000\u0000\u0242\u0243\u0005"+
		"#\u0000\u0000\u0243\u0244\u0003p8\u0000\u0244g\u0001\u0000\u0000\u0000"+
		"\u0245\u0246\u0005%\u0000\u0000\u0246\u0247\u0003j5\u0000\u0247\u0248"+
		"\u0005&\u0000\u0000\u0248i\u0001\u0000\u0000\u0000\u0249\u024a\u00065"+
		"\uffff\uffff\u0000\u024a\u024b\u0003l6\u0000\u024b\u0251\u0001\u0000\u0000"+
		"\u0000\u024c\u024d\n\u0002\u0000\u0000\u024d\u024e\u0005!\u0000\u0000"+
		"\u024e\u0250\u0003l6\u0000\u024f\u024c\u0001\u0000\u0000\u0000\u0250\u0253"+
		"\u0001\u0000\u0000\u0000\u0251\u024f\u0001\u0000\u0000\u0000\u0251\u0252"+
		"\u0001\u0000\u0000\u0000\u0252k\u0001\u0000\u0000\u0000\u0253\u0251\u0001"+
		"\u0000\u0000\u0000\u0254\u0255\u0005@\u0000\u0000\u0255\u0256\u0005#\u0000"+
		"\u0000\u0256\u0257\u0003n7\u0000\u0257m\u0001\u0000\u0000\u0000\u0258"+
		"\u0259\u00067\uffff\uffff\u0000\u0259\u025a\u0005)\u0000\u0000\u025a\u025b"+
		"\u0003n7\u0000\u025b\u025c\u0005*\u0000\u0000\u025c\u0261\u0001\u0000"+
		"\u0000\u0000\u025d\u025e\u0007\u0000\u0000\u0000\u025e\u0261\u0003n7\b"+
		"\u025f\u0261\u0003z=\u0000\u0260\u0258\u0001\u0000\u0000\u0000\u0260\u025d"+
		"\u0001\u0000\u0000\u0000\u0260\u025f\u0001\u0000\u0000\u0000\u0261\u0276"+
		"\u0001\u0000\u0000\u0000\u0262\u0263\n\u0007\u0000\u0000\u0263\u0264\u0007"+
		"\u0001\u0000\u0000\u0264\u0275\u0003n7\b\u0265\u0266\n\u0006\u0000\u0000"+
		"\u0266\u0267\u0007\u0002\u0000\u0000\u0267\u0275\u0003n7\u0007\u0268\u0269"+
		"\n\u0005\u0000\u0000\u0269\u026a\u0007\u0003\u0000\u0000\u026a\u0275\u0003"+
		"n7\u0006\u026b\u026c\n\u0004\u0000\u0000\u026c\u026d\u0007\u0004\u0000"+
		"\u0000\u026d\u0275\u0003n7\u0005\u026e\u026f\n\u0003\u0000\u0000\u026f"+
		"\u0270\u0005=\u0000\u0000\u0270\u0275\u0003n7\u0004\u0271\u0272\n\u0002"+
		"\u0000\u0000\u0272\u0273\u0005>\u0000\u0000\u0273\u0275\u0003n7\u0003"+
		"\u0274\u0262\u0001\u0000\u0000\u0000\u0274\u0265\u0001\u0000\u0000\u0000"+
		"\u0274\u0268\u0001\u0000\u0000\u0000\u0274\u026b\u0001\u0000\u0000\u0000"+
		"\u0274\u026e\u0001\u0000\u0000\u0000\u0274\u0271\u0001\u0000\u0000\u0000"+
		"\u0275\u0278\u0001\u0000\u0000\u0000\u0276\u0274\u0001\u0000\u0000\u0000"+
		"\u0276\u0277\u0001\u0000\u0000\u0000\u0277o\u0001\u0000\u0000\u0000\u0278"+
		"\u0276\u0001\u0000\u0000\u0000\u0279\u0280\u0005\n\u0000\u0000\u027a\u0280"+
		"\u0005\t\u0000\u0000\u027b\u0280\u0005\u000b\u0000\u0000\u027c\u0280\u0005"+
		"\f\u0000\u0000\u027d\u0280\u0005\r\u0000\u0000\u027e\u0280\u0005@\u0000"+
		"\u0000\u027f\u0279\u0001\u0000\u0000\u0000\u027f\u027a\u0001\u0000\u0000"+
		"\u0000\u027f\u027b\u0001\u0000\u0000\u0000\u027f\u027c\u0001\u0000\u0000"+
		"\u0000\u027f\u027d\u0001\u0000\u0000\u0000\u027f\u027e\u0001\u0000\u0000"+
		"\u0000\u0280q\u0001\u0000\u0000\u0000\u0281\u0282\u0005@\u0000\u0000\u0282"+
		"\u0283\u0005\'\u0000\u0000\u0283\u0284\u0003n7\u0000\u0284\u0285\u0005"+
		"(\u0000\u0000\u0285s\u0001\u0000\u0000\u0000\u0286\u0287\u0005@\u0000"+
		"\u0000\u0287\u0289\u0005)\u0000\u0000\u0288\u028a\u0003v;\u0000\u0289"+
		"\u0288\u0001\u0000\u0000\u0000\u0289\u028a\u0001\u0000\u0000\u0000\u028a"+
		"\u028b\u0001\u0000\u0000\u0000\u028b\u028c\u0005*\u0000\u0000\u028cu\u0001"+
		"\u0000\u0000\u0000\u028d\u028e\u0006;\uffff\uffff\u0000\u028e\u028f\u0003"+
		"n7\u0000\u028f\u0295\u0001\u0000\u0000\u0000\u0290\u0291\n\u0002\u0000"+
		"\u0000\u0291\u0292\u0005!\u0000\u0000\u0292\u0294\u0003n7\u0000\u0293"+
		"\u0290\u0001\u0000\u0000\u0000\u0294\u0297\u0001\u0000\u0000\u0000\u0295"+
		"\u0293\u0001\u0000\u0000\u0000\u0295\u0296\u0001\u0000\u0000\u0000\u0296"+
		"w\u0001\u0000\u0000\u0000\u0297\u0295\u0001\u0000\u0000\u0000\u0298\u029c"+
		"\u0003X,\u0000\u0299\u029c\u0003r9\u0000\u029a\u029c\u0005@\u0000\u0000"+
		"\u029b\u0298\u0001\u0000\u0000\u0000\u029b\u0299\u0001\u0000\u0000\u0000"+
		"\u029b\u029a\u0001\u0000\u0000\u0000\u029cy\u0001\u0000\u0000\u0000\u029d"+
		"\u02a9\u0005C\u0000\u0000\u029e\u02a9\u0005D\u0000\u0000\u029f\u02a9\u0005"+
		"B\u0000\u0000\u02a0\u02a9\u0005A\u0000\u0000\u02a1\u02a9\u0003|>\u0000"+
		"\u02a2\u02a9\u0003r9\u0000\u02a3\u02a9\u0003t:\u0000\u02a4\u02a9\u0003"+
		"X,\u0000\u02a5\u02a9\u0003h4\u0000\u02a6\u02a9\u0003R)\u0000\u02a7\u02a9"+
		"\u0005@\u0000\u0000\u02a8\u029d\u0001\u0000\u0000\u0000\u02a8\u029e\u0001"+
		"\u0000\u0000\u0000\u02a8\u029f\u0001\u0000\u0000\u0000\u02a8\u02a0\u0001"+
		"\u0000\u0000\u0000\u02a8\u02a1\u0001\u0000\u0000\u0000\u02a8\u02a2\u0001"+
		"\u0000\u0000\u0000\u02a8\u02a3\u0001\u0000\u0000\u0000\u02a8\u02a4\u0001"+
		"\u0000\u0000\u0000\u02a8\u02a5\u0001\u0000\u0000\u0000\u02a8\u02a6\u0001"+
		"\u0000\u0000\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a9{\u0001\u0000"+
		"\u0000\u0000\u02aa\u02ad\u0005\u000e\u0000\u0000\u02ab\u02ad\u0005\u000f"+
		"\u0000\u0000\u02ac\u02aa\u0001\u0000\u0000\u0000\u02ac\u02ab\u0001\u0000"+
		"\u0000\u0000\u02ad}\u0001\u0000\u0000\u0000\u02ae\u02af\u0003x<\u0000"+
		"\u02af\u02b0\u00050\u0000\u0000\u02b0\u02b1\u0005\"\u0000\u0000\u02b1"+
		"\u02bf\u0001\u0000\u0000\u0000\u02b2\u02b3\u0003x<\u0000\u02b3\u02b4\u0005"+
		"1\u0000\u0000\u02b4\u02b5\u0005\"\u0000\u0000\u02b5\u02bf\u0001\u0000"+
		"\u0000\u0000\u02b6\u02b7\u00050\u0000\u0000\u02b7\u02b8\u0003x<\u0000"+
		"\u02b8\u02b9\u0005\"\u0000\u0000\u02b9\u02bf\u0001\u0000\u0000\u0000\u02ba"+
		"\u02bb\u00051\u0000\u0000\u02bb\u02bc\u0003x<\u0000\u02bc\u02bd\u0005"+
		"\"\u0000\u0000\u02bd\u02bf\u0001\u0000\u0000\u0000\u02be\u02ae\u0001\u0000"+
		"\u0000\u0000\u02be\u02b2\u0001\u0000\u0000\u0000\u02be\u02b6\u0001\u0000"+
		"\u0000\u0000\u02be\u02ba\u0001\u0000\u0000\u0000\u02bf\u007f\u0001\u0000"+
		"\u0000\u00008\u0083\u0089\u0096\u009b\u00a2\u00a7\u00aa\u00b6\u00bb\u00be"+
		"\u00c7\u00ce\u00d9\u00df\u00e9\u00f4\u0105\u0113\u011b\u0121\u012b\u0135"+
		"\u013c\u0144\u0148\u0155\u015e\u0165\u0169\u0171\u017a\u018d\u019a\u01a3"+
		"\u01b0\u01bb\u01e4\u01f4\u0204\u020e\u0210\u021d\u0229\u0234\u0239\u0251"+
		"\u0260\u0274\u0276\u027f\u0289\u0295\u029b\u02a8\u02ac\u02be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}