import java.math.BigInteger;

public class Rational implements Comparable<Rational>{
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

    //Converting String into Rational
    static Rational parseRational(String input){
        Rational result;
        int index = input.indexOf('/'); //if the search is failed, it'll return -1
        try{
            if(index == -1){
                //"42" -> 42/1
                result = new Rational(new BigInteger(input), BigInteger.ONE);
            }else{
                //"1/2" -> 1/2
                BigInteger numerator = new BigInteger(input.substring(0, index));
                BigInteger denominator = new BigInteger(input.substring(index + 1));
                result = new Rational(numerator, denominator);
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("Incorrect rational: " + input + "'");//Rethrowing an error with a better message
            //This class doesn't handle anything
        }

        return result;
    }
}
