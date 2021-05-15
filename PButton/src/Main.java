import processing.core.PApplet;
import processing.event.MouseEvent;

public class Main extends PApplet {
    public void settings() {
        size(400, 400); // or fullScreen();
    }

    public void setup() {
        background(0);
    }

    public void draw() {

    }

    /* Working with mouse for the window itself */
    public void mousePressed() {

    }

    public void mouseReleased() {
        super.mouseReleased();
    }

    public void mouseClicked() {

    }

    public void mouseMoved(MouseEvent event) {

    }

    public static void main(String[] args) {
        PApplet.main("Main"); //It's just a requirement from Processing
    }
}
