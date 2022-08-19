package Medium;

public class Sno_1_Spiral_traversal_of_a_Matrix {


    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15,16}};

        // Solution
        solution(arr);
    }

    private static void solution(int[][] arr) {
        int rF = 0;
        int rL = arr.length - 1;
        int cF = 0;
        int cL = arr[0].length - 1;

        while (rF <= rL && cF <= cL ) {
            // print first row
            for (int i = cF; i <= cL ; i++) {
                System.out.println(arr[rF][i]);
            }
            rF++;

            // print last Column
            for (int i = rF ; i <= rL ; i++) {
                System.out.println(arr[i][cL]);
            }
            cL--;

            if(rL >= rF) {
                // print last row
                for (int i= cL ; i >= cF ; i--) {
                    System.out.println(arr[rL][i]);
                }
                rL--;
            }

            if(cF <= cL) {
                // print first column
                for (int i = rL ; i >= rF ; i--) {
                    System.out.println(arr[i][cF]);
                }
                cF++;
            }
        }
    }
}
