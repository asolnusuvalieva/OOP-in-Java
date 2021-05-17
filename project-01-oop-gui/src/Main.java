import processing.core.PApplet;
import processing.event.MouseEvent;

public class Main extends PApplet implements MouseClickListener {
    private final int difficulty = 2; //BEGINNER by default
    GameLevel gameLevel = new GameLevel(difficulty);
    Player player = new Player(gameLevel);
    Field field = new Field(gameLevel, player);
    private int flagCounter = gameLevel.getMINES();
    private int timeCounter = 0;

    //Separate Buttons
    PButton beginnerButton;
    PButton intermediateButton;
    PButton expertButton;

    PButton smileyFaceButton;

    public void settings(){
        fullScreen();
    }

    public void setup() {
        background(0);

        //Three Level Buttons
        float levelButtonWidth = width/8f;
        float levelButtonHeight = levelButtonWidth/2f;

        float beginnerButtonX = 7*width/8f - levelButtonWidth/2f;
        float beginnerButtonY = height/4f - levelButtonHeight;
        beginnerButton = new PButton(this, beginnerButtonX, beginnerButtonY, levelButtonWidth, levelButtonHeight, "Beginner", null, this);
        beginnerButton.getLabel().setFontSize(25);
        beginnerButton.getLabel().setColor(0xff00cc22); //green
        beginnerButton.getLabel().setColorHover(0xff00cc22); //green
        beginnerButton.getLabel().setColorActive(0xff00cc22); //green


        float intermediateButtonX = beginnerButtonX;
        float intermediateButtonY = height/2f - levelButtonHeight;
        intermediateButton = new PButton(this, intermediateButtonX, intermediateButtonY, levelButtonWidth, levelButtonHeight, "Intermediate", null, this);
        intermediateButton.getLabel().setFontSize(25);
        intermediateButton.getLabel().setColor(0xff00c3ff); //blue
        intermediateButton.getLabel().setColorHover(0xff00c3ff); //blue
        intermediateButton.getLabel().setColorActive(0xff00c3ff); //blue


        float expertButtonX = beginnerButtonX;
        float expertButtonY = 3*height/4f - levelButtonHeight;
        expertButton = new PButton(this, expertButtonX, expertButtonY, levelButtonWidth, levelButtonHeight, "Expert", null, this);
        expertButton.getLabel().setFontSize(25);
        expertButton.getLabel().setColor(0xffff00dd); //purple
        expertButton.getLabel().setColorHover(0xffff00dd); //purple
        expertButton.getLabel().setColorActive(0xffff00dd); //purple


        //Cell Buttons
        float buttonCellSize = 32; //Just by default
        float centeringShiftX = calculateCenteringShifts(width, height, gameLevel, buttonCellSize)[0];
        float centeringShiftY = calculateCenteringShifts(width, height, gameLevel, buttonCellSize)[1];;

        //Initializing buttons
        for(int y = 0; y < field.buttons.length; y++){
            for(int x = 0; x < field.buttons.length; x++){
                float screenX = centeringShiftX + x * buttonCellSize;
                float screenY = centeringShiftY + y * buttonCellSize;
                field.buttons[y][x] = new PButton(this, screenX, screenY, buttonCellSize, buttonCellSize, "", new int[]{x, y}, field);
                field.buttons[y][x].appearance.setBackgroundImage(this.loadImage("buttonBackgroundImageNormal.png"));
                field.buttons[y][x].appearance.setBackgroundImageHover(this.loadImage("buttonBackgroundImageHover.png"));
                field.buttons[y][x].appearance.setBackgroundImageActive(this.loadImage("buttonBackgroundImageActive.png"));
            }
        }

        float smileyFaceButtonSize = 64; //64 is convenient for the sake of image
        float smileyFaceButtonX = centeringShiftX + (gameLevel.getFIELD_WIDTH() * buttonCellSize)/2f - smileyFaceButtonSize/2f;
        float smileyFaceButtonY = centeringShiftY - smileyFaceButtonSize - 5; //5 is just to give some space
        smileyFaceButton = new PButton(this, smileyFaceButtonX, smileyFaceButtonY, smileyFaceButtonSize, smileyFaceButtonSize, "", null, this); //TODO: Don't touch it
        smileyFaceButton.appearance.setBackgroundImage(this.loadImage("smileyFaceNormal.png"));
    }

    public void draw() {
        stroke(255, 0, 0);
        line( 6*width/8f, 0, 6*width/8f, height);
        beginnerButton.draw();
        intermediateButton.draw();
        expertButton.draw();
        smileyFaceButton.draw();

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

        beginnerButton.mousePressed();
        intermediateButton.mousePressed();
        expertButton.mousePressed();
        smileyFaceButton.mousePressed();
    }

    public void mouseReleased() {
        for(int y = 0; y < field.buttons.length; y++) {
            for (int x = 0; x < field.buttons.length; x++) {
                field.buttons[y][x].mouseReleased();
            }
        }

        beginnerButton.mouseReleased();
        intermediateButton.mouseReleased();
        expertButton.mouseReleased();
        smileyFaceButton.mouseReleased();
    }

    public void mouseClicked() {
        for(int y = 0; y < field.buttons.length; y++) {
            for (int x = 0; x < field.buttons.length; x++) {
                field.buttons[y][x].mouseClicked();
            }
        }

        beginnerButton.mouseClicked();
        intermediateButton.mouseClicked();
        expertButton.mouseClicked();
        smileyFaceButton.mouseClicked();

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
        beginnerButton.mouseMoved();
        intermediateButton.mouseMoved();
        expertButton.mouseMoved();
        smileyFaceButton.mouseMoved();
    }

    //Helper Methods
    private float[] calculateCenteringShifts(float width, float height, GameLevel gameLevel, float buttonSize){
        float[] centeringShifts = new float[2];
        float availableScreenWidthSpace = width - 2*width/8f;

        float fieldScreenWidth = gameLevel.getFIELD_WIDTH() * buttonSize;
        centeringShifts[0] = availableScreenWidthSpace/2f - fieldScreenWidth/2f;
        centeringShifts[1] = height/2f - fieldScreenWidth/2f;

        return centeringShifts;
    }

    //What to do when level buttons get pressed?
    public void mouseClicked(PApplet applet, int selectedCellX, int selectedCellY) {
        //TODO: THINK
        System.out.println("Level Buttons were pressed");
    }

    public static void main(String[] args) {
        PApplet.main("Main"); //It's just a requirement from Processing
    }


}

