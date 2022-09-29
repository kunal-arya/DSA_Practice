package Medium;

public class Sno_23_repeated_String_match {
    public static void main(String[] args) {
        String a = "aaab";
        String b = "ab";

        float min = 8f/3f;
        System.out.println(Math.ceil(min));

        System.out.println(anotherSol(a,b));
        System.out.println(kmpAlgo(a,b));
    }

    static int kmpAlgo(String a, String b) {
        int m = b.length();
        int n = a.length();

        int[] lps = new int[m];

        int i = 1;
        int j = 0;

        while(i < m) {
            if (b.charAt(i) == b.charAt(j)) {
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

        i = 0; // a's pointer
        j = 0; // b's pointer

        int min = (n + m - 1) / n;
        int a_max = (min + 1) * n;

        while (i < a_max) {
            int indexA = i % n;
            if (a.charAt(indexA) == b.charAt(j)) {
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
                return (i + n - 1)/n;
            }
        }

        return -1;
    }

    static int anotherSol(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // adding string a in sb till it becomes greater than b
        // output - this will give us the minimum length of the String a to contain b as it's
        // subString
        // example =>
        // a - 'abcd'
        // b - 'abcdabcd'
        // minimum times to repeat is 2  (think ?? )
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // If String b is in sb , return count
        if (sb.toString().contains(b)) {
            return count;
        }

        // if String b is not in sb, try to add one more iteration and check again
        // example =>
        // a - 'abcd'
        // b - 'cdabcdab'
        // maximum times to repeat is 3 ( think ?? )
        if (sb.append(a).toString().contains(b)) {
            return count + 1;
        }

        // even after adding String a in sb, we couldn't find string b in it
        // that means, its not exist in it. return -1
        return -1;
    }
}
