import java.util.Scanner;
//calculate and print the sum or average of all elements within the green area
// according to the case.
public class URI1181Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        String s = scanner.next();
        double[][] table = new double[12][12];
        double sum = 0;

        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                table[i][j] = scanner.nextDouble();
                if(i == l){
                    sum += table[i][j];
                }
            }
        }

        if(s.equals("S")){
            System.out.printf("%.1f%n", sum);
        }else{
            double average = sum/table[l].length;
            System.out.printf("%.1f%n", average);
        }
    }
}
//Accepted and pushed
