import java.util.Scanner;

public class URI1099Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x;
        int y;


        //1 2 3 4 5
        for(int i = 0; i < n; i++){
            x = scanner.nextInt();
            y = scanner.nextInt();
            if(x > y){
                int temp = y;
                y = x;
                x = temp;
            }
            int sum = 0;

            x++; //to make it ()
            for (int h = x; h < y; h++){
                if(h % 2 != 0){
                    sum += h;
                }
            }
            System.out.println(sum);
        }
    }
}
//accepted