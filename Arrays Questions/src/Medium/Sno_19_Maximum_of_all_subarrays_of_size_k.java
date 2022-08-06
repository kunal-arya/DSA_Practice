package Medium;
import java.util.ArrayList;
import java.util.Arrays;

public class Sno_19_Maximum_of_all_subarrays_of_size_k {
    public static int[] bruteForce(int[] arr, int n , int k){
        int[] result = new int[n - k + 1];

        for (int i = 0 ; i <= n-k ; i++){
            int max = arr[i];
            for (int j = i ; j < i + k ; j++) {
                if(arr[j] > max){
                    max = arr[j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public static int[] slidingWindow(int[] arr, int n , int k){
        ArrayList<Integer> maxList = new ArrayList<>();
        int[] result = new int[n - k + 1];

        int i = 0, j = 0;

        while (j < n){
            // 1) if maxList size is Zero, just add the arr[j] and
            // 2) if maxList size is not Zero ,
                // ( 2.1 ) start a While Loop
                // till maxList size > 0 and maxList last element < arr[j] b/c
                // we are using maxList to store the maximum , so before adding arr[j]
                // we are just checking if the numbers that are in maxList are > or < than arr[j] and
                // if they are < than arr[j] we are just removing them from the list.
                //  We are making sure that
                // numbers of the left of arr[j] are bigger than the arr[j] , so that First Number in the list is always
                // maximum and if we remove the first element in future next Number is the maximum among all the remaining
                // number in the maxList
                // ( 2.2 ) and after that just add arr[j]
            if(maxList.size() != 0){
                while(maxList.size() > 0 && maxList.get(maxList.size() - 1) < arr[j]){
                    maxList.remove(maxList.size() - 1);
                }
            }
            maxList.add(arr[j]);

            int curr_window = j - i + 1;
            if(curr_window < k){
                j++;
            } else if(curr_window == k){
                // include the max element to the result array and first Element of maxlist is maximum
                result[i] = maxList.get(0);

                // reverse the calculation to slide the window by increasing i and j
                // if arr[i] ( element we are about to remove from the current window ) is the maximum number , i.e. first
                // element of the maxList, in that case , remove the first element and as we have made the list in such a
                // way that next element after removing first will be the max among the maxList
                if(arr[i] == maxList.get(0)){
                    maxList.remove(0);
                }
                // increase i and j
                i++;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1 ,2 ,3 ,1 ,4 ,5 ,2 ,3 ,6};
        int n = arr.length;
        int k = 3;
        // Expected Output => 3 3 4 5 5 5 6

        // Brute force => Time Complexity - O(n^2)
        int[] brute = bruteForce(arr,n,k);
        System.out.println(Arrays.toString(brute));

        // Optimised Solution => Sliding Window Technique - O(n)
        int[] result = slidingWindow(arr,n,k);
        System.out.println(Arrays.toString(result));
    }
}
