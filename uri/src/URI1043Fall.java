import java.util.Scanner;
//URI 1043
//The sum of any two sides should be more than the third side.

public class URI1043Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        if (a + b > c
                && a + c > b
                && b + c > a){
            double perimeter = a + b + c;
            System.out.printf("Perimetro = %.1f%n",perimeter);
        }else{
            double area = c*(a + b)/2;
            System.out.printf("Area = %.1f%n", area);
        }

    }
}
//accepted