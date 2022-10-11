package Medium;

public class Sno_27_Longest_Common_prefix {
    public static void main(String[] args) {
        String[] str = {"ab", "a"};

        System.out.println(longestPrefix(str));
    }
    
    static String longestPrefix(String[] str) {
        String ans = "";
        StringBuilder sb = new StringBuilder();
        int i = 0,j;
        while(i < str[0].length()) {
            char ch = str[0].charAt(i);
            boolean isChar = true;
            for (j = 1; j < str.length; j++) {
                if (i >= str[j].length()) {
                    isChar = false;
                    break;
                }

                if (ch != str[j].charAt(i)) {
                    isChar = false;
                    break;
                }
            }
            if (isChar) {
                sb.append(ch);
            } else {
                break;
            }

            i++;
        }
        ans = sb.toString();
        return ans;
    }
}
