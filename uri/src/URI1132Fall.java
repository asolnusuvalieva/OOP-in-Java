import java.util.Scanner;
public class URI1132Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if(x > y){
            int temp = x;
            x = y;
            y = temp;
        }

        int sum = 0;
        for(int i = x; i <= y; i++){
            if(i % 13 != 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
//ACCEPTED Pushed