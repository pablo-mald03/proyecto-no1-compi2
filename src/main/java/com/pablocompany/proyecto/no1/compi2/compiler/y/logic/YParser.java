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
		RULE_program = 0, RULE_code = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "code"
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
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
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
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRUCTURES_REGION) {
				{
				{
				setState(4);
				code();
				}
				}
				setState(9);
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
	public static class CodeContext extends ParserRuleContext {
		public TerminalNode STRUCTURES_REGION() { return getToken(YParser.STRUCTURES_REGION, 0); }
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof YParserListener ) ((YParserListener)listener).exitCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof YParserVisitor ) return ((YParserVisitor<? extends T>)visitor).visitCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			match(STRUCTURES_REGION);
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
		"\u0004\u0001G\r\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0005\u0000\u0006\b\u0000\n\u0000\f\u0000\t\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0000\u0000\u0002\u0000\u0002\u0000\u0000\u000b"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0002\n\u0001\u0000\u0000\u0000\u0004"+
		"\u0006\u0003\u0002\u0001\u0000\u0005\u0004\u0001\u0000\u0000\u0000\u0006"+
		"\t\u0001\u0000\u0000\u0000\u0007\u0005\u0001\u0000\u0000\u0000\u0007\b"+
		"\u0001\u0000\u0000\u0000\b\u0001\u0001\u0000\u0000\u0000\t\u0007\u0001"+
		"\u0000\u0000\u0000\n\u000b\u0005\u0007\u0000\u0000\u000b\u0003\u0001\u0000"+
		"\u0000\u0000\u0001\u0007";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}