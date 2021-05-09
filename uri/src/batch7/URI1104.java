package batch7;

import java.util.Scanner;

/*
Pockemon Cards:
- Each card has a unique identifier

Alice gives Betty N distinct cards and receives back other N distinct cards.
Find the max number of cards they can trade

Solution:
Create two arrays of what each girl can trade.
Choose the min one.
 */
public class URI1104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aliceCardsQ;
        int bettyCardsQ;

        while ((aliceCardsQ = scanner.nextInt()) != 0 && (bettyCardsQ = scanner.nextInt()) != 0){
            String aliceCards = scanner.nextLine();
            String bettyCards = scanner.nextLine();

            System.out.printf("aliceCardsQ is %d, bettyCardsQ  is %d, aliceCards is %s, bettyCards is %s", aliceCardsQ, bettyCardsQ, aliceCards, bettyCards);
        }
    }
}
