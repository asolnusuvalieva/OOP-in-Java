import java.util.Scanner;

public class URI1154Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = scanner.nextInt();
        int sum = 0;
        int people = 0;
        while (age > 0){
            sum += age;
            people++;
            age = scanner.nextInt();
        }

        double average = sum/(people * 1.0);
        System.out.printf("%.2f%n", average);
    }
}//accepted and pushed
