/*
Tracking a mouse coordinate
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

abstract class Reporter implements MouseMotionListener, KeyListener{ //no point to instantiate this class
    protected final JFrame window; //window is repeated in two different listeners

    Reporter(JFrame window){
        this.window = window;
    }

    //Methods from MouseMotionListener
    public void mouseMoved(MouseEvent e) {}
    public void mouseDragged(MouseEvent e){}

    //Methods from KeyListener
    public void keyPressed(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}

class MouseReporter extends Reporter {
    MouseReporter(JFrame window){
        super(window);
    }

    public void mouseMoved(MouseEvent e) {
        window.setTitle(e.getX() + ", " + e.getY());
    }
}

class KeyReporter extends Reporter {
    KeyReporter(JFrame window){
        super(window);
    }

    public void keyPressed(KeyEvent e) {
        window.setTitle(String.valueOf(e.getKeyChar()));
    }
}

public class Problem03 extends JFrame {
    Problem03(){
        /* WINDOW */
        setSize(400, 400);
        setLocationRelativeTo(null); //set the window to the center of the screen
        setTitle("Lab-05: Problem03");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //What to do by default when we close the window? //it'll stop the program
        setLayout(new BorderLayout()); //Choose a layout engine

        /* Red Panel */
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.addMouseMotionListener(new MouseReporter(this));

        addKeyListener(new KeyReporter(this)); //adding the KeyReporter to the window

        /* Adding the panel to the window */
        add(mainPanel, "Center");
    }

    public static void main(String[] args) {
        new Problem03().setVisible(true);
        /*
        So Problem03 is basically a JFrame (a window) ;)
        It sets the window visible and start an event loop that doesn't end when reaching the {}
         */
    }
}

//Final Version