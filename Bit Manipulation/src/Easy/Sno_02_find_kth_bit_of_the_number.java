package Easy;

public class Sno_02_find_kth_bit_of_the_number {
    public static void main(String[] args) {
        int n1 = 13;
        int k1 = 2;
        // output = 0

        int n2 = 14;
        int k2 = 3;
        // output - 1

        int result1 = findBit(n1,k1);
        int result2 = findBit(n2,k2);
        System.out.println(result1);
        System.out.println(result2);
    }

    static int findBit(int n, int k) {
        // creating mask
        int mask = 1 << (k - 1);
        //masking all elements 0 except our ans
        int result = n & mask;
        // reversing the mask
        return result >> (k - 1);
    }
}
