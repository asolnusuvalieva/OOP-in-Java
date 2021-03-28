import java.util.Scanner;

public class SubtractionQuizLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis(); //obtains the time before the test starts
        final int NUMBER_OF_QS = 5;
        int correct = 0;
        int count = 0;

        int number1;
        int number2;

        int userAnswer;
        String output = "";

        while(count < NUMBER_OF_QS){
            number1 = (int)(Math.random() * 10);
            number2 = (int)(Math.random() * 10);

            /*To swap values to subtract min from max */
            if(number1 < number2){
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }
            System.out.println("What is " + number1 + " - " + number2 + "?");
            userAnswer = scanner.nextInt();

            if(userAnswer == (number1 - number2)){
                correct++;
                System.out.println("You are correct!");
            }else{
                System.out.println("You are wrong! It should've been " + (number1 - number2));
            }

            output += number1 + " - " + number2 + " = " + userAnswer +
                    (userAnswer == number1 - number2 ? " correct\n" : " wrong\n");
            count++;
        }
        long endTime = System.currentTimeMillis();//the time after the test ends
        long difference = endTime - startTime;

        System.out.println("Correct count is " + correct + "\n" + "Test time is " +
                difference/1000 +" seconds" +  "\n" + output); //the time is in milliseconds, so it has to b converted
    }
}
