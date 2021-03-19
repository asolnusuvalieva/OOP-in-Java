import java.util.Scanner;

public class URI1172Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputs = new int[10];

        for(int i = 0; i < inputs.length; i++){
            int input = scanner.nextInt();;
            if(input <= 0){
                input = 1;
            }
            inputs[i] = input;
            System.out.printf("X[%d] = %d%n", i, inputs[i]);
        }
    }
}
//Accepted and Pushed
