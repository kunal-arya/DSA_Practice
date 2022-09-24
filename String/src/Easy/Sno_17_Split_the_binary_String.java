package Easy;

public class Sno_17_Split_the_binary_String {
    public static void main(String[] args) {
        String str = "0100110101";
        int result = splitString(str);
    }

    static int splitString(String str) {

        int count0 = 0;
        int count1 = 0;
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {

            // if char is '0' - increase count0 and if char is '1' , increase count1
            if(str.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }

            // if count0 == count1 , we found a string , increase ans
            if(count0 == count1) {
                ans++;
            }
        }

        // if number of 0's and 1's in a string are not same, we cannot split the string into a equal number of 0's
        // and 1's , so return -1
        if (count0 != count1) {
            return -1;
        }

        return ans;
    }
}
