package batch6;
import java.util.Scanner;
/*
For example, if the recruit is initially with his face oriented to the north,
after a command "Turn left!" he should stay with his face oriented to the west.
If the recruit is initially with his face oriented to the east,
after a command "Turn right!" He must have his face oriented to the south.

Face turned to *North*
'E' (for "Turn left!") and 'D' (for "Turn right!")
 */
public class URI1437 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCommands;

        while ((numberOfCommands = scanner.nextInt()) != 0){
            scanner.nextLine(); //TODO: to avoid scanner misreading

            String commands = scanner.nextLine();
            int count = 0;

            for(char command : commands.toCharArray()){
                if(command == 'D'){ //Right
                    count++;
                }else{ //Left
                    count--;
                }
            }

            String direction = "";

            if(count > 0){
                if (count % 4 == 0)
                    direction = "N";
                else if (count % 4 == 1)
                    direction = "L"; //E
                else if (count % 4 == 2)
                    direction = "S";
                else if (count % 4 == 3)
                    direction = "O"; //W
            }else{
                if (count % 4 == 0)
                    direction = "N";
                else if (count % 4 == -1)
                    direction = "O"; //W
                else if (count % 4 == -2)
                    direction = "S";
                else if (count % 4 == -3)
                    direction = "L"; //E
            }

            System.out.println(direction);
        }
    }
}
//Accepted