package batch6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
Input: positive and integer numbers (1 <= X <= 2000)

Output:
1) Write each distinct value in an ascending order
2) Print how many times each distinct value appears
 */
public class URI1171 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbersQuantity = scanner.nextInt();
        int[] numbersRepetition = new int[2000];
        int[] inputNumbers = new int[numbersQuantity];

        for(int i = 0; i < numbersQuantity; i++){
            int input = scanner.nextInt();
            numbersRepetition[input - 1]++;
            inputNumbers[i] = input;
        }

        Arrays.sort(inputNumbers);
        boolean[] werePrinted = new boolean[2000];
        //Printing
        for(int i = 0; i < inputNumbers.length; i++){
            int inputNumber = inputNumbers[i];
            int itsRepetition = numbersRepetition[inputNumber - 1];

            if(!werePrinted[inputNumber - 1]){
                System.out.printf("%d aparece %d vez(es)%n", inputNumber, itsRepetition);
                werePrinted[inputNumber - 1] = true;
            }
        }
    }
}

//Accepted