import java.util.Scanner;

public class FindNearestPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int numberOfPoints = scanner.nextInt();
        double[][] points = new double[numberOfPoints][2]; //each point has 2 coordinates

        System.out.print("Enter " + numberOfPoints + " points: ");
        for(int i = 0; i < points.length; i++){
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        int point1 = 0, point2 = 1; //initial two points
        double shortestDistance = distance(points[point1][0], points[point1][1], points[point2][0], points[point2][1]);

        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                double x1 = points[i][0];
                double y1 = points[i][1];
                double x2 = points[j][0];
                double y2 = points[j][1];
                double currentDistance = distance(x1, y1, x2, y2);
                if(currentDistance < shortestDistance){
                    shortestDistance = currentDistance;
                    point1 = i;
                    point2 = j;
                }
            }
        }
        System.out.println("The closest two points are "+
                "(" + points[point1][0] + ", " + points[point1][1] + ") and (" + points[point2][0] + ", " + points[point2][1] + ")");

    }


    public static double distance (double x1, double y1, double x2, double y2){
        double x = x2 - x1;
        double y = y2 - y1;
        return Math.sqrt(x*x + y*y);
    }
}
