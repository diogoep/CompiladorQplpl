import ast.Codigo;
import intermediary.QplplIRTranslator;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import simbol.QplplChecker;
import interpreter.*;

public class Main {

    public static void main(String[] args) {
        try {
            QplplLexer lexer = new QplplLexer(CharStreams.fromFileName("/home/diogo/Downloads/QPP1-master/src/teste.txt"));

            QplplParser parser = new QplplParser(new CommonTokenStream(lexer));
            QplplParser.ProgramaContext ctx = parser.programa();


            // AST
            if( parser.getNumberOfSyntaxErrors() == 0) {
                QplplTranslator translate = new QplplTranslator(); //classe que transforma a arvore do antlr em uma AS;
                Codigo prog = (Codigo) translate.visit(ctx);
                prog.printAtDepth(0);

                // Análise Semântica
                QplplChecker checker = new QplplChecker(prog);
                checker.check();
                if (!checker.mostrarErros()) {
                    //IR
                    QplplIRTranslator translator = new QplplIRTranslator(checker.getPrincipal());
                    translator.translate();
                    System.out.println(translator.getHead().mostrarCodigo());
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
