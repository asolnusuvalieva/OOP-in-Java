public class Circle extends Shape {
    private final int radius;

    Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    boolean contains(int mouseX, int mouseY){
//        int dx = x - mouseX; (our logic)
        int dx = x + radius - mouseX;
//        int dy = y - mouseY;
        int dy = y + radius - mouseY;
        return dx * dx + dy * dy < radius * radius; //a^2 + b^2  = c^2
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Circle: %d, %d, %d", x, y, radius);
    }
}
