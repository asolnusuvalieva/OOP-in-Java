import java.util.Scanner;

public class URI1188 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        double[][] table = new double[12][12];
        double sum = 0;
        double count = 0;

        for(int i = 0; i < table.length; i++) {
            int diagonalIndexStart = table[i].length - i;
            int diagonalIndexEnd = table[i].length - diagonalIndexStart;
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = scanner.nextDouble();

                if(i >= 7 && j >= diagonalIndexStart && j < diagonalIndexEnd){
                    sum += table[i][j];
                    count++;
                }
            }
        }

        if(s.equals("S")){
            System.out.printf("%.1f%n", sum);
        }else{
            double average = sum/count;
            System.out.printf("%.1f%n", average);
        }
    }
}
//Accepted and pushed