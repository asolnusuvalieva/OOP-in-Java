public class SummingElementsByColumn {
    public static void main(String[] args) {
        int[][] example = {
                {2, 3, 4},
                {4, 5, 6},
                {5, 5, 6}
        };
        sumElementsOfColumn(example);
    }

    public static void sumElementsOfColumn (int[][] list){
        for(int column = 0; column < list[0].length; column++){
            int total = 0;
            for(int row = 0; row < list.length; row++){
                total += list[row][column];
            }
            System.out.println("Sum for column " + column + " is "
                    + total);
        }
    }

}
