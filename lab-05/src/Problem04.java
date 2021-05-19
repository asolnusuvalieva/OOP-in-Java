/*
Draw checkerboard pattern
 */
import javax.swing.*;
import java.awt.*;

class Checkerboard extends JPanel{
    private static final int FIELD_WIDTH = 10;
    private static final int FIELD_HEIGHT = 10;

    //Custom Drawing Code
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //combining old/parent's logic
        /*
        g can do a lot of useful things
         */

        //Dynamic choice of the cell size
        int cellSize = (int)(Math.min(getWidth()/FIELD_WIDTH, getHeight()/FIELD_HEIGHT)*0.85f); //80% is for the cell, while 20% is to give space
        int screenFieldWidth = FIELD_WIDTH * cellSize;
        int screenFieldHeight = FIELD_HEIGHT * cellSize;
        int centeringShiftX = (int)((getWidth() - screenFieldWidth)/2.0f);
        int centeringShiftY = (int)((getHeight() - screenFieldHeight)/2.0f);

        for(int y = 0; y < FIELD_HEIGHT; y++){
            for(int x = 0; x < FIELD_WIDTH; x++){
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
    }
}

public class Problem04 extends JFrame{
    Problem04(){
        setSize(400, 400);
        setLocationRelativeTo(null); //set the window to the center of the screen
        setTitle("Lab-05: Problem04");
        setDefaultCloseOperation(EXIT_ON_CLOSE);//What to do by default when we close the window? //it'll stop the program
        setLayout(new BorderLayout()); //Choose a layout engine

        JPanel mainPanel = new Checkerboard();
        mainPanel.setBackground(Color.BLACK);

        add(mainPanel, "Center");
    }

    public static void main(String[] args) {
        new Problem04().setVisible(true); //set window visible and start an infinite loop
    }
}
