package Medium;

import java.util.ArrayList;
import java.util.List;

public class Sno_01_Letter_combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        System.out.println(letterCombo(""));
    }

    static List<String> letterCombo(String str) {
        String[] arr = {"abc","def","ghi","jkl","mno","pqrs","tuv", "wxyz"};

        return getLetterCombo(str,"",arr);
    }

    static List<String> getLetterCombo(String str, String ans, String[] arr) {
        if(str.isEmpty()) {
            List<String> a = new ArrayList<>();
            a.add(ans);
            return a;
        }

        int digit = str.charAt(0) - '0';
        List<String> result = new ArrayList<>();
        String digitStr = arr[digit - 2];
        for (int i = 0; i < digitStr.length(); i++) {
            char ch = digitStr.charAt(i);
            result.addAll(getLetterCombo(str.substring(1),ans + ch,arr));
        }
        return result;
    }
}
