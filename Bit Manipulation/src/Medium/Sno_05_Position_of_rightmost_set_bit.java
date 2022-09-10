package Medium;

public class Sno_05_Position_of_rightmost_set_bit {
    public static void main(String[] args) {
        int n1 = 18;
        // output - 2
        int n2 = 19;
        // output - 1

        System.out.println(Integer.toBinaryString(n1));

        int result1 = rightSetBit(n1);
        int result2 = rightSetBit(n2);
        System.out.println(result1);
        System.out.println(result2);
    }

    static int rightSetBit(int n) {
        // To know how it works, understand how the negative number stores in binary
        // look into the notes
        return n & -n;
    }
}
