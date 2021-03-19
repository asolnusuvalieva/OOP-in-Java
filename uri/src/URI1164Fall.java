import java.util.Scanner;

public class URI1164Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            int x = scanner.nextInt();

            int sumOfDivisors = 0;
            for(int j = 1; j < x; j++){
                if(x % j == 0){
                    sumOfDivisors += j;
                }
            }
            if(sumOfDivisors == x){
                System.out.println(x + " eh perfeito");
            }else{
                System.out.println(x + " nao eh perfeito");
            }
        }
    }
}//Accepted and pushed
