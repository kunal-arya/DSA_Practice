package Medium;

import java.util.HashMap;

public class Sno_4_Longest_K_unique_characters_substring {

    public static int bruteForce(String s, int k) {
        int n = s.length();
        int answer = -1;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n; j++) {
                int distinct = 0;
                // create an array of size 26 b/c there are 26 character in Alphabets.
                // Initial value is 0
                int count[] = new int[26];

                // count[s.charAt(i) - 'a'] gives us place of that number and we just increasing it by 1;
                // for ex- count['c' - 'a'] = count[2] => c is the 3rd element in the aplhabet.
                // index of array when c values are => 3 - 1 = 2;
                for(int l = i; l < j; l++) {
                    count[s.charAt(l) - 'a']++;
                }

                // checking how many count array values are greater than zero on the full count array.
                // if value is > 0 , add 1 to distinct element
                for(int l = 0; l < 26; l++) {
                    distinct += (count[l] > 0 ? 1 : 0);
                }

                // if distinct element is == k
                if(distinct == k) {
                    answer = Math.max(answer, j - i);
                }
            }
        }
        return answer;
    }

    public static int slidingWindow(String s, int k){
        int n = s.length();
        int i = 0, j = 0;
        int max = -1;
        HashMap<Character,Integer> hm = new HashMap<>();

        while (j < n){
            // calculation
            // put the current character i.e. s[j] into the hashmap and set value to one, if it exist before increase
            // the value
            // reason:
            // storing s[j] - hashmap size will total unique element in the String
            // store 1 or increasing value by 1 - we will use this when we are going to increase i.
            hm.put(s.charAt(j) , hm.getOrDefault(s.charAt(j),0) + 1);


            if(hm.size() < k){
                j++;
            } else if(hm.size() == k){
                max = Math.max(max,j - i + 1);
                j++;
            } else if(hm.size() > k){
                while (hm.size() > k){
                    // decrease the value of s[i] element from the hashmap
                    // reason: b/c we are removing it from the current window
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                    // if value of s[i] in hm becomes 0, remove the character
                    // reason: b/c we are using hm.size to identify how many unique character are there
                    // if value become 0 , that means character at s[i] no longer exist in window
                    if(hm.get(s.charAt(i)) == 0){
                        hm.remove(s.charAt(i));
                    }
                    // increase the i
                    // reason: to decrease the window z
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        // brute force
        int brute = bruteForce(s,k);
        System.out.println(brute);

        // Optimised Approach
        int result = slidingWindow(s,k);
        System.out.println(result);
    }
}
