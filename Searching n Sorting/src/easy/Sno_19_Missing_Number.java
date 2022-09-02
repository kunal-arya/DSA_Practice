package easy;

import java.util.Arrays;

public class Sno_19_Missing_Number {
    public static void main(String[] args) {
        // case 1 - where Missing Number is not N
        int[] arr1 = {9,6,4,2,3,5,7,0,1};
        // case 2 - Where Missing Number is N
        int[] arr2 = {3,0,1,2};

        // brute Force => T.C. - O( NlogN ) S.C. - O(1)
//        int brute = bruteForce(arr2);
//        System.out.println(brute);

        // Optimised Approach => T.C. - O(n)  S.C. - O(1)
        // since array's element is from 0 to N , we will use Cyclic Sort
        int result1 = findMissing(arr1);
        System.out.println(result1);

        int result2 = findMissing(arr2);
        System.out.println(result2);
    }

    static int bruteForce(int[] arr) {
        int n = arr.length;

        // sort the Array
        Arrays.sort(arr);

        // loop over to find the missing;
        int missingNumber = 0;
        for (int num : arr) {
            if(num == missingNumber) {
                missingNumber++;
            } else {
                break;
            }
        }

        return missingNumber;
    }

    static int findMissing(int[] arr) {
        // first sort the array using cyclic sort
        cyclicSort(arr);
        int n = arr.length;
        // start a for loop to check the missing Number
        int correctNum = 0;
        int missing = -1;
        for (int num: arr) {
            if(num == correctNum) {
                correctNum++;
            } else {
                missing = correctNum;
                break;
            }
        }

        if(missing == -1) {
            return n;
        }
        return missing;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIdx = arr[i];

            // Edge Case , where we find the current Number is equal to N
            if(correctIdx == arr.length) {
                i++;
                continue;
            }

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
