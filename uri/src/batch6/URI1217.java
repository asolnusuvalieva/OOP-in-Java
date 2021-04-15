package batch6;

import java.util.Scanner;
/*
calculate the consumption of fruit + the amount spent per day on these fruits.
 */
public class URI1217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int numberOfDays = scanner.nextInt();

            double totalMoneySpent = 0;
            int totalFruitsKGs = 0;

            for(int i = 1; i <= numberOfDays; i++){
                double money = scanner.nextDouble();
                scanner.nextLine(); //TODO: to avoid scanner misreading

                String stringOfFruits = scanner.nextLine();
                int fruitsKGs = stringOfFruits.split(" ").length;

                System.out.printf("day %d: %d kg%n", i, fruitsKGs);
                totalMoneySpent += money;
                totalFruitsKGs += fruitsKGs;
            }

            double moneyPerDay = totalMoneySpent/numberOfDays;
            double kgPerDay = totalFruitsKGs * 1.0 /numberOfDays;

            System.out.printf("%.2f kg by day%n", kgPerDay);
            System.out.printf("R$ %.2f by day%n", moneyPerDay);
        }
    }
}
//Accepted