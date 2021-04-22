package batch6;
import java.util.Scanner;
/*
determine how many peaks exist in her musical loop
 */
public class URI1089 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPoints;
        while ((numberOfPoints = scanner.nextInt()) != 0){
            int[] points = new int[numberOfPoints];
            //Initialization
            for(int i = 0; i < numberOfPoints; i++){
                points[i] = scanner.nextInt();
            }

            int peaks = 2; //by default, one at the start, the 2nd is at the end

            for(int i = 1; i < points.length - 1; i++){
                int currentPoint = points[i];
                int previousPoint = points[i - 1];
                int nextPoint = points[i + 1];
                if(currentPoint > previousPoint && currentPoint > nextPoint
                        || currentPoint < previousPoint && currentPoint < nextPoint){
                    peaks++;
                }
            }
            if(peaks % 2 == 1)
                peaks -= 1;

            System.out.println(peaks);
        }
    }
}
//Accepted
