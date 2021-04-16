package batch6;

import java.util.Scanner;

public class URI1087{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.contains("0")) { // 1 <= X or Y <= 8
            String[] parts = input.split(" ");

            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            int x2 = Integer.parseInt(parts[2]);
            int y2 = Integer.parseInt(parts[3]);

            if(x1 == x2 && y1 == y2){
                System.out.println(0);
            }else if(x1 == x2 || y1 == y2 || (Math.abs(x1 - x2) == Math.abs(y1 - y2))){
                System.out.println(1);
            }else{
                System.out.println(2);
            }

            input = scanner.nextLine(); //Accepting new input
        }
    }
}
//Accepted