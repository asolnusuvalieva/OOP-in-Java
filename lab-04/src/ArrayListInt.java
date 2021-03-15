/*
Naive Solution
 */
public class ArrayListInt {
    private int[] data;

    ArrayListInt(){
        data = new int[0];
    }

    int size(){
        return data.length;
    }

    int get(int index){
        return data[index]; //Java itself will raise Errors in case of incorrect input
    }
    void set(int index, int value){
        data[index] = value; //Java itself will raise Errors in case of incorrect input
    }

    void add(int value){ //Appending
        int[] temp = new int[data.length + 1];

        //Copying old values to the new array
        for(int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }
        temp[temp.length - 1] = value;
        data = temp;
    }

    void add(int index, int value){ //Inserting
        if(index < 0 || index >= data.length){
            throw new IndexOutOfBoundsException("Invalid index of insertion!");
        }

        int[] temp = new int[data.length + 1];

        for(int d = 0, t = 0; d < data.length; d++, t++){
            if(t == index){
                t++;
            }
            temp[t] = data[d];
        }
        temp[index] = value;

        data = temp;
    }
    void remove(int index){
        if(index < 0 || index >= data.length){
            throw new IndexOutOfBoundsException("Invalid index of removal!");
        }

        int[] temp = new int[data.length - 1];
        for(int d = 0, t = 0; d < data.length; d++, t++){
            if(d == index){
                d++;
            }
            temp[t] = data[d];
        }

        data = temp;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("[");

        for(int i = 0; i < data.length; i++){
            result.append(data[i]).append((i != data.length - 1 ? ", " : "]"));
        }

        return result.toString();
    }
}
