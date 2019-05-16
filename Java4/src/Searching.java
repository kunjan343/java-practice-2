import java.util.Arrays;
import java.util.Scanner;

public class Searching {
    private int[] arr = new int[200];

    public Searching() {
        this.fillArray();
    }

    private void fillArray() {
        for (int index = 0; index < arr.length; index++) {
            arr[index] = (int) (Math.random() * 100 + 1);
        }
    }

    private int findNumber(int num) {
        Arrays.sort(arr);
        return Arrays.binarySearch(arr,num);
    }

    public static void main(String[] args) {
        // Scanner class
        Scanner input = new Scanner(System.in);

        Searching self = new Searching();

        System.out.println("Enter number you want to search:");
        int num = input.nextInt();

        int index = self.findNumber(num);
        String ans = index < 0 ? "Not found" : String.valueOf(index);

        System.out.println("number at position: " + ans);
    }
}
