package Medium;

import java.util.ArrayList;

public class Sno_31_restore_IP_Addresses {
    public static void main(String[] args) {
        String str = "25525511135";
        int n = str.length();

        // Brute force - Backtracking => T.C. - O(3 ^ 4 ) [Check video of the solution to understand this complexity]
        System.out.println(restoreIP(str,n));
    }

    static ArrayList<String> restoreIP(String str, int n) {
        ArrayList<String> result = new ArrayList<>();

        // if the length of the string is greater than 12
        if (n > 12) {
            return result;
        }

        // updating the result List using backtracking
        backtrack(0,0,"",result,str);

        return result;
    }

    static void backtrack(int i, int dots, String currIP, ArrayList<String> result,String str) {
        // If dots become 4, check for if we reach at the end of the string or not
        if (dots == 4 ) {
            // if we reach at the end , just remove the last dot and add the string to result
            if (i == str.length()) {
                StringBuilder sb = new StringBuilder(currIP);
                sb.deleteCharAt(sb.length() - 1);
                result.add(sb.toString());
                return;
                // if we didn't reach the end, just backtrack
            } else {
                return;
            }
        }

        for (int j = i; j < i + 3 && j < str.length(); j++) {
            // substring(i, j + 1) should be less than 256 as told in the question
            // first number can't be zero if length is more than 1
                // so if (i == j) => that means, there is only one number in the substring or
                // if str.charAt(i) != '0' means, that if length of the substring is more than 1 , first number of the
                // substring should not be ZERO
            if (Integer.parseInt(str.substring(i,j+ 1)) < 256 && (i == j || str.charAt(i) != '0')) {
                // calling a recursive call
                // i becomes j + 1
                // dots become dots + 1
                // currIP becomes => currIP + substring(i,j+1) + '.'
                // rest all the same
                backtrack(j + 1,dots + 1,currIP + str.substring(i,j + 1) + '.',result,str);
            }
        }
    }
}
