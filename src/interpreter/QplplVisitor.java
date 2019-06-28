// Generated from /home/diogo/Downloads/QPP1-master/src/interpreter/Qplpl.g4 by ANTLR 4.7.2
package interpreter;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QplplParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QplplVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QplplParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(QplplParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinicaoFuncao}
	 * labeled alternative in {@link QplplParser#definicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicaoFuncao(QplplParser.DefinicaoFuncaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinicaoEstrutura}
	 * labeled alternative in {@link QplplParser#definicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicaoEstrutura(QplplParser.DefinicaoEstruturaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinicaoVariavel}
	 * labeled alternative in {@link QplplParser#definicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicaoVariavel(QplplParser.DefinicaoVariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#estrutura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstrutura(QplplParser.EstruturaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EstrutPublic}
	 * labeled alternative in {@link QplplParser#estruturaAcesso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstrutPublic(QplplParser.EstrutPublicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EstrutPrivate}
	 * labeled alternative in {@link QplplParser#estruturaAcesso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstrutPrivate(QplplParser.EstrutPrivateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EstrutProtected}
	 * labeled alternative in {@link QplplParser#estruturaAcesso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstrutProtected(QplplParser.EstrutProtectedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MembroConstrutor}
	 * labeled alternative in {@link QplplParser#listMembro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMembroConstrutor(QplplParser.MembroConstrutorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MembroATributo}
	 * labeled alternative in {@link QplplParser#listMembro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMembroATributo(QplplParser.MembroATributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MembroMetodo}
	 * labeled alternative in {@link QplplParser#listMembro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMembroMetodo(QplplParser.MembroMetodoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributo(QplplParser.AtributoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IniciaVariavelVazia}
	 * labeled alternative in {@link QplplParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIniciaVariavelVazia(QplplParser.IniciaVariavelVaziaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IniciaVariavelComValor}
	 * labeled alternative in {@link QplplParser#variavel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIniciaVariavelComValor(QplplParser.IniciaVariavelComValorContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#construtor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstrutor(QplplParser.ConstrutorContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#metodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetodo(QplplParser.MetodoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncaoComTipo}
	 * labeled alternative in {@link QplplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncaoComTipo(QplplParser.FuncaoComTipoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncaoComVoid}
	 * labeled alternative in {@link QplplParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncaoComVoid(QplplParser.FuncaoComVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#parametros_formais}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros_formais(QplplParser.Parametros_formaisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link QplplParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(QplplParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeChar}
	 * labeled alternative in {@link QplplParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeChar(QplplParser.TypeCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeBool}
	 * labeled alternative in {@link QplplParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(QplplParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link QplplParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeString(QplplParser.TypeStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeNamed}
	 * labeled alternative in {@link QplplParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNamed(QplplParser.TypeNamedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NomeListFuncao}
	 * labeled alternative in {@link QplplParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomeListFuncao(QplplParser.NomeListFuncaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NomeListVariavel}
	 * labeled alternative in {@link QplplParser#nome}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNomeListVariavel(QplplParser.NomeListVariavelContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#parametros_reais}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros_reais(QplplParser.Parametros_reaisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QualifConst}
	 * labeled alternative in {@link QplplParser#qualificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifConst(QplplParser.QualifConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QualifStatic}
	 * labeled alternative in {@link QplplParser#qualificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifStatic(QplplParser.QualifStaticContext ctx);
	/**
	 * Visit a parse tree produced by the {@code QualifiVazio}
	 * labeled alternative in {@link QplplParser#qualificador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiVazio(QplplParser.QualifiVazioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoBloco}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoBloco(QplplParser.ComandoBlocoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoSelecao}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoSelecao(QplplParser.ComandoSelecaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoRepeticao}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoRepeticao(QplplParser.ComandoRepeticaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoAtribuicao}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoAtribuicao(QplplParser.ComandoAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoRetorno}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoRetorno(QplplParser.ComandoRetornoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoEntrada}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoEntrada(QplplParser.ComandoEntradaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoSaida}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoSaida(QplplParser.ComandoSaidaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoExpressao}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoExpressao(QplplParser.ComandoExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComandoBreak}
	 * labeled alternative in {@link QplplParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoBreak(QplplParser.ComandoBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(QplplParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectionIf}
	 * labeled alternative in {@link QplplParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionIf(QplplParser.SelectionIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SelectionIfElse}
	 * labeled alternative in {@link QplplParser#selecao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionIfElse(QplplParser.SelectionIfElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#repeticao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepeticao(QplplParser.RepeticaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#atribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtribuicao(QplplParser.AtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#retorno}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetorno(QplplParser.RetornoContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#entrada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntrada(QplplParser.EntradaContext ctx);
	/**
	 * Visit a parse tree produced by {@link QplplParser#saida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSaida(QplplParser.SaidaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParen}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParen(QplplParser.ExprParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMult}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMult(QplplParser.ExprMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnariaMinus}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnariaMinus(QplplParser.ExprUnariaMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDecrementoEsq}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDecrementoEsq(QplplParser.ExprDecrementoEsqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMenor}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMenor(QplplParser.ExprMenorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDecrementoDir}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDecrementoDir(QplplParser.ExprDecrementoDirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMaiorIgual}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMaiorIgual(QplplParser.ExprMaiorIgualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNot(QplplParser.ExprNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSoma}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSoma(QplplParser.ExprSomaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIncrementoEsq}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIncrementoEsq(QplplParser.ExprIncrementoEsqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDiv}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDiv(QplplParser.ExprDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMaior}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMaior(QplplParser.ExprMaiorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprE}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprE(QplplParser.ExprEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMenorIgual}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMenorIgual(QplplParser.ExprMenorIgualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOU}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOU(QplplParser.ExprOUContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSub}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSub(QplplParser.ExprSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLiteral}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(QplplParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIgual}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgual(QplplParser.ExprIgualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIncrementoDir}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIncrementoDir(QplplParser.ExprIncrementoDirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVariavel}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVariavel(QplplParser.ExprVariavelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprUnariaPlus}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprUnariaPlus(QplplParser.ExprUnariaPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMod}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMod(QplplParser.ExprModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDiferente}
	 * labeled alternative in {@link QplplParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDiferente(QplplParser.ExprDiferenteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralInt}
	 * labeled alternative in {@link QplplParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralInt(QplplParser.LiteralIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralString}
	 * labeled alternative in {@link QplplParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralString(QplplParser.LiteralStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralChar}
	 * labeled alternative in {@link QplplParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralChar(QplplParser.LiteralCharContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralBool}
	 * labeled alternative in {@link QplplParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralBool(QplplParser.LiteralBoolContext ctx);
}