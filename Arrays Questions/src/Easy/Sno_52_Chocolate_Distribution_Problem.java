package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sno_52_Chocolate_Distribution_Problem {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int n = arr.length;
        int m = 5;

        // optimised approach
        // we will use sliding window technique
        long result = opSolution(arr,n,m);
        System.out.println(result);
    }

    private static long opSolution(int[] arr, int n, int m ) {
        List<Integer> a = new ArrayList<Integer>();
        for (int num: arr) {
            a.add(num);
        }
        Collections.sort(a);
        System.out.println(a);
        int k = a.size();
        int i = 0;
        int j = 0;
        long ans = Integer.MAX_VALUE;

        while(j < k) {
            int curr_window = j - i + 1;
            if(curr_window < m) {
                j++;
            } else if(curr_window == m) {
                int curr_min = a.get(j) - a.get(i);
                ans = (long) Math.min(ans, curr_min);
                i++;
                j++;
            }
        }
        return ans;
    }
}
