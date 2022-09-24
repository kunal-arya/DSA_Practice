package Easy;

import java.util.Locale;

public class Sno_19_Convert_a_sentence_into_mobile_numeric_keypad {
    public static void main(String[] args) {
        String[] num
            = { "2",    "22",  "222", "3",   "33", "333",
                "4",    "44",  "444", "5",   "55", "555",
                "6",    "66",  "666", "7",   "77", "777",
                "7777", "8",   "88",  "888", "9",  "99",
                "999",  "9999" };
        String str= "HELLO WORLD";
        // expected output - 4433555555666096667775553

        System.out.println(convertNum(str,num));
    }

    static String convertNum(String str, String[] num) {

        str = str.toLowerCase();

        StringBuilder ans = new StringBuilder();

        for (int i = 0 ; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ' ') {
                ans.append('0');
            } else {
                ans.append(num[ch - 'a']);
            }

        }

        return ans.toString();
    }


 }
