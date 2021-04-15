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
        }
    }
    private static boolean isSameDiagonal(int x1, int y1, int x2, int y2){
        boolean isSameDiagonal = false;
        boolean firstQ = x2 > x1 && y2 < y1; // [x1 + 1, 8], [1, y1 - 1]
        boolean secondQ = x2 < x1 && y2 < y1; // [1, x1 - 1], [1, y1 - 1]
        boolean thirdQ = x2 < x1 && y2 > y1; // [1, x1 -1], [y1 + 1, 8]
        boolean forthQ = x2 > x1 && y2 > y1; // [x1 + 1, 8], [y1 + 1, 8]

        return isSameDiagonal;
    }
}