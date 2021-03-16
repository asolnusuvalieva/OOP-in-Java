import java.util.Scanner;

public class URI1144Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 2 * scanner.nextInt(); //number of output lines
        int number = 1;
        int printCount = 0;

        while (printCount != n){
            int squared = (int)Math.pow(number, 2);
            int cubed = (int)Math.pow(number, 3);
            System.out.printf("%d %d %d%n", number, squared, cubed);
            System.out.printf("%d %d %d%n", number, squared + 1, cubed + 1);
            number++;
            printCount += 2;
        }
    }
}
//Accepted and pushed