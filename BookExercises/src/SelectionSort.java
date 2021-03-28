/*
Selection sort finds the smallest number in the list and swaps it with the first element.
Then finds the next smallest number remaining and swaps it with the second element
...
until only a single number remains
 */

public class SelectionSort {

    public static void selectionSort(int[] list){
        for(int i = 0; i < list.length - 1; i++){
            int currentMin = list[i];
            int currentMinIndex = i;

            for(int j = i + 1; j < list.length; j++){
                if(list[j] < currentMin){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if(currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}
