package Medium;

import java.util.Arrays;

public class Sno_03_Find_median_in_a_row_wise_sorted_matrix {
    public static void main(String[] args) {
        int[][] mat = {{1,2,6},
                      {2,6,9},
                      {3,6,9}};

        // Brute Force => T.C. - O(n*m.log(n*m)) and S.C - O(n*m)
        int brute = bruteForce(mat);
        System.out.println(brute);

        // Optimised Approach => T.C. - O(row*log col) and S.C. - O(1)
        // We will use Binary Search
        int result = findMedian(mat);
        System.out.println(result);
    }

    static int bruteForce(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[] arr = new int[n * m];
        int k = 0;
        //Putting all the values of mat[][] into arr[]
        for ( int i = 0; i < n ; i++ ) {
            for ( int j = 0; j < m ; j++ ) {
                arr[k] = mat[i][j];
                k++;
            }
        }

        // sorting the array
        Arrays.sort(arr);

        // returning medium => n * m is always be ODD ( given in ques )
        int a = arr.length;
        return arr[a/2];
    }

    static int findMedian(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        // Finding min and max value of the Matrix
        for (int r = 0; r < n ; r++) {
            lo = Math.min(mat[r][0], lo);
            hi = Math.max(mat[r][m - 1],hi);
        }
        int ans = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;

            int count = 0;
            // finding the total elements in the matrix smaller than mid
            for (int r = 0; r < n ; r++) {
                count += findCount(mat,r,m,mid);
            }

            // If count <= size/2 -- store ans and update lo = mid + 1
            // else update hi = mid - 1
            if( count <= (m*n) /2 ) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    // helper function to count number of element smaller than given val
    static int findCount(int[][] mat, int r, int m, int val) {
        int lo = 0;
        int hi = m - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;

            if(mat[r][mid] < val){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
