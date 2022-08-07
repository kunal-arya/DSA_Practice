package Medium;

public class Sno_26_minimum_Size_Subarray_Sum {

    public static int minSubArray(int[] nums, int target){
        int i = 0, j = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int n = nums.length;
        int k = target;
        while(j < n){
            sum += nums[j];

            if(sum < k){
                j++;
            } else if(sum >= k){
                result = Math.min((j - i + 1),result);

                while(sum > k){
                    sum -= nums[i];
                    i++;
                    if(sum >= k){
                        result = Math.min((j - i + 1), result);
                    }
                }
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
