import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Minesweeper game!\n");

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

        try{
            player.enterCoordinates(scanner, 0, field.getWidth(), 0, field.getHeight());
        }catch (EOFException EOF){
            System.exit(0); //We exit only if user decides to finish the game
        }

        field.putMines(player.getSelectedX(), player.getSelectedY());
        player.totalCellsToUncover -= field.floodUncover(player.getSelectedX(), player.getSelectedY());

        while(!player.isLost() || !player.isWon()){
            field.present();

            try{
                player.enterCoordinates(scanner, 0, field.getWidth(), 0, field.getHeight());
            }catch (EOFException EOF){
                System.exit(0); //We exit only if user decides to finish the game
            }
            int selectedX = player.getSelectedX();
            int selectedY = player.getSelectedY();
            int cell = field.getCell(selectedX, selectedY);

            if(cell == Field.getMineValue()){
                field.uncoveredField[selectedY][selectedX] = true;
                player.setLost(true);
            }else if(cell == Field.getEmptyValue()){
                player.totalCellsToUncover -= field.floodUncover(selectedX, selectedY);
            }else{
                field.uncoveredField[selectedY][selectedX] = true;
                player.totalCellsToUncover--;
            }

            if(player.totalCellsToUncover == 0){
                player.setWon(true);
            }
        }

        field.presentWinOrLost();
        if (player.isLost()) {
            System.out.println("☹️\nYou lost! That is fine! Play again!");
        } else {
            System.out.println("🎉🎉🎉\nYou won! Play the harder level!");
        }
    }
}
