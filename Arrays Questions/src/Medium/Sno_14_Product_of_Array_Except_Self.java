package Medium;

import java.util.Arrays;

public class Sno_14_Product_of_Array_Except_Self {
    public static int[] bruteForce(int[] arr, int n){
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
         int product = 1;
         for (int j = 0 ; j < n ; j++){
             if(i == j){
                 continue;
             }
             product *= arr[j];
         }
         ans[i] = product;
        }
        return ans;
    }

    public static int[] optimisedSol(int[] arr , int n){
        int[] result = new int[n];

        int prefix = 1;
        for (int i = 0 ; i < n ; i++){
            result[i] = prefix;
            prefix *= arr[i];
        }

        int suffix = 1;
        for (int i = n - 1 ; i >= 0 ; i--) {
            result[i] *= suffix;
            suffix *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int n = arr.length;

        // brute force approach => time complexity = O(n^2) and space Complexity = O(1)
        int[] brute = bruteForce(arr,n);
        System.out.println(Arrays.toString(brute));

        // optimised Approach => time complexity = O(n) and space Complexity = O(1)
        int[] optimised = optimisedSol(arr,n);
        System.out.println(Arrays.toString(optimised));
    }
}
