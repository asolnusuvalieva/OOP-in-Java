import javax.swing.*;
import java.awt.*;

public class Problem02 extends JFrame {
    Problem02(){
        setSize(400, 400);
        setLocationRelativeTo(null); //will center the window
        setTitle("Sol: First GUI App");
        setDefaultCloseOperation(EXIT_ON_CLOSE); //request to close the window on tapping [x]
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.RED);

        JPanel toolbarPanel = new JPanel();
        toolbarPanel.setBackground(Color.DARK_GRAY);
    }
}
