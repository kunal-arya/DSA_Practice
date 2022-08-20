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

        // optimised Solution => do this after you learn binary search
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
}
