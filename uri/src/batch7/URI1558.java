package batch7;
import java.util.Scanner;
/*

 */
public class URI1558 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean isSquare = false;
            int n = scanner.nextInt();
            if (n == 1 || n == 2 || n == 0) {
                isSquare = true;
            }
            if (!isSquare) {
                int j = (int) Math.sqrt(n);
                int i = 0;
                while (j >= i) {
                    int sqI = i * i;
                    int sqJ = j * j;
                    int s = sqI + sqJ;

                    if (s == n) {
                        isSquare = true;
                        break;
                    } else if (s < n) {
                        i++;
                    } else j--;
                }
            }
            if (isSquare) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
}
