import java.util.Scanner;

public class URI1116Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double x;
        double y;

        for(int i = 0; i < n; i++){
            x = scanner.nextDouble();
            y = scanner.nextDouble();

            if(y != 0){
                double result = x/y;
                System.out.printf("%.1f%n", result);
            }else{
                System.out.println("divisao impossivel");
            }
        }

    }
}
//accepted
//PUSHED