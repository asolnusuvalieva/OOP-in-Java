import java.util.Scanner;

//April - 30 days
public class URI1061Fall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();
        int startDay = scanner.nextInt();
        int startHour = scanner.nextInt();
        scanner.next();
        int startMin = scanner.nextInt();
        scanner.next();
        int startSec = scanner.nextInt();
        scanner.next();
        int endDay = scanner.nextInt();
        int endHour = scanner.nextInt();
        scanner.next();
        int endMin = scanner.nextInt();
        scanner.next();
        int endSec = scanner.nextInt();

        int start = startDay * 24 * 60 * 60 +
                startHour * 60 * 60 +
                startMin * 60 + startSec;

        int end = endDay * 24 * 60 * 60 +
                endHour * 60 * 60 +
                endMin * 60 + endSec;

        int difference = end - start;

        int days = difference / (24 * 60 * 60);
        int hours = difference % (24 * 60 * 60) / (60 * 60);
        int minutes = difference % (24 * 60 * 60) % (60 * 60) / 60;
        int seconds = difference % (24 * 60 * 60) % (60 * 60) % 60;

        System.out.println(days + " dia(s)");
        System.out.println(hours + " hora(s)");
        System.out.println(minutes + " minuto(s)");
        System.out.println(seconds + " segundo(s)");

    }
}
//accepted