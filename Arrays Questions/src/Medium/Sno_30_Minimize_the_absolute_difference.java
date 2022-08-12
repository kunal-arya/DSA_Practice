package Medium;

import java.lang.management.MemoryType;

public class Sno_30_Minimize_the_absolute_difference {

    public static int bruteForce(int[] a, int[] b, int[] c) {
        int min = Integer.MAX_VALUE;
        int x = a.length;
        int y = b.length;
        int z = c.length;
        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < y ; j++) {
                for (int k = 0; k < z ; k++) {
                    int a1 = a[i];
                    int b1 = b[j];
                    int c1 = c[k];
                    int curr_min = Math.abs(Math.max(Math.max(a1,b1),c1)) - Math.abs(Math.min(Math.min(a1,b1),c1));
                    if(curr_min < min) min = curr_min;
                }
            }
        }
        return min;
    }

    public static int twoPointer(int[] a, int[] b, int[] c) {
        // use three pointer on a, b and c array as i , j & k.
        // find this equation => | maximum(a[i],b[j],c[k]) - minimum(a[i],b[j],c[k]) | = curr_ans.
        // compare it with the ans , if curr_ans < ans , update ans.
        // Trick of the question is - whatever the minimum one between a[i],b[j] & c[k] and increase its pointer
        // ( that's it , that is trick).
        // reason: if you look at the ques - we have to MINIMIZE this EQUATION => | maximum(a,b,c) - minimum(a,b,c) |
        // So, in order to do that we can do two things
        // 1) decrease the value of maximum(a,b,c) [NOT POSSIBLE, b/c as array is sorted ,
        //                                          we are sitting on the minimum MAX value of these 3 Arrays]
        //
        // 2) Increase the value of minimum(a,b,c) [that we can do and this is what we did]

        int al = a.length;
        int bl = b.length;
        int cl = c.length;
        int i = 0, j = 0, k = 0;
        int ans = Integer.MAX_VALUE;
        while (i < al && j < bl && k < cl) {
            int max = Math.max(Math.max(a[i],b[j]),c[k]);
            int min = Math.min(Math.min(a[i],b[j]),c[k]);
            int curr_min = Math.abs(max - min);

            if(curr_min < ans) {
                ans = curr_min;
            }

            if(min == a[i]) {
                i++;
            } else if(min == b[j]) {
                j++;
            } else if(min == c[k]) {
                k++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 5, 8, 10 };
        int[] B = { 6, 9, 15 };
        int[] C = { 2, 3, 6, 6 };
        // Output - 1

        // brute force Approach - T.C. - O(n^3)
        int brute = bruteForce(A,B,C);
        System.out.println(brute);

        // Optimised Approach - T.C. - O(n)
        // we will use two Pointer Approach
        int result = twoPointer(A,B,C);
        System.out.println(result);
    }
}
