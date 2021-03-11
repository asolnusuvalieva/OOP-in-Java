import java.util.Scanner;

public class URI1079Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //number of test cases
        int weight1 = 2;
        int weight2 = 3;
        int weight3 = 5;

        float grade1;
        float grade2;
        float grade3;


        for(int i = 0; i < n; i++) {
            float weightedAverage = 0;
            grade1 = scanner.nextFloat();
            grade2 = scanner.nextFloat();
            grade3 = scanner.nextFloat();

            weightedAverage = (grade1*weight1 + grade2*weight2 + grade3*weight3) / 10;
            System.out.printf("%.1f%n", weightedAverage);
        }
    }
}
//accepted