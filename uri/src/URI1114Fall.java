import java.util.Scanner;

public class URI1114Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long password = 2002;
        long userInput = scanner.nextLong();

        while (password != userInput){
            System.out.println("Senha Invalida");
            userInput = scanner.nextLong();
        }

        System.out.println("Acesso Permitido");
    }
}
//accepted