public class Label {
    private final String text; //text on the top of the button
    private final int fontSize = 16;

    private final int color = 0xffe0e0e0;
    private final int colorHover = 0xffe0e0e0;
    private final int colorActive = 0xff969696;

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
