import java.util.Scanner;

public class URI1173Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[10];
        array[0] = number;
        System.out.printf("N[%d] = %d%n", 0, number);

        for(int i = 1; i < array.length; i++){
            array[i] = array[i - 1] * 2;
            System.out.printf("N[%d] = %d%n", i, array[i]);
        }
    }
}
//Accepted and pushed