package medium;

public class Sno_07_Search_in_rotated_sorted_array {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 6;

        // Brute Force => T.C. - O(n)
        // Use linear Search
        int brute = linearSearch(arr,target);
        System.out.println(brute);

        // Optimised Approach => T.C. - O(logN)
        // use Binary Search
        int result = findIndex(arr,target);
        System.out.println(result);
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int findIndex(int[] arr, int target) {

        int n = arr.length;

        // find Pivot
        int pivotIndex = findPivotIndex(arr);

        // if pivot not found
        if(pivotIndex == - 1) {
            return binarySearch(arr,n,target,0,n - 1);
        }

        // if pivot is found
        // case- 1
        if(arr[pivotIndex] == target) {
            return pivotIndex;
        }

        // case - 2
        if(target >= arr[0]){
            return binarySearch(arr,n,target,0,pivotIndex - 1);
        }

        // case - 3 => if( Target < arr[0] )
        return binarySearch(arr,n,target,pivotIndex + 1,n - 1);
    }

    static int findPivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            // case first
            if(mid < end && arr[mid] > arr[mid + 1]){
                return mid;
            }

            // case second
            if(mid > start && arr[mid] < arr[mid - 1]){
                return mid - 1;
            }

            // case third
            if(arr[start] >= arr[mid]) {
                end = mid - 1;
                // case fourth
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    static int binarySearch(int[] arr, int n , int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start)/2;

            if(target == arr[mid]){
                return mid;
            }

            if(target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
