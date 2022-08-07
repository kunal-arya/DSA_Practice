package Medium;

public class Sno_24_Jump_game {

    public static int bruteForce(int[] arr, int l, int r ){
        if(l == r){
            return 0;
        }

        if(arr[l] == 0){
            return Integer.MAX_VALUE;
        }

        int minJump = Integer.MAX_VALUE;
        int i = l + 1;
        while(i <= r && i <= l + arr[l]){
            int jumps = bruteForce(arr,i,r);

            if(jumps != Integer.MAX_VALUE && jumps + 1 < minJump){
                minJump = jumps + 1;
            }
            i++;
        }
        return minJump;
    }

    public static int optimisedSol(int[] arr, int n){
        if(n == 1){
            return 0;
        }

        if(arr[0] == 0){
            return -1;
        }

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1 ; i < n ; i++){
            if(i == n - 1){
                return jumps;
            }

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if(steps == 0){
                jumps++;
                if(i >= maxReach){
                    return -1;
                }

                steps = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        int n = arr.length;

        // brute force
        int brute = bruteForce(arr,0,n - 1);
        System.out.println(brute);

        // optimised solution
        int optimised = optimisedSol(arr,n);
        System.out.println(optimised);
    }
}
