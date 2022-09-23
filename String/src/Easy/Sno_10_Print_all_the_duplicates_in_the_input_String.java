package Easy;

import java.util.HashMap;
import java.util.Map;

public class Sno_10_Print_all_the_duplicates_in_the_input_String {
    public static void main(String[] args) {
        String str = "mynameiskunal";

        printDuplicates(str);
    }

    static void printDuplicates(String str) {
        HashMap<Character,Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            hm.put(ch, hm.getOrDefault(ch,0) + 1);
        }

        for (Map.Entry<Character,Integer> element : hm.entrySet()) {
            char key = (char) element.getKey();
            int value = (int) element.getValue();

            if(value > 1) {
                System.out.print(key + " ");
            }
        }
    }


}
