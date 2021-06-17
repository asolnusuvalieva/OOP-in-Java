package batch7;
import java.util.Scanner;
/*
    - Each can have repeating cards
    - Each has to give cards that other doesn't have
 */
public class URI1104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aliceCardsQ;
        int bettyCardsQ;

        while ((aliceCardsQ = scanner.nextInt()) != 0 && (bettyCardsQ = scanner.nextInt()) != 0) {
            scanner.nextLine(); //TODO: To avoid scanner misreading

            int[] aliceCards = new int[aliceCardsQ];
            int aliceDistinctCards = 1;

            //Initialization for Alice Cards
            aliceCards[0] = scanner.nextInt();
            for(int i = 1; i < aliceCardsQ; i++){
                int card = scanner.nextInt();
                if(!contains(card, aliceCards, aliceDistinctCards)){
                    aliceCards[aliceDistinctCards] = card;
                    aliceDistinctCards++;
                }
            }

            scanner.nextLine(); //TODO: To avoid scanner misreading

            int[] bettyCards = new int[bettyCardsQ];
            int bettyDistinctCards = 1;

            //Initialization for Alice Cards
            bettyCards[0] = scanner.nextInt();
            for(int i = 1; i < bettyCardsQ; i++){
                int card = scanner.nextInt();
                if(!contains(card, bettyCards, bettyDistinctCards)){
                    bettyCards[bettyDistinctCards] = card;
                    bettyDistinctCards++;
                }
            }

            int aliceCanTrade = 0;
            int bettyCanTrade = 0;

            for(int i = 0; i < aliceDistinctCards; i++){
                int aliceCurrentCard = aliceCards[i];
                if(!contains(aliceCurrentCard, bettyCards, bettyDistinctCards)){
                    aliceCanTrade++;
                }
            }

            for(int i = 0; i < bettyDistinctCards; i++){
                int bettyCurrentCard = bettyCards[i];
                if(!contains(bettyCurrentCard, aliceCards, aliceDistinctCards)){
                    bettyCanTrade++;
                }
            }

            System.out.println(Math.min(aliceCanTrade, bettyCanTrade));
        }
    }

    private static boolean contains(int card, int[] cards, int distinctNOfCards){
        boolean contains = false;

        for(int i = 0; i < distinctNOfCards; i++){
            if(cards[i] == card){
                contains = true;
                break;
            }
        }

        return contains;
    }
}
//Accepted