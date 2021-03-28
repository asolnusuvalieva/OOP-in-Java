import java.util.Scanner;

public class Sudoku {
    public static void main(String[] args) {
        int[][] solution = readASolution();
        System.out.println(isValid(solution) ? "Valid solution" : "Invalid solution");
    }

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

    //is Solution Valid?
    public static boolean isValid(int[][] solution){
        for(int i = 0; i < solution.length; i++){
            for(int j = 0; j < solution[i].length; j++){
                if(solution[i][j] < 1 || solution[i][j] > 9 || !isValid(i, j, solution)){
                    return false;
                }
            }
        }
        return true;
    }

    //is Cell unique?
    public static boolean isValid(int i, int j, int[][] solution){
        //Unique in row "i"?
        for(int column = 0; column < solution[i].length; column++){
            if(solution[i][column] == solution[i][j] && column != j){
                return false;
            }
        }

        //Unique in column "j"
        for(int row = 0; row < solution.length; row++){
            if(row != i && solution[i][j] == solution[row][j]){
                return false;
            }
        }

        //Unique in 3 X 3 block
        for(int row = i/3 * 3; row < i/3 * 3 + 3; row++){
            for(int col = j/3 * 3; col < j/3 * 3 + 3; col++){
                if(row != i && col != j && solution[row][col] == solution[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
