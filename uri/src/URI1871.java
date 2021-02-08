import java.util.Scanner;

public class URI1871 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        while(number1 != 0 && number2 != 0){
            int sum = number1 + number2;
            String stringSum = String.valueOf(sum);
            String formattedStringSum = stringSum.replaceAll("0", "");
            System.out.println(formattedStringSum);

            //Updating number1 and number2
            number1 = scanner.nextInt();
            number2 = scanner.nextInt();
        }
    }
}
//Accepted
