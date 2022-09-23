package Easy;

import java.util.Arrays;
import java.util.HashMap;

public class Sno_13_Check_whether_a_string_is_a_valid_shuffle {
    public static void main(String[] args) {
        String a = "XYZY";
        String b = "121";
        String c = "X1Y12ZY";
        // Output - True


        System.out.println(validShuffle(a,b,c));

        // using hashmap
        System.out.println(validShuffle2(a,b,c));
    }


    // Sorting the String by making it a Character array and then sort
    static String sortString(String str) {
        char[] arr = str.toCharArray();

        Arrays.sort(arr);
        str = String.valueOf(arr);
        return str;
    }

    static boolean validShuffle(String a, String b, String c) {

        // if length of a + b != c , return false

        if( (a.length() + b.length()) != c.length() ) {
            return false;
        }


        // Sort the strings
        a = sortString(a);
        b = sortString(b);
        c = sortString(c);

        // initialising the pointers for 3 strings
        int i = 0, j = 0, k = 0;

        while (k < c.length()) {
            if(i < a.length() && a.charAt(i) == c.charAt(k)) {
                i++;
            } else if ( j < b.length() && b.charAt(j) == c.charAt(k)) {
                j++;
            } else {
                // that means this character is not in any of the strings , neither in A nor B
                return false;
            }

            // increasing the k
            k++;
        }

        // if they came out of the while loop, that means c contains every word either from a or b
        return true;
    }

    static boolean validShuffle2(String a, String b, String c) {
        HashMap<Character,Integer> a1 = new HashMap<>();
        HashMap<Character,Integer> b1 = new HashMap<>();

        int countChar = 0;
        // Adding the String to the HashMap
        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);
            a1.put(ch,a1.getOrDefault(ch,0) + 1);
            countChar++;
        }

        for (int i = 0; i < b.length(); i++) {
            char ch = b.charAt(i);
            b1.put(ch, b1.getOrDefault(ch,0) + 1);
            countChar++;
        }

        // checking if c Strings , in both a or b
        for (int i = 0; i < c.length(); i++) {
            char ch = c.charAt(i);
            if(a1.containsKey(ch)) {
                a1.put(ch, a1.get(ch) - 1);
                if(a1.get(ch) == 0) {
                    a1.remove(ch);
                }
                countChar--;
            } else if(b1.containsKey(ch)) {
                b1.put(ch, b1.get(ch) - 1);
                if (b1.get(ch) == 0) {
                    b1.remove(ch);
                }
                countChar--;
            } else {
                return false;
            }
        }

        // if countChar is zero, return true or if not, then false
        return countChar == 0;
    }
}
