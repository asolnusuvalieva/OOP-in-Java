import java.util.Scanner;

public class URI1235 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); //just to avoid an incorrect scanner reading

        for(int i = 0; i < testCases; i++){
            String gibberish = scanner.nextLine();
            int n = gibberish.length() / 2; //11
            String half1 = "";
            String half2 = "";

            for(int h1 = n - 1; h1 >= 0; h1--){
                half1 += gibberish.charAt(h1);
            }

            for(int h2 = gibberish.length() - 1; h2 >= n; h2--){
                half2 += gibberish.charAt(h2);
            }
            System.out.println(half1 + half2);
        }
    }
}
