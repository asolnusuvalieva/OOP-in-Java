import java.util.Scanner;

public class Dec2Hex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int decimal = scanner.nextInt();

        String hex = "";

        while (decimal != 0){
            int hexValue = decimal % 16;
            char hexDigit = (hexValue <= 9 && hexValue >= 0) ? (char)(hexValue + '0') : (char)(hexValue - 10 + 'A');
            hex = hex + hexDigit;

            decimal = decimal / 16;
        }

        System.out.println("The hex number is " + hex);
    }
}
