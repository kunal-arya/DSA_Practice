package Hard;

import java.util.HashMap;
import java.util.Map;

public class Sno_6_Minimum_Window_Substring {
    public static String bruteForce(String searchString, String t) {
        int n = searchString.length();

        // It contains the min length seen so far
        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;

        // It contains the minimum length substring
        String minWindow = "";

        // The nested for loop help us generate all the substrings
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {

                // Generate the substring - we are making a substring from left to right + 1 b/c end value is not included
                String windowSnippet = searchString.substring(left, right + 1);

                // Check if the generated char contains all the characters of target
                boolean windowContainsAllChars = stringContainsAllCharacters(windowSnippet, t);

                // If it is a valid substring
                // And the length is less than the minimum so far
                // Update the answer
                if (windowContainsAllChars && windowSnippet.length() < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSnippet.length();
                    minWindow = windowSnippet;
                }
            }
        }

        return minWindow;
    }

    // Helper function to check if all the char of string are
    // Present in the string searchString
    public static boolean stringContainsAllCharacters(String searchString, String t) {

        // Hash Map for storing the character frequency
        Map<Character, Integer> requiredCharacters = new HashMap<Character, Integer>();

        // Store the frequency of all the characters of string t
        for (int i = 0; i < t.length(); i++) {
            int occurrencesOfCharacter = requiredCharacters.getOrDefault(t.charAt(i), 0);


            requiredCharacters.put(t.charAt(i), occurrencesOfCharacter + 1);
        }

        // Traverse the searchString
        for (int i = 0; i < searchString.length(); i++) {
            char curChar = searchString.charAt(i);

            if (requiredCharacters.containsKey(curChar)) {
                // Calculate what the new occurrence count will be
                int newOccurrenceCount = requiredCharacters.get(curChar) - 1;

                /*
                 * If we have satisfied all of the characters for this character, remove the key
                 * from the hashtable.
                 *
                 * Otherwise, just update the mapping with 1 less occurrence to satisfy for
                 */
                if (newOccurrenceCount == 0) {
                    requiredCharacters.remove(curChar);
                } else {
                    requiredCharacters.put(curChar, newOccurrenceCount);
                }
            }
        }

        /*
         * If we satisfied all characters the the required characters hashtable will be
         * empty
         */
        return requiredCharacters.isEmpty();
    }

    public static String slidingWindow(String s , String t){

        // Initialization of all the variable we need
        int i = 0, j = 0, min = Integer.MAX_VALUE, n = s.length();
        String substring = "", minString = "";
        HashMap <Character,Integer> hm = new HashMap<>();

        // put all the values of t string into the Hashmap
        // reason: hashmap will give us total characters & their count in String t , which we will use to
        // compare with characters of a substring of String s.
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

            // reason : in this ques , we have to find min substring of s that contains all the characters from string t
            // so, if count == 0 ,
            // that means we have found a substring that contains all the char from string t
            // if count > 0
            // that means we not found a substring
            if(count > 0){
                j++;
            } else if(count == 0){
                int curr_window = j - i + 1;
                if(min > curr_window){
                    min = curr_window;
                    minString = substring;
                }

                // we will do while loop till count == 0
                // reason: let's explain through an example
                //   substring = "aabbc"
                //   String t = "abc"
                //  substring includes all the char from t String
                //  if we remove a from 0 index
                // substring becomes "abbc"
                // this also includes all the char from t string
                // and it will be a potentinal candidate for the answer.
                // that's why we are using a while loop till count == 0
                while (count == 0){
                    // reverse what we have done in a. but on s[i]
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

        // Brute Force
        String brute = bruteForce(s,t);
        System.out.println(brute);

        // optimised Approach
        String result = slidingWindow(s,t);
        System.out.println(result);
    }
}
