package semester1;/*
# the consonants do not interfere in how digital laughter influence the feeling of transmission.
#  the funniest digital laughter are those in which the sequences of vowels are the same
when read in the natural order (from left to right) or in reverse order (from right to left),
ignoring consonants.

For example,
huaauhahhuahau
ua au a ua au
If laugh is funniest or not?
 */

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class URI2242 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String laughter = scanner.next();
            char[] laughterVowels = new char[laughter.length()]; //the max length if there is a word of only vowels
            int vowelsCount = 0;
            for(int i = 0; i < laughter.length(); i++){
                char currentChar = laughter.charAt(i);
                if(currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || currentChar == 'o' || currentChar == 'u'){
                    laughterVowels[vowelsCount] = currentChar;
                    vowelsCount++;
                }
            }

            boolean isFunny = true;
            for(int l = 0, r = vowelsCount - 1; l < r; l++, r--){
                if(laughterVowels[l] != laughterVowels[r]){
                    isFunny = false;
                    break;
                }
            }

            if(isFunny){
                System.out.println("S");
            }else{
                System.out.println("N");
            }
        }
    }
}
//Accepted and pushed