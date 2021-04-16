package batch6;
import java.util.Scanner;
/*
Multiple-choice tests.
In each test, each question will have five alternatives (A, B, C, D and E),
and the teacher will distribute one answer sheet for each student.

Row - Question
Columns - Options
black 0 <= 127
white > 127

Situations:
1) a single option chosen
2) more than one option chosen (*)
3) No option chosen (*)
 */
public class URI1129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] alternatives = {'A', 'B', 'C', 'D', 'E'};
         int numberOfQs;

         while ((numberOfQs = scanner.nextInt()) != 0){
             scanner.nextLine(); // TODO: To avoid scanner misreading

             for(int i = 0; i < numberOfQs; i++){
                 String[] questionAlternatives = scanner.nextLine().split(" ");
                 int blacks = 0;
                 int singleCorrectAnswerIndex = -1;

                 for(int j = 0; j < questionAlternatives.length; j++){
                     int optionValue = Integer.parseInt(questionAlternatives[j]);
                     if(optionValue >= 0 && optionValue <= 127){
                         blacks++;
                         singleCorrectAnswerIndex = j;
                     }
                 }

                 if(blacks == 1){ //single answer
                     System.out.println(alternatives[singleCorrectAnswerIndex]);
                 }else if(blacks > 1 || blacks == 0){ //more than one || nothing at all
                     System.out.println('*');
                 }
             }
         }
    }
}
//Accepted