package semester1;

import java.util.Scanner;
/*
The trunk of the tree is *
                        * *
 with each row starting with the size ordered by you and decreasing every two character,
 until you reach the top of the tree that have just one asterisk.
 */
public class URI1768 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int number = scanner.nextInt();
            for(int i = 1; i <= number; i += 2){
                System.out.println(printLayer(i, number));
            }

            //Printing trunk
            for(int i = 1; i <= 3; i += 2){
                System.out.println(printLayer(i, number));
            }

            System.out.println();//Going to the next line after each test case
        }
    }

    public static String printLayer(int numberOfAsterisks, int maxLength){
        int spacesEachSide = (maxLength - numberOfAsterisks)/2;
        char[] spaces = new char[spacesEachSide];
        char[] asterisks = new char[numberOfAsterisks];

        for(int s = 0; s < spacesEachSide; s++){
            spaces[s] = ' ';
        }

        for(int a = 0; a < numberOfAsterisks; a++){
            asterisks[a] = '*';
        }
        return String.valueOf(spaces) + String.valueOf(asterisks);
    }
}

//Accepted and pushed