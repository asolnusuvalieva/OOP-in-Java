import java.util.ArrayList;
import java.util.Scanner;

public class Problem04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(0, 0, 100, 100));
        shapes.add(new Rectangle(40, 40, 50, 70));

        shapes.add(new Circle(100, 200, 20));
        shapes.add(new Circle(40, 60, 20));

        boolean shouldStop = false;
        while (!shouldStop){
            System.out.print("cmd: ");
            String cmd = scanner.next().trim().toLowerCase(); //just for the flexibility and safety
            switch (cmd){
                case "click":
                    System.out.print("x: ");
                    int mouseX = scanner.nextInt();
                    System.out.print("y: ");
                    int mouseY = scanner.nextInt();
                    for(Shape shape : shapes){
                        if(shape.contains(mouseX, mouseY)){
                            System.out.println(shape);
                        }
                    }
                    break;
                case "move":
                    System.out.print("x1: ");
                    int x1 = scanner.nextInt();
                    System.out.print("y1: ");
                    int y1 = scanner.nextInt();
                    System.out.print("x2: ");
                    int x2 = scanner.nextInt();
                    System.out.print("y1: ");
                    int y2 = scanner.nextInt();
                    //Move only if x1, y1 is inside
                    for(Shape shape : shapes){
                        if(shape.contains(x1, y1)){
                            shape.move(x2, y2);
                        }
                    }
                    break;
                case "present":
                    /* Just print all the shapes */
                    for(Shape shape : shapes){
                        System.out.println(shape);
                    }
                    break;
                case "stop":
                    shouldStop = true;
                    break;
                default:
                    System.out.println("Invalid Command. Try again.");
            }
        }
    }
}


