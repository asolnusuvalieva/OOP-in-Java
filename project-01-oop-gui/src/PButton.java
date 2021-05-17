import processing.core.PApplet;
interface MouseClickListener{
    void mouseClicked(PApplet applet, int selectedCellX, int selectedCellY);
}

public class PButton {
    // Data Fields
    enum State{
        NORMAL,  //0
        HOVER,   //1
        ACTIVE   //2
    }

    private final PApplet applet;
    private float x, y;
    private float width, height;
    private Label label;
    private State currentState = State.NORMAL;
    public PButtonAppearance appearance = new PButtonAppearance(); //TODO: Stay 'public'?
    private boolean enabled = true; //can and can NOT interact with the button
    private final int[] identifier; //to count cells in 2D array
    private MouseClickListener clickListener; //Пусть кто то другой решает, что делать если нажали на кнопку

    // Methods
    public PButton(PApplet applet, float x, float y, float width, float height, String label, int[] identifier, MouseClickListener clickListener){
        this.applet = applet;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = new Label(label);
        this.identifier = identifier;
        this.clickListener = clickListener;
    }

    // Reacting to mouse manipulations
    public void mouseClicked() {
        if(!enabled) return;

        //mouse pressed AND released, and the mouse didn't move too far
        if(areMouseCoordsInside(applet.mouseX, applet.mouseY)){
            clickListener.mouseClicked(applet, identifier[0], identifier[1]); //x, y
        }
    }

    public void mousePressed() {
        if(!enabled) return;

        if(areMouseCoordsInside(applet.mouseX, applet.mouseY)){
            currentState = State.ACTIVE;
        }
    }

    public void mouseReleased() {
        if(!enabled) return;
        if(areMouseCoordsInside(applet.mouseX, applet.mouseY)){
            currentState = State.HOVER;
        }else{
            currentState = State.NORMAL;
        }
    }
    public void mouseMoved() {
        if(!enabled) return;

        if(areMouseCoordsInside(applet.mouseX, applet.mouseY)){
            currentState = State.HOVER;
        }else{
            //if mouse leaves and not over us
            currentState = State.NORMAL;
        }
    }

    public void draw(){
        //Respective behavior in corresponding states
        if(currentState == State.NORMAL){
            applet.fill(appearance.getBackgroundColor());
            applet.noStroke();
            applet.rect(x, y, width, height);

            //Background Image ?
            if(appearance.getBackgroundImage() != null){
                applet.image(appearance.getBackgroundImage(), x, y, width, height);
            }

            //Icon ?
            if(appearance.getIcon() != null){
                float iconX = x + (width - appearance.getIcon().width) * 0.5f;
                float iconY = y + (height - appearance.getIcon().height) * 0.5f;
                applet.image(appearance.getIcon(), iconX, iconY);
            }

            // Label ?
            if(!label.getText().isEmpty()){
                applet.fill(label.getColor());
                applet.textAlign(applet.CENTER, applet.CENTER);
                applet.textSize(label.getFontSize());
                applet.text(label.getText(), x + width/2, y + height/2);
            }
        }else if(currentState == State.HOVER){
            applet.fill(appearance.getBackgroundColorHover());
            applet.noStroke();
            applet.rect(x, y, width, height);

            //BackgroundImageHover ?
            if(appearance.getBackgroundImageHover() != null){
                applet.image(appearance.getBackgroundImageHover(), x, y, width, height);
            }else if(appearance.getBackgroundImage() != null){
                applet.image(appearance.getBackgroundImage(), x, y, width, height);
            }

            //IconHover ?
            if(appearance.getIconHover() != null){
                float iconX = x + (width - appearance.getIconHover().width)*0.5f;
                float iconY = y + (height - appearance.getIconHover().height)*0.5f;
                applet.image(appearance.getIconHover(), iconX, iconY);
            }else if(appearance.getIcon() != null){
                float iconX = x + (width - appearance.getIcon().width)*0.5f;
                float iconY = y + (height - appearance.getIcon().height)*0.5f;
                applet.image(appearance.getIcon(), iconX, iconY);
            }

            //Label ?
            if(!label.getText().isEmpty()){
                applet.fill(label.getColorHover());
                applet.textAlign(applet.CENTER, applet.CENTER);
                applet.textSize(label.getFontSize());
                applet.text(label.getText(), x + width/2, y + height/2);
            }
        }else if(currentState == State.ACTIVE){
            applet.fill(appearance.getBackgroundColorActive());
            applet.noStroke();
            applet.rect(x, y, width, height);

            //BackgroundImageActive ?
            if(appearance.getBackgroundImageActive() != null){
                applet.image(appearance.getBackgroundImageActive(), x, y, width, height);
            }else if(appearance.getBackgroundImage() != null){
                applet.image(appearance.getBackgroundImage(), x, y, width, height);
            }

            //IconActive ?
            if(appearance.getIconActive() != null){
                float iconX = x + (width - appearance.getIconActive().width) * 0.5f;
                float iconY = y + (height - appearance.getIconActive().height) * 0.5f;
                applet.image(appearance.getIconActive(), iconX, iconY);
            }else if(appearance.getIcon() != null){
                float iconX = x + (width - appearance.getIcon().width) * 0.5f;
                float iconY = y + (height - appearance.getIcon().height) * 0.5f;
                applet.image(appearance.getIcon(), iconX, iconY);
            }

            //Label ?
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

    public void setClickListener(MouseClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}

