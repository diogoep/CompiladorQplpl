import ast.Codigo;
import ast.Programa;
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
            QplplTranslator translate = new QplplTranslator(); //classe que transforma a arvore do antlr em uma AS;

            // AST

            Programa prog = (Programa) translate.visit(ctx);
            prog.printAtDepth(0);

            // Análise Semântica
            QplplChecker checker = new QplplChecker(prog);
            checker.check();
            checker.mostrarErros();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
