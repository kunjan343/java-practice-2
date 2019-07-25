package abstractShape;

public class ColoredCylinder extends Circle {
    private int height;

    ColoredCylinder(String color, int height, int radius) {
        super(color, radius);
        setHeight(height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius() * getHeight();
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius() * (getHeight() + getRadius());
    }
}
