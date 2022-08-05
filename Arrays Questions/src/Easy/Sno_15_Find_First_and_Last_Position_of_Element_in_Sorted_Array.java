package Easy;

import java.util.Arrays;

public class Sno_15_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static int[] searchRange(int[] nums, int target) {
        int first = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(target == nums[i]){
                first = i;
                break;
            }
        }

        int last = -1;
        for(int i = nums.length - 1; i >= 0 ; i--){
            if(target == nums[i]){
                last = i;
                break;
            }
        }

        int[] result = {first,last};

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        // solution - T.C. => O(n)
        int[] sol = searchRange(nums,target);
        System.out.println(Arrays.toString(sol));
    }
}
