/*
The same situation as draw() in Shape in prev examples
 */
abstract class Shape {
    protected final int x, y;

    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract boolean contains(int x, int y);
}
