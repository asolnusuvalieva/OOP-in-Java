import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Problem05 extends JFrame {
    private final static int MIN_RECT_SIZE = 10;
    private final static int MAX_RECT_SIZE = 100;

    private final static int MIN_CIRCLE_RADIUS = 10;
    private final static int MAX_CIRCLE_RADIUS = 50;

    ArrayList<Shape> shapes = new ArrayList<>();
    private Shape selectedShape = null;
    private boolean dragging = false;
    private int mouseDX, mouseDY; //для красивого dragging

    //Custom drawing - inner class
    class CanvasPanel extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            //Graphics2D comes from older GUI Java library
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHints(new RenderingHints( //get a better quality
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            ));

            super.paintComponent(g);

            for(Shape shape : shapes){
                if(shape instanceof Rectangle){
                    Rectangle rectangle = (Rectangle) shape;
                    g.setColor(Color.YELLOW);
                    g.fillRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
                    if(shape == selectedShape){
                        /*If it's selected outline the shape */
                        g.setColor(Color.RED);
                        g2.setStroke(new BasicStroke(5)); //thickness
                        g.drawRect(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
                    }
                }else if(shape instanceof Circle){
                    Circle circle = (Circle) shape;
                    g.setColor(Color.PINK);
                    g.fillOval(circle.getX(), circle.getY(), circle.getRadius()*2, circle.getRadius()*2);
                    if(shape == selectedShape){
                        /*If it's selected outline the shape */
                        g.setColor(Color.RED);
                        g2.setStroke(new BasicStroke(5)); //thickness
                        g.drawOval(circle.getX(), circle.getY(), circle.getRadius()*2, circle.getRadius()*2);
                    }
                }
            }
        }
    }

    Problem05(){
        setTitle("Graphics Editor");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JFrame thisWindow = this;
        JPanel canvasPanel = new CanvasPanel();
        canvasPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedShape = null;
                for(Shape shape : shapes){
                    if(shape.contains(e.getX(), e.getY())){
                        selectedShape = shape;
                    }
                }

                if(selectedShape != null){
                    if(e.getButton() == MouseEvent.BUTTON1){
                        dragging = true;
                        mouseDX = selectedShape.getX() - e.getX();
                        mouseDY = selectedShape.getY() - e.getY();
                    } else if(e.getButton() == MouseEvent.BUTTON3){ //button3 is a right mouse button
                        JOptionPane.showMessageDialog(thisWindow, selectedShape); //dialog is part of the window
                    }
                }
                canvasPanel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });

        canvasPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(dragging){
                    selectedShape.move(e.getX() + mouseDX, e.getY() + mouseDY);
                    canvasPanel.repaint();
                }
            }
        });

        //Deletion
        canvasPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(selectedShape != null){
                    if(e.getKeyCode() == KeyEvent.VK_DELETE){
                        shapes.remove(selectedShape);
                        selectedShape = null;
                        canvasPanel.repaint();
                    }
                }
            }
        });

        add(canvasPanel, BorderLayout.CENTER);

        JPanel toolbar = new JPanel();

        JButton rectangleButton = new JButton("Rectangle");
        //Что делать, если нажали на кнопку?
        rectangleButton.addActionListener(e -> { //anonymous class that implements ActionListener interface which requires 1 method
            int width = (int)(MIN_RECT_SIZE + Math.random()*(MAX_RECT_SIZE - MIN_RECT_SIZE + 1));
            int height = (int)(MIN_RECT_SIZE + Math.random()*(MAX_RECT_SIZE - MIN_RECT_SIZE + 1));
            int x = (int)(Math.random()*(canvasPanel.getWidth() - width));
            int y = (int)(Math.random()*(canvasPanel.getHeight() - height));
            shapes.add(new Rectangle(x, y, width, height));
            canvasPanel.repaint();
            canvasPanel.requestFocus();
        });

        JButton circleButton = new JButton("Circle");
        circleButton.addActionListener(e -> {
            int radius = (int)(MIN_CIRCLE_RADIUS + Math.random()*(MAX_CIRCLE_RADIUS - MIN_CIRCLE_RADIUS + 1));
            int x = (int)(Math.random()*(canvasPanel.getWidth() - radius*2));
            int y = (int)(Math.random()*(canvasPanel.getHeight() - radius*2));
            shapes.add(new Circle(x, y, radius));
            canvasPanel.repaint();
            canvasPanel.requestFocus();
        });

//        JButton crossButton = new JButton("Cross");

        toolbar.add(rectangleButton);
        toolbar.add(circleButton);
//        toolbar.add(crossButton);
        add(toolbar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new Problem05().setVisible(true); //infinite event loop starts
    }
}
