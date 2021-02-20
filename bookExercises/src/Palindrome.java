import java.util.Scanner;
/*
One solution is to check whether the first character in the string is the same as the last character.
 If so, check whether the second character is the same as the second-to-last character.
 This process continues until a mismatch is found or
 all the characters in the string are checked,
 except for the middle character if the string has an odd number of characters.
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = scanner.nextLine();

        // The index of the first character in the string
        int start = 0;
        // The index of the last character in the string
        int end = s.length() - 1;

        boolean isPalindrome =  true;

        while (start < end){
            if(s.charAt(start) != s.charAt(end)){
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome){
            System.out.println(s + " is a palindrome");
        }else{
            System.out.println(s + " is not a palindrome");
        }
    }
}
