package Hard;

import java.util.HashMap;

public class Sno_28_Subarray_with_K_different_Integers {

    public static int optimisedSol(int[] arr, int k){
        // we have to find the total sub-arrays with exactly k different Integers
        // approach => use sliding window and
        // Find total sub-arrays with atMost (k) and atMost ( k - 1 ) Different Integers
        // ANSWER ==> exactly k = atMost (k) - atMost(k - 1) [[[ THINK WHY ???? ]]]]
        // reason : let's explain using an Example
        // arr : [1,2,1]
        // k : 2
        // atMost k different Integers =>>> [1] , [1,2] , [1,2,1]
        //
        // Why we choose [1] in atMost k because we have to find every sub array in which k distinct Integers are
        // less than k.
        // Get the count of all the subArray sizes using sliding Window -  [1] - 1 \\ [1,2] - 2 \\ [1,2,1] - 3 \\
        // total count = 1 + 2 + 3 = 6
        // atMost k - 1 different Integers ==>>> [1] , [2] , [1]
        // total count = 1 + 1 + 1 = 3
        // Ans => atMost (k) - atMost (k - 1) => 6 - 3 = 3
        // There are Exactly 3 sub-arrays with exactly k different Integers => [1,2] , [2,1] , [1,2,1]
        // HINT on finding the atMost k size sub-arrays count using sliding Window
        // --- use Variable sliding Window
        // --- use a for loop from j = 0 till arr.length - 1;
        // --- use a hashmap Start storing all the values line by line using arr[j] and getOrDefault + 1;
        // --- if ( hm.size() > k ) , run a while loop till ( hm.size() > k ) and start removing char from arr[i]
        //     and if value becomes 0 , remove them. Also do i++ at the end of this while loop.
        // --- and after while loop ends, store all the window size count ( j - i + 1 ) into a variable ans
        // let's understand through an Example - arr = [1,2,3];
        // as previous disucatMost k - [1] , []
        // --- after for loop finished, return ans

        return slidingWindow(arr,k) - slidingWindow(arr,k - 1);
    }

    public static int slidingWindow(int[] arr, int k){
        int i = 0, j = 0, n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();

        int count = 0;
        int result = 0;

        while(j < n){
            hm.put(arr[j], hm.getOrDefault(arr[j],0) + 1);

            if(hm.size() > k){
                while(hm.size() > k){
                    hm.put(arr[i], hm.get(arr[i]) - 1);

                    if(hm.get(arr[i]) == 0){
                        hm.remove(arr[i]);
                    }

                    i++;
                }
            }
            result += j - i + 1;
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int k = 2;
        // output = 7

        // optimised Approach
        int result = optimisedSol(arr,k);
        System.out.println(result);
    }
}
