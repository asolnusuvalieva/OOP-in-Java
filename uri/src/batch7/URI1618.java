package batch7;
import java.util.Scanner;
/*
Print '1' is the robot is within the area;
Print '0' otherwise.
 */

public class URI1618 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for(int i = 0; i < tests; i++){
            int aX = scanner.nextInt(); //widthX1
            int aY = scanner.nextInt();
            int bX = scanner.nextInt(); //widthX2
            int bY = scanner.nextInt(); //heightY1
            int cX = scanner.nextInt();
            int cY = scanner.nextInt(); //heightY2
            int dX = scanner.nextInt();
            int dY = scanner.nextInt();
            int robotX = scanner.nextInt();
            int robotY = scanner.nextInt();

            if(robotX >= aX && robotX <= bX
                    && robotY >= bY && robotY <= cY){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}

//Accepted