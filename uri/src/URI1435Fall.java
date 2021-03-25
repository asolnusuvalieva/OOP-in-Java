import java.util.Scanner;

public class URI1435Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do{
            n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    matrix[i][j] = (int) (n/2.0 + 1 - Math.max(Math.abs(i - (n - 1)/2.0), Math.abs(j - (n - 1)/2.0)));
                }
            }

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.printf(j < n - 1 ? "%3d " : "%3d%n", matrix[i][j]);
                }
            }
            if(n != 0){
                System.out.println();
            }
        }while (n != 0);
    }
}
//accepted and pushed
