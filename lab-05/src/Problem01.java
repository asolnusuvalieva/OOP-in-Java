import javax.swing.*;
import java.awt.*;

public class Problem01 extends JFrame {
    Problem01(){
        setSize(400, 400);
        setLocationRelativeTo(null); //will center the window
        setTitle("Sol: First GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //request to close the window on tapping [x]
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);

        JPanel toolbarPanel = new JPanel();
        toolbarPanel.setBackground(Color.DARK_GRAY);

        JButton redButton = new JButton("RED"); //a text on a button
        JButton greenButton = new JButton("GREEN"); //a text on a button
        JButton blueButton = new JButton("BLUE"); //a text on a button
    }






    public static void main(String[] args) {

    }
}
