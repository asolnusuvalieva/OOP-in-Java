/*
The problem is to create a program that will randomly select four cards from a deck of 52 cards.
All the cards can be represented using an array named deck, filled with initial values 0 to 51
 */
public class DeckOfCards {
    public static void main(String[] args) {
        int[] deck = new int[52];
        String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        //initialize the cards
        for(int i = 0; i < 52; i++){
            deck[i] = i;
        } //{0, 1, 2, 3, ..., 51}

        //Shuffle the cards
        for(int i = 0; i < 52; i++){
            //Generate an index randomly
            int index= (int)(Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        } //{4, 7, 24, ..., 34} now, they are randomly placed

        //display the first 4 cards
        for(int i = 0; i < 4; i++){
            int cardNumber = deck[i];
            String suit = suits[cardNumber/13];
            String rank = ranks[cardNumber%13]; //остаток всегда меньше делителя
            System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);
        }
    }
}
