package easy;

public class Sno_02_Find_smallest_letter_greater_than_target {
    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        int n = arr.length;
        char target = 'g';

        // brute force => O(n)
        // linear Search
        char brute = bruteForce(arr,n,target);
        System.out.println(brute);

        // optimised Approach => O(logn)
        // use binary search
        char result = binarySearch(arr,n,target);
        System.out.println(result);
    }

    static char bruteForce(char[] arr, int n, char target) {
        int targetValue = target - 'a';
        char ans = arr[0];
        for (int i = 0; i < n; i++) {
            int curr_value = arr[i] - 'a';
            if(targetValue < curr_value) {
                ans = arr[i];
                break;
            }
        }

        return ans;
    }

    static char binarySearch(char[] arr, int n, char target) {
        int start = 0;
        int end = n - 1;

        int target_value = target - 'a';
        int greatest_el_value = arr[n - 1] - 'a';
        if(greatest_el_value < target_value) {
            return arr[0];
        }

        while (start <= end) {
            int mid = start + (end - start)/2;


            int curr_value = arr[mid] - 'a';
            if(target_value < curr_value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[start];
    }
 }
