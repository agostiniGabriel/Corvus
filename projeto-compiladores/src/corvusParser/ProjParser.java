// Generated from C:/Users/Eugene/Desktop/ufabc/compiladores/Corvus/projeto-compiladores\Proj.g4 by ANTLR 4.9.1
package corvusParser;

    import corvusDataStructures.CorvusSymbol;
    import corvusDataStructures.CorvusVariable;
    import corvusDataStructures.CorvusSymbolTable;
    import corvusExceptions.CorvusSemanticException;
    import corvusAST.CorvusAbstractCommand;
    import corvusAST.CorvusProgram;
    import corvusAST.CommandRead;
    import corvusAST.CommandWrite;
    import corvusAST.CommandAttr;
    import corvusAST.CommandDecider;
    import corvusAST.CommandWhile;
    import java.util.ArrayList;
    import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProjParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		WhiteSpace=10, OpenParentheses=11, CloseParentheses=12, OpenBraces=13, 
		CloseBraces=14, Semicolon=15, Colon=16, Operation=17, LogicalOperator=18, 
		Attribute=19, Integer=20, Float=21, String=22, IfSintax=23, ElseSintax=24, 
		WhileSintax=25, Identifier=26, Char=27;
	public static final int
		RULE_prog = 0, RULE_decl = 1, RULE_varDeclaration = 2, RULE_type = 3, 
		RULE_codeBlock = 4, RULE_command = 5, RULE_read = 6, RULE_write = 7, RULE_attribute = 8, 
		RULE_expression = 9, RULE_boolExpression = 10, RULE_termo = 11, RULE_ifCMD = 12, 
		RULE_ifElseCMD = 13, RULE_whileCMD = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "decl", "varDeclaration", "type", "codeBlock", "command", "read", 
			"write", "attribute", "expression", "boolExpression", "termo", "ifCMD", 
			"ifElseCMD", "whileCMD"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'end'", "'int'", "'float'", "'string'", "'list'", 
			"'obj'", "'read'", "'write'", null, "'('", "')'", "'{'", "'}'", "';'", 
			"','", null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "WhiteSpace", 
			"OpenParentheses", "CloseParentheses", "OpenBraces", "CloseBraces", "Semicolon", 
			"Colon", "Operation", "LogicalOperator", "Attribute", "Integer", "Float", 
			"String", "IfSintax", "ElseSintax", "WhileSintax", "Identifier", "Char"
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
	public String getGrammarFileName() { return "Proj.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private int _varType;
	    private String _varName;
	    private String _varValue;
	    private CorvusSymbolTable symbolTable = new CorvusSymbolTable();
	    private Stack<ArrayList<CorvusAbstractCommand>> cmdStack = new Stack<ArrayList<CorvusAbstractCommand>>();
	    private Stack<String> conditionStack = new Stack<String>();
	    private CorvusSymbol symbol;
	    private CorvusProgram program = new CorvusProgram();
	    private ArrayList<CorvusAbstractCommand> curThread;
	    private ArrayList<CorvusAbstractCommand> cmdTrue;
	    private ArrayList<CorvusAbstractCommand> cmdFalse;
	    private ArrayList<CorvusAbstractCommand> cmdWhile;

	    private String _readId;
	    private String _writeId;
	    private String _attrId;
	    private String _attrContent;
	    private String _exprDecision;

	    private void verifyId(String id){
	        if(!symbolTable.exists(id)){
	            throw new CorvusSemanticException("Variable '" + id + "' has not been declared");
	        }
	    }

	    public void printCMD(){
	        for(CorvusAbstractCommand cur : program.getCmd()){
	            System.out.println(cur.toString());
	        }
	    }
	    
		public void generateCode(){
			program.generateTarget();
		}

	public ProjParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode OpenBraces() { return getToken(ProjParser.OpenBraces, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public TerminalNode CloseBraces() { return getToken(ProjParser.CloseBraces, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			match(OpenBraces);
			setState(32);
			decl();
			setState(33);
			codeBlock();
			setState(34);
			match(CloseBraces);
			setState(35);
			match(T__1);

			        program.setVarTable(symbolTable);
			        program.setCmd(cmdStack.pop());
			    
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

	public static class DeclContext extends ParserRuleContext {
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(38);
					varDeclaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(41); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(ProjParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(ProjParser.Identifier, i);
		}
		public TerminalNode Semicolon() { return getToken(ProjParser.Semicolon, 0); }
		public List<TerminalNode> Colon() { return getTokens(ProjParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(ProjParser.Colon, i);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitVarDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitVarDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			type();
			setState(44);
			match(Identifier);

			                        _varName = _input.LT(-1).getText();
			                        _varValue = null;
			                        symbol = new CorvusVariable(_varName,_varValue,_varType);
			                        symbolTable.add(symbol);
			                    
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Colon) {
				{
				{
				setState(46);
				match(Colon);
				setState(47);
				match(Identifier);

				                        _varName = _input.LT(-1).getText();
				                        _varValue = null;
				                        symbol = new CorvusVariable(_varName,_varValue,_varType);
				                        symbolTable.add(symbol);
				                    
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(Semicolon);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(T__2);
				 _varType = CorvusVariable.intVar; 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(T__3);
				 _varType = CorvusVariable.floatVar; 
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				match(T__4);
				 _varType = CorvusVariable.stringVar; 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(T__5);
				 _varType = CorvusVariable.listVar; 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 5);
				{
				setState(64);
				match(T__6);
				 _varType = CorvusVariable.objVar; 
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

	public static class CodeBlockContext extends ParserRuleContext {
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitCodeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitCodeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_codeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        curThread = new ArrayList<CorvusAbstractCommand>();
			        cmdStack.push(curThread);
			    
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << IfSintax) | (1L << WhileSintax) | (1L << Identifier))) != 0)) {
				{
				{
				setState(69);
				command();
				}
				}
				setState(74);
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

	public static class CommandContext extends ParserRuleContext {
		public ReadContext read() {
			return getRuleContext(ReadContext.class,0);
		}
		public WriteContext write() {
			return getRuleContext(WriteContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public IfCMDContext ifCMD() {
			return getRuleContext(IfCMDContext.class,0);
		}
		public IfElseCMDContext ifElseCMD() {
			return getRuleContext(IfElseCMDContext.class,0);
		}
		public WhileCMDContext whileCMD() {
			return getRuleContext(WhileCMDContext.class,0);
		}
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_command);
		try {
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				read();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				write();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				attribute();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				ifCMD();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				ifElseCMD();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				whileCMD();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				varDeclaration();
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

	public static class ReadContext extends ParserRuleContext {
		public TerminalNode OpenParentheses() { return getToken(ProjParser.OpenParentheses, 0); }
		public TerminalNode Identifier() { return getToken(ProjParser.Identifier, 0); }
		public TerminalNode CloseParentheses() { return getToken(ProjParser.CloseParentheses, 0); }
		public TerminalNode Semicolon() { return getToken(ProjParser.Semicolon, 0); }
		public ReadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitRead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadContext read() throws RecognitionException {
		ReadContext _localctx = new ReadContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_read);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__7);
			setState(85);
			match(OpenParentheses);
			setState(86);
			match(Identifier);

			        verifyId(_input.LT(-1).getText());
			        _readId = _input.LT(-1).getText();
			    
			setState(88);
			match(CloseParentheses);
			setState(89);
			match(Semicolon);

			        CommandRead cmd = new CommandRead(_readId);
			        cmdStack.peek().add(cmd);
			    
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

	public static class WriteContext extends ParserRuleContext {
		public TerminalNode OpenParentheses() { return getToken(ProjParser.OpenParentheses, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TerminalNode CloseParentheses() { return getToken(ProjParser.CloseParentheses, 0); }
		public TerminalNode Semicolon() { return getToken(ProjParser.Semicolon, 0); }
		public WriteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterWrite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitWrite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitWrite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WriteContext write() throws RecognitionException {
		WriteContext _localctx = new WriteContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_write);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__8);
			setState(93);
			match(OpenParentheses);
			setState(94);
			termo();

			        _writeId = _input.LT(-1).getText();
			    
			setState(96);
			match(CloseParentheses);
			setState(97);
			match(Semicolon);

			        CommandWrite cmd = new CommandWrite(_writeId);
			        cmdStack.peek().add(cmd);
			    
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

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ProjParser.Identifier, 0); }
		public TerminalNode Attribute() { return getToken(ProjParser.Attribute, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(ProjParser.Semicolon, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(Identifier);

			      verifyId(_input.LT(-1).getText());
			      _varName = _input.LT(-1).getText();
			      _attrId = _varName;
			    
			setState(102);
			match(Attribute);

			      _attrContent = "";
			    
			setState(104);
			expression();

			        CommandAttr cmd = new CommandAttr(_attrId,_attrContent);
			        cmdStack.peek().add(cmd);
			    
			setState(106);
			match(Semicolon);
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

	public static class ExpressionContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> Operation() { return getTokens(ProjParser.Operation); }
		public TerminalNode Operation(int i) {
			return getToken(ProjParser.Operation, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			termo();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operation) {
				{
				{
				setState(109);
				match(Operation);
				_attrContent += _input.LT(-1).getText();
				setState(111);
				termo();
				}
				}
				setState(116);
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

	public static class BoolExpressionContext extends ParserRuleContext {
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<TerminalNode> LogicalOperator() { return getTokens(ProjParser.LogicalOperator); }
		public TerminalNode LogicalOperator(int i) {
			return getToken(ProjParser.LogicalOperator, i);
		}
		public BoolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExpressionContext boolExpression() throws RecognitionException {
		BoolExpressionContext _localctx = new BoolExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_boolExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			termo();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LogicalOperator) {
				{
				{
				setState(118);
				match(LogicalOperator);
				_attrContent += _input.LT(-1).getText();
				setState(120);
				termo();
				}
				}
				setState(125);
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

	public static class TermoContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ProjParser.Identifier, 0); }
		public TerminalNode Integer() { return getToken(ProjParser.Integer, 0); }
		public TerminalNode Float() { return getToken(ProjParser.Float, 0); }
		public TerminalNode String() { return getToken(ProjParser.String, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				match(Identifier);

				        verifyId(_input.LT(-1).getText());
				        _varName = _input.LT(-1).getText();
				        _attrContent += _input.LT(-1).getText();
				    
				}
				break;
			case Integer:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(Integer);
				_attrContent += _input.LT(-1).getText();
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				match(Float);
				_attrContent += _input.LT(-1).getText();
				}
				break;
			case String:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(String);
				_attrContent += _input.LT(-1).getText();
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

	public static class IfCMDContext extends ParserRuleContext {
		public TerminalNode IfSintax() { return getToken(ProjParser.IfSintax, 0); }
		public TerminalNode OpenParentheses() { return getToken(ProjParser.OpenParentheses, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode CloseParentheses() { return getToken(ProjParser.CloseParentheses, 0); }
		public TerminalNode OpenBraces() { return getToken(ProjParser.OpenBraces, 0); }
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public TerminalNode CloseBraces() { return getToken(ProjParser.CloseBraces, 0); }
		public IfCMDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifCMD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterIfCMD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitIfCMD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitIfCMD(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfCMDContext ifCMD() throws RecognitionException {
		IfCMDContext _localctx = new IfCMDContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifCMD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(IfSintax);
			_attrContent = "";
			setState(138);
			match(OpenParentheses);
			setState(139);
			boolExpression();
			setState(140);
			match(CloseParentheses);

			        _exprDecision = _attrContent;
			        conditionStack.push(_exprDecision);
			    
			setState(142);
			match(OpenBraces);
			setState(143);
			codeBlock();
			setState(144);
			match(CloseBraces);

			        cmdTrue = cmdStack.pop();
			        CommandDecider cmd = new CommandDecider(conditionStack.pop(), cmdTrue, null);
			        cmdStack.peek().add(cmd);
			    
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

	public static class IfElseCMDContext extends ParserRuleContext {
		public TerminalNode IfSintax() { return getToken(ProjParser.IfSintax, 0); }
		public TerminalNode OpenParentheses() { return getToken(ProjParser.OpenParentheses, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode CloseParentheses() { return getToken(ProjParser.CloseParentheses, 0); }
		public List<TerminalNode> OpenBraces() { return getTokens(ProjParser.OpenBraces); }
		public TerminalNode OpenBraces(int i) {
			return getToken(ProjParser.OpenBraces, i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public List<TerminalNode> CloseBraces() { return getTokens(ProjParser.CloseBraces); }
		public TerminalNode CloseBraces(int i) {
			return getToken(ProjParser.CloseBraces, i);
		}
		public TerminalNode ElseSintax() { return getToken(ProjParser.ElseSintax, 0); }
		public IfElseCMDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseCMD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterIfElseCMD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitIfElseCMD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitIfElseCMD(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseCMDContext ifElseCMD() throws RecognitionException {
		IfElseCMDContext _localctx = new IfElseCMDContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifElseCMD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(IfSintax);
			_attrContent = "";
			setState(149);
			match(OpenParentheses);
			setState(150);
			boolExpression();
			setState(151);
			match(CloseParentheses);

			        _exprDecision = _attrContent;
			        conditionStack.push(_exprDecision);
			    
			setState(153);
			match(OpenBraces);
			setState(154);
			codeBlock();
			setState(155);
			match(CloseBraces);

			        cmdTrue = cmdStack.pop();
			    
			setState(157);
			match(ElseSintax);
			setState(158);
			match(OpenBraces);
			setState(159);
			codeBlock();
			setState(160);
			match(CloseBraces);

			        cmdFalse = cmdStack.pop();
			        CommandDecider cmd = new CommandDecider(conditionStack.pop(), cmdTrue, cmdFalse);
			        cmdStack.peek().add(cmd);
			    
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

	public static class WhileCMDContext extends ParserRuleContext {
		public TerminalNode WhileSintax() { return getToken(ProjParser.WhileSintax, 0); }
		public TerminalNode OpenParentheses() { return getToken(ProjParser.OpenParentheses, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode CloseParentheses() { return getToken(ProjParser.CloseParentheses, 0); }
		public TerminalNode OpenBraces() { return getToken(ProjParser.OpenBraces, 0); }
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public TerminalNode CloseBraces() { return getToken(ProjParser.CloseBraces, 0); }
		public WhileCMDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileCMD; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterWhileCMD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitWhileCMD(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProjVisitor ) return ((ProjVisitor<? extends T>)visitor).visitWhileCMD(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileCMDContext whileCMD() throws RecognitionException {
		WhileCMDContext _localctx = new WhileCMDContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_whileCMD);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(WhileSintax);
			setState(164);
			match(OpenParentheses);
			_attrContent = "";
			setState(166);
			boolExpression();
			setState(167);
			match(CloseParentheses);

			        _exprDecision = _attrContent;
			        conditionStack.push(_exprDecision);
			    
			setState(169);
			match(OpenBraces);
			setState(170);
			codeBlock();
			setState(171);
			match(CloseBraces);

			        cmdWhile = cmdStack.pop();
			        CommandWhile cmd  = new CommandWhile(conditionStack.pop(),cmdWhile);
			        cmdStack.peek().add(cmd);
			    
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00b1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\6\3*\n\3\r\3\16\3+\3\4\3\4\3\4\3\4\3\4\3\4\7\4\64\n"+
		"\4\f\4\16\4\67\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5E\n\5\3\6\3\6\7\6I\n\6\f\6\16\6L\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5"+
		"\7U\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13s\n\13\f\13"+
		"\16\13v\13\13\3\f\3\f\3\f\3\f\7\f|\n\f\f\f\16\f\177\13\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0089\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\2"+
		"\u00b3\2 \3\2\2\2\4)\3\2\2\2\6-\3\2\2\2\bD\3\2\2\2\nF\3\2\2\2\fT\3\2\2"+
		"\2\16V\3\2\2\2\20^\3\2\2\2\22f\3\2\2\2\24n\3\2\2\2\26w\3\2\2\2\30\u0088"+
		"\3\2\2\2\32\u008a\3\2\2\2\34\u0095\3\2\2\2\36\u00a5\3\2\2\2 !\7\3\2\2"+
		"!\"\7\17\2\2\"#\5\4\3\2#$\5\n\6\2$%\7\20\2\2%&\7\4\2\2&\'\b\2\1\2\'\3"+
		"\3\2\2\2(*\5\6\4\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\5\3\2\2\2"+
		"-.\5\b\5\2./\7\34\2\2/\65\b\4\1\2\60\61\7\22\2\2\61\62\7\34\2\2\62\64"+
		"\b\4\1\2\63\60\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3"+
		"\2\2\2\67\65\3\2\2\289\7\21\2\29\7\3\2\2\2:;\7\5\2\2;E\b\5\1\2<=\7\6\2"+
		"\2=E\b\5\1\2>?\7\7\2\2?E\b\5\1\2@A\7\b\2\2AE\b\5\1\2BC\7\t\2\2CE\b\5\1"+
		"\2D:\3\2\2\2D<\3\2\2\2D>\3\2\2\2D@\3\2\2\2DB\3\2\2\2E\t\3\2\2\2FJ\b\6"+
		"\1\2GI\5\f\7\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\13\3\2\2\2LJ\3"+
		"\2\2\2MU\5\16\b\2NU\5\20\t\2OU\5\22\n\2PU\5\32\16\2QU\5\34\17\2RU\5\36"+
		"\20\2SU\5\6\4\2TM\3\2\2\2TN\3\2\2\2TO\3\2\2\2TP\3\2\2\2TQ\3\2\2\2TR\3"+
		"\2\2\2TS\3\2\2\2U\r\3\2\2\2VW\7\n\2\2WX\7\r\2\2XY\7\34\2\2YZ\b\b\1\2Z"+
		"[\7\16\2\2[\\\7\21\2\2\\]\b\b\1\2]\17\3\2\2\2^_\7\13\2\2_`\7\r\2\2`a\5"+
		"\30\r\2ab\b\t\1\2bc\7\16\2\2cd\7\21\2\2de\b\t\1\2e\21\3\2\2\2fg\7\34\2"+
		"\2gh\b\n\1\2hi\7\25\2\2ij\b\n\1\2jk\5\24\13\2kl\b\n\1\2lm\7\21\2\2m\23"+
		"\3\2\2\2nt\5\30\r\2op\7\23\2\2pq\b\13\1\2qs\5\30\r\2ro\3\2\2\2sv\3\2\2"+
		"\2tr\3\2\2\2tu\3\2\2\2u\25\3\2\2\2vt\3\2\2\2w}\5\30\r\2xy\7\24\2\2yz\b"+
		"\f\1\2z|\5\30\r\2{x\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\27\3\2\2"+
		"\2\177}\3\2\2\2\u0080\u0081\7\34\2\2\u0081\u0089\b\r\1\2\u0082\u0083\7"+
		"\26\2\2\u0083\u0089\b\r\1\2\u0084\u0085\7\27\2\2\u0085\u0089\b\r\1\2\u0086"+
		"\u0087\7\30\2\2\u0087\u0089\b\r\1\2\u0088\u0080\3\2\2\2\u0088\u0082\3"+
		"\2\2\2\u0088\u0084\3\2\2\2\u0088\u0086\3\2\2\2\u0089\31\3\2\2\2\u008a"+
		"\u008b\7\31\2\2\u008b\u008c\b\16\1\2\u008c\u008d\7\r\2\2\u008d\u008e\5"+
		"\26\f\2\u008e\u008f\7\16\2\2\u008f\u0090\b\16\1\2\u0090\u0091\7\17\2\2"+
		"\u0091\u0092\5\n\6\2\u0092\u0093\7\20\2\2\u0093\u0094\b\16\1\2\u0094\33"+
		"\3\2\2\2\u0095\u0096\7\31\2\2\u0096\u0097\b\17\1\2\u0097\u0098\7\r\2\2"+
		"\u0098\u0099\5\26\f\2\u0099\u009a\7\16\2\2\u009a\u009b\b\17\1\2\u009b"+
		"\u009c\7\17\2\2\u009c\u009d\5\n\6\2\u009d\u009e\7\20\2\2\u009e\u009f\b"+
		"\17\1\2\u009f\u00a0\7\32\2\2\u00a0\u00a1\7\17\2\2\u00a1\u00a2\5\n\6\2"+
		"\u00a2\u00a3\7\20\2\2\u00a3\u00a4\b\17\1\2\u00a4\35\3\2\2\2\u00a5\u00a6"+
		"\7\33\2\2\u00a6\u00a7\7\r\2\2\u00a7\u00a8\b\20\1\2\u00a8\u00a9\5\26\f"+
		"\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\b\20\1\2\u00ab\u00ac\7\17\2\2\u00ac"+
		"\u00ad\5\n\6\2\u00ad\u00ae\7\20\2\2\u00ae\u00af\b\20\1\2\u00af\37\3\2"+
		"\2\2\n+\65DJTt}\u0088";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}