package semester1;

import java.util.Scanner;
/*
The text is given and there, only OBI and URI can be written incorrectly,
and the error can be only in the last letter.
 */
public class URI2062 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int numberOfWords = scanner.nextInt();
            scanner.nextLine(); //TODO: To avoid Scanner misreading
            String[] words = scanner.nextLine().split(" ");

            for(int i = 0; i < numberOfWords; i++){
                String currentWord = words[i];
                if(currentWord.length() == 3 &&
                        (currentWord.substring(0, 2).equals("UR") || currentWord.substring(0, 2).equals("OB"))){
                    System.out.print(currentWord.substring(0, 2) + (i == numberOfWords - 1 ? "I\n" : "I "));
                }else{
                    System.out.print(currentWord + (i == numberOfWords - 1 ? "\n" : " "));
                }
            }

        }
    }
}

//Accepted and pushed