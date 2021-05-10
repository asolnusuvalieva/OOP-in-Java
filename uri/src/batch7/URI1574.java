package batch7;

import java.util.Scanner;

/*
p is the original position of the robot (x = 0)
LEFT: move one unit left (decrease p by 1)
RIGHT: move one unit right (increase p by 1)
SAME AS i: perform the same action as in the i-th instruction.
It is guaranteed that i is a positive integer not greater than the number of instructions before this.
 */
public class URI1574 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for(int t = 0; t < tests; t++){
            int numberOfInstructions = scanner.nextInt();
            scanner.nextLine(); //TODO: To avoid Scanner misreading

            String[] instructions = new String[numberOfInstructions];

            //Initializing the instructions
            for(int i = 0; i < numberOfInstructions; i++){
                String input = scanner.nextLine();
                if(input.contains("S")){ //Решать дела сразу здесь
                    String[] sameAs = input.split(" ");
                    int backTo = Integer.parseInt(sameAs[sameAs.length - 1]);
                    instructions[i] = instructions[backTo - 1];
                }else {
                    instructions[i] = input;
                }
            }

            int originPosition = 0;
            //Moving the robot
            for(int i = 0; i < numberOfInstructions; i++){
                String currentInstruction = instructions[i];

                if(currentInstruction.contains("L"))
                    originPosition--;
                else if(currentInstruction.contains("R"))
                    originPosition++;
            }

            System.out.println(originPosition);
        }
    }
}
//Accepted