import java.util.Scanner;

public class URI1071Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int sumOfOddValues = 0;

        if(y < x){
            int temp = y;
            y = x;
            x = temp;
        }

        for(int i = x + 1; i < y; i++){
            if(i % 2 != 0){
                sumOfOddValues += i;
            }
        }

        System.out.println(sumOfOddValues);
    }
}
//accepted