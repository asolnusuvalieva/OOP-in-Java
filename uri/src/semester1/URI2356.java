package semester1;

import java.util.Scanner;

/*
Question: If bacteria resistant or not?
- DNA
- Part of the genetic code
 */
public class URI2356 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String DNA = scanner.nextLine();
            String resistanceGeneticCode = scanner.nextLine();

            if(DNA.contains(resistanceGeneticCode)){
                System.out.println("Resistente");
            }else{
                System.out.println("Nao resistente");
            }
        }
    }
}
//Accepted and pushed