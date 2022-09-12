package Medium;

public class Sno_09_number_of_1_Bits {
    public static void main(String[] args) {
        int n = -55;

        System.out.println(Integer.toBinaryString(n));

        // Solution - 1 ( doesn't work with negative numbers )
        System.out.println(totalSetBits1(55));

        // Solution - 2
        System.out.println(totalSetBits2(n));
    }

    static int totalSetBits1(int n) {
        int count = 0;
        while(n != 0) {
            // checking LSB is 0 or one
            int last = n & 1;

            // if LSB is one , add it to the count
            if(last == 1){
                count++;
            }

            // >> n by 1
            n >>= 1;
        }

        // count
        return count;
    }

    static int totalSetBits2(int n) {
        int count = 0;

        while(n != 0) {
            // finding the rightmost set bit
            int rightmost = n & -n;

            // deleting the rightmost set bit
            n = n - rightmost;

            // counting the number of times loop is running
            count++;
        }

        return count;
    }
}
