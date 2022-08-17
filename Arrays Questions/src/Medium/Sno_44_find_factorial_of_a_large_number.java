package Medium;

import java.util.ArrayList;

public class Sno_44_find_factorial_of_a_large_number {

    private static ArrayList<Integer> factorial(int n) {
        // declaring an ArrayList
        // reason: to store our result
        ArrayList<Integer> result = new ArrayList<>();

        // initialize size and carry
        // size -> size of arrayList
        int size = 0, carry = 0;

        // add 1 at index 0 , because as we know 0! is 1 and 1! is 1
        result.add(0,1);

        // size shows us the size of the array,
        size++;

        // initiate a val = 2 , and run a while loop if val <= N , means
        // it will enter the while loop only if N is larger than 1
        int val = 2;
        while (val <= n) {
            // run a reverse for loop
            // starting -> i = size - 1
            // ending -> i >= 0
            for (int i = size - 1; i >=0 ; i--) {
                int temp = result.get(i)*val + carry;
                result.set(i,temp%10);
                carry = temp / 10;
            }

            while (carry != 0){
                result.add(0,carry%10);
                size++;
                carry /= 10;
            }
            val++;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 897;
        //output - 120

        ArrayList<Integer> result = factorial(n);
        System.out.println(result);
    }
}
