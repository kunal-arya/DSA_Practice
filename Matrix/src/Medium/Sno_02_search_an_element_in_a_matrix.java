package Medium;

public class Sno_02_search_an_element_in_a_matrix {
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},
                   {10,11,16,20},
                   {23,30,34,60}};
        int target = 60;
        // solution
        boolean result = solution(arr, target);
        System.out.println(result);
    }

    private static boolean solution(int[][] arr, int target) {
        // first find the array row of target exist
        int r = arr.length;
        int c = arr[0].length;
        int row = 0;
        for (int i = 0; i < r ; i++) {
             if(target >= arr[i][0] && target <= arr[i][c - 1]) {
                row = i;
                break;
            }
        }


        // traverse that row you found
        for (int j = 0; j < c ; j++) {
            if(target == arr[row][j]) {
                return true;
            }
        }

        return false;
    }
}
