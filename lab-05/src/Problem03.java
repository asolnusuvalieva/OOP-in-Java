import javax.swing.*;
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

public class Problem03 {
}
