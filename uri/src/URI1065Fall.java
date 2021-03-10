import java.util.Scanner;

public class URI1065Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int countEven = 0;
        for(int i = 1; i <= 5; i++){
            num = scanner.nextInt();
            if(num % 2 == 0){
                countEven++;
            }
        }
        System.out.println(countEven + " valores pares");
    }
}
//Accepted and pushed
