package Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Sno_33_First_Missing_Positive {

    public static void main(String[] args) {
        int[] arr = {2,0,3,1};
        int n = arr.length;

//// brute force T.C. - O(nlogn) S.C. - O(1)
//        int brute = bruteForce(arr);
//        System.out.println(brute);
//
//////        // Optimised Approach T.C. - O(n) S.C - O(n)
//        int hm = hashMapSol(arr);
//        System.out.println(hm);
//
//
//        // further Optimised Approach T.C. - O(n) S.C. - O(1)
//        int result = furOptimised(arr);
//        System.out.println(result);

        // BEST SOLUTION ( Cyclic Sort ) => T.C. - O(n) S.C. - O(1)
        int best = findMissing(arr,n);
        System.out.println(best);
    }

    private static int bruteForce(int[] arr) {
       // first sort the array
        Arrays.sort(arr);

        int k = 1;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == k) {
                k++;
            }
        }
        return k;
    }

    private static int hashMapSol(int[] arr) {
        HashSet<Integer> hm = new HashSet<>();

        for (int i = 0; i < arr.length ; i++) {
            hm.add(arr[i]);
        }
        int k = 1;
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            if(hm.contains(k)) {
                k++;
            } else {
                result = k;
                break;
            }
        }
        return result;
    }

    private static int furOptimised(int[] arr ) {
        // removing all the negative number by replacing them with 0
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] < 0) {
                arr[i] = 0;
            }
        }

       // for loop to store the negative value
        for (int i = 0; i < arr.length ; i++) {
            int index = Math.abs(arr[i]) - 1;
            if( index >= 0 && index < arr.length )  {
                  if (arr[index] == 0) {
                    arr[index] = (-1) * (arr.length + 1);
                } else if(arr[index] > 0){
                    arr[index] *= (-1);
                }
            }
        }

        // for loop to return first positive value Index
        for (int i = 1; i < arr.length + 1; i++) {
            if(arr[i - 1] >= 0) {
                return i;
            }
        }
        // if for loop doesn't return any value
        return arr.length + 1;
    }

    static int findMissing(int[] arr, int n) {
        // sort the array using cyclic sort
        cyclicSort(arr,n);

        int correctNum = 1;


        for (int i = 0 ; i < n ; i++) {
            if(arr[i] != correctNum) {
                return correctNum;
            }

            correctNum++;
        }

        return correctNum;
    }

    static void cyclicSort(int[] arr, int n) {
        int i = 0;
        while(i < n) {
            int correct = arr[i] - 1;

            // dealing with edge case
            if(arr[i] <= 0 || arr[i] > n) {
                i++;
                continue;
            }

            if( arr[i] == arr[correct] ) {
                i++;
            } else {
                swap(arr,i,correct);
            }
        }
    }

    static void swap(int[] arr, int i , int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
