/**
 * @author heckelson
 * @id m-nr
 */

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

public class AdvancedCalculator {
    public static void main(String[] args) throws IOException {
        //TODO: Change the filenames to the programs you wrote or the program1-4 set.
        
//         evaluateProgram("program1.txt");
//         evaluateProgram("program2.txt");
//         evaluateProgram("program3.txt");
//         evaluateProgram("program4.txt");
// 
//         evaluateProgram("program_modulo_debug.txt");
    }

    private static void evaluateProgram(String filename) throws IOException {
        printProgram(filename);
        System.out.println(" ==> " + runProgram(filename));
        System.out.println();
    }

    private static void printProgram(String filename) throws FileNotFoundException {
        System.out.println("=== " + filename + " ===");
        Scanner fileIn = new Scanner(new File(filename));
        while (fileIn.hasNext()) {
            System.out.println(fileIn.nextLine());
        }
    }

    private static BigDecimal runProgram(String filename) throws IOException {
        final CharStream input = CharStreams.fromFileName(filename);
        final AdvancedCalculatorLexer lexer = new AdvancedCalculatorLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AdvancedCalculatorParser parser = new AdvancedCalculatorParser(tokens);

        final ParseTree tree = parser.program();
        final AdvancedCalculatorVisitor<BigDecimal> visitor = new AdvancedCalculatorVisitorImpl();
        return visitor.visit(tree);
    }
}
