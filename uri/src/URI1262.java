import java.util.Scanner;
/*
[] multiple processes can read from the same resource during the same clock cycle
[] only a single process can write to the resource during a clock cycle.

W: Every W represents one clock cycle
R: 2 <= R <= procs ? one clock cycle : should be considered separately
 */
public class URI1262 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String trace = scanner.next();
            int procs = scanner.nextInt();

            if(procs == 1){
                System.out.println(trace.length());
                continue;
            }

            String regex = "R{2" + "," + procs + "}";
            String result = trace.replaceAll(regex, "R");
            System.out.println(result.length());
        }
    }
}
//Accepted and pushed