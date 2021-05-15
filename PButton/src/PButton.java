import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

interface MouseClickListener{
    void mouseClicked();
}
public class PButton {
    // Data Fields
    //Ellipses from StateMachine
    enum State{
        NORMAL,  //0
        HOVER,   //1
        ACTIVE   //2
    }

    private State currentState = State.NORMAL;

    private float x, y;
    private float width, height;
    private Label label;
    private boolean enabled = true; //can and can NOT interact with the button
    private MouseClickListener clickListener = () -> {};
    private final PApplet applet;

    private int backgroundColor = PApplet.unhex("5b4df7"); // DARK-GRAY
    private int backgroundColorHover = PApplet.unhex("9d95ed"); // Lighter color
    private int backgroundColorActive = PApplet.unhex("322b75"); // Darker color : when pressed

    private PImage backgroundImage = null;
    private PImage backgroundImageHover = null;
    private PImage backgroundImageActive = null;

    private PImage icon = null; //for example, a smiley face
    private PImage iconHover = null;
    private PImage iconActive = null;


    // Methods
    PButton(PApplet applet, float x, float y, float width, float height, String label){
        this.applet = applet;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = new Label(label);
    }

    /* Getters and Setters */
    float getX() {
        return x;
    }

    void setX(float x) {
        this.x = x;
    }

    float getY() {
        return y;
    }

    void setY(float y) {
        this.y = y;
    }

    float getWidth() {
        return width;
    }

    void setWidth(float width) {
        this.width = width;
    }

    float getHeight() {
        return height;
    }

    void setHeight(float height) {
        this.height = height;
    }

    Label getLabel() {
        return label;
    }

    void setLabel(Label label) {
        this.label = label;
    }

    boolean isEnabled() {
        return enabled;
    }

    void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    MouseClickListener getClickListener() {
        return clickListener;
    }

    void setClickListener(MouseClickListener clickListener) {
        this.clickListener = clickListener;
    }

    int getBackgroundColor() {
        return backgroundColor;
    }

    void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    int getBackgroundColorHover() {
        return backgroundColorHover;
    }

    void setBackgroundColorHover(int backgroundColorHover) {
        this.backgroundColorHover = backgroundColorHover;
    }

    int getBackgroundColorActive() {
        return backgroundColorActive;
    }

    void setBackgroundColorActive(int backgroundColorActive) {
        this.backgroundColorActive = backgroundColorActive;
    }

    PImage getBackgroundImage() {
        return backgroundImage;
    }

    void setBackgroundImage(PImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    PImage getBackgroundImageHover() {
        return backgroundImageHover;
    }

    void setBackgroundImageHover(PImage backgroundImageHover) {
        this.backgroundImageHover = backgroundImageHover;
    }

    PImage getBackgroundImageActive() {
        return backgroundImageActive;
    }

    void setBackgroundImageActive(PImage backgroundImageActive) {
        this.backgroundImageActive = backgroundImageActive;
    }

    PImage getIcon() {
        return icon;
    }

    void setIcon(PImage icon) {
        this.icon = icon;
    }

    PImage getIconHover() {
        return iconHover;
    }

    void setIconHover(PImage iconHover) {
        this.iconHover = iconHover;
    }

    PImage getIconActive() {
        return iconActive;
    }

    void setIconActive(PImage iconActive) {
        this.iconActive = iconActive;
    }

    // Event Handling
    void mouseClicked() {
        if(!enabled) return;

        //mouse pressed AND released, and the mouse didn't move too far
        if(areMouseCoordsInside(applet.mouseX, applet.mouseY)){
            clickListener.mouseClicked();
        }
    }

    void mousePressed() {
        if(!enabled) return;

        if(areMouseCoordsInside(applet.mouseX, applet.mouseY)){
            currentState = State.ACTIVE;
        }
    }

    void mouseReleased() {
        if(!enabled) return;
        if(areMouseCoordsInside(applet.mouseX, applet.mouseY)){
            currentState = State.HOVER;
        }else{
            currentState = State.NORMAL;
        }
    }
    void mouseMoved() {
        if(!enabled) return;

        if(areMouseCoordsInside(applet.mouseX, applet.mouseY)){
            currentState = State.HOVER;
        }else{
            //if mouse leaves and not over us
            currentState = State.NORMAL;
        }
    }

    void draw(){
        //Respective behavior in corresponding states
        if(currentState == State.NORMAL){
            applet.fill(backgroundColor);
            applet.rect(x, y, width, height);
            if(backgroundImage != null){
                applet.image(backgroundImage, x, y, width, height);
            }

            if(icon != null){
                float iconX = x + (width - icon.width)*0.5f;
                float iconY = y + (height - icon.height)*0.5f;
                applet.image(icon, iconX, iconY);
            }

            if(!label.getText().isEmpty()){
                applet.fill(label.getColor());
                applet.textAlign(applet.CENTER, applet.CENTER);
                applet.textSize(label.getFontSize());
                applet.text(label.getText(), x + width/2, y + height/2);
            }
        }else if(currentState == State.HOVER){
            applet.fill(backgroundColorHover);
            applet.rect(x, y, width, height);
            if(backgroundImageHover != null){
                applet.image(backgroundImageHover, x, y, width, height);
            }else if(backgroundImage != null){
                applet.image(backgroundImage, x, y, width, height);
            }

            if(iconHover != null){
                float iconX = x + (width - icon.width)*0.5f;
                float iconY = y + (height - icon.height)*0.5f;
                applet.image(iconHover, iconX, iconY);
            }else if(icon != null){
                float iconX = x + (width - icon.width)*0.5f;
                float iconY = y + (height - icon.height)*0.5f;
                applet.image(icon, iconX, iconY);
            }

            if(!label.getText().isEmpty()){
                applet.fill(label.getColorHover());
                applet.textAlign(applet.CENTER, applet.CENTER);
                applet.textSize(label.getFontSize());
                applet.text(label.getText(), x + width/2, y + height/2);
            }
        }else if(currentState == State.ACTIVE){
            applet.fill(backgroundColorActive);
            applet.rect(x, y, width, height);
            if(backgroundImageActive != null){
                applet.image(backgroundImageActive, x, y, width, height);
            }else if(backgroundImage != null){
                applet.image(backgroundImage, x, y, width, height);
            }

            if(iconActive != null){
                float iconX = x + (width - icon.width) * 0.5f;
                float iconY = y + (height - icon.height) * 0.5f;
                applet.image(iconActive, iconX, iconY);
            }else if(icon != null){
                float iconX = x + (width - icon.width)*0.5f;
                float iconY = y + (height - icon.height)*0.5f;
                applet.image(icon, iconX, iconY);
            }

            if(!label.getText().isEmpty()){
                applet.fill(label.getColorActive());
                applet.textAlign(applet.CENTER, applet.CENTER);
                applet.textSize(label.getFontSize());
                applet.text(label.getText(), x + width/2, y + height/2);
            }
        }
    }

    private boolean areMouseCoordsInside(int mouseX, int mouseY){
        return mouseX >= x && mouseX < x + width &&
                mouseY >= y && mouseY < y + height;
    }
}
