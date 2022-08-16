package Medium;

import java.util.Arrays;

public class Sno_38_Next_Permutation {

    private static void swap(int[] arr, int i , int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            swap(arr, start,end);
            start++;
            end--;
        }
    }

    private static void optimisedSol(int[] arr) {
        // edge cases
        if(arr.length == 0 || arr == null) return;
        int n = arr.length;
        int k = n - 2;

        // update k -> 1 2 5 4 3
        for (int i = n - 1; i > 0 ; i--){
            if(arr[i] < arr[i - 1]) {
                k--;
            } else {
                break;
            }
        }

        // if k becomes - 1 -> reverse the whole array
        if(k == - 1) {
            reverse(arr, 0, n - 1);
        }
        // swap and reverse to get the ans
        for (int i = n - 1; i > 0 ; i--) {
            if(arr[i] > arr[k]) {
                swap(arr,i,k);
                break;
            }
        }

        reverse(arr,k + 1, n - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,4,3};

//        Approach 1: Brute Force Algorithm
//
//        In this approach, we find out every possible permutation of list formed
//        by the elements of the given array and find out the permutation which is
//        just larger than the given one. But this one will be a very naive approach,
//        since it requires us to find out every possible permutation which will take
//        really long time and the implementation is complex. Thus, this approach is not
//        acceptable at all. Hence, we move on directly to the correct approach.
//
//        Complexity Analysis -
//        Time complexity : O(n!)O(n!). Total possible permutations is n!n!.
//        Space complexity : O(n)O(n). Since an array will be used to store the permutations.



        // optimised Solution
        // we will use an algo to reduce the complexity to O(n)
        optimisedSol(arr);
    }
}
