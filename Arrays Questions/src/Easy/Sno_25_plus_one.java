package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sno_25_plus_one {
    public static int[] plusOne(int[] digits) {
        int lastIndex = digits.length - 1;
        int k = 1;
        List<Integer> result = new ArrayList<>();
        int i = lastIndex;
        while(i >= 0 || k > 0){
            if(i >= 0){
                result.add((digits[i] + k) % 10);
                k = (digits[i] + k) / 10;
            } else {
                result.add(k % 10);
                k /= 10;
            }
            i--;
        }

        Collections.reverse(result);
        int[] sol = new int[result.size()];

        for (int j = 0 ; j < result.size(); j++ ){
            sol[j] = result.get(j);
        }
        return sol;
    }

    public static void main(String[] args) {
        int[] arr = {9,9};

        // brute force => similar to Sno - 11

        // optimised solution
        int[] result = plusOne(arr);
        System.out.println(Arrays.toString(result));

    }
}
