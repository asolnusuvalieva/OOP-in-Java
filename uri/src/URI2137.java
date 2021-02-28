import java.util.Arrays;
import java.util.Scanner;

public class URI2137 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int testCases = scanner.nextInt();
            int[] codeNumbers = new int[testCases];

            //Creating an array of int values
            for(int i = 0; i < testCases; i++){
                String input = scanner.next();
                codeNumbers[i] = Integer.parseInt(input);
            }

            //Sorting this array
            Arrays.sort(codeNumbers);

            //Printing the output
            for(int codeValue : codeNumbers){
                System.out.println(makeOutputString(codeValue));
            }
        }
    }

    public static String makeOutputString(int codeValue){
        String output = "";
        if(String.valueOf(codeValue).length() < 4){
            int diff = 4 - String.valueOf(codeValue).length();
            while (diff > 0){
                output += '0';
                diff--;
            }
        }

        return output + codeValue;
    }
}

//Accepted and pushed