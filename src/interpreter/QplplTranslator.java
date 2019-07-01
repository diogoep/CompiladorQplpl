package interpreter;


import ast.*;


import java.util.ArrayList;

public class QplplTranslator extends QplplBaseVisitor<TreeNode> {
    //////////////////////////////programa///////////////////////////////////
    @Override
    public Codigo visitPrograma(QplplParser.ProgramaContext ctx) {
        if(ctx.definicao().size() == 0) return new Codigo();
        ArrayList<Declaracao> definicoes = new ArrayList<>();
        for (QplplParser.DefinicaoContext def : ctx.definicao()){
            definicoes.add((Declaracao)visit(def));
        }
        return new Codigo(definicoes);
    }
////////////////////////////////Declaracao//////////////////////////////////////


    @Override
    public DeclaracaoFuncao visitDefinicaoFuncao(QplplParser.DefinicaoFuncaoContext ctx) {
        return (DeclaracaoFuncao) visit(ctx.func());
    }


    @Override
    public DeclaracaoVariavel visitDefinicaoVariavel(QplplParser.DefinicaoVariavelContext ctx) {
        return (DeclaracaoVariavel) visit(ctx.variavel());
    }

    @Override
    public DeclaracaoEstrutura visitDefinicaoEstrutura(QplplParser.DefinicaoEstruturaContext ctx) {
        return (DeclaracaoEstrutura) visit(ctx.estrutura());
    }   //struct



    ///////////////////////////variavel/////////////////////////////////////
    @Override
    public DeclaracaoVariavel visitIniciaVariavelVazia(QplplParser.IniciaVariavelVaziaContext ctx) {
        return new DeclaracaoVariavel((Tipo) visit(ctx.tipo()), ctx.ID().getText(), ctx.getStart().getLine());
    }

    @Override public DeclaracaoVariavel visitIniciaVariavelComValor(QplplParser.IniciaVariavelComValorContext ctx) {
        return new DeclaracaoVariavel((Tipo) visit(ctx.tipo()), ctx.ID().getText(), (Expressao) visit(ctx.expressao()), ctx.getStart().getLine());
    }




//////////////////////////////////////////////estrutura/////////////////////////////////////////////////////////


    @Override
    public DeclaracaoEstrutura visitEstrutura(QplplParser.EstruturaContext ctx) {

        String id = ctx.ID().getText();
        ArrayList<DeclaracaoEstrutura> acessos = new ArrayList<>();

        for(QplplParser.EstruturaAcessoContext i : ctx.estruturaAcesso()) {
            acessos.add((DeclaracaoEstrutura) visit(i));
        }

        return new DeclaracaoEstrutura(id, acessos, ctx.getStart().getLine());
    }


    @Override
    public EstrutAcesso visitEstrutPublic(QplplParser.EstrutPublicContext ctx) {
        ArrayList<Declaracao> acesso = new ArrayList<>();

        for(QplplParser.ListMembroContext i : ctx.listMembro()) {
            acesso.add((Declaracao) visit(i));
        }
        return new EstrutAcesso(TipoAcesso.PUBLIC, acesso, ctx.getStart().getLine());
    }


    @Override
    public EstrutAcesso visitEstrutPrivate(QplplParser.EstrutPrivateContext ctx) {
        ArrayList<Declaracao> acesso = new ArrayList<>();

        for(QplplParser.ListMembroContext m : ctx.listMembro()) {
            acesso.add((Declaracao) visit(m));
        }
        return new EstrutAcesso(TipoAcesso.PRIVATE, acesso, ctx.getStart().getLine());
    }
    @Override
    public EstrutAcesso visitEstrutProtected(QplplParser.EstrutProtectedContext ctx) {
        ArrayList<Declaracao> acesso = new ArrayList<>();

        for(QplplParser.ListMembroContext m : ctx.listMembro()){
            acesso.add((Declaracao) visit(m));
        }

        return new EstrutAcesso(TipoAcesso.PROTECTED, acesso, ctx.getStart().getLine());
    }


