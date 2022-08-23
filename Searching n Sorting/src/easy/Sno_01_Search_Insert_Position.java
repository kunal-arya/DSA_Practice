package easy;

public class Sno_01_Search_Insert_Position {
    public static void main(String[] args) {

        int[] arr = {1,3,5,6};
        int target = 5;
        // Output: 2

        // Brute Force - O(n)
        // using linear search
        int brute = linearSearch(arr,target);
        System.out.println(brute);

        // optimised solution - O(logN)
        // using binary search
        int sol = binarySearch(arr,target);
        System.out.println(sol);
    }

    static int linearSearch(int[] arr, int target) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= target) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if(target == arr[mid]) {
                return mid;
            }

            if(target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return start;
    }
}
