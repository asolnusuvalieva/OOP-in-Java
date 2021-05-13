import javax.swing.*;
import java.awt.*;

public class Problem01 extends JFrame {
    Problem01(){
        /* WINDOW */
        setSize(400, 400);
        setLocationRelativeTo(null); //set the window to the center of the screen
        setTitle("Lab-05: Problem01");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //What to do by default when we close the window? //it'll stop the program
        setLayout(new BorderLayout()); //Choose a layout engine

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);
        add(mainPanel, "Center");

        JButton redButton = new JButton("RED"); //a button with a text/name
        JButton greenButton = new JButton("GREEN"); //a button with a text/name
        JButton blueButton = new JButton("BLUE"); //a button with a text/name

        JPanel toolbarPanel = new JPanel();
        toolbarPanel.setBackground(Color.DARK_GRAY);

        toolbarPanel.add(redButton);
        toolbarPanel.add(greenButton);
        toolbarPanel.add(blueButton);

        add(toolbarPanel, "South");
    }

    public static void main(String[] args) {
        new Problem01().setVisible(true);
        /*
        So Problem01 is basically a JFrame (a window) ;)
        It sets the window visible and start an event loop that doesn't end when reaching the {}
         */
    }
}

//Final Version