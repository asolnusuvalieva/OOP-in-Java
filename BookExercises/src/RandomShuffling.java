//Shuffling is randomly reordering the elements in an array
//for each element myList[i], randomly generate an index j and swap myList[i] with myList[j]
public class RandomShuffling {
    public static void main(String[] args) {
        double[] myList = {1, 5, 3, 4, 5, 5};

        for(int i = myList.length - 1; i > 0; i--){
            // Generate an index j randomly with 0 <= j <= i
            int j = (int)(Math.random() * (i + 1));

            // Swap myList[i] with myList[j]
            double temp = myList[i];
            myList[i] = myList[j];
            myList[j] = temp;
        }
    }
}
