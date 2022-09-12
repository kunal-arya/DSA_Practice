package Medium;

public class Sno_07_find_nth_Magic_number {
    public static void main(String[] args) {
        int n = 6;
        // output - 150

        long result = findNth(n);
        System.out.println(result);
    }

    static long findNth(int n) {
        long ans = 0L;
        long base = 5L;
        while (n > 0) {
            long last = (long) n & 1;
            ans += last * base;
            base = base * 5;
            n = n >> 1;
        }
        return ans;
    }
}
