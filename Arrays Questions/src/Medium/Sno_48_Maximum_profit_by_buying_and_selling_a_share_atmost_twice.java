package Medium;

public class Sno_48_Maximum_profit_by_buying_and_selling_a_share_atmost_twice {
    public static void main(String[] args) {
        int[] arr = {10, 22, 5, 75, 65, 80};
        int n = arr.length;
        //output - 87
        //Trader earns 87 as sum of 12, 75
        //Buy at 10, sell at 22,
        //Buy at 5 and sell at 80

        //Optimised Solution
        int result = opSolution(arr,n);
        System.out.println(result);

        // further optimised solution T.C- O(n) S.C. - O(1) { Try this solution after doing DP }
        int result1 = maxtwobuysell(arr,n);
        System.out.println(result1);
    }

    private static int opSolution(int[] arr, int n) {
        // calculate two for every price
        // max profit If I sold today or before today
        // max profit If I bought today or after today

        int lsf = arr[0]; // least so far
        int pist = 0; // profit if sold today
        int[] maxProfitLeft = new int[n]; // array of storing maxProfit from left

        for (int i = 1; i < n; i++) {
            lsf = Math.min(lsf,arr[i]);

            pist = arr[i] - lsf;

            maxProfitLeft[i] = Math.max(pist, maxProfitLeft[i - 1]);
        }

        int pibt = 0; // profit If bought today
        int maxAT = arr[n - 1]; // max after today ( max sales prices after today )
        int[] maxProfitRight = new int[n]; // Max Profit from right

        for (int i = n - 2; i >= 0 ; i--) {
            maxAT = Math.max(maxAT,arr[i]);

            pibt = maxAT - arr[i];

            maxProfitRight[i] = Math.max(pibt, maxProfitRight[i + 1]);
        }

        int op = 0; // overall Profit
        for (int i = 0; i < n ; i++) {
            int temp = maxProfitLeft[i] + maxProfitRight[i];
            op = Math.max(temp,op);
        }
        return op;
    }

    static int maxtwobuysell(int arr[],int size) {
        int first_buy = Integer.MIN_VALUE;
        int first_sell = 0;
        int second_buy = Integer.MIN_VALUE;
        int second_sell = 0;

        for(int i = 0; i < size; i++) {

            first_buy = Math.max(first_buy,-arr[i]);
            first_sell = Math.max(first_sell,first_buy+arr[i]);
            second_buy = Math.max(second_buy,first_sell-arr[i]);
            second_sell = Math.max(second_sell,second_buy+arr[i]);
        }
        return second_sell;
    }
}
