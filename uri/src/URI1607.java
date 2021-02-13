import java.util.Scanner;
/*
String 1
String 2

Goal: transform it in the next letter of the alphabet

Given both strings, compute the minimum number of operations needed to transform the first string into the second one.

Possibilities
- String has to be advanced by going to -> direction
-
 */
public class URI1607 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < testCase; i++){
            String string1 = scanner.next();
            String string2 = scanner.next();
            int steps = 0;

            for(int j = 0; j < string1.length(); j++){
                int char1Index = alphabet.indexOf(string1.charAt(j));
                int char2Index = alphabet.indexOf(string2.charAt(j));
                int diff;
                if(char2Index < char1Index){
                    diff = 26 - char1Index + char2Index;
                }else{
                    diff = char2Index - char1Index;
                }
                steps += diff;
            }
            System.out.println(steps);
        }

    }
}
//Accepted and pushed