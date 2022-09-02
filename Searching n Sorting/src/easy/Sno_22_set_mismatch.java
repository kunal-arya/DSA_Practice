package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sno_22_set_mismatch {
    public static void main(String[] args) {
        int[] arr = {4,2,1,2};
        int n = arr.length;
        // output - {2,3}

        // Brute force
        int[] brute = bruteForce(arr,n);
        System.out.println(Arrays.toString(brute));

        // Optimised Solution
        List<Integer> result = setMisMatch(arr,n);
        System.out.println(result);
    }

    static int[] bruteForce(int[] arr, int n) {
        // sort the array
        Arrays.sort(arr);
        int correctNum = 1;
        int duplicate = -1;
        int missing = -1;
        for (int i = 0; i < n ; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) {
                duplicate = arr[i];
                continue;
            }

            if(arr[i] != correctNum) {
                missing = correctNum;
            }
            correctNum++;
        }

        return new int[]{duplicate,missing};
    }

    static List<Integer> setMisMatch(int[] arr, int n) {
        // first sort the array using cyclic sort
        cyclicSort(arr);

        // storing the ans
        List<Integer> ans = new ArrayList<>();

        // start a for loop to find Missing Number and Duplicate Number
        int correctNum = 1;
        int missing = -1;
        int duplicate = -1;
        for (int i = 0; i < n ; i++) {
            if(arr[i] == correctNum) {
                correctNum++;
            } else {
                missing = correctNum;
                duplicate = arr[i];
                ans.add(missing);
                ans.add(duplicate);
                break;
            }
        }

        return ans;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIdx = arr[i] - 1;
            if(arr[i] == arr[correctIdx]){
                i++;
            } else {
                swap(arr,i,correctIdx);
            }
        }
    }

    static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
