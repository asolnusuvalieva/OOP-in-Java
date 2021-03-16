import java.util.Scanner;

public class URI1149Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int n = scanner.nextInt();

        while (n <= 0){
            n = scanner.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += a;
            a++;
        }

        System.out.println(sum);
    }
}//ACCEPTED and pushed
