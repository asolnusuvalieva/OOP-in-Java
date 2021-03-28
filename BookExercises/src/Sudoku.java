import java.util.Scanner;

public class Sudoku {


    public static int[][] readASolution (){
        Scanner scanner = new Scanner(System.in);
        int[][] grid = new int[9][9];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = scanner.nextInt();
            }
        }

        return grid;
    }
}
