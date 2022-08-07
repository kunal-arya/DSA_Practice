package Medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Sno_22_kth_largest_element_in_the_array {

    public static int bruteForce(Integer[] arr, int k ){
        // sort the array
        Arrays.sort(arr,Collections.reverseOrder());
        return arr[k - 1];
    }

    // partition code Video - https://www.youtube.com/watch?v=if40LxQ8_Xo
    public static int partition(int[] arr,int pivot,int l,int r){
        int i = l, j = l;

        while(i <= r){
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

    public static int quickSelectAlgo(int[] arr, int l , int r,int k){
        // base case
        int pivot = arr[r];
        int pivotIndex = partition(arr,pivot,l,r);
        if(pivotIndex > k){
           return quickSelectAlgo(arr,l,pivotIndex - 1,k);
        } else if(pivotIndex < k) {
            return quickSelectAlgo(arr,pivotIndex + 1, r, k);
        } else {
            return arr[pivotIndex];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        Integer[] arr1 = {3,2,1,5,6,4};
        int k = 2;
        int n = arr.length;

        // Brute force
        int brute = bruteForce(arr1,k);
        System.out.println(brute);

        // optimised Approach
        // Quick Select Algorithm
        int l = 0;
        int r = n - 1;
        int k1 = n - k;
        int result = quickSelectAlgo(arr,l,r,k1);
        System.out.println(result);
    }
}
