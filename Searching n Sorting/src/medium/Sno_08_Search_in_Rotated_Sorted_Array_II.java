package medium;

public class Sno_08_Search_in_Rotated_Sorted_Array_II {
    public static void main(String[] args) {
        int[] arr = {1,3};
        int target = 1;

        // brute force => O(n)
        // linear search
        boolean brute = bruteForce(arr,target);
        System.out.println(brute);

        // optimised Approach => O(logN)
        // Binary Search
        boolean result = search(arr,target);
        System.out.println(result);
    }

    // This question is same as Sno - 07 ques , only thing change is that , in this question
    // array values can be duplicate as compared to Sno - 07 ques where all the values are
    // Unique.

    static boolean bruteForce(int[] arr, int target) {
        for (int j : arr) {
            if (j == target) {
                return true;
            }
        }
        return false;
    }

    static boolean search(int[] arr, int target) {
        int n = arr.length;

        // find pivot Index
        int pivotIndex = findPivotIndexWithDuplicates(arr,n);

        // if pivot not found
        if(pivotIndex == -1 ){
            int ans = binarySearch(arr,n,target,0,n - 1);
            return ans != -1;
        }

        // if pivot is found
        if(arr[pivotIndex] == target) {
            return true;
        }


        if(target >= arr[0]) {
            int result = binarySearch(arr,n,target,0,pivotIndex - 1);
            return result != -1;
        }

        int ans = binarySearch(arr,n,target,pivotIndex + 1, n - 1);
        return ans != -1;
    }

    static int findPivotIndexWithDuplicates(int[] arr, int n) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            // case 1
            if(mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            // case 2
            if(mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // so, If start, end and mid are not equal,
            // now , we look if
            // 1) arr[mid] > arr[start]
            // 2) or as we have duplicate elements
            // we could encounter something like this -
            // arr[start] == arr[mid] =>
            // In this case we have to look for one more thing
            // that is if arr[mid] > arr[end] or not.
            //
            // If one of them is true , we know that pivot is in Right
            // for example - {2,2,2,2,3,4,0,1}
            // arr[mid] == arr[start] => 2 == 2
            // and arr[mid] > arr[end] => 2 > 1
            // so pivot should in right of mid. Hence, start = mid + 1
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
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
