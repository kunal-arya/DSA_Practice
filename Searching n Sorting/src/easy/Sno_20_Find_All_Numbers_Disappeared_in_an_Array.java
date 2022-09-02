package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sno_20_Find_All_Numbers_Disappeared_in_an_Array {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};

        // brute force
        List<Integer> brute = bruteForce(arr);
        System.out.println(brute);

        //Optimised Approach
        List<Integer> result = findAllDisappeared(arr);
        System.out.println(result);
    }

    static List<Integer> bruteForce(int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        List<Integer> ans = new ArrayList<>();

        int missing = 1;
        for (int i = 0; i < arr.length; i++) {
            // Skipping the duplicates
            if(i > 0 && arr[i] == arr[i - 1]){
                continue;
            }

            if(arr[i] == missing) {
                missing++;
            } else {
                ans.add(missing);
                missing++;
            }
        }
        return ans;
    }

    static List<Integer> findAllDisappeared(int[] arr) {
        // sort the array using Cyclic sort
        cyclicSort(arr);

        // store the missing Numbers
        List<Integer> ans = new ArrayList<>();

        // traversing through array & whenever you find the element the missing element , store it in ans
        int missing = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != missing) {
                ans.add(missing);
            }
            missing++;
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
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            }
        }
    }
}
