import java.util.Scanner;
public class URI1117Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input1 = scanner.nextDouble();

        while(input1 < 0 || input1 > 10){
            System.out.println("nota invalida");
            input1 = scanner.nextDouble();
        }

        double input2 = scanner.nextDouble();

        while(input2 < 0 || input2 > 10){
            System.out.println("nota invalida");
            input2 = scanner.nextDouble();
        }

        double average = (input1 + input2)/2;
        System.out.printf("media = %.2f%n", average);
    }
}

//accepted and pushed