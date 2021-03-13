import java.util.Scanner;

public class URI1131Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int interWins = 0;

        int gremioWins = 0;

        int draws = 0;
        int matchesCount = 0;

        int again = 1;
        while (again != 2){
            int interInput = scanner.nextInt();
            int gremiInput = scanner.nextInt();
            if(interInput == gremiInput){
                draws++;
            } else if(interInput > gremiInput){
                interWins++;
            }else{
                gremioWins++;
            }
            matchesCount++;
            System.out.println("Novo grenal (1-sim 2-nao)");
            again = scanner.nextInt();
        }

        System.out.printf("%d grenais%nInter:%d%nGremio:%d%nEmpates:%d%n", matchesCount, interWins, gremioWins, draws);
        if(interWins == gremioWins){
            System.out.println("Não houve vencedor");
        } else if(interWins > gremioWins){
            System.out.println("Inter venceu mais");
        }else{
            System.out.println("Gremio venceu mais");
        }
    }
}

//ACCEPTED
//PUSHED