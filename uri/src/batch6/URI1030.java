package batch6;
import java.util.ArrayList;
import java.util.Scanner;
//Print who remained 'alive'
//каждый второй или каждый X

/*
Solution:
Having a dynamic array, each time I kill, they get removed
 */
public class URI1030 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNextInt()){
            int testCases = scanner.nextInt();

            for(int testCase = 1; testCase <= testCases; testCase++){
                int numberOfPeople = scanner.nextInt(); //n
                int steps = scanner.nextInt(); //k

                ArrayList<Integer> peopleNumbers = new ArrayList<>();

                //Initializing it by assigning numbers
                for(int i = 1; i <= numberOfPeople; i++){
                    peopleNumbers.add(i);
                }

                int index = 0;
                for(int person = 0; person < numberOfPeople - 1; person++){
                    for(int step = 1; step < steps; step++){
                        index++;

                        if(index == peopleNumbers.size())
                            index = 0;
                    }

                    peopleNumbers.remove(index);
                    if(index == peopleNumbers.size())
                        index = 0;
                }

                int personNumber = peopleNumbers.get(0);
                System.out.printf("Case %d: %d%n", testCase, personNumber);
            }
        }
    }
}
//Accepted
