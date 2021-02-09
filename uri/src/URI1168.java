import java.util.Scanner;

public class URI1168 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] leds = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6}; //each represent numbers from 0 to 9
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            String input = scanner.next();
            int ledsCount = 0;
            for(int j = 0; j < input.length(); j++){
                char currentCharacter = input.charAt(j);
                int characterIndex = Integer.parseInt(String.valueOf(currentCharacter));
                ledsCount += leds[characterIndex];
            }
            System.out.println(ledsCount + " leds");
        }
    }
}
//accepted and pushed
