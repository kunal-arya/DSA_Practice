package Medium;

public class Sno_04_Program_to_clear_K_th_bit_of_a_number_N {
    public static void main(String[] args) {
        int n1 = 5;
        int k1 = 1;
        // output - 4

        int n2 = 5;
        int k2 = 2;
        // output - 5

        int result1 = clearKthBit(n1,k1);
        int result2 = clearKthBit(n2,k2);
        System.out.println(result1);
        System.out.println(result2);
    }

    static int clearKthBit(int n, int k) {
        int mask = 1 << ( k - 1 );
        // ~mask means opposite of mask - it means complement
        return n & (~mask);
    }
}
