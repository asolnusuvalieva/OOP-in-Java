import java.util.Scanner;
/*
Goal is to right justify given words in the same order as they appear in the input.
 */
public class URI1273 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWords = scanner.nextInt();
        while (numberOfWords != 0){
            String[] words = new String[numberOfWords];

            //Reading words and writing into array
            for(int i = 0; i < words.length; i++){
                words[i] = scanner.next();
            }

            int maxLength = findMaxLength(words);
            for(int i = 0; i < words.length; i++){
                System.out.println(makeOutput(maxLength, words[i]));
            }

            //Updating numberOfWords
            numberOfWords = scanner.nextInt();
        }
    }

    public static String makeOutput(int maxLength, String word){
        String output = "";
        int diff = maxLength - word.length();
        while (diff > 0){
            output += " ";
            diff--;
        }

        return output + word;
    }
    public static int findMaxLength(String[] words){
        int maxLength = words[0].length();
        int indexOfMax = 0;

        for(int i = 1; i < words.length; i++){
            if(words[i].length() > maxLength){
                maxLength = words[i].length();
                indexOfMax = i;
            }
        }

        return maxLength;
    }
}
