package Easy;

import java.util.HashSet;

public class Sno_12_check_whether_one_string_is_a_rotation_of_another {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDAB";
        // return true

        System.out.println(strRotation(s1,s2));
    }

    static boolean strRotation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int idx = -1;
        int firstChar = s1.charAt(0);
        for (int i = 0; i < s2.length(); i++) {
            if (firstChar == s2.charAt(i)) {
                idx = i;
            }
        }

        for (int i = 0; i < s1.length(); i++) {
            int s2Idx = (idx + i) % s2.length();
            if(s1.charAt(i) != s2.charAt(s2Idx)) {
                return false;
            }
        }

        return true;
    }


}
