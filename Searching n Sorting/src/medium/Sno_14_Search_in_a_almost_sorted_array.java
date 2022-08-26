package medium;

public class Sno_14_Search_in_a_almost_sorted_array {
    public static void main(String[] args) {
        int[] arr =  {10, 3, 40, 20, 50, 80, 70};
        int key = 40;
        // output = 2

        // brute force => O(n)
        int brute = linearSearch(arr,key);
        System.out.println(brute);

        // Optimised Approach => O(logN)
        int result = binarySearch(arr,key);
        System.out.println(result);
    }

    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                return mid;
            } else if(mid > start && arr[mid - 1] == target) {
                return mid - 1;
            } else if(mid < end && arr[mid + 1] == target) {
                return mid + 1;
            }

            if(arr[mid] > target) {
                end = mid - 2;
            } else {
                start = mid + 2;
            }
        }

        return -1;
    }
}
