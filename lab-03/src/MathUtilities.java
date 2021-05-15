public class MathUtilities {
    private MathUtilities(){} //for prohibiting constructing objects of this type

    static int gcd(int a, int b){
        if(a == 0 && b == 0){
            throw new IllegalArgumentException("GCD is not defined for 0 and 0");
        }
        int temp = a % b;
        while (temp != 0){
            a = b;
            b = temp;
            temp = a % b;
        }

        return b;
    }
}
