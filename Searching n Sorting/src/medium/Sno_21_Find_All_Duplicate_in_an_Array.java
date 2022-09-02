package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sno_21_Find_All_Duplicate_in_an_Array {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        int n = arr.length;
        // output - {3,2}

        // Brute Force
        List<Integer> brute = bruteForce(arr,n);
        System.out.println(brute);

        // Optimised Solution
        // using Cyclic Sort
        List<Integer> result = findAllDuplicates(arr,n);
        System.out.println(result);
    }

    static List<Integer> bruteForce(int[] arr, int n) {
        // sort the array
        Arrays.sort(arr);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) {
                ans.add(arr[i]);
            }
        }
        return ans;
    }

    static List<Integer> findAllDuplicates(int[] arr, int n) {
        // sort the array
        cyclicSort(arr,n);

        List<Integer> ans = new ArrayList<>();

        int correctNum = 1;
        for (int i = 0; i < n ; i++) {
            if(arr[i] != correctNum) {
                ans.add(arr[i]);
            }
            correctNum++;
        }
        return ans;
    }

    static void cyclicSort(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            int correct = arr[i] - 1;
            if(arr[i] == arr[correct]) {
                i++;
            } else {
                swap(arr,i,correct);
            }
        }
    }

    static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
