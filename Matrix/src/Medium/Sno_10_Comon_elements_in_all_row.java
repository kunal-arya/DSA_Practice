package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Sno_10_Comon_elements_in_all_row {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,1,4,8},
                          {8,7,8,5,1},
                          {8,7,7,3,1},
                          {8,1,2,7,9}};
        int[][] arr = {{0, 0, 1},
                     { 1, 2, 0 },
                     { 0, 0, 1}};
        int n = matrix.length;
        int m = matrix[0].length;

        // using hashset
         hashsetSol(arr,arr.length, arr[0].length);

         // using hashmap
        hashmapSol(matrix,n,m);
    }

    private static void hashmapSol(int[][] matrix, int n, int m) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        // put all the values of 1st row in the hashmap with value 1
        // reason: 1) we will use this hashmap to check if these exist in other rows or don't
        // 2) putting everyone's value equal to 1 b/c to avoid duplicates (think!! )
        for (int j = 0; j < m ; j++) {
            hm.put(matrix[0][j], 1);
        }

        // traverse through each row starting from index 1 ( as we already traverse through first)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if hm contains curr_Integer and hm.get( curr_integer ) == 1 , increase the value by 1
                // reason:
                // hm.get ( curr_integer ) == i OR curr_row  => To avoid duplicates b/c if number has value equal to
                // current row that means we have already increased its value
                // for ex - hm { 0 : 1 }, curr_row = { 0,0,1 } and curr_row_index => i = 1
                // if we traverse through row with 1 index , we found 0 , we increase its value by 2
                // so now => hm { 0 : 2 }
                // and if we again found 0 in row with 1 index, we knew this number is duplicate as its value is not
                // equal to curr_row_index.
                if(hm.containsKey(matrix[i][j]) && hm.get(matrix[i][j]) == i) {
                    hm.put(matrix[i][j], hm.get(matrix[i][j]) + 1);

                    // if we reach last row , simply print the number
                    if(i == n - 1){
                        System.out.println(matrix[i][j]);
                    }
                }
            }
        }

        // edge case if n is 1, traverse through map and print all the keys
        // reason: b/c there is only one , that means all of them are common elements
        if(n == 1) {
            for (Map.Entry<Integer,Integer> hmEntry: hm.entrySet()) {
                System.out.println(hmEntry.getKey());
            }
        }
    }

    private static void hashsetSol(int[][] matrix, int n, int m) {
        HashSet<Integer> hs = new HashSet<>();
        int k = 0;
        while (k < m) {
            int curr = matrix[0][k];
            int count = 1;
            for (int i = 1; i < n ; i++) {
                for (int j = 0; j < m ; j++) {
                    if (curr == matrix[i][j] && count == i) {
                        count++;
                    }
                }
            }
            if(count == n){
                hs.add(curr);
            }
            k++;
        }

        ArrayList<Integer> list = new ArrayList<>(hs);
        System.out.println(list);
    }


}
