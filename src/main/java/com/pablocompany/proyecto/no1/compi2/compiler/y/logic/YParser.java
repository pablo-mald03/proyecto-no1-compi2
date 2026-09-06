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
		RULE_parameter_list = 6, RULE_parameter = 7, RULE_statement = 8, RULE_variable_declaration = 9, 
		RULE_assignment = 10, RULE_type = 11, RULE_expression = 12, RULE_expression_list = 13, 
		RULE_accessor = 14, RULE_skip_lines = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "structures_region", "struct_declaration", "struct_field", 
			"functions_region", "function_declaration", "parameter_list", "parameter", 
			"statement", "variable_declaration", "assignment", "type", "expression", 
			"expression_list", "accessor", "skip_lines"
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(32);
				skip_lines();
				}
			}

			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRUCTURES_REGION) {
				{
				setState(35);
				structures_region();
				}
			}

			setState(38);
			functions_region();
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(39);
				skip_lines();
				}
			}

			setState(42);
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
		public Structures_regionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structures_region; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStructures_region(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStructures_region(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStructures_region(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Structures_regionContext structures_region() throws RecognitionException {
		Structures_regionContext _localctx = new Structures_regionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_structures_region);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(STRUCTURES_REGION);
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(45);
				match(NEWLINE);
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRUCT) {
				{
				{
				setState(50);
				struct_declaration();
				}
				}
				setState(55);
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
		public Struct_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStruct_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStruct_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStruct_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_struct_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(STRUCT);
			setState(57);
			match(ID);
			setState(58);
			match(TWO_POINTS);
			setState(59);
			match(NEWLINE);
			setState(60);
			match(INDENT);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 549755813919L) != 0)) {
				{
				{
				setState(61);
				struct_field();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(DEDENT);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(68);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public TerminalNode INIT_BRACKET() { return getToken(YParser.INIT_BRACKET, 0); }
		public TerminalNode INT() { return getToken(YParser.INT, 0); }
		public TerminalNode FINAL_BRACKET() { return getToken(YParser.FINAL_BRACKET, 0); }
		public Struct_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStruct_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStruct_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStruct_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_fieldContext struct_field() throws RecognitionException {
		Struct_fieldContext _localctx = new Struct_fieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_struct_field);
		int _la;
		try {
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				type();
				setState(72);
				match(ID);
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(73);
					match(NEWLINE);
					}
					}
					setState(76); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				type();
				setState(79);
				match(ID);
				setState(80);
				match(INIT_BRACKET);
				setState(81);
				match(INT);
				setState(82);
				match(FINAL_BRACKET);
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(83);
					match(NEWLINE);
					}
					}
					setState(86); 
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
		public Functions_regionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions_region; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterFunctions_region(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitFunctions_region(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitFunctions_region(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Functions_regionContext functions_region() throws RecognitionException {
		Functions_regionContext _localctx = new Functions_regionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functions_region);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(FUNCTION_REGION);
			setState(92); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(91);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(94); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DEFINE) {
				{
				{
				setState(96);
				function_declaration();
				}
				}
				setState(101);
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
		public Function_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterFunction_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitFunction_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitFunction_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_declarationContext function_declaration() throws RecognitionException {
		Function_declarationContext _localctx = new Function_declarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(DEFINE);
			setState(103);
			match(ID);
			setState(104);
			match(INIT_PARENT);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 549755834399L) != 0)) {
				{
				setState(105);
				parameter_list();
				}
			}

			setState(108);
			match(FINAL_PARENT);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LAMBDA) {
				{
				setState(109);
				match(LAMBDA);
				setState(110);
				type();
				}
			}

			setState(113);
			match(TWO_POINTS);
			setState(114);
			match(NEWLINE);
			setState(115);
			match(INDENT);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & 50577534894205L) != 0)) {
				{
				{
				setState(116);
				statement();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(DEDENT);
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(123);
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
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterParameter_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitParameter_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			parameter();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(127);
				match(COMMA);
				setState(128);
				parameter();
				}
				}
				setState(133);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(YParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YParser.ID, i);
		}
		public TerminalNode INIT_BRACKET() { return getToken(YParser.INIT_BRACKET, 0); }
		public TerminalNode FINAL_BRACKET() { return getToken(YParser.FINAL_BRACKET, 0); }
		public TerminalNode INIT_BRACE() { return getToken(YParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(YParser.FINAL_BRACE, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case STRING:
			case FLOAT:
			case CHARACTER:
			case BOOLEAN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				type();
				setState(135);
				match(ID);
				}
				break;
			case INIT_BRACKET:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(INIT_BRACKET);
				setState(138);
				match(FINAL_BRACKET);
				setState(139);
				type();
				setState(140);
				match(ID);
				}
				break;
			case INIT_BRACE:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(INIT_BRACE);
				setState(143);
				match(FINAL_BRACE);
				setState(144);
				match(ID);
				setState(145);
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
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(YParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(YParser.NEWLINE, i);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(YParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				variable_declaration();
				setState(150); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(149);
					match(NEWLINE);
					}
					}
					setState(152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				assignment();
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(155);
					match(NEWLINE);
					}
					}
					setState(158); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
				match(RETURN);
				setState(161);
				expression();
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(162);
					match(NEWLINE);
					}
					}
					setState(165); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(167);
				expression();
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(168);
					match(NEWLINE);
					}
					}
					setState(171); 
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
	public static class Variable_declarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(YParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterVariable_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitVariable_declaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitVariable_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_variable_declaration);
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				type();
				setState(176);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				type();
				setState(179);
				match(ID);
				setState(180);
				match(EQUAL);
				setState(181);
				expression();
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
		public AccessorContext accessor() {
			return getRuleContext(AccessorContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(YParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			accessor();
			setState(186);
			match(EQUAL);
			setState(187);
			expression();
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
		public TerminalNode INTEGER() { return getToken(YParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(YParser.STRING, 0); }
		public TerminalNode FLOAT() { return getToken(YParser.FLOAT, 0); }
		public TerminalNode CHARACTER() { return getToken(YParser.CHARACTER, 0); }
		public TerminalNode BOOLEAN() { return getToken(YParser.BOOLEAN, 0); }
		public TerminalNode ID() { return getToken(YParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !(((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 549755813919L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode INIT_BRACE() { return getToken(YParser.INIT_BRACE, 0); }
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(YParser.FINAL_BRACE, 0); }
		public AccessorContext accessor() {
			return getRuleContext(AccessorContext.class,0);
		}
		public TerminalNode INT() { return getToken(YParser.INT, 0); }
		public TerminalNode DECIMAL() { return getToken(YParser.DECIMAL, 0); }
		public TerminalNode CHAR() { return getToken(YParser.CHAR, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INIT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(INIT_BRACE);
				setState(192);
				expression_list();
				setState(193);
				match(FINAL_BRACE);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				accessor();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(INT);
				}
				break;
			case DECIMAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(DECIMAL);
				}
				break;
			case CHAR:
				enterOuterAlt(_localctx, 5);
				{
				setState(198);
				match(CHAR);
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
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterExpression_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitExpression_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitExpression_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			expression();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(202);
				match(COMMA);
				setState(203);
				expression();
				}
				}
				setState(208);
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
	public static class AccessorContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(YParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(YParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(YParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(YParser.DOT, i);
		}
		public AccessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterAccessor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitAccessor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitAccessor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessorContext accessor() throws RecognitionException {
		AccessorContext _localctx = new AccessorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_accessor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(ID);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(210);
				match(DOT);
				setState(211);
				match(ID);
				}
				}
				setState(216);
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
		enterRule(_localctx, 30, RULE_skip_lines);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(217);
					match(NEWLINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(220); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	public static final String _serializedATN =
		"\u0004\u0001G\u00df\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0003\u0000\"\b\u0000\u0001\u0000\u0003\u0000%\b\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000)\b\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0004\u0001/\b\u0001\u000b\u0001\f\u00010\u0001\u0001"+
		"\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002?\b\u0002"+
		"\n\u0002\f\u0002B\t\u0002\u0001\u0002\u0001\u0002\u0003\u0002F\b\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003K\b\u0003\u000b\u0003"+
		"\f\u0003L\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0004\u0003U\b\u0003\u000b\u0003\f\u0003V\u0003\u0003Y\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0004\u0004]\b\u0004\u000b\u0004\f\u0004"+
		"^\u0001\u0004\u0005\u0004b\b\u0004\n\u0004\f\u0004e\t\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005k\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005p\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005v\b\u0005\n\u0005\f\u0005y\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005}\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u0082\b\u0006\n\u0006\f\u0006\u0085\t\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u0093\b\u0007\u0001\b\u0001\b\u0004\b\u0097\b\b\u000b\b\f\b\u0098"+
		"\u0001\b\u0001\b\u0004\b\u009d\b\b\u000b\b\f\b\u009e\u0001\b\u0001\b\u0001"+
		"\b\u0004\b\u00a4\b\b\u000b\b\f\b\u00a5\u0001\b\u0001\b\u0004\b\u00aa\b"+
		"\b\u000b\b\f\b\u00ab\u0003\b\u00ae\b\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b8\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u00c8\b\f\u0001\r\u0001\r\u0001\r\u0005"+
		"\r\u00cd\b\r\n\r\f\r\u00d0\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00d5\b\u000e\n\u000e\f\u000e\u00d8\t\u000e\u0001\u000f\u0004\u000f"+
		"\u00db\b\u000f\u000b\u000f\f\u000f\u00dc\u0001\u000f\u0000\u0000\u0010"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e\u0000\u0001\u0002\u0000\u001b\u001fBB\u00f0\u0000!\u0001"+
		"\u0000\u0000\u0000\u0002,\u0001\u0000\u0000\u0000\u00048\u0001\u0000\u0000"+
		"\u0000\u0006X\u0001\u0000\u0000\u0000\bZ\u0001\u0000\u0000\u0000\nf\u0001"+
		"\u0000\u0000\u0000\f~\u0001\u0000\u0000\u0000\u000e\u0092\u0001\u0000"+
		"\u0000\u0000\u0010\u00ad\u0001\u0000\u0000\u0000\u0012\u00b7\u0001\u0000"+
		"\u0000\u0000\u0014\u00b9\u0001\u0000\u0000\u0000\u0016\u00bd\u0001\u0000"+
		"\u0000\u0000\u0018\u00c7\u0001\u0000\u0000\u0000\u001a\u00c9\u0001\u0000"+
		"\u0000\u0000\u001c\u00d1\u0001\u0000\u0000\u0000\u001e\u00da\u0001\u0000"+
		"\u0000\u0000 \"\u0003\u001e\u000f\u0000! \u0001\u0000\u0000\u0000!\"\u0001"+
		"\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#%\u0003\u0002\u0001\u0000"+
		"$#\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000"+
		"\u0000&(\u0003\b\u0004\u0000\')\u0003\u001e\u000f\u0000(\'\u0001\u0000"+
		"\u0000\u0000()\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0005"+
		"\u0000\u0000\u0001+\u0001\u0001\u0000\u0000\u0000,.\u0005\u0007\u0000"+
		"\u0000-/\u0005\u0005\u0000\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000015\u0001"+
		"\u0000\u0000\u000024\u0003\u0004\u0002\u000032\u0001\u0000\u0000\u0000"+
		"47\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u00006\u0003\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000089\u0005"+
		"\r\u0000\u00009:\u0005B\u0000\u0000:;\u0005%\u0000\u0000;<\u0005\u0005"+
		"\u0000\u0000<@\u0005\u0001\u0000\u0000=?\u0003\u0006\u0003\u0000>=\u0001"+
		"\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000"+
		"\u0000CE\u0005\u0002\u0000\u0000DF\u0003\u001e\u000f\u0000ED\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0005\u0001\u0000\u0000\u0000"+
		"GH\u0003\u0016\u000b\u0000HJ\u0005B\u0000\u0000IK\u0005\u0005\u0000\u0000"+
		"JI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000"+
		"\u0000LM\u0001\u0000\u0000\u0000MY\u0001\u0000\u0000\u0000NO\u0003\u0016"+
		"\u000b\u0000OP\u0005B\u0000\u0000PQ\u0005)\u0000\u0000QR\u0005C\u0000"+
		"\u0000RT\u0005*\u0000\u0000SU\u0005\u0005\u0000\u0000TS\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000"+
		"\u0000\u0000WY\u0001\u0000\u0000\u0000XG\u0001\u0000\u0000\u0000XN\u0001"+
		"\u0000\u0000\u0000Y\u0007\u0001\u0000\u0000\u0000Z\\\u0005\b\u0000\u0000"+
		"[]\u0005\u0005\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_c\u0001\u0000"+
		"\u0000\u0000`b\u0003\n\u0005\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000d\t\u0001"+
		"\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fg\u0005\f\u0000\u0000gh\u0005"+
		"B\u0000\u0000hj\u0005+\u0000\u0000ik\u0003\f\u0006\u0000ji\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lo\u0005"+
		",\u0000\u0000mn\u0005\t\u0000\u0000np\u0003\u0016\u000b\u0000om\u0001"+
		"\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000"+
		"qr\u0005%\u0000\u0000rs\u0005\u0005\u0000\u0000sw\u0005\u0001\u0000\u0000"+
		"tv\u0003\u0010\b\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000z|\u0005\u0002\u0000\u0000{}\u0003\u001e"+
		"\u000f\u0000|{\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u000b"+
		"\u0001\u0000\u0000\u0000~\u0083\u0003\u000e\u0007\u0000\u007f\u0080\u0005"+
		"#\u0000\u0000\u0080\u0082\u0003\u000e\u0007\u0000\u0081\u007f\u0001\u0000"+
		"\u0000\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\r\u0001\u0000\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0087\u0003\u0016\u000b"+
		"\u0000\u0087\u0088\u0005B\u0000\u0000\u0088\u0093\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0005)\u0000\u0000\u008a\u008b\u0005*\u0000\u0000\u008b\u008c"+
		"\u0003\u0016\u000b\u0000\u008c\u008d\u0005B\u0000\u0000\u008d\u0093\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0005\'\u0000\u0000\u008f\u0090\u0005("+
		"\u0000\u0000\u0090\u0091\u0005B\u0000\u0000\u0091\u0093\u0005B\u0000\u0000"+
		"\u0092\u0086\u0001\u0000\u0000\u0000\u0092\u0089\u0001\u0000\u0000\u0000"+
		"\u0092\u008e\u0001\u0000\u0000\u0000\u0093\u000f\u0001\u0000\u0000\u0000"+
		"\u0094\u0096\u0003\u0012\t\u0000\u0095\u0097\u0005\u0005\u0000\u0000\u0096"+
		"\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u00ae\u0001\u0000\u0000\u0000\u009a\u009c\u0003\u0014\n\u0000\u009b\u009d"+
		"\u0005\u0005\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00ae\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0005\u0019\u0000\u0000\u00a1\u00a3\u0003\u0018\f\u0000\u00a2\u00a4\u0005"+
		"\u0005\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a6\u00ae\u0001\u0000\u0000\u0000\u00a7\u00a9\u0003"+
		"\u0018\f\u0000\u00a8\u00aa\u0005\u0005\u0000\u0000\u00a9\u00a8\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ad\u0094\u0001\u0000\u0000\u0000\u00ad\u009a\u0001\u0000"+
		"\u0000\u0000\u00ad\u00a0\u0001\u0000\u0000\u0000\u00ad\u00a7\u0001\u0000"+
		"\u0000\u0000\u00ae\u0011\u0001\u0000\u0000\u0000\u00af\u00b0\u0003\u0016"+
		"\u000b\u0000\u00b0\u00b1\u0005B\u0000\u0000\u00b1\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b3\u0003\u0016\u000b\u0000\u00b3\u00b4\u0005B\u0000\u0000"+
		"\u00b4\u00b5\u0005\"\u0000\u0000\u00b5\u00b6\u0003\u0018\f\u0000\u00b6"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b7\u00af\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b8\u0013\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0003\u001c\u000e\u0000\u00ba\u00bb\u0005\"\u0000\u0000\u00bb\u00bc"+
		"\u0003\u0018\f\u0000\u00bc\u0015\u0001\u0000\u0000\u0000\u00bd\u00be\u0007"+
		"\u0000\u0000\u0000\u00be\u0017\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005"+
		"\'\u0000\u0000\u00c0\u00c1\u0003\u001a\r\u0000\u00c1\u00c2\u0005(\u0000"+
		"\u0000\u00c2\u00c8\u0001\u0000\u0000\u0000\u00c3\u00c8\u0003\u001c\u000e"+
		"\u0000\u00c4\u00c8\u0005C\u0000\u0000\u00c5\u00c8\u0005D\u0000\u0000\u00c6"+
		"\u00c8\u0005F\u0000\u0000\u00c7\u00bf\u0001\u0000\u0000\u0000\u00c7\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u0019"+
		"\u0001\u0000\u0000\u0000\u00c9\u00ce\u0003\u0018\f\u0000\u00ca\u00cb\u0005"+
		"#\u0000\u0000\u00cb\u00cd\u0003\u0018\f\u0000\u00cc\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u001b\u0001\u0000"+
		"\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1\u00d6\u0005B\u0000"+
		"\u0000\u00d2\u00d3\u0005&\u0000\u0000\u00d3\u00d5\u0005B\u0000\u0000\u00d4"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7"+
		"\u001d\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9"+
		"\u00db\u0005\u0005\u0000\u0000\u00da\u00d9\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0001\u0000\u0000\u0000\u00dd\u001f\u0001\u0000\u0000\u0000\u001c"+
		"!$(05@ELVX^cjow|\u0083\u0092\u0098\u009e\u00a5\u00ab\u00ad\u00b7\u00c7"+
		"\u00ce\u00d6\u00dc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}