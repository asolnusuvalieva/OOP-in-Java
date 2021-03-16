import java.util.Scanner;

public class URI1134Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int alcool = 0;
        int gasolina = 0;
        int diesel = 0;


        int code = scanner.nextInt();

        while (code != 4){
            if(code == 1){
                alcool++;
            }else if(code == 2){
                gasolina++;
            }else if(code == 3){
                diesel++;
            }
            code = scanner.nextInt();
        }

        System.out.println("MUITO OBRIGADO");
        System.out.println("Alcool: " + alcool);
        System.out.println("Gasolina: " + gasolina);
        System.out.println("Diesel: " + diesel);
    }
}
//ACCEPTED and Pushed