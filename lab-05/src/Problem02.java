import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ColorChanger extends MouseAdapter {
    private final JPanel panel;
    private final Color color;

    ColorChanger(JPanel panel, Color color){
        this.panel = panel;
        this.color = color;
    }

    public void mouseClicked(MouseEvent e) {
        panel.setBackground(color);
    }
}
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

        JButton redButton = new JButton("RED"); //a text on a button
        redButton.addMouseListener(new ColorChanger(mainPanel, Color.RED));

        JButton greenButton = new JButton("GREEN"); //a text on a button
        greenButton.addMouseListener(new ColorChanger(mainPanel, Color.GREEN));

        JButton blueButton = new JButton("BLUE"); //a text on a button
        blueButton.addMouseListener(new ColorChanger(mainPanel, Color.BLUE));


        toolbarPanel.add(redButton);
        toolbarPanel.add(greenButton);
        toolbarPanel.add(blueButton);

        add(mainPanel, "Center");
        add(toolbarPanel, "South");
    }
}
