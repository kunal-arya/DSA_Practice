package Medium;

import java.util.HashMap;

public class Sno_21_Subarray_with_sum_Equals_k {

    public static int bruteForce(int[] arr, int k, int n){
        int count = 0;
        int sum = 0;

        for (int i = 0 ; i < n ; i++){
            sum = arr[i];

            if(sum == k){
                count++;
                continue;
            }

            for (int j = i + 1; j < n ; j++){
                sum += arr[j];

                if(sum == k){
                    count++;
                    continue;
                }
            }
        }
        return count;
    }
    public static int optimisedSol(int[] arr, int k , int n){
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        // we are using hashmap to store
        // Key - the sum as prefix sum technique
        // Value - how many times that sum comes before
        // we will initialize the hashmap by putting
        // key - 0
        // value - 1
        // b/c at starting level sum is zero & it comes 1 time only till now.
        hm.put(0,1);
        int sum = 0;

        for (int i = 0 ; i < n ; i++){
            // add current value of the array
            sum += arr[i];

            // check if hashmap contains (sum - k) before. If yes, increase the ans by
            // value of ( sum - k ) stored in the hashmap
            if(hm.containsKey(sum - k)){
                count += hm.get(sum - k);
            }

            // Put the sum in Hashmap and increase its value by one if it exists before or put one as its initial value
            hm.put(sum, hm.getOrDefault(sum,0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {3,9,-2,4,1,-7,2,6,-5,8,-3,-7,6,2,1};
        int k = 5;
        int n = arr.length;

        // brute force => Time Complexity - O(n^2)
        int brute = bruteForce(arr,k,n);
        System.out.println(brute);

        // try to solve this question using Sliding window algo - BUT that algo will not work with negative numbers either
        // in the array or k being -ve

        // Optimised Solution => Time Complexity - O(n) , Space Complexity O(k)
        int optimised = optimisedSol(arr,k,n);
        System.out.println(optimised);
    }
}
