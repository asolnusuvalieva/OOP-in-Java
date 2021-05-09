package batch7;

import java.util.Scanner;

/*
Input
- Digits
- Spaces
- Uppercase Letters (except Q, A, Z)
- Punctuation Marks (-, =, [, ], \, /, ;, ', ., ,)
 */
public class URI1196 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();

            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == ' '){
                    output.append(' ');
                }else{
                    output.append(makeRightOutput(input.charAt(i)));
                }
            }

            System.out.println(output);
        }
    }

    private static char makeRightOutput(char inputChar){
        char[] keyboardRow1 = {'`', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-', '='};
        int[] row1Info = contains(inputChar, keyboardRow1);
        char[] keyboardRow2 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P', '[', ']', '\\'};
        int[] row2Info = contains(inputChar, keyboardRow2);
        char[] keyboardRow3 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', ';', '\''};
        int[] row3Info = contains(inputChar, keyboardRow3);
        char[] keyboardRow4 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M', ',', '.', '/'};
        int[] row4Info = contains(inputChar, keyboardRow4);

        int index;
        char answer = ' '; //A default answer, this symbol is not present in the problem
        if(row1Info[0] == 1){
            index = row1Info[1];
            answer = keyboardRow1[index-1];
        }else if(row2Info[0] == 1){
            index = row2Info[1];
            answer = keyboardRow2[index-1];
        }else if(row3Info[0] == 1){
            index = row3Info[1];
            answer = keyboardRow3[index-1];
        }else if(row4Info[0] == 1){
            index = row4Info[1];
            answer = keyboardRow4[index-1];
        }

        return answer;
    }

    private static int[] contains(char inputChar, char[] keyboardRow){
        /* -1 -> failure, 1 -> success*/
        int contains = -1;
        int index = -1;

        for(int i = 0; i < keyboardRow.length; i++){
            if(keyboardRow[i] == inputChar){
                contains = 1;
                index = i;
                break;
            }
        }

        return new int[]{contains, index};
    }
}
//Accepted