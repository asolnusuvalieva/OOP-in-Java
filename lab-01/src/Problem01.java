import java.util.Scanner;
public class Problem01 {
    /*
    Field Properties
    - width and height of the field
    - the content of the field
     */
    final static int WIDTH = 20;
    final static int HEIGHT = 20;

    final static char FIELD_TURTLE_CELL = 'T';
    final static char FIELD_EMPTY_CELL = '.';
    final static char FIELD_MARKED_CELL = '*';

    static char[][] fieldContent;

    /*
    Field Methods
    - initialize itself()
    - putMark(int x, int y)
    - display()
    - is the point inside? -> boolean
     */

    static void fieldInit(){
        fieldContent = new char[WIDTH][HEIGHT];
        for(int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                fieldContent[i][j] = FIELD_EMPTY_CELL;
            }
        }
    }

    static boolean fieldAreCoordsInside(int x, int y){

        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
    }

    static void fieldPutMark(int x, int y){
        if (fieldAreCoordsInside(x, y)){
            fieldContent[y][x] = FIELD_MARKED_CELL;
        }
    }

    static void fieldDisplay(){
        for(int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                if(turtleY == i && turtleX == j){
                    System.out.print(FIELD_TURTLE_CELL);
                }else{
                    System.out.print(fieldContent[i][j]);
                }
            }
            System.out.println();
        }
    }

    /*
    Turtle Properties
    - location(x, y)
    - pen is UP or DOWN
    - direction
     */

    static int turtleX = 0, turtleY = 0; //by default, the location is (0, 0)
    static boolean turtleIsPenDown = false; //be default, the pen is UP
    static int turtleDX = 1, turtleDY = 0; //be default, the turtle looks to the right

    /*
    Turtle Methods
    - putPenDown() or putPenUp()
    - turnRight() or turnLeft()
    - move()
     */

    static void turtlePutPenUp(){
        turtleIsPenDown = false;
    }

    static void turtlePutPenDown(){
        turtleIsPenDown = true;
    }

    /*
    (1, 0) looks to the right. After turning right, it should look down: (0, 1)

    Basically, turtleDX and turtleDY are changing their values between 1 and 0.
     */
    static void turtleTurnRight(){
        int temp = turtleDX;
        turtleDX = turtleDY;
        turtleDY = temp;

        turtleDX = -turtleDX;
    }

    static void turtleTurnLeft(){
        int temp = turtleDX;
        turtleDX = turtleDY;
        turtleDY = temp;

        turtleDY = -turtleDY;
    }

    static void turtleMove(int steps){
        for(int i = 0; i < steps; i++){ //Important to do it incrementally to be within the field
            int nextX = turtleX + turtleDX;
            int nextY = turtleY + turtleDY;

            if(!fieldAreCoordsInside(nextX, nextY)){
                break;
            }

            if(turtleIsPenDown){
                fieldPutMark(turtleX, turtleY);
            }
            turtleX = nextX;
            turtleY = nextY;
        }
    }


    public static void main(String[] args) {
        fieldInit();

        Scanner scanner = new Scanner(System.in);
        String input;
        while(!(input = scanner.nextLine().toLowerCase().trim()).equals("exit")){
            if(input.isEmpty()){
                System.err.println("Provide the command");
                continue;
            }
            String[] parts = input.split(" ");
            switch(parts[0]){
                case "penup":
                    turtlePutPenUp();
                    break;
                case "pendown":
                    turtlePutPenDown();
                    break;
                case "turnright":
                    turtleTurnRight();
                    break;
                case "turnleft":
                    turtleTurnLeft();
                    break;
                case "move":
                    if(parts.length != 2){
                        System.err.println("No info about the steps");
                        continue;
                    }
                    int steps;
                    try{
                        steps = Integer.parseInt(parts[1]);
                    }catch (Exception e){
                        System.err.println("Steps must be a number");
                        continue;
                    }

                    if(steps < 0){
                        System.err.println("Steps must be positive");
                        continue;
                    }
                    turtleMove(steps);
                    break;
                case "display":
                    fieldDisplay();
                    break;
                default:
                    System.err.println("Invalid Command");
                    break;
            }
        }
    }
}
