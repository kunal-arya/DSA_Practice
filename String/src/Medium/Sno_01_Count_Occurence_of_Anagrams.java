package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sno_01_Count_Occurence_of_Anagrams {

    public static int bruteForce(String str, String ptr){
        int ans = 0;
        int k = ptr.length();
        int n = str.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        // put all the element in the HashMap
        for (int i = 0 ; i < k ; i++){
            char curr_char = ptr.charAt(i);
            if(hm.containsKey(curr_char)){
                hm.put(curr_char, hm.get(curr_char) + 1);
            } else {
                hm.put(curr_char, 1);
            }
        }

        for (int i = 0 ; i <= n - k; i++){
            HashMap<Character,Integer> hm2 = new HashMap<>();
            for (int j = i ; j < i + k ; j++){
                char curr_char = str.charAt(j);
                if(hm2.containsKey(curr_char)){
                    hm2.put(curr_char, hm2.get(curr_char) + 1);
                } else {
                    hm2.put(curr_char, 1);
                }
            }
            boolean value = hm.equals(hm2);
            if(value){
                ans++;
            }
        }
        return ans;
    }
    public static int slidingWindow(String str, String ptr){
        int ans = 0;
        int k = ptr.length();
        HashMap<Character,Integer> hm = new HashMap<>();

        // Put all elements of pattern ptr in map
        for (int i = 0 ; i < ptr.length(); i++){
            char curr_char = ptr.charAt(i);
            if(hm.containsKey(curr_char)){
                hm.put(curr_char, hm.get(curr_char) + 1);
            } else {
                hm.put(curr_char,1);
            }
        }

        int count = hm.size();
        int i = 0, j = 0;
        while (j < str.length()){
            // check if current char { i.e. str.charAt(j) } is in hashmap or not , If it is in hashmap ,
            // decrease its count by one. Also, check if value of current Char becomes zero or not , if it becomes
            // zero , decrease count by one

            // b/c we use hashmap to take the count of every number occurence in the ptr and if we find that number in
            // str , we decrease its value and if values of all the numbers in hashmap become zero , that means we got our
            // anagram. To refrain from checking everytime if all the numbers in hashmap become zero or not , we are using
            // count variable , if it becomes zero that means values of all the numbers in hashmap becomes zero.

            char curr_char = str.charAt(j);
            if(hm.containsKey(curr_char)){
                hm.put(curr_char , hm.get(curr_char) - 1);
                if(hm.get(curr_char) == 0){
                    count--;
                }
            }

            if((j - i + 1) < k){
                j++;
            } else if((j - i + 1) == k){
                // if count becomes zero , that means all values of keys in hashmaps are zero, that means we get our anagram
                if(count == 0){
                    ans++;
                }

                // check if character at str.charAt(i) is in hm or not , if yes , increase value of key in hashmap
                // before increasing count of i b/c to change the current window by increasing both i & j
                // we have to restore any changes made in (a) step
                // and check if value of str.charAt(i) becomes 1 or not , if yes increase the count by 1 b/c that means
                // it was zero before we added 1 in the above step.
                if(hm.containsKey(str.charAt(i))){
                    hm.put(str.charAt(i), hm.get(str.charAt(i)) + 1);
                    if(hm.get(str.charAt(i)) == 1){
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String str = "forxxorfxdofr";
        String pattern = "for";

        // Brute Force
        int brute = bruteForce(str,pattern);
        System.out.println(brute);

        // optimised Solution - Sliding Window
        int sol = slidingWindow(str,pattern);
        System.out.println(sol);
    }
}
