package Medium;

import java.util.HashMap;

public class Sno_05_Longest_Substring_Without_Repeating_character {

         // This function returns true if all characters in
         // str[i..j] are distinct, otherwise returns false
    public static Boolean areDistinct(String str, int i, int j)
    {
        // Note : Default values in visited are false
        boolean[] visited = new boolean[26];

        for(int k = i; k <= j; k++)
        {
            if (visited[str.charAt(k) - 'a'])
                return false;

            visited[str.charAt(k) - 'a'] = true;
        }
        return true;
    }

    // Returns length of the longest substring
// with all distinct characters.
    public static int bruteForce(String str)
    {
        int n = str.length();

        // Result
        int res = 0;

        for(int i = 0; i < n; i++)
            for(int j = i; j < n; j++)
                if (areDistinct(str, i, j))
                    res = Math.max(res, j - i + 1);

        return res;
    }
    public static int slidingWindow(String s){

        if(s.length() == 0){
            return 0;
        }

        int i = 0, j = 0, max = Integer.MIN_VALUE;
        HashMap<Character,Integer> hm = new HashMap<>();

        while (j < s.length()){
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j),0) + 1);

            int curr_window = j - i + 1;
            // understanding why we are comparing hashmap size with current window using an example
            // for example - suppose , current substring is - 'aabc'
            // unique element in this substring is => 3 (i.e. size of HashMap )
            // total element in this substrings are => 4 (i.e. current window )
            // so, is hashmap size < current Window => some element is repeating
            // if hashmap size == current window => no element in the substring is repeating
            if(hm.size() == curr_window){
                max = Math.max(max,curr_window);
                j++;
            } else if(hm.size() < curr_window){
                while (hm.size() < (j - i + 1)){
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);

                    if(hm.get(s.charAt(i)) == 0){
                        hm.remove(s.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s =  s = "abcabcbb";

        // brute force
        int brute = bruteForce(s);
        System.out.println(brute);


        // Optimised Solution
        // we will use variable size Sliding window Algo
        int result = slidingWindow(s);
        System.out.println(result);
    }
}
