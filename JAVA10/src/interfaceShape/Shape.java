package interfaceShape;

public abstract class Shape implements IShape {
    private String color;

    Shape(String color) {
        setColor(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
