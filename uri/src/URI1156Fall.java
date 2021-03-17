public class URI1156Fall {
    public static void main(String[] args) {
        double s = 0;
        double j = 1.0;

        for(int i = 1; i <= 39; i += 2){
            s += i/j;
            j *= 2;
        }
        System.out.printf("%.2f%n", s);
    }
}//accepted and pushed
