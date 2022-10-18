package Easy;

public class Sno_05_First_uppercase_letter_in_a_string {
    public static void main(String[] args) {
        String str = "mynameisKunal";
        // output - K

        // iterative
        firstUppercaseI(str);

        // recursive
        firstUppercaseR(str);
    }

    private static void firstUppercaseI(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                System.out.println(str.charAt(i));
            }
        }
    }

    private static void firstUppercaseR(String str) {
        if (str.length() < 1) {
            return;
        }

        if (Character.isUpperCase(str.charAt(str.length() - 1))) {
            System.out.println(str.charAt(str.length() - 1));
            return;
        }

        firstUppercaseR(str.substring(0,str.length() - 1));
    }


}
