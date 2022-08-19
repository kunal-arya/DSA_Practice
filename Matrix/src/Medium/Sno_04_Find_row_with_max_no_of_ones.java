package Medium;

public class Sno_04_Find_row_with_max_no_of_ones {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 1},
                {0, 0, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        // brute force
        int brute = bruteForce(matrix);
        System.out.println(brute);

        // optimised approach
        int result = opSolution(matrix);
        System.out.println(result);

        // furOptimised Solution
        int res = furSolution(matrix);
        System.out.println(res);
    }

    private static int bruteForce(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < arr.length ; i++) {
            int count = 0;
            for (int j = 0; j < arr[0].length ; j++) {
                if(arr[i][j] == 1 ) {
                    count++;
                }
            }
            if(max < count) {
                max = count;
                result = i;
            }
        }
        return result;
    }

    private static int opSolution(int[][] matrix) {
        int c = matrix[0].length;
        int r = matrix.length;

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                if(matrix[j][i] == 1) {
                    return j;
                }
            }
        }

        return -1;
    }

    private static int furSolution(int[][] matrix) {
        int c = matrix[0].length;
        int r = matrix.length;
        int max_row_so_far = 0;
        int j = c - 1;
        for (int i = 0; i < r ; i++) {
            while (j >= 0 && matrix[i][j] == 1) {
                j--;
                max_row_so_far = i;
            }
        }

        if (max_row_so_far == 0 && matrix[0][c - 1] == 0) {
            return -1;
        }

        return max_row_so_far;
    }
}
