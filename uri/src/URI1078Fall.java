import java.util.Scanner;

public class URI1078Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        for(int i = 1; i <= 10; i++){
            int product = i * number;
            System.out.printf("%d x %d = %d%n", i, number, product);
        }
    }
}
//accepted