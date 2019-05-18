import java.util.Arrays;

public class Comparing {
    public boolean compareArrays(int[] arr1, int[] arr2) {
        int result = Arrays.compare(arr1, arr2);
        return result == 0;
    }

    public static void printStatus(boolean result) {
        System.out.println(result ? "Same Array" : "Different Array");
    }

    public static void main(String[] args) {
        Comparing self = new Comparing();
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 4, 3};
        int[] arr4 = {1, 2};

        System.out.println(Arrays.toString(arr1) + " and " + Arrays.toString(arr4));
        Comparing.printStatus(self.compareArrays(arr1, arr3));
        System.out.println(Arrays.toString(arr1) + " and " + Arrays.toString(arr2));
        Comparing.printStatus(self.compareArrays(arr1, arr2));
        System.out.println(Arrays.toString(arr1) + " and " + Arrays.toString(arr3));
        Comparing.printStatus(self.compareArrays(arr1, arr4));
    }
}
