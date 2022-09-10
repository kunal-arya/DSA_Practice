package Easy;

public class Sno_01_find_number_that_only_once {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 4, 5, 3, 4};
        int n = arr.length;
        // Output - 2


        // Brute Force
        int brute = bruteForce(arr,n);
        System.out.println(brute);

        // optimised Solution
        int result = isOnce(arr,n);
        System.out.println(result);
    }

    static int bruteForce(int[] arr, int n) {
        for (int i = 0; i < n ; i++) {
            int value = 0;
            for (int j = i + 1; j < n ; j++) {
                if (arr[i] == arr[j]) {
                    value = 1;
                    break;
                }
            }

            if(value == 0) {
                return arr[i];
            }
        }
        return -1;
    }

    static int isOnce(int[] arr, int n) {
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            ans ^= arr[i];
        }
        return ans;
    }
}
