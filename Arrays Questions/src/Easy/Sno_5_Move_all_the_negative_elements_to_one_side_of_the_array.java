package Easy;

import java.util.Arrays;

public class Sno_5_Move_all_the_negative_elements_to_one_side_of_the_array {
    public static void partition(int[] arr, int l , int r, int pivot){
        int i = l , j = l;

        while(i <= r){
            if(arr[i] >= pivot){
                swap(arr,i,j);
                i++;
                j++;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void segregateElements(int arr[], int n)
    {
        // Your code goes here
        int[] result = new int[n];
        int j = 0;
        // to store all positive value first in the array
        for(int i = 0 ; i < n ; i++){
            if(arr[i] >= 0){
                result[j] = arr[i];
                j++;
            }
        }

        // to store all negative value first in the array
        for(int i = 0 ; i < n ; i++){
            if(arr[i] < 0){
                result[j] = arr[i];
                j++;
            }
        }

        j = 0;
        // changing the original array
        for(int i = 0 ; i < n ; i++){
            arr[i] = result[j];
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-5, 7, -3, -4, 9, 10, -1, 11};
        int n = 8;

        // Method 1 => using partition - Time complexity - O(n) and Space Complexity - O(1)
        // issue with this method => It will change the order of the elements in the Array
        partition(arr,0,n - 1,0);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {-5, 7, -3, -4, 9, 10, -1, 11};
        // Method 2 => creating an extra array - time complexity - O(n) and Space Complexity - O(n)
        // This method will not change the order of the elements in the array but space complexity is not constant
        segregateElements(arr1,n);
        System.out.println(Arrays.toString(arr1));
    }
}
