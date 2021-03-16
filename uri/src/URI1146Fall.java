import java.util.Scanner;

public class URI1146Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        while (x != 0){
            for(int i = 1; i <= x; i++){
                if(i == x){
                    System.out.println(i);
                    break;
                }
                System.out.print(i + " ");
            }
            x = scanner.nextInt();
        }
    }
}
//accepted and pushed