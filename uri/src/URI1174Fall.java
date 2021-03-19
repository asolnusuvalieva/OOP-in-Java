import java.util.Scanner;

public class URI1174Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] list = new double[100];

        for(int i = 0; i < list.length; i++){
            list[i] = scanner.nextDouble();
            if(list[i] <= 10){
                System.out.printf("A[%d] = %.1f%n", i, list[i]);
            }
        }
    }
}
//Accepted and Pushed