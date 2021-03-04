import java.util.Scanner;

public class URI1048Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double oldSalary = scanner.nextDouble();
        double newSalary = oldSalary;
        String persentage = "";
        double moneyEarned = 0;

        if (oldSalary > 2000){
            moneyEarned = oldSalary * 0.04;
            newSalary += moneyEarned;
            persentage = "4 %";
        }else if (oldSalary >= 1200.01 && oldSalary <= 2000){
            moneyEarned = oldSalary * 0.07;
            newSalary += moneyEarned;
            persentage = "7 %";
        }else if (oldSalary >= 800.01 && oldSalary <= 1200){
            moneyEarned = oldSalary * 0.1;
            newSalary += moneyEarned;
            persentage = "10 %";
        }else if (oldSalary >= 400.01 && oldSalary <= 800){
            moneyEarned = oldSalary * 0.12;
            newSalary += moneyEarned;
            persentage = "12 %";
        }else if (oldSalary > 0 && oldSalary <= 400){
            moneyEarned = oldSalary * 0.15;
            newSalary += moneyEarned;
            persentage = "15 %";
        }

        System.out.printf("Novo salario: %.2f%n", newSalary);
        System.out.printf("Reajuste ganho: %.2f%n", moneyEarned);
        System.out.println("Em percentual: " + persentage);
    }
}
//accepted