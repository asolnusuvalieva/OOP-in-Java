package semester1;

import java.util.Scanner;
/*
one, two, three
    - for each word, there might be at most one WRONG LETTER.
    - the word length is always correct.
    - each word has a unique interpretation.
 */
public class URI1332 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWords = scanner.nextInt();

        for(int i = 0; i < numberOfWords; i++){
            String word = scanner.next();
            if(word.length() == 5){
                System.out.println(3);
            }else{ //1 or 2
                String one = "one";
                int mistakes = 0;
                for(int j = 0; j < word.length(); j++){
                    if(word.charAt(j) != one.charAt(j)){
                        mistakes++;
                    }
                }

                System.out.println(mistakes > 1 ? 2 : 1);
            }
        }
    }
}
//Accepted and pushed