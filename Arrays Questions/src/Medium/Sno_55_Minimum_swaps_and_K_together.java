package Medium;

public class Sno_55_Minimum_swaps_and_K_together {
    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 5, 8, 7, 4};
        int k = 6;
        //output - 2

        // Brute Force => T.C. - O(n^2)
        int brute = bruteForce(arr,k);
        System.out.println(brute);

        // optimised Solution => T.C. - O(n) S.C. - O(1)
        int result = opSolution(arr,k);
        System.out.println(result);
    }

    private static int bruteForce(int[] arr, int k) {
        int count = 0;
        int n = arr.length;
        for (int num: arr) {
            if(num <= k) count++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n - count ; i++) {
            int badNum = 0;
            for (int j = i ; j < count + i ; j++) {
                if(arr[j] > k) badNum++;
            }
            ans = Math.min(badNum,ans);
        }
        return ans;
    }

    private static int opSolution(int[] arr, int k){
        int n = arr.length;
        int count = 0;
        for (int num: arr) {
            if(num <= k) count++;
        }

        int i = 0;
        int j = 0;
        int bad = 0;
        int ans = Integer.MAX_VALUE;
        while (j < n) {
            if(arr[j] > k) bad++;

            if((j - i + 1) < count) {
                j++;
            } else if((j - i + 1) == count) {
                ans = Math.min(ans,bad);

                if(arr[i] > k) bad--;
                i++;
                j++;
            }
        }
        return ans;
    }
}
