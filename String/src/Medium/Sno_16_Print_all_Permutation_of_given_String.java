package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sno_16_Print_all_Permutation_of_given_String {
    public static void main(String[] args) {
        String str = "abb";

        List<String> result = retPerm(str,"");

        // remove duplicates and sort the List
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            if(!ans.contains(result.get(i))) {
                ans.add(result.get(i));
            }
        }
        Collections.sort(ans);
        System.out.println(ans);
    }

    static List<String> retPerm(String str, String s) {
        if (str.length() == 0) {
            List<String> a = new ArrayList<>();
            a.add(s);
            return a;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i <= s.length(); i++) {
            String first = s.substring(0,i);
            String last = s.substring(i,s.length());
            result.addAll(retPerm(str.substring(1),first + str.charAt(0) + last));
        }

        return result;
    }


}
