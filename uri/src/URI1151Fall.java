import java.util.Scanner;

public class URI1151Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] fibonacciSequence = new int[45];
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;

        for(int i = 2; i < 45; i++){
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }

        for(int i = 0; i < n; i++){
            if(i == n - 1){
                System.out.println(fibonacciSequence[i]);
                break;
            }
            System.out.print(fibonacciSequence[i] + " ");
        }

    }
}
//Accepted and Pushed