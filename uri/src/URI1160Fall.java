import java.util.Scanner;

/*
A < B
City A: population, growing rate
City B: population, growing rate
 */
public class URI1160Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            int populationA = scanner.nextInt();
            int populationB = scanner.nextInt();
            double growingRateA = scanner.nextDouble();
            double growingRateB = scanner.nextDouble();
            int years = 0;

            while (populationA <= populationB){
                int toAddA = (int)(growingRateA/100 * populationA);
                populationA += toAddA;

                int toAddB = (int)(growingRateB/100 * populationB);
                populationB += toAddB;
                years++;
            }

            if(years > 100){
                System.out.println("Mais de 1 seculo.");
            }else{
                System.out.println(years + " anos.");
            }
        }
    }
}//Accepted and pushed
