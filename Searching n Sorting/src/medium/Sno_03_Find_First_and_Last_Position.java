package medium;

import java.util.Arrays;

public class Sno_03_Find_First_and_Last_Position {
    public static void main(String[] args) {
        int[] arr = {5,7,7,7,7,8,10};
        int target = 7;
        int n = arr.length;

        // Brute Force => O(n)
        // linear search
        int[] brute = bruteForce(arr,target,n);
        System.out.println(Arrays.toString(brute));

        // optimised Solution => O(logN)
        // binary Search
        int[] ans = searchRange(arr,target,n);
        System.out.println(Arrays.toString(ans));
    }

    static int[] bruteForce(int[] arr, int target, int n) {
        int[] ans = {-1,-1};

        // finding first occurrence
        for (int i = 0; i < n ; i++) {
            if(arr[i] == target) {
                ans[0] = i;
                break;
            }
        }

        // finding last occurrence
        for (int i = n - 1; i >= 0 ; i--) {
            if(arr[i] == target) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }

    static int[] searchRange(int[] arr, int target, int n) {
        int[] ans = {-1,-1};

        ans[0] = binarySearch(arr,target,n,true);
        ans[1] = binarySearch(arr,target,n,false);

        return ans;
    }

    static int binarySearch(int[] arr, int target, int n , boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = n - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(target > arr[mid]) {
                start = mid + 1;
            } else if(target < arr[mid] ) {
                end = mid - 1;
            } else {
                ans = mid;

                if(findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
