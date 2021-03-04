import java.util.Scanner;

//URI 1041
public class URI1041Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        String q = "";
        if (x == 0 && y == 0){
            q = "Origem";
        }else if (x > 0 && y > 0){
            q = "Q1";
        }else if (x < 0 && y > 0){
            q = "Q2";
        }else if (x < 0 && y < 0){
            q = "Q3";
        }else if (x > 0 && y < 0){
            q = "Q4";
        }else if (y == 0 && (x > 0 || x < 0)){
            q = "Eixo X";
        }else{
            q = "Eixo Y";
        }

        System.out.println(q);
    }
}
//accepted