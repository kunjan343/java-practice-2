package abstractShape;

public abstract class Shape {
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    Shape(String color) {
        setColor(color);
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
