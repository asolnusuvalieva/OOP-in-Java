import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/*
Write a program that removes all the occurrences of a specified string from a text file.
For example, invoking
            java Exercise12_11 John filename
removes the string John from the specified file.
 */
public class Problem05 {
    public static void main(String[] args) throws Exception { //we say, there is a possibility to crash
        /*
        args is a command line arguments.
        For example, Scanner provides interactive way.
         */
        if(args.length != 2){
            System.err.println("Usage: java Problem05 <Text To Remove> <File To Process>");
            System.exit(-1); //unsuccessful program completion (any other number than 0)
        }

        /*
        The File class is an abstract representation of file and directory pathname.
        A pathname can be either absolute or relative.
         */

        //Check if source file exists
        File fileToProcess = new File(args[1]);
        if(!fileToProcess.exists()){
            System.out.printf("File '%s' doesn't exist.%n", args[1]);
            System.exit(-1);
        }

        File tempFile = File.createTempFile("Problem05.tmp", ".txt");
        tempFile.deleteOnExit();

        try(
                // Create input and output files
                Scanner input = new Scanner(fileToProcess);
                PrintWriter output = new PrintWriter(tempFile);
        ){
            while (input.hasNext()){
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[0], "");
                output.println(s2);
            }
        }

        //Writing temp file to the original one
        Files.copy(tempFile.toPath(), fileToProcess.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