    ////////////////////////////////////////////////////////mebro/////////////////////////////////////////////////////////
    @Override
    public Declaracao visitMembroConstrutor(QplplParser.MembroConstrutorContext ctx) {


        return (Declaracao) visit(ctx.construtor());
    }


    @Override
    public DeclaracaoAtributo visitMembroATributo(QplplParser.MembroATributoContext ctx){
        return (DeclaracaoAtributo) visit(ctx.atributo());
    }

    @Override
    public DeclaracaoMetodo visitMembroMetodo(QplplParser.MembroMetodoContext ctx)  {

        return (DeclaracaoMetodo) visit(ctx.metodo());
    }


    //////////////////////////////////////////////////////////atributo////////////////////////////////////////////////////////////


    @Override
    public DeclaracaoAtributo visitAtributo(QplplParser.AtributoContext ctx) {
        Qualificador q = (Qualificador) visit(ctx.qualificador());
        DeclaracaoVariavel v = (DeclaracaoVariavel) visit(ctx.variavel());
        return new DeclaracaoAtributo(q,v);
    }
////////////////////////////////////////////////Construtor////////////////////////////////////////////////////

    @Override
    public DeclaracaoFuncao visitConstrutor(QplplParser.ConstrutorContext ctx)  {
        String id = ctx.ID().getText();
        ParametroFormal pf = (ParametroFormal) visit(ctx.parametros_formais());
        Bloco bl = (Bloco) visit(ctx.bloco());
        Tipo ti = new Tipo(TipoValor.CONSTRUTOR, id);
        return new DeclaracaoFuncao(ti,id,pf,bl, ctx.getStart().getLine());
    }
    //////////////////////////////////////Construtor///////////////////////////////////////

    @Override
    public DeclaracaoMetodo visitMetodo(QplplParser.MetodoContext ctx){
        Qualificador q = (Qualificador) visit(ctx.qualificador());
        DeclaracaoFuncao f = (DeclaracaoFuncao) visit(ctx.func());
        return new DeclaracaoMetodo(q,f);
    }


    /////////////////////// EXPRESSOES PARA VARIAVEIS E LITERAIS ///////////////////////

    @Override
    public Expressao visitExprVariavel(QplplParser.ExprVariavelContext ctx) {
        return new ExpressaoNomeada((Identificador) visit(ctx.nome()), ctx.getStart().getLine());
    }

    @Override
    public Expressao visitExprLiteral(QplplParser.ExprLiteralContext ctx) { return (Expressao) visit(ctx.literal());
    }


    @Override public Expressao visitLiteralInt(QplplParser.LiteralIntContext ctx) {
        return new LiteralInteiro(ctx.INTL().getText(), ctx.getStart().getLine());
    }
    @Override public Expressao visitLiteralString(QplplParser.LiteralStringContext ctx) {
        return new LiteralString(ctx.STRL().getText(), ctx.getStart().getLine());
    }
    @Override public Expressao visitLiteralBool(QplplParser.LiteralBoolContext ctx) {
        return new LiteralBool(ctx.BOOLL().getText(), ctx.getStart().getLine());
    }

    @Override public Expressao visitLiteralChar(QplplParser.LiteralCharContext ctx) {
        return new LiteralChar(ctx.CHARL().getText(), ctx.getStart().getLine());
    }


    /////////////////////// EXPRESSOES BINARIAS ///////////////////////

