package Easy;

public class Sno_26_Roman_to_Decimals {
    public static void main(String[] args) {

    }

    static int getRomanValue(char ch) {
        switch(ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }

        return 0;
    }

    public int romanToInt(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            int intValue = getRomanValue(s.charAt(i));
            if(i > 0) {
                if(s.charAt(i - 1) == 'I' && ( s.charAt(i) == 'V' || s.charAt(i) == 'X' )) {
                    intValue -= 2;
                } else if(s.charAt(i - 1) == 'X' && ( s.charAt(i) == 'L' || s.charAt(i) == 'C' )) {
                    intValue -= 20;
                } else if(s.charAt(i - 1) == 'C' && ( s.charAt(i) == 'D' || s.charAt(i) == 'M' )) {
                    intValue -= 200;
                }
            }
            ans += intValue;
        }

        return ans;
    }
}
