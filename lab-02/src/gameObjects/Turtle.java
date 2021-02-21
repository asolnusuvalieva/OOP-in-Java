package gameObjects;

public class Turtle {
    //PROPERTIES
    private int x = 0, y = 0;
    private int dx = 1, dy = 0;
    private boolean isPenDown = false;
    private Field field;

    //Getter methods
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }

    //Setter methods (YAGNI)
    public void setX(int newX){
        if (Field.areCoordsInside(newX, y)){
            x = newX;
        }
    }
    public void setY(int newY){
        if (Field.areCoordsInside(x, newY)){
            y = newY;
        }
    }

    //METHODS
    //Initialization
    public Turtle(Field newField){
        field = newField;
    }

    public void putPenUp(){
        isPenDown = false;
    }

    public void putPenDown(){
        isPenDown = true;
    }

    public void turnRight(){
        int temp = dx;
        dx = dy;
        dy = temp;

        dx = -dx;
    }

    public void turnLeft(){
        int temp = dx;
        dx = dy;
        dy = temp;

        dy = -dy;
    }

    public void move(int steps){
        for(int i = 0; i < steps; i++){
            int nextX = x + dx;
            int nextY = y + dy;

            if(!Field.areCoordsInside(nextX, nextY)){
                break;
            }

            if(isPenDown){
                field.putMark(x, y);
            }
            x = nextX;
            y = nextY;
        }
    }

}
