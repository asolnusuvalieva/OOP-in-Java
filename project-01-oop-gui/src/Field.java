import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Field {
    private static final String MINE_CELL = "💣";
    private static final String EMPTY_CELL = "⬜️";
    private static final String COVERED_CELL = "🟦";

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
    public Field(GameLevel gameLevel){
        mines = gameLevel.getMINES();
        width = gameLevel.getFIELD_WIDTH();
        height = gameLevel.getFIELD_HEIGHT();

        field = new int[height][width];
        uncoveredField = new boolean[height][width]; //default values = false; all cells are closed
    }

    public void presentWinOrLost (PApplet applet, PButton[][] buttons){
        uncoveredField = null;
        present(applet, buttons);
    }

    public void present(PApplet applet, PButton[][] buttons){
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                if(uncoveredField == null || uncoveredField[y][x]){ //if the cell is open
                    System.out.println("It should not happen");
                    int cell = field[y][x];
                    if(cell == MINE_VALUE){
                        buttons[y][x].appearance.setBackgroundColor(0xffff0000); //red
                        buttons[y][x].appearance.setIcon(applet.loadImage("mine.png"));
//                        System.out.print(MINE_CELL);
                    }else if(cell != 0){ //Some number
                        buttons[y][x].setLabel(new Label(String.valueOf(cell)));
                    }
                }

                buttons[y][x].draw();
//              System.out.print(COVERED_CELL);
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
}
