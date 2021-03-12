import java.text.DecimalFormat;
public class URI1098Fall {
    public static void main(String[] args) {
        for(double i = 0; i <= 2.0; i+= 0.2){
            for (double j = 1; j <= 3; j++){
                String strI = new DecimalFormat("#.#").format(i);
                String strJ = new DecimalFormat("#.#").format(i + j);
                System.out.printf("I=%s J=%s%n", strI, strJ);
            }
        }
    }
}
//accepted