import java.util.Scanner;

//URI 1045
public class URI1045Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double longest = 0;
        double mid = 0;
        double small = 0;

        if (a > b){
            if (c > a){
                longest = c;
                mid = a;
                small = b;

            }else{
                longest = a;
                mid = Math.max(c, b);
                small = Math.min(c, b);
            }
        }else{
            if(c > b){
                longest = c;
                mid = b;
                small = a;
            }else{
                longest = b;
                mid = Math.max(a, c);
                small = Math.min(a, c);
            }
        }

        a = longest;
        b = mid;
        c = small;


        if(a >= b + c){
            System.out.println("NAO FORMA TRIANGULO");
        } else if (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)){
            System.out.println("TRIANGULO RETANGULO");
        }else if(Math.pow(a, 2) > Math.pow(b, 2) + Math.pow(c, 2)){
            System.out.println("TRIANGULO OBTUSANGULO");
        }else if (Math.pow(a, 2) < Math.pow(b, 2) + Math.pow(c, 2)){
            System.out.println("TRIANGULO ACUTANGULO");
        }

        if(a == b && b == c) {
            System.out.println("TRIANGULO EQUILATERO");
        }else if ((a == b && c != b) || (a == c && b != c) || (c == b && a != b)){
            System.out.println("TRIANGULO ISOSCELES");
        }

    }
}

//accepted
