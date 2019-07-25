package abstractShape;

public class Rectangle extends Shape {
    private int height;
    private int width;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    Rectangle(String color, int height, int width) {
        super(color);
        setHeight(height);
        setWidth(width);
    }

    @Override
    public double getArea() {
        return getHeight() * getHeight();
    }

    @Override
    public double getPerimeter() {
        return 2 * getHeight() * getWidth();
    }
}
