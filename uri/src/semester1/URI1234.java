package semester1;

import java.util.Scanner;
/*
A sentence is called dancing if its first letter is uppercase
and the case of each subsequent letter is the opposite of the previous letter.

For example, AsOl or HeLlO

*Spaces should be ignored
 */
public class URI1234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String input = scanner.nextLine();
            int count = 0;
            String output = "";
            for(int i = 0; i < input.length(); i++){
                char currentChar = input.charAt(i);

                if(count % 2 == 0){
                    output += Character.toUpperCase(currentChar);
                }else{
                    output += Character.toLowerCase(currentChar);
                }

                if(currentChar != ' '){
                    count++;
                }
            }
            System.out.println(output);
        }
    }
}
//Accepted and pushed