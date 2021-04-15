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

        int startBoardY = -1;
        int endBoardY = -1;
        int startBoardX = -1;
        int endBoardX = -1;

        if(firstQ){
            startBoardY = 1;
            endBoardY = y1 - 1;
            startBoardX = x1 + 1;
            endBoardX = 8;
        }else if(secondQ){
            startBoardY = 1;
            endBoardY = y1 - 1;
            startBoardX = 1;
            endBoardX = x1 - 1;
        }else if(thirdQ){// [1, x1 -1], [y1 + 1, 8]
            startBoardY = y1 + 1;
            endBoardY = 8;
            startBoardX = 1;
            endBoardX = x1 - 1;
        }else if(forthQ){// [x1 + 1, 8], [y1 + 1, 8]
            startBoardY = y1 + 1;
            endBoardY = 8;
            startBoardX = x1 + 1;
            endBoardX = 8;
        }

        //Check individual points on the diagonal of that quarter
        for(int boardY = startBoardY; boardY <= endBoardY; boardY++){
            for(int boardX = startBoardX; boardX <= endBoardX; boardX++){
                if(boardX == x2 && boardY == y2){
                    isSameDiagonal = true;
                    break;
                }
            }
        }

        return isSameDiagonal;
    }
}