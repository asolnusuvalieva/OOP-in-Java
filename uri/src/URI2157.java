import java.util.Scanner;
/*Time limit issue*/
public class URI2157 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            int startNum = scanner.nextInt();
            int endNum = scanner.nextInt();
            String[] sequence = new String[endNum - startNum + 1];
            int index = 0;

            //Creating a sequence from startNum to endNum
            for(int j = startNum; j <= endNum; j++){
                sequence[index] = String.valueOf(j);
                index++;
            }

            //Creating a mirror sequence
            String stringSequence = String.join("", sequence);
            System.out.println(stringSequence + reverse(stringSequence));
        }
    }

    public static String reverse(String s){
        char[] chars = s.toCharArray();

        for(int i = 0, j = chars.length - 1; i < j ; i++, j--){ //e.g. 454647 : 746454
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return new String(chars);
    }
}
//Accepted and pushed