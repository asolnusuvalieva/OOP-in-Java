public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {67, 78};
        int key = 50;
        int index = binarySearch(numbers, key);

        System.out.println(index);
    }

    public static int binarySearch(int[] list, int key){
        int low = 0;
        int high = list.length - 1;

        while (high >= low){
            int mid = (low + high)/2;
            if(key < list[mid]){
                high = mid - 1;
            }else if(key == list[mid]){
                return mid;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
