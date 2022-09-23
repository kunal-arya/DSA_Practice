package Easy;

public class Sno_09_Palindrome_String {
    public static void main(String[] args) {
        String str = "abbac";
        // output - true

        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
