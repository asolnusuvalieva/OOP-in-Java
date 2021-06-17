package batch6;

import java.util.Scanner;
public class URI1218 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 1;
        while (scanner.hasNextInt()){
            int searchSize = scanner.nextInt();
            scanner.nextLine(); //TODO: To avoid scanner misreading
            String[] parts = scanner.nextLine().split(" ");

            int totalNumberOfPairs = 0;
            int f = 0;
            int m = 0;

            for(int i = 0; i < parts.length; i++){
                if(i % 2 == 0 && Integer.parseInt(parts[i]) == searchSize){ //sizes
                    totalNumberOfPairs++;
                    int index = i + 1;
                    if(parts[index].equals(String.valueOf('F'))){
                        f++;
                    }else{
                        m++;
                    }
                }
            }

            if(n != 1){
                System.out.println(); //Print a blank line between the outputs for two consecutive test cases.
            }

            System.out.printf("Caso %d:%n", n);
            System.out.printf("Pares Iguais: %d%n", totalNumberOfPairs);
            System.out.printf("F: %d%n", f);
            System.out.println("M: " + m);

            n++; //updating the label
        }
    }
}
//Accepted