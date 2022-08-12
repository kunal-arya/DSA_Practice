package Medium;

public class Sno_31_Container_with_most_water {

    public static int bruteForce(int[] arr) {
        int max_vol = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int curr_vol = (j - i) * Math.min(arr[j],arr[i]);
                if(max_vol < curr_vol) {
                    max_vol = curr_vol;
                }
            }
        }
        return max_vol;
    }

    public static int twoPointer(int[] arr) {
        // create two pointers , one starts at the start and other one at the end of array

        // start a while loop till i < j
        // find the curr_vol = (j - i) * minimum(arr[i],arr[j])
        // if curr_vol > max_vol , update max_vol

        // trick to crack this question is to find how to update the pointers
        // According to ques, we have to maximize the area;
        // area = (j - i) * minimum(arr[i],arr[j])
        // so, in order to maximize this equation focus on two things
        // 1) j and i has to far away from each other as possible [we solved this problem by putting
        //                                                         two pointers far away as possible
        //                                                         by putting one at start and other one at the end]
        // 2) next to understand this, when are using min of arr[i] and arr[j]
        // larger number => no use in current area
        // smaller number => used in current area
        // so, as we have found the area with the smaller number and as it is used,
        // shift the counter of the smaller one to find more answers
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        int max_vol = Integer.MIN_VALUE;
        while(i < j) {
            int curr_vol = (j - i ) * Math.min(arr[i],arr[j]);
            if(curr_vol > max_vol ) {
                max_vol = curr_vol;
            }
            if(arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max_vol;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,2,4,5,1};
        // output => 12

        // Brute Force - T.C. - O(n^2)
        int brute = bruteForce(arr);
        System.out.println(brute);

        // Optimised Approach - T.C. - O(n)
        // In this Approach, we will use Two Pointers
        int result = twoPointer(arr);
        System.out.println(result);
    }
}
