import java.math.BigInteger;
import java.util.Scanner;
/*
There are two exceptions I have:
- ArithmeticException (when denominator == 0)
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculator of Rational Numbers");

        printUserMessage();
        while (scanner.hasNext()) {
            String rationalInput = scanner.next();
            Rational rational;
            try {
                rational = Rational.parseRational(rationalInput);
            } catch (NumberFormatException e) { //Error when casting to BigInteger
                System.out.println(e.getMessage());

                printUserMessage();
                continue;
            } catch (ArithmeticException e) { //Error when denominator == 0
                System.out.println(e.getMessage());

                printUserMessage();
                continue;
            }

            System.out.print("Enter the operator: ");
            String operator = scanner.next();
            if(!contains(operator)){
                System.out.println("Incorrect operator: " + operator);

                printUserMessage();
                continue;
            }

            System.out.print("Enter the second rational (press Ctrl-Z to exit): ");
            String otherRationalInput = scanner.next();
            Rational other;
            try {
                other = Rational.parseRational(otherRationalInput);
            } catch (NumberFormatException e) { //Error when casting to BigInteger
                System.out.println(e.getMessage());

                printUserMessage();
                continue;
            } catch (ArithmeticException e) { //Error when denominator == 0
                System.out.println(e.getMessage());

                printUserMessage();
                continue;
            }

            int answer = rational.compareTo(other);
            boolean isTrue = false; //-1, 0, 1

            Rational result = new Rational(BigInteger.ONE, BigInteger.ONE); //It's just to avoid compilations error
            switch(operator){
                case "+":
                    result = rational.add(other);
                    break;
                case "-":
                    result = rational.subtract(other);
                    break;
                case "*":
                    result = rational.multiply(other);
                    break;
                case "/":
                    result = rational.divide(other);
                    break;
                case "<":
                    if(answer < 0)
                        isTrue = true;
                    break;
                case ">":
                    if(answer > 0)
                        isTrue = true;
                    break;
                case ">=":
                    if(answer >= 0)
                        isTrue = true;
                    break;
                case "<=":
                    if(answer <= 0)
                        isTrue = true;
                    break;
                case "=":
                    if(answer == 0)
                        isTrue = true;
                case "!=":
                    if(answer != 0)
                        isTrue = true;
                default:
                    System.out.println("The operator " + operator + " is incorrect!");

                    printUserMessage();
                    continue;
            }

            if(operator.equals("*") || operator.equals("/") || operator.equals("-") || operator.equals("+")){
                System.out.printf("Result: %s %s %s = %s%n", rational, operator, other, result);
            }else {
                System.out.printf("Result: %s %s %s: %s%n", rational, operator, other, isTrue ? "true" : "false");
            }
            printUserMessage();
        }
    }

    public static void printUserMessage(){
        System.out.print("Enter the first rational (press Ctrl-Z to exit): ");
    }
    public static boolean contains(String operator){
        String[] operators = {"*", "/", "-" , "+" , ">", "<", ">=", "<=", "=", "!="};
        boolean contains = false;
        for(String correctOperator : operators){
            if(correctOperator.equals(operator)){
                contains = true;
                break;
            }
        }

        return contains;
    }
}

/*
Remaining:
- Starting the loop from the beginning when the 2nd rational or operator are not correct
 */