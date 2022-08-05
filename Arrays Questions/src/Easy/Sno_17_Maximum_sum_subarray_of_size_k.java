package Easy;

import java.util.ArrayList;

public class Sno_17_Maximum_sum_subarray_of_size_k {
    public static int bruteForce(int[] arr, int k){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0 ; i <= n - k ; i++){
            int sum = 0;
            for (int j = i ; j < i + k ; j++){
                sum += arr[j];
            }
            max = Math.max(sum,max);
        }
        return max;
    }

    public static int slidingWindow(ArrayList<Integer> arr, int k){
        int n = arr.size();
        int max = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < n){
            sum += arr.get(j);
            if((j - i + 1) < k){
                j++;
            } else if((j - i + 1) == k){
                max = Math.max(max,sum);
                sum = sum - arr.get(i);
                i++;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1,7};
        int k = 3;

        // Brute Force - O(n^2)
        int brute = bruteForce(arr,k);
        System.out.println(brute);

        ArrayList<Integer> Arr = new ArrayList<>();
        Arr.add(4);
        Arr.add(3);
        Arr.add(2);
        Arr.add(1);
        Arr.add(7);
        // optimised Approach - Sliding Window Algorithm - O(n)
        int optimised = slidingWindow(Arr,k);
        System.out.println(optimised);
    }
}
