import java.util.Scanner;

public class URI1177Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] numbers = new int[1000];

        int index = 0;

        while (index < numbers.length){
            for(int i = 0; i < t; i++){
                numbers[index] = i;
                System.out.printf("N[%d] = %d%n", index, numbers[index]);
                index++;
                if(index >= numbers.length){
                    break;
                }
            }
        }
    }
}
