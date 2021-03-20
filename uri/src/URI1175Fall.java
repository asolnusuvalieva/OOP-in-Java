import java.util.Scanner;

public class URI1175Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0, j = numbers.length - 1; j > i; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }

        int i = 0;
        while (i < numbers.length) {
            System.out.printf("N[%d] = %d%n", i, numbers[i]);
            i++;
        }
    }
}
//Accepted and pushed
