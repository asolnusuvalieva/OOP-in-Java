import java.util.Scanner;
public class URI1145Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int number = 1;

        while (number <= y){
            for(int i = 1; i < x; i++){
                System.out.print(number + " ");
                number++;
            }
            System.out.println(number);
            number++;
        }
    }
}//Accepted and pushed
