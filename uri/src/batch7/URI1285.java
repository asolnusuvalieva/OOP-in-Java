package batch7;

import java.util.Scanner;

/*
A number with a repeated digit (e.g. 838, 1004)

Input:
N and M (1 ≤ N ≤ M ≤ 5000)

Find the max number of houses that can be assigned street numbers between N and M, inclusive,
that do not have repeated digits.
 */
public class URI1285 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int maxNumberOfH = 0;

            for(int i = n; i <= m; i++){
                if(hasUniqueDigits(i))
                    maxNumberOfH++;
            }
            System.out.println(maxNumberOfH);
        }
    }

    private static boolean hasUniqueDigits(int number){
        //Determine if the number has unique digits (e.g. 4999)

        boolean hasUniqueDigits = true;
        String sNumber = String.valueOf(number);

        for(int i = 0; i < sNumber.length(); i++){
            for(int j = i + 1; j < sNumber.length(); j++){
                if(sNumber.charAt(i) == sNumber.charAt(j)) {
                    hasUniqueDigits = false;
                    break;
                }
            }

            if(!hasUniqueDigits)
                break;
        }

        return hasUniqueDigits;
    }
}

//Accepted