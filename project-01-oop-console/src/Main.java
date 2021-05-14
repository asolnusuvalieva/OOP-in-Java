import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Minesweeper\n");

        int difficulty = 1; //default value to avoid IDE warning
        try{
            difficulty = Player.chooseDifficulty(scanner);
        }catch (EOFException EOF){
            System.exit(0); //We exit only if user decides to finish the game
        }

        GameLevel gameLevel = new GameLevel(difficulty);
        Player player = new Player(gameLevel);
        Field field = new Field(gameLevel);
        field.present();

        int[] selectedCoords = {0, 0}; //default value to avoid IDE warning
        try{
            selectedCoords = Player.enterCoordinates(scanner, 0, field.getWidth(), 0, field.getHeight());
        }catch (EOFException EOF){
            System.exit(0); //We exit only if user decides to finish the game
        }

        int selectedX = selectedCoords[0];
        int selectedY = selectedCoords[1];

        field.putMines(selectedX, selectedY);
        player.totalCellsToUncover -= field.floodUncover(selectedX, selectedY);

        while(!player.lost && !player.won){
            field.present();

            try{
                selectedCoords = Player.enterCoordinates(scanner, 0, field.getWidth(), 0, field.getHeight());
            }catch (EOFException EOF){
                System.exit(0); //We exit only if user decides to finish the game
            }
            selectedX = selectedCoords[0];
            selectedY = selectedCoords[1];

            int cell = field.getCell(selectedX, selectedY);
            if(cell == Field.getMineValue()){
                field.uncoveredField[selectedY][selectedX] = true;
                player.lost = true;
            }else if(cell == Field.getEmptyValue()){
                player.totalCellsToUncover -= field.floodUncover(selectedX, selectedY);
            }else{
                field.uncoveredField[selectedY][selectedX] = true;
                player.totalCellsToUncover--;
            }

            if(player.totalCellsToUncover == 0){
                player.won = true;
            }
        }

        field.present_debugger();
        if (player.lost) {
            System.out.println("Bad luck, the mine went off.");
        } else {
            System.out.println("You won! The field was cleared.");
        }
    }
}
