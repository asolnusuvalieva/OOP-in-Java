package batch7;
import java.util.Scanner;
/*
When the emitter is turned on when moving, a specific width layer is removed from the block.
In each step, a layer with 1 mm of width is removed.
 */
public class URI1107 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height;
        int length;

        while ((height = scanner.nextInt()) != 0 && (length = scanner.nextInt()) != 0){
            int[] finalHeights = new int[length];


            for(int i = 0; i < length; i++){
                int finalHeight = scanner.nextInt();
                finalHeights[i] = finalHeight;
            }

            int timesToTurnOn = 0;

            for(int h = height; h >= 1; h--){ //Starting from the top
                boolean laserOn = false;

                //Considering one layer at a time
                for(int l = 0; l < length; l++){
                    if(finalHeights[l] < h){
                        laserOn = true;
                    }else{
                        if(laserOn){ //if the laser was on before
                            timesToTurnOn++;
                            laserOn = false;
                        }
                    }
                }
            }
            System.out.println(timesToTurnOn);
        }
    }
}
