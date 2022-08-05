package Medium;

public class Sno_16_Jump_game {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return true;
        }

        if(nums[0] == 0){
            return false;
        }

        int steps = nums[0];
        int maxReach = nums[0];

        for(int i = 0 ; i < n ; i++){
            if(i == n - 1){
                return true;
            }

            steps--;
            maxReach = Math.max(maxReach,i + nums[i]);

            if(steps == 0){
                if(i >= maxReach){
                    return false;
                }
                steps = maxReach - i;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        //=========================================================
        // first do Sno_10 ( Arrays ) and then solve this question
        //=========================================================
        int[] nums = {2,3,1,1,4};

        // // // brute force - Check Sno_10 solution
        // optimised solution - O(n^2)
        boolean solution = canJump(nums);
        System.out.println(solution);
    }
}
