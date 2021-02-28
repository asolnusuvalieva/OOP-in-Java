import java.util.Scanner;
/*
- The frequency of letters in a given line of text.
- Letters are 26 letters of the alphabet
 */
public class URI1255 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); //TODO: To avoid Scanner Misreading

        for(int i = 0; i < testCases; i++){
            String text = scanner.nextLine();
            String formattedText = (text.toLowerCase()).trim();

            char[] textArray = formattedText.toCharArray();
            int[] frequencyArray = new int[26];

            for(char currentChar : textArray){
                if(Character.isAlphabetic(currentChar)){
                    int ascii = (int)currentChar;
                    int index = ascii - 97;
                    frequencyArray[index]++;
                }
            }

            System.out.println(makeOutput(frequencyArray));
        }
    }

    public static String makeOutput(int[] frequencyArray){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String output = "";
        int maxFrequency = frequencyArray[0];
        for(int i = 1; i < frequencyArray.length; i++){
            if(frequencyArray[i] > maxFrequency){
                maxFrequency = frequencyArray[i];
            }
        }

        for(int i = 0; i < frequencyArray.length; i++){
            if(frequencyArray[i] == maxFrequency){
                output += alphabet.charAt(i);
            }
        }

        return output;
    }
}
//Accepted and pushed
