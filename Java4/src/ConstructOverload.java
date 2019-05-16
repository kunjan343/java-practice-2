public class ConstructOverload {
    private double radius;

    private ConstructOverload() {
        this.radius = 15;
    }

    private ConstructOverload(double radius) {
        this.radius = radius;
    }

    private double getRadius() {
        return this.radius;
    }

    private double getCircleArea() {
        return Math.PI * this.radius * this.radius;
    }

    private double getCircleDiameter() {
        return 2 * Math.PI * this.radius;
    }

    public static void main(String[] args) {
        ConstructOverload circle = new ConstructOverload();
        System.out.println("Default circle area(" + circle.getRadius() + "): " + circle.getCircleArea());
        System.out.println("Default circle diameter(" + circle.getRadius() + "): " + circle.getCircleDiameter());

        ConstructOverload userCircle = new ConstructOverload(12.5);
        System.out.println("User circle area(" + userCircle.getRadius() + "): " + userCircle.getCircleArea());
        System.out.println("User circle diameter(" + userCircle.getRadius() + "): " + userCircle.getCircleDiameter());
    }
}
