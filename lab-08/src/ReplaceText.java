//Problem04
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/*
The program checks the number of arguments passed to the main method (lines 7–11),
checks whether the source and target files exist (lines 14–25),
creates a Scanner for the source file (line 29),
creates a PrintWriter for the target file (line 30),
and repeatedly reads a line from the source file (line 33),
replaces the text (line 34), and writes a new line to the target file (line 35).
 */
public class ReplaceText {
    public static void main(String[] args) throws Exception {
        //Check command line parameter usage
        if(args.length != 4){
            System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }

        // Check if source file exists
        File sourceFile = new File(args[0]);
        if(!sourceFile.exists()){
            System.out.println("Source file " + args[0] + " doesn't exist");
            System.exit(2);
        }

        //Check if target file exists
        File targetFile = new File(args[1]);
        if(targetFile.exists()){
            System.out.println("Target file " + args[1] + " already exists");
            System.exit(3);
        }

        try(
            // Create input and output files
            Scanner input = new Scanner(sourceFile);
            PrintWriter output = new PrintWriter(targetFile);
            ){
            while (input.hasNext()){
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[2], args[3]);
                output.println(s2);
            }
        }
    }
}
