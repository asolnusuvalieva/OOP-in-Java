package semester1;

import java.util.Scanner;
/*
the hidden message of a text is composed of the first letter from each word in the text,
in the order they appear
 */
public class URI1272 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < testCases; i++){
            String line = scanner.nextLine();
            String formattedLine = line.replaceAll("\\s{2,}", " ").trim();
            String[] words = formattedLine.split(" ");
            String output = "";
            for(int j = 0; j < words.length; j++){
                output += words[j].charAt(0);
            }
            System.out.println(output);
        }
    }
}
//Accepted and pushed




