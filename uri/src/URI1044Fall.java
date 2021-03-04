import java.util.Scanner;

//URI 1044
public class URI1044Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if(b % a == 0 || a % b == 0){
            System.out.println("Sao Multiplos");
        }else{
            System.out.println("Nao sao Multiplos");
        }

    }
}
//accepted