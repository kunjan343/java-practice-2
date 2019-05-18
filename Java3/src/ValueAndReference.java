import java.util.Arrays;

public class ValueAndReference {
    
    public static void main(String[] args) {
        int num = 1;
        // A value type
        double[] arr = {1.1, 2.2, 3.3, 4.4};
        // A reference type (object)
        System.out.println("Value of num is " + num + ", arr contains " + Arrays.toString(arr));
        test(num, arr);
        System.out.println("Value of num is " + num + ", arr contains " + Arrays.toString(arr));
    }

    private static void test(int num, double[] array) {
        num = 99;
        array[1] = 99;
    }
}
