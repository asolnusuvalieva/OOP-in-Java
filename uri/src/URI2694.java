import java.util.Scanner;
/*
N lines with exactly 14 characters that must be read
and the three number existing in this line must be extracted and summed.
 */
public class URI2694 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); //TODO:To avoid Scanner misreading

        for(int i = 0; i < testCases; i++){
            String input = scanner.nextLine();
            String[] numbers = {"", "", ""};

            //Going through the input
            int index = -1;
            for(int j = 0; j < input.length(); j++){
                if(!Character.isDigit(input.charAt(j))){
                    if(j < 12 && Character.isDigit(input.charAt(j + 1))){
                        index++;
                    }
                }else{
                    numbers[index] += input.charAt(j);
                }
            }


            System.out.println(sum(numbers));
        }
    }

    public static int sum(String[] numbers){
        int sum = 0;
        for(String num : numbers){
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}

//Accepted and pushed