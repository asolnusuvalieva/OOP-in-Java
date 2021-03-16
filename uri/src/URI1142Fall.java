import java.util.Scanner;

public class URI1142Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int printCount = 0;
        int num = 1;
        int newLine = 0;
        String s = "PUM";

        while(printCount != n){
            System.out.print(num + " ");
            num++;
            newLine++;
            if(newLine % 3 == 0){
                System.out.println(s);
                printCount++;
                num += 1;
            }
        }
    }
}
//ACCEPTED and Pushed