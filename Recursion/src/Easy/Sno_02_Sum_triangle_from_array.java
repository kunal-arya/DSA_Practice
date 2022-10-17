package Easy;

import java.util.Arrays;

public class Sno_02_Sum_triangle_from_array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        printTriangleSum(arr);
    }

    static void printTriangleSum(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }

        int[] result = new int[n - 1];
        int k = 0;
        for (int i = 0; i < n - 1 ; i++) {
            result[k] = arr[i] + arr[i + 1];
            k++;
        }
        printTriangleSum(result);
        System.out.println(Arrays.toString(result));
    }
}
