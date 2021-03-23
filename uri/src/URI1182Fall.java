import java.util.Scanner;

public class URI1182Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();
        String s = scanner.next();
        double[][] table = new double[12][12];

        double sum = 0;
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                table[i][j] = scanner.nextDouble();
                if(j == column){
                    sum += table[i][j];
                }
            }
        }

        if(s.equals("S")){
            System.out.printf("%.1f%n", sum);
        }else{
            double average = sum/12;
            System.out.printf("%.1f%n", average);
        }
    }
}
//Accepted and pushed