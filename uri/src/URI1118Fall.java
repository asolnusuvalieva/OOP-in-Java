import java.util.Scanner;

public class URI1118Fall {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        average();

        while(true) {
            System.out.println("novo calculo (1-sim 2-nao)");
            int again = scanner.nextInt();
            while (again < 1 || again > 2) {
                System.out.println("novo calculo (1-sim 2-nao)");
                again = scanner.nextInt();
            }

            if (again == 1) {
                average();
            }else{
                break;
            }
        }
    }

    public static void average(){
        double input1 = scanner.nextDouble();

        while (input1 < 0 || input1 > 10){
            System.out.println("nota invalida");
            input1 = scanner.nextDouble();
        }

        double input2 = scanner.nextDouble();
        while (input2 < 0 || input2 > 10){
            System.out.println("nota invalida");
            input2 = scanner.nextDouble();
        }

        double average = (input1 + input2)/2;
        System.out.printf("media = %.2f%n", average);
    }
}
//Accepted and pushed
