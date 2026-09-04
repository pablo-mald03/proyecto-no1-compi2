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
		FUNCTION_REGION=8, LAMBDA=9, PRINT=10, READ=11, DEFINE=12, IF=13, ELSE_IF=14, 
		ELSE=15, SO=16, SWITCH=17, CASE=18, BREAK=19, ALWAYS=20, FOR=21, WHILE=22, 
		DO=23, RETURN=24, CONTINUE=25, INTEGER=26, STRING=27, FLOAT=28, CHARACTER=29, 
		BOOLEAN=30, TRUE=31, FALSE=32, EQUAL=33, COMMA=34, DOT_COMMA=35, TWO_POINTS=36, 
		DOT=37, INIT_BRACE=38, FINAL_BRACE=39, INIT_BRACKET=40, FINAL_BRACKET=41, 
		INIT_PARENT=42, FINAL_PARENT=43, ABREV_PLUS=44, ABREV_MINUS=45, PLUS=46, 
		MINUS=47, MULTIPLICATION=48, DIVIDE=49, EQUALS=50, GREATER_EQUALS=51, 
		LESS_EQUALS=52, DIFERENCE=53, LESS=54, GREATER=55, AND=56, OR=57, NOT=58, 
		ID=59, INT=60, DECIMAL=61, TEXT=62, CHAR=63, ERROR_TOKEN=64;
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
			"'->'", "'imprimir'", "'leer'", "'definir'", "'si'", "'sino'", "'contrario'", 
			"'entonces'", "'elegir'", "'caso'", "'romper'", "'siempre'", "'para'", 
			"'mientras'", "'hacer'", "'retornar'", "'continuar'", "'entero'", "'cadena'", 
			"'flotante'", "'caracter'", "'bool'", "'verdadero'", "'falso'", "'='", 
			"','", "';'", "':'", "'.'", "'{'", "'}'", "'['", "']'", "'('", "')'", 
			"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'=='", "'>='", "'<='", "'!='", 
			"'<'", "'>'", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "COMMENT", "BLOCK_COMMENT", "NEWLINE", "WS", 
			"STRUCTURES_REGION", "FUNCTION_REGION", "LAMBDA", "PRINT", "READ", "DEFINE", 
			"IF", "ELSE_IF", "ELSE", "SO", "SWITCH", "CASE", "BREAK", "ALWAYS", "FOR", 
			"WHILE", "DO", "RETURN", "CONTINUE", "INTEGER", "STRING", "FLOAT", "CHARACTER", 
			"BOOLEAN", "TRUE", "FALSE", "EQUAL", "COMMA", "DOT_COMMA", "TWO_POINTS", 
			"DOT", "INIT_BRACE", "FINAL_BRACE", "INIT_BRACKET", "FINAL_BRACKET", 
			"INIT_PARENT", "FINAL_PARENT", "ABREV_PLUS", "ABREV_MINUS", "PLUS", "MINUS", 
			"MULTIPLICATION", "DIVIDE", "EQUALS", "GREATER_EQUALS", "LESS_EQUALS", 
			"DIFERENCE", "LESS", "GREATER", "AND", "OR", "NOT", "ID", "INT", "DECIMAL", 
			"TEXT", "CHAR", "ERROR_TOKEN"
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
		"\u0004\u0001@\r\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
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