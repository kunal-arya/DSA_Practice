package Easy;

import javax.swing.event.InternalFrameEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Sno_40_find_common_elements_in_3_sorted_arrays {

    private static Object[] bruteForce(int[] arr1, int[] arr2, int[] arr3) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        for (int nums: arr1){
            hs1.add(nums);
        }

        for (int nums: arr2) {
            if(hs1.contains(nums)){
                hs2.add(nums);
                hs1.remove(nums);
            }
        }

        HashSet<Integer> hs3 = new HashSet<>();

        for (int num: arr3) {
            if(hs2.contains(num)){
                hs3.add(num);
                hs2.remove(num);
            }
        }

        // change the Hashset to Array
        return hs3.toArray();
    }
    public static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3)
    {
        // code here
        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0, k = 0;
        while(i < n1 && j < n2 && k < n3) {
            // duplicates
            while((i - 1) >= 0 && i < n1 && A[i - 1] == A[i]){
                i++;
            }

            while((j - 1) >= 0 && j < n2 && B[j - 1] == B[j]) {
                j++;
            }

            while((k - 1) >= 0 && k < n3 && C[k - 1] == C[k]) {
                k++;
            }

            // if anyone get exahausted
            if(i >= n1 || j >= n2 || k >= n3) break;

            //calculating the result
            if(A[i] == B[j] && A[i] == C[k]) {
                result.add(A[i]);
                i++;
                j++;
                k++;
                continue;
            }

            // moving the pointers
            int min = Math.min(Math.min(A[i],B[j]),C[k]);

            if(min == A[i]) {
                i++;
            } else if(min == B[j]) {
                j++;
            } else if(min == C[k]) {
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,3,3};
        int[] arr2 = {3,3,3};
        int[] arr3 = {3,3,3};
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;
        // brute force
        Object[] brute = bruteForce(arr1,arr2,arr3);
        System.out.println(Arrays.toString(brute));

        // optimised Solution
        // using two pointers
        ArrayList<Integer> result1 = commonElements(arr1,arr2,arr3,n1,n2,n3);
        System.out.println(result1);
    }
}
