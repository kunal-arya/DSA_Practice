package Medium;

import java.awt.geom.Point2D;

public class Sno_22_Find_the_index_of_the_first_Occurrence_in_a_String {
    public static void main(String[] args) {
        String a = "abcdabcabcdf";
        String b = "abcdf";
        // output - 7

        // Brute Force - O(n ^ m) => where n and m are length of a and b respectively
        System.out.println(bruteForce(a,b));

        // Rabin Karp Algorithm
        System.out.println(rabinKarpAlgo(a,b));
    }

    private static int rabinKarpAlgo(String a, String b) {
        int d = 256; // total characters
        int q = Integer.MAX_VALUE;
        int n = a.length();
        int m = b.length();
        int p = 0;
        int t = 0;
        int h = 1;
        int i,j;

        // updating h
        for (i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // getting first hashvalues of p and t
        for (i = 0; i < m ; i++) {
            p = (p * d + b.charAt(i)) % q;
            t = (t * d + a.charAt(i)) % q;
        }

        // matching the string
        for (i = 0; i <= n - m ; i++) {
            if(p == t) {
                for (j = 0; j < m ; j++) {
                    if (b.charAt(j) != a.charAt(i + j)) {
                        break;
                    }
                }

                if (j == m) {
                    return i;
                }
            }

            if (i < n - m) {
                t = ( (t - a.charAt(i) * h) * d  + a.charAt(i + m) ) % q;

                if(t < 0) {
                    t += q;
                }
            }
        }

        return -1;
    }

    static int bruteForce(String a, String b) {
        int n = a.length();
        int m = b.length();

        for (int i = 0; i < n ; i++) {
            int f = i;
            int j = 0;

            while(j < m) {
                if(a.charAt(f) == b.charAt(j)) {
                    f++;
                    j++;
                } else {
                    break;
                }
            }

            if(j == m) {
                return i;
            }
        }

        return -1;
    }
}
