package semester1;

import java.util.Scanner;
/*
Round Up if the fractional part is 0.5 or greater
Round Down if the fractional part is less than 0.5

Input:
num
cutoff ("0.####", where each '#' represents a digit ('0'-'9'))

Your task is to round num up if its fractional part is greater than cutoff, and down otherwise,
and return the result as an int.

Various types of input:
- Whole part
.235 (0.235)
00003.235 (3.235)

- Fractional Part
235. (235.0)
 */
public class URI1305 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        while (scanner.hasNextLine()){
            String num = scanner.nextLine();
            String cutoff = scanner.nextLine();

            int numWholePart;
            double numFractionalPart;
            double doubleCutoff = Double.parseDouble(cutoff); //always be successful

            int indexOfDecimalPoint = num.indexOf('.');
            if(indexOfDecimalPoint != -1){
                numWholePart = (indexOfDecimalPoint == 0 ? 0 : Integer.parseInt(num.substring(0, indexOfDecimalPoint)));
                numFractionalPart = Double.parseDouble("0" + num.substring(indexOfDecimalPoint));
            }else{
                numWholePart = Integer.parseInt(num);
                numFractionalPart = 0;
            }

            if(numFractionalPart > doubleCutoff){
                numWholePart++;
            }
            System.out.println(numWholePart);
        }
    }
}
//Accepted and pushed