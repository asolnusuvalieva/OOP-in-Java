package semester1;

import java.util.Scanner;

public class URI1257 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int testCases = scanner.nextInt();
        scanner.nextLine(); //TODO: To avoid misreading

        for(int i = 0; i < testCases; i++){
            int numberOfLines = scanner.nextInt();
            scanner.nextLine(); //TODO: To avoid misreading
            int hash = 0;

            for(int j = 0; j < numberOfLines; j++){
                String line = scanner.nextLine();
                int elementOfInput = j;

                //Working with each character of every line
                for(int c = 0; c < line.length(); c++){
                    int positionInElement = c;
                    int alphabetPosition = alphabet.indexOf(line.charAt(c));
                    hash += alphabetPosition + elementOfInput + positionInElement;
                }
            }

            System.out.println(hash);
        }
    }
}
//Accepted and pushed