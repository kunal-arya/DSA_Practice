package Easy;

public class Sno_03_Set_the_Kth_bit_of_a_given_no {
    public static void main(String[] args) {
        int n1 = 10;
        int k1 = 2;
        // output - 14

        int n2 = 15;
        int k2 = 3;
        // output - 15

        int result1 = kthBit(n1,k1);
        int result2 = kthBit(n2,k2);
        System.out.println(result1);
        System.out.println(result2);
    }

    static int kthBit(int n,int k) {
        // k is k not k -1 b/c LSB(or last bit) is 0th index value
        int mask = 1 << (k);
        return mask | n;
    }
}
