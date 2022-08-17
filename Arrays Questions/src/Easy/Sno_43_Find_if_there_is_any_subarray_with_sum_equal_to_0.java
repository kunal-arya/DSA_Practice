package Easy;

import java.util.HashSet;

public class Sno_43_Find_if_there_is_any_subarray_with_sum_equal_to_0 {

    private static boolean findsum(int arr[],int n)
    {
        //Your code here
        HashSet<Integer> hs = new HashSet<>();
        hs.add(0);
        int sum = 0;
        for(int i = 0; i < n ; i++) {
            sum += arr[i];
            if(hs.contains(sum)){
                return true;
            }
            hs.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,-3,1,6};
        int n = arr.length;

        // optimised solution
        boolean result = findsum(arr,n);
        System.out.println(result);
    }
}
