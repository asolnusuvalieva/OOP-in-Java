
import java.util.Scanner;

public class URI1051Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double salary = scanner.nextDouble();
        salary -= 2000.0;
        double taxPayment = 0;

        if (salary > 0.0){
            double part = salary > 1000.0 ? 1000.0 : salary;
            taxPayment += part * 0.08;

            salary -= 1000.0;
            if (salary > 0.0){
                part = salary > 1500.0 ? 1500.0 : salary;
                taxPayment += part * 0.18;

                salary -= 1500.0;
                if (salary > 0.0){
                    taxPayment += salary * 0.28;
                }
            }

            System.out.printf("R$ %.2f%n", taxPayment);
        }else{
            System.out.println("Isento");
        }

    }
}
//accepted