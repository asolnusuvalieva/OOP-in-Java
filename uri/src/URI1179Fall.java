import java.util.Scanner;

public class URI1179Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] par = new int[5];
        int indexPar = 0;

        int[] impar = new int[5];
        int indexImpar = 0;

        for(int i = 0; i < 15; i++){
            int input = scanner.nextInt();
            if(input % 2 == 0){
                par[indexPar] = input;
                indexPar++;

                if(indexPar >= par.length){
                    printEven(par, par.length);
                    indexPar = 0;
                }
            }else{
                impar[indexImpar] = input;
                indexImpar++;
                if(indexImpar >= impar.length){
                    printOdd(impar, impar.length);
                    indexImpar = 0;
                }
            }
        }

        printOdd(impar, indexImpar);
        printEven(par, indexPar);
    }

    public static void printEven(int[] array, int count){
        for(int i = 0; i < count; i++){
            System.out.printf("par[%d] = %d%n", i, array[i]);
        }
    }

    public static void printOdd(int[] array, int count){
        for(int i = 0; i < count; i++){
            System.out.printf("impar[%d] = %d%n", i, array[i]);
        }
    }
}
