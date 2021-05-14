import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
class EOFException extends Exception{
    public EOFException(String message){
        super(message);
    }
};
public class Main {
    private static final int MINES_FOR_BEGINNER = 10;
    private static final int MINES_FOR_INTERMEDIATE = 40;
    private static final int MINES_FOR_EXPERT = 99;

    private static final int FIELD_WIDTH_FOR_BEGINNER = 8;
    private static final int FIELD_HEIGHT_FOR_BEGINNER = 8;
    private static final int FIELD_WIDTH_FOR_INTERMEDIATE = 16;
    private static final int FIELD_HEIGHT_FOR_INTERMEDIATE = 16;
    private static final int FIELD_WIDTH_FOR_EXPERT = 24;
    private static final int FIELD_HEIGHT_FOR_EXPERT = 24;

    private static final String MINE_CELL = "💣";
    private static final String EMPTY_CELL = "🟨";
    private static final String COVERED_CELL = "🟦";

    private static final int MINE_VALUE = -1;
    private static final int EMPTY_VALUE = 0;

    //It's to analyze 8 cells around one cell
    private static final int[][] SHIFTS = {
            /* Y axis */ {-1, -1, -1,  0, 0,  0,  1, 1, 1},
           /* X axis */  {-1,  0,  1,  0, -1,  1, -1, 0, 1}
    };


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int difficulty = 1; //default value to avoid IDE warning
        try{
            difficulty = readDifficulty(scanner);
        }catch (EOFException EOF){
            System.exit(0); //We exit only if user decides to finish the game
        }

        int mines;
        int fieldWidth;
        int fieldHeight;
        switch (difficulty){
            case 1:
                mines = MINES_FOR_BEGINNER;
                fieldWidth = FIELD_WIDTH_FOR_BEGINNER;
                fieldHeight = FIELD_HEIGHT_FOR_BEGINNER;
                break;
            case 2:
                mines = MINES_FOR_INTERMEDIATE;
                fieldWidth = FIELD_WIDTH_FOR_INTERMEDIATE;
                fieldHeight = FIELD_HEIGHT_FOR_INTERMEDIATE;
                break;
            case 3:
            default:
                mines = MINES_FOR_EXPERT;
                fieldWidth = FIELD_WIDTH_FOR_EXPERT;
                fieldHeight = FIELD_HEIGHT_FOR_EXPERT;
        }

        boolean[][] uncoveredField = new boolean[fieldHeight][fieldWidth]; //default values = false
        int[][] field = new int[fieldHeight][fieldWidth];

        present(field, uncoveredField);

        int[] selectedCoords = {0, 0};
        try{
            selectedCoords = readCoordinates(scanner, 0, fieldWidth, 0, fieldHeight);
        }catch (EOFException EOF){
            System.exit(0); //We exit only if user decides to finish the game
        }

        int selectedX = selectedCoords[0];
        int selectedY = selectedCoords[1];
        /* Only now, we can place mines */

        ArrayList<Integer[]> potentialMinePlaces = new ArrayList<>();
        for(int y = 0; y < fieldHeight; y++) {
            outer:
            for (int x = 0; x < fieldWidth; x++) {
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
                if(areCoordsInside(field, neighbourX, neighbourY) && field[neighbourY][neighbourX] != MINE_VALUE){
                    field[neighbourY][neighbourX]++;
                }
            }
        }

        /* Flood Fill Algorithm */
        floodUncover(selectedX, selectedY, field, uncoveredField);

        boolean lost = false;
        do{
            present(field, uncoveredField);

            try{
                selectedCoords = readCoordinates(scanner, 0, fieldWidth, 0, fieldHeight);
            }catch (EOFException EOF){
                System.exit(0); //We exit only if user decides to finish the game
            }
            selectedX = selectedCoords[0];
            selectedY = selectedCoords[1];

            int cell = field[selectedY][selectedX];
            if(cell == MINE_VALUE){
                uncoveredField[selectedY][selectedX] = true;
                lost = true;
            }else if(cell == EMPTY_VALUE){
                floodUncover(selectedX, selectedY, field, uncoveredField);
            }else{
                uncoveredField[selectedY][selectedX] = true;
            }

            //TODO: check we won or not?
        }while (!lost);

        present(field, uncoveredField);
        //TODO: Print some message, won or lost...
    }

    private static int readDifficulty(Scanner scanner) throws EOFException{
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

    private static int[] readCoordinates(Scanner scanner, int minX, int maxX, int minY, int maxY) throws EOFException{
        do{
            System.out.println("Select a cell (x, y): ");

            if(!scanner.hasNextLine()){
                throw new EOFException("End Of Input");
            }

            try{
                String[] rawInput = scanner.nextLine().split(" ");
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

    private static boolean areCoordsInside(int[][] field, int x, int y){
        int fieldHeight = field.length;
        int fieldWidth = field[0].length;

        return x >= 0 && x < fieldWidth && y >= 0 && y < fieldHeight;
    }

    private static void present_debugger (int[][] field){
        int fieldHeight = field.length;
        int fieldWidth = field[0].length;

        for(int y = 0; y < fieldHeight; y++){
            for(int x = 0; x < fieldWidth; x++){
                int cell = field[y][x];
                if(cell == MINE_VALUE){
                    System.out.print(MINE_CELL);
                }else if(cell == EMPTY_VALUE){
                    System.out.print(EMPTY_CELL);
                }else{ //Some number
                    String numberEmoji = turnNumberIntoEmoji(cell);
                    System.out.print(numberEmoji);
                }
            }
            System.out.println(); //Go to the next line
        }
    }
    private static void present(int[][] field, boolean[][] uncoveredField){
        int fieldHeight = field.length;
        int fieldWidth = field[0].length;

        for(int y = 0; y < fieldHeight; y++){
            for(int x = 0; x < fieldWidth; x++){
                if(uncoveredField[y][x]){ //if the cell is open
                    int cell = field[y][x];
                    if(cell == MINE_VALUE){
                        System.out.print(MINE_CELL);
                    }else if(cell == EMPTY_VALUE){
                        System.out.print(EMPTY_CELL);
                    }else{ //Some number
                        String numberEmoji = turnNumberIntoEmoji(cell);
                        System.out.print(numberEmoji);
                    }
                }else{
                    System.out.print(COVERED_CELL);
                }
            }
            System.out.println(); //Go to the next line
        }
    }

    private static void floodUncover(int selectedX, int selectedY, int[][] field, boolean[][] uncoveredField){
        //Uncovering empty cells and stop when meeting non-zero cells
        uncoveredField[selectedY][selectedX] = true;

        for(int i = 0; i < SHIFTS[0].length; i++) {
            int neighbourY = selectedY + SHIFTS[0][i];
            int neighbourX = selectedX + SHIFTS[1][i];
            if(areCoordsInside(field, neighbourX, neighbourY) && !uncoveredField[neighbourY][neighbourX]){
                uncoveredField[neighbourY][neighbourX] = true;
                if(field[neighbourY][neighbourX] == EMPTY_VALUE){
                    floodUncover(neighbourX, neighbourY, field, uncoveredField);
                }
            }
        }
    }

    private static String turnNumberIntoEmoji(int number){
        switch (number){
            case 1:
                return "1️⃣";
            case 2:
                return "2️⃣";
            case 3:
                return "3️⃣";
            case 4:
                return "4️⃣";
            case 5:
                return "5️⃣";
            case 6:
                return "6️⃣";
            case 7:
                return "7️⃣";
            case 8:
            default:
                return "8️⃣";
        }
    }
}
