import java.util.Scanner;

public class URI1073Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 1; i <= n; i++){
            if(i % 2 == 0){
                System.out.printf("%d^2 = %d%n", i, i*i);
            }
        }
    }
}
//accepted