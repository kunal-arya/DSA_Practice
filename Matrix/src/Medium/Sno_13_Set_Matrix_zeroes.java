package Medium;

import java.util.Arrays;

public class Sno_13_Set_Matrix_zeroes {
    public static void main(String[] args) {
        int[][] mat  = {{1,1,1},
                        {1,0,1},
                        {1,1,1}};
        int n = mat.length;
        int m = mat[0].length;

        // Brute Force => T.C. - O(n * m ) x ( n + m )  and S.C. - O(1)
        // ask the interviewer if the values of matrix are negative or not, If all the matrix's values are positive
        // use this brute force approach as your first Solution
//        bruteForce(mat,n,m);

        // better approach => T.C. - O(n * m + n * m) and S.C. - O(n) + O(m)
//        betterApproach(mat,n,m);

        // optimal Approach => T.C. - O(n * m) and S.C. - O(1)
        opSolution(mat,n,m);
     }

     private static void bruteForce(int[][] mat, int n, int m) {

        // traversing through the matrix
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                // if matrix[i][j] is equal to zero , traverse its rows and column and make every element value -1
                // except if value is 0.
                if(mat[i][j] == 0) {

                    // traversing through column
                    for (int c = 0; c < m ; c++) {
                        // if element is not zero, change it's value to -1
                        if(mat[i][c] != 0) {
                            mat[i][c] = -1;
                        }
                    }

                    // traversing through row
                    for (int r = 0; r < n ; r++) {
                        // if element is not zero, changing it's value to -1
                        if(mat[r][j] != 0) {
                            mat[r][j] = -1;
                        }
                    }
                }

            }
        }

        // Traverse through the matrix again and make all the value of -1 to zero
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(mat[i][j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }

        // printing the matrix
         for(int[] arr: mat) {
             System.out.println(Arrays.toString(arr));
         }
     }

     private static void betterApproach(int[][] mat, int n , int m) {
        int[] row = new int[n];
        int[] col = new int[m];
         // filling values to created two arrays
         // reason: b/c default value is zero, we want to change it
         Arrays.fill(row,-1);
         Arrays.fill(col, -1);


         // traversing through the matrix and if we found a zero, we make row[i] == 0 and col[j] == 0
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(mat[i][j] == 0) {
                    row[i] = 0;
                    col[i] = 0;
                }
            }
        }

        // traversing through the matrix again and if we found row[i] == 0 OR column[j] == 0 , we change it to Zero
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(row[i] == 0 || col[j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Print the Matrix
        for (int[] arr: mat) {
            System.out.println(Arrays.toString(arr));
        }
     }

     private static void opSolution(int[][] mat, int n , int m) {
        // boolean if first row's value should be zero or not
        boolean rowFirstZero = false;

        // traverse through the matrix
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                // if an element is zero
                if(mat[i][j] == 0) {
                    // make that column of first row == 0
                    mat[0][j] = 0;

                    // make that row of first column == 0
                    // but before that check if i > 0 or not
                    // reason: if arr[0][0] should be zero, we don't update it , but update the boolean
                    if(i > 0) {
                        mat[i][0] = 0;
                    } else {
                        rowFirstZero = true;
                    }
                }
            }
        }

        // traverse through matrix again from row and col index starting from 1 ( as we are using 0th row and col )
        for (int r = 1; r < n ; r++) {
            for (int c = 1; c < m ; c++) {
                // if that column value of the first row is zero OR
                // if that row value of the first column is zero
                // make the matrix[r][c] == 0
                if(mat[0][c] == 0 || mat[r][0] == 0 ) {
                    mat[r][c] = 0;
                }
            }
        }

         // NOW WE LOOK INTO THE 0th ROW AND COLUMN of the MATRIX  //
        // if mat[0][0] == 0 , make the whole first column zero
        if(mat[0][0] == 0) {
            for (int r = 0; r < n ; r++) {
                mat[r][0] = 0;
            }
        }

        // if rowFirstZero is true, make the first row 0
        if(rowFirstZero) {
            for (int c = 0; c < m ; c++) {
                mat[0][c] = 0;
            }
        }

        for (int[] arr: mat) {
            System.out.println(Arrays.toString(arr));
        }
     }
}
