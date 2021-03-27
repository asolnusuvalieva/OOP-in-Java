public class LinearSearch {
    public static int linearSearch(int[] array, int keyElement){
        for(int i = 0; i < array.length; i++){
            if(array[i] == keyElement){
                return i;
            }
        }
        return -1;
    }
}
