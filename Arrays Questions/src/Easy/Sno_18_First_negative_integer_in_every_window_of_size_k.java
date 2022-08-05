package Easy;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sno_18_First_negative_integer_in_every_window_of_size_k {
    public static List<Integer> bruteForce(int[] arr, int n , int k){
        List<Integer> result = new ArrayList<>();

        for (int i = 0 ; i <= n - k; i++){
            for(int j = i ; j < i + k ; j++){
                if(arr[j] < 0){
                    result.add(arr[j]);
                    break;
                }
                if(j == (i + k - 1)){
                    result.add(0);
                    break;
                }
            }

        }

        return result;
    }

    public static long[] optimisedSol(long[] arr, int n , int k){
        // resultant array would a long type array with (n - k + 1) length
        // b/c that's how many subArray of size k is there with n length
        long[] result = new long[n - k + 1];

        // create a empty list to store all the negative Numbers
        List<Integer> negativeList = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(j < n){
            // arr[j] is negative store that value for future use
            if(arr[j] < 0){
                int number = (int)arr[j];
                negativeList.add(number);
            }

            // if window is less than given constant k , increase the window by increasing j
            if((j - i + 1) < k){
                j++;

            // when window hit it's optimal length (i.e. k) , maintain that by increasing both i and j
            } else if((j - i + 1) == k){
                // if size of the negative list is zero , that means no negative number exist in that window, so store zero in the result array
                if(negativeList.size() == 0){
                    result[i] = 0;
                } else {
                    // add the first negative number from the negative number list to the result
                    result[i] = negativeList.get(0);
                    // before increasing i , first check whether the number we are removing from the sliding window by increasing i
                    // is equal the first number in the negative list or not . if yes then , remove the number from the list. We are
                    // doing that b/c we want first negative number and we are checking whether the number we are removing by increasing
                    // i is the first negative in that sliding window or not
                    if(negativeList.get(0) == arr[i]){
                        negativeList.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        long[] arr1 = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        // expected output = [-1, -1, -7, -15, -15, 0]

        // Brute Force Approach => T.C. - O(n^2)
        List<Integer> brute = bruteForce(arr,n,k);
        System.out.println(brute); // output = [-1, -1, -7, -15, -15, 0]

        // optimised Approach => T.C. - O(n) T.C. - O(k)
        long[] optimised = optimisedSol(arr1,n,k);
        System.out.println(Arrays.toString(optimised));
    }
}
