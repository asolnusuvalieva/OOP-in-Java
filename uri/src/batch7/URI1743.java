package batch7;

import java.util.Scanner;

/*
An in-line connector is composed of five connection points, labelled from 1 to 5.
Each connection point of a connector can be either a plug (🔌) or an outlet (🕳).

Check the compatibility of two connectors!
two connectors are compatible if, for every label,
one connection point is a plug and the other connection point is an outlet
 */
public class URI1743 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int[] connector1 = new int[5]; //0 is outlet, 1 is a plug
            int[] connector2 = new int[5];

            //Initialization
            for(int i = 0; i < connector1.length; i++){
                connector1[i] = scanner.nextInt();
            }

            //Initialization
            for(int i = 0; i < connector2.length; i++){
                connector2[i] = scanner.nextInt();
            }

            boolean compatible = true;

            for(int i = 0; i < 5; i++){
                if(connector1[i] == connector2[i]){
                    compatible = false;
                    break;
                }
            }

            if(compatible)
                System.out.println('Y');
            else
                System.out.println('N');
        }
    }
}

//Accepted