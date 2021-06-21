package semester1;

import java.util.Scanner;
/*
At least one uppercase letter, one lowercase letter and a number;
It can’t have any punctuation character, accent or space;
The password must be 6 to 32 characters.
 */
public class URI2253 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String password = scanner.nextLine();

            boolean containsUppercase = false;
            boolean containsLowercase = false;
            boolean containsNumber = false;
            boolean containsWrongCharacters = false;

            for(char currentChar : password.toCharArray()){
                if(Character.isUpperCase(currentChar)){
                    containsUppercase = true;
                }else if(Character.isLowerCase(currentChar)){
                    containsLowercase = true;
                }else if(Character.isDigit(currentChar)){
                    containsNumber = true;
                }else{
                    containsWrongCharacters = true;
                }
            }

            boolean isValid = !containsWrongCharacters && containsLowercase && containsUppercase && containsNumber && (password.length() > 5 && password.length() < 33);
            System.out.println(isValid ? "Senha valida." : "Senha invalida.");
        }
    }
}
