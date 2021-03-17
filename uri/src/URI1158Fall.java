import java.util.Scanner;

public class URI1158Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int sum = 0;
            int oddNumbersCount = 0;
            while (oddNumbersCount != y){
                if(x % 2 != 0){
                    sum += x;
                    oddNumbersCount++;
                }
                x++;
            }
            System.out.println(sum);
        }
    }
}//Accepted and pushed
