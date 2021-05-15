import processing.core.PApplet;
import processing.event.MouseEvent;

import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<PButton> buttons = new ArrayList<>();

    public void settings() {
//        fullScreen();
        size(400, 400);
    }

    public void setup() {
        background(0);
        float buttonWidth = 100;
        float buttonHeight = 100;
        float button1X = width/2f - buttonWidth/2f;
        float button1Y = width/2f - buttonWidth/2f;

        PButton button1 = new PButton(this, button1X, button1Y, buttonWidth, buttonHeight, "1");
        button1.setBackgroundImage(loadImage("normal.png"));
        button1.setBackgroundImageHover(loadImage("hover.png"));
        button1.setBackgroundImageActive(loadImage("active.png"));
        button1.setClickListener(() -> System.out.println("Button1 was clicked!"));

        buttons.add(button1);
    }

    public void draw() {
        for(PButton button : buttons){
            button.draw();
        }
    }

    /* Working with mouse for the window itself */
    public void mousePressed() {
        for(PButton button : buttons){
            button.mousePressed();
        }
    }

    public void mouseReleased() {
        for(PButton button : buttons){
            button.mouseReleased();
        }
    }

    public void mouseClicked() {
        for(PButton button : buttons){
            button.mouseClicked();
        }
    }

    public void mouseMoved(MouseEvent event) {
        for(PButton button : buttons){
            button.mouseMoved();
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main"); //It's just a requirement from Processing
    }
}
