package Medium;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sno_56_Minimum_operation_to_make_array_Palindrome {
    public static void main(String[] args) {
        int[] arr1 = {1,2,5,1};
        // output - 1
        int[] arr2 = {11,14,15,99};
        // output - 3


        // Solution => T.C. - O(n)
        // Two pointer Approach
        int result1 = opSolution(arr1);
        int result2 = opSolution(arr2);
        System.out.println(result1);
        System.out.println(result2);
    }

    private static int opSolution(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i <= j) {
            if(arr[i] == arr[j]){
                i++;
                j--;
            } else if(arr[i] < arr[j]) {
                i++;
                arr[i] += arr[i - 1];
                count++;
            } else {
                j--;
                arr[j] += arr[j + 1];
                count++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return count;
    }
}
