import java.util.ArrayList;
import java.util.Scanner;

public class Problem02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(0, 0, 100, 100));
        rectangles.add(new Rectangle(40, 40, 50, 70));

        ArrayList<Circle> circles = new ArrayList<>();
        circles.add(new Circle(100, 200, 20));
        circles.add(new Circle(40, 60, 20));

        while (true){
            System.out.print("x: ");
            int mouseX = scanner.nextInt();
            System.out.print("y: ");
            int mouseY = scanner.nextInt();

            if(mouseX == -1 && mouseY == -1){
                break;
            }

            for(Rectangle rectangle : rectangles){
                if(rectangle.contains(mouseX, mouseY)){
                    System.out.println(rectangle);
                }
            }

            for(Circle circle : circles){
                if(circle.contains(mouseX, mouseY)){
                    System.out.println(circle);
                }
            }
        }
    }
}
