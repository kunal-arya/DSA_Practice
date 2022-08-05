package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sno_11_Add_to_Array_Form_of_Integer {
    public static List<Integer> solution(int[] num , int k){
        int n = num.length;
        int i = n - 1;
        List<Integer> solution = new ArrayList<>();

        while (i >= 0 || k > 0){
            if(i >= 0){
                solution.add((num[i] + k) % 10);
                k = ( num[i] + k ) / 10;
            } else {
                solution.add(k % 10);
                k /= 10;
            }
            i--;
        }
        Collections.reverse(solution);
        return solution;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        int k = 34;

        List<Integer> ans = solution(arr,k);
        System.out.println(ans);
    }
}
