grammar Qplpl;



programa : definicao* EOF
         ;

definicao       : func          #DefinicaoFuncao
                | estrutura     #DefinicaoEstrutura
                | variavel      #DefinicaoVariavel
                ;


estrutura :'struct' ID '{' estruturaAcesso* '}';

estruturaAcesso
    : 'public'    ':' listMembro* #EstrutPublic
    | 'private'   ':' listMembro* #EstrutPrivate
    | 'protected' ':' listMembro* #EstrutProtected
    ;


listMembro
    : construtor #MembroConstrutor
    | atributo   #MembroATributo
    | metodo     #MembroMetodo
    ;

atributo : qualificador variavel;

variavel : tipo ID ';'                   #IniciaVariavelVazia
         | tipo ID '=' expressao ';'     #IniciaVariavelComValor
         ;


construtor : ID '{' parametros_formais '}' bloco;

metodo :  qualificador func;

func : tipo   ID '(' parametros_formais ')' bloco    #FuncaoComTipo
     |'void'  ID '(' parametros_formais ')' bloco    #FuncaoComVoid
     ;


parametros_formais     : tipo ID (',' tipo ID)*
                       |
                       ;


tipo            : 'int'       #TypeInt
                | 'char'      #TypeChar
                | 'bool'      #TypeBool
                | 'string'    #TypeString
                |  ID         #TypeNamed
                ;

nome            : ID '(' parametros_reais ')' ('.' nome)?    #NomeListFuncao
                | ID                          ('.' nome)?    #NomeListVariavel
                ;

parametros_reais    : expressao (',' expressao)*
                    |
                    ;



qualificador    : 'const'      #QualifConst
                | 'static'     #QualifStatic
                |              #QualifiVazio
                ;



comando         : bloco         #ComandoBloco
                | selecao       #ComandoSelecao
                | repeticao     #ComandoRepeticao
                | atribuicao    #ComandoAtribuicao
                | retorno       #ComandoRetorno
                | entrada       #ComandoEntrada
                | saida         #ComandoSaida
                | expressao ';' #ComandoExpressao
                | 'break' ';'   #ComandoBreak
                ;


bloco           : '{' variavel* comando* '}';


selecao         : 'if' '(' expressao ')' comando                    #SelectionIf
                | 'if' '(' expressao ')' comando 'else' comando    #SelectionIfElse
                ;

repeticao       : 'while' '(' expressao ')' comando;


atribuicao      : nome '=' expressao ';';

retorno         : 'return' expressao ';';


entrada         : 'std::cin' ('>>' expressao)+ ';';

saida           : 'std::cout' ('<<' expressao)+ ';';


expressao
    : '(' expressao ')'                                 #ExprParen
    | <assoc=right> '+' expressao                       #ExprUnariaPlus
    | <assoc=right> '-' expressao                       #ExprUnariaMinus
    | <assoc=right> '++' expressao                      #ExprIncrementoEsq
    | <assoc=right> '--' expressao                      #ExprDecrementoEsq
    | <assoc=right> expressao  '++'                     #ExprIncrementoDir
    | <assoc=right> expressao  '--'                     #ExprDecrementoDir
    | <assoc=right> '!' expressao                       #ExprNot
    | expressao   '%'  expressao                        #ExprMod
    | expressao '*' expressao                           #ExprMult
    | expressao '/' expressao                           #ExprDiv
    | expressao '+' expressao                           #ExprSoma
    | expressao '-' expressao                           #ExprSub
    | expressao '<'  expressao                          #ExprMenor
    | expressao '<=' expressao                          #ExprMenorIgual
    | expressao '>'  expressao                          #ExprMaior
    | expressao '>=' expressao                          #ExprMaiorIgual
    | expressao '==' expressao                          #ExprIgual
    | expressao '!=' expressao                          #ExprDiferente
    | expressao '&&' expressao                          #ExprE
    | expressao '||' expressao                          #ExprOU
    | nome                                              #ExprVariavel
    | literal                                           #ExprLiteral
    ;


literal
    : INTL      #LiteralInt
    | STRL      #LiteralString
    | CHARL     #LiteralChar
    | BOOLL     #LiteralBool
    ;



fragment DIG : [0-9];
fragment LET : [a-zA-Z];
fragment PONT: ('-' | '!' | ':' | ',' | '.' | '+' | '?' | '(' | ')' | '{' | '}' | '/');
//ACHA QUE É ID PQ O PADRAO É O MESMO
INTL    : ( '+' | '-' )? ( '0' | [1-9](DIG)* );
CHARL   : '\'' ( DIG | LET )? '\'';
STRL    : '"' ( DIG | LET | ' ' | PONT)* '"';
BOOLL   : 'true' | 'false';




ID      : LET ( '_' | LET | DIG )*;



COMMENTBLOCK: '/*' .*? '*/' -> skip;
COMMENTLINE: '//' ~[\r\n]*  -> skip;
WS      : [ \r\n\t]+ -> skip ;





///////////////////////////////////////////////////////////////////////////////////////////////////


