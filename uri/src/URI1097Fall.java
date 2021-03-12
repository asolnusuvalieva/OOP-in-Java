public class URI1097Fall {
    public static void main(String[] args) {
        int i = 1;
        int j = 7;

        while (i <= 9){
            int answer = j;
            for (int a = 0; a < 3; a++){
                System.out.print("I=" + i + " ");
                System.out.println("J=" + answer);
                answer -= 1;
            }
            j += 2;
            i += 2;
        }
    }
}
//accepted
