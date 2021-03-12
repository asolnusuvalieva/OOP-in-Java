import java.util.Scanner;

public class URI1113Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x;
        int y;
        while (true){
            x = scanner.nextInt();
            y = scanner.nextInt();
            if(x == y){
                break;
            }
            if(x < y){
                System.out.println("Crescente");
            }else{
                System.out.println("Decrescente");
            }
        }
    }
}
//accepted
