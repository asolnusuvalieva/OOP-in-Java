import java.util.Scanner;
/*
Full -- all letters of the alphabet
Almost Full -- half of the letters of the alphabet
Nah

Input: one line: lowercase letters, white spaces and/or commas
 */
public class URI1551 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String spaceRegex = "\\s{1,}";

        int testCases = scanner.nextInt();
        scanner.nextLine(); //TODO: To avoid Scanner Misreading

        for(int i = 0; i < testCases; i++) {
            String line = scanner.nextLine().replaceAll(",", "");
            String formattedLine = line.replaceAll(spaceRegex, "");

            boolean full = true;

            //Working on `full`
            for(int j = 0; j < alphabet.length(); j++){
                String currentAlphabetChar = String.valueOf(alphabet.charAt(j));
                if(!formattedLine.contains(currentAlphabetChar)){
                    full = false;
                    break;
                }
            }

            int containsCount = 0;
            //Working on almost full
            for(int j = 0; j < alphabet.length(); j++){
                String currentAlphabetChar = String.valueOf(alphabet.charAt(j));
                if(formattedLine.contains(currentAlphabetChar)){
                    containsCount++;
                }
            }

            //Finally deciding
            if(full){
                System.out.println("frase completa");
            }else if(containsCount >= 13){
                System.out.println("frase quase completa");
            }else{
                System.out.println("frase mal elaborada");
            }
        }
    }
}
//Accepted and pushed