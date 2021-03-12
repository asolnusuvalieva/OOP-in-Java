import java.util.Scanner;

public class URI1101Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m;
        int n;

        while (true){
            int sum = 0;
            m = scanner.nextInt();
            n = scanner.nextInt();
            if (m <= 0 || n <= 0){
                break;
            }else{
                //swapping values
                if(m > n){
                    int temp = m;
                    m = n;
                    n = temp;
                }

                for(int i = m; i <= n; i++){
                    sum += i;
                    System.out.print(i + " ");
                }
                System.out.println("Sum=" + sum);
            }
        }
    }
}
//accepted
