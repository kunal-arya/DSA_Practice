package Medium;

import java.util.Arrays;

public class Sno_14_Longest_Palindrome_String {
    public static void main(String[] args) {
        String str = "aacabdkacaa";

        // Brute Force - O(n^3)
        System.out.println(bruteForce(str));

        // Optimised Approach - O(n^2)
        System.out.println(opSol(str));

        // Manacher's Algorithm => T.C. - O(n) and S.C. - O(n)

//        System.out.println(manachersAlgo(str));
    }


    // manacher's algo code here is incorrect-
    // articles to refer -
    // part1 - https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
    // part2 - https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-2/
    // part3 - https://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-3-2/
    private static String manachersAlgo(String str) {

        int strIdx = 0;

        // creating new String
        char[] newInput = new char[2*str.length() + 1];

        for (int i = 0; i < newInput.length; i++) {
            if(i % 2 == 0) {
                newInput[i] = '#';
            } else {
                newInput[i] = str.charAt(strIdx);
                strIdx++;
            }
        }

        // creating an array to store the size of palindrome
        int[] p = new int[newInput.length];

        // initializing center(c) and right(r) as both 0
        int c = 0, r = 0;
        for (int i = 1; i < newInput.length; i++) {
            int mirror = (2 * c) - i;

            if (i < r) {
                p[i] = Math.min(r - i,newInput[mirror]);
            }

            int c1 = i - (1 + p[i]);
            int c2 = i + (1 + p[i]);
            while (c2 < newInput.length && c1 >= 0
                    && newInput[c1] == newInput[c2]) {
                p[i]++;
                c1--;
                c2++;
            }

            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }

        int max = -1;
        int maxIdx = -1;

        for (int i = 0; i < p.length; i++) {
            int j = p[i];
            if(max < j) {
                max = j;
                maxIdx = i;
            }
        }

        int start = maxIdx - max;
        int end = maxIdx + max;
        char[] outputArray = new char[max];
        int k = 0;
        for (int i = start; i <= end; i++) {
            if(i % 2 != 0) {
                outputArray[k] = newInput[i];
                k++;
            }
        }

        return String.valueOf(outputArray);
    }


    static String opSol(String str) {
        int start = 0, end = 0;
        for (int i = 1; i < str.length(); i++) {

            // Even Substring
            int l = i - 1;
            int h = i;

            while(l >= 0 && h < str.length() && str.charAt(l) == str.charAt(h)) {

                if( (h - l + 1) > (end - start + 1) ) {
                    start = l;
                    end = h;
                }
                l--;
                h++;
            }

            // odd Substring
            l = i - 1;
            h = i + 1;

            while(l >= 0 && h < str.length() && str.charAt(l) == str.charAt(h)) {

                if( (h - l + 1) > (end - start + 1) ) {
                    start = l;
                    end = h;
                }
                l--;
                h++;
            }
        }


        return str.substring(start,end + 1);
    }

    static String bruteForce(String str) {

        int count = -1;

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            // creating a stringBuilder to add the strings
            StringBuilder ans = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                // adding the current char to ans
                ans.append(str.charAt(j));

                // checking if str is palindrome from i to j
                if (isPalindrome(str,i,j)) {
                    // if element in CurrentWindow greater than count,
                    // update count and store the ans to result
                    int curr_win = j - i + 1;
                    if (curr_win > count) {
                        count = curr_win;
                        result = ans.toString();
                    }
                }
            }
        }

        return result;
    }


    static boolean isPalindrome(String str,int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
