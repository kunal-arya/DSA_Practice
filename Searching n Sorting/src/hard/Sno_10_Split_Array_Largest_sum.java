package hard;

public class Sno_10_Split_Array_Largest_sum {
    public static void main(String[] args) {
        int[] arr = {7,2,5,10,8};
        int n = arr.length;
        int m = 2;
        // brute Force
        // use Backtracking

        // optimised Approach
        // use binary Search
        int result = binarySearch(arr,n,m);
        System.out.println(result);
    }

    static int binarySearch(int[] arr, int n, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < n ; i++) {
            start = Math.max(start,arr[i]);
            end += arr[i];
        }



        while (start < end) {
            int mid = start + (end - start)/2;

            int sum = 0;
            int pieces = 1;

            for (int num: arr) {
                if(sum + num > mid) {
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m){
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }
}
