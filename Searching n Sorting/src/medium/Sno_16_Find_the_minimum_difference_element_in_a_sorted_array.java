package medium;

public class Sno_16_Find_the_minimum_difference_element_in_a_sorted_array {
    public static void main(String[] args) {
        int[] arr = {1,3,8,10,12,15};
        int n = arr.length;
        int key = 12;
        // output = 2

        // Brute Force => T.C. - O(n)
        // using linear Search
        int brute = linearSearch(arr,n,key);
        System.out.println(brute);

        // Optimised Approach => T.C. - O(logN)
        // Using Binary Search
        int result = findMin(arr,n,key);
        System.out.println(result);
    }

    static int linearSearch(int[] arr, int n, int key ) {
        int min = Integer.MAX_VALUE;

        // if element is in the array
        for (int num: arr) {
            if(num == key) {
                return 0;
            }
        }

        // if any value is not returned from the above, then
        // if element is not in the array
        for (int i = 0; i < n - 1; i++) {
            int min_diff = Math.abs(arr[i + 1] - arr[i]);
            min = Math.min(min,min_diff);
        }

        return min;
    }

    static int findMin(int[] arr, int n , int key ) {
        int[] fCValues = floorCeil(arr,n,key);

        // element found, return 0;
        if(fCValues[0] == fCValues[1]) {
            return 0;
        }

        // element not found
        return Math.min(Math.abs(fCValues[0] - key) , Math.abs(fCValues[1] - key));
    }

    static int[] floorCeil(int[] arr, int n , int target) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == target ) {
                return new int[]{arr[mid],arr[mid]};
            }

            if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return new int[]{arr[start],arr[end]};
    }
}
