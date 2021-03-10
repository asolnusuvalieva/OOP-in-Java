import java.util.Scanner;

public class URI1064Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num;
        int countPositive = 0;
        double sumOfPositiveN = 0;

        for(int i = 0; i < 6; i++) {
            num = scanner.nextDouble();
            if(num > 0){
                countPositive++;
                sumOfPositiveN += num;
            }
        }

        double average = sumOfPositiveN / countPositive;
        System.out.println(countPositive + " valores positivos");
        System.out.printf("%.1f%n", average);
    }
}
//Accepted and pushed