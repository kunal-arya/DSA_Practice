package medium;

public class Sno_04_Find_position_of_an_element_in_a_sorted_infinite_array {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;

        // brute force - O(n)
        // we are going to use linear search
        int brute = linearSearch(arr,target);
        System.out.println(brute);

        // Optimised Approach - O(logN)
        // Array is sorted - Use Binary Search
        int result = findingRange(arr,target);
    }

    static int linearSearch(int[] arr, int target) {
        int i = 0;
        while(true) {
            if(target == arr[i]) {
                return i;
            }
            i++;
        }
    }

    static int findingRange(int[] arr, int target) {
        // first find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while(target > arr[end]) {
            int temp = end + 1; // this is our new start

            // double the box value
            // end = previous end - sizeOfBox * 2
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        return binarySearch(arr,target,start,end);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start)/2;

            if(target == arr[mid]){
                return mid;
            }

            if(target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
