package Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Sno_47_elements_that_appear_more_than_n_k_times {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,3,2,3};
        int k = 4;
        // output = [2,3];

        //Brute force
        int brute = bruteForce(arr,k);
        System.out.println(brute);

        // optimised Approach
        // using Hashmap
        int result = opSolution(arr,k);
        System.out.println(result);
    }

    private static int bruteForce(int[] arr, int k) {
        int n = arr.length;
        int sum = n/k;

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < n ; i++) {
            int count = 1;
            for (int j = 0; j < n ; j++) {
                if(i != j){
                    if(arr[i] == arr[j]) count++;
                }
            }
            if(count > sum) hs.add(arr[i]);
        }

        return hs.size();
    }

    private static int opSolution(int[] arr, int k) {
        int n = arr.length;
        if(n == 0 || arr == null) {
            return 0;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();

        int x = n/k;


        for (int num: arr) {
            hm.put(num, hm.getOrDefault(num,0) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer,Integer> mapElement: hm.entrySet()) {
            int key = mapElement.getKey();
            int value = mapElement.getValue();

            if(value > x) {
                result++;
            }
        }
        return result;
    }
}
