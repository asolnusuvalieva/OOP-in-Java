import java.util.Scanner;

public class URI1074Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int input;

        for(int i = 0; i < n; i++){
            String answer = "";
            input = scanner.nextInt();
            if(input == 0){
                answer = "NULL";
            }else{
                if(input % 2 == 0){
                    answer += "EVEN ";
                }else{
                    answer += "ODD ";
                }

                if(input > 0){
                    answer += "POSITIVE";
                }else{
                    answer += "NEGATIVE";
                }
            }
            System.out.println(answer);
        }
    }
}
//accepted