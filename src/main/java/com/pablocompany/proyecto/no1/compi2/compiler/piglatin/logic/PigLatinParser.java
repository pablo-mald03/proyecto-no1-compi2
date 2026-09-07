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
		RULE_program = 0, RULE_body = 1, RULE_import_list = 2, RULE_accessor = 3, 
		RULE_maior_section = 4, RULE_code_body = 5, RULE_statement = 6, RULE_block_code = 7, 
		RULE_if_statement = 8, RULE_else_if_list = 9, RULE_else_if_clause = 10, 
		RULE_else_statement = 11, RULE_while_statement = 12, RULE_do_while_statement = 13, 
		RULE_for_statement = 14, RULE_for_init = 15, RULE_for_update = 16, RULE_return_control = 17, 
		RULE_loop_control = 18, RULE_console_actions = 19, RULE_print_function = 20, 
		RULE_variable_section = 21, RULE_variabiles_body = 22, RULE_declaration = 23, 
		RULE_variable_declaration = 24, RULE_assignment = 25, RULE_compound_assignment = 26, 
		RULE_array_declaration = 27, RULE_array_initialization = 28, RULE_values_array_list = 29, 
		RULE_struct_declaration = 30, RULE_struct_body = 31, RULE_struct_normal_body = 32, 
		RULE_struct_comma_body = 33, RULE_struct_attribute = 34, RULE_variable_without_value = 35, 
		RULE_array_variable_struct = 36, RULE_struct_instance = 37, RULE_struct_literal = 38, 
		RULE_struct_data_list = 39, RULE_struct_data_value = 40, RULE_nest_variable = 41, 
		RULE_object_values = 42, RULE_arguments_list = 43, RULE_expression = 44, 
		RULE_variable_type = 45, RULE_normal_values = 46, RULE_boolean_values = 47, 
		RULE_abbreviated_operation = 48;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "body", "import_list", "accessor", "maior_section", "code_body", 
			"statement", "block_code", "if_statement", "else_if_list", "else_if_clause", 
			"else_statement", "while_statement", "do_while_statement", "for_statement", 
			"for_init", "for_update", "return_control", "loop_control", "console_actions", 
			"print_function", "variable_section", "variabiles_body", "declaration", 
			"variable_declaration", "assignment", "compound_assignment", "array_declaration", 
			"array_initialization", "values_array_list", "struct_declaration", "struct_body", 
			"struct_normal_body", "struct_comma_body", "struct_attribute", "variable_without_value", 
			"array_variable_struct", "struct_instance", "struct_literal", "struct_data_list", 
			"struct_data_value", "nest_variable", "object_values", "arguments_list", 
			"expression", "variable_type", "normal_values", "boolean_values", "abbreviated_operation"
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
		public TerminalNode EOF() { return getToken(PigLatinParser.EOF, 0); }
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 65584L) != 0)) {
				{
				{
				setState(98);
				body();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
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
		public List<Import_listContext> import_list() {
			return getRuleContexts(Import_listContext.class);
		}
		public Import_listContext import_list(int i) {
			return getRuleContext(Import_listContext.class,i);
		}
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
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(106);
				import_list();
				}
				}
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABILES) {
				{
				setState(112);
				variable_section();
				}
			}

			setState(115);
			maior_section();
			setState(116);
			match(FINIS_SEPARATOR);
			setState(117);
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
	public static class Import_listContext extends ParserRuleContext {
		public Import_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_list; }
	 
		public Import_listContext() { }
		public void copyFrom(Import_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportListsContext extends Import_listContext {
		public TerminalNode IMPORT() { return getToken(PigLatinParser.IMPORT, 0); }
		public AccessorContext accessor() {
			return getRuleContext(AccessorContext.class,0);
		}
		public ImportListsContext(Import_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterImportLists(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitImportLists(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitImportLists(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_listContext import_list() throws RecognitionException {
		Import_listContext _localctx = new Import_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_import_list);
		try {
			_localctx = new ImportListsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(IMPORT);
			setState(120);
			accessor();
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
		public AccessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessor; }
	 
		public AccessorContext() { }
		public void copyFrom(AccessorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccessorInstructionContext extends AccessorContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParser.ID, i);
		}
		public List<TerminalNode> DOT() { return getTokens(PigLatinParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PigLatinParser.DOT, i);
		}
		public AccessorInstructionContext(AccessorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterAccessorInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitAccessorInstruction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitAccessorInstruction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessorContext accessor() throws RecognitionException {
		AccessorContext _localctx = new AccessorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_accessor);
		int _la;
		try {
			_localctx = new AccessorInstructionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ID);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(123);
				match(DOT);
				setState(124);
				match(ID);
				}
				}
				setState(129);
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
		enterRule(_localctx, 8, RULE_maior_section);
		try {
			_localctx = new MaiorSectionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(MAIOR);
			setState(131);
			match(GREATER);
			setState(132);
			code_body();
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
	public static class CodeBodyStatementContext extends Code_bodyContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CodeBodyStatementContext(Code_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCodeBodyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCodeBodyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCodeBodyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Code_bodyContext code_body() throws RecognitionException {
		Code_bodyContext _localctx = new Code_bodyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_code_body);
		int _la;
		try {
			_localctx = new CodeBodyStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 7)) & ~0x3f) == 0 && ((1L << (_la - 7)) & 144121785175474179L) != 0)) {
				{
				{
				setState(134);
				statement();
				}
				}
				setState(139);
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
	public static class BlockCodeContext extends StatementContext {
		public Block_codeContext block_code() {
			return getRuleContext(Block_codeContext.class,0);
		}
		public BlockCodeContext(StatementContext ctx) { copyFrom(ctx); }
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
	public static class ConsoleActionsContext extends StatementContext {
		public Console_actionsContext console_actions() {
			return getRuleContext(Console_actionsContext.class,0);
		}
		public ConsoleActionsContext(StatementContext ctx) { copyFrom(ctx); }
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
	public static class ReturnControlActionContext extends StatementContext {
		public Return_controlContext return_control() {
			return getRuleContext(Return_controlContext.class,0);
		}
		public ReturnControlActionContext(StatementContext ctx) { copyFrom(ctx); }
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
	public static class StatementObjectPropertyCallingContext extends StatementContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public StatementObjectPropertyCallingContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStatementObjectPropertyCalling(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStatementObjectPropertyCalling(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStatementObjectPropertyCalling(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopControlActionContext extends StatementContext {
		public Loop_controlContext loop_control() {
			return getRuleContext(Loop_controlContext.class,0);
		}
		public LoopControlActionContext(StatementContext ctx) { copyFrom(ctx); }
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
	public static class LocalAssignmentContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public LocalAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterLocalAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitLocalAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitLocalAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LocalAbbreviatedOperationContext extends StatementContext {
		public Abbreviated_operationContext abbreviated_operation() {
			return getRuleContext(Abbreviated_operationContext.class,0);
		}
		public LocalAbbreviatedOperationContext(StatementContext ctx) { copyFrom(ctx); }
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement);
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new BlockCodeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				block_code();
				}
				break;
			case 2:
				_localctx = new ConsoleActionsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				console_actions();
				}
				break;
			case 3:
				_localctx = new LoopControlActionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				loop_control();
				}
				break;
			case 4:
				_localctx = new ReturnControlActionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				return_control();
				}
				break;
			case 5:
				_localctx = new LocalAbbreviatedOperationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				abbreviated_operation();
				}
				break;
			case 6:
				_localctx = new LocalAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				assignment();
				}
				break;
			case 7:
				_localctx = new StatementObjectPropertyCallingContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(146);
				object_values(0);
				setState(147);
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
		enterRule(_localctx, 14, RULE_block_code);
		try {
			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SI:
				_localctx = new CodeBlockIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				if_statement();
				}
				break;
			case DUM:
				_localctx = new CodeBlockWhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				while_statement();
				}
				break;
			case FACERE:
				_localctx = new CodeBlockDoWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				do_while_statement();
				}
				break;
			case PER:
				_localctx = new CodeBlockForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(154);
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
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
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
		enterRule(_localctx, 16, RULE_if_statement);
		try {
			_localctx = new IfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(SI);
			setState(158);
			match(INIT_PARENT);
			setState(159);
			expression(0);
			setState(160);
			match(FINAL_PARENT);
			setState(161);
			match(INIT_BRACE);
			setState(162);
			code_body();
			setState(163);
			match(FINAL_BRACE);
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(164);
				else_if_list();
				}
				break;
			}
			setState(167);
			else_statement();
			setState(168);
			match(FINIS);
			setState(169);
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
		Else_if_listContext _localctx = new Else_if_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_else_if_list);
		try {
			int _alt;
			_localctx = new ElseIfListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(172); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(171);
					else_if_clause();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(174); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
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
		enterRule(_localctx, 20, RULE_else_if_clause);
		try {
			_localctx = new ElseIfClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(ALITER);
			setState(177);
			match(INIT_PARENT);
			setState(178);
			expression(0);
			setState(179);
			match(FINAL_PARENT);
			setState(180);
			match(INIT_BRACE);
			setState(181);
			code_body();
			setState(182);
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
	public static class ElseStatementContext extends Else_statementContext {
		public TerminalNode ALITER() { return getToken(PigLatinParser.ALITER, 0); }
		public TerminalNode INIT_BRACE() { return getToken(PigLatinParser.INIT_BRACE, 0); }
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public ElseStatementContext(Else_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_else_statement);
		int _la;
		try {
			_localctx = new ElseStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ALITER) {
				{
				setState(184);
				match(ALITER);
				setState(185);
				match(INIT_BRACE);
				setState(186);
				code_body();
				setState(187);
				match(FINAL_BRACE);
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
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
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
		enterRule(_localctx, 24, RULE_while_statement);
		try {
			_localctx = new WhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(DUM);
			setState(192);
			match(INIT_PARENT);
			setState(193);
			expression(0);
			setState(194);
			match(FINAL_PARENT);
			setState(195);
			match(INIT_BRACE);
			setState(196);
			code_body();
			setState(197);
			match(FINAL_BRACE);
			setState(198);
			match(FINIS);
			setState(199);
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
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
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
		enterRule(_localctx, 26, RULE_do_while_statement);
		try {
			_localctx = new DoWhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(FACERE);
			setState(202);
			match(INIT_BRACE);
			setState(203);
			code_body();
			setState(204);
			match(FINAL_BRACE);
			setState(205);
			match(DUM);
			setState(206);
			match(INIT_PARENT);
			setState(207);
			expression(0);
			setState(208);
			match(FINAL_PARENT);
			setState(209);
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
		public Code_bodyContext code_body() {
			return getRuleContext(Code_bodyContext.class,0);
		}
		public TerminalNode FINAL_BRACE() { return getToken(PigLatinParser.FINAL_BRACE, 0); }
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
		enterRule(_localctx, 28, RULE_for_statement);
		try {
			_localctx = new ForStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(PER);
			setState(212);
			match(INIT_PARENT);
			setState(213);
			for_init();
			setState(214);
			match(DOT_COMMA);
			setState(215);
			expression(0);
			setState(216);
			match(DOT_COMMA);
			setState(217);
			for_update();
			setState(218);
			match(FINAL_PARENT);
			setState(219);
			match(INIT_BRACE);
			setState(220);
			code_body();
			setState(221);
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
		enterRule(_localctx, 30, RULE_for_init);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
				_localctx = new ForInitVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				match(ESTO);
				setState(224);
				match(ID);
				setState(225);
				match(TWO_POINTS);
				setState(226);
				variable_type();
				setState(227);
				expression(0);
				}
				break;
			case ID:
				_localctx = new ForInitAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(ID);
				setState(230);
				match(EQUAL);
				setState(231);
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
		enterRule(_localctx, 32, RULE_for_update);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new ForUpdateIncrementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(ID);
				setState(235);
				match(ABREV_PLUS);
				}
				break;
			case 2:
				_localctx = new ForUpdateDecrementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(ID);
				setState(237);
				match(ABREV_MINUS);
				}
				break;
			case 3:
				_localctx = new ForUpdateAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(238);
				match(ID);
				setState(239);
				match(EQUAL);
				setState(240);
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
	public static class ReturnStatementContext extends Return_controlContext {
		public TerminalNode REDDERE() { return getToken(PigLatinParser.REDDERE, 0); }
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(Return_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_controlContext return_control() throws RecognitionException {
		Return_controlContext _localctx = new Return_controlContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_return_control);
		int _la;
		try {
			_localctx = new ReturnStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(REDDERE);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 35465984647102475L) != 0)) {
				{
				setState(244);
				expression(0);
				}
			}

			setState(247);
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
		enterRule(_localctx, 36, RULE_loop_control);
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PERGE:
				_localctx = new LoopContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(249);
				match(PERGE);
				setState(250);
				match(DOT_COMMA);
				}
				break;
			case INTERRUMPE:
				_localctx = new LoopBreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(INTERRUMPE);
				setState(252);
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
		enterRule(_localctx, 38, RULE_console_actions);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new ReadVariableInputContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				nest_variable();
				setState(256);
				match(READ);
				}
				break;
			case READ:
				_localctx = new ReadInputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(258);
				match(READ);
				}
				break;
			case PRINT:
				_localctx = new PrintActionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
				match(PRINT);
				setState(260);
				print_function(0);
				setState(261);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_print_function, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PrintSingleExprContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(266);
			expression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(273);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrintMultipleExprContext(new Print_functionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_print_function);
					setState(268);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(269);
					match(PRINT);
					setState(270);
					expression(0);
					}
					} 
				}
				setState(275);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
		enterRule(_localctx, 42, RULE_variable_section);
		try {
			_localctx = new VariablesSectionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(VARIABILES);
			setState(277);
			match(GREATER);
			setState(278);
			variabiles_body();
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
	public static class VariabilesBodyContext extends Variabiles_bodyContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public VariabilesBodyContext(Variabiles_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterVariabilesBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitVariabilesBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitVariabilesBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variabiles_bodyContext variabiles_body() throws RecognitionException {
		Variabiles_bodyContext _localctx = new Variabiles_bodyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_variabiles_body);
		int _la;
		try {
			_localctx = new VariabilesBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(281); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(280);
				declaration();
				}
				}
				setState(283); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & 70371965403143L) != 0) );
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
	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalArrayInstanceContext extends DeclarationContext {
		public Array_declarationContext array_declaration() {
			return getRuleContext(Array_declarationContext.class,0);
		}
		public NormalArrayInstanceContext(DeclarationContext ctx) { copyFrom(ctx); }
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
	public static class StructDefinitionContext extends DeclarationContext {
		public Struct_declarationContext struct_declaration() {
			return getRuleContext(Struct_declarationContext.class,0);
		}
		public StructDefinitionContext(DeclarationContext ctx) { copyFrom(ctx); }
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
	public static class GlobalAbbreviatedOperationContext extends DeclarationContext {
		public Abbreviated_operationContext abbreviated_operation() {
			return getRuleContext(Abbreviated_operationContext.class,0);
		}
		public GlobalAbbreviatedOperationContext(DeclarationContext ctx) { copyFrom(ctx); }
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
	public static class VariableAssignmentContext extends DeclarationContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public VariableAssignmentContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterVariableAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitVariableAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitVariableAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableInstanceContext extends DeclarationContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public VariableInstanceContext(DeclarationContext ctx) { copyFrom(ctx); }
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
	public static class CompoundAssignmentContext extends DeclarationContext {
		public Compound_assignmentContext compound_assignment() {
			return getRuleContext(Compound_assignmentContext.class,0);
		}
		public CompoundAssignmentContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCompoundAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCompoundAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCompoundAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructVariableInstanceContext extends DeclarationContext {
		public Struct_instanceContext struct_instance() {
			return getRuleContext(Struct_instanceContext.class,0);
		}
		public StructVariableInstanceContext(DeclarationContext ctx) { copyFrom(ctx); }
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

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_declaration);
		try {
			setState(292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new VariableInstanceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				variable_declaration();
				}
				break;
			case 2:
				_localctx = new VariableAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				assignment();
				}
				break;
			case 3:
				_localctx = new NormalArrayInstanceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(287);
				array_declaration();
				}
				break;
			case 4:
				_localctx = new StructDefinitionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(288);
				struct_declaration();
				}
				break;
			case 5:
				_localctx = new StructVariableInstanceContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(289);
				struct_instance();
				}
				break;
			case 6:
				_localctx = new GlobalAbbreviatedOperationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(290);
				abbreviated_operation();
				}
				break;
			case 7:
				_localctx = new CompoundAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(291);
				compound_assignment();
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public Variable_typeContext variable_type() {
			return getRuleContext(Variable_typeContext.class,0);
		}
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
		enterRule(_localctx, 48, RULE_variable_declaration);
		try {
			_localctx = new VariableDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(ESTO);
			setState(295);
			match(ID);
			setState(296);
			match(TWO_POINTS);
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(297);
				variable_type();
				}
				break;
			}
			setState(300);
			expression(0);
			setState(301);
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
	public static class StructAssignmentContext extends AssignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PigLatinParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public StructAssignmentContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assignment);
		try {
			_localctx = new StructAssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			nest_variable();
			setState(304);
			match(EQUAL);
			setState(305);
			expression(0);
			setState(306);
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
		public TerminalNode BY_ONE_DIVISION() { return getToken(PigLatinParser.BY_ONE_DIVISION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public CompoundDivAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCompoundDivAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCompoundDivAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCompoundDivAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundModAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_PERCENT() { return getToken(PigLatinParser.BY_ONE_PERCENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public CompoundModAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCompoundModAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCompoundModAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCompoundModAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundSubAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_MINUS() { return getToken(PigLatinParser.BY_ONE_MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public CompoundSubAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCompoundSubAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCompoundSubAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCompoundSubAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundMulAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_MULTIPLICATION() { return getToken(PigLatinParser.BY_ONE_MULTIPLICATION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public CompoundMulAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCompoundMulAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCompoundMulAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCompoundMulAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundAddAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_ADD() { return getToken(PigLatinParser.BY_ONE_ADD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
		public CompoundAddAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterCompoundAddAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitCompoundAddAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitCompoundAddAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_assignmentContext compound_assignment() throws RecognitionException {
		Compound_assignmentContext _localctx = new Compound_assignmentContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_compound_assignment);
		try {
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new CompoundAddAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				nest_variable();
				setState(309);
				match(BY_ONE_ADD);
				setState(310);
				expression(0);
				setState(311);
				match(DOT_COMMA);
				}
				break;
			case 2:
				_localctx = new CompoundSubAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				nest_variable();
				setState(314);
				match(BY_ONE_MINUS);
				setState(315);
				expression(0);
				setState(316);
				match(DOT_COMMA);
				}
				break;
			case 3:
				_localctx = new CompoundMulAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(318);
				nest_variable();
				setState(319);
				match(BY_ONE_MULTIPLICATION);
				setState(320);
				expression(0);
				setState(321);
				match(DOT_COMMA);
				}
				break;
			case 4:
				_localctx = new CompoundDivAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(323);
				nest_variable();
				setState(324);
				match(BY_ONE_DIVISION);
				setState(325);
				expression(0);
				setState(326);
				match(DOT_COMMA);
				}
				break;
			case 5:
				_localctx = new CompoundModAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(328);
				nest_variable();
				setState(329);
				match(BY_ONE_PERCENT);
				setState(330);
				expression(0);
				setState(331);
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
	public static class Array_declarationContext extends ParserRuleContext {
		public Array_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_declaration; }
	 
		public Array_declarationContext() { }
		public void copyFrom(Array_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalArrayDeclarationContext extends Array_declarationContext {
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
		public NormalArrayDeclarationContext(Array_declarationContext ctx) { copyFrom(ctx); }
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

	public final Array_declarationContext array_declaration() throws RecognitionException {
		Array_declarationContext _localctx = new Array_declarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_array_declaration);
		int _la;
		try {
			_localctx = new NormalArrayDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(SERIES);
			setState(336);
			match(ID);
			setState(337);
			match(INIT_BRACKET);
			setState(338);
			expression(0);
			setState(339);
			match(FINAL_BRACKET);
			setState(340);
			match(TWO_POINTS);
			setState(341);
			variable_type();
			setState(343);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INIT_BRACE) {
				{
				setState(342);
				array_initialization();
				}
			}

			setState(345);
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
		enterRule(_localctx, 56, RULE_array_initialization);
		try {
			_localctx = new ArrayInitWithValuesContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			match(INIT_BRACE);
			setState(348);
			values_array_list();
			setState(349);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PigLatinParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigLatinParser.COMMA, i);
		}
		public Values_array_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values_array_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValues_array_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValues_array_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValues_array_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Values_array_listContext values_array_list() throws RecognitionException {
		Values_array_listContext _localctx = new Values_array_listContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_values_array_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			expression(0);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(352);
				match(COMMA);
				setState(353);
				expression(0);
				}
				}
				setState(358);
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
		enterRule(_localctx, 60, RULE_struct_declaration);
		try {
			_localctx = new StructDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(STRUCTURE);
			setState(360);
			match(ID);
			setState(361);
			match(INIT_BRACE);
			setState(362);
			struct_body();
			setState(363);
			match(FINAL_BRACE);
			setState(364);
			match(FINIS);
			setState(365);
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
		enterRule(_localctx, 62, RULE_struct_body);
		try {
			setState(369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new StructSeparatedBodyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				struct_normal_body();
				}
				break;
			case 2:
				_localctx = new StructCommaBodyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				struct_comma_body();
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
	public static class StructNormalBodyContext extends Struct_normal_bodyContext {
		public List<Struct_attributeContext> struct_attribute() {
			return getRuleContexts(Struct_attributeContext.class);
		}
		public Struct_attributeContext struct_attribute(int i) {
			return getRuleContext(Struct_attributeContext.class,i);
		}
		public List<TerminalNode> DOT_COMMA() { return getTokens(PigLatinParser.DOT_COMMA); }
		public TerminalNode DOT_COMMA(int i) {
			return getToken(PigLatinParser.DOT_COMMA, i);
		}
		public StructNormalBodyContext(Struct_normal_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructNormalBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructNormalBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructNormalBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_normal_bodyContext struct_normal_body() throws RecognitionException {
		Struct_normal_bodyContext _localctx = new Struct_normal_bodyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_struct_normal_body);
		int _la;
		try {
			_localctx = new StructNormalBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(374); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(371);
				struct_attribute();
				setState(372);
				match(DOT_COMMA);
				}
				}
				setState(376); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ESTO || _la==SERIES );
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
	public static class StructCommaStatementBodyContext extends Struct_comma_bodyContext {
		public List<Struct_attributeContext> struct_attribute() {
			return getRuleContexts(Struct_attributeContext.class);
		}
		public Struct_attributeContext struct_attribute(int i) {
			return getRuleContext(Struct_attributeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PigLatinParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigLatinParser.COMMA, i);
		}
		public StructCommaStatementBodyContext(Struct_comma_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructCommaStatementBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructCommaStatementBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructCommaStatementBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_comma_bodyContext struct_comma_body() throws RecognitionException {
		Struct_comma_bodyContext _localctx = new Struct_comma_bodyContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_struct_comma_body);
		int _la;
		try {
			_localctx = new StructCommaStatementBodyContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			struct_attribute();
			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(379);
				match(COMMA);
				setState(380);
				struct_attribute();
				}
				}
				setState(385);
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
		enterRule(_localctx, 68, RULE_struct_attribute);
		try {
			setState(388);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ESTO:
				_localctx = new NormalVariableStructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				variable_without_value();
				}
				break;
			case SERIES:
				_localctx = new ArrayVariableStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
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
		enterRule(_localctx, 70, RULE_variable_without_value);
		try {
			_localctx = new InternalStructNormalVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(ESTO);
			setState(391);
			match(ID);
			setState(392);
			match(TWO_POINTS);
			setState(393);
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
		enterRule(_localctx, 72, RULE_array_variable_struct);
		try {
			_localctx = new InternalStructArrayContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			match(SERIES);
			setState(396);
			match(ID);
			setState(397);
			match(TWO_POINTS);
			setState(398);
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
		public TerminalNode DOT_COMMA() { return getToken(PigLatinParser.DOT_COMMA, 0); }
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
		enterRule(_localctx, 74, RULE_struct_instance);
		try {
			_localctx = new StructInstanceContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			match(ESTO);
			setState(401);
			match(ID);
			setState(402);
			match(TWO_POINTS);
			setState(403);
			match(ID);
			setState(404);
			struct_literal();
			setState(405);
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
		enterRule(_localctx, 76, RULE_struct_literal);
		try {
			_localctx = new StructLiteralValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(INIT_BRACE);
			setState(408);
			struct_data_list();
			setState(409);
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
	public static class StructDataListContext extends Struct_data_listContext {
		public List<Struct_data_valueContext> struct_data_value() {
			return getRuleContexts(Struct_data_valueContext.class);
		}
		public Struct_data_valueContext struct_data_value(int i) {
			return getRuleContext(Struct_data_valueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PigLatinParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigLatinParser.COMMA, i);
		}
		public StructDataListContext(Struct_data_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterStructDataList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitStructDataList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitStructDataList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Struct_data_listContext struct_data_list() throws RecognitionException {
		Struct_data_listContext _localctx = new Struct_data_listContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_struct_data_list);
		int _la;
		try {
			_localctx = new StructDataListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			struct_data_value();
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(412);
				match(COMMA);
				setState(413);
				struct_data_value();
				}
				}
				setState(418);
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
		enterRule(_localctx, 80, RULE_struct_data_value);
		try {
			_localctx = new StructDataNormalContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(ID);
			setState(420);
			match(TWO_POINTS);
			setState(421);
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
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterNestedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitNestedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitNestedVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nest_variableContext nest_variable() throws RecognitionException {
		Nest_variableContext _localctx = new Nest_variableContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_nest_variable);
		try {
			_localctx = new NestedVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
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
	public static class ObjectMethodChainContext extends Object_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PigLatinParser.DOT, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public ObjectMethodChainContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterObjectMethodChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitObjectMethodChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitObjectMethodChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectArrayAccessChainContext extends Object_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode INIT_BRACKET() { return getToken(PigLatinParser.INIT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(PigLatinParser.FINAL_BRACKET, 0); }
		public ObjectArrayAccessChainContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterObjectArrayAccessChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitObjectArrayAccessChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitObjectArrayAccessChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectPropertyChainContext extends Object_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PigLatinParser.DOT, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public ObjectPropertyChainContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterObjectPropertyChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitObjectPropertyChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitObjectPropertyChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseFunctionCallContext extends Object_valuesContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public BaseFunctionCallContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBaseFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBaseFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBaseFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseIdentifierContext extends Object_valuesContext {
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public BaseIdentifierContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterBaseIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitBaseIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitBaseIdentifier(this);
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
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_object_values, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				_localctx = new BaseFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(426);
				match(ID);
				setState(427);
				match(INIT_PARENT);
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 35465984647102475L) != 0)) {
					{
					setState(428);
					arguments_list();
					}
				}

				setState(431);
				match(FINAL_PARENT);
				}
				break;
			case 2:
				{
				_localctx = new BaseIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(432);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(453);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(451);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ObjectPropertyChainContext(new Object_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_object_values);
						setState(435);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(436);
						match(DOT);
						setState(437);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new ObjectMethodChainContext(new Object_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_object_values);
						setState(438);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(439);
						match(DOT);
						setState(440);
						match(ID);
						setState(441);
						match(INIT_PARENT);
						setState(443);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 35465984647102475L) != 0)) {
							{
							setState(442);
							arguments_list();
							}
						}

						setState(445);
						match(FINAL_PARENT);
						}
						break;
					case 3:
						{
						_localctx = new ObjectArrayAccessChainContext(new Object_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_object_values);
						setState(446);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(447);
						match(INIT_BRACKET);
						setState(448);
						expression(0);
						setState(449);
						match(FINAL_BRACKET);
						}
						break;
					}
					} 
				}
				setState(455);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		public List<TerminalNode> COMMA() { return getTokens(PigLatinParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PigLatinParser.COMMA, i);
		}
		public ArgumentsListContext(Arguments_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterArgumentsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitArgumentsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitArgumentsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arguments_listContext arguments_list() throws RecognitionException {
		Arguments_listContext _localctx = new Arguments_listContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_arguments_list);
		int _la;
		try {
			_localctx = new ArgumentsListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			expression(0);
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(457);
				match(COMMA);
				setState(458);
				expression(0);
				}
				}
				setState(463);
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
		public TerminalNode PERCENT() { return getToken(PigLatinParser.PERCENT, 0); }
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
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INIT_PARENT:
				{
				_localctx = new ExpressionParentsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(465);
				match(INIT_PARENT);
				setState(466);
				expression(0);
				setState(467);
				match(FINAL_PARENT);
				}
				break;
			case MINUS:
			case NOT:
				{
				_localctx = new ExpressionUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(469);
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
				setState(470);
				expression(8);
				}
				break;
			case VERUM:
			case FALSUS:
			case NOVUS:
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
				setState(471);
				normal_values();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(494);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(492);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMultDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(474);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(475);
						((ExpressionMultDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31525197391593472L) != 0)) ) {
							((ExpressionMultDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(476);
						expression(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(477);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(478);
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
						setState(479);
						expression(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionRelationalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(480);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(481);
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
						setState(482);
						expression(6);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionEqualityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(483);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(484);
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
						setState(485);
						expression(5);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(486);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(487);
						match(AND);
						setState(488);
						expression(4);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(489);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(490);
						match(OR);
						setState(491);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(496);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		enterRule(_localctx, 90, RULE_variable_type);
		try {
			setState(503);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXTUM:
				_localctx = new TypeTextContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(497);
				match(TEXTUM);
				}
				break;
			case NUMERUS:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(498);
				match(NUMERUS);
				}
				break;
			case DECIMALIS:
				_localctx = new TypeDecimalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(499);
				match(DECIMALIS);
				}
				break;
			case LITTERA:
				_localctx = new TypeCharContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(500);
				match(LITTERA);
				}
				break;
			case BOOLEAN:
				_localctx = new TypeBooleanContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(501);
				match(BOOLEAN);
				}
				break;
			case ID:
				_localctx = new TypeCustomIdContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(502);
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
	public static class ValStructNestValueContext extends Normal_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
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
	public static class ValNewInstanceContext extends Normal_valuesContext {
		public TerminalNode NOVUS() { return getToken(PigLatinParser.NOVUS, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(PigLatinParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(PigLatinParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public ValNewInstanceContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValNewInstance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValNewInstance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValNewInstance(this);
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
	public static class ValArrayInitialLiteralContext extends Normal_valuesContext {
		public Array_initializationContext array_initialization() {
			return getRuleContext(Array_initializationContext.class,0);
		}
		public ValArrayInitialLiteralContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).enterValArrayInitialLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinParserListener ) ((PigLatinParserListener)listener).exitValArrayInitialLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinParserVisitor ) return ((PigLatinParserVisitor<? extends T>)visitor).visitValArrayInitialLiteral(this);
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
		enterRule(_localctx, 92, RULE_normal_values);
		int _la;
		try {
			setState(520);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new ValStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(505);
				match(STRING);
				}
				break;
			case 2:
				_localctx = new ValCharContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(506);
				match(CHAR);
				}
				break;
			case 3:
				_localctx = new ValDecimalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(507);
				match(DECIMAL);
				}
				break;
			case 4:
				_localctx = new ValIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(508);
				match(INT);
				}
				break;
			case 5:
				_localctx = new ValBoolContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(509);
				boolean_values();
				}
				break;
			case 6:
				_localctx = new ValStructNestValueContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(510);
				object_values(0);
				}
				break;
			case 7:
				_localctx = new ValStructPropertyLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(511);
				struct_literal();
				}
				break;
			case 8:
				_localctx = new ValArrayInitialLiteralContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(512);
				array_initialization();
				}
				break;
			case 9:
				_localctx = new ValNewInstanceContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(513);
				match(NOVUS);
				setState(514);
				match(ID);
				setState(515);
				match(INIT_PARENT);
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & 35465984647102475L) != 0)) {
					{
					setState(516);
					arguments_list();
					}
				}

				setState(519);
				match(FINAL_PARENT);
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
		enterRule(_localctx, 94, RULE_boolean_values);
		try {
			setState(524);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VERUM:
				_localctx = new BoolTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(522);
				match(VERUM);
				}
				break;
			case FALSUS:
				_localctx = new BoolFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(523);
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
		enterRule(_localctx, 96, RULE_abbreviated_operation);
		try {
			setState(542);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new IncOperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(526);
				nest_variable();
				setState(527);
				match(ABREV_PLUS);
				setState(528);
				match(DOT_COMMA);
				}
				break;
			case 2:
				_localctx = new DecOperationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(530);
				nest_variable();
				setState(531);
				match(ABREV_MINUS);
				setState(532);
				match(DOT_COMMA);
				}
				break;
			case 3:
				_localctx = new IncPrevOperationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(534);
				match(ABREV_PLUS);
				setState(535);
				nest_variable();
				setState(536);
				match(DOT_COMMA);
				}
				break;
			case 4:
				_localctx = new DecPrevOperationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(538);
				match(ABREV_MINUS);
				setState(539);
				nest_variable();
				setState(540);
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
		case 20:
			return print_function_sempred((Print_functionContext)_localctx, predIndex);
		case 42:
			return object_values_sempred((Object_valuesContext)_localctx, predIndex);
		case 44:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean print_function_sempred(Print_functionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean object_values_sempred(Object_valuesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001E\u0221\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u0001\u0000\u0005\u0000"+
		"d\b\u0000\n\u0000\f\u0000g\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0005\u0001l\b\u0001\n\u0001\f\u0001o\t\u0001\u0001\u0001\u0003\u0001"+
		"r\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"~\b\u0003\n\u0003\f\u0003\u0081\t\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0005\u0005\u0088\b\u0005\n\u0005\f\u0005"+
		"\u008b\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0096\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u009c\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00a6\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0004\t\u00ad\b\t"+
		"\u000b\t\f\t\u00ae\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00be\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00e9\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00f2\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u00f6\b\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00fe\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u0108\b\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0110\b\u0014\n"+
		"\u0014\f\u0014\u0113\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0016\u0004\u0016\u011a\b\u0016\u000b\u0016\f\u0016\u011b"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0003\u0017\u0125\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0003\u0018\u012b\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u014e\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0158\b\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0163\b\u001d\n\u001d"+
		"\f\u001d\u0166\t\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u0172\b\u001f\u0001 \u0001 \u0001 \u0004 \u0177\b \u000b"+
		" \f \u0178\u0001!\u0001!\u0001!\u0005!\u017e\b!\n!\f!\u0181\t!\u0001\""+
		"\u0001\"\u0003\"\u0185\b\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0005\'\u019f\b"+
		"\'\n\'\f\'\u01a2\t\'\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001*"+
		"\u0001*\u0001*\u0001*\u0003*\u01ae\b*\u0001*\u0001*\u0003*\u01b2\b*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0003*\u01bc\b*\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u01c4\b*\n*\f*\u01c7\t*\u0001"+
		"+\u0001+\u0001+\u0005+\u01cc\b+\n+\f+\u01cf\t+\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0003,\u01d9\b,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0005,\u01ed\b,\n,\f,\u01f0\t,\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0003-\u01f8\b-\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0003.\u0206"+
		"\b.\u0001.\u0003.\u0209\b.\u0001/\u0001/\u0003/\u020d\b/\u00010\u0001"+
		"0\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u00010\u0001"+
		"0\u00010\u00010\u00010\u00010\u00030\u021f\b0\u00010\u0000\u0003(TX1\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`\u0000\u0005\u0002\u000033??"+
		"\u0001\u000046\u0001\u000023\u0002\u000089;<\u0002\u000077::\u023c\u0000"+
		"e\u0001\u0000\u0000\u0000\u0002m\u0001\u0000\u0000\u0000\u0004w\u0001"+
		"\u0000\u0000\u0000\u0006z\u0001\u0000\u0000\u0000\b\u0082\u0001\u0000"+
		"\u0000\u0000\n\u0089\u0001\u0000\u0000\u0000\f\u0095\u0001\u0000\u0000"+
		"\u0000\u000e\u009b\u0001\u0000\u0000\u0000\u0010\u009d\u0001\u0000\u0000"+
		"\u0000\u0012\u00ac\u0001\u0000\u0000\u0000\u0014\u00b0\u0001\u0000\u0000"+
		"\u0000\u0016\u00bd\u0001\u0000\u0000\u0000\u0018\u00bf\u0001\u0000\u0000"+
		"\u0000\u001a\u00c9\u0001\u0000\u0000\u0000\u001c\u00d3\u0001\u0000\u0000"+
		"\u0000\u001e\u00e8\u0001\u0000\u0000\u0000 \u00f1\u0001\u0000\u0000\u0000"+
		"\"\u00f3\u0001\u0000\u0000\u0000$\u00fd\u0001\u0000\u0000\u0000&\u0107"+
		"\u0001\u0000\u0000\u0000(\u0109\u0001\u0000\u0000\u0000*\u0114\u0001\u0000"+
		"\u0000\u0000,\u0119\u0001\u0000\u0000\u0000.\u0124\u0001\u0000\u0000\u0000"+
		"0\u0126\u0001\u0000\u0000\u00002\u012f\u0001\u0000\u0000\u00004\u014d"+
		"\u0001\u0000\u0000\u00006\u014f\u0001\u0000\u0000\u00008\u015b\u0001\u0000"+
		"\u0000\u0000:\u015f\u0001\u0000\u0000\u0000<\u0167\u0001\u0000\u0000\u0000"+
		">\u0171\u0001\u0000\u0000\u0000@\u0176\u0001\u0000\u0000\u0000B\u017a"+
		"\u0001\u0000\u0000\u0000D\u0184\u0001\u0000\u0000\u0000F\u0186\u0001\u0000"+
		"\u0000\u0000H\u018b\u0001\u0000\u0000\u0000J\u0190\u0001\u0000\u0000\u0000"+
		"L\u0197\u0001\u0000\u0000\u0000N\u019b\u0001\u0000\u0000\u0000P\u01a3"+
		"\u0001\u0000\u0000\u0000R\u01a7\u0001\u0000\u0000\u0000T\u01b1\u0001\u0000"+
		"\u0000\u0000V\u01c8\u0001\u0000\u0000\u0000X\u01d8\u0001\u0000\u0000\u0000"+
		"Z\u01f7\u0001\u0000\u0000\u0000\\\u0208\u0001\u0000\u0000\u0000^\u020c"+
		"\u0001\u0000\u0000\u0000`\u021e\u0001\u0000\u0000\u0000bd\u0003\u0002"+
		"\u0001\u0000cb\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000hi\u0005\u0000\u0000\u0001i\u0001\u0001\u0000"+
		"\u0000\u0000jl\u0003\u0004\u0002\u0000kj\u0001\u0000\u0000\u0000lo\u0001"+
		"\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pr\u0003*\u0015\u0000"+
		"qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000st\u0003\b\u0004\u0000tu\u0005\u0006\u0000\u0000uv\u0005\"\u0000"+
		"\u0000v\u0003\u0001\u0000\u0000\u0000wx\u0005\u0010\u0000\u0000xy\u0003"+
		"\u0006\u0003\u0000y\u0005\u0001\u0000\u0000\u0000z\u007f\u0005@\u0000"+
		"\u0000{|\u0005$\u0000\u0000|~\u0005@\u0000\u0000}{\u0001\u0000\u0000\u0000"+
		"~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0007\u0001\u0000\u0000\u0000\u0081\u007f"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0005\u0000\u0000\u0083\u0084"+
		"\u0005<\u0000\u0000\u0084\u0085\u0003\n\u0005\u0000\u0085\t\u0001\u0000"+
		"\u0000\u0000\u0086\u0088\u0003\f\u0006\u0000\u0087\u0086\u0001\u0000\u0000"+
		"\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u000b\u0001\u0000\u0000"+
		"\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u0096\u0003\u000e\u0007"+
		"\u0000\u008d\u0096\u0003&\u0013\u0000\u008e\u0096\u0003$\u0012\u0000\u008f"+
		"\u0096\u0003\"\u0011\u0000\u0090\u0096\u0003`0\u0000\u0091\u0096\u0003"+
		"2\u0019\u0000\u0092\u0093\u0003T*\u0000\u0093\u0094\u0005\"\u0000\u0000"+
		"\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u008c\u0001\u0000\u0000\u0000"+
		"\u0095\u008d\u0001\u0000\u0000\u0000\u0095\u008e\u0001\u0000\u0000\u0000"+
		"\u0095\u008f\u0001\u0000\u0000\u0000\u0095\u0090\u0001\u0000\u0000\u0000"+
		"\u0095\u0091\u0001\u0000\u0000\u0000\u0095\u0092\u0001\u0000\u0000\u0000"+
		"\u0096\r\u0001\u0000\u0000\u0000\u0097\u009c\u0003\u0010\b\u0000\u0098"+
		"\u009c\u0003\u0018\f\u0000\u0099\u009c\u0003\u001a\r\u0000\u009a\u009c"+
		"\u0003\u001c\u000e\u0000\u009b\u0097\u0001\u0000\u0000\u0000\u009b\u0098"+
		"\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009a"+
		"\u0001\u0000\u0000\u0000\u009c\u000f\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0005\u0019\u0000\u0000\u009e\u009f\u0005)\u0000\u0000\u009f\u00a0\u0003"+
		"X,\u0000\u00a0\u00a1\u0005*\u0000\u0000\u00a1\u00a2\u0005%\u0000\u0000"+
		"\u00a2\u00a3\u0003\n\u0005\u0000\u00a3\u00a5\u0005&\u0000\u0000\u00a4"+
		"\u00a6\u0003\u0012\t\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\u0003\u0016\u000b\u0000\u00a8\u00a9\u0005\u0015\u0000\u0000\u00a9\u00aa"+
		"\u0005\"\u0000\u0000\u00aa\u0011\u0001\u0000\u0000\u0000\u00ab\u00ad\u0003"+
		"\u0014\n\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000"+
		"\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000"+
		"\u0000\u0000\u00af\u0013\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u001a"+
		"\u0000\u0000\u00b1\u00b2\u0005)\u0000\u0000\u00b2\u00b3\u0003X,\u0000"+
		"\u00b3\u00b4\u0005*\u0000\u0000\u00b4\u00b5\u0005%\u0000\u0000\u00b5\u00b6"+
		"\u0003\n\u0005\u0000\u00b6\u00b7\u0005&\u0000\u0000\u00b7\u0015\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b9\u0005\u001a\u0000\u0000\u00b9\u00ba\u0005"+
		"%\u0000\u0000\u00ba\u00bb\u0003\n\u0005\u0000\u00bb\u00bc\u0005&\u0000"+
		"\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00b8\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u0017\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0005\u0016\u0000\u0000\u00c0\u00c1\u0005)\u0000\u0000"+
		"\u00c1\u00c2\u0003X,\u0000\u00c2\u00c3\u0005*\u0000\u0000\u00c3\u00c4"+
		"\u0005%\u0000\u0000\u00c4\u00c5\u0003\n\u0005\u0000\u00c5\u00c6\u0005"+
		"&\u0000\u0000\u00c6\u00c7\u0005\u0015\u0000\u0000\u00c7\u00c8\u0005\""+
		"\u0000\u0000\u00c8\u0019\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u0017"+
		"\u0000\u0000\u00ca\u00cb\u0005%\u0000\u0000\u00cb\u00cc\u0003\n\u0005"+
		"\u0000\u00cc\u00cd\u0005&\u0000\u0000\u00cd\u00ce\u0005\u0016\u0000\u0000"+
		"\u00ce\u00cf\u0005)\u0000\u0000\u00cf\u00d0\u0003X,\u0000\u00d0\u00d1"+
		"\u0005*\u0000\u0000\u00d1\u00d2\u0005\"\u0000\u0000\u00d2\u001b\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0005\u0018\u0000\u0000\u00d4\u00d5\u0005"+
		")\u0000\u0000\u00d5\u00d6\u0003\u001e\u000f\u0000\u00d6\u00d7\u0005\""+
		"\u0000\u0000\u00d7\u00d8\u0003X,\u0000\u00d8\u00d9\u0005\"\u0000\u0000"+
		"\u00d9\u00da\u0003 \u0010\u0000\u00da\u00db\u0005*\u0000\u0000\u00db\u00dc"+
		"\u0005%\u0000\u0000\u00dc\u00dd\u0003\n\u0005\u0000\u00dd\u00de\u0005"+
		"&\u0000\u0000\u00de\u001d\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0012"+
		"\u0000\u0000\u00e0\u00e1\u0005@\u0000\u0000\u00e1\u00e2\u0005#\u0000\u0000"+
		"\u00e2\u00e3\u0003Z-\u0000\u00e3\u00e4\u0003X,\u0000\u00e4\u00e9\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e6\u0005@\u0000\u0000\u00e6\u00e7\u0005 \u0000"+
		"\u0000\u00e7\u00e9\u0003X,\u0000\u00e8\u00df\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e9\u001f\u0001\u0000\u0000\u0000\u00ea"+
		"\u00eb\u0005@\u0000\u0000\u00eb\u00f2\u00050\u0000\u0000\u00ec\u00ed\u0005"+
		"@\u0000\u0000\u00ed\u00f2\u00051\u0000\u0000\u00ee\u00ef\u0005@\u0000"+
		"\u0000\u00ef\u00f0\u0005 \u0000\u0000\u00f0\u00f2\u0003X,\u0000\u00f1"+
		"\u00ea\u0001\u0000\u0000\u0000\u00f1\u00ec\u0001\u0000\u0000\u0000\u00f1"+
		"\u00ee\u0001\u0000\u0000\u0000\u00f2!\u0001\u0000\u0000\u0000\u00f3\u00f5"+
		"\u0005\u001d\u0000\u0000\u00f4\u00f6\u0003X,\u0000\u00f5\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f8\u0005\"\u0000\u0000\u00f8#\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0005\u001e\u0000\u0000\u00fa\u00fe\u0005\"\u0000\u0000"+
		"\u00fb\u00fc\u0005\u001f\u0000\u0000\u00fc\u00fe\u0005\"\u0000\u0000\u00fd"+
		"\u00f9\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe"+
		"%\u0001\u0000\u0000\u0000\u00ff\u0100\u0003R)\u0000\u0100\u0101\u0005"+
		"\b\u0000\u0000\u0101\u0108\u0001\u0000\u0000\u0000\u0102\u0108\u0005\b"+
		"\u0000\u0000\u0103\u0104\u0005\u0007\u0000\u0000\u0104\u0105\u0003(\u0014"+
		"\u0000\u0105\u0106\u0005\"\u0000\u0000\u0106\u0108\u0001\u0000\u0000\u0000"+
		"\u0107\u00ff\u0001\u0000\u0000\u0000\u0107\u0102\u0001\u0000\u0000\u0000"+
		"\u0107\u0103\u0001\u0000\u0000\u0000\u0108\'\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0006\u0014\uffff\uffff\u0000\u010a\u010b\u0003X,\u0000\u010b\u0111"+
		"\u0001\u0000\u0000\u0000\u010c\u010d\n\u0002\u0000\u0000\u010d\u010e\u0005"+
		"\u0007\u0000\u0000\u010e\u0110\u0003X,\u0000\u010f\u010c\u0001\u0000\u0000"+
		"\u0000\u0110\u0113\u0001\u0000\u0000\u0000\u0111\u010f\u0001\u0000\u0000"+
		"\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112)\u0001\u0000\u0000\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0114\u0115\u0005\u0004\u0000\u0000"+
		"\u0115\u0116\u0005<\u0000\u0000\u0116\u0117\u0003,\u0016\u0000\u0117+"+
		"\u0001\u0000\u0000\u0000\u0118\u011a\u0003.\u0017\u0000\u0119\u0118\u0001"+
		"\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u0119\u0001"+
		"\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c-\u0001\u0000"+
		"\u0000\u0000\u011d\u0125\u00030\u0018\u0000\u011e\u0125\u00032\u0019\u0000"+
		"\u011f\u0125\u00036\u001b\u0000\u0120\u0125\u0003<\u001e\u0000\u0121\u0125"+
		"\u0003J%\u0000\u0122\u0125\u0003`0\u0000\u0123\u0125\u00034\u001a\u0000"+
		"\u0124\u011d\u0001\u0000\u0000\u0000\u0124\u011e\u0001\u0000\u0000\u0000"+
		"\u0124\u011f\u0001\u0000\u0000\u0000\u0124\u0120\u0001\u0000\u0000\u0000"+
		"\u0124\u0121\u0001\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000"+
		"\u0124\u0123\u0001\u0000\u0000\u0000\u0125/\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0005\u0012\u0000\u0000\u0127\u0128\u0005@\u0000\u0000\u0128\u012a"+
		"\u0005#\u0000\u0000\u0129\u012b\u0003Z-\u0000\u012a\u0129\u0001\u0000"+
		"\u0000\u0000\u012a\u012b\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000"+
		"\u0000\u0000\u012c\u012d\u0003X,\u0000\u012d\u012e\u0005\"\u0000\u0000"+
		"\u012e1\u0001\u0000\u0000\u0000\u012f\u0130\u0003R)\u0000\u0130\u0131"+
		"\u0005 \u0000\u0000\u0131\u0132\u0003X,\u0000\u0132\u0133\u0005\"\u0000"+
		"\u0000\u01333\u0001\u0000\u0000\u0000\u0134\u0135\u0003R)\u0000\u0135"+
		"\u0136\u0005+\u0000\u0000\u0136\u0137\u0003X,\u0000\u0137\u0138\u0005"+
		"\"\u0000\u0000\u0138\u014e\u0001\u0000\u0000\u0000\u0139\u013a\u0003R"+
		")\u0000\u013a\u013b\u0005,\u0000\u0000\u013b\u013c\u0003X,\u0000\u013c"+
		"\u013d\u0005\"\u0000\u0000\u013d\u014e\u0001\u0000\u0000\u0000\u013e\u013f"+
		"\u0003R)\u0000\u013f\u0140\u0005-\u0000\u0000\u0140\u0141\u0003X,\u0000"+
		"\u0141\u0142\u0005\"\u0000\u0000\u0142\u014e\u0001\u0000\u0000\u0000\u0143"+
		"\u0144\u0003R)\u0000\u0144\u0145\u0005.\u0000\u0000\u0145\u0146\u0003"+
		"X,\u0000\u0146\u0147\u0005\"\u0000\u0000\u0147\u014e\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0003R)\u0000\u0149\u014a\u0005/\u0000\u0000\u014a"+
		"\u014b\u0003X,\u0000\u014b\u014c\u0005\"\u0000\u0000\u014c\u014e\u0001"+
		"\u0000\u0000\u0000\u014d\u0134\u0001\u0000\u0000\u0000\u014d\u0139\u0001"+
		"\u0000\u0000\u0000\u014d\u013e\u0001\u0000\u0000\u0000\u014d\u0143\u0001"+
		"\u0000\u0000\u0000\u014d\u0148\u0001\u0000\u0000\u0000\u014e5\u0001\u0000"+
		"\u0000\u0000\u014f\u0150\u0005\u0013\u0000\u0000\u0150\u0151\u0005@\u0000"+
		"\u0000\u0151\u0152\u0005\'\u0000\u0000\u0152\u0153\u0003X,\u0000\u0153"+
		"\u0154\u0005(\u0000\u0000\u0154\u0155\u0005#\u0000\u0000\u0155\u0157\u0003"+
		"Z-\u0000\u0156\u0158\u00038\u001c\u0000\u0157\u0156\u0001\u0000\u0000"+
		"\u0000\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000"+
		"\u0000\u0159\u015a\u0005\"\u0000\u0000\u015a7\u0001\u0000\u0000\u0000"+
		"\u015b\u015c\u0005%\u0000\u0000\u015c\u015d\u0003:\u001d\u0000\u015d\u015e"+
		"\u0005&\u0000\u0000\u015e9\u0001\u0000\u0000\u0000\u015f\u0164\u0003X"+
		",\u0000\u0160\u0161\u0005!\u0000\u0000\u0161\u0163\u0003X,\u0000\u0162"+
		"\u0160\u0001\u0000\u0000\u0000\u0163\u0166\u0001\u0000\u0000\u0000\u0164"+
		"\u0162\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165"+
		";\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0167\u0168"+
		"\u0005\u0014\u0000\u0000\u0168\u0169\u0005@\u0000\u0000\u0169\u016a\u0005"+
		"%\u0000\u0000\u016a\u016b\u0003>\u001f\u0000\u016b\u016c\u0005&\u0000"+
		"\u0000\u016c\u016d\u0005\u0015\u0000\u0000\u016d\u016e\u0005\"\u0000\u0000"+
		"\u016e=\u0001\u0000\u0000\u0000\u016f\u0172\u0003@ \u0000\u0170\u0172"+
		"\u0003B!\u0000\u0171\u016f\u0001\u0000\u0000\u0000\u0171\u0170\u0001\u0000"+
		"\u0000\u0000\u0172?\u0001\u0000\u0000\u0000\u0173\u0174\u0003D\"\u0000"+
		"\u0174\u0175\u0005\"\u0000\u0000\u0175\u0177\u0001\u0000\u0000\u0000\u0176"+
		"\u0173\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u0178"+
		"\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179"+
		"A\u0001\u0000\u0000\u0000\u017a\u017f\u0003D\"\u0000\u017b\u017c\u0005"+
		"!\u0000\u0000\u017c\u017e\u0003D\"\u0000\u017d\u017b\u0001\u0000\u0000"+
		"\u0000\u017e\u0181\u0001\u0000\u0000\u0000\u017f\u017d\u0001\u0000\u0000"+
		"\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180C\u0001\u0000\u0000\u0000"+
		"\u0181\u017f\u0001\u0000\u0000\u0000\u0182\u0185\u0003F#\u0000\u0183\u0185"+
		"\u0003H$\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184\u0183\u0001\u0000"+
		"\u0000\u0000\u0185E\u0001\u0000\u0000\u0000\u0186\u0187\u0005\u0012\u0000"+
		"\u0000\u0187\u0188\u0005@\u0000\u0000\u0188\u0189\u0005#\u0000\u0000\u0189"+
		"\u018a\u0003Z-\u0000\u018aG\u0001\u0000\u0000\u0000\u018b\u018c\u0005"+
		"\u0013\u0000\u0000\u018c\u018d\u0005@\u0000\u0000\u018d\u018e\u0005#\u0000"+
		"\u0000\u018e\u018f\u0003Z-\u0000\u018fI\u0001\u0000\u0000\u0000\u0190"+
		"\u0191\u0005\u0012\u0000\u0000\u0191\u0192\u0005@\u0000\u0000\u0192\u0193"+
		"\u0005#\u0000\u0000\u0193\u0194\u0005@\u0000\u0000\u0194\u0195\u0003L"+
		"&\u0000\u0195\u0196\u0005\"\u0000\u0000\u0196K\u0001\u0000\u0000\u0000"+
		"\u0197\u0198\u0005%\u0000\u0000\u0198\u0199\u0003N\'\u0000\u0199\u019a"+
		"\u0005&\u0000\u0000\u019aM\u0001\u0000\u0000\u0000\u019b\u01a0\u0003P"+
		"(\u0000\u019c\u019d\u0005!\u0000\u0000\u019d\u019f\u0003P(\u0000\u019e"+
		"\u019c\u0001\u0000\u0000\u0000\u019f\u01a2\u0001\u0000\u0000\u0000\u01a0"+
		"\u019e\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1"+
		"O\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a3\u01a4"+
		"\u0005@\u0000\u0000\u01a4\u01a5\u0005#\u0000\u0000\u01a5\u01a6\u0003X"+
		",\u0000\u01a6Q\u0001\u0000\u0000\u0000\u01a7\u01a8\u0003T*\u0000\u01a8"+
		"S\u0001\u0000\u0000\u0000\u01a9\u01aa\u0006*\uffff\uffff\u0000\u01aa\u01ab"+
		"\u0005@\u0000\u0000\u01ab\u01ad\u0005)\u0000\u0000\u01ac\u01ae\u0003V"+
		"+\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000"+
		"\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af\u01b2\u0005*\u0000\u0000"+
		"\u01b0\u01b2\u0005@\u0000\u0000\u01b1\u01a9\u0001\u0000\u0000\u0000\u01b1"+
		"\u01b0\u0001\u0000\u0000\u0000\u01b2\u01c5\u0001\u0000\u0000\u0000\u01b3"+
		"\u01b4\n\u0005\u0000\u0000\u01b4\u01b5\u0005$\u0000\u0000\u01b5\u01c4"+
		"\u0005@\u0000\u0000\u01b6\u01b7\n\u0004\u0000\u0000\u01b7\u01b8\u0005"+
		"$\u0000\u0000\u01b8\u01b9\u0005@\u0000\u0000\u01b9\u01bb\u0005)\u0000"+
		"\u0000\u01ba\u01bc\u0003V+\u0000\u01bb\u01ba\u0001\u0000\u0000\u0000\u01bb"+
		"\u01bc\u0001\u0000\u0000\u0000\u01bc\u01bd\u0001\u0000\u0000\u0000\u01bd"+
		"\u01c4\u0005*\u0000\u0000\u01be\u01bf\n\u0003\u0000\u0000\u01bf\u01c0"+
		"\u0005\'\u0000\u0000\u01c0\u01c1\u0003X,\u0000\u01c1\u01c2\u0005(\u0000"+
		"\u0000\u01c2\u01c4\u0001\u0000\u0000\u0000\u01c3\u01b3\u0001\u0000\u0000"+
		"\u0000\u01c3\u01b6\u0001\u0000\u0000\u0000\u01c3\u01be\u0001\u0000\u0000"+
		"\u0000\u01c4\u01c7\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6U\u0001\u0000\u0000\u0000"+
		"\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c8\u01cd\u0003X,\u0000\u01c9\u01ca"+
		"\u0005!\u0000\u0000\u01ca\u01cc\u0003X,\u0000\u01cb\u01c9\u0001\u0000"+
		"\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001\u0000"+
		"\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ceW\u0001\u0000\u0000"+
		"\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0\u01d1\u0006,\uffff\uffff"+
		"\u0000\u01d1\u01d2\u0005)\u0000\u0000\u01d2\u01d3\u0003X,\u0000\u01d3"+
		"\u01d4\u0005*\u0000\u0000\u01d4\u01d9\u0001\u0000\u0000\u0000\u01d5\u01d6"+
		"\u0007\u0000\u0000\u0000\u01d6\u01d9\u0003X,\b\u01d7\u01d9\u0003\\.\u0000"+
		"\u01d8\u01d0\u0001\u0000\u0000\u0000\u01d8\u01d5\u0001\u0000\u0000\u0000"+
		"\u01d8\u01d7\u0001\u0000\u0000\u0000\u01d9\u01ee\u0001\u0000\u0000\u0000"+
		"\u01da\u01db\n\u0007\u0000\u0000\u01db\u01dc\u0007\u0001\u0000\u0000\u01dc"+
		"\u01ed\u0003X,\b\u01dd\u01de\n\u0006\u0000\u0000\u01de\u01df\u0007\u0002"+
		"\u0000\u0000\u01df\u01ed\u0003X,\u0007\u01e0\u01e1\n\u0005\u0000\u0000"+
		"\u01e1\u01e2\u0007\u0003\u0000\u0000\u01e2\u01ed\u0003X,\u0006\u01e3\u01e4"+
		"\n\u0004\u0000\u0000\u01e4\u01e5\u0007\u0004\u0000\u0000\u01e5\u01ed\u0003"+
		"X,\u0005\u01e6\u01e7\n\u0003\u0000\u0000\u01e7\u01e8\u0005=\u0000\u0000"+
		"\u01e8\u01ed\u0003X,\u0004\u01e9\u01ea\n\u0002\u0000\u0000\u01ea\u01eb"+
		"\u0005>\u0000\u0000\u01eb\u01ed\u0003X,\u0003\u01ec\u01da\u0001\u0000"+
		"\u0000\u0000\u01ec\u01dd\u0001\u0000\u0000\u0000\u01ec\u01e0\u0001\u0000"+
		"\u0000\u0000\u01ec\u01e3\u0001\u0000\u0000\u0000\u01ec\u01e6\u0001\u0000"+
		"\u0000\u0000\u01ec\u01e9\u0001\u0000\u0000\u0000\u01ed\u01f0\u0001\u0000"+
		"\u0000\u0000\u01ee\u01ec\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000"+
		"\u0000\u0000\u01efY\u0001\u0000\u0000\u0000\u01f0\u01ee\u0001\u0000\u0000"+
		"\u0000\u01f1\u01f8\u0005\n\u0000\u0000\u01f2\u01f8\u0005\t\u0000\u0000"+
		"\u01f3\u01f8\u0005\u000b\u0000\u0000\u01f4\u01f8\u0005\f\u0000\u0000\u01f5"+
		"\u01f8\u0005\r\u0000\u0000\u01f6\u01f8\u0005@\u0000\u0000\u01f7\u01f1"+
		"\u0001\u0000\u0000\u0000\u01f7\u01f2\u0001\u0000\u0000\u0000\u01f7\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f7\u01f4\u0001\u0000\u0000\u0000\u01f7\u01f5"+
		"\u0001\u0000\u0000\u0000\u01f7\u01f6\u0001\u0000\u0000\u0000\u01f8[\u0001"+
		"\u0000\u0000\u0000\u01f9\u0209\u0005C\u0000\u0000\u01fa\u0209\u0005D\u0000"+
		"\u0000\u01fb\u0209\u0005B\u0000\u0000\u01fc\u0209\u0005A\u0000\u0000\u01fd"+
		"\u0209\u0003^/\u0000\u01fe\u0209\u0003T*\u0000\u01ff\u0209\u0003L&\u0000"+
		"\u0200\u0209\u00038\u001c\u0000\u0201\u0202\u0005\u0011\u0000\u0000\u0202"+
		"\u0203\u0005@\u0000\u0000\u0203\u0205\u0005)\u0000\u0000\u0204\u0206\u0003"+
		"V+\u0000\u0205\u0204\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000\u0000"+
		"\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207\u0209\u0005*\u0000\u0000"+
		"\u0208\u01f9\u0001\u0000\u0000\u0000\u0208\u01fa\u0001\u0000\u0000\u0000"+
		"\u0208\u01fb\u0001\u0000\u0000\u0000\u0208\u01fc\u0001\u0000\u0000\u0000"+
		"\u0208\u01fd\u0001\u0000\u0000\u0000\u0208\u01fe\u0001\u0000\u0000\u0000"+
		"\u0208\u01ff\u0001\u0000\u0000\u0000\u0208\u0200\u0001\u0000\u0000\u0000"+
		"\u0208\u0201\u0001\u0000\u0000\u0000\u0209]\u0001\u0000\u0000\u0000\u020a"+
		"\u020d\u0005\u000e\u0000\u0000\u020b\u020d\u0005\u000f\u0000\u0000\u020c"+
		"\u020a\u0001\u0000\u0000\u0000\u020c\u020b\u0001\u0000\u0000\u0000\u020d"+
		"_\u0001\u0000\u0000\u0000\u020e\u020f\u0003R)\u0000\u020f\u0210\u0005"+
		"0\u0000\u0000\u0210\u0211\u0005\"\u0000\u0000\u0211\u021f\u0001\u0000"+
		"\u0000\u0000\u0212\u0213\u0003R)\u0000\u0213\u0214\u00051\u0000\u0000"+
		"\u0214\u0215\u0005\"\u0000\u0000\u0215\u021f\u0001\u0000\u0000\u0000\u0216"+
		"\u0217\u00050\u0000\u0000\u0217\u0218\u0003R)\u0000\u0218\u0219\u0005"+
		"\"\u0000\u0000\u0219\u021f\u0001\u0000\u0000\u0000\u021a\u021b\u00051"+
		"\u0000\u0000\u021b\u021c\u0003R)\u0000\u021c\u021d\u0005\"\u0000\u0000"+
		"\u021d\u021f\u0001\u0000\u0000\u0000\u021e\u020e\u0001\u0000\u0000\u0000"+
		"\u021e\u0212\u0001\u0000\u0000\u0000\u021e\u0216\u0001\u0000\u0000\u0000"+
		"\u021e\u021a\u0001\u0000\u0000\u0000\u021fa\u0001\u0000\u0000\u0000)e"+
		"mq\u007f\u0089\u0095\u009b\u00a5\u00ae\u00bd\u00e8\u00f1\u00f5\u00fd\u0107"+
		"\u0111\u011b\u0124\u012a\u014d\u0157\u0164\u0171\u0178\u017f\u0184\u01a0"+
		"\u01ad\u01b1\u01bb\u01c3\u01c5\u01cd\u01d8\u01ec\u01ee\u01f7\u0205\u0208"+
		"\u020c\u021e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}