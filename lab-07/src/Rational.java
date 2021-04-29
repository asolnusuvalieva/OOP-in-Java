import java.math.BigInteger;

public class Rational {
    private final BigInteger numerator;
    private final BigInteger denominator;

    Rational(BigInteger numerator, BigInteger denominator){
        if(denominator.equals(BigInteger.ZERO)){
            throw new ArithmeticException("The denominator can not be zero (0)!"); //it stops this method
        }

        //Reducing the rational number
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        //Keeping "-" sign only in numerator
        if(denominator.compareTo(BigInteger.ZERO) < 0){
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
