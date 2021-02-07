import java.util.Scanner;
public class URI1238 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            String string1 = scanner.next();
            String string2 = scanner.next();
            String output = "";

            int minLength = Math.min(string1.length(), string2.length());
            for(int j = 0; j < minLength; j++){
                output += string1.charAt(j);
                output += string2.charAt(j);
            }

            String remainingString = "";

            if(string1.length() > string2.length()){
                remainingString = string1;
            }else if(string2.length() > string1.length()){
                remainingString = string2;
            }

            for(int n = minLength; n < remainingString.length(); n++){
                output += remainingString.charAt(n);
            }

            System.out.println(output);
        }
    }
}
//Accepted and pushed

