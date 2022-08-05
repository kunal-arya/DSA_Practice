package Medium;

import java.util.Arrays;

public class Sno_3_Find_the_Kth_max_and_min_element {

    // Brute force Approach ==> Sorting - Time Complexity - O(NlogN)
    public static int sortArray(int[] arr , int k){
        // Sorting the Array
        Arrays.sort(arr);

        // kth smallest Element in the Array
        return arr[k - 1];
    }

    // Optimised Approach ==> Quick Select Algorithm - Time Complexity is O(n) { average case } and O(n^2) { worst case }

    /*
    * lo - lowest index of the array
    * hi - highest index of the array
    * */

    public static int quickSelect(int[] arr, int lo , int hi, int k){

        int pivot = arr[hi];
        // call partition to find pivot's Index => pi - pivot Index
        int pi = partition(arr, pivot, lo, hi);

        if(pi > k){
            return quickSelect(arr, lo , pi - 1, k);
        } else if(pi < k){
            return quickSelect(arr, pi + 1, hi, k);
        } else {
            return arr[pi];
        }
    }

    public static int partition(int[] arr, int pivot, int lo , int hi){
        int i = lo, j = lo;

        while(i <= hi){
            if(arr[i] <= pivot){
                swap(arr,i,j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j - 1;
    }

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;
        // expected output = 7

        int bruteForce = sortArray(arr,k);
        System.out.println(bruteForce); // output is 7

        int optimisedSol = quickSelect(arr,0,arr.length - 1, k - 1);
        System.out.println(optimisedSol);
    }
}
