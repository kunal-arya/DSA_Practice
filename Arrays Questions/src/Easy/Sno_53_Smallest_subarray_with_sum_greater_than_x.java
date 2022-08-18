package Easy;

public class Sno_53_Smallest_subarray_with_sum_greater_than_x {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 0, 19};
        int x = 51;
        int n = arr.length;
        // output = 3

        // optimised Solution
        // we will use sliding window technique
        int result = opSolution(arr,x,n);
        System.out.println(result);
    }

    private static int opSolution(int[] arr, int x , int n) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while(j < n) {
            sum += arr[j];

            if(sum <= x) {
                j++;
            } else {
                ans = Math.min(ans, j - i + 1);

                while(sum > x) {
                    sum -= arr[i];
                    i++;
                    if(sum > x) {
                        ans = Math.min(ans,j - i + 1);
                    }
                }

                j++;
            }
        }
        return ans;
    }
}
