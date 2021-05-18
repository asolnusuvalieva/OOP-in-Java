public class Label {
    private String text; //text on the top of the button
    private int fontSize = 15;
    private int color = 0xff001aff;
    private int colorHover = 0xff4a5cff;
    private int colorActive = 0xff0011ad;

    public Label(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public int getFontSize() {
        return fontSize;
    }

    public int getColor() {
        return color;
    }

    public int getColorHover() {
        return colorHover;
    }

    public int getColorActive() {
        return colorActive;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setColorHover(int colorHover) {
        this.colorHover = colorHover;
    }

    public void setColorActive(int colorActive) {
        this.colorActive = colorActive;
    }

    public void setText(String text) {
        this.text = text;
    }
}

