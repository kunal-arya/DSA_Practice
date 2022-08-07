package Medium;

import java.util.HashMap;

public class Sno_20_Longest_Subarray_with_sum_k {

    public static int bruteForce(int[] arr, int k , int n){
        int count = 0, sum = 0;

        for (int i = 0 ; i < n ; i++){
            sum = arr[i];

            if(sum == k){
                count = Math.max(count,1);
                continue;
            }

            for (int j = i + 1; j < n ; j++ ){
                sum += arr[j];

                if(sum == k){
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }

    public static int slidingWindow(int[] arr,int k,int n){
        int max = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        while(j < n){
            // add the current element to the sum
            sum += arr[j];

            if(sum < k){
                j++;
            } else if(sum == k){
                int curr_window = j - i + 1;
                max = Math.max(curr_window,max);
                j++;
            } else if(sum > k){
                while(sum > k){
                    sum -= arr[i];
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static int prefixSum(int[] arr, int k, int n ){
        HashMap<Integer,Integer> hm = new HashMap<>();
        int ans = 0;
        int sum = 0;
        hm.put(0,0);

        for (int i = 0 ; i < n ; i++){
            sum += arr[i];

            int remSum = sum - k;
            if(hm.containsKey(remSum)){
                int position = hm.get(remSum);
                ans = Math.max(ans, i - position + 1);
            }

            if (!hm.containsKey(sum)) {
                hm.put(sum,i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9};
        int k = 15;
        int n = arr.length;

        // Brute Force - O(n^2)
        int brute = bruteForce(arr,k,n);
        System.out.println(brute);

        // optimised => Sliding Window Algorithm - T.C. - O(n)
        // disclaimer : This approach is not going to work if NEGATIVE NUMBERS are given in array or k is -ve
        int result = slidingWindow(arr,k,n);
        System.out.println(result);

        // using prefix sum technique
        int sum = prefixSum(arr,k,n);
        System.out.println(sum);
    }
}
