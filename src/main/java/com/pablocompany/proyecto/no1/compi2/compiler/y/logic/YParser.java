// Generated from YParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.y.logic;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class YParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, COMMENT=3, BLOCK_COMMENT=4, NEWLINE=5, WS=6, STRUCTURES_REGION=7, 
		FUNCTION_REGION=8, LAMBDA=9, PRINT=10, READ=11, DEFINE=12, STRUCT=13, 
		IF=14, ELSE_IF=15, ELSE=16, SO=17, SWITCH=18, CASE=19, BREAK=20, ALWAYS=21, 
		FOR=22, WHILE=23, DO=24, RETURN=25, CONTINUE=26, INTEGER=27, STRING=28, 
		FLOAT=29, CHARACTER=30, BOOLEAN=31, TRUE=32, FALSE=33, EQUAL=34, COMMA=35, 
		DOT_COMMA=36, TWO_POINTS=37, DOT=38, INIT_BRACE=39, FINAL_BRACE=40, INIT_BRACKET=41, 
		FINAL_BRACKET=42, INIT_PARENT=43, FINAL_PARENT=44, BY_ONE_ADD=45, BY_ONE_MINUS=46, 
		BY_ONE_MULTIPLICATION=47, BY_ONE_DIVISION=48, BY_ONE_PERCENT=49, ABREV_PLUS=50, 
		ABREV_MINUS=51, PLUS=52, MINUS=53, MULTIPLICATION=54, DIVIDE=55, PERCENT=56, 
		EQUALS=57, GREATER_EQUALS=58, LESS_EQUALS=59, DIFERENCE=60, LESS=61, GREATER=62, 
		AND=63, OR=64, NOT=65, ID=66, INT=67, DECIMAL=68, TEXT=69, CHAR=70, ERROR_TOKEN=71;
	public static final int
		RULE_program = 0, RULE_structures_region = 1, RULE_struct_declaration = 2, 
		RULE_struct_field = 3, RULE_functions_region = 4, RULE_function_declaration = 5, 
		RULE_parameter_list = 6, RULE_parameter = 7, RULE_statement = 8, RULE_block_statement = 9, 
		RULE_if_statement = 10, RULE_else_if_list = 11, RULE_else_if_clause = 12, 
		RULE_else_block = 13, RULE_switch_statement = 14, RULE_switch_case = 15, 
		RULE_always_case = 16, RULE_while_statement = 17, RULE_do_while_statement = 18, 
		RULE_for_statement = 19, RULE_for_init = 20, RULE_for_update = 21, RULE_loop_control = 22, 
		RULE_console_actions = 23, RULE_read_call = 24, RULE_abbreviated_operation = 25, 
		RULE_compound_assignment = 26, RULE_assignment = 27, RULE_nest_variable = 28, 
		RULE_object_values = 29, RULE_arguments_list = 30, RULE_array_literal = 31, 
		RULE_array_values = 32, RULE_variable_declaration = 33, RULE_type = 34, 
		RULE_expression = 35, RULE_normal_values = 36, RULE_boolean_values = 37, 
		RULE_expression_list = 38, RULE_skip_lines = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "structures_region", "struct_declaration", "struct_field", 
			"functions_region", "function_declaration", "parameter_list", "parameter", 
			"statement", "block_statement", "if_statement", "else_if_list", "else_if_clause", 
			"else_block", "switch_statement", "switch_case", "always_case", "while_statement", 
			"do_while_statement", "for_statement", "for_init", "for_update", "loop_control", 
			"console_actions", "read_call", "abbreviated_operation", "compound_assignment", 
			"assignment", "nest_variable", "object_values", "arguments_list", "array_literal", 
			"array_values", "variable_declaration", "type", "expression", "normal_values", 
			"boolean_values", "expression_list", "skip_lines"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, "'%estructuras'", "'%funciones'", 
			"'->'", "'imprimir'", "'leer'", "'definir'", "'estructura'", "'si'", 
			"'sino'", "'contrario'", "'entonces'", "'elegir'", "'caso'", "'romper'", 
			"'siempre'", "'para'", "'mientras'", "'hacer'", "'retornar'", "'continuar'", 
			"'entero'", "'cadena'", "'flotante'", "'caracter'", "'bool'", "'verdadero'", 
			"'falso'", "'='", "','", "';'", "':'", "'.'", "'{'", "'}'", "'['", "']'", 
			"'('", "')'", "'+='", "'-='", "'*='", "'/='", "'%='", "'++'", "'--'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'>='", "'<='", "'!='", "'<'", 
			"'>'", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "COMMENT", "BLOCK_COMMENT", "NEWLINE", "WS", 
			"STRUCTURES_REGION", "FUNCTION_REGION", "LAMBDA", "PRINT", "READ", "DEFINE", 
			"STRUCT", "IF", "ELSE_IF", "ELSE", "SO", "SWITCH", "CASE", "BREAK", "ALWAYS", 
			"FOR", "WHILE", "DO", "RETURN", "CONTINUE", "INTEGER", "STRING", "FLOAT", 
			"CHARACTER", "BOOLEAN", "TRUE", "FALSE", "EQUAL", "COMMA", "DOT_COMMA", 
			"TWO_POINTS", "DOT", "INIT_BRACE", "FINAL_BRACE", "INIT_BRACKET", "FINAL_BRACKET", 
			"INIT_PARENT", "FINAL_PARENT", "BY_ONE_ADD", "BY_ONE_MINUS", "BY_ONE_MULTIPLICATION", 
			"BY_ONE_DIVISION", "BY_ONE_PERCENT", "ABREV_PLUS", "ABREV_MINUS", "PLUS", 
			"MINUS", "MULTIPLICATION", "DIVIDE", "PERCENT", "EQUALS", "GREATER_EQUALS", 
			"LESS_EQUALS", "DIFERENCE", "LESS", "GREATER", "AND", "OR", "NOT", "ID", 
			"INT", "DECIMAL", "TEXT", "CHAR", "ERROR_TOKEN"
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
	public String getGrammarFileName() { return "YParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public YParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Functions_regionContext functions_region() {
			return getRuleContext(Functions_regionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(YParser.EOF, 0); }
		public List<Skip_linesContext> skip_lines() {
			return getRuleContexts(Skip_linesContext.class);
		}
		public Skip_linesContext skip_lines(int i) {
			return getRuleContext(Skip_linesContext.class,i);
		}
		public Structures_regionContext structures_region() {
			return getRuleContext(Structures_regionContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(80);
				skip_lines();
				}
			}

			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRUCTURES_REGION) {
				{
				setState(83);
				structures_region();
				}
			}

			setState(86);
			functions_region();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(87);
				skip_lines();
				}
			}

			setState(90);
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
	public static class Structures_regionContext extends ParserRuleContext {
		public Structures_regionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structures_region; }
	 
		public Structures_regionContext() { }
		public void copyFrom(Structures_regionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructRegionDeclarationContext extends Structures_regionContext {
		public TerminalNode STRUCTURES_REGION() { return getToken(YParser.STRUCTURES_REGION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public List<Struct_declarationContext> struct_declaration() {
			return getRuleContexts(Struct_declarationContext.class);
		}
		public Struct_declarationContext struct_declaration(int i) {
			return getRuleContext(Struct_declarationContext.class,i);
		}
		public StructRegionDeclarationContext(Structures_regionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStructRegionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStructRegionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStructRegionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Structures_regionContext structures_region() throws RecognitionException {
		Structures_regionContext _localctx = new Structures_regionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_structures_region);
		int _la;
		try {
			_localctx = new StructRegionDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(STRUCTURES_REGION);
			setState(94); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(93);
				match(NEWLINE);
				}
				}
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRUCT) {
				{
				{
				setState(98);
				struct_declaration();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		public TerminalNode STRUCT() { return getToken(YParser.STRUCT, 0); }
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode TWO_POINTS() { return getToken(YParser.TWO_POINTS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<Struct_fieldContext> struct_field() {
			return getRuleContexts(Struct_fieldContext.class);
		}
		public Struct_fieldContext struct_field(int i) {
			return getRuleContext(Struct_fieldContext.class,i);
		}
		public Skip_linesContext skip_lines() {
			return getRuleContext(Skip_linesContext.class,0);
		}
		public StructDeclarationContext(Struct_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_struct_declaration);
		int _la;
		try {
			_localctx = new StructDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(STRUCT);
			setState(105);
			match(ID);
			setState(106);
			match(TWO_POINTS);
			setState(107);
			match(NEWLINE);
			setState(108);
			match(INDENT);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 549755813919L) != 0)) {
				{
				{
				setState(109);
				struct_field();
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(115);
			match(DEDENT);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(116);
				skip_lines();
				}
			}

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
	public static class Struct_fieldContext extends ParserRuleContext {
		public Struct_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_field; }
	 
		public Struct_fieldContext() { }
		public void copyFrom(Struct_fieldContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructArrayPropertyContext extends Struct_fieldContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode INIT_BRACKET() { return getToken(YParser.INIT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(YParser.FINAL_BRACKET, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public StructArrayPropertyContext(Struct_fieldContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStructArrayProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStructArrayProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStructArrayProperty(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructNormalPropertyContext extends Struct_fieldContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public StructNormalPropertyContext(Struct_fieldContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStructNormalProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStructNormalProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStructNormalProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_fieldContext struct_field() throws RecognitionException {
		Struct_fieldContext _localctx = new Struct_fieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_struct_field);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new StructNormalPropertyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				type();
				setState(120);
				match(ID);
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(121);
					match(NEWLINE);
					}
					}
					setState(124); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case 2:
				_localctx = new StructArrayPropertyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				type();
				setState(127);
				match(ID);
				setState(128);
				match(INIT_BRACKET);
				setState(129);
				expression(0);
				setState(130);
				match(FINAL_BRACKET);
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(131);
					match(NEWLINE);
					}
					}
					setState(134); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
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
	public static class Functions_regionContext extends ParserRuleContext {
		public Functions_regionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_region; }
	 
		public Functions_regionContext() { }
		public void copyFrom(Functions_regionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionSectionContext extends Functions_regionContext {
		public TerminalNode FUNCTION_REGION() { return getToken(YParser.FUNCTION_REGION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public List<Function_declarationContext> function_declaration() {
			return getRuleContexts(Function_declarationContext.class);
		}
		public Function_declarationContext function_declaration(int i) {
			return getRuleContext(Function_declarationContext.class,i);
		}
		public FunctionSectionContext(Functions_regionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterFunctionSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitFunctionSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitFunctionSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Functions_regionContext functions_region() throws RecognitionException {
		Functions_regionContext _localctx = new Functions_regionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functions_region);
		int _la;
		try {
			int _alt;
			_localctx = new FunctionSectionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(FUNCTION_REGION);
			setState(140); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(139);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(142); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE) {
				{
				{
				setState(144);
				function_declaration();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		public TerminalNode DEFINE() { return getToken(YParser.DEFINE, 0); }
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public TerminalNode TWO_POINTS() { return getToken(YParser.TWO_POINTS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public TerminalNode LAMBDA() { return getToken(YParser.LAMBDA, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Skip_linesContext skip_lines() {
			return getRuleContext(Skip_linesContext.class,0);
		}
		public FunctionDeclarationContext(Function_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_declaration);
		int _la;
		try {
			_localctx = new FunctionDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(DEFINE);
			setState(151);
			match(ID);
			setState(152);
			match(INIT_PARENT);
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 549755834399L) != 0)) {
				{
				setState(153);
				parameter_list();
				}
			}

			setState(156);
			match(FINAL_PARENT);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LAMBDA) {
				{
				setState(157);
				match(LAMBDA);
				setState(158);
				type();
				}
			}

			setState(161);
			match(TWO_POINTS);
			setState(162);
			match(NEWLINE);
			setState(163);
			match(INDENT);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(164);
				statement();
				}
				}
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(170);
			match(DEDENT);
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(171);
				skip_lines();
				}
				break;
			}
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
	public static class Parameter_listContext extends ParserRuleContext {
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
	 
		public Parameter_listContext() { }
		public void copyFrom(Parameter_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends Parameter_listContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(YParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(YParser.COMMA, i);
		}
		public ParameterListContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter_list);
		int _la;
		try {
			_localctx = new ParameterListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			parameter();
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(175);
				match(COMMA);
				setState(176);
				parameter();
				}
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class ParameterContext extends ParserRuleContext {
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	 
		public ParameterContext() { }
		public void copyFrom(ParameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructParameterContext extends ParameterContext {
		public TerminalNode INIT_BRACE() { return getToken(YParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(YParser.FINAL_BRACE, 0); }
		public List<TerminalNode> ID() { return getTokens(YParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YParser.ID, i);
		}
		public StructParameterContext(ParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStructParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStructParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStructParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayParameterContext extends ParameterContext {
		public TerminalNode INIT_BRACKET() { return getToken(YParser.INIT_BRACKET, 0); }
		public TerminalNode FINAL_BRACKET() { return getToken(YParser.FINAL_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public ArrayParameterContext(ParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterArrayParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitArrayParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitArrayParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveParameterContext extends ParameterContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public PrimitiveParameterContext(ParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterPrimitiveParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitPrimitiveParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitPrimitiveParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case STRING:
			case FLOAT:
			case CHARACTER:
			case BOOLEAN:
			case ID:
				_localctx = new PrimitiveParameterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				type();
				setState(183);
				match(ID);
				}
				break;
			case INIT_BRACKET:
				_localctx = new ArrayParameterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				match(INIT_BRACKET);
				setState(186);
				match(FINAL_BRACKET);
				setState(187);
				type();
				setState(188);
				match(ID);
				}
				break;
			case INIT_BRACE:
				_localctx = new StructParameterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				match(INIT_BRACE);
				setState(191);
				match(FINAL_BRACE);
				setState(192);
				match(ID);
				setState(193);
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
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementConsoleActionContext extends StatementContext {
		public Console_actionsContext console_actions() {
			return getRuleContext(Console_actionsContext.class,0);
		}
		public StatementConsoleActionContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStatementConsoleAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStatementConsoleAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStatementConsoleAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementCompoundAssignmentContext extends StatementContext {
		public Compound_assignmentContext compound_assignment() {
			return getRuleContext(Compound_assignmentContext.class,0);
		}
		public StatementCompoundAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStatementCompoundAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStatementCompoundAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStatementCompoundAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementStructDeclarationContext extends StatementContext {
		public Struct_declarationContext struct_declaration() {
			return getRuleContext(Struct_declarationContext.class,0);
		}
		public StatementStructDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStatementStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStatementStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStatementStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementLoopControlContext extends StatementContext {
		public Loop_controlContext loop_control() {
			return getRuleContext(Loop_controlContext.class,0);
		}
		public StatementLoopControlContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStatementLoopControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStatementLoopControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStatementLoopControl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(YParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationStatementContext extends StatementContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public VariableDeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitVariableDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitVariableDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementAbbreviatedOperationContext extends StatementContext {
		public Abbreviated_operationContext abbreviated_operation() {
			return getRuleContext(Abbreviated_operationContext.class,0);
		}
		public StatementAbbreviatedOperationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStatementAbbreviatedOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStatementAbbreviatedOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStatementAbbreviatedOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementBlockContext extends StatementContext {
		public Block_statementContext block_statement() {
			return getRuleContext(Block_statementContext.class,0);
		}
		public StatementBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentVariableStatementContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public AssignmentVariableStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterAssignmentVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitAssignmentVariableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitAssignmentVariableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new StatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				block_statement();
				}
				break;
			case 2:
				_localctx = new StatementConsoleActionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				console_actions();
				}
				break;
			case 3:
				_localctx = new StatementLoopControlContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				loop_control();
				}
				break;
			case 4:
				_localctx = new StatementAbbreviatedOperationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				abbreviated_operation();
				}
				break;
			case 5:
				_localctx = new StatementCompoundAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(200);
				compound_assignment();
				}
				break;
			case 6:
				_localctx = new StatementStructDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(201);
				struct_declaration();
				}
				break;
			case 7:
				_localctx = new VariableDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(202);
				variable_declaration();
				setState(204); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(203);
					match(NEWLINE);
					}
					}
					setState(206); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case 8:
				_localctx = new AssignmentVariableStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(208);
				assignment();
				setState(210); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(209);
					match(NEWLINE);
					}
					}
					setState(212); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case 9:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(214);
				match(RETURN);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & 1134911508713570305L) != 0)) {
					{
					setState(215);
					expression(0);
					}
				}

				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(218);
					match(NEWLINE);
					}
					}
					setState(221); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
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
	public static class Block_statementContext extends ParserRuleContext {
		public Block_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_statement; }
	 
		public Block_statementContext() { }
		public void copyFrom(Block_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockForContext extends Block_statementContext {
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public BlockForContext(Block_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBlockFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBlockFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBlockFor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockDoWhileContext extends Block_statementContext {
		public Do_while_statementContext do_while_statement() {
			return getRuleContext(Do_while_statementContext.class,0);
		}
		public BlockDoWhileContext(Block_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBlockDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBlockDoWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBlockDoWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockIfContext extends Block_statementContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public BlockIfContext(Block_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBlockIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBlockIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBlockIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockSwitchContext extends Block_statementContext {
		public Switch_statementContext switch_statement() {
			return getRuleContext(Switch_statementContext.class,0);
		}
		public BlockSwitchContext(Block_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBlockSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBlockSwitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBlockSwitch(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockWhileContext extends Block_statementContext {
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public BlockWhileContext(Block_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBlockWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBlockWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBlockWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_statementContext block_statement() throws RecognitionException {
		Block_statementContext _localctx = new Block_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_block_statement);
		try {
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new BlockIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				if_statement();
				}
				break;
			case SWITCH:
				_localctx = new BlockSwitchContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				switch_statement();
				}
				break;
			case WHILE:
				_localctx = new BlockWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				while_statement();
				}
				break;
			case DO:
				_localctx = new BlockDoWhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				do_while_statement();
				}
				break;
			case FOR:
				_localctx = new BlockForContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(229);
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
		public TerminalNode IF() { return getToken(YParser.IF, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public TerminalNode SO() { return getToken(YParser.SO, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Else_if_listContext else_if_list() {
			return getRuleContext(Else_if_listContext.class,0);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public IfStatementContext(If_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_if_statement);
		int _la;
		try {
			_localctx = new IfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(IF);
			setState(233);
			match(INIT_PARENT);
			setState(234);
			expression(0);
			setState(235);
			match(FINAL_PARENT);
			setState(236);
			match(SO);
			setState(237);
			match(NEWLINE);
			setState(238);
			match(INDENT);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(239);
				statement();
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(245);
			match(DEDENT);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE_IF) {
				{
				setState(246);
				else_if_list();
				}
			}

			setState(250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(249);
				else_block();
				}
			}

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
	public static class ElseIfListContext extends Else_if_listContext {
		public List<Else_if_clauseContext> else_if_clause() {
			return getRuleContexts(Else_if_clauseContext.class);
		}
		public Else_if_clauseContext else_if_clause(int i) {
			return getRuleContext(Else_if_clauseContext.class,i);
		}
		public ElseIfListContext(Else_if_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterElseIfList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitElseIfList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitElseIfList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_listContext else_if_list() throws RecognitionException {
		Else_if_listContext _localctx = new Else_if_listContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_else_if_list);
		int _la;
		try {
			_localctx = new ElseIfListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(253); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(252);
				else_if_clause();
				}
				}
				setState(255); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ELSE_IF );
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
		public TerminalNode ELSE_IF() { return getToken(YParser.ELSE_IF, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public TerminalNode SO() { return getToken(YParser.SO, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseIfClauseContext(Else_if_clauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterElseIfClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitElseIfClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitElseIfClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_clauseContext else_if_clause() throws RecognitionException {
		Else_if_clauseContext _localctx = new Else_if_clauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_else_if_clause);
		int _la;
		try {
			_localctx = new ElseIfClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(ELSE_IF);
			setState(258);
			match(INIT_PARENT);
			setState(259);
			expression(0);
			setState(260);
			match(FINAL_PARENT);
			setState(261);
			match(SO);
			setState(262);
			match(NEWLINE);
			setState(263);
			match(INDENT);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(264);
				statement();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			match(DEDENT);
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
	public static class Else_blockContext extends ParserRuleContext {
		public Else_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_block; }
	 
		public Else_blockContext() { }
		public void copyFrom(Else_blockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseBlockContext extends Else_blockContext {
		public TerminalNode ELSE() { return getToken(YParser.ELSE, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseBlockContext(Else_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_blockContext else_block() throws RecognitionException {
		Else_blockContext _localctx = new Else_blockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_else_block);
		int _la;
		try {
			_localctx = new ElseBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(ELSE);
			setState(273);
			match(NEWLINE);
			setState(274);
			match(INDENT);
			setState(278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(275);
				statement();
				}
				}
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(281);
			match(DEDENT);
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
	public static class Switch_statementContext extends ParserRuleContext {
		public Switch_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_statement; }
	 
		public Switch_statementContext() { }
		public void copyFrom(Switch_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends Switch_statementContext {
		public TerminalNode SWITCH() { return getToken(YParser.SWITCH, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public TerminalNode TWO_POINTS() { return getToken(YParser.TWO_POINTS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<Switch_caseContext> switch_case() {
			return getRuleContexts(Switch_caseContext.class);
		}
		public Switch_caseContext switch_case(int i) {
			return getRuleContext(Switch_caseContext.class,i);
		}
		public Always_caseContext always_case() {
			return getRuleContext(Always_caseContext.class,0);
		}
		public SwitchStatementContext(Switch_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_statementContext switch_statement() throws RecognitionException {
		Switch_statementContext _localctx = new Switch_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_switch_statement);
		int _la;
		try {
			_localctx = new SwitchStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(SWITCH);
			setState(284);
			match(INIT_PARENT);
			setState(285);
			expression(0);
			setState(286);
			match(FINAL_PARENT);
			setState(287);
			match(TWO_POINTS);
			setState(288);
			match(NEWLINE);
			setState(289);
			match(INDENT);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(290);
				switch_case();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALWAYS) {
				{
				setState(296);
				always_case();
				}
			}

			setState(299);
			match(DEDENT);
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
	public static class Switch_caseContext extends ParserRuleContext {
		public Switch_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_case; }
	 
		public Switch_caseContext() { }
		public void copyFrom(Switch_caseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchCaseContext extends Switch_caseContext {
		public TerminalNode CASE() { return getToken(YParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TWO_POINTS() { return getToken(YParser.TWO_POINTS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchCaseContext(Switch_caseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSwitchCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSwitchCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_caseContext switch_case() throws RecognitionException {
		Switch_caseContext _localctx = new Switch_caseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_switch_case);
		int _la;
		try {
			_localctx = new SwitchCaseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(CASE);
			setState(302);
			expression(0);
			setState(303);
			match(TWO_POINTS);
			setState(304);
			match(NEWLINE);
			setState(305);
			match(INDENT);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(306);
				statement();
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(312);
			match(DEDENT);
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
	public static class Always_caseContext extends ParserRuleContext {
		public Always_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_always_case; }
	 
		public Always_caseContext() { }
		public void copyFrom(Always_caseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AlwaysCaseContext extends Always_caseContext {
		public TerminalNode ALWAYS() { return getToken(YParser.ALWAYS, 0); }
		public TerminalNode TWO_POINTS() { return getToken(YParser.TWO_POINTS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public AlwaysCaseContext(Always_caseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterAlwaysCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitAlwaysCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitAlwaysCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Always_caseContext always_case() throws RecognitionException {
		Always_caseContext _localctx = new Always_caseContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_always_case);
		int _la;
		try {
			_localctx = new AlwaysCaseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(ALWAYS);
			setState(315);
			match(TWO_POINTS);
			setState(316);
			match(NEWLINE);
			setState(317);
			match(INDENT);
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(318);
				statement();
				}
				}
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(324);
			match(DEDENT);
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
		public TerminalNode WHILE() { return getToken(YParser.WHILE, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public TerminalNode DO() { return getToken(YParser.DO, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(While_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_while_statement);
		int _la;
		try {
			_localctx = new WhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(WHILE);
			setState(327);
			match(INIT_PARENT);
			setState(328);
			expression(0);
			setState(329);
			match(FINAL_PARENT);
			setState(330);
			match(DO);
			setState(331);
			match(NEWLINE);
			setState(332);
			match(INDENT);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(333);
				statement();
				}
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(339);
			match(DEDENT);
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
		public TerminalNode DO() { return getToken(YParser.DO, 0); }
		public TerminalNode TWO_POINTS() { return getToken(YParser.TWO_POINTS, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public TerminalNode WHILE() { return getToken(YParser.WHILE, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DoWhileStatementContext(Do_while_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_while_statementContext do_while_statement() throws RecognitionException {
		Do_while_statementContext _localctx = new Do_while_statementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_do_while_statement);
		int _la;
		try {
			_localctx = new DoWhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			match(DO);
			setState(342);
			match(TWO_POINTS);
			setState(343);
			match(NEWLINE);
			setState(344);
			match(INDENT);
			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(345);
				statement();
				}
				}
				setState(350);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(351);
			match(DEDENT);
			setState(352);
			match(WHILE);
			setState(353);
			match(INIT_PARENT);
			setState(354);
			expression(0);
			setState(355);
			match(FINAL_PARENT);
			setState(357); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(356);
				match(NEWLINE);
				}
				}
				setState(359); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
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
		public TerminalNode FOR() { return getToken(YParser.FOR, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public List<TerminalNode> DOT_COMMA() { return getTokens(YParser.DOT_COMMA); }
		public TerminalNode DOT_COMMA(int i) {
			return getToken(YParser.DOT_COMMA, i);
		}
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public TerminalNode TWO_POINTS() { return getToken(YParser.TWO_POINTS, 0); }
		public TerminalNode NEWLINE() { return getToken(YParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(YParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(YParser.DEDENT, 0); }
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public For_updateContext for_update() {
			return getRuleContext(For_updateContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStatementContext(For_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_for_statement);
		int _la;
		try {
			_localctx = new ForStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(FOR);
			setState(362);
			match(INIT_PARENT);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 549755813919L) != 0)) {
				{
				setState(363);
				for_init();
				}
			}

			setState(366);
			match(DOT_COMMA);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & 1134911508713570305L) != 0)) {
				{
				setState(367);
				expression(0);
				}
			}

			setState(370);
			match(DOT_COMMA);
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 50)) & ~0x3f) == 0 && ((1L << (_la - 50)) & 65539L) != 0)) {
				{
				setState(371);
				for_update();
				}
			}

			setState(374);
			match(FINAL_PARENT);
			setState(375);
			match(TWO_POINTS);
			setState(376);
			match(NEWLINE);
			setState(377);
			match(INDENT);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & 72060892577002779L) != 0)) {
				{
				{
				setState(378);
				statement();
				}
				}
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(384);
			match(DEDENT);
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
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(YParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitAssignContext(For_initContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterForInitAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitForInitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitForInitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForInitVarDeclContext extends For_initContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(YParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitVarDeclContext(For_initContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterForInitVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitForInitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitForInitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_for_init);
		try {
			setState(395);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new ForInitVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				type();
				setState(387);
				match(ID);
				setState(388);
				match(EQUAL);
				setState(389);
				expression(0);
				}
				break;
			case 2:
				_localctx = new ForInitAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(391);
				nest_variable();
				setState(392);
				match(EQUAL);
				setState(393);
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
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_MINUS() { return getToken(YParser.ABREV_MINUS, 0); }
		public ForUpdateDecrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterForUpdateDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitForUpdateDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitForUpdateDecrement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdatePrefixDecrementContext extends For_updateContext {
		public TerminalNode ABREV_MINUS() { return getToken(YParser.ABREV_MINUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public ForUpdatePrefixDecrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterForUpdatePrefixDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitForUpdatePrefixDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitForUpdatePrefixDecrement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdatePrefixIncrementContext extends For_updateContext {
		public TerminalNode ABREV_PLUS() { return getToken(YParser.ABREV_PLUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public ForUpdatePrefixIncrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterForUpdatePrefixIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitForUpdatePrefixIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitForUpdatePrefixIncrement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateAssignContext extends For_updateContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(YParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateAssignContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterForUpdateAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitForUpdateAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitForUpdateAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateIncrementContext extends For_updateContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_PLUS() { return getToken(YParser.ABREV_PLUS, 0); }
		public ForUpdateIncrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterForUpdateIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitForUpdateIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitForUpdateIncrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_updateContext for_update() throws RecognitionException {
		For_updateContext _localctx = new For_updateContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_for_update);
		try {
			setState(411);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				_localctx = new ForUpdateIncrementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				nest_variable();
				setState(398);
				match(ABREV_PLUS);
				}
				break;
			case 2:
				_localctx = new ForUpdateDecrementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				nest_variable();
				setState(401);
				match(ABREV_MINUS);
				}
				break;
			case 3:
				_localctx = new ForUpdatePrefixIncrementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(403);
				match(ABREV_PLUS);
				setState(404);
				nest_variable();
				}
				break;
			case 4:
				_localctx = new ForUpdatePrefixDecrementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(405);
				match(ABREV_MINUS);
				setState(406);
				nest_variable();
				}
				break;
			case 5:
				_localctx = new ForUpdateAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(407);
				nest_variable();
				setState(408);
				match(EQUAL);
				setState(409);
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
		public TerminalNode CONTINUE() { return getToken(YParser.CONTINUE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public LoopContinueContext(Loop_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterLoopContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitLoopContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitLoopContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopBreakContext extends Loop_controlContext {
		public TerminalNode BREAK() { return getToken(YParser.BREAK, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public LoopBreakContext(Loop_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterLoopBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitLoopBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitLoopBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_controlContext loop_control() throws RecognitionException {
		Loop_controlContext _localctx = new Loop_controlContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_loop_control);
		int _la;
		try {
			setState(425);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTINUE:
				_localctx = new LoopContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				match(CONTINUE);
				setState(415); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(414);
					match(NEWLINE);
					}
					}
					setState(417); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case BREAK:
				_localctx = new LoopBreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(419);
				match(BREAK);
				setState(421); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(420);
					match(NEWLINE);
					}
					}
					setState(423); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
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
	public static class PrintActionContext extends Console_actionsContext {
		public TerminalNode PRINT() { return getToken(YParser.PRINT, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public PrintActionContext(Console_actionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterPrintAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitPrintAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitPrintAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadActionContext extends Console_actionsContext {
		public Read_callContext read_call() {
			return getRuleContext(Read_callContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public ReadActionContext(Console_actionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterReadAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitReadAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitReadAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Console_actionsContext console_actions() throws RecognitionException {
		Console_actionsContext _localctx = new Console_actionsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_console_actions);
		int _la;
		try {
			setState(442);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				_localctx = new PrintActionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(427);
				match(PRINT);
				setState(428);
				match(INIT_PARENT);
				setState(429);
				expression(0);
				setState(430);
				match(FINAL_PARENT);
				setState(432); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(431);
					match(NEWLINE);
					}
					}
					setState(434); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case READ:
				_localctx = new ReadActionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				read_call();
				setState(438); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(437);
					match(NEWLINE);
					}
					}
					setState(440); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
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
	public static class Read_callContext extends ParserRuleContext {
		public Read_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_call; }
	 
		public Read_callContext() { }
		public void copyFrom(Read_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadCallContext extends Read_callContext {
		public TerminalNode READ() { return getToken(YParser.READ, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public ReadCallContext(Read_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterReadCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitReadCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitReadCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_callContext read_call() throws RecognitionException {
		Read_callContext _localctx = new Read_callContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_read_call);
		try {
			_localctx = new ReadCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(READ);
			setState(445);
			match(INIT_PARENT);
			setState(446);
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
	public static class DecPrefixOperationContext extends Abbreviated_operationContext {
		public TerminalNode ABREV_MINUS() { return getToken(YParser.ABREV_MINUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public DecPrefixOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDecPrefixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDecPrefixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDecPrefixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncPrefixOperationContext extends Abbreviated_operationContext {
		public TerminalNode ABREV_PLUS() { return getToken(YParser.ABREV_PLUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public IncPrefixOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterIncPrefixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitIncPrefixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitIncPrefixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncSufixOperationContext extends Abbreviated_operationContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_PLUS() { return getToken(YParser.ABREV_PLUS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public IncSufixOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterIncSufixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitIncSufixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitIncSufixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecSufixOperationContext extends Abbreviated_operationContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_MINUS() { return getToken(YParser.ABREV_MINUS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public DecSufixOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDecSufixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDecSufixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDecSufixOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Abbreviated_operationContext abbreviated_operation() throws RecognitionException {
		Abbreviated_operationContext _localctx = new Abbreviated_operationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_abbreviated_operation);
		try {
			setState(464);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				_localctx = new IncSufixOperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				nest_variable();
				setState(449);
				match(ABREV_PLUS);
				setState(450);
				match(DOT_COMMA);
				}
				break;
			case 2:
				_localctx = new DecSufixOperationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				nest_variable();
				setState(453);
				match(ABREV_MINUS);
				setState(454);
				match(DOT_COMMA);
				}
				break;
			case 3:
				_localctx = new IncPrefixOperationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
				match(ABREV_PLUS);
				setState(457);
				nest_variable();
				setState(458);
				match(DOT_COMMA);
				}
				break;
			case 4:
				_localctx = new DecPrefixOperationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(460);
				match(ABREV_MINUS);
				setState(461);
				nest_variable();
				setState(462);
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
	public static class Compound_assignmentContext extends ParserRuleContext {
		public Compound_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_assignment; }
	 
		public Compound_assignmentContext() { }
		public void copyFrom(Compound_assignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundDivAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_DIVISION() { return getToken(YParser.BY_ONE_DIVISION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public CompoundDivAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCompoundDivAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCompoundDivAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCompoundDivAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundModAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_PERCENT() { return getToken(YParser.BY_ONE_PERCENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public CompoundModAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCompoundModAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCompoundModAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCompoundModAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundSubAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_MINUS() { return getToken(YParser.BY_ONE_MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public CompoundSubAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCompoundSubAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCompoundSubAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCompoundSubAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundMulAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_MULTIPLICATION() { return getToken(YParser.BY_ONE_MULTIPLICATION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public CompoundMulAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCompoundMulAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCompoundMulAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCompoundMulAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundAddAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_ADD() { return getToken(YParser.BY_ONE_ADD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(YParser.DOT_COMMA, 0); }
		public CompoundAddAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCompoundAddAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCompoundAddAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCompoundAddAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_assignmentContext compound_assignment() throws RecognitionException {
		Compound_assignmentContext _localctx = new Compound_assignmentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_compound_assignment);
		try {
			setState(491);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				_localctx = new CompoundAddAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				nest_variable();
				setState(467);
				match(BY_ONE_ADD);
				setState(468);
				expression(0);
				setState(469);
				match(DOT_COMMA);
				}
				break;
			case 2:
				_localctx = new CompoundSubAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(471);
				nest_variable();
				setState(472);
				match(BY_ONE_MINUS);
				setState(473);
				expression(0);
				setState(474);
				match(DOT_COMMA);
				}
				break;
			case 3:
				_localctx = new CompoundMulAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(476);
				nest_variable();
				setState(477);
				match(BY_ONE_MULTIPLICATION);
				setState(478);
				expression(0);
				setState(479);
				match(DOT_COMMA);
				}
				break;
			case 4:
				_localctx = new CompoundDivAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(481);
				nest_variable();
				setState(482);
				match(BY_ONE_DIVISION);
				setState(483);
				expression(0);
				setState(484);
				match(DOT_COMMA);
				}
				break;
			case 5:
				_localctx = new CompoundModAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(486);
				nest_variable();
				setState(487);
				match(BY_ONE_PERCENT);
				setState(488);
				expression(0);
				setState(489);
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
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssingmentStatementContext extends AssignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(YParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssingmentStatementContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterAssingmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitAssingmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitAssingmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assignment);
		try {
			_localctx = new AssingmentStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			nest_variable();
			setState(494);
			match(EQUAL);
			setState(495);
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
	public static class NestedVariableContext extends Nest_variableContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public NestedVariableContext(Nest_variableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterNestedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitNestedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitNestedVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nest_variableContext nest_variable() throws RecognitionException {
		Nest_variableContext _localctx = new Nest_variableContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_nest_variable);
		try {
			_localctx = new NestedVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			object_values(0);
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
	public static class Object_valuesContext extends ParserRuleContext {
		public Object_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_values; }
	 
		public Object_valuesContext() { }
		public void copyFrom(Object_valuesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectArrayAccessChainContext extends Object_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode INIT_BRACKET() { return getToken(YParser.INIT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(YParser.FINAL_BRACKET, 0); }
		public ObjectArrayAccessChainContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterObjectArrayAccessChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitObjectArrayAccessChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitObjectArrayAccessChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectPropertyChainContext extends Object_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode DOT() { return getToken(YParser.DOT, 0); }
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public ObjectPropertyChainContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterObjectPropertyChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitObjectPropertyChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitObjectPropertyChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseFunctionCallContext extends Object_valuesContext {
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public BaseFunctionCallContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBaseFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBaseFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBaseFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseIdentifierContext extends Object_valuesContext {
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public BaseIdentifierContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBaseIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBaseIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBaseIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Object_valuesContext object_values() throws RecognitionException {
		return object_values(0);
	}

	private Object_valuesContext object_values(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Object_valuesContext _localctx = new Object_valuesContext(_ctx, _parentState);
		Object_valuesContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_object_values, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				_localctx = new BaseFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(500);
				match(ID);
				setState(501);
				match(INIT_PARENT);
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & 1134911508713570305L) != 0)) {
					{
					setState(502);
					arguments_list();
					}
				}

				setState(505);
				match(FINAL_PARENT);
				}
				break;
			case 2:
				{
				_localctx = new BaseIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(506);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(517);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new ObjectPropertyChainContext(new Object_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_object_values);
						setState(509);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(510);
						match(DOT);
						setState(511);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new ObjectArrayAccessChainContext(new Object_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_object_values);
						setState(512);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(513);
						match(INIT_BRACKET);
						setState(514);
						expression(0);
						setState(515);
						match(FINAL_BRACKET);
						}
						break;
					}
					} 
				}
				setState(521);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
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
	public static class ArgumentsListContext extends Arguments_listContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(YParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(YParser.COMMA, i);
		}
		public ArgumentsListContext(Arguments_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterArgumentsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitArgumentsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitArgumentsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arguments_listContext arguments_list() throws RecognitionException {
		Arguments_listContext _localctx = new Arguments_listContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arguments_list);
		int _la;
		try {
			_localctx = new ArgumentsListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(522);
			expression(0);
			setState(527);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(523);
				match(COMMA);
				setState(524);
				expression(0);
				}
				}
				setState(529);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Array_literalContext extends ParserRuleContext {
		public Array_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_literal; }
	 
		public Array_literalContext() { }
		public void copyFrom(Array_literalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLiteralValueContext extends Array_literalContext {
		public TerminalNode INIT_BRACE() { return getToken(YParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(YParser.FINAL_BRACE, 0); }
		public Array_valuesContext array_values() {
			return getRuleContext(Array_valuesContext.class,0);
		}
		public ArrayLiteralValueContext(Array_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterArrayLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitArrayLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitArrayLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literalContext array_literal() throws RecognitionException {
		Array_literalContext _localctx = new Array_literalContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_array_literal);
		int _la;
		try {
			_localctx = new ArrayLiteralValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(530);
			match(INIT_BRACE);
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & 1134911508713570305L) != 0)) {
				{
				setState(531);
				array_values();
				}
			}

			setState(534);
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
	public static class Array_valuesContext extends ParserRuleContext {
		public Array_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_values; }
	 
		public Array_valuesContext() { }
		public void copyFrom(Array_valuesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayValuesListContext extends Array_valuesContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(YParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(YParser.COMMA, i);
		}
		public ArrayValuesListContext(Array_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterArrayValuesList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitArrayValuesList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitArrayValuesList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_valuesContext array_values() throws RecognitionException {
		Array_valuesContext _localctx = new Array_valuesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_array_values);
		int _la;
		try {
			_localctx = new ArrayValuesListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			expression(0);
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(537);
				match(COMMA);
				setState(538);
				expression(0);
				}
				}
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class NotDefiniedVariableContext extends Variable_declarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public NotDefiniedVariableContext(Variable_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterNotDefiniedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitNotDefiniedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitNotDefiniedVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefiniedVariableContext extends Variable_declarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(YParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DefiniedVariableContext(Variable_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDefiniedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDefiniedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDefiniedVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotDefiniedArrayVariableContext extends Variable_declarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public List<TerminalNode> INIT_BRACKET() { return getTokens(YParser.INIT_BRACKET); }
		public TerminalNode INIT_BRACKET(int i) {
			return getToken(YParser.INIT_BRACKET, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> FINAL_BRACKET() { return getTokens(YParser.FINAL_BRACKET); }
		public TerminalNode FINAL_BRACKET(int i) {
			return getToken(YParser.FINAL_BRACKET, i);
		}
		public NotDefiniedArrayVariableContext(Variable_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterNotDefiniedArrayVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitNotDefiniedArrayVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitNotDefiniedArrayVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefiniedArrayVariableContext extends Variable_declarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(YParser.EQUAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> INIT_BRACKET() { return getTokens(YParser.INIT_BRACKET); }
		public TerminalNode INIT_BRACKET(int i) {
			return getToken(YParser.INIT_BRACKET, i);
		}
		public List<TerminalNode> FINAL_BRACKET() { return getTokens(YParser.FINAL_BRACKET); }
		public TerminalNode FINAL_BRACKET(int i) {
			return getToken(YParser.FINAL_BRACKET, i);
		}
		public DefiniedArrayVariableContext(Variable_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterDefiniedArrayVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitDefiniedArrayVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitDefiniedArrayVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_variable_declaration);
		int _la;
		try {
			setState(575);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				_localctx = new NotDefiniedVariableContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(544);
				type();
				setState(545);
				match(ID);
				}
				break;
			case 2:
				_localctx = new DefiniedVariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(547);
				type();
				setState(548);
				match(ID);
				setState(549);
				match(EQUAL);
				setState(550);
				expression(0);
				}
				break;
			case 3:
				_localctx = new NotDefiniedArrayVariableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(552);
				type();
				setState(553);
				match(ID);
				setState(558); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(554);
					match(INIT_BRACKET);
					setState(555);
					expression(0);
					setState(556);
					match(FINAL_BRACKET);
					}
					}
					setState(560); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INIT_BRACKET );
				}
				break;
			case 4:
				_localctx = new DefiniedArrayVariableContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(562);
				type();
				setState(563);
				match(ID);
				setState(568); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(564);
					match(INIT_BRACKET);
					setState(565);
					expression(0);
					setState(566);
					match(FINAL_BRACKET);
					}
					}
					setState(570); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==INIT_BRACKET );
				setState(572);
				match(EQUAL);
				setState(573);
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CustomTypeValueContext extends TypeContext {
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public CustomTypeValueContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCustomTypeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCustomTypeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCustomTypeValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanValueContext extends TypeContext {
		public TerminalNode BOOLEAN() { return getToken(YParser.BOOLEAN, 0); }
		public BooleanValueContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharValueContext extends TypeContext {
		public TerminalNode CHARACTER() { return getToken(YParser.CHARACTER, 0); }
		public CharValueContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCharValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCharValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCharValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatValueContext extends TypeContext {
		public TerminalNode FLOAT() { return getToken(YParser.FLOAT, 0); }
		public FloatValueContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterFloatValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitFloatValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitFloatValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringValueContext extends TypeContext {
		public TerminalNode STRING() { return getToken(YParser.STRING, 0); }
		public StringValueContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStringValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStringValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStringValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntValueContext extends TypeContext {
		public TerminalNode INTEGER() { return getToken(YParser.INTEGER, 0); }
		public IntValueContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterIntValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitIntValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitIntValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_type);
		try {
			setState(583);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new IntValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(577);
				match(INTEGER);
				}
				break;
			case STRING:
				_localctx = new StringValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(578);
				match(STRING);
				}
				break;
			case FLOAT:
				_localctx = new FloatValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(579);
				match(FLOAT);
				}
				break;
			case CHARACTER:
				_localctx = new CharValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(580);
				match(CHARACTER);
				}
				break;
			case BOOLEAN:
				_localctx = new BooleanValueContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(581);
				match(BOOLEAN);
				}
				break;
			case ID:
				_localctx = new CustomTypeValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(582);
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
		public TerminalNode INIT_PARENT() { return getToken(YParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(YParser.FINAL_PARENT, 0); }
		public ExpressionParentsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionParents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionParents(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionParents(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionUnaryContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(YParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(YParser.MINUS, 0); }
		public ExpressionUnaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionUnary(this);
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
		public TerminalNode EQUALS() { return getToken(YParser.EQUALS, 0); }
		public TerminalNode DIFERENCE() { return getToken(YParser.DIFERENCE, 0); }
		public ExpressionEqualityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionEquality(this);
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
		public TerminalNode LESS() { return getToken(YParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(YParser.GREATER, 0); }
		public TerminalNode LESS_EQUALS() { return getToken(YParser.LESS_EQUALS, 0); }
		public TerminalNode GREATER_EQUALS() { return getToken(YParser.GREATER_EQUALS, 0); }
		public ExpressionRelationalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionRelational(this);
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
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionValue(this);
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
		public TerminalNode AND() { return getToken(YParser.AND, 0); }
		public ExpressionAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionAnd(this);
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
		public TerminalNode OR() { return getToken(YParser.OR, 0); }
		public ExpressionOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionOr(this);
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
		public TerminalNode MULTIPLICATION() { return getToken(YParser.MULTIPLICATION, 0); }
		public TerminalNode DIVIDE() { return getToken(YParser.DIVIDE, 0); }
		public ExpressionMultDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionMultDiv(this);
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
		public TerminalNode PLUS() { return getToken(YParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(YParser.MINUS, 0); }
		public ExpressionAddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionAddSub(this);
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
		int _startState = 70;
		enterRecursionRule(_localctx, 70, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INIT_PARENT:
				{
				_localctx = new ExpressionParentsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(586);
				match(INIT_PARENT);
				setState(587);
				expression(0);
				setState(588);
				match(FINAL_PARENT);
				}
				break;
			case MINUS:
			case NOT:
				{
				_localctx = new ExpressionUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(590);
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
				setState(591);
				expression(8);
				}
				break;
			case READ:
			case TRUE:
			case FALSE:
			case INIT_BRACE:
			case ID:
			case INT:
			case DECIMAL:
			case TEXT:
			case CHAR:
				{
				_localctx = new ExpressionValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(592);
				normal_values();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(615);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(613);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMultDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(595);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(596);
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
						setState(597);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(598);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(599);
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
						setState(600);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionRelationalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(601);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(602);
						((ExpressionRelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7782220156096217088L) != 0)) ) {
							((ExpressionRelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(603);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionEqualityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(604);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(605);
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
						setState(606);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(607);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(608);
						match(AND);
						setState(609);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(610);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(611);
						match(OR);
						setState(612);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(617);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
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
	public static class ValueCharContext extends Normal_valuesContext {
		public TerminalNode CHAR() { return getToken(YParser.CHAR, 0); }
		public ValueCharContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterValueChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitValueChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitValueChar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueIntContext extends Normal_valuesContext {
		public TerminalNode INT() { return getToken(YParser.INT, 0); }
		public ValueIntContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterValueInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitValueInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitValueInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueDecimalContext extends Normal_valuesContext {
		public TerminalNode DECIMAL() { return getToken(YParser.DECIMAL, 0); }
		public ValueDecimalContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterValueDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitValueDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitValueDecimal(this);
			else return visitor.visitChildren(this);
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
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterValBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitValBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitValBool(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValObjectAccessContext extends Normal_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public ValObjectAccessContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterValObjectAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitValObjectAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitValObjectAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValArrayLiteralContext extends Normal_valuesContext {
		public Array_literalContext array_literal() {
			return getRuleContext(Array_literalContext.class,0);
		}
		public ValArrayLiteralContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterValArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitValArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitValArrayLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValReadCallContext extends Normal_valuesContext {
		public Read_callContext read_call() {
			return getRuleContext(Read_callContext.class,0);
		}
		public ValReadCallContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterValReadCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitValReadCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitValReadCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValueStringContext extends Normal_valuesContext {
		public TerminalNode TEXT() { return getToken(YParser.TEXT, 0); }
		public ValueStringContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterValueString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitValueString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitValueString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_valuesContext normal_values() throws RecognitionException {
		Normal_valuesContext _localctx = new Normal_valuesContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_normal_values);
		try {
			setState(626);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				_localctx = new ValueStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(618);
				match(TEXT);
				}
				break;
			case CHAR:
				_localctx = new ValueCharContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(619);
				match(CHAR);
				}
				break;
			case DECIMAL:
				_localctx = new ValueDecimalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(620);
				match(DECIMAL);
				}
				break;
			case INT:
				_localctx = new ValueIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(621);
				match(INT);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new ValBoolContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(622);
				boolean_values();
				}
				break;
			case ID:
				_localctx = new ValObjectAccessContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(623);
				object_values(0);
				}
				break;
			case INIT_BRACE:
				_localctx = new ValArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(624);
				array_literal();
				}
				break;
			case READ:
				_localctx = new ValReadCallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(625);
				read_call();
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
		public TerminalNode FALSE() { return getToken(YParser.FALSE, 0); }
		public BoolFalseContext(Boolean_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBoolFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBoolFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBoolFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTrueContext extends Boolean_valuesContext {
		public TerminalNode TRUE() { return getToken(YParser.TRUE, 0); }
		public BoolTrueContext(Boolean_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterBoolTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitBoolTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitBoolTrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_valuesContext boolean_values() throws RecognitionException {
		Boolean_valuesContext _localctx = new Boolean_valuesContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_boolean_values);
		try {
			setState(630);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new BoolTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(628);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new BoolFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(629);
				match(FALSE);
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
	public static class Expression_listContext extends ParserRuleContext {
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
	 
		public Expression_listContext() { }
		public void copyFrom(Expression_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends Expression_listContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(YParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(YParser.COMMA, i);
		}
		public ExpressionListContext(Expression_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpressionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpressionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_expression_list);
		int _la;
		try {
			_localctx = new ExpressionListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			expression(0);
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(633);
				match(COMMA);
				setState(634);
				expression(0);
				}
				}
				setState(639);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class Skip_linesContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public Skip_linesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_skip_lines; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterSkip_lines(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitSkip_lines(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitSkip_lines(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Skip_linesContext skip_lines() throws RecognitionException {
		Skip_linesContext _localctx = new Skip_linesContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_skip_lines);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(641); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(640);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(643); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		case 29:
			return object_values_sempred((Object_valuesContext)_localctx, predIndex);
		case 35:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean object_values_sempred(Object_valuesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 4);
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001G\u0286\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0001"+
		"\u0000\u0003\u0000R\b\u0000\u0001\u0000\u0003\u0000U\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0003\u0000Y\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0004\u0001_\b\u0001\u000b\u0001\f\u0001`\u0001\u0001\u0005"+
		"\u0001d\b\u0001\n\u0001\f\u0001g\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002o\b\u0002\n\u0002"+
		"\f\u0002r\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002v\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0004\u0003{\b\u0003\u000b\u0003\f\u0003|\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003\u0085\b\u0003\u000b\u0003\f\u0003\u0086\u0003\u0003\u0089\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0004\u0004\u008d\b\u0004\u000b\u0004\f\u0004"+
		"\u008e\u0001\u0004\u0005\u0004\u0092\b\u0004\n\u0004\f\u0004\u0095\t\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u009b\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00a0\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00a6\b\u0005\n\u0005"+
		"\f\u0005\u00a9\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00ad\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00b2\b\u0006\n\u0006"+
		"\f\u0006\u00b5\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u00c3\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u00cd\b\b\u000b\b\f"+
		"\b\u00ce\u0001\b\u0001\b\u0004\b\u00d3\b\b\u000b\b\f\b\u00d4\u0001\b\u0001"+
		"\b\u0003\b\u00d9\b\b\u0001\b\u0004\b\u00dc\b\b\u000b\b\f\b\u00dd\u0003"+
		"\b\u00e0\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00e7\b\t"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00f1\b\n\n\n\f\n\u00f4\t\n\u0001\n\u0001\n\u0003\n\u00f8\b\n\u0001"+
		"\n\u0003\n\u00fb\b\n\u0001\u000b\u0004\u000b\u00fe\b\u000b\u000b\u000b"+
		"\f\u000b\u00ff\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0005\f\u010a\b\f\n\f\f\f\u010d\t\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0005\r\u0115\b\r\n\r\f\r\u0118\t\r\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0124\b\u000e\n\u000e\f\u000e\u0127"+
		"\t\u000e\u0001\u000e\u0003\u000e\u012a\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u0134\b\u000f\n\u000f\f\u000f\u0137\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u0140\b\u0010\n\u0010\f\u0010\u0143\t\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u014f\b\u0011\n\u0011\f\u0011\u0152"+
		"\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u015b\b\u0012\n\u0012\f\u0012\u015e\t\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0004\u0012\u0166\b\u0012\u000b\u0012\f\u0012\u0167\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u016d\b\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u0171\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0175\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013"+
		"\u017c\b\u0013\n\u0013\f\u0013\u017f\t\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u018c\b\u0014\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u019c\b\u0015\u0001\u0016\u0001\u0016\u0004\u0016\u01a0"+
		"\b\u0016\u000b\u0016\f\u0016\u01a1\u0001\u0016\u0001\u0016\u0004\u0016"+
		"\u01a6\b\u0016\u000b\u0016\f\u0016\u01a7\u0003\u0016\u01aa\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0004\u0017\u01b1"+
		"\b\u0017\u000b\u0017\f\u0017\u01b2\u0001\u0017\u0001\u0017\u0004\u0017"+
		"\u01b7\b\u0017\u000b\u0017\f\u0017\u01b8\u0003\u0017\u01bb\b\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u01d1\b\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u01ec"+
		"\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u01f8"+
		"\b\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u01fc\b\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0005\u001d\u0206\b\u001d\n\u001d\f\u001d\u0209\t\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u020e\b\u001e\n\u001e\f\u001e"+
		"\u0211\t\u001e\u0001\u001f\u0001\u001f\u0003\u001f\u0215\b\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0005 \u021c\b \n \f \u021f\t"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0004!\u022f\b!\u000b!\f!\u0230\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0004!\u0239\b!\u000b!\f!\u023a\u0001!\u0001"+
		"!\u0001!\u0003!\u0240\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0003\"\u0248\b\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#"+
		"\u0001#\u0003#\u0252\b#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0005#\u0266\b#\n#\f#\u0269\t#\u0001$\u0001$\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0003$\u0273\b$\u0001%\u0001%\u0003%\u0277\b%\u0001"+
		"&\u0001&\u0001&\u0005&\u027c\b&\n&\f&\u027f\t&\u0001\'\u0004\'\u0282\b"+
		"\'\u000b\'\f\'\u0283\u0001\'\u0000\u0002:F(\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:<>@BDFHJLN\u0000\u0005\u0002\u000055AA\u0001\u000067\u0001\u00004"+
		"5\u0002\u0000:;=>\u0002\u000099<<\u02c6\u0000Q\u0001\u0000\u0000\u0000"+
		"\u0002\\\u0001\u0000\u0000\u0000\u0004h\u0001\u0000\u0000\u0000\u0006"+
		"\u0088\u0001\u0000\u0000\u0000\b\u008a\u0001\u0000\u0000\u0000\n\u0096"+
		"\u0001\u0000\u0000\u0000\f\u00ae\u0001\u0000\u0000\u0000\u000e\u00c2\u0001"+
		"\u0000\u0000\u0000\u0010\u00df\u0001\u0000\u0000\u0000\u0012\u00e6\u0001"+
		"\u0000\u0000\u0000\u0014\u00e8\u0001\u0000\u0000\u0000\u0016\u00fd\u0001"+
		"\u0000\u0000\u0000\u0018\u0101\u0001\u0000\u0000\u0000\u001a\u0110\u0001"+
		"\u0000\u0000\u0000\u001c\u011b\u0001\u0000\u0000\u0000\u001e\u012d\u0001"+
		"\u0000\u0000\u0000 \u013a\u0001\u0000\u0000\u0000\"\u0146\u0001\u0000"+
		"\u0000\u0000$\u0155\u0001\u0000\u0000\u0000&\u0169\u0001\u0000\u0000\u0000"+
		"(\u018b\u0001\u0000\u0000\u0000*\u019b\u0001\u0000\u0000\u0000,\u01a9"+
		"\u0001\u0000\u0000\u0000.\u01ba\u0001\u0000\u0000\u00000\u01bc\u0001\u0000"+
		"\u0000\u00002\u01d0\u0001\u0000\u0000\u00004\u01eb\u0001\u0000\u0000\u0000"+
		"6\u01ed\u0001\u0000\u0000\u00008\u01f1\u0001\u0000\u0000\u0000:\u01fb"+
		"\u0001\u0000\u0000\u0000<\u020a\u0001\u0000\u0000\u0000>\u0212\u0001\u0000"+
		"\u0000\u0000@\u0218\u0001\u0000\u0000\u0000B\u023f\u0001\u0000\u0000\u0000"+
		"D\u0247\u0001\u0000\u0000\u0000F\u0251\u0001\u0000\u0000\u0000H\u0272"+
		"\u0001\u0000\u0000\u0000J\u0276\u0001\u0000\u0000\u0000L\u0278\u0001\u0000"+
		"\u0000\u0000N\u0281\u0001\u0000\u0000\u0000PR\u0003N\'\u0000QP\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SU\u0003"+
		"\u0002\u0001\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000VX\u0003\b\u0004\u0000WY\u0003N\'\u0000XW\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z[\u0005\u0000\u0000\u0001[\u0001\u0001\u0000\u0000\u0000\\^\u0005\u0007"+
		"\u0000\u0000]_\u0005\u0005\u0000\u0000^]\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ae\u0001\u0000\u0000\u0000bd\u0003\u0004\u0002\u0000cb\u0001\u0000\u0000"+
		"\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000"+
		"\u0000\u0000f\u0003\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000"+
		"hi\u0005\r\u0000\u0000ij\u0005B\u0000\u0000jk\u0005%\u0000\u0000kl\u0005"+
		"\u0005\u0000\u0000lp\u0005\u0001\u0000\u0000mo\u0003\u0006\u0003\u0000"+
		"nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000pq\u0001\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000su\u0005\u0002\u0000\u0000tv\u0003N\'\u0000ut\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000v\u0005\u0001\u0000\u0000\u0000"+
		"wx\u0003D\"\u0000xz\u0005B\u0000\u0000y{\u0005\u0005\u0000\u0000zy\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}\u0089\u0001\u0000\u0000\u0000~\u007f\u0003"+
		"D\"\u0000\u007f\u0080\u0005B\u0000\u0000\u0080\u0081\u0005)\u0000\u0000"+
		"\u0081\u0082\u0003F#\u0000\u0082\u0084\u0005*\u0000\u0000\u0083\u0085"+
		"\u0005\u0005\u0000\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088w\u0001"+
		"\u0000\u0000\u0000\u0088~\u0001\u0000\u0000\u0000\u0089\u0007\u0001\u0000"+
		"\u0000\u0000\u008a\u008c\u0005\b\u0000\u0000\u008b\u008d\u0005\u0005\u0000"+
		"\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000"+
		"\u0000\u008f\u0093\u0001\u0000\u0000\u0000\u0090\u0092\u0003\n\u0005\u0000"+
		"\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000"+
		"\u0094\t\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096"+
		"\u0097\u0005\f\u0000\u0000\u0097\u0098\u0005B\u0000\u0000\u0098\u009a"+
		"\u0005+\u0000\u0000\u0099\u009b\u0003\f\u0006\u0000\u009a\u0099\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c\u009f\u0005,\u0000\u0000\u009d\u009e\u0005\t"+
		"\u0000\u0000\u009e\u00a0\u0003D\"\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005%\u0000\u0000\u00a2\u00a3\u0005\u0005\u0000\u0000"+
		"\u00a3\u00a7\u0005\u0001\u0000\u0000\u00a4\u00a6\u0003\u0010\b\u0000\u00a5"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8"+
		"\u00aa\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ac\u0005\u0002\u0000\u0000\u00ab\u00ad\u0003N\'\u0000\u00ac\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u000b"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b3\u0003\u000e\u0007\u0000\u00af\u00b0"+
		"\u0005#\u0000\u0000\u00b0\u00b2\u0003\u000e\u0007\u0000\u00b1\u00af\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\r\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b7\u0003D\""+
		"\u0000\u00b7\u00b8\u0005B\u0000\u0000\u00b8\u00c3\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0005)\u0000\u0000\u00ba\u00bb\u0005*\u0000\u0000\u00bb\u00bc"+
		"\u0003D\"\u0000\u00bc\u00bd\u0005B\u0000\u0000\u00bd\u00c3\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0005\'\u0000\u0000\u00bf\u00c0\u0005(\u0000"+
		"\u0000\u00c0\u00c1\u0005B\u0000\u0000\u00c1\u00c3\u0005B\u0000\u0000\u00c2"+
		"\u00b6\u0001\u0000\u0000\u0000\u00c2\u00b9\u0001\u0000\u0000\u0000\u00c2"+
		"\u00be\u0001\u0000\u0000\u0000\u00c3\u000f\u0001\u0000\u0000\u0000\u00c4"+
		"\u00e0\u0003\u0012\t\u0000\u00c5\u00e0\u0003.\u0017\u0000\u00c6\u00e0"+
		"\u0003,\u0016\u0000\u00c7\u00e0\u00032\u0019\u0000\u00c8\u00e0\u00034"+
		"\u001a\u0000\u00c9\u00e0\u0003\u0004\u0002\u0000\u00ca\u00cc\u0003B!\u0000"+
		"\u00cb\u00cd\u0005\u0005\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00e0\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d2\u00036\u001b\u0000\u00d1\u00d3\u0005\u0005\u0000\u0000\u00d2"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"\u00e0\u0001\u0000\u0000\u0000\u00d6\u00d8\u0005\u0019\u0000\u0000\u00d7"+
		"\u00d9\u0003F#\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001"+
		"\u0000\u0000\u0000\u00d9\u00db\u0001\u0000\u0000\u0000\u00da\u00dc\u0005"+
		"\u0005\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001"+
		"\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001"+
		"\u0000\u0000\u0000\u00de\u00e0\u0001\u0000\u0000\u0000\u00df\u00c4\u0001"+
		"\u0000\u0000\u0000\u00df\u00c5\u0001\u0000\u0000\u0000\u00df\u00c6\u0001"+
		"\u0000\u0000\u0000\u00df\u00c7\u0001\u0000\u0000\u0000\u00df\u00c8\u0001"+
		"\u0000\u0000\u0000\u00df\u00c9\u0001\u0000\u0000\u0000\u00df\u00ca\u0001"+
		"\u0000\u0000\u0000\u00df\u00d0\u0001\u0000\u0000\u0000\u00df\u00d6\u0001"+
		"\u0000\u0000\u0000\u00e0\u0011\u0001\u0000\u0000\u0000\u00e1\u00e7\u0003"+
		"\u0014\n\u0000\u00e2\u00e7\u0003\u001c\u000e\u0000\u00e3\u00e7\u0003\""+
		"\u0011\u0000\u00e4\u00e7\u0003$\u0012\u0000\u00e5\u00e7\u0003&\u0013\u0000"+
		"\u00e6\u00e1\u0001\u0000\u0000\u0000\u00e6\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7\u0013\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0005\u000e\u0000\u0000\u00e9\u00ea\u0005+\u0000\u0000\u00ea"+
		"\u00eb\u0003F#\u0000\u00eb\u00ec\u0005,\u0000\u0000\u00ec\u00ed\u0005"+
		"\u0011\u0000\u0000\u00ed\u00ee\u0005\u0005\u0000\u0000\u00ee\u00f2\u0005"+
		"\u0001\u0000\u0000\u00ef\u00f1\u0003\u0010\b\u0000\u00f0\u00ef\u0001\u0000"+
		"\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f7\u0005\u0002"+
		"\u0000\u0000\u00f6\u00f8\u0003\u0016\u000b\u0000\u00f7\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u00fa\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fb\u0003\u001a\r\u0000\u00fa\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u0015\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fe\u0003\u0018\f\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0017\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0005\u000f\u0000\u0000\u0102\u0103\u0005+\u0000\u0000\u0103"+
		"\u0104\u0003F#\u0000\u0104\u0105\u0005,\u0000\u0000\u0105\u0106\u0005"+
		"\u0011\u0000\u0000\u0106\u0107\u0005\u0005\u0000\u0000\u0107\u010b\u0005"+
		"\u0001\u0000\u0000\u0108\u010a\u0003\u0010\b\u0000\u0109\u0108\u0001\u0000"+
		"\u0000\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000"+
		"\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u010f\u0005\u0002"+
		"\u0000\u0000\u010f\u0019\u0001\u0000\u0000\u0000\u0110\u0111\u0005\u0010"+
		"\u0000\u0000\u0111\u0112\u0005\u0005\u0000\u0000\u0112\u0116\u0005\u0001"+
		"\u0000\u0000\u0113\u0115\u0003\u0010\b\u0000\u0114\u0113\u0001\u0000\u0000"+
		"\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000"+
		"\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0119\u0001\u0000\u0000"+
		"\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119\u011a\u0005\u0002\u0000"+
		"\u0000\u011a\u001b\u0001\u0000\u0000\u0000\u011b\u011c\u0005\u0012\u0000"+
		"\u0000\u011c\u011d\u0005+\u0000\u0000\u011d\u011e\u0003F#\u0000\u011e"+
		"\u011f\u0005,\u0000\u0000\u011f\u0120\u0005%\u0000\u0000\u0120\u0121\u0005"+
		"\u0005\u0000\u0000\u0121\u0125\u0005\u0001\u0000\u0000\u0122\u0124\u0003"+
		"\u001e\u000f\u0000\u0123\u0122\u0001\u0000\u0000\u0000\u0124\u0127\u0001"+
		"\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001"+
		"\u0000\u0000\u0000\u0126\u0129\u0001\u0000\u0000\u0000\u0127\u0125\u0001"+
		"\u0000\u0000\u0000\u0128\u012a\u0003 \u0010\u0000\u0129\u0128\u0001\u0000"+
		"\u0000\u0000\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012b\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0005\u0002\u0000\u0000\u012c\u001d\u0001\u0000"+
		"\u0000\u0000\u012d\u012e\u0005\u0013\u0000\u0000\u012e\u012f\u0003F#\u0000"+
		"\u012f\u0130\u0005%\u0000\u0000\u0130\u0131\u0005\u0005\u0000\u0000\u0131"+
		"\u0135\u0005\u0001\u0000\u0000\u0132\u0134\u0003\u0010\b\u0000\u0133\u0132"+
		"\u0001\u0000\u0000\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133"+
		"\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0138"+
		"\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u0005\u0002\u0000\u0000\u0139\u001f\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0005\u0015\u0000\u0000\u013b\u013c\u0005%\u0000\u0000\u013c\u013d\u0005"+
		"\u0005\u0000\u0000\u013d\u0141\u0005\u0001\u0000\u0000\u013e\u0140\u0003"+
		"\u0010\b\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u0140\u0143\u0001\u0000"+
		"\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000"+
		"\u0000\u0000\u0142\u0144\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000"+
		"\u0000\u0000\u0144\u0145\u0005\u0002\u0000\u0000\u0145!\u0001\u0000\u0000"+
		"\u0000\u0146\u0147\u0005\u0017\u0000\u0000\u0147\u0148\u0005+\u0000\u0000"+
		"\u0148\u0149\u0003F#\u0000\u0149\u014a\u0005,\u0000\u0000\u014a\u014b"+
		"\u0005\u0018\u0000\u0000\u014b\u014c\u0005\u0005\u0000\u0000\u014c\u0150"+
		"\u0005\u0001\u0000\u0000\u014d\u014f\u0003\u0010\b\u0000\u014e\u014d\u0001"+
		"\u0000\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0153\u0001"+
		"\u0000\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0154\u0005"+
		"\u0002\u0000\u0000\u0154#\u0001\u0000\u0000\u0000\u0155\u0156\u0005\u0018"+
		"\u0000\u0000\u0156\u0157\u0005%\u0000\u0000\u0157\u0158\u0005\u0005\u0000"+
		"\u0000\u0158\u015c\u0005\u0001\u0000\u0000\u0159\u015b\u0003\u0010\b\u0000"+
		"\u015a\u0159\u0001\u0000\u0000\u0000\u015b\u015e\u0001\u0000\u0000\u0000"+
		"\u015c\u015a\u0001\u0000\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000"+
		"\u015d\u015f\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000"+
		"\u015f\u0160\u0005\u0002\u0000\u0000\u0160\u0161\u0005\u0017\u0000\u0000"+
		"\u0161\u0162\u0005+\u0000\u0000\u0162\u0163\u0003F#\u0000\u0163\u0165"+
		"\u0005,\u0000\u0000\u0164\u0166\u0005\u0005\u0000\u0000\u0165\u0164\u0001"+
		"\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0165\u0001"+
		"\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168%\u0001\u0000"+
		"\u0000\u0000\u0169\u016a\u0005\u0016\u0000\u0000\u016a\u016c\u0005+\u0000"+
		"\u0000\u016b\u016d\u0003(\u0014\u0000\u016c\u016b\u0001\u0000\u0000\u0000"+
		"\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000"+
		"\u016e\u0170\u0005$\u0000\u0000\u016f\u0171\u0003F#\u0000\u0170\u016f"+
		"\u0001\u0000\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0172"+
		"\u0001\u0000\u0000\u0000\u0172\u0174\u0005$\u0000\u0000\u0173\u0175\u0003"+
		"*\u0015\u0000\u0174\u0173\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000"+
		"\u0000\u0000\u0175\u0176\u0001\u0000\u0000\u0000\u0176\u0177\u0005,\u0000"+
		"\u0000\u0177\u0178\u0005%\u0000\u0000\u0178\u0179\u0005\u0005\u0000\u0000"+
		"\u0179\u017d\u0005\u0001\u0000\u0000\u017a\u017c\u0003\u0010\b\u0000\u017b"+
		"\u017a\u0001\u0000\u0000\u0000\u017c\u017f\u0001\u0000\u0000\u0000\u017d"+
		"\u017b\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e"+
		"\u0180\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000\u0000\u0180"+
		"\u0181\u0005\u0002\u0000\u0000\u0181\'\u0001\u0000\u0000\u0000\u0182\u0183"+
		"\u0003D\"\u0000\u0183\u0184\u0005B\u0000\u0000\u0184\u0185\u0005\"\u0000"+
		"\u0000\u0185\u0186\u0003F#\u0000\u0186\u018c\u0001\u0000\u0000\u0000\u0187"+
		"\u0188\u00038\u001c\u0000\u0188\u0189\u0005\"\u0000\u0000\u0189\u018a"+
		"\u0003F#\u0000\u018a\u018c\u0001\u0000\u0000\u0000\u018b\u0182\u0001\u0000"+
		"\u0000\u0000\u018b\u0187\u0001\u0000\u0000\u0000\u018c)\u0001\u0000\u0000"+
		"\u0000\u018d\u018e\u00038\u001c\u0000\u018e\u018f\u00052\u0000\u0000\u018f"+
		"\u019c\u0001\u0000\u0000\u0000\u0190\u0191\u00038\u001c\u0000\u0191\u0192"+
		"\u00053\u0000\u0000\u0192\u019c\u0001\u0000\u0000\u0000\u0193\u0194\u0005"+
		"2\u0000\u0000\u0194\u019c\u00038\u001c\u0000\u0195\u0196\u00053\u0000"+
		"\u0000\u0196\u019c\u00038\u001c\u0000\u0197\u0198\u00038\u001c\u0000\u0198"+
		"\u0199\u0005\"\u0000\u0000\u0199\u019a\u0003F#\u0000\u019a\u019c\u0001"+
		"\u0000\u0000\u0000\u019b\u018d\u0001\u0000\u0000\u0000\u019b\u0190\u0001"+
		"\u0000\u0000\u0000\u019b\u0193\u0001\u0000\u0000\u0000\u019b\u0195\u0001"+
		"\u0000\u0000\u0000\u019b\u0197\u0001\u0000\u0000\u0000\u019c+\u0001\u0000"+
		"\u0000\u0000\u019d\u019f\u0005\u001a\u0000\u0000\u019e\u01a0\u0005\u0005"+
		"\u0000\u0000\u019f\u019e\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000"+
		"\u0000\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a2\u01aa\u0001\u0000\u0000\u0000\u01a3\u01a5\u0005\u0014"+
		"\u0000\u0000\u01a4\u01a6\u0005\u0005\u0000\u0000\u01a5\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000"+
		"\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8\u01aa\u0001\u0000"+
		"\u0000\u0000\u01a9\u019d\u0001\u0000\u0000\u0000\u01a9\u01a3\u0001\u0000"+
		"\u0000\u0000\u01aa-\u0001\u0000\u0000\u0000\u01ab\u01ac\u0005\n\u0000"+
		"\u0000\u01ac\u01ad\u0005+\u0000\u0000\u01ad\u01ae\u0003F#\u0000\u01ae"+
		"\u01b0\u0005,\u0000\u0000\u01af\u01b1\u0005\u0005\u0000\u0000\u01b0\u01af"+
		"\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2\u01b0"+
		"\u0001\u0000\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01bb"+
		"\u0001\u0000\u0000\u0000\u01b4\u01b6\u00030\u0018\u0000\u01b5\u01b7\u0005"+
		"\u0005\u0000\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001"+
		"\u0000\u0000\u0000\u01b8\u01b6\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001"+
		"\u0000\u0000\u0000\u01b9\u01bb\u0001\u0000\u0000\u0000\u01ba\u01ab\u0001"+
		"\u0000\u0000\u0000\u01ba\u01b4\u0001\u0000\u0000\u0000\u01bb/\u0001\u0000"+
		"\u0000\u0000\u01bc\u01bd\u0005\u000b\u0000\u0000\u01bd\u01be\u0005+\u0000"+
		"\u0000\u01be\u01bf\u0005,\u0000\u0000\u01bf1\u0001\u0000\u0000\u0000\u01c0"+
		"\u01c1\u00038\u001c\u0000\u01c1\u01c2\u00052\u0000\u0000\u01c2\u01c3\u0005"+
		"$\u0000\u0000\u01c3\u01d1\u0001\u0000\u0000\u0000\u01c4\u01c5\u00038\u001c"+
		"\u0000\u01c5\u01c6\u00053\u0000\u0000\u01c6\u01c7\u0005$\u0000\u0000\u01c7"+
		"\u01d1\u0001\u0000\u0000\u0000\u01c8\u01c9\u00052\u0000\u0000\u01c9\u01ca"+
		"\u00038\u001c\u0000\u01ca\u01cb\u0005$\u0000\u0000\u01cb\u01d1\u0001\u0000"+
		"\u0000\u0000\u01cc\u01cd\u00053\u0000\u0000\u01cd\u01ce\u00038\u001c\u0000"+
		"\u01ce\u01cf\u0005$\u0000\u0000\u01cf\u01d1\u0001\u0000\u0000\u0000\u01d0"+
		"\u01c0\u0001\u0000\u0000\u0000\u01d0\u01c4\u0001\u0000\u0000\u0000\u01d0"+
		"\u01c8\u0001\u0000\u0000\u0000\u01d0\u01cc\u0001\u0000\u0000\u0000\u01d1"+
		"3\u0001\u0000\u0000\u0000\u01d2\u01d3\u00038\u001c\u0000\u01d3\u01d4\u0005"+
		"-\u0000\u0000\u01d4\u01d5\u0003F#\u0000\u01d5\u01d6\u0005$\u0000\u0000"+
		"\u01d6\u01ec\u0001\u0000\u0000\u0000\u01d7\u01d8\u00038\u001c\u0000\u01d8"+
		"\u01d9\u0005.\u0000\u0000\u01d9\u01da\u0003F#\u0000\u01da\u01db\u0005"+
		"$\u0000\u0000\u01db\u01ec\u0001\u0000\u0000\u0000\u01dc\u01dd\u00038\u001c"+
		"\u0000\u01dd\u01de\u0005/\u0000\u0000\u01de\u01df\u0003F#\u0000\u01df"+
		"\u01e0\u0005$\u0000\u0000\u01e0\u01ec\u0001\u0000\u0000\u0000\u01e1\u01e2"+
		"\u00038\u001c\u0000\u01e2\u01e3\u00050\u0000\u0000\u01e3\u01e4\u0003F"+
		"#\u0000\u01e4\u01e5\u0005$\u0000\u0000\u01e5\u01ec\u0001\u0000\u0000\u0000"+
		"\u01e6\u01e7\u00038\u001c\u0000\u01e7\u01e8\u00051\u0000\u0000\u01e8\u01e9"+
		"\u0003F#\u0000\u01e9\u01ea\u0005$\u0000\u0000\u01ea\u01ec\u0001\u0000"+
		"\u0000\u0000\u01eb\u01d2\u0001\u0000\u0000\u0000\u01eb\u01d7\u0001\u0000"+
		"\u0000\u0000\u01eb\u01dc\u0001\u0000\u0000\u0000\u01eb\u01e1\u0001\u0000"+
		"\u0000\u0000\u01eb\u01e6\u0001\u0000\u0000\u0000\u01ec5\u0001\u0000\u0000"+
		"\u0000\u01ed\u01ee\u00038\u001c\u0000\u01ee\u01ef\u0005\"\u0000\u0000"+
		"\u01ef\u01f0\u0003F#\u0000\u01f07\u0001\u0000\u0000\u0000\u01f1\u01f2"+
		"\u0003:\u001d\u0000\u01f29\u0001\u0000\u0000\u0000\u01f3\u01f4\u0006\u001d"+
		"\uffff\uffff\u0000\u01f4\u01f5\u0005B\u0000\u0000\u01f5\u01f7\u0005+\u0000"+
		"\u0000\u01f6\u01f8\u0003<\u001e\u0000\u01f7\u01f6\u0001\u0000\u0000\u0000"+
		"\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8\u01f9\u0001\u0000\u0000\u0000"+
		"\u01f9\u01fc\u0005,\u0000\u0000\u01fa\u01fc\u0005B\u0000\u0000\u01fb\u01f3"+
		"\u0001\u0000\u0000\u0000\u01fb\u01fa\u0001\u0000\u0000\u0000\u01fc\u0207"+
		"\u0001\u0000\u0000\u0000\u01fd\u01fe\n\u0004\u0000\u0000\u01fe\u01ff\u0005"+
		"&\u0000\u0000\u01ff\u0206\u0005B\u0000\u0000\u0200\u0201\n\u0003\u0000"+
		"\u0000\u0201\u0202\u0005)\u0000\u0000\u0202\u0203\u0003F#\u0000\u0203"+
		"\u0204\u0005*\u0000\u0000\u0204\u0206\u0001\u0000\u0000\u0000\u0205\u01fd"+
		"\u0001\u0000\u0000\u0000\u0205\u0200\u0001\u0000\u0000\u0000\u0206\u0209"+
		"\u0001\u0000\u0000\u0000\u0207\u0205\u0001\u0000\u0000\u0000\u0207\u0208"+
		"\u0001\u0000\u0000\u0000\u0208;\u0001\u0000\u0000\u0000\u0209\u0207\u0001"+
		"\u0000\u0000\u0000\u020a\u020f\u0003F#\u0000\u020b\u020c\u0005#\u0000"+
		"\u0000\u020c\u020e\u0003F#\u0000\u020d\u020b\u0001\u0000\u0000\u0000\u020e"+
		"\u0211\u0001\u0000\u0000\u0000\u020f\u020d\u0001\u0000\u0000\u0000\u020f"+
		"\u0210\u0001\u0000\u0000\u0000\u0210=\u0001\u0000\u0000\u0000\u0211\u020f"+
		"\u0001\u0000\u0000\u0000\u0212\u0214\u0005\'\u0000\u0000\u0213\u0215\u0003"+
		"@ \u0000\u0214\u0213\u0001\u0000\u0000\u0000\u0214\u0215\u0001\u0000\u0000"+
		"\u0000\u0215\u0216\u0001\u0000\u0000\u0000\u0216\u0217\u0005(\u0000\u0000"+
		"\u0217?\u0001\u0000\u0000\u0000\u0218\u021d\u0003F#\u0000\u0219\u021a"+
		"\u0005#\u0000\u0000\u021a\u021c\u0003F#\u0000\u021b\u0219\u0001\u0000"+
		"\u0000\u0000\u021c\u021f\u0001\u0000\u0000\u0000\u021d\u021b\u0001\u0000"+
		"\u0000\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021eA\u0001\u0000\u0000"+
		"\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u0220\u0221\u0003D\"\u0000"+
		"\u0221\u0222\u0005B\u0000\u0000\u0222\u0240\u0001\u0000\u0000\u0000\u0223"+
		"\u0224\u0003D\"\u0000\u0224\u0225\u0005B\u0000\u0000\u0225\u0226\u0005"+
		"\"\u0000\u0000\u0226\u0227\u0003F#\u0000\u0227\u0240\u0001\u0000\u0000"+
		"\u0000\u0228\u0229\u0003D\"\u0000\u0229\u022e\u0005B\u0000\u0000\u022a"+
		"\u022b\u0005)\u0000\u0000\u022b\u022c\u0003F#\u0000\u022c\u022d\u0005"+
		"*\u0000\u0000\u022d\u022f\u0001\u0000\u0000\u0000\u022e\u022a\u0001\u0000"+
		"\u0000\u0000\u022f\u0230\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000"+
		"\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231\u0240\u0001\u0000"+
		"\u0000\u0000\u0232\u0233\u0003D\"\u0000\u0233\u0238\u0005B\u0000\u0000"+
		"\u0234\u0235\u0005)\u0000\u0000\u0235\u0236\u0003F#\u0000\u0236\u0237"+
		"\u0005*\u0000\u0000\u0237\u0239\u0001\u0000\u0000\u0000\u0238\u0234\u0001"+
		"\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000\u023a\u0238\u0001"+
		"\u0000\u0000\u0000\u023a\u023b\u0001\u0000\u0000\u0000\u023b\u023c\u0001"+
		"\u0000\u0000\u0000\u023c\u023d\u0005\"\u0000\u0000\u023d\u023e\u0003F"+
		"#\u0000\u023e\u0240\u0001\u0000\u0000\u0000\u023f\u0220\u0001\u0000\u0000"+
		"\u0000\u023f\u0223\u0001\u0000\u0000\u0000\u023f\u0228\u0001\u0000\u0000"+
		"\u0000\u023f\u0232\u0001\u0000\u0000\u0000\u0240C\u0001\u0000\u0000\u0000"+
		"\u0241\u0248\u0005\u001b\u0000\u0000\u0242\u0248\u0005\u001c\u0000\u0000"+
		"\u0243\u0248\u0005\u001d\u0000\u0000\u0244\u0248\u0005\u001e\u0000\u0000"+
		"\u0245\u0248\u0005\u001f\u0000\u0000\u0246\u0248\u0005B\u0000\u0000\u0247"+
		"\u0241\u0001\u0000\u0000\u0000\u0247\u0242\u0001\u0000\u0000\u0000\u0247"+
		"\u0243\u0001\u0000\u0000\u0000\u0247\u0244\u0001\u0000\u0000\u0000\u0247"+
		"\u0245\u0001\u0000\u0000\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0248"+
		"E\u0001\u0000\u0000\u0000\u0249\u024a\u0006#\uffff\uffff\u0000\u024a\u024b"+
		"\u0005+\u0000\u0000\u024b\u024c\u0003F#\u0000\u024c\u024d\u0005,\u0000"+
		"\u0000\u024d\u0252\u0001\u0000\u0000\u0000\u024e\u024f\u0007\u0000\u0000"+
		"\u0000\u024f\u0252\u0003F#\b\u0250\u0252\u0003H$\u0000\u0251\u0249\u0001"+
		"\u0000\u0000\u0000\u0251\u024e\u0001\u0000\u0000\u0000\u0251\u0250\u0001"+
		"\u0000\u0000\u0000\u0252\u0267\u0001\u0000\u0000\u0000\u0253\u0254\n\u0007"+
		"\u0000\u0000\u0254\u0255\u0007\u0001\u0000\u0000\u0255\u0266\u0003F#\b"+
		"\u0256\u0257\n\u0006\u0000\u0000\u0257\u0258\u0007\u0002\u0000\u0000\u0258"+
		"\u0266\u0003F#\u0007\u0259\u025a\n\u0005\u0000\u0000\u025a\u025b\u0007"+
		"\u0003\u0000\u0000\u025b\u0266\u0003F#\u0006\u025c\u025d\n\u0004\u0000"+
		"\u0000\u025d\u025e\u0007\u0004\u0000\u0000\u025e\u0266\u0003F#\u0005\u025f"+
		"\u0260\n\u0003\u0000\u0000\u0260\u0261\u0005?\u0000\u0000\u0261\u0266"+
		"\u0003F#\u0004\u0262\u0263\n\u0002\u0000\u0000\u0263\u0264\u0005@\u0000"+
		"\u0000\u0264\u0266\u0003F#\u0003\u0265\u0253\u0001\u0000\u0000\u0000\u0265"+
		"\u0256\u0001\u0000\u0000\u0000\u0265\u0259\u0001\u0000\u0000\u0000\u0265"+
		"\u025c\u0001\u0000\u0000\u0000\u0265\u025f\u0001\u0000\u0000\u0000\u0265"+
		"\u0262\u0001\u0000\u0000\u0000\u0266\u0269\u0001\u0000\u0000\u0000\u0267"+
		"\u0265\u0001\u0000\u0000\u0000\u0267\u0268\u0001\u0000\u0000\u0000\u0268"+
		"G\u0001\u0000\u0000\u0000\u0269\u0267\u0001\u0000\u0000\u0000\u026a\u0273"+
		"\u0005E\u0000\u0000\u026b\u0273\u0005F\u0000\u0000\u026c\u0273\u0005D"+
		"\u0000\u0000\u026d\u0273\u0005C\u0000\u0000\u026e\u0273\u0003J%\u0000"+
		"\u026f\u0273\u0003:\u001d\u0000\u0270\u0273\u0003>\u001f\u0000\u0271\u0273"+
		"\u00030\u0018\u0000\u0272\u026a\u0001\u0000\u0000\u0000\u0272\u026b\u0001"+
		"\u0000\u0000\u0000\u0272\u026c\u0001\u0000\u0000\u0000\u0272\u026d\u0001"+
		"\u0000\u0000\u0000\u0272\u026e\u0001\u0000\u0000\u0000\u0272\u026f\u0001"+
		"\u0000\u0000\u0000\u0272\u0270\u0001\u0000\u0000\u0000\u0272\u0271\u0001"+
		"\u0000\u0000\u0000\u0273I\u0001\u0000\u0000\u0000\u0274\u0277\u0005 \u0000"+
		"\u0000\u0275\u0277\u0005!\u0000\u0000\u0276\u0274\u0001\u0000\u0000\u0000"+
		"\u0276\u0275\u0001\u0000\u0000\u0000\u0277K\u0001\u0000\u0000\u0000\u0278"+
		"\u027d\u0003F#\u0000\u0279\u027a\u0005#\u0000\u0000\u027a\u027c\u0003"+
		"F#\u0000\u027b\u0279\u0001\u0000\u0000\u0000\u027c\u027f\u0001\u0000\u0000"+
		"\u0000\u027d\u027b\u0001\u0000\u0000\u0000\u027d\u027e\u0001\u0000\u0000"+
		"\u0000\u027eM\u0001\u0000\u0000\u0000\u027f\u027d\u0001\u0000\u0000\u0000"+
		"\u0280\u0282\u0005\u0005\u0000\u0000\u0281\u0280\u0001\u0000\u0000\u0000"+
		"\u0282\u0283\u0001\u0000\u0000\u0000\u0283\u0281\u0001\u0000\u0000\u0000"+
		"\u0283\u0284\u0001\u0000\u0000\u0000\u0284O\u0001\u0000\u0000\u0000EQ"+
		"TX`epu|\u0086\u0088\u008e\u0093\u009a\u009f\u00a7\u00ac\u00b3\u00c2\u00ce"+
		"\u00d4\u00d8\u00dd\u00df\u00e6\u00f2\u00f7\u00fa\u00ff\u010b\u0116\u0125"+
		"\u0129\u0135\u0141\u0150\u015c\u0167\u016c\u0170\u0174\u017d\u018b\u019b"+
		"\u01a1\u01a7\u01a9\u01b2\u01b8\u01ba\u01d0\u01eb\u01f7\u01fb\u0205\u0207"+
		"\u020f\u0214\u021d\u0230\u023a\u023f\u0247\u0251\u0265\u0267\u0272\u0276"+
		"\u027d\u0283";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}