package Medium;

import java.util.Arrays;
import java.util.HashSet;

public class Sno_46_longest_consecutive_subsequence {
    public static void main(String[] args) {
        int[] arr = {9 ,8, 7, 6, 5, 4, 9, 8, 7, 6, 5, 4, 4};
        int n = arr.length;
        // output - 6

        // Brute force => T.C. - O(n*logn)
//        int brute = bruteForce(arr,n);
//        System.out.println(brute);

        // optimised solution
        int result = opSolution(arr,n);
        System.out.println(result);
    }

    private static int bruteForce(int[] arr, int n) {

        if(n <= 0 || arr == null){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int total = 1;
        Arrays.sort(arr);
        for (int i = 1; i < n ; i++) {
            if(arr[i] == arr[i - 1] + 1) {
                total++;
            } else {
                max = Math.max(total,max);
                total = 1;
            }
        }
        max = Math.max(total,max);

        return max;
    }

    private static int opSolution(int[] arr, int n) {
        // Trick to solve this ques
        // made a hashset and put all the elements of arr to hashset
        // loop over hashset ( b/c it will eliminate duplicates also )
        // find if hashset.contains(arr[i] - 1) or not
        // if yes , don't do anything
        // if no, start a while loop till hashset.contains(arr[i] + 1)
        // and keep counting
        // after while loop end
        // we will have the count of consecutive subsequence like 2,3,4,5 or 6,7,8,9
        // update the longest Consecutive if count if more than that.
        if(n == 0 || arr == null) {
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();
        int longestStreak = 1;
        for (int num: arr) {
            hs.add(num);
        }

        for (int num: hs) {
            if(!hs.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;

                while(hs.contains(currentNum + 1)){
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak,currentStreak);
            }
        }
        return longestStreak;
    }
}
