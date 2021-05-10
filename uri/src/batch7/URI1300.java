package batch7;
import java.util.Scanner;
/*
The minute hand moves from its current mark to the next mark once every minute.
The hour hand moves from its current mark to the next mark once every 12 minutes

Note that when the minute hand moves, the hour hand may not move;
however, when the hour hand moves, the minute hand also moves.

Input:
A (0 ≤ A ≤ 180) representing the angle to be checked.
Output:
'Y' or 'N' depending on If there exists at least one time of the day
such that the minimum angle between the two hands of the clock is exactly A degrees

Минутная стрелка: Каждую минуту на 6°
Часовая стрелка: Каждые 12 минут на 6°
 */
public class URI1300 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int degree = scanner.nextInt();
            int degreePerMinute = 360/60; //6°

            int minsHand = 0;
            int hoursHand = 0;
            boolean degreeFound = false;

            for(int min = 0; min < 720; min++){
                minsHand += degreePerMinute;

                if(min % 12 == 0)
                    hoursHand += degreePerMinute;

                if(Math.max(minsHand, hoursHand) - Math.min(minsHand, hoursHand) == degree){
                    degreeFound = true;
                    break;
                }
            }

            if(degreeFound)
                System.out.println('Y');
            else
                System.out.println('N');
        }
    }
}
//Accepted