package Easy;

public class Sno_39_best_time_to_buy_and_sell_stock {

    public static int bruteForce( int[] arr ) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            int max = -1;
            for (int j = i + 1; j < n ; j++) {
                 if(max < arr[j]) max = arr[j];
            }
            ans = Math.max(ans,max - min);
        }
        return ans;
    }

    private static int opSolution(int[] arr) {
        int lsf = Integer.MAX_VALUE; // least so for
        int maxProfit = 0; // maximum profit till now
        int pist = 0; // profit if I sold today

        for (int num: arr) {
            if(num < lsf) {
                lsf = num;
            }

            pist = num - lsf;

            if(maxProfit < pist) {
                maxProfit = pist;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        //output  5

        // brute force - T.C. - O(n^2)
        int brute = bruteForce(arr);
        System.out.println(brute);

        // optimised Solution - T.C. - O(n)
        int optimised = opSolution(arr);
        System.out.println(optimised);
    }
}
