package Medium;

import java.util.Arrays;
import java.util.HashMap;

public class Sno_29_Count_pairs_with_sum {

    public static int bruteForce(int[] arr, int k, int n) {
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int sum = arr[j] + arr[i];
                if(sum == k){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int optimisedApproach (int[] arr, int k, int n) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        // Putting all the values in the HashMap. Storing no. of occurrence
        for (int i = 0 ; i < n ; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0) + 1);
        }

        // made a variable named twice_count to store the values of result.
        // reason: All the variables are going to be counted twice acc. to our approach.
        // we will iterate and store the values of the element in a variable twice count
        //  we will check if there is a number in hashmap that is (required_sum[k] - arr[i]). if yes
        // that means we got our result. as you can see that we will get twice as number as pair
        // for ex - arr -- [1,5,7,1] , k -- 6
        // pairs with sum 6 => (1,5) and (5,1)
        // but we will count this two pair twice , one when we are on one number and second when we are on second number.

        int twice_count = 0;

        for (int i = 0; i < n ; i++) {
            if( hm.get(k - arr[i]) != null ) {
                twice_count += hm.get(k - arr[i]);
            }


            // if there is a  pair with itself
            // (arr[i], arr[i]) = k , we have to reduce twice_count by 1
            if( (k - arr[i]) == arr[i] ) {
                twice_count--;
            }
        }

        // ans will be twice_count / 2 b/c we have counted ans twice , so it's time to reduce it by one.
        int ans = twice_count/2;

        return ans;
    }

    public static int furOptimised(int[] arr, int k, int n) {
        int ans = 0;
        int i = 0;
        int j = n - 1;

        Arrays.sort(arr);

        while(j > i) {
            // if arr[i] + arr[j] is < than k, that means you have to increase the sum.. we all know that array is sorted
            // so increase the i pointer towards right, means i++
            if(arr[i] + arr[j] < k){
                i++;
            }

            // if arr[i] + arr[j] is > than k, that means you have to decrease the sum. b/c array is sorted , left of j
            // will be smaller values than j , so shift j to left , means j--
            else if(arr[i] + arr[j] > k) {
                j++;
            }
            // if arr[i] + arr[j] == k , that means we got a pair we want
            else {
                // so we got a pair , we have to check if the pair numbers have more than one in count or not.
                // reason: let's look this through an example
                // arr = [1,2,2,2,4,4,6]
                // desired_sum or k = 6
                // so, if you start a pointer from left and pointer from right
                // we will reach where i = 1 & j = 5 and arr[i] + arr[j] == k ==> 1 + 5 = 6
                // now, forget about coding , lets do simple math
                // Total number 2 in arr are => 3
                // Total number 4 in arr are => 2
                // so , we need pairs of both
                // How many pairs will exist ???
                // it's simple => 3 x 2  = 6 pairs exists
                // b/c number 2 at index 1 have exactly two 6 at index-5 and index-4 respectively , where desired_sum
                // is reached , same for 2 at index-2 & index-3. so, 3 times 2 pair exists => 6 pairs
                //
                // Now our task after finding 2 at index-1 and 4 at index-6 ===>> find out how many 2's and 6's exists
                // in the array.
                // since, array is sorted , its easy
                // for finding out total number of 2 i.e. arr[i] in arr, store the current i position and run a while loop
                // till 2 == arr[i] and j < i , do i++ to move to next
                int first_i = i, i_value = arr[i];
                while ((i < j) && (i_value == arr[i])) {
                    i++;
                }

                // for finding the total number of arr[j] i.e. 4 in arr, store the current i position and run a while loop
                // till 4 == arr[j] and j >=i , do j-- to move to next
                int first_j = j, j_value = arr[j];
                while((j_value == arr[j]) && (j >= i)) {
                    j--;
                }



                // check if current value of i is equal to current value of j.
                if(i_value == j_value) {
                    // if value at i == value at j
                    // let's explain this situation using a example
                    // for ex -
                    // arr = [3,3,3];
                    // k = 6
                    // if you find out the pairs where sum is k
                    // these pairs are only 3 => [3(1),3(2)] , [3(1),3(3)] , [3(2),3(3)] where [value(index of value)]
                    // but if you use our old technique and count the total Occurrence of number 3 and multiply them both
                    // you will get => 3 x 3 = 9, here 3 is total number of Occurrence of number 3
                    // but this is wrong as you can see
                    //
                    // to solve this issue, do two things
                    // 1) subtract ( curr_i - first_i ) = tc => this will give you total number of Occurrence - 1 ( dry run this )
                    // 2) add = (result * (result + 1))/2
                    // reason: to find out the ans , result => (tc * (tc + 1)), here tc is total occurrence of number
                    // b/c we have to delete the pair where it is making the pair with itself and
                    // this will give us double pairs like [3(1),3(2)] and [3(2),3(1)]
                    // So, to remove this => just divide the result / 2 and add this to the final answer ans.
                    int temp = i - first_i;
                    ans += (temp*(temp + 1))/2;
                } else {
                    int total_i = i - first_i;
                    int total_j = first_j - j;
                    ans += total_i * total_j;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,3,3,3,3,3,4};
        int k = 6;
        int n = arr.length;

        // brute force - T.C. => O(n^2)
        int brute = bruteForce(arr,k,n);
        System.out.println(brute);

        // Optimised Approach - T.C. => O(n) and S.C. => O(n)
        // we will use hashmap in this
        int optimised = optimisedApproach(arr,k,n);
        System.out.println(optimised);

        // further optimised Approach - T.C. => O(n) and S.C. => O(1)
        // we will use two pointer approach
        // Disclaimer: This Method will only work on sorted Array. If array is unsorted use Hashmap only
        int furOpt = furOptimised(arr,k,n);
        System.out.println(furOpt);
    }
}
