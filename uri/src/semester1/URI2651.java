package semester1;

import java.util.Scanner;

public class URI2651 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String link = "zelda";

        while (scanner.hasNext()){
            String letter = scanner.next().toLowerCase();

            if(letter.contains(link)){
                System.out.println("Link Bolado");
            }else{
                System.out.println("Link Tranquilo");
            }
        }
    }
}
//Accepted and pushed