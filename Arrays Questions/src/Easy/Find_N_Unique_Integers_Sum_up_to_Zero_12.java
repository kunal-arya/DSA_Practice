package Easy;

// Question URL: https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

import java.util.Arrays;

public class Find_N_Unique_Integers_Sum_up_to_Zero_12 {
    public static int[] arraySumZero(int n) {
        int[] result = new int[n];
        int number = n/2;
        for(int i = 0 ; i < result.length ; i++){
            if(n % 2 == 0){
                if(number == 0){
                    number--;
                }
            }

            result[i] = number;
            number--;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] result = arraySumZero(n);
        System.out.println("Result: " + Arrays.toString(result));
    }
}
