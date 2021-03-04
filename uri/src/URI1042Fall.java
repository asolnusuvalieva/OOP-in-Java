import java.util.Scanner;

//URI 1042
public class URI1042Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        int max1;
        int max2;
        int max3;

        if (num1 > num2){
            if (num3 > num1){
                max1 = num3;
                max2 = num1;
                max3 = num2;
            }else{
                max1 = num1;
                max2 = Math.max(num2, num3);
                max3 = Math.min(num2, num3);
            }
        }else{
            if(num3 > num2){
                max1 = num3;
                max2 = num2;
                max3 = num1;
            }else{
                max1 = num2;
                max2 = Math.max(num1, num3);
                max3 = Math.min(num1, num3);
            }
        }

        System.out.println(max3 + "\n" + max2 + "\n" + max1);
        System.out.println();
        System.out.println(num1 + "\n" + num2 + "\n" + num3);
    }
}
//accepted