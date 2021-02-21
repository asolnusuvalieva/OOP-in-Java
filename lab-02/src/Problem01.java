import gameObjects.*;
import java.util.Scanner;
public class Problem01 {
    public static void main(String[] args) {
        Field field = new Field();
        Turtle turtle = new Turtle(field);

        Scanner scanner = new Scanner(System.in);

        String input;
        while(!(input = scanner.nextLine().toLowerCase().trim()).equals("exit")){
            if(input.isEmpty()){
                System.err.println("Provide the command");
                continue; //going to the next iteration
            }

            String[] parts = input.split(" ");

            switch(parts[0]){
                case "penup":
                    turtle.putPenUp();
                    break;
                case "pendown":
                    turtle.putPenDown();
                    break;
                case "turnright":
                    turtle.turnRight();
                    break;
                case "turnleft":
                    turtle.turnLeft();
                    break;
                case "move":
                    if(parts.length != 2){
                        System.err.println("No info about the steps");
                        continue;
                    }

                    int steps;
                    try{
                        steps = Integer.parseInt(parts[1]); //handling other developers' code
                    }catch(Exception e){
                        System.err.println("Steps must be a number");
                        continue;
                    }

                    if(steps < 0){
                        System.err.println("Steps must be positive");
                        continue;
                    }
                    turtle.move(steps);
                    break;
                case "display":
                    field.display(turtle);
                    break;
                default:
                    System.err.println("Invalid Command");
                    break;
            }
        }
    }
}
