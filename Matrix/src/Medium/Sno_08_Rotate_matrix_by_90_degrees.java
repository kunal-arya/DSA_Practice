package Medium;

import java.util.Arrays;

public class Sno_08_Rotate_matrix_by_90_degrees {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        int n = arr.length;

        // Brute Force => T.C. - O(n^2) and S.C. - O(n^2)
        bruteForce(arr,n);

        // Optimised Solution => T.C. - O(n^2) and S.C. - O(1)
        opSolution(arr,n);
    }

    private static void bruteForce(int[][] matrix, int n) {
        int[][] newArr = new int[n][n];

        int r = 0, c = n - 1;
        for (int i = 0; i < n ; i++) {
            for (int j = 0 ; j < n ; j++) {
                newArr[r][c] = matrix[i][j];
                r++;
            }
            c--;
            r = 0;
        }

        for (int[] print: newArr) {
            System.out.println(Arrays.toString(print));
        }
    }

    // Trick to solve this question
    // 1. transpose the matrix
    // 2. reverse each row elements
    private static void opSolution(int[][] matrix, int n) {

        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                 swap(matrix,i,j);
            }
        }

        for (int i = 0; i < n ; i++) {
            int l = 0, r = n - 1;
            while (l <= r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }

        for (int[] arr: matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void swap(int[][] matrix, int i , int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}
