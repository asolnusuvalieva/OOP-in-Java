package semester1;

import java.util.Scanner;
/*
print out the list of students who did not attend to enough classes
and will be denied to sit for exams.

Attendance Record: ‘A’, ‘P’ and ‘M’ characters.
A - absent
P - present
M - A Doctor's Note (not counted)
 */
public class URI1277 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "\\s+$";
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine(); //TODO: To avoid Scanner misreading
            String[] studentsNames = scanner.nextLine().split(" ");
            String[] attendanceRecords = scanner.nextLine().split(" ");
            String listOfStudentsNames = "";

            //Working with each student
            for(int j = 0; j < numberOfStudents; j++){
                if(isAttendanceLower75(attendanceRecords[j])){
                    listOfStudentsNames += studentsNames[j] + " ";
                }
            }
            System.out.println(listOfStudentsNames.replaceAll(regex, ""));
        }
    }

    public static boolean isAttendanceLower75(String record){
        int presentCount = 0;
        int medicalCount = 0;

        for(int i = 0; i < record.length(); i++){
            if(record.charAt(i) == 'P'){
                presentCount++;
            }else if(record.charAt(i) == 'M'){
                medicalCount++;
            }
        }

        double result = (presentCount * 100.0) / (record.length() - medicalCount);

        return result < 75;
    }
}
//Accepted and pushed