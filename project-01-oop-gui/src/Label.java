public class Label {
    private final String text; //text on the top of the button
    private final int fontSize = 25;
    private final int color = 0xff001aff;
    private final int colorHover = 0xff4a5cff;
    private final int colorActive = 0xff0011ad;

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
}

