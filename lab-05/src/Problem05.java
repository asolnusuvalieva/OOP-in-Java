import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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

class Robot{
    private final Field field;
    private int x, y;

    Robot(Field field){
        this(field, 0, 0);
    }

    Robot(Field field, int x, int y){
        this.field = field;
        this.x = x;
        this.y = y;
    }

    int getX(){
        return x;
    }
    int getY(){
        return y;
    }

    void moveLeft(){
        int nextX = x - 1;
        int nextY = y;
    }

    void moveRight(){

    }
    void moveUp(){

    }
    void moveDown(){

    }
}

class RobotController extends KeyAdapter {
    private Robot robot;
    RobotController(Robot robot){
        this.robot = robot;
    }

    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
//            case KeyEvent:
        }
    }
}
class RobotCanvas extends JPanel {
    private static final float CELL_GAP = 0.85f;
    private static Field field;
    private static Robot robot;

    public RobotCanvas(){
        field = new Field();
        robot = new Robot(field);

        addKeyListener(new RobotController(robot));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //let the parent fill the background with some color

        int cellSize = (int)(Math.min(getWidth()/field.getWidth(), getHeight()/field.getHeight()) * CELL_GAP); //80% is just to have gaps around the board
        int screenFieldWidth = field.getWidth() * cellSize;
        int screenFieldHeight = field.getHeight() * cellSize;
        int centeringShiftX = (int)((getWidth() - screenFieldWidth)/2f);
        int centeringShiftY = (int)((getHeight() - screenFieldHeight)/2f);

        //Field
        for(int i = 0; i < field.getHeight(); i++){
            for(int j = 0; j < field.getWidth(); j++){
                int screenX = centeringShiftX + j * cellSize;
                int screenY = centeringShiftY + i * cellSize;

                if((i + j) % 2 == 0){ //even + even = even, odd + even = odd
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.WHITE);
                }

                g.fillRect(screenX,screenY, cellSize, cellSize);
            }
        }

        //Robot
    }
}
public class Problem05 extends JFrame {
    Problem05(){
        setSize(400, 400);
        setLocationRelativeTo(null); //will center the window
        setTitle("Fifth GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //request to close the window on tapping [x]
        setLayout(new BorderLayout());

        JPanel mainPanel = new RobotCanvas();
        mainPanel.setBackground(Color.BLACK);
        add(mainPanel, "Center");
    }

    public static void main(String[] args) {
        new Problem05().setVisible(true); //set window visible and start an infinite loop
    }
}
