package Medium;

import java.util.Arrays;

public class Sno_9_Minimize_the_maximum_diff_between_heights {
    public static int minimiseDiff(int[] arr, int n, int k){
        // if there is only one element in the Array
        if(n == 1){
            return 0;
        }

        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];
        int largest = arr[n - 1] - k;
        int smallest = arr[0] + k;
        int min,max;

        for(int i = 1 ; i < n ; i++){
            max = Math.max(largest, arr[i - 1] + k);
            min = Math.min(smallest , arr[i] - k);

            // min cannot be negative b/c height of a tower cannot be negative
            if(min < 0 ){
                continue;
            }

            ans = Math.min(ans, max - min);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 10};
        int n = arr.length;
        int k = 2;
        int ans = minimiseDiff(arr,n,k);
        System.out.println(ans);
    }
}
