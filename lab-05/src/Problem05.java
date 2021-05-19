/*
a circle moving on a checkerboard
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/* Field and Robot are just model classes responsible for calculations */
class Field{
    private static final int DEFAULT_FIELD_WIDTH = 10;
    private static final int DEFAULT_FIELD_HEIGHT = 10;

    private final int width, height;

    Field(){
        this(DEFAULT_FIELD_WIDTH, DEFAULT_FIELD_HEIGHT); //by default
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

class Robot{ //a circle
    private int x, y;
    private final Field field;

    Robot(Field field){
        this(field, 0, 0); //by default, (0, 0)
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

    //Movements
    void moveLeft(){
        int nextX = x - 1;
        int nextY = y;

        if(field.areCoordsInside(nextX, nextY)){
            x = nextX;
        }
    }

    void moveRight(){
        int nextX = x + 1;
        int nextY = y;

        if(field.areCoordsInside(nextX, nextY)){
            x = nextX;
        }
    }
    void moveUp(){
        int nextY = y - 1;
        int nextX = x;

        if(field.areCoordsInside(nextX, nextY)){
            y = nextY;
        }
    }
    void moveDown(){
        int nextY = y + 1;
        int nextX = x;

        if(field.areCoordsInside(nextX, nextY)){
            y = nextY;
        }
    }
}

class RobotController extends KeyAdapter { //the same logic as MouseAdapter
    private final JPanel robotCheckerboard; //ask Java Swing to update when a robot moves
    private final Robot robot;

    RobotController(JPanel robotCheckerboard, Robot robot){
        this.robotCheckerboard = robotCheckerboard;
        this.robot = robot;
    }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                robot.moveUp();
                robotCheckerboard.repaint(); //you are invalid, redraw
                break;
            case KeyEvent.VK_DOWN:
                robot.moveDown();
                robotCheckerboard.repaint(); //you are invalid, redraw
                break;
            case KeyEvent.VK_LEFT:
                robot.moveLeft();
                robotCheckerboard.repaint(); //you are invalid, redraw
                break;
            case KeyEvent.VK_RIGHT:
                robot.moveRight();
                robotCheckerboard.repaint(); //you are invalid, redraw
                break;
        }
    }
}

class RobotCheckerboard extends JPanel {
    private final Field field;
    private final Robot robot;

    RobotCheckerboard(Field field, Robot robot){
        this.field = field;
        this.robot = robot;
    }

    //Custom Drawing Code
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //combining old/parent's logic
        /*
        g can do a lot of useful things
         */

        //Dynamic choice of the cell size
        int cellSize = (int)(Math.min(getWidth()/field.getWidth(), getHeight()/field.getHeight())*0.85f); //80% is for the cell, while 20% is to give space
        int screenFieldWidth = field.getWidth() * cellSize;
        int screenFieldHeight = field.getHeight() * cellSize;
        int centeringShiftX = (int)((getWidth() - screenFieldWidth)/2.0f);
        int centeringShiftY = (int)((getHeight() - screenFieldHeight)/2.0f);

        //Drawing Checkerboard
        for(int y = 0; y < field.getHeight(); y++){
            for(int x = 0; x < field.getWidth(); x++){
                int screenX = centeringShiftX + x * cellSize;
                int screenY = centeringShiftY + y * cellSize;

                if((y + x) % 2 == 0){
                    g.setColor(Color.BLACK);
                }else{
                    g.setColor(Color.WHITE);
                }
                g.fillRect(screenX, screenY, cellSize, cellSize);
            }
        }

        //Drawing Robot
        int screenX = centeringShiftX + robot.getX() * cellSize;
        int screenY = centeringShiftY + robot.getY() * cellSize;
        g.setColor(Color.RED);
        g.fillOval(screenX, screenY, cellSize, cellSize);
    }
}

public class Problem05 extends JFrame {
    Problem05(){
        setSize(400, 400);
        setLocationRelativeTo(null); //will center the window
        setTitle("Lab-05: Problem05");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //request to close the window on tapping [x]
        setLayout(new BorderLayout());

        Field field = new Field();
        Robot robot = new Robot(field);

        JPanel mainPanel = new RobotCheckerboard(field, robot);
        mainPanel.setBackground(Color.BLACK);
        addKeyListener(new RobotController(mainPanel, robot)); //to the window

        add(mainPanel, "Center");
    }

    public static void main(String[] args) {
        new Problem05().setVisible(true); //set window visible and start an infinite loop
    }
}
