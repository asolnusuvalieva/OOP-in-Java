public class Rational {
    private int numerator;
    private int denominator;

    Rational(int numerator, int denominator){
        if(denominator == 0){
            throw new IllegalArgumentException("The denominator can not be zero (0)!"); //it stops this method
        }

        int gcd = MathUtilities.gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;

        //Keeping "-" sign only on one place
        if(denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    //Making the original Rational immutable

    Rational add(Rational other){
        return new Rational(numerator * other.denominator + other.numerator*denominator, denominator * other.denominator);
    }

    Rational sub(Rational other){
        return new Rational(numerator * other.denominator - other.numerator*denominator, denominator * other.denominator);
    }
    Rational mul(Rational other){
        return new Rational(numerator * other.numerator,
                denominator * other.denominator); //Making it immutable
    }

    Rational div(Rational other){
        return new Rational(numerator * other.denominator,
                denominator * other.numerator); //Making it immutable
    }

    public String toString(){
        return numerator + "/" + denominator;
    }
}

