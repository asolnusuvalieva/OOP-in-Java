public class Rectangle {
    private final int x, y;
    private final int width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    boolean contains(int mouseX, int mouseY){
        return mouseX >= this.x && mouseX < x + width &&
                mouseY >= this.y && mouseY < y + height;
    }
    public String toString() {
        return String.format("Rect: %d, %d, %d, %d", x, y, width, height);
    }
}
