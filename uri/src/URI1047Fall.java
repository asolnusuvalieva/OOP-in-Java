import java.util.Scanner;

public class URI1047Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startHour = scanner.nextInt();
        int startMinute = scanner.nextInt();
        int finishHour = scanner.nextInt();
        int finishMinute = scanner.nextInt();

        int start = startHour * 60 + startMinute;
        int end = finishHour * 60 + finishMinute;
        int durationInHours, durationInMins;

        if (end > start){
            int duration = end - start;
            durationInHours = duration / 60 % 24;
            durationInMins = duration % 60;
        }else if (end < start){
            int duration = 24 * 60 - start + end;
            durationInHours = duration / 60 % 24;
            durationInMins = duration % 60;
        }else{
            durationInHours = 24;
            durationInMins = 0;
        }


        System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)%n", durationInHours, durationInMins);
    }
}
//accepted