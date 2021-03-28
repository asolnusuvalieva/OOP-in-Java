//Sometimes you need to shift the elements left or right.
//Shift elements one position to the left and fill the last element with the first element
public class ShiftingElements {
    public static void main(String[] args) {
        double[] myList = {1, 5, 3, 4, 5, 5};
        double temp = myList[0]; //retain the first element

        for(int i = 1; i < myList.length; i++){
            myList[i-1] = myList[i];
        }
// Move the first element to fill in the last position
        myList[myList.length - 1] = temp;
    }
}
