import java.util.Scanner;

public class URI1176Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] fibonacciSequence = new long[61]; //0 <= n <= 60
        fibonacciSequence[0] = 0;
        fibonacciSequence[1] = 1;

        for(int i = 2; i < fibonacciSequence.length; i++){
            fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
        }

        int numberOfTests = scanner.nextInt();
        for(int i = 0; i < numberOfTests; i++){
            int n = scanner.nextInt();
            System.out.printf("Fib(%d) = %d%n", n, fibonacciSequence[n]);
        }
    }
}
//Accepted and pushed
