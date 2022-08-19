package Medium;

import java.util.ArrayList;
import java.util.List;

public class Spiral_matrix_11 {
    public static List<Integer> spiralMatrix(int[][] matrix){
        int sR = 0;
        int eR = matrix.length - 1;
        int sC = 0;
        int eC = matrix[0].length - 1;
        /*
            sR = starting Row
            eR = ending Row
            sC = starting Column
            eC = ending Column
        */
        List<Integer> result = new ArrayList<Integer>();
        while(sR <= eR && sC <= eC){

            // Left to Right
            for(int i = sC ; i <= eC ; i++){
                result.add(matrix[sR][i]);
            }
            sR++;

            //  top to down
            for(int i = sR ; i <= eR ; i++){
                result.add(matrix[i][eC]);
            }
            eC--;

            // right to left
            if(eR >= sR) {
                for (int i = eC; i >= sC; i--) {
                    result.add(matrix[eR][i]);
                }
                eR--;
            }
            // bottom to top
            if(eC >= sC) {
                for (int i = eR; i >= sR; i--) {
                    result.add(matrix[i][sC]);
                }
                sC++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
    int[][] matrix = {{1,2,3},
                      {5,6,7}};
    List<Integer> result = spiralMatrix(matrix);
        for(int i : result){
            System.out.println(i);
        }
    }
}
