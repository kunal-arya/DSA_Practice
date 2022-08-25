package easy;

public class Sno_09_Rotation_count_in_sorted_array {
    public static void main(String[] args) {
        int[] arr = {4,5,1,2,3};
        int n = arr.length;
        // Brute Force => O(n)
        // using linear search
        int brute = linearSearch(arr,n);
        System.out.println(brute);

        // Optimised Approach => O(logN)
        // using Binary Search
        int result = search(arr,n);
        System.out.println(result);
    }

    static int linearSearch(int[] arr, int n) {
        // first find pivot
        int pivot = 0;
        int max = arr[0];
        for (int i = 1; i < n ; i++) {
            if(max < arr[i]) {
                max = arr[i];
                pivot = i;
            }
        }

        // edge case - If array is not rotated at all
        if(arr[pivot] == n - 1){
            return 0;
        }

        // window size from 0 to pivot => pivot - 0 + 1 = pivot + 1
        return pivot + 1;
    }

    static int search(int[] arr, int n) {
        // first find pivot
        int pivot = findPivot(arr,n);

        // edge case
        if(pivot == -1){
            return 0;
        }

        return pivot + 1;
    }

    static int findPivot(int[] arr, int n) {
        int start = 0;
        int end = n - 1;
        while (start <= end){
            int mid = start + (end - start)/2;

            // case 1
            if(mid < end  && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // case 2
            if(mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // case 3
            if(arr[start] <= arr[mid] ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
