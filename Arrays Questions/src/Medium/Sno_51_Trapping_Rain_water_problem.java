package Medium;

public class Sno_51_Trapping_Rain_water_problem {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int n = arr.length;
        // output - 6

       // Brute force => T.C. - O(n^2) S.C. - O(1)
        int brute = bruteForce(arr,n);
        System.out.println(brute);

        // Optimised Approach => T.C. - O(n) S.C. - O(n)
        // using prefix and suffix arrays
        int result = opSolution(arr,n);
        System.out.println(result);

        // fur Optimised Approach => T.C. - O(n) S.C. - O(1)
        long opsol = furSolution(arr,n);
        System.out.println(opsol);
    }

    private static int bruteForce(int[] arr, int n ) {
        int totalWater = 0;
        for (int i = 0; i < n ; i++) {
            // max from left till current point
            int maxLeft = -1;
            for (int j = i ; j >= 0; j-- ){
                maxLeft = Math.max(maxLeft,arr[j]);
            }

            // max from right till current point
            int maxRight = -1;
            for (int k = i ; k < n ; k++) {
                maxRight = Math.max(maxRight,arr[k]);
            }

            // formula we derived
            totalWater += Math.min(maxLeft,maxRight) - arr[i];
        }
        return totalWater;
    }

    private static int opSolution(int[] arr, int n) {
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n ; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }

        int[] suffix = new int[n];
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i-- ) {
            suffix[i] = Math.max(suffix[i + 1] , arr[i]);
        }

        int totalWaterTrapped = 0;

        for (int i = 0; i < n ; i++) {
            totalWaterTrapped += Math.min(prefix[i],suffix[i]) - arr[i];
        }

        return totalWaterTrapped;
    }

    // using two pointer approach
    // first pointer => left = 0
    // second Pointer => right = n - 1
    // max_left_till_now => maxLeft = 0
    // max_right_till_now => max right = 0
    // start a while loop till left <= right
    // if(arr[left] <= arr[right]) =>
    // 1. if (arr[left] > maxLeft) - update maxLeft
    // 2. else - result += maxLeft - arr[left]
    // 3. left++

    // if(arr[left] > arr[right]) =>
    // 1. if (arr[right] > maxRight) - update maxLeft
    // 2. else - result += maxLeft - arr[left]
    // 3. right--

    // Intiution -
    // so , we are going to every height and finding the amount of water stored at the point is
    // maxLeft / maxRight - arr[left] / arr[right] =>
    // first by making sure there is a right (left) height that is bigger or equal
    // to maxLeft(maxRight) and arr[left](arr[right]) both. 
    private static long furSolution(int[] arr, int n ) {
        int left = 0;
        int right = n - 1;
        int maxLeft = 0;
        int maxRight = 0;
        long totalWaterTrapped = 0;
        while(left <= right) {
            if(arr[left] <= arr[right]) {
                if(arr[left] > maxLeft) {
                    maxLeft = arr[left];
                } else {
                    totalWaterTrapped += (long) maxLeft - arr[left];
                }

                left++;
            } else {
                if(arr[right] > maxRight) {
                    maxRight = arr[right];
                } else {
                    totalWaterTrapped += (long) maxRight - arr[right];
                }
                right--;
            }
        }
        return totalWaterTrapped;
    }
}
