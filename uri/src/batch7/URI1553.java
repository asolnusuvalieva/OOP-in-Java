package batch7;
import java.util.Scanner;
/*
Questions have identifiers
The question is frequent when k times

Find the number of FAQs
 */
public class URI1553 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfQs;
        int frequentK;

        while ((numberOfQs = scanner.nextInt()) != 0 && (frequentK = scanner.nextInt()) != 0){
            int[] allQsIdentifiersFrequency = new int[1000];

            //Initialization question identifiers
            for(int i = 0; i < numberOfQs; i++){
                int input = scanner.nextInt();
                allQsIdentifiersFrequency[input - 1]++;
            }

            int FAQ = 0;
            for(int i = 0; i < allQsIdentifiersFrequency.length; i++){
                if(allQsIdentifiersFrequency[i] >= frequentK)
                    FAQ++;
            }

            System.out.println(FAQ);
        }
    }
}
//Accepted