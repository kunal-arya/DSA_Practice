package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class Sno_49_Array_Subset_of_another_array {
    public static void main(String[] args) {
        int[] arr1 = {11,1,13,21,3,7};
        int[] arr2 = {11,3,7,1};

        // brute force => T.C. - O(n^2) S.C. - O(1)
        boolean brute = bruteForce(arr1,arr2);
        System.out.println(brute);

        // optimised Solution => T.C. - O(n) S.C. - O(n)
        boolean result = opSolution(arr1,arr2);
        System.out.println(result);
    }

    private static boolean bruteForce(int[] arr1, int[] arr2) {
        for (int num: arr2) {
            boolean flag = false;
            for (int n: arr1) {
                if(n == num){
                    flag = true;
                }
            }
            if(!flag) return false;
        }
        return true;
    }

    private static boolean opSolution(int[] arr1, int[] arr2) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();

        for (int n : arr1) {
            hs1.add(n);
        }

        for (int n : arr2) {
            hs2.add(n);
        }

        for (int n : hs2) {
            if(!hs1.contains(n)){
                return false;
            }
        }
        return true;
    }
}
