package Medium;

import java.util.Arrays;

public class Sno_41_Rearrange_Array_Alternately {

    private static long[] bruteForce(long[] arr,int n) {
       int i = 0, j = n - 1;
       long[] result = new long[n];
       for (int k = 0; k < arr.length; k++) {
           if(k % 2 == 0){
               result[k] = arr[j];
               j--;
           } else {
               result[k] = arr[i];
               i++;
           }
       }
       return result;
    }

    private static long[] opSolution(long[] arr, int n) {

        long max = 0L;
        for (long num: arr) {
            max = Math.max(num,max);
        }
        max++;

        int i = 0, j = n - 1, k = 0;
        while (k < n) {
            long eI = arr[i] % max;
            long eJ = arr[j] % max;
            if(k % 2 == 0) {
                arr[k] += max * eJ;
                j--;
                k++;
            } else {
                arr[k] += max * eI;
                i++;
                k++;
            }
        }

        for (int in = 0; in < arr.length; in++) {
            arr[in] /= max;
        }

        return arr;
    }

    public static void main(String[] args) {
        long[] arr = {1,2,3,4,5,6};
        int n = arr.length;

//        // brute force using extra space
        long[] result = bruteForce(arr,n);
        System.out.println(Arrays.toString(result));

        // optimal solution
        long[] op = opSolution(arr,n);
        System.out.println(Arrays.toString(op));
    }
}
