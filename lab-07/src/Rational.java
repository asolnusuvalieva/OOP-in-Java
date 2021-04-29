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

    Rational add(Rational other){
        return new Rational(
                numerator.multiply(other.denominator).add(other.numerator.multiply(denominator)),
                denominator.multiply(other.denominator));
    }

    Rational subtract(Rational other){
        return new Rational(
                numerator.multiply(other.denominator).subtract(other.numerator.multiply(denominator)),
                denominator.multiply(other.denominator));
    }

    Rational multiply(Rational other){
        return new Rational(numerator.multiply(other.numerator),
                denominator.multiply(other.denominator)); //Making it immutable
    }

    Rational divide(Rational other){
        return new Rational(numerator.multiply(other.denominator),
                denominator.multiply(other.numerator)); //Making it immutable
    }

    public String toString(){
        return denominator.equals(BigInteger.ONE) ? numerator.toString() : numerator + "/" + denominator;
    }

    public int compareTo(Rational other){
        return numerator.multiply(other.denominator).compareTo(denominator.multiply(other.numerator));
        /*
        They just have the same denominator, using the same trick that we used for subtraction/addition
         */
        /*
        Integer.compare():
        the value 0 if this Integer is equal to the argument Integer;
        a value less than 0 if this Integer is numerically less than the argument Integer;
        and a value greater than 0 if this Integer is numerically greater than the argument Integer
         */
    }
}
