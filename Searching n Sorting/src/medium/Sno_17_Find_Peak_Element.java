package medium;

public class Sno_17_Find_Peak_Element {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,4};
        int n = arr.length;
        // output => 5th index is ans

        // brute Force => T.C. - O(n)
        // use Linear Search
        int brute = linearSearch(arr,n);
        System.out.println(brute);

        // Optimised Solution => T.C. - O(logN)
        // use Binary Search
        int result = binarySearch(arr,n);
        System.out.println(result);
    }

    static int linearSearch(int[] arr, int n ) {

        /* edge cases */
        // if first element is peak element
        if(arr[0] > arr[1]) {
            return 0;
        }
        // if last element is peak element
        if(arr[n - 1] > arr[n - 2] ) {
            return n - 1;
        }

        for (int i = 1; i < n - 1;i++ ) {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    static int binarySearch(int[] arr, int n ) {
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if((mid == n - 1 || arr[mid] > arr[mid + 1]) && ( mid == 0 || arr[mid] > arr[mid - 1])) {
                return mid;
            }

            if( mid < n - 1 && arr[mid + 1] > arr[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
