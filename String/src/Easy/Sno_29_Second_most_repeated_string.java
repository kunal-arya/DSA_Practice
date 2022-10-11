package Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Sno_29_Second_most_repeated_string {
    public static void main(String[] args) {
        String[] arr = {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
        int n = arr.length;

        // using hashmap
        System.out.println(secondMostRepeated(arr,n));
    }

    static String secondMostRepeated(String[] arr, int n) {
        HashMap<String,Integer> hm = new HashMap<>();

        for (String str : arr) {
            hm.put(str,hm.getOrDefault(str,0) + 1);
        }

        // if there is only one element in hashmap, how can we find the second largest
        if (hm.size() == 1) return "";

        int maxValue = -1;
        String ans = "";
        for (Map.Entry<String,Integer> entry : hm.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                ans = entry.getKey();
            }
        }

        hm.remove(ans);

        maxValue = -1;
        ans = "";
        for (Map.Entry<String,Integer> entry : hm.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                ans = entry.getKey();
            }
        }

        return ans;
    }
}
