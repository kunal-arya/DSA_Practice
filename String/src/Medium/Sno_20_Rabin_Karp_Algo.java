package Medium;

public class Sno_20_Rabin_Karp_Algo {
    public static void main(String[] args) {
        String txt = "for Geeks";
        String pattern = "Geek";
        int q = Integer.MAX_VALUE;
        rabinKarpAlgo(txt,pattern,q);
    }

    public static void rabinKarpAlgo(String txt, String pattern, int q) {
        int d = 256; // total characters
        int m = pattern.length();
        int n = txt.length();
        int p = 0; // Hash Value of pattern
        int t = 0; // Hash value of txt
        int h = 1; // biggest hash to multiply ( 256 ^ (m - 1) )

        // getting the h value i.e. 256^m - 1
        // we are doing % q to protect the overflow
        // you can take any prime Number as you wish, bigger the prime number, better it will be
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first
        // window of text
        for (int i = 0; i < m; i++) {
            p = (p * d + pattern.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m ; i++) {

            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (t == p) {
                /* Check for characters one by one */
                int j;
                for (j = 0; j < m ; j++) {
                    if(pattern.charAt(j) != txt.charAt(j + i)) {
                        break;
                    }
                }

                // if j reach the last, means we found our String
                if(j == m) {
                    System.out.println("found string at " + i);
                }
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit ( basically sliding the window)
            if (i < n - m) {
                t = ((t - txt.charAt(i) * h) * d + txt.charAt(i + m)) % q;

                // We might get negative value of t,
                // converting it to positive
                if (t < 0) {
                    t = t + q;
                }
            }
        }
    }
}
