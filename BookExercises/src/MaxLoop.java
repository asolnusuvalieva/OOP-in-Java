import java.util.Scanner;

public class MaxLoop { //2 3 4 5 0
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number, max;
        number = input.nextInt();
        max = number;
        while (number != 0) {
            number = input.nextInt();
            if (number > max)
                max = number;
        }

        System.out.println("max is " + max); //5
        System.out.println("number " + number); //0
    }
}

