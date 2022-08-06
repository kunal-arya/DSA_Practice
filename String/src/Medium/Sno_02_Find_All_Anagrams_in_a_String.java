package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sno_02_Find_All_Anagrams_in_a_String {

    public static List<Integer> allAnagram(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = s.length();
        int k = p.length();

        // put all the elements of String p into hashmap
        for (int i = 0 ; i < k ; i++){
            char curr_char = p.charAt(i);
            if(hm.containsKey(curr_char)){
                hm.put(curr_char, hm.get(curr_char) + 1);
            } else {
                hm.put(curr_char, 1);
            }
        }

        // to store the count of characters in String p
        int count = hm.size();
        int i = 0 , j = 0;
        while(j < n){
            // decrease value of character in hashmap , if it exists in String s, if value become zero - decrease count
            if(hm.containsKey(s.charAt(j))){
                hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                if(hm.get(s.charAt(j)) == 0){
                    count--;
                }
            }

            int curr_window = j - i + 1;
            if(curr_window < k){
                j++;
            } else if(curr_window == k){
                // check if count becomes zero or not. If yes, add element index to the result list
                if(count == 0){
                    result.add(i);
                }

                // to maintain the window size and take it forward, do exact opposite that you have done when element is checked
                if(hm.containsKey(s.charAt(i))){
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
                    if(hm.get(s.charAt(i)) == 1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        // Brute force - similar to Sno_01

        // optimised Approach - Sliding Window Algorithm - O(n) and O(k)
        List<Integer> result = allAnagram(s,p);
        System.out.println(result);
    }
}
