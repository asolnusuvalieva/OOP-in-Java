import java.util.Scanner;
public class URI1080Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int max = 0;
        int position = 0;

        for(int i = 1; i<=100; i++){
            number = scanner.nextInt();
            if(i == 1) {
                max = number;
            }
            if(number > max){
                max = number;
                position = i;
            }
        }

        System.out.println(max);
        System.out.println(position);
    }
}
//accepted
