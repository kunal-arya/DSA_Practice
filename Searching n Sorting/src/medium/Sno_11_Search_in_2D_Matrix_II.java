package medium;

import java.util.Arrays;

public class Sno_11_Search_in_2D_Matrix_II {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {11,25,35,45},
                {28,29,37,49},
                {33,34,38,50}
        };
        int n = arr.length;
        int target = 37;

        // Brute Force => T.C. - O(n^2)
        // use linear Search
        int[] brute = bruteForce(arr,n,target);
        System.out.println(Arrays.toString(brute));

        // Optimised Approach => O(n)
        // use Binary Search
        int[] result = binarySearch(arr,n,target);
        System.out.println(Arrays.toString(result));
    }

    static int[] bruteForce(int[][] arr, int n, int target) {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(arr[i][j] == target) {
                    return new int[]{i,j};
                }
            }
        }

        return new int[]{-1,-1};
    }

    static int[] binarySearch(int[][] arr, int n , int target) {
        int r = 0;
        int c = n - 1;

        while(r < n && c >= 0) {
            // target matched
            if(arr[r][c] == target) {
                return new int[]{r,c};
            }

            // if target is bigger
            if(arr[r][c] < target) {
                r++;

            }
            // if target is smaller
              else {
                c--;
            }
        }

        return new int[]{-1,-1};
    }
}