    @Override
    public Expressao visitExprSoma(QplplParser.ExprSomaContext ctx) {
        // pega a linha do token
        //int linha = ctx.getStart().getLine();
        //System.out.println("tem uma soma na linha " + linha);
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.SOMA,
                        (Expressao) visit(ctx.expressao(1)),
                        ctx.getStart().getLine()
                );
    }


    @Override
    public Expressao visitExprSub(QplplParser.ExprSubContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.SUBTRACAO,
                        (Expressao) visit(ctx.expressao(1))
                        , ctx.getStart().getLine()
                );
    }


    @Override
    public Expressao visitExprMult(QplplParser.ExprMultContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.MULTIPLICACAO,
                        (Expressao) visit(ctx.expressao(1))
                        , ctx.getStart().getLine()
                );
    }


    @Override
    public Expressao visitExprE(QplplParser.ExprEContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.AND,
                        (Expressao) visit(ctx.expressao(1))
                        , ctx.getStart().getLine()
                );
    }


    @Override
    public Expressao visitExprMod(QplplParser.ExprModContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.MOD,
                        (Expressao) visit(ctx.expressao(1)),
                        ctx.getStart().getLine()
                );
    }

    @Override public Expressao visitExprDiv(QplplParser.ExprDivContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.DIVISAO,
                        (Expressao) visit(ctx.expressao(1))
                        , ctx.getStart().getLine()
                );
    }

    @Override
    public Expressao visitExprIgual(QplplParser.ExprIgualContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.IGUAL,
                        (Expressao) visit(ctx.expressao(1)), ctx.getStart().getLine()
                );
    }

    @Override public Expressao visitExprOU(QplplParser.ExprOUContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.OR,
                        (Expressao) visit(ctx.expressao(1)), ctx.getStart().getLine()
                );
    }


    @Override public Expressao visitExprDiferente(QplplParser.ExprDiferenteContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.DIFERENTE,
                        (Expressao) visit(ctx.expressao(1)), ctx.getStart().getLine()
                );
    }

    @Override public Expressao visitExprMenor(QplplParser.ExprMenorContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.MENOR,
                        (Expressao) visit(ctx.expressao(1)), ctx.getStart().getLine()
                );
    }

    @Override public Expressao visitExprMenorIgual(QplplParser.ExprMenorIgualContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.MENORIGUAL,
                        (Expressao) visit(ctx.expressao(1)), ctx.getStart().getLine()
                );
    }

    @Override public Expressao visitExprMaior(QplplParser.ExprMaiorContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.MAIOR,
                        (Expressao) visit(ctx.expressao(1)), ctx.getStart().getLine()
                );
    }

    @Override public Expressao visitExprMaiorIgual(QplplParser.ExprMaiorIgualContext ctx) {
        return new ExpressaoBinaria
                (
                        (Expressao) visit(ctx.expressao(0)),
                        OperadorBinario.MAIORIGUAL,
                        (Expressao) visit(ctx.expressao(1)), ctx.getStart().getLine()
                );
    }


    ////////////////  EXPRESSOES  UNARIAS  ///////////////////////


    @Override public Expressao visitExprIncrementoEsq(QplplParser.ExprIncrementoEsqContext ctx){
        return new ExpressaoUnaria(OperadorUnario.INCREMENTOESQUERDA, (Expressao) visit(ctx.expressao()), ctx.getStart().getLine());
    }
    @Override public Expressao visitExprDecrementoEsq(QplplParser.ExprDecrementoEsqContext ctx) {
        return new ExpressaoUnaria(OperadorUnario.DECRESCIMOESQUERDA, (Expressao) visit(ctx.expressao()), ctx.getStart().getLine());
    }


    @Override public Expressao visitExprIncrementoDir(QplplParser.ExprIncrementoDirContext ctx){
        return new ExpressaoUnaria(OperadorUnario.INCREMENTODIREITA, (Expressao) visit(ctx.expressao()), ctx.getStart().getLine());
    }
    @Override public Expressao visitExprDecrementoDir(QplplParser.ExprDecrementoDirContext ctx) {
        return new ExpressaoUnaria(OperadorUnario.DECRESCIMODIREITA, (Expressao) visit(ctx.expressao()), ctx.getStart().getLine());
    }

    @Override
    public Expressao visitExprNot(QplplParser.ExprNotContext ctx) {
        return new ExpressaoUnaria(OperadorUnario.NOT, (Expressao) visit(ctx.expressao()), ctx.getStart().getLine());
    }

    @Override
    public Expressao visitExprUnariaPlus(QplplParser.ExprUnariaPlusContext ctx) {
        return new ExpressaoUnaria(OperadorUnario.MAIS, (Expressao) visit(ctx.expressao()), ctx.getStart().getLine());
    }

    @Override
    public Expressao visitExprUnariaMinus(QplplParser.ExprUnariaMinusContext ctx) {
        return new ExpressaoUnaria(OperadorUnario.MENOS, (Expressao) visit(ctx.expressao()), ctx.getStart().getLine());
    }


    @Override
    public Expressao visitExprParen(QplplParser.ExprParenContext ctx) {
        return  (Expressao) visit(ctx.expressao());
    }



    //////////////   NOME E CHAMADA DE FUNCOES/METODOS  ///////////////////



    @Override public Identificador visitNomeListVariavel(QplplParser.NomeListVariavelContext ctx) {
        if(ctx.nome() == null) return new ChamadaVariavel(ctx.ID().getText(), ctx.getStart().getLine());

        return new ChamadaVariavel(ctx.ID().getText(), (Identificador) visit(ctx.nome()), ctx.getStart().getLine());
    }

    @Override public Identificador visitNomeListFuncao(QplplParser.NomeListFuncaoContext ctx) {
        if(ctx.nome() == null)
            return new ChamadaFuncao(ctx.ID().getText(), (ParametroReal) visit(ctx.parametros_reais()), ctx.getStart().getLine());

        return new ChamadaFuncao(ctx.ID().getText(),
                (ParametroReal) visit(ctx.parametros_reais()),
                (Identificador) visit(ctx.nome()), ctx.getStart().getLine());
    }


    @Override public ParametroReal visitParametros_reais(QplplParser.Parametros_reaisContext ctx) {
        ArrayList<Expressao> parameters = new ArrayList<>();
        for (QplplParser.ExpressaoContext p : ctx.expressao()) {
            parameters.add((Expressao) visit(p));
        }
        return new ParametroReal(parameters);
    }



    @Override public Comando visitSelectionIf(QplplParser.SelectionIfContext ctx) {
        return new Condicional((Expressao) visit(ctx.expressao()), (Comando) visit(ctx.comando()), ctx.getStart().getLine());
    }


    @Override public Comando visitSelectionIfElse(QplplParser.SelectionIfElseContext ctx) {
        Comando cmdElse = (Comando) visit(ctx.comando(1));
        return new Condicional((Expressao) visit(ctx.expressao()),
                (Comando) visit(ctx.comando(0)),
                cmdElse, ctx.getStart().getLine()
        );
    }


    @Override public Comando visitRepeticao(QplplParser.RepeticaoContext ctx) {
        return new ComandoRepeticao((Expressao) visit(ctx.expressao()), (Comando) visit(ctx.comando()), ctx.getStart().getLine());
    }


    @Override public Comando visitAtribuicao(QplplParser.AtribuicaoContext ctx) {
        return new Atribuicao((Identificador) visit(ctx.nome()), (Expressao)visit(ctx.expressao()), ctx.getStart().getLine());
    }


    @Override public Comando visitRetorno(QplplParser.RetornoContext ctx) {
        return new Retorno((Expressao)visit(ctx.expressao()), ctx.getStart().getLine());
    }


    @Override public Comando visitEntrada(QplplParser.EntradaContext ctx) {
        ArrayList<Expressao> parameters = new ArrayList<>();
        for (QplplParser.ExpressaoContext p : ctx.expressao()) {
            parameters.add((Expressao) visit(p));
        }
        return new Entrada(parameters, ctx.getStart().getLine());
    }

    @Override public Comando visitSaida(QplplParser.SaidaContext ctx) {
        ArrayList<Expressao> parameters = new ArrayList<>();
        for (QplplParser.ExpressaoContext p : ctx.expressao()) {
            parameters.add((Expressao) visit(p));
        }
        return new Saida(parameters, ctx.getStart().getLine());
    }

    @Override public Comando visitBloco(QplplParser.BlocoContext ctx) {
        ArrayList<DeclaracaoVariavel> declaracoes = new ArrayList<>();
        for (QplplParser.VariavelContext v : ctx.variavel()) {
            declaracoes.add((DeclaracaoVariavel) visit(v));
        }

        ArrayList<Comando> comandos = new ArrayList<>();
        for (QplplParser.ComandoContext c : ctx.comando()) {
            comandos.add((Comando) visit(c));
        }

        return new Bloco(declaracoes, comandos);
    }

    @Override public Comando visitComandoBloco(QplplParser.ComandoBlocoContext ctx) { return (Comando) visit(ctx.bloco()); }
    @Override public Comando visitComandoSelecao(QplplParser.ComandoSelecaoContext ctx) { return (Comando) visit(ctx.selecao()); }
    @Override public Comando visitComandoRepeticao(QplplParser.ComandoRepeticaoContext ctx) { return (Comando) visit(ctx.repeticao()); }
    @Override public Comando visitComandoAtribuicao(QplplParser.ComandoAtribuicaoContext ctx) { return (Comando) visit(ctx.atribuicao()); }
    @Override public Comando visitComandoRetorno(QplplParser.ComandoRetornoContext ctx) { return (Comando) visit(ctx.retorno()); }
    @Override public Comando visitComandoEntrada(QplplParser.ComandoEntradaContext ctx) { return (Comando) visit(ctx.entrada()); }
    @Override public Comando visitComandoSaida(QplplParser.ComandoSaidaContext ctx) { return (Comando) visit(ctx.saida()); }
    @Override public Comando visitComandoBreak(QplplParser.ComandoBreakContext ctx) { return new Break(ctx.getStart().getLine()); }
    @Override public Comando visitComandoExpressao(QplplParser.ComandoExpressaoContext ctx)
    { return new ComandoExpressao((Expressao) visit(ctx.expressao()), ctx.getStart().getLine()); }



    //cabecalhos
    @Override public DeclaracaoFuncao visitFuncaoComTipo(QplplParser.FuncaoComTipoContext ctx) {
        Tipo ti = (Tipo) visit(ctx.tipo());
        String id = ctx.ID().getText();
        ParametroFormal pf = (ParametroFormal) visit(ctx.parametros_formais());
        Bloco bl = (Bloco) visit(ctx.bloco());
        return new DeclaracaoFuncao(ti, id, pf, bl, ctx.getStart().getLine());
    }

    @Override public DeclaracaoFuncao visitFuncaoComVoid(QplplParser.FuncaoComVoidContext ctx) {
        Tipo ti = new Tipo(TipoValor.VOID);
        String id = ctx.ID().getText();
        ParametroFormal pf = (ParametroFormal) visit(ctx.parametros_formais());
        Bloco bl = (Bloco) visit(ctx.bloco());
        return new DeclaracaoFuncao(ti, id, pf, bl, ctx.getStart().getLine());
    }
    //fim cabecalhos


    @Override public ParametroFormal visitParametros_formais(QplplParser.Parametros_formaisContext ctx) {
        ArrayList<DeclaracaoVariavel> parametrosf = new ArrayList<>();

        for( int i = 0; i < ctx.ID().size(); i++ ){
            parametrosf.add( new DeclaracaoVariavel((Tipo) visit(ctx.tipo(i)), ctx.ID(i).getText(), ctx.getStart().getLine()));
        }
        return new ParametroFormal(parametrosf);
    }







    @Override public Tipo visitTypeInt(QplplParser.TypeIntContext ctx) { return new Tipo(TipoValor.INTEIRO); }
    @Override public Tipo visitTypeChar(QplplParser.TypeCharContext ctx) { return new Tipo(TipoValor.CHAR); }
    @Override public Tipo visitTypeBool(QplplParser.TypeBoolContext ctx) { return new Tipo(TipoValor.BOOL); }
    @Override public Tipo visitTypeString(QplplParser.TypeStringContext ctx) { return new Tipo(TipoValor.STRING); }
    @Override public Tipo visitTypeNamed(QplplParser.TypeNamedContext ctx) {
        return new Tipo(TipoValor.ESTRUTURA, ctx.ID().getText());
    }






    @Override public Qualificador visitQualifConst(QplplParser.QualifConstContext ctx){
        return new Qualificador(true,false);
    }
    @Override public Qualificador visitQualifStatic(QplplParser.QualifStaticContext ctx){
        return new Qualificador(true,true);
    }
    @Override public Qualificador visitQualifiVazio(QplplParser.QualifiVazioContext ctx){
        return new Qualificador(false,false);
    }


}

