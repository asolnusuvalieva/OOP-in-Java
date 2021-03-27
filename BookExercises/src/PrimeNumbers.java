public class PrimeNumbers {
    public static void main(String[] args) {
        int NUMBER_OF_PRIME_NUMBERS = 50;
        int count = 0;
        int number = 2;

        System.out.println("The first 50 prime numbers are \n");
        while (count < NUMBER_OF_PRIME_NUMBERS){
            boolean isPrime = true; //it should be inside of the while loop bc this boolean value is new foe each new number

            /*Check if the value is prime or not */
            for(int divisor = 2; divisor <= number/2; divisor++){
                if(number % divisor == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                count++;
                if(count % 10 == 0){
                    System.out.println(number); //advance the cursor to a new line
                }else{
                    System.out.print(number + " ");
                }
            }
            number++;
        }
    }
}
