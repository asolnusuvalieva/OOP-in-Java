import java.util.Scanner;

public class URI1070Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int oddCount = 0;

        while (oddCount != 6){
            if(x % 2 != 0){
                oddCount++;
                System.out.println(x);
            }
            x++;
        }
    }
}
//Accepted and pushed
