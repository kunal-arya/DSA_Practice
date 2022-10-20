package Easy;

public class Sno_06_Power_of_Two {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }

        return isPower(n);
    }

    private static boolean isPower(int n) {
        if(n % 2 != 0) {
            return n == 1;
        }

        return isPower(n/2);
    }


}
