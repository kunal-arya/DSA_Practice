package hard;

public class Sno_06_Find_in_Mountain_Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,2,1};
        int target = 3;

        // brute force
        // use linear Search
        int brute = linearSearch(arr,target);
        System.out.println(brute);

        // Optimised Solution => T.C. - O(logN)
        // use Binary Search
        int result = findIndex(arr,target);
        System.out.println(result);
    }

    // Finding the linear Index
    static int linearSearch(int[] arr, int target) {
        int ans = -1;
        for ( int i = 0; i < arr.length; i++ ) {
            if(arr[i] == target) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    static int findIndex(int[] arr, int target) {
        // first find peak index of the mountain array
        int peakIndex = peakMountain(arr);
        if(arr[peakIndex] == target) {
            return peakIndex;
        } else if(arr[peakIndex] < target) {
            return -1;
        } else {
            int asc = binarySearch(arr,target,0,peakIndex - 1);
            if(asc == -1) {
                return binarySearch(arr,target,peakIndex + 1, arr.length - 1);
            } else {
                return asc;
            }
        }
    }

    static int peakMountain(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start)/2;

            if( arr[mid] > arr[mid + 1] ) {
                // dec part, looks left
                end = mid;
            } else if(arr[mid] < arr[mid + 1]) {
                // asc part , looks right
                start = mid + 1;
            }
        }
        return start; // or end
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        boolean ascOrder = arr[start] < arr[end];
        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                return mid;
            }

            if(ascOrder) {
                if(arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(arr[mid] > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
