import javax.swing.*;
import java.awt.*;

class Canvas extends JPanel {
    private static final int FIELD_WIDTH = 10;
    private static final int FIELD_HEIGHT = 10;
    private static final float CELL_GAP = 0.85f;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //let the parent fill the background with some color

        int cellSize = (int)(Math.min(getWidth()/FIELD_WIDTH, getHeight()/FIELD_HEIGHT) * CELL_GAP); //80% is just to have gaps around the board
        int screenFieldWidth = FIELD_WIDTH * cellSize;
        int screenFieldHeight = FIELD_HEIGHT * cellSize;
        int centeringShiftX = (int)((getWidth() - screenFieldWidth)/2f);
        int centeringShiftY = (int)((getHeight() - screenFieldHeight)/2f);

        for(int i = 0; i < FIELD_HEIGHT; i++){
            for(int j = 0; j < FIELD_WIDTH; j++){
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
    }
}
public class Problem04 extends JFrame{
    Problem04(){
        setSize(400, 400);
        setLocationRelativeTo(null); //will center the window
        setTitle("Fourth GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //request to close the window on tapping [x]
        setLayout(new BorderLayout());

        JPanel mainPanel = new Canvas();
        mainPanel.setBackground(Color.BLACK);

        add(mainPanel, "Center");
    }

    public static void main(String[] args) {
        new Problem04().setVisible(true); //set window visible and start an infinite loop
    }
}