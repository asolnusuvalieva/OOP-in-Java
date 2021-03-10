import java.util.Scanner;

public class URI1066Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        int evenCount = 0;
        int oddCount = 0;
        int positiveCount = 0;
        int negativeCount = 0;

        for(int i = 1; i <= 5; i++){
            num = scanner.nextInt();
            if(num % 2 == 0){
                evenCount++;
            }else{
                oddCount++;
            }

            if(num > 0){
                positiveCount++;
            }else if(num < 0){
                negativeCount++;
            }
        }

        System.out.println(evenCount + " valor(es) par(es)");
        System.out.println(oddCount + " valor(es) impar(es)");
        System.out.println(positiveCount + " valor(es) positivo(s)");
        System.out.println(negativeCount + " valor(es) negativo(s)");

    }
}

//Accepted and pushed