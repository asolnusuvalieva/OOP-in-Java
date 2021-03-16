import java.util.Scanner;

public class URI1143Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //number of output lines
        int printCount = 0;
        int number = 1;

        while (printCount != n){
            int squared = (int)Math.pow(number, 2);
            int cubed = (int)Math.pow(number, 3);

            System.out.printf("%d %d %d%n", number, squared, cubed);
            printCount++;
            number++;
        }
    }
}

//accepted and pushed
