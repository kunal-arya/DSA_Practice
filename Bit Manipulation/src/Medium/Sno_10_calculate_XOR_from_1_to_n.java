package Medium;

public class Sno_10_calculate_XOR_from_1_to_n {
    public static void main(String[] args) {
        int n = 8;
        // output - 8

        // Brute Force - Time Complexity - O(n) & Space Complexity - O(1)
        System.out.println(bruteForce(n));

        // Optimised Solution - Time Complexity - O(1) & Space Complexity - O(1)
        System.out.println(optimisedSol(n));
    }

    static int bruteForce(int n) {
        if(n == 0) return 0;
        int ans = 0;
        int i = 1;
        while(i <= n) {
            ans ^= i;
            i++;
        }

        return ans;
    }

    static int optimisedSol(int n) {

        if(n % 4 == 0) return n;

        if(n % 4 == 1) return 1;

        if(n % 4 == 2) return n + 1;

        // If n % 4 == 3
        return 0;
    }

}
