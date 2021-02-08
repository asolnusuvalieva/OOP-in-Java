import java.util.Scanner;

public class URI1241 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            String a = scanner.next();
            String b = scanner.next();

            if(b.length() > a.length()){
                System.out.println("nao encaixa");
                continue; //go to the next case
            }

            int count = a.length() - b.length();
            boolean isSuccessful = true;
            for(int j = count, n = 0; j < a.length(); j++, n++){
                if(a.charAt(j) != b.charAt(n)){
                    System.out.println("nao encaixa");
                    isSuccessful = false;
                    break;
                }
            }
            if (isSuccessful){
                System.out.println("encaixa");
            }
        }
    }
}
//Accepted and pushed