public class URI1155Fall {
    public static void main(String[] args) {
        double sum = 0;

        for(int i = 1; i <= 100; i++){
            sum += 1.0/i;
        }
        System.out.printf("%.2f%n", sum);
    }
}//accepted and pushed