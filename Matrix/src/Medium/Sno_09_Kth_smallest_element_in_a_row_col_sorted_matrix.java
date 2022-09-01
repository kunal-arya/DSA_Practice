package Medium;

import java.util.Arrays;

public class Sno_09_Kth_smallest_element_in_a_row_col_sorted_matrix {
    public static void main(String[] args) {
        int[][] matrix =  {{16, 28, 60, 64},
                          {22, 41, 63, 91},
                          {27, 50, 87, 93},
                          {36, 78, 87, 94 }};
        int n = matrix.length;
        int k = 3;
        // Output - 27

        // brute force => T.C. - O{(n^2)log(n^2)}
        int brute = bruteForce(matrix,n,k);
        System.out.println(brute);

        // optimised Solution
        // using binary Solution
        int result = findKthSmallest(matrix,k);
        System.out.println(result);
    }

    private static int bruteForce(int[][] matrix , int n, int k) {
        int[] arr = new int[n * n];

        int x = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[x++] = matrix[i][j];
            }
        }

        Arrays.sort(arr);

        return arr[k - 1];
    }

    static int findKthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int lo = mat[0][0];
        int hi = mat[n - 1][m - 1];
        int ans = 0;

        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;

            int count = 0;
            for (int r = 0; r < n ; r++) {
                count += countLessOrEqual(mat,r,m,mid);
            }

            if(count >= k) {
                hi = mid - 1;
                ans = mid;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    static int countLessOrEqual(int[][] mat, int r, int m, int target) {
        int lo = 0;
        int hi = m - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;

            if(mat[r][mid] <= target){
                lo = mid + 1;
            } else {
                hi = mid -1;
            }
        }
        return lo;
    }
}
