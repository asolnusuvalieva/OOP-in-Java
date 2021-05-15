import java.util.Scanner;

public class Player {
    private boolean lost = false;
    private boolean won;
    public int totalCellsToUncover;


    /* Getters */
    public boolean isLost() {
        return lost;
    }

    public boolean isWon() {
        return won;
    }

    public int getTotalCellsToUncover() {
        return totalCellsToUncover;
    }

    /* Setters */

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void setTotalCellsToUncover(int totalCellsToUncover) {
        this.totalCellsToUncover = totalCellsToUncover;
    }

    public Player(GameLevel gameLevel){
        totalCellsToUncover = gameLevel.getFIELD_HEIGHT() * gameLevel.getFIELD_WIDTH() - gameLevel.getMINES();
        won = totalCellsToUncover == 0;
    }

    public static int chooseDifficulty(Scanner scanner) throws EOFException{
        do{
            System.out.println(
                    "Select difficulty:\n" +
                            "\t1. Beginner\n" +
                            "\t2. Intermediate\n" +
                            "\t3. Expert"
            );

            if(!scanner.hasNextLine()){
                throw new EOFException("End Of Input");
            }

            try{
                String rawInput = scanner.nextLine();
                int input = Integer.parseInt(rawInput);
                if(input < 1 || input > 3){
                    throw new NumberFormatException();
                }
                return input;
            }catch (NumberFormatException e){
                System.err.print("Invalid difficulty level. Try again (or Command+D to exit).");
            }
        }while (true);
    }

    public static int[] enterCoordinates(Scanner scanner, int minX, int maxX, int minY, int maxY) throws EOFException{
        do{
            System.out.println("Select a cell (x, y): ");

            if(!scanner.hasNextLine()){
                throw new EOFException("End Of Input");
            }

            try{
                String[] rawInput = scanner.nextLine().trim().split("\\s+");;
                if(rawInput.length != 2){
                    throw new NumberFormatException();
                }
                int x = Integer.parseInt(rawInput[0]);
                x--;
                if(x < minX || x >= maxX){
                    throw new NumberFormatException();
                }

                int y = Integer.parseInt(rawInput[1]);
                y--;
                if(y < minY || y >= maxY){
                    throw new NumberFormatException();
                }

                return new int[] {x, y};
            }catch (NumberFormatException e){
                System.err.print("Invalid coordinates. Try again (or Command+D to exit).");
            }
        }while (true);
    }
}
