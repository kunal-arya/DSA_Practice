package Hard;

import java.util.HashMap;

public class Sno_6_Minimum_Window_Substring {

    public static String slidingWindow(String s , String t){

        // Initialization of all the variable we need
        int i = 0, j = 0, min = Integer.MAX_VALUE, n = s.length();
        String substring = "", minString = "";
        HashMap <Character,Integer> hm = new HashMap<>();

        // put all the values of t string into the Hashmap
        for (int k = 0; k < t.length() ; k++){
            hm.put(t.charAt(k), hm.getOrDefault(t.charAt(k),0) + 1);
        }

        // variable to count no. of characters in
        int count = hm.size();

        while (j < n){
            // subtract the value by 1 if s[j] is in hashmap
            if(hm.containsKey(s.charAt(j))){
                hm.put(s.charAt(j), hm.get(s.charAt(j)) - 1);
                // if the value become Zero , decrease count
                if(hm.get(s.charAt(j)) == 0){
                    count--;
                }
            }
            // add the current character to substring
            substring += s.charAt(j);

            if(count > 0){
                j++;
            } else if(count == 0){
                int curr_window = j - i + 1;
                if(min > curr_window){
                    min = curr_window;
                    minString = substring;
                }

                while (count == 0){
                    if(hm.containsKey(s.charAt(i))){
                        hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
                        // Agar character value one ho jaati hai iska matlab hai abhi add hua hai character
                        if(hm.get(s.charAt(i)) == 1){
                            count++;
                        }
                    }

                    // decrease the string from left side
                    StringBuilder sb = new StringBuilder(substring);
                    sb.deleteCharAt(0);
                    substring = sb.toString();

                    // increase i
                    i++;

                    // check if count is zero or not, if yes , update min and minstring
                    if(count == 0){
                        int curr_win = j - i + 1;
                        if(min > curr_win){
                            min = curr_win;
                            minString = substring;
                        }
                    }
                }
                // increase j
                j++;
            }
        }
        return minString;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        // output = "BANC"

        // optimised Approach
        String result = slidingWindow(s,t);
        System.out.println(result);
    }
}
