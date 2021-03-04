import java.util.Scanner;
//Format - 24
public class URI1046Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int hours = 0;

        if (end > start){
            hours = end - start;
        }else{
            hours = 24 - start + end;
        }

        System.out.printf("O JOGO DUROU %s HORA(S)%n", hours);
    }
}
//Accepted