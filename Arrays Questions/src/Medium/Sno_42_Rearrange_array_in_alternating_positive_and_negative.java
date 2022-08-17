package Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class Sno_42_Rearrange_array_in_alternating_positive_and_negative {

    public static void main(String[] args) {
        int[] arr = {-1,1,2,3,-3,-2};
        int n = arr.length;

        // brute force
//        int[] result = bruteForce(arr,n);
//        System.out.println(Arrays.toString(result));

        // 1st approach ( where order doesn't matter )
//        opApproach1(arr,n);
//        System.out.println(Arrays.toString(arr));

//
//        // 2nd Approach ( where order does matter )
        opApproach2(arr,n);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] bruteForce(int[] arr, int n) {
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        int[] result = new int[n];

        // adding negatives to negative arraylist and positives to positive Arraylist
        for (int x:arr) {
            if(x < 0){
                negative.add(x);
            } else {
                positive.add(x);
            }
        }
        int x = 0, p = 0;
        for (int i = 0; i < n ; i++) {
            if(i % 2 == 0){
                result[i] = negative.get(x);
                x++;
            } else {
                result[i] = positive.get(p);
                p++;
            }
        }
        return result;
    }

    private static void opApproach1(int[] arr, int n) {
        // put all the positives on the left side of the array and negatives to left using two pointers
        // first pointer start from i = 0 , second from right j = n - 1
        int i = 0, j = n - 1;
        while(i < j) {
            //ignoring all the positives from left
            while(arr[i] > 0) {
                i++;
            }
            // ignoring all the negatives from right
            while (arr[j] < 0) {
                j--;
            }

            // check if i becomes greater than j or not
            if(i >= j){
                break;
            }

            // swapping a negative from left to a positive from right
            swap(arr,i,j);
            i++;
            j--;
        }


        // reinitialize i and j to 0 and n - 1 respectively. swap i to j only if i is on the even index,
        // j -- and i++
        i = 0;
        j = n - 1;
        while (i < j){
            if(i % 2 == 0){
                swap(arr,i,j);
            }
            j--;
            i++;
        }
    }

    private static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void rotateArr(int[] arr, int start, int end) {
        int temp = arr[end];
        while (end > start) {
            arr[end] = arr[end - 1];
            end--;
        }
        arr[end] = temp;
    }

    // start a for loop from 0 to n - 1
    // find the wrong Index
    // we want positive on odd index
    // we want negative on even Index
    // so , we will check if any number is positive and on even index
    // also, check if any number is negative and on odd index
    // store the wrong index
    // {-1,1,2,3,-3,-2}
    // we can see number 2 at index 2 is on the wrong index , store wrong index = 2;

    // rotate the array from first positive to wrong Index(if wrongIndex, is negative)
    // OR if wrongIndex is positive -> rotate the array from first negative to wrongIndex
    // update the wrongIndex
    // if i - wrongindex >= 2 , that means we have skip a number that is on the wrongIndex ,
    // update wrongIndex += 2
    // if i - wrongIndex < 2
    // update wrongIndex = -1
    private static void opApproach2(int[] arr, int n) {

        int wrongIndex = -1;
        for (int i = 0; i < n ; i++) {
            if(wrongIndex == -1) {
                if (arr[i] >= 0 && i % 2 == 0 || arr[i] < 0 && i % 2 != 0) {
                    wrongIndex = i;
                }
            } else {
                if (arr[wrongIndex] >= 0 && arr[i] < 0 || arr[wrongIndex] < 0 && arr[i] >= 0) {
                    rotateArr(arr,wrongIndex,i);

                    if(i - wrongIndex >= 2){
                        wrongIndex += 2;
                    } else {
                        wrongIndex = -1;
                    }
                }
            }
        }
    }
}
