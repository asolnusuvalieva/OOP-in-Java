import java.util.Scanner;

//A Prime Number is a number that is divisible only by 1 (one) and by itself.
public class URI1165Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            int input = scanner.nextInt();
            boolean isPrime = true;
            for(int divisor = 2; divisor <= input/2; divisor++){
                if(input % divisor == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(input + " eh primo");
            }else{
                System.out.println(input + " nao eh primo");
            }
        }
    }
}
//Accepted and pushed
