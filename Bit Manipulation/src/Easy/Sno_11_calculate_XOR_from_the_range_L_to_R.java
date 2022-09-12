package Easy;

public class Sno_11_calculate_XOR_from_the_range_L_to_R {
    public static void main(String[] args) {
        int l = 4;
        int r = 8;
        // output - 4

        // Brute Force => T.C. - O(n) and S.C. - O(1)
        System.out.println(bruteForce(l,r));

        // Optimised Solution => T.C. - O(1) and S.C. - O(1)
        System.out.println(optimisedSol(l,r));
    }

    static int bruteForce(int l, int r) {
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans ^= i;
        }
        return ans;
    }

    static int Xor1toN(int n) {
        if(n % 4 == 0) return n;

        if(n % 4 == 1) return 1;

        if(n % 4 == 2) return n+1;

        return 0;
    }
    static int optimisedSol(int l, int r) {
        // get XOR from 1 to ( l - 1 )
        int XorL = Xor1toN(l - 1);

        // get XOR from 1 to R
        int XorR = Xor1toN(r);

        return XorR - XorL;
    }
}
