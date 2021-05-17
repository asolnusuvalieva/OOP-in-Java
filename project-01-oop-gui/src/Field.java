import processing.core.PApplet;

import java.util.ArrayList;

public class Field implements MouseClickListener{
    private static boolean wasFirstWave = false;
    private static final int MINE_VALUE = -1;
    private static final int EMPTY_VALUE = 0;

    //It's to analyze 8 cells around one cell
    private static final int[][] SHIFTS = {
            /* Y axis */ {-1, -1, -1,  0,  0,  0,  1,  1, 1},
            /* X axis */  {-1,  0,  1,  -1, 0,  1, -1,  0, 1}
    };

    private final int mines;
    private final int width;
    private final int height;

    private final int[][] field;
    public boolean[][] uncoveredField;
    private Player player;
    public PButton[][] buttons;

    /* Getters */
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public static int getMineValue() {
        return MINE_VALUE;
    }
    public static int getEmptyValue() {
        return EMPTY_VALUE;
    }
    public int getCell(int x, int y){
        return field[y][x];
    }

    /* Methods */
    public Field(GameLevel gameLevel, Player player){
        mines = gameLevel.getMINES();
        width = gameLevel.getFIELD_WIDTH();
        height = gameLevel.getFIELD_HEIGHT();
        this.player = player;

        field = new int[height][width];
        uncoveredField = new boolean[height][width]; //default values = false; all cells are closed
        buttons = new PButton[gameLevel.getFIELD_HEIGHT()][gameLevel.getFIELD_WIDTH()];
    }

    public void presentWinOrLost (PApplet applet){
        uncoveredField = null;
        present(applet);
    }

    public void present(PApplet applet){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(uncoveredField == null || uncoveredField[y][x]){ //if the cell is open
                    int cell = field[y][x];
                    if(cell == MINE_VALUE){
                        //Удаление старого дерьма
                        buttons[y][x].appearance.setBackgroundImage(null);
                        buttons[y][x].appearance.setBackgroundImageHover(null);
                        buttons[y][x].appearance.setBackgroundImageActive(null);

                        buttons[y][x].setCurrentState(PButton.State.NORMAL);
                        buttons[y][x].appearance.setBackgroundColor(0xffff0000); //red
                        buttons[y][x].appearance.setIcon(applet.loadImage("mine.png"));
                        buttons[y][x].setEnabled(false);
                    }else if(cell == 0){
                        //Удаление старого дерьма
                        buttons[y][x].appearance.setBackgroundImage(null);
                        buttons[y][x].appearance.setBackgroundImageHover(null);
                        buttons[y][x].appearance.setBackgroundImageActive(null);

                        buttons[y][x].appearance.setIcon(applet.loadImage("buttonEmptyCellBackgroundImage.png"));//light yellow
                        buttons[y][x].setEnabled(false);
                    }else{//Some number
                        buttons[y][x].setCurrentState(PButton.State.NORMAL);
                        buttons[y][x].setLabel(new Label(String.valueOf(cell)));
                        buttons[y][x].setEnabled(false);
                    }
                }// otherwise there will be a default appearance of the button

                buttons[y][x].draw();
            }
        }
    }

    public void putMines(int selectedX, int selectedY){
        ArrayList<Integer[]> potentialMinePlaces = findPotentialMinePlaces(selectedX, selectedY);

        //Now, we can finally place mines
        for(int i = 0; i < mines; i++){
            int randomIndex = (int)(Math.random() * potentialMinePlaces.size());
            Integer[] mineCoords = potentialMinePlaces.get(randomIndex);
            potentialMinePlaces.remove(randomIndex);

            int mineY = mineCoords[0];
            int mineX = mineCoords[1];
            field[mineY][mineX] = MINE_VALUE;
            for(int j = 0; j < SHIFTS[0].length; j++) {
                int neighbourY = mineY + SHIFTS[0][j];
                int neighbourX = mineX + SHIFTS[1][j];
                if(areCoordsInside(neighbourX, neighbourY) && field[neighbourY][neighbourX] != MINE_VALUE){
                    field[neighbourY][neighbourX]++;
                }
            }
        }
    }

    public int floodUncover(int selectedX, int selectedY){
        int uncoveredCells = 0;

        //Uncovering empty cells and stop when meeting non-zero cells
        uncoveredField[selectedY][selectedX] = true;

        for(int i = 0; i < SHIFTS[0].length; i++) {
            int neighbourY = selectedY + SHIFTS[0][i];
            int neighbourX = selectedX + SHIFTS[1][i];
            if(areCoordsInside(neighbourX, neighbourY) && !uncoveredField[neighbourY][neighbourX]){
                uncoveredField[neighbourY][neighbourX] = true;
                uncoveredCells++;

                if(field[neighbourY][neighbourX] == EMPTY_VALUE){
                    uncoveredCells += floodUncover(neighbourX, neighbourY);
                }
            }
        }

        return uncoveredCells;
    }

    private ArrayList<Integer[]> findPotentialMinePlaces(int selectedX, int selectedY){
        ArrayList<Integer[]> potentialMinePlaces = new ArrayList<>();
        for(int y = 0; y < height; y++) {
            outer:
            for (int x = 0; x < width; x++) {
                //selectedX, selectedY, and cells around them are NOT places for mines
                for(int i = 0; i < SHIFTS[0].length; i++){
                    int neighbourY = selectedY + SHIFTS[0][i];
                    int neighbourX = selectedX + SHIFTS[1][i];

                    if(x == neighbourX && y == neighbourY){
                        break outer;
                    }
                }
                potentialMinePlaces.add(new Integer[] {y, x});
            }
        }

        return potentialMinePlaces;
    }

    private boolean areCoordsInside(int x, int y){
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void mouseClicked(PApplet applet, int selectedCellX, int selectedCellY) {
        if(!wasFirstWave){
            putMines(selectedCellX, selectedCellY);
            player.totalCellsToUncover -= floodUncover(selectedCellX, selectedCellY);
            wasFirstWave = true;
            present(applet);
        }else{
            int cell = getCell(selectedCellX, selectedCellY);
            if(cell == Field.getMineValue()){
                uncoveredField[selectedCellY][selectedCellX] = true;
                player.setLost(true);
            }else if(cell == Field.getEmptyValue()){
                player.totalCellsToUncover -= floodUncover(selectedCellX, selectedCellY);
            }else{
                uncoveredField[selectedCellY][selectedCellX] = true;
                player.totalCellsToUncover--;
            }

            if(player.totalCellsToUncover == 0){
                player.setWon(true);
            }
            present(applet);
            System.out.println("This cell (" + selectedCellX + ", " + selectedCellY + ") was clicked!");
        }
    }
}
