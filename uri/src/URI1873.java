import java.util.Scanner;
/*
Rows:
1. Rock
2. Paper
3. Scissors
4. Lizard
5. Spock

[
[scissors, lizard] -> Rock
[rock, spock] -> Paper
[paper, lizard] -> Scissors
[spock, paper] -> Lizard
[rock, scissors] -> Spock
]
 */
public class URI1873 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rajesh = "rajesh";
        String sheldon = "sheldon";
        String[] weapons = {"pedra", "papel", "tesoura", "lagarto", "spock"};
        String[][] rules = {
                {"tesoura", "lagarto"},
                {"pedra", "spock"},
                {"papel", "lagarto"},
                {"papel", "spock"},
                {"pedra", "tesoura"}
        };

        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            String rajeshInput = scanner.next();
            String sheldonInput = scanner.next();

            if(rajeshInput.equals(sheldonInput)){
                System.out.println("empate");
            }else{
                int rajeshRow = 0;
                int sheldonRow = 0;
                //Finding out their rows
                for(int j = 0; j < weapons.length; j++){
                    if(weapons[j].equals(rajeshInput)){
                        rajeshRow = j;
                    }else if (weapons[j].equals(sheldonInput)){
                        sheldonRow = j;
                    }
                }

                //Determining the winner
                if(contains(rules[rajeshRow], sheldonInput)){
                    System.out.println(rajesh);
                }else if(contains(rules[sheldonRow], rajeshInput)){
                    System.out.println(sheldon);
                }

            }
        }
    }

    public static boolean contains(String[] array, String value) {
        boolean contains = false;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals(value)){
                contains = true;
                break;
            }
        }
        return contains;
    }
}

//Accepted and pushed