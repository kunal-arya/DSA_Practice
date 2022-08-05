package Easy;

// question URL : https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

public class Sno_13_Minimum_Cost_to_Move_Chips_to_The_Same_Position {

    public static int minCostToMoveChips(int[] position) {
        int evenPlace = 0;
        int oddPlace = 0;

        for(int i = 0 ; i < position.length ; i++){
            if(position[i] % 2 == 0){
                evenPlace++;
            } else {
                oddPlace++;
            }
        }

        return Math.min(evenPlace, oddPlace);
    }

    public static void main(String[] args) {
        int[] position = {2,2,2,3,3};
        int result = minCostToMoveChips(position);
        System.out.println("result: " + result);
    }
}
