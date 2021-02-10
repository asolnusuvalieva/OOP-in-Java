import java.util.Scanner;

public class URI1253 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //0123456789
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            String encodedMessage = scanner.next();
            int leftShift = scanner.nextInt(); //this is how many shifts left I have to make
            String output = "";

            for(int j = 0; j < encodedMessage.length(); j++){
                char currentChar = encodedMessage.charAt(j);
                int indexOfChar = letters.indexOf(currentChar) - leftShift;
                if(indexOfChar < 0){
                    indexOfChar *= -1;
                    int wrappedIndexOfChar = letters.length() - indexOfChar;
                    output += letters.charAt(wrappedIndexOfChar);
                }else{
                    output += letters.charAt(indexOfChar);
                }
            }
            System.out.println(output);
        }
    }
}
//Accepted and pushed