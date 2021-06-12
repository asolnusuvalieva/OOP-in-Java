package semester1;

import java.util.Scanner;
/*
I -> each uppercase or lowercase LETTER must be shifted 3 positions to the right, according to the ASCII table
For example, letter 'a' should become letter 'd', letter 'y' must become the character '|' and so on.

II -> 1) each line must be reversed
      2) all characters from the half on (truncated) must be moved one position to the left in ASCII

 */
public class URI1024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < testCases; i++){
            String line = scanner.nextLine();
            String output = "";
            for(int j = line.length() - 1; j >= 0; j--){
                char currentChar = line.charAt(j);

                //Is in the alphabet?
                if(currentChar >= 'a' && currentChar <= 'z' || (currentChar >= 'A' && currentChar <= 'Z')){
                    int currentShiftedCharUnicode = currentChar + 3;
                    currentChar = (char)currentShiftedCharUnicode;
                }

                output += currentChar;
            }
            //truncating
            int halfN = line.length()/2;
            for(int n = line.length() - 1; n >= halfN; n--){
                int shiftedOne = output.charAt(n) - 1;
                char[] outputChars = output.toCharArray();
                outputChars[n] = (char)shiftedOne;
                output = String.valueOf(outputChars);
            }
            System.out.println(output);
        }
    }
}
//Accepted and pushed