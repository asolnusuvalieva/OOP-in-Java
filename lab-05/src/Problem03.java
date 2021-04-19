import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

class Reporter{
    private final JFrame frame;

    public Reporter(JFrame frame){
        this.frame = frame;
    }
}

class CoordinateReporter extends Reporter implements MouseMotionListener {
    public CoordinateReporter(JFrame frame){
        super(frame);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }
     /*
    Options for mouseMoved()
    - MouseAdapter (abstract class which implements MouseMotionListener, ...)
    - MouseMotionListener (interface)
     */
}

public class Problem03 extends JFrame {
    Problem03(){
        setSize(400, 400);
        setLocationRelativeTo(null); //will center the window
        setTitle("Sol -- Third: First GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //request to close the window on tapping [x]
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.addMouseMotionListener(new CoordinateReporter(this));
        add(mainPanel, "Center");
    }
}
