public class URI1096Fall {
    public static void main(String[] args) {
        int i = 1;

        while (i <= 9){
            int j = 7;
            for (int count = j; count >= 5; count--){
                System.out.print("I=" + i + " ");
                System.out.println("J=" + count);
            }
            i += 2;
        }
    }
}
//Accepted
/*
int i = 1; int j = 7;
Pattern:
After 3 times, i += 2; j--;
 */