import java.util.Scanner;

/*
Total
Number of each animals
Percentage of each animals
 */
public class URI1094Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfExperiments = scanner.nextInt();
        int numberOfAnimals;
        String animalType;

        int total = 0;
        int rabbits = 0;
        int rats = 0;
        int frogs = 0;

        for(int i = 0; i < numberOfExperiments; i++){
            numberOfAnimals = scanner.nextInt();
            animalType = scanner.next();
            total += numberOfAnimals;

            if(animalType.equals("C")){
                rabbits += numberOfAnimals;
            }else if(animalType.equals("R")){
                rats += numberOfAnimals;
            }else{
                frogs += numberOfAnimals;
            }
        }

        System.out.println("Total: " + total+ " cobaias");
        System.out.println("Total de coelhos: " + rabbits);
        System.out.println("Total de ratos: " + rats);
        System.out.println("Total de sapos: " + frogs);

        float rabbitPercentage = 1f * rabbits / total * 100;
        float ratsPercentage =  1f * rats / total * 100;
        float frogsPercentage = 1f * frogs / total * 100;
        System.out.printf("Percentual de coelhos: %.2f", rabbitPercentage);
        System.out.print(" %\n");
        System.out.printf("Percentual de ratos: %.2f", ratsPercentage);
        System.out.print(" %\n");
        System.out.printf("Percentual de sapos: %.2f", frogsPercentage);
        System.out.print(" %\n");
    }
}
//accepted