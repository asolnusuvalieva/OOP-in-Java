import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the 1'st integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the 2'nd integer: ");
        int num2 = scanner.nextInt();

        int gcd = 1; /*greatest common divisor*/
        int k = 2; /* possible gcd */

        while (k <= num1 && k <= num2){
            if(num1 % k == 0 && num2 % k == 0){
                gcd = k; //upgrade the gcd
            }
            k++; //Next possible gcd
        }
        // After the loop, gcd is the greatest common divisor for n1 and n2

        System.out.print("The greatest common divisor for " + num1 + " and " + num2 + " is " + gcd);
    }
}
