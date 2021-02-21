import java.util.Scanner;
//Error Handling
public class Problem02 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Month: ");
        int month = scanner.nextInt();

        System.out.print("Year: ");
        int year = scanner.nextInt();
        try {
            int days = getDaysInMonth(year, month);
            System.out.println("Days: " + days);
        }catch (Exception error){
            System.err.println(error.getMessage());
        }
    }

    private static int getDaysInMonth(int year, int month) throws Exception{ //I am not handling the error here, so just you know that Yes, it throws an error
        int[] days = {
                0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 //the range of correct values are [28, 31]
        };

        if(month >= 1 && month <= 12){
            int output = days[month];
            if(month == 2 && isLeapYear(year)){
                output++;
            }
            return output;
        }else{
            throw new Exception("Invalid Month");
        }
    }

    private static boolean isLeapYear(int year){
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0; 
    }
}
