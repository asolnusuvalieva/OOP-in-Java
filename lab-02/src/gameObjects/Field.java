package gameObjects;

public class Field {
    //PROPERTIES
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;

    private static final char TURTLE_CELL = 'T';
    private static final char EMPTY_CELL = '.';
    private static final char MARKED_CELL = '*';

    private char[][] content;

    //METHODS
    //Initialization
    public Field(){
        content = new char[HEIGHT][WIDTH];
        for(int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                content[i][j] = EMPTY_CELL;
            }
        }
    }

    static boolean areCoordsInside(int x, int y){
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
    }

    void putMark(int x, int y){
        if (areCoordsInside(x, y)){
            content[y][x] = MARKED_CELL;
        }
    }

    public void display(Turtle turtle){
        for(int i = 0; i < HEIGHT; i++){
            for (int j = 0; j < WIDTH; j++){
                if(turtle.getY() == i && turtle.getX() == j){
                    System.out.print(TURTLE_CELL);
                }else{
                    System.out.print(content[i][j]);
                }
            }
            System.out.println();
        }
    }
}
