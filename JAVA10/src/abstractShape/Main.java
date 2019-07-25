package abstractShape;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("red", 15);
        Rectangle rectangle = new Rectangle("green", 8, 17);
        ColoredCylinder coloredCylinder = new ColoredCylinder("orange", 30, 12);
        /* abstractShape.Circle methods */
        System.out.println("Area of circle: " + circle.getArea());
        System.out.println("Perimeter of circle: " + circle.getPerimeter());

        /* abstractShape.Rectangle methods */
        System.out.println("Area of rectangle: " + rectangle.getArea());
        System.out.println("Perimeter of rectangle: " + rectangle.getPerimeter());

        /* abstractShape.Rectangle methods */
        System.out.println("Area of rectangle: " + coloredCylinder.getArea());
        System.out.println("Perimeter of rectangle: " + coloredCylinder.getPerimeter());
    }
}
