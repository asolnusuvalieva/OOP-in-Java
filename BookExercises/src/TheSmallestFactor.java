import java.util.Scanner;

public class TheSmallestFactor {
    public static void main(String[] args) {
        int factor = 2;
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
/*
        while (factor <= number){
            if(number % factor == 0){
                break;
            }
            factor++;
        }

 */
        boolean found = false;
        while (factor <= number && !found){
            if(number % factor == 0){
                found = true;
            }else{
                factor++;
            }
            /*
            Если убрать else, то логика условия будет правильной, но зато к factor добавится ненужный 1.
             */
        }

        System.out.println("The smallest factor other than 1 for " + number + " is " + factor);
    }
}
