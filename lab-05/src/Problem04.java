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
    }




}
public class Problem04 {
}
