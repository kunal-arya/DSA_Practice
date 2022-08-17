package Medium;

public class Sno_45_Maximum_product_subarray {

    private static long bruteForce(int[] arr) {
        long max = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            long sum = arr[i];

            max = Math.max(sum,max);

            for (int j = i + 1; j < n ; j++) {
                sum *= arr[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    private static long opSolution(int[] arr) {
        // trick to solve this question is to store currMax as well as currMin Values
        // as we traverse through the array
        // currMax -> maximum of ( arr[i] * currMax , arr[i] * currMin , arr[i] )
        // currMin -> minimum of ( arr[i] * currMin , arr[i] * currMax , arr[i] )
        // reason: because array can contain positive and negative values
        // currMin * negative number will give us currMax ( Dry run to get more clarity )

        // storing the maximum value to our max variable
        long max = 0;
        for (int j : arr) {
            max = Math.max(max, j);
        }
        // initialization of current Max and current min to 1
        long currMax = 1, currMin = 1;


        // traverse through the array and find currMax & currMin
        // and update max variable with maximum of max and curr_max
        for (int num: arr) {
            // edge case: if arr[i] == 0, we reinitialize currMax & currMin to 1
            if(num == 0){
                currMax = 1;
                currMin = 1;
                continue;
            }

            // save value of num * currMax , to be used to find currMin
            // reason: because we are going to update currMax before finding currMin
            long temp = num * currMax;

            // find currMax and currMin
            currMax = Math.max( Math.max(num * currMax, num * currMin),num);
            currMin = Math.min( Math.min(num * currMin, temp), num);

            // update max variable
            max = Math.max(max,currMax);
        }
        // return max variable
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {6,-3,-10,0,2};

        // brute force =>  T.C. - O(n^2)
        long brute = bruteForce(arr);
        System.out.println(brute);

        // optimised Solution => T.C. - O(n)
        long result = opSolution(arr);
        System.out.println(result);
    }
}
