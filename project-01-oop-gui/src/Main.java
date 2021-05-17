import processing.core.PApplet;
import processing.event.MouseEvent;

public class Main extends PApplet {
    int difficulty = 1; //BEGINNER
    GameLevel gameLevel = new GameLevel(difficulty);
    Player player = new Player(gameLevel);
    Field field = new Field(gameLevel, player);

    public void settings(){
        fullScreen();
    }

    public void setup() {
        background(0);

        //Welcoming Message
        this.fill(250, 246, 0);
        this.textAlign(this.CENTER, this.CENTER);
        this.textSize(50);
        this.text("Minesweeper Game!\nBeginner Level", width/2f, height/15f);
        float buttonSize = 65; //Just by default
        float centeringShiftX = width/15f;
        float centeringShiftY = 3*height/15f;

        //Initializing buttons
        for(int y = 0; y < field.buttons.length; y++){
            for(int x = 0; x < field.buttons.length; x++){
                float screenX = centeringShiftX + x * buttonSize;
                float screenY = centeringShiftY + y * buttonSize;
                field.buttons[y][x] = new PButton(this, screenX, screenY, buttonSize, buttonSize, "", new int[]{x, y}, field);
                field.buttons[y][x].appearance.setBackgroundImage(this.loadImage("buttonBackgroundImageNormal.png"));
                field.buttons[y][x].appearance.setBackgroundImageHover(this.loadImage("buttonBackgroundImageHover.png"));
                field.buttons[y][x].appearance.setBackgroundImageActive(this.loadImage("buttonBackgroundImageActive.png"));
            }
        }
    }

    public void draw() {
        for(int y = 0; y < field.buttons.length; y++) {
            for (int x = 0; x < field.buttons.length; x++) {
                field.buttons[y][x].draw();
            }
        }
    }

    /* Working with mouse for the window itself */
    public void mousePressed() {
        for(int y = 0; y < field.buttons.length; y++) {
            for (int x = 0; x < field.buttons.length; x++) {
                field.buttons[y][x].mousePressed();
            }
        }
    }

    public void mouseReleased() {
        for(int y = 0; y < field.buttons.length; y++) {
            for (int x = 0; x < field.buttons.length; x++) {
                field.buttons[y][x].mouseReleased();
            }
        }
    }

    public void mouseClicked() {
        for(int y = 0; y < field.buttons.length; y++) {
            for (int x = 0; x < field.buttons.length; x++) {
                field.buttons[y][x].mouseClicked();
            }
        }

        if(player.isLost() || player.isWon()){
            field.presentWinOrLost(this);
            System.out.println(player.isLost()? "You lost!" : "You won!");
        }
    }

    public void mouseMoved(MouseEvent event) {
        for(int y = 0; y < field.buttons.length; y++) {
            for (int x = 0; x < field.buttons.length; x++) {
                field.buttons[y][x].mouseMoved();
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main"); //It's just a requirement from Processing
    }
}

