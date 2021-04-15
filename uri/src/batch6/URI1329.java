package batch6;

import java.util.Scanner;

/*
They play Head or Tail with a coin.
Mary always choose Head, and John always choose Tail.

 */
public class URI1329 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases;

        while ((testCases = scanner.nextInt()) != 0){
            int mary = 0;
            int john = 0;

            for(int i = 0; i < testCases; i++){
                int input = scanner.nextInt();
                if(input == 0){
                    mary++;
                }else{
                    john++;
                }
            }

            System.out.printf("Mary won %d times and John won %d times%n", mary, john);
        }
    }
}
//Accepted