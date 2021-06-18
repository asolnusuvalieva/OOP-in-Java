package semester1;

import java.util.Scanner;
/*
Translating shortcuts into HTML tags!
There are italic or bold shortcuts;
The number of underscores is even,
The number of asterisks is even.

Any substring of the text that are enclosed by two underscores or asterisks CANNOT contain more further.
 */
public class URI1239 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String text = scanner.nextLine();
            char[] chars = text.toCharArray();
            int numberOfUnderscores = 0;
            int numberOfAsterisks = 0;

            for(char currentChar : chars){
                if(currentChar == '_'){
                    numberOfUnderscores++;
                    System.out.print(numberOfUnderscores % 2 == 1 ? "<i>" : "</i>");
                }else if (currentChar == '*'){
                    numberOfAsterisks++;
                    System.out.print(numberOfAsterisks % 2 == 1 ? "<b>" : "</b>");
                }else{
                    System.out.print(currentChar);
                }
            }
            System.out.println(); //Putting cursor to the next line
        }
    }
}
//Accepted and pushed