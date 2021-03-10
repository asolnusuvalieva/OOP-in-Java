import java.util.Scanner;

public class URI1072Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //n times to read
        int x;
        int in = 0;
        int out = 0;

        for(int i = 1; i <= n; i++){
            x = scanner.nextInt();
            if(x >= 10 && x <= 20){
                in++;
            }else{
                out++;
            }
        }

        System.out.println(in + " in" + "\n" + out + " out");
    }
}

//accepted