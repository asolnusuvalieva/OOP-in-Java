import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        int number = (int)(Math.random() * 101);

        Scanner scanner = new Scanner(System.in);
        int guess = -1;

        while (guess != number){
            System.out.print("Please, enter your guess: ");
            guess = scanner.nextInt();
            if(guess == number){
                System.out.println("Yes, you got it right!");
            }else if(guess > number){
                System.out.println("Your guess is too high.");
            }else{
                System.out.println("Your guess is too low.");
            }
        }
    }
}
