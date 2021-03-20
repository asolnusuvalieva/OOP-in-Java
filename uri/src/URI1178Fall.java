import java.util.Scanner;

public class URI1178Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] array = new double[100];
        double x = scanner.nextDouble();
        array[0] = x;
        System.out.printf("N[%d] = %.4f%n", 0, array[0]);

        for(int i = 1; i < array.length; i++){
            array[i] = array[i - 1] * 0.5;
            System.out.printf("N[%d] = %.4f%n", i, array[i]);
        }

    }
}
//Accepted and pushed