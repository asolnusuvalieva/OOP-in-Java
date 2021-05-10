package batch7;
import java.util.Scanner;

/*
The real tickets were numbered sequentially from 1 to N (N ≤ 10000)
determine how many tickets in the pack had another ticket with the same sequence number.
 */
public class URI1318 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfOriginalTickets;
        int numberOfPeople;

        while ((numberOfOriginalTickets = scanner.nextInt()) != 0 && (numberOfPeople = scanner.nextInt()) != 0){
            int[] allTickets = new int[numberOfPeople];
            //Initialization of all tickets
            for(int i = 0; i < numberOfPeople; i++){
                allTickets[i] = scanner.nextInt();
            }

            int fakeTickets = 0;
            //Going through the original/unique sequence
            for(int i = 1; i <= numberOfOriginalTickets; i++){
                if(hasDuplicates(i, allTickets))
                    fakeTickets++;
            }

            System.out.println(fakeTickets);
        }
    }

    private static boolean hasDuplicates(int ticket, int[] tickets){
        int duplicates = 0;
        for(int i = 0; i < tickets.length; i++){
            if(tickets[i] == ticket) {
                duplicates++;
            }
        }

        return duplicates > 1;
    }
}

//Accepted