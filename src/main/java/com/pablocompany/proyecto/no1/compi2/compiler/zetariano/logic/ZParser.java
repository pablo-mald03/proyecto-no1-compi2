// Generated from ZParser.g4 by ANTLR 4.13.2
package com.pablocompany.proyecto.no1.compi2.compiler.zetariano.logic;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ZParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, BLOCK_COMMENT=2, WS=3, NEW=4, NULL=5, PUBLIC=6, READ=7, PRINTLN=8, 
		PRINT=9, IF=10, ELSE=11, SWITCH=12, CASE=13, BREAK=14, DEFAULT=15, FOR=16, 
		WHILE=17, DO=18, RETURN=19, CONTINUE=20, CLASS=21, INTEGER=22, DOUBLE=23, 
		CHARACTER=24, BOOLEAN=25, VOID=26, TRUE=27, FALSE=28, EQUAL=29, COMMA=30, 
		DOT_COMMA=31, TWO_POINTS=32, QUESTION=33, DOT=34, INIT_BRACE=35, FINAL_BRACE=36, 
		INIT_BRACKET=37, FINAL_BRACKET=38, INIT_PARENT=39, FINAL_PARENT=40, BY_ONE_ADD=41, 
		BY_ONE_MINUS=42, BY_ONE_MULTIPLICATION=43, BY_ONE_DIVISION=44, BY_ONE_PERCENT=45, 
		ABREV_PLUS=46, ABREV_MINUS=47, PLUS=48, MINUS=49, MULTIPLICATION=50, DIVIDE=51, 
		PERCENT=52, EQUALS=53, GREATER_EQUALS=54, LESS_EQUALS=55, DIFERENCE=56, 
		LESS=57, GREATER=58, AND=59, OR=60, NOT=61, ID=62, INT=63, DECIMAL=64, 
		TEXT=65, CHAR=66, ERROR_TOKEN=67;
	public static final int
		RULE_program = 0, RULE_class_declaration = 1, RULE_class_member = 2, RULE_constructor_declaration = 3, 
		RULE_method_declaration = 4, RULE_parameter_list = 5, RULE_parameter = 6, 
		RULE_statement = 7, RULE_call_statement = 8, RULE_return_statement = 9, 
		RULE_loop_control = 10, RULE_console_actions = 11, RULE_read_call = 12, 
		RULE_block_statement = 13, RULE_statement_body = 14, RULE_if_statement = 15, 
		RULE_else_if_list = 16, RULE_else_if_clause = 17, RULE_else_block = 18, 
		RULE_switch_statement = 19, RULE_switch_case = 20, RULE_default_case = 21, 
		RULE_while_statement = 22, RULE_do_while_statement = 23, RULE_for_statement = 24, 
		RULE_for_init = 25, RULE_for_update = 26, RULE_variable_declaration = 27, 
		RULE_nested_variables_usage = 28, RULE_compound_assignment = 29, RULE_abbreviated_operation = 30, 
		RULE_nest_variable = 31, RULE_object_values = 32, RULE_arguments_list = 33, 
		RULE_instantiation = 34, RULE_array_literal = 35, RULE_array_values = 36, 
		RULE_expression = 37, RULE_type = 38, RULE_primitive_type = 39, RULE_normal_values = 40, 
		RULE_boolean_values = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "class_declaration", "class_member", "constructor_declaration", 
			"method_declaration", "parameter_list", "parameter", "statement", "call_statement", 
			"return_statement", "loop_control", "console_actions", "read_call", "block_statement", 
			"statement_body", "if_statement", "else_if_list", "else_if_clause", "else_block", 
			"switch_statement", "switch_case", "default_case", "while_statement", 
			"do_while_statement", "for_statement", "for_init", "for_update", "variable_declaration", 
			"nested_variables_usage", "compound_assignment", "abbreviated_operation", 
			"nest_variable", "object_values", "arguments_list", "instantiation", 
			"array_literal", "array_values", "expression", "type", "primitive_type", 
			"normal_values", "boolean_values"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'new'", "'null'", "'public'", "'readln'", "'println'", 
			"'print'", "'if'", "'else'", "'switch'", "'case'", "'break'", "'default'", 
			"'for'", "'while'", "'do'", "'return'", "'continue'", "'class'", "'int'", 
			"'double'", "'char'", "'boolean'", "'void'", "'true'", "'false'", "'='", 
			"','", "';'", "':'", "'?'", "'.'", "'{'", "'}'", "'['", "']'", "'('", 
			"')'", "'+='", "'-='", "'*='", "'/='", "'%='", "'++'", "'--'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'=='", "'>='", "'<='", "'!='", "'<'", "'>'", 
			"'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "BLOCK_COMMENT", "WS", "NEW", "NULL", "PUBLIC", "READ", 
			"PRINTLN", "PRINT", "IF", "ELSE", "SWITCH", "CASE", "BREAK", "DEFAULT", 
			"FOR", "WHILE", "DO", "RETURN", "CONTINUE", "CLASS", "INTEGER", "DOUBLE", 
			"CHARACTER", "BOOLEAN", "VOID", "TRUE", "FALSE", "EQUAL", "COMMA", "DOT_COMMA", 
			"TWO_POINTS", "QUESTION", "DOT", "INIT_BRACE", "FINAL_BRACE", "INIT_BRACKET", 
			"FINAL_BRACKET", "INIT_PARENT", "FINAL_PARENT", "BY_ONE_ADD", "BY_ONE_MINUS", 
			"BY_ONE_MULTIPLICATION", "BY_ONE_DIVISION", "BY_ONE_PERCENT", "ABREV_PLUS", 
			"ABREV_MINUS", "PLUS", "MINUS", "MULTIPLICATION", "DIVIDE", "PERCENT", 
			"EQUALS", "GREATER_EQUALS", "LESS_EQUALS", "DIFERENCE", "LESS", "GREATER", 
			"AND", "OR", "NOT", "ID", "INT", "DECIMAL", "TEXT", "CHAR", "ERROR_TOKEN"
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
	public String getGrammarFileName() { return "ZParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ZParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Class_declarationContext class_declaration() {
			return getRuleContext(Class_declarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ZParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			class_declaration();
			setState(85);
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
	public static class Class_declarationContext extends ParserRuleContext {
		public Class_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_declaration; }
	 
		public Class_declarationContext() { }
		public void copyFrom(Class_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends Class_declarationContext {
		public TerminalNode PUBLIC() { return getToken(ZParser.PUBLIC, 0); }
		public TerminalNode CLASS() { return getToken(ZParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode INIT_BRACE() { return getToken(ZParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(ZParser.FINAL_BRACE, 0); }
		public List<Class_memberContext> class_member() {
			return getRuleContexts(Class_memberContext.class);
		}
		public Class_memberContext class_member(int i) {
			return getRuleContext(Class_memberContext.class,i);
		}
		public ClassDeclarationContext(Class_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_declarationContext class_declaration() throws RecognitionException {
		Class_declarationContext _localctx = new Class_declarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_declaration);
		int _la;
		try {
			_localctx = new ClassDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(PUBLIC);
			setState(88);
			match(CLASS);
			setState(89);
			match(ID);
			setState(90);
			match(INIT_BRACE);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611686018557411392L) != 0)) {
				{
				{
				setState(91);
				class_member();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
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
	public static class Class_memberContext extends ParserRuleContext {
		public Class_memberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_member; }
	 
		public Class_memberContext() { }
		public void copyFrom(Class_memberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassFieldMemberContext extends Class_memberContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public ClassFieldMemberContext(Class_memberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterClassFieldMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitClassFieldMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitClassFieldMember(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassMethodMemberContext extends Class_memberContext {
		public Method_declarationContext method_declaration() {
			return getRuleContext(Method_declarationContext.class,0);
		}
		public ClassMethodMemberContext(Class_memberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterClassMethodMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitClassMethodMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitClassMethodMember(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassConstructorMemberContext extends Class_memberContext {
		public Constructor_declarationContext constructor_declaration() {
			return getRuleContext(Constructor_declarationContext.class,0);
		}
		public ClassConstructorMemberContext(Class_memberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterClassConstructorMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitClassConstructorMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitClassConstructorMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_memberContext class_member() throws RecognitionException {
		Class_memberContext _localctx = new Class_memberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_member);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new ClassFieldMemberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				variable_declaration();
				}
				break;
			case 2:
				_localctx = new ClassConstructorMemberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				constructor_declaration();
				}
				break;
			case 3:
				_localctx = new ClassMethodMemberContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				method_declaration();
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
	public static class Constructor_declarationContext extends ParserRuleContext {
		public Constructor_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor_declaration; }
	 
		public Constructor_declarationContext() { }
		public void copyFrom(Constructor_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclarationContext extends Constructor_declarationContext {
		public TerminalNode PUBLIC() { return getToken(ZParser.PUBLIC, 0); }
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(ZParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(ZParser.FINAL_BRACE, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ConstructorDeclarationContext(Constructor_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constructor_declarationContext constructor_declaration() throws RecognitionException {
		Constructor_declarationContext _localctx = new Constructor_declarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constructor_declaration);
		int _la;
		try {
			_localctx = new ConstructorDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(PUBLIC);
			setState(105);
			match(ID);
			setState(106);
			match(INIT_PARENT);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611686018557411328L) != 0)) {
				{
				setState(107);
				parameter_list();
				}
			}

			setState(110);
			match(FINAL_PARENT);
			setState(111);
			match(INIT_BRACE);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611897124791998336L) != 0)) {
				{
				{
				setState(112);
				statement();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
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
	public static class Method_declarationContext extends ParserRuleContext {
		public Method_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_declaration; }
	 
		public Method_declarationContext() { }
		public void copyFrom(Method_declarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationContext extends Method_declarationContext {
		public TerminalNode PUBLIC() { return getToken(ZParser.PUBLIC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(ZParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(ZParser.FINAL_BRACE, 0); }
		public List<TerminalNode> INIT_BRACKET() { return getTokens(ZParser.INIT_BRACKET); }
		public TerminalNode INIT_BRACKET(int i) {
			return getToken(ZParser.INIT_BRACKET, i);
		}
		public List<TerminalNode> FINAL_BRACKET() { return getTokens(ZParser.FINAL_BRACKET); }
		public TerminalNode FINAL_BRACKET(int i) {
			return getToken(ZParser.FINAL_BRACKET, i);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodDeclarationContext(Method_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Method_declarationContext method_declaration() throws RecognitionException {
		Method_declarationContext _localctx = new Method_declarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method_declaration);
		int _la;
		try {
			_localctx = new MethodDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(PUBLIC);
			setState(121);
			type();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INIT_BRACKET) {
				{
				{
				setState(122);
				match(INIT_BRACKET);
				setState(123);
				match(FINAL_BRACKET);
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			match(ID);
			setState(130);
			match(INIT_PARENT);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611686018557411328L) != 0)) {
				{
				setState(131);
				parameter_list();
				}
			}

			setState(134);
			match(FINAL_PARENT);
			setState(135);
			match(INIT_BRACE);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611897124791998336L) != 0)) {
				{
				{
				setState(136);
				statement();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
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
		public List<TerminalNode> COMMA() { return getTokens(ZParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZParser.COMMA, i);
		}
		public ParameterListContext(Parameter_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter_list);
		int _la;
		try {
			_localctx = new ParameterListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			parameter();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(145);
				match(COMMA);
				setState(146);
				parameter();
				}
				}
				setState(151);
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
	public static class ParameterStatementContext extends ParameterContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public List<TerminalNode> INIT_BRACKET() { return getTokens(ZParser.INIT_BRACKET); }
		public TerminalNode INIT_BRACKET(int i) {
			return getToken(ZParser.INIT_BRACKET, i);
		}
		public List<TerminalNode> FINAL_BRACKET() { return getTokens(ZParser.FINAL_BRACKET); }
		public TerminalNode FINAL_BRACKET(int i) {
			return getToken(ZParser.FINAL_BRACKET, i);
		}
		public ParameterStatementContext(ParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterParameterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitParameterStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitParameterStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter);
		int _la;
		try {
			_localctx = new ParameterStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			type();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INIT_BRACKET) {
				{
				{
				setState(153);
				match(INIT_BRACKET);
				setState(154);
				match(FINAL_BRACKET);
				}
				}
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(160);
			match(ID);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementConsoleAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementConsoleAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementConsoleAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementVariableDeclarationContext extends StatementContext {
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public StatementVariableDeclarationContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementReturnContext extends StatementContext {
		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class,0);
		}
		public StatementReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementCompoundAssignmentContext extends StatementContext {
		public Compound_assignmentContext compound_assignment() {
			return getRuleContext(Compound_assignmentContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public StatementCompoundAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementCompoundAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementCompoundAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementCompoundAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementObjectPropertyCallingContext extends StatementContext {
		public Call_statementContext call_statement() {
			return getRuleContext(Call_statementContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public StatementObjectPropertyCallingContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementObjectPropertyCalling(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementObjectPropertyCalling(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementObjectPropertyCalling(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementLoopControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementLoopControl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementLoopControl(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StatementNestedAssignmentContext extends StatementContext {
		public Nested_variables_usageContext nested_variables_usage() {
			return getRuleContext(Nested_variables_usageContext.class,0);
		}
		public StatementNestedAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementNestedAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementNestedAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementNestedAssignment(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementAbbreviatedOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementAbbreviatedOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementAbbreviatedOperation(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(175);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new StatementBlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				block_statement();
				}
				break;
			case 2:
				_localctx = new StatementConsoleActionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				console_actions();
				}
				break;
			case 3:
				_localctx = new StatementLoopControlContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				loop_control();
				}
				break;
			case 4:
				_localctx = new StatementReturnContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				return_statement();
				}
				break;
			case 5:
				_localctx = new StatementAbbreviatedOperationContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(166);
				abbreviated_operation();
				}
				break;
			case 6:
				_localctx = new StatementCompoundAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(167);
				compound_assignment();
				setState(168);
				match(DOT_COMMA);
				}
				break;
			case 7:
				_localctx = new StatementNestedAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(170);
				nested_variables_usage();
				}
				break;
			case 8:
				_localctx = new StatementVariableDeclarationContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(171);
				variable_declaration();
				}
				break;
			case 9:
				_localctx = new StatementObjectPropertyCallingContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(172);
				call_statement();
				setState(173);
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
	public static class Call_statementContext extends ParserRuleContext {
		public Call_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_statement; }
	 
		public Call_statementContext() { }
		public void copyFrom(Call_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChainedCallStatementContext extends Call_statementContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ZParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public ChainedCallStatementContext(Call_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterChainedCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitChainedCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitChainedCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DirectCallStatementContext extends Call_statementContext {
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public DirectCallStatementContext(Call_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterDirectCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitDirectCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitDirectCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_statementContext call_statement() throws RecognitionException {
		Call_statementContext _localctx = new Call_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_call_statement);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new ChainedCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				object_values(0);
				setState(178);
				match(DOT);
				setState(179);
				match(ID);
				setState(180);
				match(INIT_PARENT);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 9079292069683396619L) != 0)) {
					{
					setState(181);
					arguments_list();
					}
				}

				setState(184);
				match(FINAL_PARENT);
				}
				break;
			case 2:
				_localctx = new DirectCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(ID);
				setState(187);
				match(INIT_PARENT);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 9079292069683396619L) != 0)) {
					{
					setState(188);
					arguments_list();
					}
				}

				setState(191);
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
	public static class Return_statementContext extends ParserRuleContext {
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_statement; }
	 
		public Return_statementContext() { }
		public void copyFrom(Return_statementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends Return_statementContext {
		public TerminalNode RETURN() { return getToken(ZParser.RETURN, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(Return_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_return_statement);
		int _la;
		try {
			_localctx = new ReturnStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(RETURN);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 9079292069683396619L) != 0)) {
				{
				setState(195);
				expression(0);
				}
			}

			setState(198);
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
		public TerminalNode CONTINUE() { return getToken(ZParser.CONTINUE, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public LoopContinueContext(Loop_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterLoopContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitLoopContinue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitLoopContinue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopBreakContext extends Loop_controlContext {
		public TerminalNode BREAK() { return getToken(ZParser.BREAK, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public LoopBreakContext(Loop_controlContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterLoopBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitLoopBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitLoopBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Loop_controlContext loop_control() throws RecognitionException {
		Loop_controlContext _localctx = new Loop_controlContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_loop_control);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTINUE:
				_localctx = new LoopContinueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(CONTINUE);
				setState(201);
				match(DOT_COMMA);
				}
				break;
			case BREAK:
				_localctx = new LoopBreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(BREAK);
				setState(203);
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
	public static class PrintActionContext extends Console_actionsContext {
		public TerminalNode PRINT() { return getToken(ZParser.PRINT, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public PrintActionContext(Console_actionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterPrintAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitPrintAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitPrintAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReadActionContext extends Console_actionsContext {
		public Read_callContext read_call() {
			return getRuleContext(Read_callContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public ReadActionContext(Console_actionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterReadAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitReadAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitReadAction(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintlnActionContext extends Console_actionsContext {
		public TerminalNode PRINTLN() { return getToken(ZParser.PRINTLN, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public PrintlnActionContext(Console_actionsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterPrintlnAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitPrintlnAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitPrintlnAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Console_actionsContext console_actions() throws RecognitionException {
		Console_actionsContext _localctx = new Console_actionsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_console_actions);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINTLN:
				_localctx = new PrintlnActionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(PRINTLN);
				setState(207);
				match(INIT_PARENT);
				setState(208);
				expression(0);
				setState(209);
				match(FINAL_PARENT);
				setState(210);
				match(DOT_COMMA);
				}
				break;
			case PRINT:
				_localctx = new PrintActionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(PRINT);
				setState(213);
				match(INIT_PARENT);
				setState(214);
				expression(0);
				setState(215);
				match(FINAL_PARENT);
				setState(216);
				match(DOT_COMMA);
				}
				break;
			case READ:
				_localctx = new ReadActionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				read_call();
				setState(219);
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
		public TerminalNode READ() { return getToken(ZParser.READ, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public ReadCallContext(Read_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterReadCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitReadCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitReadCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_callContext read_call() throws RecognitionException {
		Read_callContext _localctx = new Read_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_read_call);
		try {
			_localctx = new ReadCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(READ);
			setState(224);
			match(INIT_PARENT);
			setState(225);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBlockFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBlockFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBlockFor(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBlockDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBlockDoWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBlockDoWhile(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBlockIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBlockIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBlockIf(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBlockSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBlockSwitch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBlockSwitch(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBlockWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBlockWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBlockWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_statementContext block_statement() throws RecognitionException {
		Block_statementContext _localctx = new Block_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block_statement);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new BlockIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				if_statement();
				}
				break;
			case SWITCH:
				_localctx = new BlockSwitchContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				switch_statement();
				}
				break;
			case WHILE:
				_localctx = new BlockWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(229);
				while_statement();
				}
				break;
			case DO:
				_localctx = new BlockDoWhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				do_while_statement();
				}
				break;
			case FOR:
				_localctx = new BlockForContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(231);
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
	public static class Statement_bodyContext extends ParserRuleContext {
		public Statement_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_body; }
	 
		public Statement_bodyContext() { }
		public void copyFrom(Statement_bodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleStatementBodyContext extends Statement_bodyContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SingleStatementBodyContext(Statement_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterSingleStatementBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitSingleStatementBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitSingleStatementBody(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracedStatementBodyContext extends Statement_bodyContext {
		public TerminalNode INIT_BRACE() { return getToken(ZParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(ZParser.FINAL_BRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BracedStatementBodyContext(Statement_bodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBracedStatementBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBracedStatementBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBracedStatementBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_bodyContext statement_body() throws RecognitionException {
		Statement_bodyContext _localctx = new Statement_bodyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement_body);
		int _la;
		try {
			setState(243);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INIT_BRACE:
				_localctx = new BracedStatementBodyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(INIT_BRACE);
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611897124791998336L) != 0)) {
					{
					{
					setState(235);
					statement();
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(241);
				match(FINAL_BRACE);
				}
				break;
			case READ:
			case PRINTLN:
			case PRINT:
			case IF:
			case SWITCH:
			case BREAK:
			case FOR:
			case WHILE:
			case DO:
			case RETURN:
			case CONTINUE:
			case INTEGER:
			case DOUBLE:
			case CHARACTER:
			case BOOLEAN:
			case VOID:
			case ABREV_PLUS:
			case ABREV_MINUS:
			case ID:
				_localctx = new SingleStatementBodyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				statement();
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
		public TerminalNode IF() { return getToken(ZParser.IF, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Statement_bodyContext statement_body() {
			return getRuleContext(Statement_bodyContext.class,0);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_if_statement);
		try {
			_localctx = new IfStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(IF);
			setState(246);
			match(INIT_PARENT);
			setState(247);
			expression(0);
			setState(248);
			match(FINAL_PARENT);
			setState(249);
			statement_body();
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(250);
				else_if_list();
				}
				break;
			}
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(253);
				else_block();
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterElseIfList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitElseIfList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitElseIfList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_listContext else_if_list() throws RecognitionException {
		Else_if_listContext _localctx = new Else_if_listContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_else_if_list);
		try {
			int _alt;
			_localctx = new ElseIfListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(257); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(256);
					else_if_clause();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(259); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		public TerminalNode ELSE() { return getToken(ZParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(ZParser.IF, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Statement_bodyContext statement_body() {
			return getRuleContext(Statement_bodyContext.class,0);
		}
		public ElseIfClauseContext(Else_if_clauseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterElseIfClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitElseIfClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitElseIfClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_clauseContext else_if_clause() throws RecognitionException {
		Else_if_clauseContext _localctx = new Else_if_clauseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_else_if_clause);
		try {
			_localctx = new ElseIfClauseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(ELSE);
			setState(262);
			match(IF);
			setState(263);
			match(INIT_PARENT);
			setState(264);
			expression(0);
			setState(265);
			match(FINAL_PARENT);
			setState(266);
			statement_body();
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
		public TerminalNode ELSE() { return getToken(ZParser.ELSE, 0); }
		public Statement_bodyContext statement_body() {
			return getRuleContext(Statement_bodyContext.class,0);
		}
		public ElseBlockContext(Else_blockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterElseBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitElseBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitElseBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_blockContext else_block() throws RecognitionException {
		Else_blockContext _localctx = new Else_blockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_else_block);
		try {
			_localctx = new ElseBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(ELSE);
			setState(269);
			statement_body();
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
		public TerminalNode SWITCH() { return getToken(ZParser.SWITCH, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public TerminalNode INIT_BRACE() { return getToken(ZParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(ZParser.FINAL_BRACE, 0); }
		public List<Switch_caseContext> switch_case() {
			return getRuleContexts(Switch_caseContext.class);
		}
		public Switch_caseContext switch_case(int i) {
			return getRuleContext(Switch_caseContext.class,i);
		}
		public Default_caseContext default_case() {
			return getRuleContext(Default_caseContext.class,0);
		}
		public SwitchStatementContext(Switch_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitSwitchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitSwitchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_statementContext switch_statement() throws RecognitionException {
		Switch_statementContext _localctx = new Switch_statementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_switch_statement);
		int _la;
		try {
			_localctx = new SwitchStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(SWITCH);
			setState(272);
			match(INIT_PARENT);
			setState(273);
			expression(0);
			setState(274);
			match(FINAL_PARENT);
			setState(275);
			match(INIT_BRACE);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(276);
				switch_case();
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(282);
				default_case();
				}
			}

			setState(285);
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
		public TerminalNode CASE() { return getToken(ZParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode TWO_POINTS() { return getToken(ZParser.TWO_POINTS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SwitchCaseContext(Switch_caseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitSwitchCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitSwitchCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Switch_caseContext switch_case() throws RecognitionException {
		Switch_caseContext _localctx = new Switch_caseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_switch_case);
		int _la;
		try {
			_localctx = new SwitchCaseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(CASE);
			setState(288);
			expression(0);
			setState(289);
			match(TWO_POINTS);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611897124791998336L) != 0)) {
				{
				{
				setState(290);
				statement();
				}
				}
				setState(295);
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
	public static class Default_caseContext extends ParserRuleContext {
		public Default_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_case; }
	 
		public Default_caseContext() { }
		public void copyFrom(Default_caseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DefaultCaseContext extends Default_caseContext {
		public TerminalNode DEFAULT() { return getToken(ZParser.DEFAULT, 0); }
		public TerminalNode TWO_POINTS() { return getToken(ZParser.TWO_POINTS, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefaultCaseContext(Default_caseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterDefaultCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitDefaultCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitDefaultCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Default_caseContext default_case() throws RecognitionException {
		Default_caseContext _localctx = new Default_caseContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_default_case);
		int _la;
		try {
			_localctx = new DefaultCaseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(DEFAULT);
			setState(297);
			match(TWO_POINTS);
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611897124791998336L) != 0)) {
				{
				{
				setState(298);
				statement();
				}
				}
				setState(303);
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
		public TerminalNode WHILE() { return getToken(ZParser.WHILE, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Statement_bodyContext statement_body() {
			return getRuleContext(Statement_bodyContext.class,0);
		}
		public WhileStatementContext(While_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_while_statement);
		try {
			_localctx = new WhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(WHILE);
			setState(305);
			match(INIT_PARENT);
			setState(306);
			expression(0);
			setState(307);
			match(FINAL_PARENT);
			setState(308);
			statement_body();
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
		public TerminalNode DO() { return getToken(ZParser.DO, 0); }
		public Statement_bodyContext statement_body() {
			return getRuleContext(Statement_bodyContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(ZParser.WHILE, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public DoWhileStatementContext(Do_while_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitDoWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitDoWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Do_while_statementContext do_while_statement() throws RecognitionException {
		Do_while_statementContext _localctx = new Do_while_statementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_do_while_statement);
		try {
			_localctx = new DoWhileStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(DO);
			setState(311);
			statement_body();
			setState(312);
			match(WHILE);
			setState(313);
			match(INIT_PARENT);
			setState(314);
			expression(0);
			setState(315);
			match(FINAL_PARENT);
			setState(316);
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
		public TerminalNode FOR() { return getToken(ZParser.FOR, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public List<TerminalNode> DOT_COMMA() { return getTokens(ZParser.DOT_COMMA); }
		public TerminalNode DOT_COMMA(int i) {
			return getToken(ZParser.DOT_COMMA, i);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Statement_bodyContext statement_body() {
			return getRuleContext(Statement_bodyContext.class,0);
		}
		public For_initContext for_init() {
			return getRuleContext(For_initContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public For_updateContext for_update() {
			return getRuleContext(For_updateContext.class,0);
		}
		public ForStatementContext(For_statementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_for_statement);
		int _la;
		try {
			_localctx = new ForStatementContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(FOR);
			setState(319);
			match(INIT_PARENT);
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611686018557411328L) != 0)) {
				{
				setState(320);
				for_init();
				}
			}

			setState(323);
			match(DOT_COMMA);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 9079292069683396619L) != 0)) {
				{
				setState(324);
				expression(0);
				}
			}

			setState(327);
			match(DOT_COMMA);
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4611897124659920896L) != 0)) {
				{
				setState(328);
				for_update();
				}
			}

			setState(331);
			match(FINAL_PARENT);
			setState(332);
			statement_body();
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
		public TerminalNode EQUAL() { return getToken(ZParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitAssignContext(For_initContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterForInitAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitForInitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitForInitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForInitVarDeclContext extends For_initContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(ZParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> INIT_BRACKET() { return getTokens(ZParser.INIT_BRACKET); }
		public TerminalNode INIT_BRACKET(int i) {
			return getToken(ZParser.INIT_BRACKET, i);
		}
		public List<TerminalNode> FINAL_BRACKET() { return getTokens(ZParser.FINAL_BRACKET); }
		public TerminalNode FINAL_BRACKET(int i) {
			return getToken(ZParser.FINAL_BRACKET, i);
		}
		public ForInitVarDeclContext(For_initContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterForInitVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitForInitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitForInitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_initContext for_init() throws RecognitionException {
		For_initContext _localctx = new For_initContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_for_init);
		int _la;
		try {
			setState(350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				_localctx = new ForInitVarDeclContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				type();
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==INIT_BRACKET) {
					{
					{
					setState(335);
					match(INIT_BRACKET);
					setState(336);
					match(FINAL_BRACKET);
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(342);
				match(ID);
				setState(343);
				match(EQUAL);
				setState(344);
				expression(0);
				}
				break;
			case 2:
				_localctx = new ForInitAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(346);
				nest_variable();
				setState(347);
				match(EQUAL);
				setState(348);
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
		public TerminalNode ABREV_MINUS() { return getToken(ZParser.ABREV_MINUS, 0); }
		public ForUpdateDecrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterForUpdateDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitForUpdateDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitForUpdateDecrement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdatePrefixDecrementContext extends For_updateContext {
		public TerminalNode ABREV_MINUS() { return getToken(ZParser.ABREV_MINUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public ForUpdatePrefixDecrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterForUpdatePrefixDecrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitForUpdatePrefixDecrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitForUpdatePrefixDecrement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdatePrefixIncrementContext extends For_updateContext {
		public TerminalNode ABREV_PLUS() { return getToken(ZParser.ABREV_PLUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public ForUpdatePrefixIncrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterForUpdatePrefixIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitForUpdatePrefixIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitForUpdatePrefixIncrement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateAssignContext extends For_updateContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(ZParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateAssignContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterForUpdateAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitForUpdateAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitForUpdateAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComPoundAssingmentContext extends For_updateContext {
		public Compound_assignmentContext compound_assignment() {
			return getRuleContext(Compound_assignmentContext.class,0);
		}
		public ComPoundAssingmentContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterComPoundAssingment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitComPoundAssingment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitComPoundAssingment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateIncrementContext extends For_updateContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_PLUS() { return getToken(ZParser.ABREV_PLUS, 0); }
		public ForUpdateIncrementContext(For_updateContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterForUpdateIncrement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitForUpdateIncrement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitForUpdateIncrement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_updateContext for_update() throws RecognitionException {
		For_updateContext _localctx = new For_updateContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_for_update);
		try {
			setState(367);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new ForUpdateIncrementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				nest_variable();
				setState(353);
				match(ABREV_PLUS);
				}
				break;
			case 2:
				_localctx = new ForUpdateDecrementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				nest_variable();
				setState(356);
				match(ABREV_MINUS);
				}
				break;
			case 3:
				_localctx = new ForUpdatePrefixIncrementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(358);
				match(ABREV_PLUS);
				setState(359);
				nest_variable();
				}
				break;
			case 4:
				_localctx = new ForUpdatePrefixDecrementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(360);
				match(ABREV_MINUS);
				setState(361);
				nest_variable();
				}
				break;
			case 5:
				_localctx = new ForUpdateAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(362);
				nest_variable();
				setState(363);
				match(EQUAL);
				setState(364);
				expression(0);
				}
				break;
			case 6:
				_localctx = new ComPoundAssingmentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(366);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public List<TerminalNode> INIT_BRACKET() { return getTokens(ZParser.INIT_BRACKET); }
		public TerminalNode INIT_BRACKET(int i) {
			return getToken(ZParser.INIT_BRACKET, i);
		}
		public List<TerminalNode> FINAL_BRACKET() { return getTokens(ZParser.FINAL_BRACKET); }
		public TerminalNode FINAL_BRACKET(int i) {
			return getToken(ZParser.FINAL_BRACKET, i);
		}
		public TerminalNode EQUAL() { return getToken(ZParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(Variable_declarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_variable_declaration);
		int _la;
		try {
			_localctx = new VariableDeclarationContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			type();
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INIT_BRACKET) {
				{
				{
				setState(370);
				match(INIT_BRACKET);
				setState(371);
				match(FINAL_BRACKET);
				}
				}
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(377);
			match(ID);
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(378);
				match(EQUAL);
				setState(379);
				expression(0);
				}
			}

			setState(382);
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
	public static class NestedObjectAssignmentContext extends Nested_variables_usageContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(ZParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public NestedObjectAssignmentContext(Nested_variables_usageContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterNestedObjectAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitNestedObjectAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitNestedObjectAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nested_variables_usageContext nested_variables_usage() throws RecognitionException {
		Nested_variables_usageContext _localctx = new Nested_variables_usageContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_nested_variables_usage);
		try {
			_localctx = new NestedObjectAssignmentContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			object_values(0);
			setState(385);
			match(EQUAL);
			setState(386);
			expression(0);
			setState(387);
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
		public TerminalNode BY_ONE_DIVISION() { return getToken(ZParser.BY_ONE_DIVISION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompoundDivAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterCompoundDivAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitCompoundDivAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitCompoundDivAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundModAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_PERCENT() { return getToken(ZParser.BY_ONE_PERCENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompoundModAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterCompoundModAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitCompoundModAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitCompoundModAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundSubAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_MINUS() { return getToken(ZParser.BY_ONE_MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompoundSubAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterCompoundSubAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitCompoundSubAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitCompoundSubAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundMulAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_MULTIPLICATION() { return getToken(ZParser.BY_ONE_MULTIPLICATION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompoundMulAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterCompoundMulAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitCompoundMulAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitCompoundMulAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompoundAddAssignmentContext extends Compound_assignmentContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode BY_ONE_ADD() { return getToken(ZParser.BY_ONE_ADD, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CompoundAddAssignmentContext(Compound_assignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterCompoundAddAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitCompoundAddAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitCompoundAddAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_assignmentContext compound_assignment() throws RecognitionException {
		Compound_assignmentContext _localctx = new Compound_assignmentContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_compound_assignment);
		try {
			setState(409);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				_localctx = new CompoundAddAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				nest_variable();
				setState(390);
				match(BY_ONE_ADD);
				setState(391);
				expression(0);
				}
				break;
			case 2:
				_localctx = new CompoundSubAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				nest_variable();
				setState(394);
				match(BY_ONE_MINUS);
				setState(395);
				expression(0);
				}
				break;
			case 3:
				_localctx = new CompoundMulAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(397);
				nest_variable();
				setState(398);
				match(BY_ONE_MULTIPLICATION);
				setState(399);
				expression(0);
				}
				break;
			case 4:
				_localctx = new CompoundDivAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(401);
				nest_variable();
				setState(402);
				match(BY_ONE_DIVISION);
				setState(403);
				expression(0);
				}
				break;
			case 5:
				_localctx = new CompoundModAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(405);
				nest_variable();
				setState(406);
				match(BY_ONE_PERCENT);
				setState(407);
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
		public TerminalNode ABREV_MINUS() { return getToken(ZParser.ABREV_MINUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public DecPrefixOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterDecPrefixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitDecPrefixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitDecPrefixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncPrefixOperationContext extends Abbreviated_operationContext {
		public TerminalNode ABREV_PLUS() { return getToken(ZParser.ABREV_PLUS, 0); }
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public IncPrefixOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterIncPrefixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitIncPrefixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitIncPrefixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncSufixOperationContext extends Abbreviated_operationContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_PLUS() { return getToken(ZParser.ABREV_PLUS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public IncSufixOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterIncSufixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitIncSufixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitIncSufixOperation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecSufixOperationContext extends Abbreviated_operationContext {
		public Nest_variableContext nest_variable() {
			return getRuleContext(Nest_variableContext.class,0);
		}
		public TerminalNode ABREV_MINUS() { return getToken(ZParser.ABREV_MINUS, 0); }
		public TerminalNode DOT_COMMA() { return getToken(ZParser.DOT_COMMA, 0); }
		public DecSufixOperationContext(Abbreviated_operationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterDecSufixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitDecSufixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitDecSufixOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Abbreviated_operationContext abbreviated_operation() throws RecognitionException {
		Abbreviated_operationContext _localctx = new Abbreviated_operationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_abbreviated_operation);
		try {
			setState(427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				_localctx = new IncSufixOperationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				nest_variable();
				setState(412);
				match(ABREV_PLUS);
				setState(413);
				match(DOT_COMMA);
				}
				break;
			case 2:
				_localctx = new DecSufixOperationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(415);
				nest_variable();
				setState(416);
				match(ABREV_MINUS);
				setState(417);
				match(DOT_COMMA);
				}
				break;
			case 3:
				_localctx = new IncPrefixOperationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(419);
				match(ABREV_PLUS);
				setState(420);
				nest_variable();
				setState(421);
				match(DOT_COMMA);
				}
				break;
			case 4:
				_localctx = new DecPrefixOperationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(423);
				match(ABREV_MINUS);
				setState(424);
				nest_variable();
				setState(425);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterNestedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitNestedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitNestedVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nest_variableContext nest_variable() throws RecognitionException {
		Nest_variableContext _localctx = new Nest_variableContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_nest_variable);
		try {
			_localctx = new NestedVariableContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
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
		public TerminalNode DOT() { return getToken(ZParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public ObjectMethodChainContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterObjectMethodChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitObjectMethodChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitObjectMethodChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectArrayAccessChainContext extends Object_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode INIT_BRACKET() { return getToken(ZParser.INIT_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_BRACKET() { return getToken(ZParser.FINAL_BRACKET, 0); }
		public ObjectArrayAccessChainContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterObjectArrayAccessChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitObjectArrayAccessChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitObjectArrayAccessChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectPropertyChainContext extends Object_valuesContext {
		public Object_valuesContext object_values() {
			return getRuleContext(Object_valuesContext.class,0);
		}
		public TerminalNode DOT() { return getToken(ZParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public ObjectPropertyChainContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterObjectPropertyChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitObjectPropertyChain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitObjectPropertyChain(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseFunctionCallContext extends Object_valuesContext {
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public BaseFunctionCallContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBaseFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBaseFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBaseFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BaseIdentifierContext extends Object_valuesContext {
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public BaseIdentifierContext(Object_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBaseIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBaseIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBaseIdentifier(this);
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
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_object_values, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				_localctx = new BaseFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(432);
				match(ID);
				setState(433);
				match(INIT_PARENT);
				setState(435);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 9079292069683396619L) != 0)) {
					{
					setState(434);
					arguments_list();
					}
				}

				setState(437);
				match(FINAL_PARENT);
				}
				break;
			case 2:
				{
				_localctx = new BaseIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(438);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(459);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(457);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new ObjectPropertyChainContext(new Object_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_object_values);
						setState(441);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(442);
						match(DOT);
						setState(443);
						match(ID);
						}
						break;
					case 2:
						{
						_localctx = new ObjectMethodChainContext(new Object_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_object_values);
						setState(444);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(445);
						match(DOT);
						setState(446);
						match(ID);
						setState(447);
						match(INIT_PARENT);
						setState(449);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 9079292069683396619L) != 0)) {
							{
							setState(448);
							arguments_list();
							}
						}

						setState(451);
						match(FINAL_PARENT);
						}
						break;
					case 3:
						{
						_localctx = new ObjectArrayAccessChainContext(new Object_valuesContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_object_values);
						setState(452);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(453);
						match(INIT_BRACKET);
						setState(454);
						expression(0);
						setState(455);
						match(FINAL_BRACKET);
						}
						break;
					}
					} 
				}
				setState(461);
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
		public List<TerminalNode> COMMA() { return getTokens(ZParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZParser.COMMA, i);
		}
		public ArgumentsListContext(Arguments_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterArgumentsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitArgumentsList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitArgumentsList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arguments_listContext arguments_list() throws RecognitionException {
		Arguments_listContext _localctx = new Arguments_listContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arguments_list);
		int _la;
		try {
			_localctx = new ArgumentsListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			expression(0);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(463);
				match(COMMA);
				setState(464);
				expression(0);
				}
				}
				setState(469);
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
	public static class InstantiationContext extends ParserRuleContext {
		public InstantiationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instantiation; }
	 
		public InstantiationContext() { }
		public void copyFrom(InstantiationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ObjectInstantiationContext extends InstantiationContext {
		public TerminalNode NEW() { return getToken(ZParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public Arguments_listContext arguments_list() {
			return getRuleContext(Arguments_listContext.class,0);
		}
		public ObjectInstantiationContext(InstantiationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterObjectInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitObjectInstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitObjectInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInstantiationContext extends InstantiationContext {
		public TerminalNode NEW() { return getToken(ZParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> INIT_BRACKET() { return getTokens(ZParser.INIT_BRACKET); }
		public TerminalNode INIT_BRACKET(int i) {
			return getToken(ZParser.INIT_BRACKET, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> FINAL_BRACKET() { return getTokens(ZParser.FINAL_BRACKET); }
		public TerminalNode FINAL_BRACKET(int i) {
			return getToken(ZParser.FINAL_BRACKET, i);
		}
		public ArrayInstantiationContext(InstantiationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterArrayInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitArrayInstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitArrayInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstantiationContext instantiation() throws RecognitionException {
		InstantiationContext _localctx = new InstantiationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_instantiation);
		int _la;
		try {
			int _alt;
			setState(488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				_localctx = new ObjectInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(470);
				match(NEW);
				setState(471);
				type();
				setState(472);
				match(INIT_PARENT);
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 9079292069683396619L) != 0)) {
					{
					setState(473);
					arguments_list();
					}
				}

				setState(476);
				match(FINAL_PARENT);
				}
				break;
			case 2:
				_localctx = new ArrayInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(478);
				match(NEW);
				setState(479);
				type();
				setState(484); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(480);
						match(INIT_BRACKET);
						setState(481);
						expression(0);
						setState(482);
						match(FINAL_BRACKET);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(486); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode INIT_BRACE() { return getToken(ZParser.INIT_BRACE, 0); }
		public TerminalNode FINAL_BRACE() { return getToken(ZParser.FINAL_BRACE, 0); }
		public Array_valuesContext array_values() {
			return getRuleContext(Array_valuesContext.class,0);
		}
		public ArrayLiteralValueContext(Array_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterArrayLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitArrayLiteralValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitArrayLiteralValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_literalContext array_literal() throws RecognitionException {
		Array_literalContext _localctx = new Array_literalContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_array_literal);
		int _la;
		try {
			_localctx = new ArrayLiteralValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			match(INIT_BRACE);
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & 9079292069683396619L) != 0)) {
				{
				setState(491);
				array_values();
				}
			}

			setState(494);
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
		public List<TerminalNode> COMMA() { return getTokens(ZParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ZParser.COMMA, i);
		}
		public ArrayValuesListContext(Array_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterArrayValuesList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitArrayValuesList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitArrayValuesList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Array_valuesContext array_values() throws RecognitionException {
		Array_valuesContext _localctx = new Array_valuesContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_array_values);
		int _la;
		try {
			_localctx = new ArrayValuesListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			expression(0);
			setState(501);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(497);
				match(COMMA);
				setState(498);
				expression(0);
				}
				}
				setState(503);
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
		public TerminalNode INIT_PARENT() { return getToken(ZParser.INIT_PARENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode FINAL_PARENT() { return getToken(ZParser.FINAL_PARENT, 0); }
		public ExpressionParentsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionParents(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionParents(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionParents(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionTernaryContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode QUESTION() { return getToken(ZParser.QUESTION, 0); }
		public TerminalNode TWO_POINTS() { return getToken(ZParser.TWO_POINTS, 0); }
		public ExpressionTernaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionTernary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionTernary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionTernary(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionUnaryContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ZParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(ZParser.MINUS, 0); }
		public ExpressionUnaryContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionUnary(this);
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
		public TerminalNode EQUALS() { return getToken(ZParser.EQUALS, 0); }
		public TerminalNode DIFERENCE() { return getToken(ZParser.DIFERENCE, 0); }
		public ExpressionEqualityContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionEquality(this);
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
		public TerminalNode LESS() { return getToken(ZParser.LESS, 0); }
		public TerminalNode GREATER() { return getToken(ZParser.GREATER, 0); }
		public TerminalNode LESS_EQUALS() { return getToken(ZParser.LESS_EQUALS, 0); }
		public TerminalNode GREATER_EQUALS() { return getToken(ZParser.GREATER_EQUALS, 0); }
		public ExpressionRelationalContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionRelational(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionValue(this);
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
		public TerminalNode AND() { return getToken(ZParser.AND, 0); }
		public ExpressionAndContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionAnd(this);
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
		public TerminalNode OR() { return getToken(ZParser.OR, 0); }
		public ExpressionOrContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionOr(this);
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
		public TerminalNode MULTIPLICATION() { return getToken(ZParser.MULTIPLICATION, 0); }
		public TerminalNode DIVIDE() { return getToken(ZParser.DIVIDE, 0); }
		public TerminalNode PERCENT() { return getToken(ZParser.PERCENT, 0); }
		public ExpressionMultDivContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionMultDiv(this);
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
		public TerminalNode PLUS() { return getToken(ZParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ZParser.MINUS, 0); }
		public ExpressionAddSubContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterExpressionAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitExpressionAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitExpressionAddSub(this);
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
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INIT_PARENT:
				{
				_localctx = new ExpressionParentsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(505);
				match(INIT_PARENT);
				setState(506);
				expression(0);
				setState(507);
				match(FINAL_PARENT);
				}
				break;
			case MINUS:
			case NOT:
				{
				_localctx = new ExpressionUnaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(509);
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
				setState(510);
				expression(9);
				}
				break;
			case NEW:
			case NULL:
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
				setState(511);
				normal_values();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(540);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(538);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionMultDivContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(514);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(515);
						((ExpressionMultDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7881299347898368L) != 0)) ) {
							((ExpressionMultDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(516);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionAddSubContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(517);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(518);
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
						setState(519);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionRelationalContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(520);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(521);
						((ExpressionRelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 486388759756013568L) != 0)) ) {
							((ExpressionRelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(522);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionEqualityContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(523);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(524);
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
						setState(525);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionAndContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(526);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(527);
						match(AND);
						setState(528);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionOrContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(529);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(530);
						match(OR);
						setState(531);
						expression(4);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionTernaryContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(532);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(533);
						match(QUESTION);
						setState(534);
						expression(0);
						setState(535);
						match(TWO_POINTS);
						setState(536);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(542);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
	public static class TypeClassNameContext extends TypeContext {
		public TerminalNode ID() { return getToken(ZParser.ID, 0); }
		public TypeClassNameContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterTypeClassName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitTypeClassName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitTypeClassName(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypePrimitiveContext extends TypeContext {
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public TypePrimitiveContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterTypePrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitTypePrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitTypePrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_type);
		try {
			setState(545);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
			case DOUBLE:
			case CHARACTER:
			case BOOLEAN:
			case VOID:
				_localctx = new TypePrimitiveContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(543);
				primitive_type();
				}
				break;
			case ID:
				_localctx = new TypeClassNameContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(544);
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
	public static class Primitive_typeContext extends ParserRuleContext {
		public Primitive_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_type; }
	 
		public Primitive_typeContext() { }
		public void copyFrom(Primitive_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeCharContext extends Primitive_typeContext {
		public TerminalNode CHARACTER() { return getToken(ZParser.CHARACTER, 0); }
		public TypeCharContext(Primitive_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterTypeChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitTypeChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitTypeChar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeBooleanContext extends Primitive_typeContext {
		public TerminalNode BOOLEAN() { return getToken(ZParser.BOOLEAN, 0); }
		public TypeBooleanContext(Primitive_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterTypeBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitTypeBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitTypeBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeVoidContext extends Primitive_typeContext {
		public TerminalNode VOID() { return getToken(ZParser.VOID, 0); }
		public TypeVoidContext(Primitive_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterTypeVoid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitTypeVoid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitTypeVoid(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeIntContext extends Primitive_typeContext {
		public TerminalNode INTEGER() { return getToken(ZParser.INTEGER, 0); }
		public TypeIntContext(Primitive_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitTypeInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TypeDoubleContext extends Primitive_typeContext {
		public TerminalNode DOUBLE() { return getToken(ZParser.DOUBLE, 0); }
		public TypeDoubleContext(Primitive_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterTypeDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitTypeDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitTypeDouble(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_typeContext primitive_type() throws RecognitionException {
		Primitive_typeContext _localctx = new Primitive_typeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_primitive_type);
		try {
			setState(552);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(547);
				match(INTEGER);
				}
				break;
			case DOUBLE:
				_localctx = new TypeDoubleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(548);
				match(DOUBLE);
				}
				break;
			case CHARACTER:
				_localctx = new TypeCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(549);
				match(CHARACTER);
				}
				break;
			case BOOLEAN:
				_localctx = new TypeBooleanContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(550);
				match(BOOLEAN);
				}
				break;
			case VOID:
				_localctx = new TypeVoidContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(551);
				match(VOID);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValBool(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValObjectAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValObjectAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValObjectAccess(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValArrayLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValArrayLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValArrayLiteral(this);
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
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValReadCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValReadCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValReadCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValIntContext extends Normal_valuesContext {
		public TerminalNode INT() { return getToken(ZParser.INT, 0); }
		public ValIntContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValInt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValCharContext extends Normal_valuesContext {
		public TerminalNode CHAR() { return getToken(ZParser.CHAR, 0); }
		public ValCharContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValChar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValTextContext extends Normal_valuesContext {
		public TerminalNode TEXT() { return getToken(ZParser.TEXT, 0); }
		public ValTextContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValText(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValText(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValInstantiationContext extends Normal_valuesContext {
		public InstantiationContext instantiation() {
			return getRuleContext(InstantiationContext.class,0);
		}
		public ValInstantiationContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValInstantiation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValInstantiation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValInstantiation(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValNullContext extends Normal_valuesContext {
		public TerminalNode NULL() { return getToken(ZParser.NULL, 0); }
		public ValNullContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValNull(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ValDecimalContext extends Normal_valuesContext {
		public TerminalNode DECIMAL() { return getToken(ZParser.DECIMAL, 0); }
		public ValDecimalContext(Normal_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterValDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitValDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitValDecimal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_valuesContext normal_values() throws RecognitionException {
		Normal_valuesContext _localctx = new Normal_valuesContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_normal_values);
		try {
			setState(564);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				_localctx = new ValTextContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(554);
				match(TEXT);
				}
				break;
			case CHAR:
				_localctx = new ValCharContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(555);
				match(CHAR);
				}
				break;
			case DECIMAL:
				_localctx = new ValDecimalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(556);
				match(DECIMAL);
				}
				break;
			case INT:
				_localctx = new ValIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(557);
				match(INT);
				}
				break;
			case TRUE:
			case FALSE:
				_localctx = new ValBoolContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(558);
				boolean_values();
				}
				break;
			case NULL:
				_localctx = new ValNullContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(559);
				match(NULL);
				}
				break;
			case NEW:
				_localctx = new ValInstantiationContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(560);
				instantiation();
				}
				break;
			case ID:
				_localctx = new ValObjectAccessContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(561);
				object_values(0);
				}
				break;
			case INIT_BRACE:
				_localctx = new ValArrayLiteralContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(562);
				array_literal();
				}
				break;
			case READ:
				_localctx = new ValReadCallContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(563);
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
		public TerminalNode FALSE() { return getToken(ZParser.FALSE, 0); }
		public BoolFalseContext(Boolean_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBoolFalse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBoolFalse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBoolFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolTrueContext extends Boolean_valuesContext {
		public TerminalNode TRUE() { return getToken(ZParser.TRUE, 0); }
		public BoolTrueContext(Boolean_valuesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).enterBoolTrue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ZParserListener ) ((ZParserListener)listener).exitBoolTrue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ZParserVisitor ) return ((ZParserVisitor<? extends T>)visitor).visitBoolTrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_valuesContext boolean_values() throws RecognitionException {
		Boolean_valuesContext _localctx = new Boolean_valuesContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_boolean_values);
		try {
			setState(568);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new BoolTrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(566);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new BoolFalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(567);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 32:
			return object_values_sempred((Object_valuesContext)_localctx, predIndex);
		case 37:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean object_values_sempred(Object_valuesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 8);
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
		"\u0004\u0001C\u023b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001]\b\u0001"+
		"\n\u0001\f\u0001`\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002g\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003m\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003r\b\u0003\n\u0003\f\u0003u\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004}\b\u0004"+
		"\n\u0004\f\u0004\u0080\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u0085\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004\u008a"+
		"\b\u0004\n\u0004\f\u0004\u008d\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u0094\b\u0005\n\u0005\f\u0005\u0097"+
		"\t\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u009c\b\u0006"+
		"\n\u0006\f\u0006\u009f\t\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00b0\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b7"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00be\b\b\u0001\b"+
		"\u0003\b\u00c1\b\b\u0001\t\u0001\t\u0003\t\u00c5\b\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u00cd\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00de\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00e9\b\r\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00ed\b\u000e\n\u000e\f\u000e\u00f0\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00f4\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00fc\b\u000f\u0001\u000f"+
		"\u0003\u000f\u00ff\b\u000f\u0001\u0010\u0004\u0010\u0102\b\u0010\u000b"+
		"\u0010\f\u0010\u0103\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005"+
		"\u0013\u0116\b\u0013\n\u0013\f\u0013\u0119\t\u0013\u0001\u0013\u0003\u0013"+
		"\u011c\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u0124\b\u0014\n\u0014\f\u0014\u0127\t\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u012c\b\u0015\n\u0015\f\u0015"+
		"\u012f\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0142\b\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u0146\b"+
		"\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u014a\b\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0152"+
		"\b\u0019\n\u0019\f\u0019\u0155\t\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u015f\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0170\b\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0175\b\u001b\n\u001b"+
		"\f\u001b\u0178\t\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u017d\b\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u019a\b\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01ac\b\u001e"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0003 \u01b4\b \u0001"+
		" \u0001 \u0003 \u01b8\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0003 \u01c2\b \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0005"+
		" \u01ca\b \n \f \u01cd\t \u0001!\u0001!\u0001!\u0005!\u01d2\b!\n!\f!\u01d5"+
		"\t!\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01db\b\"\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0004\"\u01e5\b\"\u000b"+
		"\"\f\"\u01e6\u0003\"\u01e9\b\"\u0001#\u0001#\u0003#\u01ed\b#\u0001#\u0001"+
		"#\u0001$\u0001$\u0001$\u0005$\u01f4\b$\n$\f$\u01f7\t$\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u0201\b%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0005%\u021b\b%\n%\f%\u021e\t%\u0001&\u0001&\u0003&\u0222\b&"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0229\b\'\u0001(\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u0235"+
		"\b(\u0001)\u0001)\u0003)\u0239\b)\u0001)\u0000\u0002@J*\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@BDFHJLNPR\u0000\u0005\u0002\u000011==\u0001\u000024\u0001"+
		"\u000001\u0002\u0000679:\u0002\u00005588\u026d\u0000T\u0001\u0000\u0000"+
		"\u0000\u0002W\u0001\u0000\u0000\u0000\u0004f\u0001\u0000\u0000\u0000\u0006"+
		"h\u0001\u0000\u0000\u0000\bx\u0001\u0000\u0000\u0000\n\u0090\u0001\u0000"+
		"\u0000\u0000\f\u0098\u0001\u0000\u0000\u0000\u000e\u00af\u0001\u0000\u0000"+
		"\u0000\u0010\u00c0\u0001\u0000\u0000\u0000\u0012\u00c2\u0001\u0000\u0000"+
		"\u0000\u0014\u00cc\u0001\u0000\u0000\u0000\u0016\u00dd\u0001\u0000\u0000"+
		"\u0000\u0018\u00df\u0001\u0000\u0000\u0000\u001a\u00e8\u0001\u0000\u0000"+
		"\u0000\u001c\u00f3\u0001\u0000\u0000\u0000\u001e\u00f5\u0001\u0000\u0000"+
		"\u0000 \u0101\u0001\u0000\u0000\u0000\"\u0105\u0001\u0000\u0000\u0000"+
		"$\u010c\u0001\u0000\u0000\u0000&\u010f\u0001\u0000\u0000\u0000(\u011f"+
		"\u0001\u0000\u0000\u0000*\u0128\u0001\u0000\u0000\u0000,\u0130\u0001\u0000"+
		"\u0000\u0000.\u0136\u0001\u0000\u0000\u00000\u013e\u0001\u0000\u0000\u0000"+
		"2\u015e\u0001\u0000\u0000\u00004\u016f\u0001\u0000\u0000\u00006\u0171"+
		"\u0001\u0000\u0000\u00008\u0180\u0001\u0000\u0000\u0000:\u0199\u0001\u0000"+
		"\u0000\u0000<\u01ab\u0001\u0000\u0000\u0000>\u01ad\u0001\u0000\u0000\u0000"+
		"@\u01b7\u0001\u0000\u0000\u0000B\u01ce\u0001\u0000\u0000\u0000D\u01e8"+
		"\u0001\u0000\u0000\u0000F\u01ea\u0001\u0000\u0000\u0000H\u01f0\u0001\u0000"+
		"\u0000\u0000J\u0200\u0001\u0000\u0000\u0000L\u0221\u0001\u0000\u0000\u0000"+
		"N\u0228\u0001\u0000\u0000\u0000P\u0234\u0001\u0000\u0000\u0000R\u0238"+
		"\u0001\u0000\u0000\u0000TU\u0003\u0002\u0001\u0000UV\u0005\u0000\u0000"+
		"\u0001V\u0001\u0001\u0000\u0000\u0000WX\u0005\u0006\u0000\u0000XY\u0005"+
		"\u0015\u0000\u0000YZ\u0005>\u0000\u0000Z^\u0005#\u0000\u0000[]\u0003\u0004"+
		"\u0002\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000ab\u0005$\u0000\u0000b\u0003\u0001\u0000\u0000"+
		"\u0000cg\u00036\u001b\u0000dg\u0003\u0006\u0003\u0000eg\u0003\b\u0004"+
		"\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000"+
		"\u0000\u0000g\u0005\u0001\u0000\u0000\u0000hi\u0005\u0006\u0000\u0000"+
		"ij\u0005>\u0000\u0000jl\u0005\'\u0000\u0000km\u0003\n\u0005\u0000lk\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"no\u0005(\u0000\u0000os\u0005#\u0000\u0000pr\u0003\u000e\u0007\u0000q"+
		"p\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000\u0000\u0000us\u0001\u0000"+
		"\u0000\u0000vw\u0005$\u0000\u0000w\u0007\u0001\u0000\u0000\u0000xy\u0005"+
		"\u0006\u0000\u0000y~\u0003L&\u0000z{\u0005%\u0000\u0000{}\u0005&\u0000"+
		"\u0000|z\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000"+
		"\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0082\u0005>\u0000\u0000"+
		"\u0082\u0084\u0005\'\u0000\u0000\u0083\u0085\u0003\n\u0005\u0000\u0084"+
		"\u0083\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0001\u0000\u0000\u0000\u0086\u0087\u0005(\u0000\u0000\u0087\u008b"+
		"\u0005#\u0000\u0000\u0088\u008a\u0003\u000e\u0007\u0000\u0089\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001"+
		"\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005"+
		"$\u0000\u0000\u008f\t\u0001\u0000\u0000\u0000\u0090\u0095\u0003\f\u0006"+
		"\u0000\u0091\u0092\u0005\u001e\u0000\u0000\u0092\u0094\u0003\f\u0006\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u000b\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0098\u009d\u0003L&\u0000\u0099\u009a\u0005%\u0000\u0000\u009a\u009c"+
		"\u0005&\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009f\u0001"+
		"\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001"+
		"\u0000\u0000\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u009d\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0005>\u0000\u0000\u00a1\r\u0001\u0000"+
		"\u0000\u0000\u00a2\u00b0\u0003\u001a\r\u0000\u00a3\u00b0\u0003\u0016\u000b"+
		"\u0000\u00a4\u00b0\u0003\u0014\n\u0000\u00a5\u00b0\u0003\u0012\t\u0000"+
		"\u00a6\u00b0\u0003<\u001e\u0000\u00a7\u00a8\u0003:\u001d\u0000\u00a8\u00a9"+
		"\u0005\u001f\u0000\u0000\u00a9\u00b0\u0001\u0000\u0000\u0000\u00aa\u00b0"+
		"\u00038\u001c\u0000\u00ab\u00b0\u00036\u001b\u0000\u00ac\u00ad\u0003\u0010"+
		"\b\u0000\u00ad\u00ae\u0005\u001f\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000"+
		"\u0000\u00af\u00a2\u0001\u0000\u0000\u0000\u00af\u00a3\u0001\u0000\u0000"+
		"\u0000\u00af\u00a4\u0001\u0000\u0000\u0000\u00af\u00a5\u0001\u0000\u0000"+
		"\u0000\u00af\u00a6\u0001\u0000\u0000\u0000\u00af\u00a7\u0001\u0000\u0000"+
		"\u0000\u00af\u00aa\u0001\u0000\u0000\u0000\u00af\u00ab\u0001\u0000\u0000"+
		"\u0000\u00af\u00ac\u0001\u0000\u0000\u0000\u00b0\u000f\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0003@ \u0000\u00b2\u00b3\u0005\"\u0000\u0000\u00b3"+
		"\u00b4\u0005>\u0000\u0000\u00b4\u00b6\u0005\'\u0000\u0000\u00b5\u00b7"+
		"\u0003B!\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005(\u0000"+
		"\u0000\u00b9\u00c1\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005>\u0000\u0000"+
		"\u00bb\u00bd\u0005\'\u0000\u0000\u00bc\u00be\u0003B!\u0000\u00bd\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c1\u0005(\u0000\u0000\u00c0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00c0\u00ba\u0001\u0000\u0000\u0000\u00c1\u0011\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c4\u0005\u0013\u0000\u0000\u00c3\u00c5\u0003"+
		"J%\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u001f\u0000"+
		"\u0000\u00c7\u0013\u0001\u0000\u0000\u0000\u00c8\u00c9\u0005\u0014\u0000"+
		"\u0000\u00c9\u00cd\u0005\u001f\u0000\u0000\u00ca\u00cb\u0005\u000e\u0000"+
		"\u0000\u00cb\u00cd\u0005\u001f\u0000\u0000\u00cc\u00c8\u0001\u0000\u0000"+
		"\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u0015\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005\b\u0000\u0000\u00cf\u00d0\u0005\'\u0000\u0000"+
		"\u00d0\u00d1\u0003J%\u0000\u00d1\u00d2\u0005(\u0000\u0000\u00d2\u00d3"+
		"\u0005\u001f\u0000\u0000\u00d3\u00de\u0001\u0000\u0000\u0000\u00d4\u00d5"+
		"\u0005\t\u0000\u0000\u00d5\u00d6\u0005\'\u0000\u0000\u00d6\u00d7\u0003"+
		"J%\u0000\u00d7\u00d8\u0005(\u0000\u0000\u00d8\u00d9\u0005\u001f\u0000"+
		"\u0000\u00d9\u00de\u0001\u0000\u0000\u0000\u00da\u00db\u0003\u0018\f\u0000"+
		"\u00db\u00dc\u0005\u001f\u0000\u0000\u00dc\u00de\u0001\u0000\u0000\u0000"+
		"\u00dd\u00ce\u0001\u0000\u0000\u0000\u00dd\u00d4\u0001\u0000\u0000\u0000"+
		"\u00dd\u00da\u0001\u0000\u0000\u0000\u00de\u0017\u0001\u0000\u0000\u0000"+
		"\u00df\u00e0\u0005\u0007\u0000\u0000\u00e0\u00e1\u0005\'\u0000\u0000\u00e1"+
		"\u00e2\u0005(\u0000\u0000\u00e2\u0019\u0001\u0000\u0000\u0000\u00e3\u00e9"+
		"\u0003\u001e\u000f\u0000\u00e4\u00e9\u0003&\u0013\u0000\u00e5\u00e9\u0003"+
		",\u0016\u0000\u00e6\u00e9\u0003.\u0017\u0000\u00e7\u00e9\u00030\u0018"+
		"\u0000\u00e8\u00e3\u0001\u0000\u0000\u0000\u00e8\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e5\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u001b\u0001\u0000\u0000"+
		"\u0000\u00ea\u00ee\u0005#\u0000\u0000\u00eb\u00ed\u0003\u000e\u0007\u0000"+
		"\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f4\u0005$\u0000\u0000\u00f2\u00f4\u0003\u000e\u0007\u0000\u00f3"+
		"\u00ea\u0001\u0000\u0000\u0000\u00f3\u00f2\u0001\u0000\u0000\u0000\u00f4"+
		"\u001d\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005\n\u0000\u0000\u00f6\u00f7"+
		"\u0005\'\u0000\u0000\u00f7\u00f8\u0003J%\u0000\u00f8\u00f9\u0005(\u0000"+
		"\u0000\u00f9\u00fb\u0003\u001c\u000e\u0000\u00fa\u00fc\u0003 \u0010\u0000"+
		"\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fe\u0001\u0000\u0000\u0000\u00fd\u00ff\u0003$\u0012\u0000\u00fe"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff"+
		"\u001f\u0001\u0000\u0000\u0000\u0100\u0102\u0003\"\u0011\u0000\u0101\u0100"+
		"\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0101"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104!\u0001"+
		"\u0000\u0000\u0000\u0105\u0106\u0005\u000b\u0000\u0000\u0106\u0107\u0005"+
		"\n\u0000\u0000\u0107\u0108\u0005\'\u0000\u0000\u0108\u0109\u0003J%\u0000"+
		"\u0109\u010a\u0005(\u0000\u0000\u010a\u010b\u0003\u001c\u000e\u0000\u010b"+
		"#\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u000b\u0000\u0000\u010d\u010e"+
		"\u0003\u001c\u000e\u0000\u010e%\u0001\u0000\u0000\u0000\u010f\u0110\u0005"+
		"\f\u0000\u0000\u0110\u0111\u0005\'\u0000\u0000\u0111\u0112\u0003J%\u0000"+
		"\u0112\u0113\u0005(\u0000\u0000\u0113\u0117\u0005#\u0000\u0000\u0114\u0116"+
		"\u0003(\u0014\u0000\u0115\u0114\u0001\u0000\u0000\u0000\u0116\u0119\u0001"+
		"\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118\u0001"+
		"\u0000\u0000\u0000\u0118\u011b\u0001\u0000\u0000\u0000\u0119\u0117\u0001"+
		"\u0000\u0000\u0000\u011a\u011c\u0003*\u0015\u0000\u011b\u011a\u0001\u0000"+
		"\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0005$\u0000\u0000\u011e\'\u0001\u0000\u0000"+
		"\u0000\u011f\u0120\u0005\r\u0000\u0000\u0120\u0121\u0003J%\u0000\u0121"+
		"\u0125\u0005 \u0000\u0000\u0122\u0124\u0003\u000e\u0007\u0000\u0123\u0122"+
		"\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123"+
		"\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126)\u0001"+
		"\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0129\u0005"+
		"\u000f\u0000\u0000\u0129\u012d\u0005 \u0000\u0000\u012a\u012c\u0003\u000e"+
		"\u0007\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000"+
		"\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000"+
		"\u0000\u0000\u012e+\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000"+
		"\u0000\u0130\u0131\u0005\u0011\u0000\u0000\u0131\u0132\u0005\'\u0000\u0000"+
		"\u0132\u0133\u0003J%\u0000\u0133\u0134\u0005(\u0000\u0000\u0134\u0135"+
		"\u0003\u001c\u000e\u0000\u0135-\u0001\u0000\u0000\u0000\u0136\u0137\u0005"+
		"\u0012\u0000\u0000\u0137\u0138\u0003\u001c\u000e\u0000\u0138\u0139\u0005"+
		"\u0011\u0000\u0000\u0139\u013a\u0005\'\u0000\u0000\u013a\u013b\u0003J"+
		"%\u0000\u013b\u013c\u0005(\u0000\u0000\u013c\u013d\u0005\u001f\u0000\u0000"+
		"\u013d/\u0001\u0000\u0000\u0000\u013e\u013f\u0005\u0010\u0000\u0000\u013f"+
		"\u0141\u0005\'\u0000\u0000\u0140\u0142\u00032\u0019\u0000\u0141\u0140"+
		"\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0001\u0000\u0000\u0000\u0143\u0145\u0005\u001f\u0000\u0000\u0144\u0146"+
		"\u0003J%\u0000\u0145\u0144\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000"+
		"\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147\u0149\u0005\u001f"+
		"\u0000\u0000\u0148\u014a\u00034\u001a\u0000\u0149\u0148\u0001\u0000\u0000"+
		"\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000"+
		"\u0000\u014b\u014c\u0005(\u0000\u0000\u014c\u014d\u0003\u001c\u000e\u0000"+
		"\u014d1\u0001\u0000\u0000\u0000\u014e\u0153\u0003L&\u0000\u014f\u0150"+
		"\u0005%\u0000\u0000\u0150\u0152\u0005&\u0000\u0000\u0151\u014f\u0001\u0000"+
		"\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000"+
		"\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0156\u0001\u0000"+
		"\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156\u0157\u0005>\u0000"+
		"\u0000\u0157\u0158\u0005\u001d\u0000\u0000\u0158\u0159\u0003J%\u0000\u0159"+
		"\u015f\u0001\u0000\u0000\u0000\u015a\u015b\u0003>\u001f\u0000\u015b\u015c"+
		"\u0005\u001d\u0000\u0000\u015c\u015d\u0003J%\u0000\u015d\u015f\u0001\u0000"+
		"\u0000\u0000\u015e\u014e\u0001\u0000\u0000\u0000\u015e\u015a\u0001\u0000"+
		"\u0000\u0000\u015f3\u0001\u0000\u0000\u0000\u0160\u0161\u0003>\u001f\u0000"+
		"\u0161\u0162\u0005.\u0000\u0000\u0162\u0170\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0003>\u001f\u0000\u0164\u0165\u0005/\u0000\u0000\u0165\u0170\u0001"+
		"\u0000\u0000\u0000\u0166\u0167\u0005.\u0000\u0000\u0167\u0170\u0003>\u001f"+
		"\u0000\u0168\u0169\u0005/\u0000\u0000\u0169\u0170\u0003>\u001f\u0000\u016a"+
		"\u016b\u0003>\u001f\u0000\u016b\u016c\u0005\u001d\u0000\u0000\u016c\u016d"+
		"\u0003J%\u0000\u016d\u0170\u0001\u0000\u0000\u0000\u016e\u0170\u0003:"+
		"\u001d\u0000\u016f\u0160\u0001\u0000\u0000\u0000\u016f\u0163\u0001\u0000"+
		"\u0000\u0000\u016f\u0166\u0001\u0000\u0000\u0000\u016f\u0168\u0001\u0000"+
		"\u0000\u0000\u016f\u016a\u0001\u0000\u0000\u0000\u016f\u016e\u0001\u0000"+
		"\u0000\u0000\u01705\u0001\u0000\u0000\u0000\u0171\u0176\u0003L&\u0000"+
		"\u0172\u0173\u0005%\u0000\u0000\u0173\u0175\u0005&\u0000\u0000\u0174\u0172"+
		"\u0001\u0000\u0000\u0000\u0175\u0178\u0001\u0000\u0000\u0000\u0176\u0174"+
		"\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0179"+
		"\u0001\u0000\u0000\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0179\u017c"+
		"\u0005>\u0000\u0000\u017a\u017b\u0005\u001d\u0000\u0000\u017b\u017d\u0003"+
		"J%\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000"+
		"\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f\u0005\u001f\u0000"+
		"\u0000\u017f7\u0001\u0000\u0000\u0000\u0180\u0181\u0003@ \u0000\u0181"+
		"\u0182\u0005\u001d\u0000\u0000\u0182\u0183\u0003J%\u0000\u0183\u0184\u0005"+
		"\u001f\u0000\u0000\u01849\u0001\u0000\u0000\u0000\u0185\u0186\u0003>\u001f"+
		"\u0000\u0186\u0187\u0005)\u0000\u0000\u0187\u0188\u0003J%\u0000\u0188"+
		"\u019a\u0001\u0000\u0000\u0000\u0189\u018a\u0003>\u001f\u0000\u018a\u018b"+
		"\u0005*\u0000\u0000\u018b\u018c\u0003J%\u0000\u018c\u019a\u0001\u0000"+
		"\u0000\u0000\u018d\u018e\u0003>\u001f\u0000\u018e\u018f\u0005+\u0000\u0000"+
		"\u018f\u0190\u0003J%\u0000\u0190\u019a\u0001\u0000\u0000\u0000\u0191\u0192"+
		"\u0003>\u001f\u0000\u0192\u0193\u0005,\u0000\u0000\u0193\u0194\u0003J"+
		"%\u0000\u0194\u019a\u0001\u0000\u0000\u0000\u0195\u0196\u0003>\u001f\u0000"+
		"\u0196\u0197\u0005-\u0000\u0000\u0197\u0198\u0003J%\u0000\u0198\u019a"+
		"\u0001\u0000\u0000\u0000\u0199\u0185\u0001\u0000\u0000\u0000\u0199\u0189"+
		"\u0001\u0000\u0000\u0000\u0199\u018d\u0001\u0000\u0000\u0000\u0199\u0191"+
		"\u0001\u0000\u0000\u0000\u0199\u0195\u0001\u0000\u0000\u0000\u019a;\u0001"+
		"\u0000\u0000\u0000\u019b\u019c\u0003>\u001f\u0000\u019c\u019d\u0005.\u0000"+
		"\u0000\u019d\u019e\u0005\u001f\u0000\u0000\u019e\u01ac\u0001\u0000\u0000"+
		"\u0000\u019f\u01a0\u0003>\u001f\u0000\u01a0\u01a1\u0005/\u0000\u0000\u01a1"+
		"\u01a2\u0005\u001f\u0000\u0000\u01a2\u01ac\u0001\u0000\u0000\u0000\u01a3"+
		"\u01a4\u0005.\u0000\u0000\u01a4\u01a5\u0003>\u001f\u0000\u01a5\u01a6\u0005"+
		"\u001f\u0000\u0000\u01a6\u01ac\u0001\u0000\u0000\u0000\u01a7\u01a8\u0005"+
		"/\u0000\u0000\u01a8\u01a9\u0003>\u001f\u0000\u01a9\u01aa\u0005\u001f\u0000"+
		"\u0000\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u019b\u0001\u0000\u0000"+
		"\u0000\u01ab\u019f\u0001\u0000\u0000\u0000\u01ab\u01a3\u0001\u0000\u0000"+
		"\u0000\u01ab\u01a7\u0001\u0000\u0000\u0000\u01ac=\u0001\u0000\u0000\u0000"+
		"\u01ad\u01ae\u0003@ \u0000\u01ae?\u0001\u0000\u0000\u0000\u01af\u01b0"+
		"\u0006 \uffff\uffff\u0000\u01b0\u01b1\u0005>\u0000\u0000\u01b1\u01b3\u0005"+
		"\'\u0000\u0000\u01b2\u01b4\u0003B!\u0000\u01b3\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b5\u01b8\u0005(\u0000\u0000\u01b6\u01b8\u0005>\u0000\u0000\u01b7"+
		"\u01af\u0001\u0000\u0000\u0000\u01b7\u01b6\u0001\u0000\u0000\u0000\u01b8"+
		"\u01cb\u0001\u0000\u0000\u0000\u01b9\u01ba\n\u0005\u0000\u0000\u01ba\u01bb"+
		"\u0005\"\u0000\u0000\u01bb\u01ca\u0005>\u0000\u0000\u01bc\u01bd\n\u0004"+
		"\u0000\u0000\u01bd\u01be\u0005\"\u0000\u0000\u01be\u01bf\u0005>\u0000"+
		"\u0000\u01bf\u01c1\u0005\'\u0000\u0000\u01c0\u01c2\u0003B!\u0000\u01c1"+
		"\u01c0\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000\u01c2"+
		"\u01c3\u0001\u0000\u0000\u0000\u01c3\u01ca\u0005(\u0000\u0000\u01c4\u01c5"+
		"\n\u0003\u0000\u0000\u01c5\u01c6\u0005%\u0000\u0000\u01c6\u01c7\u0003"+
		"J%\u0000\u01c7\u01c8\u0005&\u0000\u0000\u01c8\u01ca\u0001\u0000\u0000"+
		"\u0000\u01c9\u01b9\u0001\u0000\u0000\u0000\u01c9\u01bc\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c4\u0001\u0000\u0000\u0000\u01ca\u01cd\u0001\u0000\u0000"+
		"\u0000\u01cb\u01c9\u0001\u0000\u0000\u0000\u01cb\u01cc\u0001\u0000\u0000"+
		"\u0000\u01ccA\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001\u0000\u0000\u0000"+
		"\u01ce\u01d3\u0003J%\u0000\u01cf\u01d0\u0005\u001e\u0000\u0000\u01d0\u01d2"+
		"\u0003J%\u0000\u01d1\u01cf\u0001\u0000\u0000\u0000\u01d2\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d4C\u0001\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000"+
		"\u0000\u01d6\u01d7\u0005\u0004\u0000\u0000\u01d7\u01d8\u0003L&\u0000\u01d8"+
		"\u01da\u0005\'\u0000\u0000\u01d9\u01db\u0003B!\u0000\u01da\u01d9\u0001"+
		"\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0001"+
		"\u0000\u0000\u0000\u01dc\u01dd\u0005(\u0000\u0000\u01dd\u01e9\u0001\u0000"+
		"\u0000\u0000\u01de\u01df\u0005\u0004\u0000\u0000\u01df\u01e4\u0003L&\u0000"+
		"\u01e0\u01e1\u0005%\u0000\u0000\u01e1\u01e2\u0003J%\u0000\u01e2\u01e3"+
		"\u0005&\u0000\u0000\u01e3\u01e5\u0001\u0000\u0000\u0000\u01e4\u01e0\u0001"+
		"\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e4\u0001"+
		"\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e9\u0001"+
		"\u0000\u0000\u0000\u01e8\u01d6\u0001\u0000\u0000\u0000\u01e8\u01de\u0001"+
		"\u0000\u0000\u0000\u01e9E\u0001\u0000\u0000\u0000\u01ea\u01ec\u0005#\u0000"+
		"\u0000\u01eb\u01ed\u0003H$\u0000\u01ec\u01eb\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ef\u0005$\u0000\u0000\u01efG\u0001\u0000\u0000\u0000\u01f0\u01f5\u0003"+
		"J%\u0000\u01f1\u01f2\u0005\u001e\u0000\u0000\u01f2\u01f4\u0003J%\u0000"+
		"\u01f3\u01f1\u0001\u0000\u0000\u0000\u01f4\u01f7\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000"+
		"\u01f6I\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f9\u0006%\uffff\uffff\u0000\u01f9\u01fa\u0005\'\u0000\u0000\u01fa"+
		"\u01fb\u0003J%\u0000\u01fb\u01fc\u0005(\u0000\u0000\u01fc\u0201\u0001"+
		"\u0000\u0000\u0000\u01fd\u01fe\u0007\u0000\u0000\u0000\u01fe\u0201\u0003"+
		"J%\t\u01ff\u0201\u0003P(\u0000\u0200\u01f8\u0001\u0000\u0000\u0000\u0200"+
		"\u01fd\u0001\u0000\u0000\u0000\u0200\u01ff\u0001\u0000\u0000\u0000\u0201"+
		"\u021c\u0001\u0000\u0000\u0000\u0202\u0203\n\b\u0000\u0000\u0203\u0204"+
		"\u0007\u0001\u0000\u0000\u0204\u021b\u0003J%\t\u0205\u0206\n\u0007\u0000"+
		"\u0000\u0206\u0207\u0007\u0002\u0000\u0000\u0207\u021b\u0003J%\b\u0208"+
		"\u0209\n\u0006\u0000\u0000\u0209\u020a\u0007\u0003\u0000\u0000\u020a\u021b"+
		"\u0003J%\u0007\u020b\u020c\n\u0005\u0000\u0000\u020c\u020d\u0007\u0004"+
		"\u0000\u0000\u020d\u021b\u0003J%\u0006\u020e\u020f\n\u0004\u0000\u0000"+
		"\u020f\u0210\u0005;\u0000\u0000\u0210\u021b\u0003J%\u0005\u0211\u0212"+
		"\n\u0003\u0000\u0000\u0212\u0213\u0005<\u0000\u0000\u0213\u021b\u0003"+
		"J%\u0004\u0214\u0215\n\u0002\u0000\u0000\u0215\u0216\u0005!\u0000\u0000"+
		"\u0216\u0217\u0003J%\u0000\u0217\u0218\u0005 \u0000\u0000\u0218\u0219"+
		"\u0003J%\u0002\u0219\u021b\u0001\u0000\u0000\u0000\u021a\u0202\u0001\u0000"+
		"\u0000\u0000\u021a\u0205\u0001\u0000\u0000\u0000\u021a\u0208\u0001\u0000"+
		"\u0000\u0000\u021a\u020b\u0001\u0000\u0000\u0000\u021a\u020e\u0001\u0000"+
		"\u0000\u0000\u021a\u0211\u0001\u0000\u0000\u0000\u021a\u0214\u0001\u0000"+
		"\u0000\u0000\u021b\u021e\u0001\u0000\u0000\u0000\u021c\u021a\u0001\u0000"+
		"\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000\u021dK\u0001\u0000\u0000"+
		"\u0000\u021e\u021c\u0001\u0000\u0000\u0000\u021f\u0222\u0003N\'\u0000"+
		"\u0220\u0222\u0005>\u0000\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0221"+
		"\u0220\u0001\u0000\u0000\u0000\u0222M\u0001\u0000\u0000\u0000\u0223\u0229"+
		"\u0005\u0016\u0000\u0000\u0224\u0229\u0005\u0017\u0000\u0000\u0225\u0229"+
		"\u0005\u0018\u0000\u0000\u0226\u0229\u0005\u0019\u0000\u0000\u0227\u0229"+
		"\u0005\u001a\u0000\u0000\u0228\u0223\u0001\u0000\u0000\u0000\u0228\u0224"+
		"\u0001\u0000\u0000\u0000\u0228\u0225\u0001\u0000\u0000\u0000\u0228\u0226"+
		"\u0001\u0000\u0000\u0000\u0228\u0227\u0001\u0000\u0000\u0000\u0229O\u0001"+
		"\u0000\u0000\u0000\u022a\u0235\u0005A\u0000\u0000\u022b\u0235\u0005B\u0000"+
		"\u0000\u022c\u0235\u0005@\u0000\u0000\u022d\u0235\u0005?\u0000\u0000\u022e"+
		"\u0235\u0003R)\u0000\u022f\u0235\u0005\u0005\u0000\u0000\u0230\u0235\u0003"+
		"D\"\u0000\u0231\u0235\u0003@ \u0000\u0232\u0235\u0003F#\u0000\u0233\u0235"+
		"\u0003\u0018\f\u0000\u0234\u022a\u0001\u0000\u0000\u0000\u0234\u022b\u0001"+
		"\u0000\u0000\u0000\u0234\u022c\u0001\u0000\u0000\u0000\u0234\u022d\u0001"+
		"\u0000\u0000\u0000\u0234\u022e\u0001\u0000\u0000\u0000\u0234\u022f\u0001"+
		"\u0000\u0000\u0000\u0234\u0230\u0001\u0000\u0000\u0000\u0234\u0231\u0001"+
		"\u0000\u0000\u0000\u0234\u0232\u0001\u0000\u0000\u0000\u0234\u0233\u0001"+
		"\u0000\u0000\u0000\u0235Q\u0001\u0000\u0000\u0000\u0236\u0239\u0005\u001b"+
		"\u0000\u0000\u0237\u0239\u0005\u001c\u0000\u0000\u0238\u0236\u0001\u0000"+
		"\u0000\u0000\u0238\u0237\u0001\u0000\u0000\u0000\u0239S\u0001\u0000\u0000"+
		"\u00006^fls~\u0084\u008b\u0095\u009d\u00af\u00b6\u00bd\u00c0\u00c4\u00cc"+
		"\u00dd\u00e8\u00ee\u00f3\u00fb\u00fe\u0103\u0117\u011b\u0125\u012d\u0141"+
		"\u0145\u0149\u0153\u015e\u016f\u0176\u017c\u0199\u01ab\u01b3\u01b7\u01c1"+
		"\u01c9\u01cb\u01d3\u01da\u01e6\u01e8\u01ec\u01f5\u0200\u021a\u021c\u0221"+
		"\u0228\u0234\u0238";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}