package medium;

public class Sno_8_Find_Largest_sum_contiguous_SubArray {
    public static int bruteForce(int[] arr, int n ){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            for(int j = i ; j < n ; j++ ){
                int sum = 0;
                for(int k = i ; k <= j ; k++){
                    sum += arr[k];
                    max = Math.max(max,sum);
                }
            }
        }
        return max;
    }

    public static int optimisedSolution(int[] arr, int n){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                sum += arr[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    public static int kadaneAlgo(int[] arr){
        int sum = 0;
        int max = arr[0];
        for(int x:arr){
            sum += x;
            if(sum < 0){
                sum = 0;
            } else if(sum > max){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        int n = arr.length;

        // Brute Force => Time Complexity - O(n^3)
        int brute = bruteForce(arr,n);
        System.out.println(brute);

        // optimised Solution => Time Complexity - O(n^2)
        int optimised = optimisedSolution(arr,n);
        System.out.println(optimised);

        // kadane's Algorithm => Time Complexity - O(n) and Space Complexity - O(1)
        // issue with this algo - There has to at least one Positive Number in the Array
        int kadane = kadaneAlgo(arr);
        System.out.println(kadane);
    }
}
