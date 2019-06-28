// Generated from /home/diogo/Downloads/QPP1-master/src/interpreter/Qplpl.g4 by ANTLR 4.7.2
package interpreter;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QplplParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		INTL=46, CHARL=47, STRL=48, BOOLL=49, ID=50, COMMENTBLOCK=51, COMMENTLINE=52, 
		WS=53;
	public static final int
		RULE_programa = 0, RULE_definicao = 1, RULE_estrutura = 2, RULE_estruturaAcesso = 3, 
		RULE_listMembro = 4, RULE_atributo = 5, RULE_variavel = 6, RULE_construtor = 7, 
		RULE_metodo = 8, RULE_func = 9, RULE_parametros_formais = 10, RULE_tipo = 11, 
		RULE_nome = 12, RULE_parametros_reais = 13, RULE_qualificador = 14, RULE_comando = 15, 
		RULE_bloco = 16, RULE_selecao = 17, RULE_repeticao = 18, RULE_atribuicao = 19, 
		RULE_retorno = 20, RULE_entrada = 21, RULE_saida = 22, RULE_expressao = 23, 
		RULE_literal = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "definicao", "estrutura", "estruturaAcesso", "listMembro", 
			"atributo", "variavel", "construtor", "metodo", "func", "parametros_formais", 
			"tipo", "nome", "parametros_reais", "qualificador", "comando", "bloco", 
			"selecao", "repeticao", "atribuicao", "retorno", "entrada", "saida", 
			"expressao", "literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'struct'", "'{'", "'}'", "'public'", "':'", "'private'", "'protected'", 
			"';'", "'='", "'('", "')'", "'void'", "','", "'int'", "'char'", "'bool'", 
			"'string'", "'.'", "'const'", "'static'", "'break'", "'if'", "'else '", 
			"'while'", "'return'", "'std::cin'", "'>>'", "'std::cout'", "'<<'", "'+'", 
			"'-'", "'++'", "'--'", "'!'", "'%'", "'*'", "'/'", "'<'", "'<='", "'>'", 
			"'>='", "'=='", "'!='", "'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "INTL", "CHARL", 
			"STRL", "BOOLL", "ID", "COMMENTBLOCK", "COMMENTLINE", "WS"
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
	public String getGrammarFileName() { return "Qplpl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QplplParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(QplplParser.EOF, 0); }
		public List<DefinicaoContext> definicao() {
			return getRuleContexts(DefinicaoContext.class);
		}
		public DefinicaoContext definicao(int i) {
			return getRuleContext(DefinicaoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << ID))) != 0)) {
				{
				{
				setState(50);
				definicao();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
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

	public static class DefinicaoContext extends ParserRuleContext {
		public DefinicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definicao; }
	 
		public DefinicaoContext() { }
		public void copyFrom(DefinicaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefinicaoFuncaoContext extends DefinicaoContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public DefinicaoFuncaoContext(DefinicaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitDefinicaoFuncao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefinicaoVariavelContext extends DefinicaoContext {
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public DefinicaoVariavelContext(DefinicaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitDefinicaoVariavel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefinicaoEstruturaContext extends DefinicaoContext {
		public EstruturaContext estrutura() {
			return getRuleContext(EstruturaContext.class,0);
		}
		public DefinicaoEstruturaContext(DefinicaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitDefinicaoEstrutura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinicaoContext definicao() throws RecognitionException {
		DefinicaoContext _localctx = new DefinicaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definicao);
		try {
			setState(61);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new DefinicaoFuncaoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				func();
				}
				break;
			case 2:
				_localctx = new DefinicaoEstruturaContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				estrutura();
				}
				break;
			case 3:
				_localctx = new DefinicaoVariavelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				variavel();
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

	public static class EstruturaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public List<EstruturaAcessoContext> estruturaAcesso() {
			return getRuleContexts(EstruturaAcessoContext.class);
		}
		public EstruturaAcessoContext estruturaAcesso(int i) {
			return getRuleContext(EstruturaAcessoContext.class,i);
		}
		public EstruturaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estrutura; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitEstrutura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstruturaContext estrutura() throws RecognitionException {
		EstruturaContext _localctx = new EstruturaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_estrutura);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__0);
			setState(64);
			match(ID);
			setState(65);
			match(T__1);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__6))) != 0)) {
				{
				{
				setState(66);
				estruturaAcesso();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(T__2);
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

	public static class EstruturaAcessoContext extends ParserRuleContext {
		public EstruturaAcessoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_estruturaAcesso; }
	 
		public EstruturaAcessoContext() { }
		public void copyFrom(EstruturaAcessoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EstrutPrivateContext extends EstruturaAcessoContext {
		public List<ListMembroContext> listMembro() {
			return getRuleContexts(ListMembroContext.class);
		}
		public ListMembroContext listMembro(int i) {
			return getRuleContext(ListMembroContext.class,i);
		}
		public EstrutPrivateContext(EstruturaAcessoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitEstrutPrivate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EstrutPublicContext extends EstruturaAcessoContext {
		public List<ListMembroContext> listMembro() {
			return getRuleContexts(ListMembroContext.class);
		}
		public ListMembroContext listMembro(int i) {
			return getRuleContext(ListMembroContext.class,i);
		}
		public EstrutPublicContext(EstruturaAcessoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitEstrutPublic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EstrutProtectedContext extends EstruturaAcessoContext {
		public List<ListMembroContext> listMembro() {
			return getRuleContexts(ListMembroContext.class);
		}
		public ListMembroContext listMembro(int i) {
			return getRuleContext(ListMembroContext.class,i);
		}
		public EstrutProtectedContext(EstruturaAcessoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitEstrutProtected(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EstruturaAcessoContext estruturaAcesso() throws RecognitionException {
		EstruturaAcessoContext _localctx = new EstruturaAcessoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_estruturaAcesso);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				_localctx = new EstrutPublicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(T__3);
				setState(75);
				match(T__4);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__19) | (1L << ID))) != 0)) {
					{
					{
					setState(76);
					listMembro();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				_localctx = new EstrutPrivateContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(T__5);
				setState(83);
				match(T__4);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__19) | (1L << ID))) != 0)) {
					{
					{
					setState(84);
					listMembro();
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__6:
				_localctx = new EstrutProtectedContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(T__6);
				setState(91);
				match(T__4);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__18) | (1L << T__19) | (1L << ID))) != 0)) {
					{
					{
					setState(92);
					listMembro();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ListMembroContext extends ParserRuleContext {
		public ListMembroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listMembro; }
	 
		public ListMembroContext() { }
		public void copyFrom(ListMembroContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MembroConstrutorContext extends ListMembroContext {
		public ConstrutorContext construtor() {
			return getRuleContext(ConstrutorContext.class,0);
		}
		public MembroConstrutorContext(ListMembroContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitMembroConstrutor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MembroMetodoContext extends ListMembroContext {
		public MetodoContext metodo() {
			return getRuleContext(MetodoContext.class,0);
		}
		public MembroMetodoContext(ListMembroContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitMembroMetodo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MembroATributoContext extends ListMembroContext {
		public AtributoContext atributo() {
			return getRuleContext(AtributoContext.class,0);
		}
		public MembroATributoContext(ListMembroContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitMembroATributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListMembroContext listMembro() throws RecognitionException {
		ListMembroContext _localctx = new ListMembroContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_listMembro);
		try {
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new MembroConstrutorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				construtor();
				}
				break;
			case 2:
				_localctx = new MembroATributoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				atributo();
				}
				break;
			case 3:
				_localctx = new MembroMetodoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				metodo();
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

	public static class AtributoContext extends ParserRuleContext {
		public QualificadorContext qualificador() {
			return getRuleContext(QualificadorContext.class,0);
		}
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public AtributoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitAtributo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtributoContext atributo() throws RecognitionException {
		AtributoContext _localctx = new AtributoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atributo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			qualificador();
			setState(106);
			variavel();
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

	public static class VariavelContext extends ParserRuleContext {
		public VariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variavel; }
	 
		public VariavelContext() { }
		public void copyFrom(VariavelContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IniciaVariavelVaziaContext extends VariavelContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public IniciaVariavelVaziaContext(VariavelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitIniciaVariavelVazia(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IniciaVariavelComValorContext extends VariavelContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public IniciaVariavelComValorContext(VariavelContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitIniciaVariavelComValor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariavelContext variavel() throws RecognitionException {
		VariavelContext _localctx = new VariavelContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variavel);
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new IniciaVariavelVaziaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				tipo();
				setState(109);
				match(ID);
				setState(110);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new IniciaVariavelComValorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				tipo();
				setState(113);
				match(ID);
				setState(114);
				match(T__8);
				setState(115);
				expressao(0);
				setState(116);
				match(T__7);
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

	public static class ConstrutorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public Parametros_formaisContext parametros_formais() {
			return getRuleContext(Parametros_formaisContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ConstrutorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_construtor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitConstrutor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstrutorContext construtor() throws RecognitionException {
		ConstrutorContext _localctx = new ConstrutorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_construtor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(ID);
			setState(121);
			match(T__1);
			setState(122);
			parametros_formais();
			setState(123);
			match(T__2);
			setState(124);
			bloco();
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

	public static class MetodoContext extends ParserRuleContext {
		public QualificadorContext qualificador() {
			return getRuleContext(QualificadorContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public MetodoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metodo; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitMetodo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetodoContext metodo() throws RecognitionException {
		MetodoContext _localctx = new MetodoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_metodo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			qualificador();
			setState(127);
			func();
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

	public static class FuncContext extends ParserRuleContext {
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncaoComTipoContext extends FuncContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public Parametros_formaisContext parametros_formais() {
			return getRuleContext(Parametros_formaisContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public FuncaoComTipoContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitFuncaoComTipo(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncaoComVoidContext extends FuncContext {
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public Parametros_formaisContext parametros_formais() {
			return getRuleContext(Parametros_formaisContext.class,0);
		}
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public FuncaoComVoidContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitFuncaoComVoid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func);
		try {
			setState(143);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case ID:
				_localctx = new FuncaoComTipoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				tipo();
				setState(130);
				match(ID);
				setState(131);
				match(T__9);
				setState(132);
				parametros_formais();
				setState(133);
				match(T__10);
				setState(134);
				bloco();
				}
				break;
			case T__11:
				_localctx = new FuncaoComVoidContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(T__11);
				setState(137);
				match(ID);
				setState(138);
				match(T__9);
				setState(139);
				parametros_formais();
				setState(140);
				match(T__10);
				setState(141);
				bloco();
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

	public static class Parametros_formaisContext extends ParserRuleContext {
		public List<TipoContext> tipo() {
			return getRuleContexts(TipoContext.class);
		}
		public TipoContext tipo(int i) {
			return getRuleContext(TipoContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(QplplParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(QplplParser.ID, i);
		}
		public Parametros_formaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros_formais; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitParametros_formais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametros_formaisContext parametros_formais() throws RecognitionException {
		Parametros_formaisContext _localctx = new Parametros_formaisContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parametros_formais);
		int _la;
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				tipo();
				setState(146);
				match(ID);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(147);
					match(T__12);
					setState(148);
					tipo();
					setState(149);
					match(ID);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__2:
			case T__10:
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

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	 
		public TipoContext() { }
		public void copyFrom(TipoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeNamedContext extends TipoContext {
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public TypeNamedContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitTypeNamed(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeCharContext extends TipoContext {
		public TypeCharContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitTypeChar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeBoolContext extends TipoContext {
		public TypeBoolContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitTypeBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIntContext extends TipoContext {
		public TypeIntContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeStringContext extends TipoContext {
		public TypeStringContext(TipoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitTypeString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tipo);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				_localctx = new TypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				match(T__13);
				}
				break;
			case T__14:
				_localctx = new TypeCharContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(T__14);
				}
				break;
			case T__15:
				_localctx = new TypeBoolContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				match(T__15);
				}
				break;
			case T__16:
				_localctx = new TypeStringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(162);
				match(T__16);
				}
				break;
			case ID:
				_localctx = new TypeNamedContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(163);
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

	public static class NomeContext extends ParserRuleContext {
		public NomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nome; }
	 
		public NomeContext() { }
		public void copyFrom(NomeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NomeListFuncaoContext extends NomeContext {
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public Parametros_reaisContext parametros_reais() {
			return getRuleContext(Parametros_reaisContext.class,0);
		}
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public NomeListFuncaoContext(NomeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitNomeListFuncao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NomeListVariavelContext extends NomeContext {
		public TerminalNode ID() { return getToken(QplplParser.ID, 0); }
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public NomeListVariavelContext(NomeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitNomeListVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NomeContext nome() throws RecognitionException {
		NomeContext _localctx = new NomeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_nome);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new NomeListFuncaoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(ID);
				setState(167);
				match(T__9);
				setState(168);
				parametros_reais();
				setState(169);
				match(T__10);
				setState(172);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(170);
					match(T__17);
					setState(171);
					nome();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new NomeListVariavelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				match(ID);
				setState(177);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(175);
					match(T__17);
					setState(176);
					nome();
					}
					break;
				}
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

	public static class Parametros_reaisContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public Parametros_reaisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros_reais; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitParametros_reais(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parametros_reaisContext parametros_reais() throws RecognitionException {
		Parametros_reaisContext _localctx = new Parametros_reaisContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_parametros_reais);
		int _la;
		try {
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case INTL:
			case CHARL:
			case STRL:
			case BOOLL:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				expressao(0);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(182);
					match(T__12);
					setState(183);
					expressao(0);
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__10:
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

	public static class QualificadorContext extends ParserRuleContext {
		public QualificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualificador; }
	 
		public QualificadorContext() { }
		public void copyFrom(QualificadorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class QualifiVazioContext extends QualificadorContext {
		public QualifiVazioContext(QualificadorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitQualifiVazio(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QualifConstContext extends QualificadorContext {
		public QualifConstContext(QualificadorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitQualifConst(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class QualifStaticContext extends QualificadorContext {
		public QualifStaticContext(QualificadorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitQualifStatic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QualificadorContext qualificador() throws RecognitionException {
		QualificadorContext _localctx = new QualificadorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_qualificador);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				_localctx = new QualifConstContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(T__18);
				}
				break;
			case T__19:
				_localctx = new QualifStaticContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				match(T__19);
				}
				break;
			case T__11:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case ID:
				_localctx = new QualifiVazioContext(_localctx);
				enterOuterAlt(_localctx, 3);
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

	public static class ComandoContext extends ParserRuleContext {
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
	 
		public ComandoContext() { }
		public void copyFrom(ComandoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ComandoAtribuicaoContext extends ComandoContext {
		public AtribuicaoContext atribuicao() {
			return getRuleContext(AtribuicaoContext.class,0);
		}
		public ComandoAtribuicaoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComandoEntradaContext extends ComandoContext {
		public EntradaContext entrada() {
			return getRuleContext(EntradaContext.class,0);
		}
		public ComandoEntradaContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoEntrada(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComandoBlocoContext extends ComandoContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public ComandoBlocoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoBloco(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComandoBreakContext extends ComandoContext {
		public ComandoBreakContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComandoRepeticaoContext extends ComandoContext {
		public RepeticaoContext repeticao() {
			return getRuleContext(RepeticaoContext.class,0);
		}
		public ComandoRepeticaoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoRepeticao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComandoSaidaContext extends ComandoContext {
		public SaidaContext saida() {
			return getRuleContext(SaidaContext.class,0);
		}
		public ComandoSaidaContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoSaida(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComandoExpressaoContext extends ComandoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ComandoExpressaoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoExpressao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComandoSelecaoContext extends ComandoContext {
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public ComandoSelecaoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoSelecao(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComandoRetornoContext extends ComandoContext {
		public RetornoContext retorno() {
			return getRuleContext(RetornoContext.class,0);
		}
		public ComandoRetornoContext(ComandoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitComandoRetorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comando);
		try {
			setState(209);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new ComandoBlocoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				bloco();
				}
				break;
			case 2:
				_localctx = new ComandoSelecaoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				selecao();
				}
				break;
			case 3:
				_localctx = new ComandoRepeticaoContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				repeticao();
				}
				break;
			case 4:
				_localctx = new ComandoAtribuicaoContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(200);
				atribuicao();
				}
				break;
			case 5:
				_localctx = new ComandoRetornoContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				retorno();
				}
				break;
			case 6:
				_localctx = new ComandoEntradaContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(202);
				entrada();
				}
				break;
			case 7:
				_localctx = new ComandoSaidaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(203);
				saida();
				}
				break;
			case 8:
				_localctx = new ComandoExpressaoContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(204);
				expressao(0);
				setState(205);
				match(T__7);
				}
				break;
			case 9:
				_localctx = new ComandoBreakContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(207);
				match(T__20);
				setState(208);
				match(T__7);
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

	public static class BlocoContext extends ParserRuleContext {
		public List<VariavelContext> variavel() {
			return getRuleContexts(VariavelContext.class);
		}
		public VariavelContext variavel(int i) {
			return getRuleContext(VariavelContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitBloco(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_bloco);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__1);
			setState(215);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(212);
					variavel();
					}
					} 
				}
				setState(217);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << INTL) | (1L << CHARL) | (1L << STRL) | (1L << BOOLL) | (1L << ID))) != 0)) {
				{
				{
				setState(218);
				comando();
				}
				}
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224);
			match(T__2);
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

	public static class SelecaoContext extends ParserRuleContext {
		public SelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecao; }
	 
		public SelecaoContext() { }
		public void copyFrom(SelecaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SelectionIfContext extends SelecaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public SelectionIfContext(SelecaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitSelectionIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SelectionIfElseContext extends SelecaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public SelectionIfElseContext(SelecaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitSelectionIfElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecaoContext selecao() throws RecognitionException {
		SelecaoContext _localctx = new SelecaoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_selecao);
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new SelectionIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(T__21);
				setState(227);
				match(T__9);
				setState(228);
				expressao(0);
				setState(229);
				match(T__10);
				setState(230);
				comando();
				}
				break;
			case 2:
				_localctx = new SelectionIfElseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				match(T__21);
				setState(233);
				match(T__9);
				setState(234);
				expressao(0);
				setState(235);
				match(T__10);
				setState(236);
				comando();
				setState(237);
				match(T__22);
				setState(238);
				comando();
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

	public static class RepeticaoContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public RepeticaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeticao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitRepeticao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RepeticaoContext repeticao() throws RecognitionException {
		RepeticaoContext _localctx = new RepeticaoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_repeticao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(T__23);
			setState(243);
			match(T__9);
			setState(244);
			expressao(0);
			setState(245);
			match(T__10);
			setState(246);
			comando();
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

	public static class AtribuicaoContext extends ParserRuleContext {
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public AtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atribuicao; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribuicaoContext atribuicao() throws RecognitionException {
		AtribuicaoContext _localctx = new AtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_atribuicao);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			nome();
			setState(249);
			match(T__8);
			setState(250);
			expressao(0);
			setState(251);
			match(T__7);
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

	public static class RetornoContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public RetornoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retorno; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitRetorno(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetornoContext retorno() throws RecognitionException {
		RetornoContext _localctx = new RetornoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_retorno);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(T__24);
			setState(254);
			expressao(0);
			setState(255);
			match(T__7);
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

	public static class EntradaContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public EntradaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entrada; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitEntrada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntradaContext entrada() throws RecognitionException {
		EntradaContext _localctx = new EntradaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_entrada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__25);
			setState(260); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(258);
				match(T__26);
				setState(259);
				expressao(0);
				}
				}
				setState(262); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__26 );
			setState(264);
			match(T__7);
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

	public static class SaidaContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public SaidaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saida; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitSaida(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SaidaContext saida() throws RecognitionException {
		SaidaContext _localctx = new SaidaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_saida);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(T__27);
			setState(269); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(267);
				match(T__28);
				setState(268);
				expressao(0);
				}
				}
				setState(271); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__28 );
			setState(273);
			match(T__7);
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

	public static class ExpressaoContext extends ParserRuleContext {
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	 
		public ExpressaoContext() { }
		public void copyFrom(ExpressaoContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprParenContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExprParenContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprMultContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprUnariaMinusContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExprUnariaMinusContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprUnariaMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDecrementoEsqContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExprDecrementoEsqContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprDecrementoEsq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMenorContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprMenorContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprMenor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDecrementoDirContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExprDecrementoDirContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprDecrementoDir(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMaiorIgualContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprMaiorIgualContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprMaiorIgual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprNotContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExprNotContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSomaContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprSomaContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprSoma(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIncrementoEsqContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExprIncrementoEsqContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprIncrementoEsq(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDivContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprDivContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMaiorContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprMaiorContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprMaior(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprEContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprEContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMenorIgualContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprMenorIgualContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprMenorIgual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprOUContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprOUContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprOU(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprSubContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprSubContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprLiteralContext extends ExpressaoContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprLiteralContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIgualContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprIgualContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprIgual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprIncrementoDirContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExprIncrementoDirContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprIncrementoDir(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprVariavelContext extends ExpressaoContext {
		public NomeContext nome() {
			return getRuleContext(NomeContext.class,0);
		}
		public ExprVariavelContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprVariavel(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprUnariaPlusContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ExprUnariaPlusContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprUnariaPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprModContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprModContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDiferenteContext extends ExpressaoContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ExprDiferenteContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitExprDiferente(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		return expressao(0);
	}

	private ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expressao, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(276);
				match(T__9);
				setState(277);
				expressao(0);
				setState(278);
				match(T__10);
				}
				break;
			case T__29:
				{
				_localctx = new ExprUnariaPlusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280);
				match(T__29);
				setState(281);
				expressao(22);
				}
				break;
			case T__30:
				{
				_localctx = new ExprUnariaMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				match(T__30);
				setState(283);
				expressao(21);
				}
				break;
			case T__31:
				{
				_localctx = new ExprIncrementoEsqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
				match(T__31);
				setState(285);
				expressao(20);
				}
				break;
			case T__32:
				{
				_localctx = new ExprDecrementoEsqContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286);
				match(T__32);
				setState(287);
				expressao(19);
				}
				break;
			case T__33:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(T__33);
				setState(289);
				expressao(16);
				}
				break;
			case ID:
				{
				_localctx = new ExprVariavelContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				nome();
				}
				break;
			case INTL:
			case CHARL:
			case STRL:
			case BOOLL:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(339);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(337);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new ExprModContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(294);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(295);
						match(T__34);
						setState(296);
						expressao(16);
						}
						break;
					case 2:
						{
						_localctx = new ExprMultContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(297);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(298);
						match(T__35);
						setState(299);
						expressao(15);
						}
						break;
					case 3:
						{
						_localctx = new ExprDivContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(300);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(301);
						match(T__36);
						setState(302);
						expressao(14);
						}
						break;
					case 4:
						{
						_localctx = new ExprSomaContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(303);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(304);
						match(T__29);
						setState(305);
						expressao(13);
						}
						break;
					case 5:
						{
						_localctx = new ExprSubContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(306);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(307);
						match(T__30);
						setState(308);
						expressao(12);
						}
						break;
					case 6:
						{
						_localctx = new ExprMenorContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(309);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(310);
						match(T__37);
						setState(311);
						expressao(11);
						}
						break;
					case 7:
						{
						_localctx = new ExprMenorIgualContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(312);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(313);
						match(T__38);
						setState(314);
						expressao(10);
						}
						break;
					case 8:
						{
						_localctx = new ExprMaiorContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(315);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(316);
						match(T__39);
						setState(317);
						expressao(9);
						}
						break;
					case 9:
						{
						_localctx = new ExprMaiorIgualContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(318);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(319);
						match(T__40);
						setState(320);
						expressao(8);
						}
						break;
					case 10:
						{
						_localctx = new ExprIgualContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(321);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(322);
						match(T__41);
						setState(323);
						expressao(7);
						}
						break;
					case 11:
						{
						_localctx = new ExprDiferenteContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(324);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(325);
						match(T__42);
						setState(326);
						expressao(6);
						}
						break;
					case 12:
						{
						_localctx = new ExprEContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(327);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(328);
						match(T__43);
						setState(329);
						expressao(5);
						}
						break;
					case 13:
						{
						_localctx = new ExprOUContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(330);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(331);
						match(T__44);
						setState(332);
						expressao(4);
						}
						break;
					case 14:
						{
						_localctx = new ExprIncrementoDirContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(333);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(334);
						match(T__31);
						}
						break;
					case 15:
						{
						_localctx = new ExprDecrementoDirContext(new ExpressaoContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(335);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(336);
						match(T__32);
						}
						break;
					}
					} 
				}
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LiteralBoolContext extends LiteralContext {
		public TerminalNode BOOLL() { return getToken(QplplParser.BOOLL, 0); }
		public LiteralBoolContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitLiteralBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralStringContext extends LiteralContext {
		public TerminalNode STRL() { return getToken(QplplParser.STRL, 0); }
		public LiteralStringContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitLiteralString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralIntContext extends LiteralContext {
		public TerminalNode INTL() { return getToken(QplplParser.INTL, 0); }
		public LiteralIntContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitLiteralInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralCharContext extends LiteralContext {
		public TerminalNode CHARL() { return getToken(QplplParser.CHARL, 0); }
		public LiteralCharContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof QplplVisitor ) return ((QplplVisitor<? extends T>)visitor).visitLiteralChar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_literal);
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTL:
				_localctx = new LiteralIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				match(INTL);
				}
				break;
			case STRL:
				_localctx = new LiteralStringContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				match(STRL);
				}
				break;
			case CHARL:
				_localctx = new LiteralCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				match(CHARL);
				}
				break;
			case BOOLL:
				_localctx = new LiteralBoolContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(345);
				match(BOOLL);
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
		case 23:
			return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u015f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\3\2\3\3\3\3\3\3\5\3@\n\3"+
		"\3\4\3\4\3\4\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\3\5\3\5\3\5\7\5P\n\5"+
		"\f\5\16\5S\13\5\3\5\3\5\3\5\7\5X\n\5\f\5\16\5[\13\5\3\5\3\5\3\5\7\5`\n"+
		"\5\f\5\16\5c\13\5\5\5e\n\5\3\6\3\6\3\6\5\6j\n\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\by\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u0092\n\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009a\n\f\f\f\16\f\u009d"+
		"\13\f\3\f\5\f\u00a0\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u00a7\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\5\16\u00af\n\16\3\16\3\16\3\16\5\16\u00b4\n\16\5\16"+
		"\u00b6\n\16\3\17\3\17\3\17\7\17\u00bb\n\17\f\17\16\17\u00be\13\17\3\17"+
		"\5\17\u00c1\n\17\3\20\3\20\3\20\5\20\u00c6\n\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d4\n\21\3\22\3\22\7\22"+
		"\u00d8\n\22\f\22\16\22\u00db\13\22\3\22\7\22\u00de\n\22\f\22\16\22\u00e1"+
		"\13\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23\u00f3\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\6\27\u0107\n\27\r\27"+
		"\16\27\u0108\3\27\3\27\3\30\3\30\3\30\6\30\u0110\n\30\r\30\16\30\u0111"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\5\31\u0127\n\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0154\n\31\f\31\16"+
		"\31\u0157\13\31\3\32\3\32\3\32\3\32\5\32\u015d\n\32\3\32\2\3\60\33\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\2\2\u0185\2\67\3"+
		"\2\2\2\4?\3\2\2\2\6A\3\2\2\2\bd\3\2\2\2\ni\3\2\2\2\fk\3\2\2\2\16x\3\2"+
		"\2\2\20z\3\2\2\2\22\u0080\3\2\2\2\24\u0091\3\2\2\2\26\u009f\3\2\2\2\30"+
		"\u00a6\3\2\2\2\32\u00b5\3\2\2\2\34\u00c0\3\2\2\2\36\u00c5\3\2\2\2 \u00d3"+
		"\3\2\2\2\"\u00d5\3\2\2\2$\u00f2\3\2\2\2&\u00f4\3\2\2\2(\u00fa\3\2\2\2"+
		"*\u00ff\3\2\2\2,\u0103\3\2\2\2.\u010c\3\2\2\2\60\u0126\3\2\2\2\62\u015c"+
		"\3\2\2\2\64\66\5\4\3\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2"+
		"\2\28:\3\2\2\29\67\3\2\2\2:;\7\2\2\3;\3\3\2\2\2<@\5\24\13\2=@\5\6\4\2"+
		">@\5\16\b\2?<\3\2\2\2?=\3\2\2\2?>\3\2\2\2@\5\3\2\2\2AB\7\3\2\2BC\7\64"+
		"\2\2CG\7\4\2\2DF\5\b\5\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2"+
		"\2\2IG\3\2\2\2JK\7\5\2\2K\7\3\2\2\2LM\7\6\2\2MQ\7\7\2\2NP\5\n\6\2ON\3"+
		"\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2Re\3\2\2\2SQ\3\2\2\2TU\7\b\2\2UY\7"+
		"\7\2\2VX\5\n\6\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Ze\3\2\2\2[Y\3"+
		"\2\2\2\\]\7\t\2\2]a\7\7\2\2^`\5\n\6\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab"+
		"\3\2\2\2be\3\2\2\2ca\3\2\2\2dL\3\2\2\2dT\3\2\2\2d\\\3\2\2\2e\t\3\2\2\2"+
		"fj\5\20\t\2gj\5\f\7\2hj\5\22\n\2if\3\2\2\2ig\3\2\2\2ih\3\2\2\2j\13\3\2"+
		"\2\2kl\5\36\20\2lm\5\16\b\2m\r\3\2\2\2no\5\30\r\2op\7\64\2\2pq\7\n\2\2"+
		"qy\3\2\2\2rs\5\30\r\2st\7\64\2\2tu\7\13\2\2uv\5\60\31\2vw\7\n\2\2wy\3"+
		"\2\2\2xn\3\2\2\2xr\3\2\2\2y\17\3\2\2\2z{\7\64\2\2{|\7\4\2\2|}\5\26\f\2"+
		"}~\7\5\2\2~\177\5\"\22\2\177\21\3\2\2\2\u0080\u0081\5\36\20\2\u0081\u0082"+
		"\5\24\13\2\u0082\23\3\2\2\2\u0083\u0084\5\30\r\2\u0084\u0085\7\64\2\2"+
		"\u0085\u0086\7\f\2\2\u0086\u0087\5\26\f\2\u0087\u0088\7\r\2\2\u0088\u0089"+
		"\5\"\22\2\u0089\u0092\3\2\2\2\u008a\u008b\7\16\2\2\u008b\u008c\7\64\2"+
		"\2\u008c\u008d\7\f\2\2\u008d\u008e\5\26\f\2\u008e\u008f\7\r\2\2\u008f"+
		"\u0090\5\"\22\2\u0090\u0092\3\2\2\2\u0091\u0083\3\2\2\2\u0091\u008a\3"+
		"\2\2\2\u0092\25\3\2\2\2\u0093\u0094\5\30\r\2\u0094\u009b\7\64\2\2\u0095"+
		"\u0096\7\17\2\2\u0096\u0097\5\30\r\2\u0097\u0098\7\64\2\2\u0098\u009a"+
		"\3\2\2\2\u0099\u0095\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u00a0\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\3\2"+
		"\2\2\u009f\u0093\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\27\3\2\2\2\u00a1\u00a7"+
		"\7\20\2\2\u00a2\u00a7\7\21\2\2\u00a3\u00a7\7\22\2\2\u00a4\u00a7\7\23\2"+
		"\2\u00a5\u00a7\7\64\2\2\u00a6\u00a1\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6"+
		"\u00a3\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\31\3\2\2"+
		"\2\u00a8\u00a9\7\64\2\2\u00a9\u00aa\7\f\2\2\u00aa\u00ab\5\34\17\2\u00ab"+
		"\u00ae\7\r\2\2\u00ac\u00ad\7\24\2\2\u00ad\u00af\5\32\16\2\u00ae\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b6\3\2\2\2\u00b0\u00b3\7\64\2\2"+
		"\u00b1\u00b2\7\24\2\2\u00b2\u00b4\5\32\16\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00a8\3\2\2\2\u00b5\u00b0\3\2"+
		"\2\2\u00b6\33\3\2\2\2\u00b7\u00bc\5\60\31\2\u00b8\u00b9\7\17\2\2\u00b9"+
		"\u00bb\5\60\31\2\u00ba\u00b8\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3"+
		"\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c1\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c1\3\2\2\2\u00c0\u00b7\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\35\3\2\2"+
		"\2\u00c2\u00c6\7\25\2\2\u00c3\u00c6\7\26\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00c2\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\37\3\2\2"+
		"\2\u00c7\u00d4\5\"\22\2\u00c8\u00d4\5$\23\2\u00c9\u00d4\5&\24\2\u00ca"+
		"\u00d4\5(\25\2\u00cb\u00d4\5*\26\2\u00cc\u00d4\5,\27\2\u00cd\u00d4\5."+
		"\30\2\u00ce\u00cf\5\60\31\2\u00cf\u00d0\7\n\2\2\u00d0\u00d4\3\2\2\2\u00d1"+
		"\u00d2\7\27\2\2\u00d2\u00d4\7\n\2\2\u00d3\u00c7\3\2\2\2\u00d3\u00c8\3"+
		"\2\2\2\u00d3\u00c9\3\2\2\2\u00d3\u00ca\3\2\2\2\u00d3\u00cb\3\2\2\2\u00d3"+
		"\u00cc\3\2\2\2\u00d3\u00cd\3\2\2\2\u00d3\u00ce\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d4!\3\2\2\2\u00d5\u00d9\7\4\2\2\u00d6\u00d8\5\16\b\2\u00d7\u00d6"+
		"\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00df\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\5 \21\2\u00dd\u00dc\3\2"+
		"\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e3\7\5\2\2\u00e3#\3\2\2\2"+
		"\u00e4\u00e5\7\30\2\2\u00e5\u00e6\7\f\2\2\u00e6\u00e7\5\60\31\2\u00e7"+
		"\u00e8\7\r\2\2\u00e8\u00e9\5 \21\2\u00e9\u00f3\3\2\2\2\u00ea\u00eb\7\30"+
		"\2\2\u00eb\u00ec\7\f\2\2\u00ec\u00ed\5\60\31\2\u00ed\u00ee\7\r\2\2\u00ee"+
		"\u00ef\5 \21\2\u00ef\u00f0\7\31\2\2\u00f0\u00f1\5 \21\2\u00f1\u00f3\3"+
		"\2\2\2\u00f2\u00e4\3\2\2\2\u00f2\u00ea\3\2\2\2\u00f3%\3\2\2\2\u00f4\u00f5"+
		"\7\32\2\2\u00f5\u00f6\7\f\2\2\u00f6\u00f7\5\60\31\2\u00f7\u00f8\7\r\2"+
		"\2\u00f8\u00f9\5 \21\2\u00f9\'\3\2\2\2\u00fa\u00fb\5\32\16\2\u00fb\u00fc"+
		"\7\13\2\2\u00fc\u00fd\5\60\31\2\u00fd\u00fe\7\n\2\2\u00fe)\3\2\2\2\u00ff"+
		"\u0100\7\33\2\2\u0100\u0101\5\60\31\2\u0101\u0102\7\n\2\2\u0102+\3\2\2"+
		"\2\u0103\u0106\7\34\2\2\u0104\u0105\7\35\2\2\u0105\u0107\5\60\31\2\u0106"+
		"\u0104\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\u010b\7\n\2\2\u010b-\3\2\2\2\u010c\u010f"+
		"\7\36\2\2\u010d\u010e\7\37\2\2\u010e\u0110\5\60\31\2\u010f\u010d\3\2\2"+
		"\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113"+
		"\3\2\2\2\u0113\u0114\7\n\2\2\u0114/\3\2\2\2\u0115\u0116\b\31\1\2\u0116"+
		"\u0117\7\f\2\2\u0117\u0118\5\60\31\2\u0118\u0119\7\r\2\2\u0119\u0127\3"+
		"\2\2\2\u011a\u011b\7 \2\2\u011b\u0127\5\60\31\30\u011c\u011d\7!\2\2\u011d"+
		"\u0127\5\60\31\27\u011e\u011f\7\"\2\2\u011f\u0127\5\60\31\26\u0120\u0121"+
		"\7#\2\2\u0121\u0127\5\60\31\25\u0122\u0123\7$\2\2\u0123\u0127\5\60\31"+
		"\22\u0124\u0127\5\32\16\2\u0125\u0127\5\62\32\2\u0126\u0115\3\2\2\2\u0126"+
		"\u011a\3\2\2\2\u0126\u011c\3\2\2\2\u0126\u011e\3\2\2\2\u0126\u0120\3\2"+
		"\2\2\u0126\u0122\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0125\3\2\2\2\u0127"+
		"\u0155\3\2\2\2\u0128\u0129\f\21\2\2\u0129\u012a\7%\2\2\u012a\u0154\5\60"+
		"\31\22\u012b\u012c\f\20\2\2\u012c\u012d\7&\2\2\u012d\u0154\5\60\31\21"+
		"\u012e\u012f\f\17\2\2\u012f\u0130\7\'\2\2\u0130\u0154\5\60\31\20\u0131"+
		"\u0132\f\16\2\2\u0132\u0133\7 \2\2\u0133\u0154\5\60\31\17\u0134\u0135"+
		"\f\r\2\2\u0135\u0136\7!\2\2\u0136\u0154\5\60\31\16\u0137\u0138\f\f\2\2"+
		"\u0138\u0139\7(\2\2\u0139\u0154\5\60\31\r\u013a\u013b\f\13\2\2\u013b\u013c"+
		"\7)\2\2\u013c\u0154\5\60\31\f\u013d\u013e\f\n\2\2\u013e\u013f\7*\2\2\u013f"+
		"\u0154\5\60\31\13\u0140\u0141\f\t\2\2\u0141\u0142\7+\2\2\u0142\u0154\5"+
		"\60\31\n\u0143\u0144\f\b\2\2\u0144\u0145\7,\2\2\u0145\u0154\5\60\31\t"+
		"\u0146\u0147\f\7\2\2\u0147\u0148\7-\2\2\u0148\u0154\5\60\31\b\u0149\u014a"+
		"\f\6\2\2\u014a\u014b\7.\2\2\u014b\u0154\5\60\31\7\u014c\u014d\f\5\2\2"+
		"\u014d\u014e\7/\2\2\u014e\u0154\5\60\31\6\u014f\u0150\f\24\2\2\u0150\u0154"+
		"\7\"\2\2\u0151\u0152\f\23\2\2\u0152\u0154\7#\2\2\u0153\u0128\3\2\2\2\u0153"+
		"\u012b\3\2\2\2\u0153\u012e\3\2\2\2\u0153\u0131\3\2\2\2\u0153\u0134\3\2"+
		"\2\2\u0153\u0137\3\2\2\2\u0153\u013a\3\2\2\2\u0153\u013d\3\2\2\2\u0153"+
		"\u0140\3\2\2\2\u0153\u0143\3\2\2\2\u0153\u0146\3\2\2\2\u0153\u0149\3\2"+
		"\2\2\u0153\u014c\3\2\2\2\u0153\u014f\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\61\3\2\2"+
		"\2\u0157\u0155\3\2\2\2\u0158\u015d\7\60\2\2\u0159\u015d\7\62\2\2\u015a"+
		"\u015d\7\61\2\2\u015b\u015d\7\63\2\2\u015c\u0158\3\2\2\2\u015c\u0159\3"+
		"\2\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015d\63\3\2\2\2\37\67"+
		"?GQYadix\u0091\u009b\u009f\u00a6\u00ae\u00b3\u00b5\u00bc\u00c0\u00c5\u00d3"+
		"\u00d9\u00df\u00f2\u0108\u0111\u0126\u0153\u0155\u015c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}