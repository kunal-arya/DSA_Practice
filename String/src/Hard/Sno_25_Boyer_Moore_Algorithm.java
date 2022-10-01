package Hard;

public class Sno_25_Boyer_Moore_Algorithm {
    public static void main(String[] args) {
        String a = "GCTTCTGCTACCTTTTGCGCGCGCGCGGAA";
        String b = "CCTTTTGC";

        search(a,b);
    }

    static int noOfChars = 256; // total number of characters

    //The preprocessing function for Boyer Moore's
    //bad character heuristic
    static void badCharHeuristic (String str , int size, int[] badChar) {



        // Initialize all Occurrence as -1
        for (int i = 0; i < noOfChars; i++) {
            badChar[i] = -1;
        }

        // Fill all the actual value of last occurrence
        // of a character ( indices of table are ascii and values are index of occurrence )
        // size -> size of the pattern ( String Str ) for which we are making bad Character Heuristic
        for (int i = 0; i < size; i++) {
            badChar[(int) str.charAt(i)] = i;
        }
    }

     /* A pattern searching function that uses Bad
     Character Heuristic of Boyer Moore Algorithm */
    static void search(String str,String pattern) {
        int n = str.length();
        int m = pattern.length();

        // created a badChar array of size -> total no of characters
        int[] badChar = new int[noOfChars];

          /* Fill the bad character array by calling
         the preprocessing function badCharHeuristic()
         for given pattern */
        badCharHeuristic(pattern,m,badChar);

        // s is shift of the pattern with
        // respect to text
        // there are n-m+1 potential alignments
        int s = 0;

        while ( s <= (n - m)) {
            int j = m - 1;

            /* Reducing j of Pattern until we get a
             mismatch character, at this shift s */
            while (j >= 0 && pattern.charAt(j) == str.charAt(s + j)) {
                j--;
            }

            /* In case if we get j=-1 which signify that
            P is present at current shift */
            if (j < 0) {
                System.out.println("Pattern occur at " + s);
             /* We will shift P such that the next
              character in T aligns with the last
              occurrence of it in P.
              To cover the case when P occur at end
              of T we need the condition idx+m < n */
                s += (s + m < n) ? m - badChar[str.charAt(m + s)] : 1;
            } else {

              /* In this case also, We will shift P such
                that the next character in T aligns
                with the last occurrence of it in P.
                To unsure that we get positive
                shift we are using max function.
                The negative shift may occur when the
                last occurrence of bad character in P
                is on the right side of the current
                character. */
                s += Math.max( 1 ,j -  badChar[ str.charAt(s + j) ] );
            }
        }
    }


}
