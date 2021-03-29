public class TheLargestSumOfRow {
    public static void main(String[] args) {
        int[][] list = {
                {2, 3, 4},
                {4, 5, 6}
        };

        whichRowHasTheLargestSum(list);
    }

    public static void whichRowHasTheLargestSum(int[][] list){
        int maxRowIndex = 0;
        int maxSum = 0;

        for(int j = 0; j < list[0].length; j++){
            maxSum += list[0][j];
        }

        for(int i = 1; i < list.length; i++){
            int currentSum = 0;
            for(int j = 0; j < list[i].length; j++){
                currentSum += list[i][j];
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
                maxRowIndex = i;
            }
        }

        System.out.println("Row " + maxRowIndex + " has the largest sum, " + maxSum);
    }
}
