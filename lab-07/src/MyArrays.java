import java.util.Comparator;
interface MyComparable<T>{
    int compareTo(T object);
}

interface MyComparator<T>{
    int compare(T first, T second);
}

class MyArrays{//an analogy to Arrays class

    @SuppressWarnings("unchecked")
    public static <T> void sort(Comparable<? super T>[] comparableObjects) { //any class that implements comparable
        //Selection sort
        for(int i = 0; i < comparableObjects.length - 1; i++){
            Comparable currentMin = comparableObjects[i];
            int currentMinIndex = i;

            for(int j = i + 1; j < comparableObjects.length; j++){
                if(comparableObjects[j].compareTo((T)currentMin) < 0){ //if smth is even less min
                    currentMin = comparableObjects[j];
                    currentMinIndex = j;
                }
            }

            if(currentMinIndex != i){ //Swap their places
                comparableObjects[currentMinIndex] = comparableObjects[i];
                comparableObjects[i] = currentMin;
            }
        }
    }

    public static <T> void sort(MyComparable<? super T>[] comparableObjects) { //any class that implements comparable
        //Selection sort
        for(int i = 0; i < comparableObjects.length - 1; i++){
            MyComparable currentMin = comparableObjects[i];
            int currentMinIndex = i;

            for(int j = i + 1; j < comparableObjects.length; j++){
                if(comparableObjects[j].compareTo((T)currentMin) < 0){ //if smth is even less min
                    currentMin = comparableObjects[j];
                    currentMinIndex = j;
                }
            }

            if(currentMinIndex != i){ //Swap their places
                comparableObjects[currentMinIndex] = comparableObjects[i];
                comparableObjects[i] = currentMin;
            }
        }
    }

    public static <T> void sort(T[] objects, MyComparator<? super T> comparator) { //any class that implements comparable
        //Selection sort
        for(int i = 0; i < objects.length - 1; i++){
            int currentMinIndex = i;

            for(int j = i + 1; j < objects.length; j++){
                if(comparator.compare(objects[j], objects[currentMinIndex]) < 0){ //if smth is even less min
                    currentMinIndex = j;
                }
            }

            if(currentMinIndex != i){ //Swap their places
                T temp = objects[currentMinIndex];
                objects[currentMinIndex] = objects[i];
                objects[i] = temp;
            }
        }
    }

    //For primitive data types, you have to make a unique method
    public static void sort(int[] integers) {
        //Selection sort
        for(int i = 0; i < integers.length - 1; i++){
            int currentMin = integers[i];
            int currentMinIndex = i;

            for(int j = i + 1; j < integers.length; j++){
                if(integers[j] < currentMin){ //if smth is even less min
                    currentMin = integers[j];
                    currentMinIndex = j;
                }
            }

            if(currentMinIndex != i){ //Swap their places
                integers[currentMinIndex] = integers[i];
                integers[i] = currentMin;
            }
        }
    }
}