package Medium;

public class Sno_26_minimum_Size_Subarray_Sum {

    public static int minSubArray(int[] nums, int k){
        int i = 0, j = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        while(j < n){
            sum += nums[j];

            if(sum < k){
                j++;
            } else if(sum >= k){
                // save the minimum of current window ( i.e j - i + 1 ) and result till now.
                // we are doing this b/c question ask from the minimum subarray with sum >= k
                result = Math.min((j - i + 1),result);

                // reduce the sum till sum becomes < k b/c
                // to move sliding window forward , we have to make sum < k ( think why ? )
                while(sum > k){
                    sum -= nums[i];
                    i++;

                    // check if sum is still >= k , than
                    // save the minimum of current window ( i.e j - i + 1 ) and result till now. ( think why ? )
                    if(sum >= k){
                        result = Math.min((j - i + 1), result);
                    }
                }
                // increase j
                j++;
            }
        }
        if(result == Integer.MAX_VALUE){
            return 0;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 11;

        // optimised Approach
        int optimised = minSubArray(arr,k);
        System.out.println(optimised);
    }
}
