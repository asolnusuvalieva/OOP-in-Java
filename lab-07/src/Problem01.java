import java.math.BigInteger;
import java.util.Arrays;

public class Problem01 {
    public static void main(String[] args) {
        int[] integers = {
             2, 90, 123, -4, 0, -2
        };

        String[] strings = {
                "Kotlin", "C", "Scala", "C#", "Java", "C++"
        };

        BigInteger[] bigIntegers = {
                new BigInteger("90"), new BigInteger("1000"), new BigInteger("-24")
        };

        Rational[] rationals = {
                Rational.parseRational("7/2"),
                Rational.parseRational("1/2"),
                Rational.parseRational("1/3"),
                Rational.parseRational("5/7"),
                Rational.parseRational("2/3"),
        };

        sortIntegers(integers);
        sortStrings(strings);
        sortBigIntegers(bigIntegers);
        sortRationals(rationals);
    }

    private static void sortIntegers(int[] integers){
        System.out.println("Sorting integers...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(integers));

        Arrays.sort(integers);

        System.out.println("After:");
        System.out.println(Arrays.toString(integers));

        System.out.println();
    }

    private static void sortStrings(String[] strings){
        System.out.println("Sorting strings...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(strings));

        Arrays.sort(strings);

        System.out.println("After:");
        System.out.println(Arrays.toString(strings));
        System.out.println();
    }

    private static void sortBigIntegers(BigInteger[] bigIntegers){
        System.out.println("Sorting bigIntegers...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(bigIntegers));

        Arrays.sort(bigIntegers);

        System.out.println("After:");
        System.out.println(Arrays.toString(bigIntegers));
        System.out.println();
    }

    private static void sortRationals(Rational[] rationals){
        System.out.println("Sorting rationals...");

        System.out.println("Before:");
        System.out.println(Arrays.toString(rationals));

        Arrays.sort(rationals);

        System.out.println("After:");
        System.out.println(Arrays.toString(rationals));
        System.out.println();
    }
}
