package Medium;

public class Sno_15_Print_all_Subsequences_of_a_string {
    public static void main(String[] args) {
        String str = "abc";

        printSubSeq(str,"");
    }

    static void printSubSeq(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        // to include first character of string
        printSubSeq(str.substring(1),ans + str.charAt(0));


        // to not include first character of String
        printSubSeq(str.substring(1),ans);
    }
}

