package batch6;

import java.util.Arrays;
import java.util.Scanner;

/*
Pairs of boots of various sizes.
 */
public class URI1245 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            int numberOfIndividualBoots = scanner.nextInt();

            //Initialization
            Boot[] boots = new Boot[numberOfIndividualBoots];
            for(int boot = 0; boot < numberOfIndividualBoots; boot++){
                int bootSize = scanner.nextInt();
                String foot = scanner.next();
                boots[boot] = new Boot(bootSize, foot);
            }

            //Sorting
            Arrays.sort(boots);

            int pairs = 0;
            boolean[] isPairFound = new boolean[numberOfIndividualBoots];

            for(int i = 0; i < boots.length; i++){
                if(!isPairFound[i]){
                    int currentBootSize = boots[i].bootSize;
                    String currentFoot = boots[i].foot;

                    for(int j = i + 1; j < boots.length; j++){
                        if(!isPairFound[j] && boots[j].bootSize == currentBootSize && !boots[j].foot.equals(currentFoot)){
                            //same size different foot
                            isPairFound[i] = true;
                            isPairFound[j] = true;
                            pairs++;
                            break;
                        }
                    }
                }
            }
            System.out.println(pairs);
        }
    }
}

class Boot implements Comparable<Boot>{
    int bootSize;
    String foot; //D or E

    Boot(int bootSize, String foot){
        this.foot = foot;
        this.bootSize = bootSize;
    }

    public int compareTo(Boot boot){
        return (this.bootSize - boot.bootSize);
    }
}
