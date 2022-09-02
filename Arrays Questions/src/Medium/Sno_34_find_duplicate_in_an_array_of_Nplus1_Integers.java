package Medium;

import java.util.HashMap;
import java.util.HashSet;

public class Sno_34_find_duplicate_in_an_array_of_Nplus1_Integers {

    public static int bruteForce(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    result = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    private static int hashMap(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i] , hm.getOrDefault(arr[i],0) + 1);
            if(hm.get(arr[i]) > 1) {
                result = arr[i];
                break;
            }
        }
        return result;
    }

    private static int furOptimised(int[] arr) {
        int result = 0;
        for (int i = 0;  i < arr.length ; i++) {
            int index = Math.abs(arr[i]) - 1;
            if(arr[index] < 0) {
                result = arr[i];
                break;
            }
            arr[index] *= (-1);
        }
        return result;
    }

    static int findDuplicate(int[] arr) {
        // Sort the Array
        cyclicSort(arr);

        int duplicate = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != duplicate) {
              return arr[i];
            }
            duplicate++;
        }
        return -1;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if(arr[i] == arr[correct]){
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

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        // output - 2

        // brute Force => T.C. - O(n^2) &  S.C. - O(1)
//        int brute = bruteForce(arr);
//        System.out.println(brute);

        // Optimised Approach => T.C. = O(n) & S.C. - O(n)
        // we will use hashmap
//        int hm = hashMap(arr);
//        System.out.println(hm);

        // Further Optimised Approach => T.C. = O(n) & S.C. = O(1)
//        int result = furOptimised(arr);
//        System.out.println(result);

        // cyclic Sort Approach => T.C. - O(n) & S.C. = O(1)
        int solution = findDuplicate(arr);
        System.out.println(solution);
    }
}
