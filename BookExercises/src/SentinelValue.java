import java.util.Scanner;

public class SentinelValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.print("Enter an integer (the input ends if it is 0): ");
        int input = scanner.nextInt();

        while (input != 0){
            sum += input;
            System.out.print("Enter an integer (the input ends if it is 0): ");
            input = scanner.nextInt();
        }
        System.out.println("The sum is " + sum);

    }
}
/*
Rewriting this code using do-while:
 do{
    System.out.print("Enter an integer (the input ends if it is 0): ");
    input = scanner.nextInt();
    sum += input;
    }while (input != 0);

    System.out.println("The sum is " + sum);
 */