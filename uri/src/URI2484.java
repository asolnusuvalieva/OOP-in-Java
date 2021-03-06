import java.util.Scanner;

public class URI2484 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String word = scanner.next();

            for(int endIndex = word.length(), s = 0; endIndex > 0; endIndex--, s++){ //the endIndex is exclusive, s is for spaces
                System.out.println(justify(word.substring(0, endIndex), s));
            }

            System.out.println(); //a new line after each test case
        }
    }

    public static String justify(String substring, int spaces){
        char[] chars = new char[substring.length() + substring.length() - 1]; //no blank space needed for the last letter
        int index = 0;
        for(int i = 0; i < chars.length; i++){
            if(i % 2 == 0){
                chars[i] = substring.charAt(index);
                index++;
            }else{
                chars[i] = ' ';
            }
        }

        return addSpaces(spaces) + String.valueOf(chars);
    }

    public static String addSpaces(int number){
        String spaces = "";
        while (number > 0){
            spaces += " ";
            number--;
        }
        return spaces;
    }
}
//Accepted and pushed