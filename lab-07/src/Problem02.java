import java.util.Arrays;
import java.util.Comparator;

class Student{
    private final String name;
    private final float gpa;
    private final int birthYear;

    Student(String name, float gpa, int birthYear) {
        this.name = name;
        this.gpa = gpa;
        this.birthYear = birthYear;
    }

    String getName() {
        return name;
    }

    float getGPA() {
        return gpa;
    }

    int getBirthYear() {
        return birthYear;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                ", birthYear=" + birthYear +
                '}';
    }
}

public class Problem02 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("StudentA", 4.0f, 2001),
                new Student("StudentB", 3.0f, 2001),
                new Student("StudentC", 3.5f, 2000),
                new Student("StudentD", 2.5f, 1998)
        };

        sortStudentsByName(students);
        sortStudentsByGPA(students);
        sortStudentsByBirthYear(students);
    }


    private static void sortStudentsByName(Student[] students){
        System.out.println("Sorting students by name...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(students));


        Arrays.sort(students, (first, second) -> first.getName().compareTo(second.getName()));

        System.out.println("After:");
        System.out.println(Arrays.toString(students));
        System.out.println();
    }

    private static void sortStudentsByGPA(Student[] students){
        System.out.println("Sorting students by GPA...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, (first, second) -> {
            return Float.compare(first.getGPA(), second.getGPA()); //float is a primitive type
        });

        System.out.println("After:");
        System.out.println(Arrays.toString(students));
        System.out.println();
    }

    private static void sortStudentsByBirthYear(Student[] students){
        System.out.println("Sorting students by birth year...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, (first, second) -> {
            return Integer.compare(first.getBirthYear(), second.getBirthYear());//int is a primitive type
        });

        System.out.println("After:");
        System.out.println(Arrays.toString(students));
        System.out.println();
    }
}
/*
sort(T[] a, Comparator<? super T> c) that accepts two arguments...
It sorts the specified array of objects
according to the order induced by the specified comparator.
 */