package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Sno_50_triplet_that_sum_to_a_given_value {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int n = arr.length;
        int x = 13;

        // Brute Force - T.C. - O(n^3)
        boolean brute = bruteForce(arr,n,x);
        System.out.println(brute);

        // Optimised Solution - T.C. - O(n^2) S.C. - O(n) { Think yourself - similar to Sno-29 }
        // use Hashing

        // further optimised Solution - T.C. - O(n^2) S.C. - O(1)
        // using two pointer Approach
        boolean result = opApproach(arr,n,x);
        System.out.println(result);
    }

    private static boolean bruteForce(int[] arr, int n, int x) {
        int count = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i + 1; j < n ; j++) {
                for (int k = j + 1; k < n ; k++) {
                    if(arr[i] + arr[j] + arr[k] == x) return true;
                }
            }
        }
        return false;
    }

    private static boolean opApproach(int[] arr, int n , int x) {
        // sort the array first to use two pointer approach
        Arrays.sort(arr);

        // edge case
        if(n <= 2){
            return false;
        }

        // we have to find three triplets that sum == X
        // for ex - arr[i] + arr[j] + arr[k] == sum;
        // to simplify this, we will do
        // arr[j] + arr[k] == sum - arr[i];
        // we will run a for loop to change arr[i] till n - 2 ( b/c we have to find 3 triplets)
        // use two pointers ( similar what we used in Sno - 29 )
        // first pointer => lo = i + 1
        // second pointer => hi = arr.length - 1
        // rem_sum => k = sum - arr[i];
        // if arr[lo] + arr[hi] < k , lo++ ( to increase the sum )
        // if arr[lo] + arr[hi] > k , hi-- ( to decease the sum )
        // if arr[lo] + arr[hi] == k , return true
        // if for loop ends , return false ( that means we were not able to find a triplet)

        for (int i = 0; i < n - 2; i++) {
            if(i == 0 || (arr[i] != arr[i - 1])) {
                int lo = i+1, hi = n - 1, sum = x - arr[i];
                while (lo < hi) {
                    if(arr[lo] + arr[hi] < sum ) {
                        lo++;
                    } else if (arr[lo] + arr[hi] > sum) {
                        hi--;
                    } else {
                        // we got our ans - arr[lo] + arr[hi] == x - arr[i]
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
