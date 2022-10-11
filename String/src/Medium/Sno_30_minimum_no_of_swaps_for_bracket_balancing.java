package Medium;

public class Sno_30_minimum_no_of_swaps_for_bracket_balancing {
    public static void main(String[] args) {
        String s = "]]][[[";
        // output = 2

        System.out.println(miniSwaps(s));
    }

    static int miniSwaps(String str) {
        int close = 0, maxClose = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '[') {
                close--;
            } else {
                close++;
            }
            maxClose = Math.max(close,maxClose);
        }

        return (maxClose + 1)/2;
    }
}
