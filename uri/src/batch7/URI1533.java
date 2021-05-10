package batch7;
import java.util.Arrays;
import java.util.Scanner;

/*
The secret is “It is never the most suspicious, but the second most suspicious”.

 */
public class URI1533 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople;

        while ((numberOfPeople = scanner.nextInt()) != 0){
            int[] levelsOfSuspicion = new int[numberOfPeople];
            int[] originalArraySequence = new int[numberOfPeople];

            //Initialization
            for(int i = 0; i < numberOfPeople; i++){
                levelsOfSuspicion[i] = scanner.nextInt();
                originalArraySequence[i] = levelsOfSuspicion[i];
            }

            //Sorting the array
            Arrays.sort(levelsOfSuspicion); //в порядке возрастания
            int killer = levelsOfSuspicion.length - 2; //предпоследний
            System.out.println(indexOf(levelsOfSuspicion[killer], originalArraySequence));
        }
    }

    private static int indexOf(int killer, int[] originalArraySequence){
        int index = -1; //-1 is a default answer, it will never be reached

        for(int i = 0; i < originalArraySequence.length; i++){
            if(originalArraySequence[i] == killer){
                index = i + 1;
                break;
            }
        }

        return index;
    }
}
//Accepted