import java.util.Scanner;

public class URI1150Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        while(y <= x){
            y = scanner.nextInt();
        }

        int countIntegers = 0;
        int sum = 0;
        while (sum <= y){
            sum += x;
            countIntegers++;
            x++;
        }

        System.out.println(countIntegers);
    }
}//Accepted and pushed
