import java.util.Scanner;

public class URI1060Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num;
        int countPositive = 0;
        for(int i = 0; i < 6; i++) {
            num = scanner.nextDouble();
            if(num > 0){
                countPositive++;
            }
        }
        System.out.println(countPositive + " valores positivos");
    }
}
//accepted