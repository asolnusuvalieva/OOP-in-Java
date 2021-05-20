public class Circle extends Shape {
    private int radius;

    Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    boolean contains(int mouseX, int mouseY){
        int dx = x - mouseX;
        int dy = y - mouseY;
        return dx * dx + dy * dy < radius * radius; //a^2 + b^2  = c^2
    }

    @Override
    public String toString() {
        return String.format("Circle: %d, %d, %d", x, y, radius);
    }
}
