package medium;

public class Sno_15_Index_of_First_1_in_a_Binary_Sorted_Infinite_Array {
    public static void main(String[] args) {
        int[] arr = {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        // output = 10

        // brute Force => T.C. - O(n)
        // use linear Search
        int brute = linearSearch(arr);
        System.out.println(brute);

        // Optimised Approach => T.C. - O(logN)
        // use Binary Search
        int result = searchFirst(arr);
        System.out.println(result);
    }

    static int linearSearch(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                return i;
            }
        }
        return -1;
    }

    static int searchFirst(int[] arr) {
        // start by taking window size of 2
        int start = 0;
        int end = 2;

        while (arr[end] < 1) {
            int newStart = end + 1;
            // increase window size by *2;
            // window size => end - start + 1
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(arr,start,end);
    }

    static int binarySearch(int[] arr, int start, int end) {
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == 1){
                ans = mid;
                if(mid > start) {
                    end = mid - 1;
                }
            }

            if(arr[mid] < 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
