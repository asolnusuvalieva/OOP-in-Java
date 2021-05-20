import java.math.BigInteger;
import java.util.Arrays;
public class Problem03 {
    public static void main(String[] args) {
        int[] integers = {
                2, 90, 123, -4, 0, -2
        };
        sortIntegers(integers);

        String[] strings = {
                "Kotlin", "C", "Scala", "C#", "Java", "C++"
        };
        sortStrings(strings);

        //BigInteger also implements Comparable
        BigInteger[] bigIntegers = {
                new BigInteger("90"), new BigInteger("1000"), new BigInteger("-24")
        };

        //Rational also implements Comparable
        Rational[] rationals = {
                Rational.parseRational("7/2"),
                Rational.parseRational("1/2"),
                Rational.parseRational("1/3"),
                Rational.parseRational("5/7"),
                Rational.parseRational("2/3"),
        };
        sortBigIntegers(bigIntegers);
        sortRationals(rationals);

        Student[] students = {
                new Student("StudentB", 3.0f, 2001),
                new Student("StudentD", 2.5f, 1998),
                new Student("StudentC", 3.5f, 2000),
                new Student("StudentA", 4.0f, 2001),
        };
        sortStudentsByName(students);
        sortStudentsByGPA(students);
        sortStudentsByBirthYear(students);
    }

    private static void sortStudentsByName(Student[] students){
        System.out.println("Sorting students by name...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(students));

        MyArrays.sort(students, (first, second) -> first.getName().compareTo(second.getName()));

        System.out.println("After:");
        System.out.println(Arrays.toString(students));
        System.out.println();
    }

    private static void sortStudentsByGPA(Student[] students){
        System.out.println("Sorting students by GPA...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(students));

        MyArrays.sort(students, (first, second) -> {
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

        MyArrays.sort(students, (first, second) -> {
            return Integer.compare(first.getBirthYear(), second.getBirthYear());//int is a primitive type
        });

        System.out.println("After:");
        System.out.println(Arrays.toString(students));
        System.out.println();
    }

    private static void sortIntegers(int[] integers){
        System.out.println("Sorting integers...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(integers));

        MyArrays.sort(integers); // <<

        System.out.println("After:");
        System.out.println(Arrays.toString(integers));

        System.out.println();
    }

    private static void sortStrings(String[] strings){
        System.out.println("Sorting strings...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(strings));

        MyArrays.sort(strings);

        System.out.println("After:");
        System.out.println(Arrays.toString(strings));
        System.out.println();
    }
    private static void sortBigIntegers(BigInteger[] bigIntegers){
        System.out.println("Sorting bigIntegers...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(bigIntegers));

        MyArrays.sort(bigIntegers);

        System.out.println("After:");
        System.out.println(Arrays.toString(bigIntegers));
        System.out.println();
    }

    private static void sortRationals(Rational[] rationals){
        System.out.println("Sorting rationals...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(rationals));

        MyArrays.sort(rationals);

        System.out.println("After:");
        System.out.println(Arrays.toString(rationals));
        System.out.println();
    }
}