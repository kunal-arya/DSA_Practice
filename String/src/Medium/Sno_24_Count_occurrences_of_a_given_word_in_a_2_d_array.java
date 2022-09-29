package Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Sno_24_Count_occurrences_of_a_given_word_in_a_2_d_array {
    public static void main(String[] args) {
        char[][] mat = {{'S','N','B','S','N'},
                        {'B','A','K','E','A'},
                        {'B','K','B','B','K'},
                        {'S','E','B','S','E'}};
       String target = "SNAKES";

        int n = mat.length;
        int m = mat[0].length;


        System.out.println(countOccurence(mat,target));

        System.out.println(printOccurence(mat,target));
    }

    static int printOccurence(char[][] mat, String target) {
        int result = 0;
        int n = mat.length;
        int m = mat[0].length;

        char[][] printArr = new char[n][m];

        // putting all the value of print array equal to '-'
        for (int i = 0; i < n ; i++ ) {
            for (int j = 0; j < m ; j++ ) {
                printArr[i][j] = '-';
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                result += printHelper(mat,target,printArr,i,j,0);
            }
        }

        return result;
    }

    private static int printHelper(char[][] mat, String target, char[][] printArr, int i, int j, int idx) {
        if (mat[i][j] != target.charAt(idx)) {
            return 0;
        }

        if (idx == target.length() - 1) {
            // adding last part to the array
            printArr[i][j] = target.charAt(idx);
            for (char[] a : printArr) {
                System.out.println(Arrays.toString(a));
            }
            System.out.println();
            // backtracking the last part
            printArr[i][j] = '-';
            return 1;
        }

        mat[i][j] = '#';
        printArr[i][j] = target.charAt(idx);
        int ans = 0;

        // down
        if (i < mat.length - 1) {
            ans += printHelper(mat,target,printArr,i + 1,j,idx + 1);
        }

        // right
        if (j < mat[0].length - 1 ) {
            ans += printHelper(mat,target,printArr,i,j + 1,idx + 1);
        }

        // up
        if (i > 0) {
            ans += printHelper(mat,target,printArr,i - 1,j,idx + 1);
        }

        // left
        if (j > 0) {
            ans += printHelper(mat,target,printArr,i,j - 1,idx + 1);
        }

        // backtracking
        mat[i][j] = target.charAt(idx);
        printArr[i][j] = '-';

        return ans;
    }

    static int countOccurence(char[][] mat, String target) {
        int n = mat.length;
        int m = mat[0].length;
        int result = 0;

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                result += helper(mat,target,i,j,0);
            }
        }

        return result;
    }

    private static int helper(char[][] mat, String target, int i, int j, int idx) {
        // if mat[i][j] is not equal to the charAt idx in target, return 0
        if (mat[i][j] != target.charAt(idx)) {
            return 0;
        }

        // if mat[i][j] == target.charAt(idx) and idx is the last index, so, we found our ans
        // return
        if (idx == target.length() - 1) {
            return 1;
        }


        mat[i][j] = '#';
        int ans = 0;

        // down
        if (i < mat.length - 1) {
            ans += helper(mat,target,i + 1,j,idx + 1);
        }

        // right
        if (j < mat[0].length - 1) {
            ans += helper(mat,target,i,j + 1,idx + 1);
        }

        // up
        if (i > 0) {
            ans += helper(mat,target,i - 1,j,idx + 1);
        }

        // left
        if (j > 0) {
            ans += helper(mat,target,i,j - 1,idx + 1);
        }

        // backtracking
        mat[i][j] = target.charAt(idx);

        return ans;
    }
}
