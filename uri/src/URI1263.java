import java.util.Scanner;
/*
2+ consecutive words which start with the same letter (ignoring case)

Find the number of alliterations (^)
 */
public class URI1263 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] words = line.toLowerCase().split(" ");
            char startingChar = words[0].charAt(0);

            int finalNumberOfAlliterations = 0;
            int lengthCounter = 1; //number of chars in alliteration
            for(int i = 1; i < words.length; i++){
                if(startingChar == words[i].charAt(0)){ //as long as it meets similar chars, we just keep incrementing its length
                    lengthCounter++;
                }else{ //once it meets another char, we calculate the lengthCounter and reset its value
                    if(lengthCounter >= 2){
                        finalNumberOfAlliterations++;
                    }
                    startingChar = words[i].charAt(0);
                    lengthCounter = 1;
                }
            }
            if(lengthCounter >= 2){ //might seem like it makes no sense but there are situations when the line when with many similar chars BUT we increment the finalNumberOfAlliterations only whne it meets another char
                finalNumberOfAlliterations++;
            }
            System.out.println(finalNumberOfAlliterations);
        }
    }
}
//Accepted and pushed