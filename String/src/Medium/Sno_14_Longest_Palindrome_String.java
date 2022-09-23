package Medium;

public class Sno_14_Longest_Palindrome_String {
    public static void main(String[] args) {
        String str = "aaaabbaa";
        String str1 = "abc";

        System.out.println(bruteForce(str));
        System.out.println(bruteForce(str1));
    }

    static String bruteForce(String str) {

        int count = -1;

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            // creating a stringBuilder to add the strings
            StringBuilder ans = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                // adding the current char to ans
                ans.append(str.charAt(j));

                // checking if str is palindrome from i to j
                if (isPalindrome(str,i,j)) {
                    // if element in CurrentWindow greater than count,
                    // update count and store the ans to result
                    int curr_win = j - i + 1;
                    if (curr_win > count) {
                        count = curr_win;
                        result = ans.toString();
                    }
                }
            }
        }

        return result;
    }


    static boolean isPalindrome(String str,int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
