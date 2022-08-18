package Easy;

import java.util.Arrays;

public class Sno_54_Three_way_partitioning {
    public static void main(String[] args) {
        int[] arr = {1,3,2,5,6};
        int a = 3;
        int b = 4;

        // optimised solution
        //using two pointers
        opSolution(arr,a,b);
        System.out.println(Arrays.toString(arr));
    }

    private static void opSolution(int[] arr, int a, int b) {
        int n = arr.length;
        int i = 0;
        int lo = 0;
        int hi = n - 1;
        while(i <= hi) {
            if(arr[i] < a){
                swap(arr,lo,i);
                lo++;
            } else if(arr[i] > b) {
                swap(arr,hi,i);
                hi--;
                continue;
            }
            i++;
        }
    }

    private static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
