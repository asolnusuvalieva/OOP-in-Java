import java.util.Scanner;

public class URI1159Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        while (x != 0){
            int sum = 0;
            int evenCount = 0;
            while (evenCount != 5){
                if(x % 2 == 0){
                    sum += x;
                    evenCount++;
                }
                x++;
            }
            System.out.println(sum);
            x = scanner.nextInt();
        }
    }
}//Accepted and pushed
