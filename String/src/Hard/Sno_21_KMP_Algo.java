package Hard;

import java.util.ArrayList;

public class Sno_21_KMP_Algo {
    public static void main(String[] args) {
        String txt = "ababcabcabaababd";
        String pattern = "ab";


        System.out.println(kmpAlgo(txt,pattern));

        // return all the occurence
        System.out.println(kmpAlgoRet(txt,pattern));
    }

    static ArrayList<Integer> kmpAlgoRet(String txt, String pattern) {
        int n = txt.length();
        int m = pattern.length();
        ArrayList<Integer> ans = new ArrayList<>();
        if(n < m) {
            ans.add(-1);
            return ans;
        }

        int i = 1;
        int j = 0;
        int[] lps = new int[m];

        while ( i < m) {
            if(pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else if(j == 0) {
                lps[i] = 0;
                i++;
            } else {
                j = lps[j - 1];
            }
        }

        i = 0; // for txt
        j = 0; // for pattern

        while(i < n) {
            if(txt.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if(j == m) {
                ans.add(i - m );
                j = lps[j - 1];
            }
        }
        return ans;
    }

    static int kmpAlgo(String txt, String pattern) {
        int n = txt.length();
        int m = pattern.length();

        if (pattern.equals("")) {
            return 0;
        }

        // lps shows us that if the beginning part of the pattern is appearing
        // again anywhere else in the pattern or not
        int[] lps = new int[m];

        // starting with two pointers j and i
        // Initial values of j is 0th index and i is 1st index
        int j = 0;
        int i = 1;

        // start a while loop till i < m

        // if pattern[i] == pattern[j]
        // that means we have found a character
        // we store lps[i] = j + 1
        // and increase j++, i++

        // else if j == 0
        // that means pattern[i] != pattern[j] and we are at the beginning index
        // so just -> lps[i] = 0 and do i++ b/c this shows us that pattern at the beginning
        // is not


        // else
        // that means pattern[i] != pattern[j] and j != 0
        // at this point , we have to update j
        // j = lps[j - 1]
        // what we are doing is we are putting j to
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                j++;
                i++;
            } else if(j == 0) {
                lps[i] = 0;
                i++;
            } else {
                j = lps[j - 1];
            }
        }

        i = 0; // pointer for txt
        j = 0; // pointer for pattern

        while (i < n) {
            if (txt.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lps[j - 1];
                }
            }

            if (j == m) {
                int idx = i - m;
                System.out.println("pattern match at " + idx);
                return idx;
            }
        }

        return -1;
    }
}
