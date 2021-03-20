import java.util.Scanner;

public class URI1180Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        array[0] = scanner.nextInt();
        int minNumber = array[0];
        int minIndex = 0;

        for(int i = 1; i < n; i++){
            int input = scanner.nextInt();
            array[i] = input;
            if(array[i] < minNumber){
                minNumber = array[i];
                minIndex = i;
            }
        }

        System.out.println("Menor valor: " + minNumber);
        System.out.println("Posicao: " + minIndex);
    }
}
//Accepted and pushed