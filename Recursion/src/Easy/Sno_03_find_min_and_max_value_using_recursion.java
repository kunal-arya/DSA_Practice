package Easy;

public class Sno_03_find_min_and_max_value_using_recursion {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};

        // minimum value
        System.out.println(findMin(arr,Integer.MAX_VALUE,0));

        // maximum value
        System.out.println(findMax(arr,arr.length));
    }

    static int findMin(int[] arr, int min, int i) {
        if (i == arr.length) {
            return min;
        }

        return findMin(arr,Math.min(min,arr[i]),++i);
    }

    static int findMax(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }

        return Math.max(arr[n - 1], findMax(arr,n - 1));
    }
}
