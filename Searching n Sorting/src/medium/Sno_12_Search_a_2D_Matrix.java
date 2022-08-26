package medium;

public class Sno_12_Search_a_2D_Matrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40},
                {50,60,70,80},
                {90,95,100,110},
                {112,120,130,140}
        };
        int n = arr.length;
        int m = arr[0].length;
        int target = 112;

        // For brute force and better than brute force approach look for solution of ques MATRIX => Sno-02
        // This is the solution of the problem using binary search
        boolean result = binarySearch(arr, n , m , target );
        System.out.println(result);
    }

    static boolean binarySearch(int[][] arr, int n , int m , int target ) {
//        Use binary search.
//        n * m matrix convert to an array => matrix[x][y] => a[x * m + y]
//        an array convert to n * m matrix => a[x] =>matrix[x / m][x % m];

        int start = 0;
        int end = n*m - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[ mid / m ][ mid % m ] == target) {
                return true;
            }

            if(arr[mid/m][mid % m] > target ) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
