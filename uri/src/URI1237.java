import java.util.Scanner;
/*
Find the longest common substring between the two informed Strings.

Input:
2 lines of String

Output:
The length of the longest substring
 */
public class URI1237 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();
            int maxSubstringLength = 0;

            //Working with only one word and using contains() method
            for(int i = 0; i < string1.length(); i++){ //beginIndex
                for(int j = i + 1; j <= string1.length(); j++){ //endIndex
                    String currentSubstring = string1.substring(i, j);
                    if(string2.contains(currentSubstring)){
                        maxSubstringLength = Math.max(maxSubstringLength, currentSubstring.length());
                    }
                }
            }
            System.out.println(maxSubstringLength);
        }
    }
}
//Accepted and pushed