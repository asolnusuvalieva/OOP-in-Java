import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ColorChanger extends MouseAdapter {
    private final JPanel panel;
    private final Color color;
    public ColorChanger(JPanel panel, Color color){
        this.panel = panel;
        this.color = color;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        panel.setBackground(color);
    }
}

public class Problem02 extends JFrame {
    Problem02(){
        /* WINDOW */
        setSize(400, 400);
        setLocationRelativeTo(null); //set the window to the center of the screen
        setTitle("Lab-05: Problem01");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //What to do by default when we close the window? //it'll stop the program
        setLayout(new BorderLayout()); //Choose a layout engine

        /* Red Panel */
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        /* Adding the panel to the window */
        add(mainPanel, "Center");

        /* Creating Buttons */
        JButton redButton = new JButton("RED"); //a button with a text/name
        redButton.addMouseListener(new ColorChanger(mainPanel, Color.RED)); //inside, it will call mouseClicked() of ColorChanger cb it's just a MouseAdapter

        JButton greenButton = new JButton("GREEN"); //a button with a text/name
        greenButton.addMouseListener(new ColorChanger(mainPanel, Color.GREEN));

        JButton blueButton = new JButton("BLUE"); //a button with a text/name
        blueButton.addMouseListener(new ColorChanger(mainPanel, Color.BLUE));

        /* Toolbar Panel */
        JPanel toolbarPanel = new JPanel();
        toolbarPanel.setBackground(Color.DARK_GRAY);

        /* Adding buttons to the panel */
        toolbarPanel.add(redButton);
        toolbarPanel.add(greenButton);
        toolbarPanel.add(blueButton);

        /* Adding the panel to the window */
        add(toolbarPanel, "South");
    }

    public static void main(String[] args) {
        new Problem02().setVisible(true);
        /*
        So Problem01 is basically a JFrame (a window) ;)
        It sets the window visible and start an event loop that doesn't end when reaching the {}
         */
    }
}
/*
MouseAdapter is an abstract class that implements MouseListener, MouseWheelListener, MouseMotionListener.
It leaves all the required methods with empty implementation.
In this case, it's better to inherit rather than directly implement a particular interface
bc it will force us to implement methods we don't need; while inheriting from MouseAdapter,
we can just override the one we need, and it looks beautiful :)
 */

//Final Version