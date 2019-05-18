public class Overloading {
    public int max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }

    public double max(double num1, double num2) {
        return num1 > num2 ? num1 : num2;
    }

    public int max(int num1, int num2, int num3) {
        return max(num1, max(num2, num3));
    }

    public static void main(String[] args) {
        Overloading self = new Overloading();

        System.out.println("max(2, 5): " + self.max(2, 5));
        System.out.println("max(6.57, 4.36): " + self.max(6.57, 4.36));
        System.out.println("max(7, 3, 9): " + self.max(7, 3, 9));
    }
}
