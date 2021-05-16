import processing.core.PApplet;
import processing.event.MouseEvent;

public class Main extends PApplet {
    int difficulty = 1; //BEGINNER
    GameLevel gameLevel = new GameLevel(difficulty);
    Player player = new Player(gameLevel);
    Field field = new Field(gameLevel);
    PButton[][] buttons = new PButton[gameLevel.getFIELD_HEIGHT()][gameLevel.getFIELD_WIDTH()];

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
        float buttonSize = 64; //Just by default
        float centeringShiftX = width/15f;
        float centeringShiftY = 2*height/15f;

        System.out.println("I should have printed something on the screen");
        //Initializing buttons
        for(int y = 0; y < buttons.length; y++){
            for(int x = 0; x < buttons.length; x++){
                float screenX = centeringShiftX + x * buttonSize;
                float screenY = centeringShiftY + y * buttonSize;
                buttons[y][x] = new PButton(this, screenX, screenY, buttonSize, buttonSize, "", new int[]{x, y}, player);
            }
        }

        field.present(this, buttons);

        field.putMines(player.getSelectedX(), player.getSelectedY());
        player.totalCellsToUncover -= field.floodUncover(player.getSelectedX(), player.getSelectedY());
        System.out.println("I placed all the mines and first floodUncover is gone");
        field.present(this, buttons);
    }

    public void draw() {
        //TODO: Is this OK?
        for(int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons.length; x++) {
                buttons[y][x].draw();
            }
        }
    }

    /* Working with mouse for the window itself */
    public void mousePressed() {
        for(int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons.length; x++) {
                buttons[y][x].mousePressed();
            }
        }
    }

    public void mouseReleased() {
        for(int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons.length; x++) {
                buttons[y][x].mouseReleased();
            }
        }
    }

    public void mouseClicked() {
        for(int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons.length; x++) {
                buttons[y][x].mouseClicked();
            }
        }
    }

    public void mouseMoved(MouseEvent event) {
        for(int y = 0; y < buttons.length; y++) {
            for (int x = 0; x < buttons.length; x++) {
                buttons[y][x].mouseMoved();
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main"); //It's just a requirement from Processing
    }
}

