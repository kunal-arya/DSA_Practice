package medium;

public class Sno_10_Minimum_number_of_jumps {

    public static int bruteForce(int[] arr, int lo, int hi){
        // If there is only One Element in the Array
        if(lo == hi){
            return 0;
        }

        // If the first Element in the Array is the Zero
        if(arr[lo] == 0){
            return Integer.MAX_VALUE;
        }

        // Initialization minimum Jumps to MAX_VALUE
        int minJumps = Integer.MAX_VALUE;

        // loops from lo + 1 to either hi OR maximum reach i.e. lo + arr[lo]
        for(int i = lo + 1 ; i <= hi && i <= lo + arr[lo] ; i++){
            // recursive call to get minimum jumps and we just have to add +1 to these jumps
            int jumps = bruteForce(arr,i,hi);
            // if jumps are not equal to MAX_Value and minJumps are greater than Jumps + 1 , update minJumps
            if(jumps != Integer.MAX_VALUE && jumps + 1 < minJumps){
                minJumps = jumps + 1;
            }
        }
        return minJumps;
    }

    public static int optimisedSol(int[] arr,int n){
        // If there is only one element in the array
        if(n == 1){
            return 0;
        }

        // If first element is zero
        if(arr[0] == 0){
            return -1;
        }

        int maxReach = arr[0];
        int step = arr[0];
        int jumps = 1;

        for(int i = 1 ; i < n ; i++){
            // if we reach the end of the array
            if(i == n - 1){
                return jumps;
            }

            // update the maxReach , that will be maximum of current value or i + arr[i]
            maxReach = Math.max(maxReach, i + arr[i]);

            // we used a step , so decreased the step
            step--;

            // if steps become 0
            if(step == 0){
                // increase the jump b/c we have used our Jump
                jumps++;

                // to check if steps not become negative
                if(i >= maxReach){
                    return -1;
                }
                step = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = 11;
        // output => 3

        // Brute Force Approach -> recursive Approach => T.C. - O(n^n) and S.C. - O(1)
        int brute = bruteForce(arr,0,n - 1);
        System.out.println(brute);

        // Optimised Solution -> with T.C. - O(n) and S.C. - O(1)
        int optimised = optimisedSol(arr,n);
        System.out.println(optimised);
    }
}
