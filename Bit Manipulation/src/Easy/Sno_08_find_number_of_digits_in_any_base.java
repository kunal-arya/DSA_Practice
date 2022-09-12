package Easy;

public class Sno_08_find_number_of_digits_in_any_base {
    public static void main(String[] args) {
        int n = 6;
        int b = 2;

        int result = findDigits(n,b);
        System.out.println(result);
    }

    static int findDigits(int n, int b) {
        return (int) (Math.log(n)/Math.log(b)) + 1;
    }
}
