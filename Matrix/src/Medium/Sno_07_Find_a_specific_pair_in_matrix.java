package Medium;

public class Sno_07_Find_a_specific_pair_in_matrix {
    public static void main(String[] args) {
        int N = 5;

        int mat[][] = {
                { 1, 2, -1, -4, -20 },
                { -8, -3, 4, 2, 1 },
                { 3, 8, 6, 1, 3 },
                { -4, -1, 1, 7, -6 },
                { 0, -4, 10, -5, 1 }
        };

        // brute force => T.C. - O(n^4)  S.C. - O(1)
        int brute = bruteForce(mat,N);
        System.out.println(brute);

        // Optimised Solution => T.C. - O(n^2) S.C. - O(n^2)
        int result = opSolution(mat,N);
        System.out.println(result);
    }

    private static int bruteForce(int[][] mat, int n) {
        int result = Integer.MIN_VALUE;
        for (int a = 0; a < n - 1 ; a++) {
            for (int b = 0; b < n - 1; b++) {
                for (int c = a + 1; c < n ; c++) {
                    for (int d = b + 1; d < n ; d++) {
                        int curr_value = mat[c][d] - mat[a][b];
                        result = Math.max(result,curr_value);
                    }
                }
            }
        }
        return result;
    }

    private static int opSolution(int[][] mat, int n) {
        int result = Integer.MIN_VALUE;
        int[][] maxArr = new int[n][n];
        int l = n - 1;
        // intializing last value of given array as it is not going to be changes
        maxArr[l][l] = mat[l][l];

        // intializing last column of array
        int maxV = maxArr[l][l];
        for (int j = n - 2; j >= 0; j--) {
            maxV = Math.max( maxV , mat[l][j] );
            maxArr[l][j] = maxV;
        }

        // initializing last row of array
        maxV = maxArr[l][l];
        for (int i = n - 2; i >= 0; i--) {
            maxV = Math.max(maxV, mat[i][l]);
            maxArr[i][l] = maxV;
        }

        //filling rest of the maxArr and update the maxV
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0 ; j--) {
                int curr_value = maxArr[i + 1][j + 1]  - mat[i][j];
                result = Math.max(curr_value,result);

                maxArr[i][j] = Math.max(mat[i][j], Math.max(maxArr[i][j + 1], maxArr[i + 1][j]));
            }
        }
        return result;
    }
}
