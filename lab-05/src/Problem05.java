class Field{
    private static final int DEFAULT_FIELD_WIDTH = 10;
    private static final int DEFAULT_FIELD_HEIGHT = 10;

    private int width, height;

    Field(){
        this(DEFAULT_FIELD_WIDTH, DEFAULT_FIELD_HEIGHT);
    }

    Field(int width, int height){
        this.width = width;
        this.height = height;
    }

    int getWidth(){
        return width;
    }
    int getHeight(){
        return height;
    }

    boolean areCoordsInside(int x, int y){
        return x >= 0 && x < width &&
                y >= 0 && y < height;
    }
}
public class Problem05 {
}
