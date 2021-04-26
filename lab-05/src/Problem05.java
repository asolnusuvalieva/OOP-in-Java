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
}
public class Problem05 {
}
