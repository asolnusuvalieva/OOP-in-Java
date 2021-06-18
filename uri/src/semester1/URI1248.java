package semester1;

import java.util.Scanner;
/*
1 character -> 1 Food

You also know what you have eaten for breakfast and lunch
Remaining food for dinner (sorted in an alphabetical order)

Cheating: eating too much of one type of food, or by eating some food that is not in the dietPlan
 */
public class URI1248 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); //TODO: To avoid scanner misreading

        for(int i = 0; i < testCases; i++){
            String diet = scanner.nextLine();
            String breakfast = scanner.nextLine();
            String lunch = scanner.nextLine();

            int[] mealCounters = new int[26];
            //Going through the alphabet
            for(char meal : diet.toCharArray()){
                mealCounters[meal - 'A']++;
            }

            for(char breakfastMeal : breakfast.toCharArray()){
                mealCounters[breakfastMeal - 'A']--;
            }

            for(char lunchMeal : lunch.toCharArray()){
                mealCounters[lunchMeal - 'A']--;
            }
            //Eating too much of one type of food is negative
            //Eating some food that is not in the dietPlan is also negative

            boolean hasCheated = false;
            for(int counter : mealCounters){
                if(counter < 0){
                    hasCheated = true;
                    break;
                }
            }

            if(hasCheated){
                System.out.println("CHEATER");
            }else{
                for(int j = 0; j < mealCounters.length; j++){
                    if(mealCounters[j] > 0){
                        System.out.print((char)(j + 'A'));
                    }
                }
                System.out.println();//Just going to another line
            }
        }
    }
}
//Accepted and pushed