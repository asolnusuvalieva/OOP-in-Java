import java.util.Scanner;

/*
Failure of a machine in one and only one numerical digit (as if it was not pressed at all).
For example, if the failed digit in the machine is 5, an agreed value of 1500
would be represented in the corresponding contract as 100

GOAL: the numeric value represented in the contract
 */
public class URI1120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String failedDigit = scanner.next();
        String agreedValue = scanner.next();

        while (!failedDigit.equals("0") && !agreedValue.equals("0")){
            String output = "";
            for(int i = 0; i < agreedValue.length(); i++){
                if(agreedValue.charAt(i) != failedDigit.charAt(0)){
                    output += agreedValue.charAt(i);
                }
            }
            if(output.isEmpty()){
                output = "0";
                System.out.println(output);
            }else{
                String formattedOutput = output.replaceFirst("^0+(?!$)", "");
                System.out.println(formattedOutput);
            }

            //Updating failedDigit and agreedValue
            failedDigit = scanner.next();
            agreedValue = scanner.next();
        }
    }
}
//Accepted and pushed