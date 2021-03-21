import java.util.Scanner;
/*
Justifier II

Input:
- 1 to 50 uppercase letters (‘A’-‘Z’) or spaces (‘ ’)
- At least one letter in a line
- More than one space character between words
- Leading and trailing spaces in the input lines.
 */
public class URI1278 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String spaceRegex = "\\s{1,}";
        int testCases = scanner.nextInt();

        while (testCases != 0){
            scanner.nextLine(); //TODO: To avoid scanner misreading

            String[] lines = new String[testCases];
            int maxLength = 1;
            //Initialization
            for(int i = 0; i < testCases; i++){
                String line = scanner.nextLine().trim(); //removing all leading and trailing spaces
                lines[i] = line.replaceAll(spaceRegex, " ");
                maxLength = Math.max(maxLength, lines[i].length());
            }

            //Printing
            for(String line : lines){
                System.out.println(makeOutput(line, maxLength));
            }

            testCases = scanner.nextInt(); //Updating testCases

            if(testCases != 0){
                System.out.println();//Going to another line after each tests
            }
        }
    }

    public static String makeOutput(String line, int maxLength){
        String output = "";
        int numberOfSpaces = maxLength - line.length();

        while (numberOfSpaces > 0){
            output += " ";
            numberOfSpaces--;
        }

        return output + line;
    }
}

//Accepted and pushed