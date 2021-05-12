package batch7;
import java.util.Arrays;
import java.util.Scanner;
/*
Each sheep is identified by a unique integer.
Output the number of distinct ones.
 */
public class URI1609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        for(int i = 0; i < tests; i++){
            int numberOfSheep = scanner.nextInt();

            int[] sheepIdentifiers = new int[numberOfSheep];

            //Initialization
            for(int j = 0; j < numberOfSheep; j++){
                int input = scanner.nextInt();
                sheepIdentifiers[j] = input;
            }

            if(numberOfSheep == 1){ //If sheep is only 1, then only 1 unique sheep
                System.out.println(1);
                continue;
            }

            Arrays.sort(sheepIdentifiers);
            int distinctSheep = 0;
            int startingSheep = sheepIdentifiers[0];


            for(int j = 1; j < numberOfSheep; j++){
                int currentSheep = sheepIdentifiers[j];
                if(currentSheep != startingSheep){
                    distinctSheep++;
                    startingSheep = currentSheep;
                }

                if(j == (numberOfSheep - 1)){
                    distinctSheep++;
                }
            }

            System.out.println(distinctSheep);
        }
    }
}
//Accepted