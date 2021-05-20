/*
The same situation as draw() in Shape in prev examples.

Model Class is just for containing data and methods for those data manipulation.
 */
abstract class Shape {
    protected int x, y;

    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move(int x2, int y2){
        x = x2;
        y = y2;
    }

    abstract boolean contains(int x, int y);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
