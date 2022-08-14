package Hard;


import java.util.Arrays;

public class Sno_35_merge_without_extra_space {

    private static void bruteForce(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];

        // putting all the values of arr1 to mergedArr
        int k = 0;
        for (int x:arr1) {
            mergedArr[k] = x;
            k++;
        }

        // Putting all the values of arr2 to mergedArr
        for (int x: arr2) {
            mergedArr[k] = x;
            k++;
        }

        // nor sort the merged array
        Arrays.sort(mergedArr);
        k = 0; // Making the index of mergedArr again start from 0

        /* Putting all the values back in the array but in sorted order */
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = mergedArr[k];
            k++;
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = mergedArr[k];
            k++;
        }
    }

    private static void sortArr2(int[] arr, int m) {
        for (int i = 1; i < m ; i++) {
            if(arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
    }

    public static void outExtraSpace(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i = 0, j = 0;
        while(i < n) {
            // if arr1[i] is bigger than arr2[j], we are going to swap the numbers
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                // sort the second array is it becomes unsorted
                sortArr2(arr2,m);
            }
            // update the i pointer
            i++;
        }
    }

    private static int nextGap(int gap) {
        if(gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    private static void swap(long[] arr1,long[] arr2, int i , int j) {
        long temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }
    private static void optimisedApproach(long[] arr1, long[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int i,  j, gap = n + m;
        // getting our first value of gap
        gap = nextGap(gap);
        while(gap > 0) {

            // comparing first array
            for (i = 0 ; (i + gap ) < n ; i++) {
                if(arr1[i] > arr1[gap + i]) {
                    swap(arr1, arr1, i, gap + i);
                }
            }

            // comparing both array
            // if gap > n => j = ( gap - n ) or j = 0
            j = (gap > n) ? gap - n : 0;
            while (j < m && i < n) {
                if (arr1[i] > arr2[j]) {
                    swap(arr1,arr2,i,j);
                }
                i++;
                j++;
            }


            if(j < m ){
                // comparing second array

                for ( j = 0; j + gap < m; j++) {
                    if (arr2[j] > arr2[j + gap]){
                        swap(arr2,arr2,j,j + gap);
                    }
                }
            }
            // updating gap value
            gap = nextGap(gap);
        }
    }

    public static void furtherOptimised(long[] arr1, long[] arr2) {

        // first, find the maximum element from both the arrays and add 1 to it.
        // reason: we need a number bigger than both the arrays' number to implement the technique
        // adding one to the max element of both the arrays make sure that we got a number that is bigger than every element

        long max = 0L;
        for (long x:arr1) {
            max = Math.max(max,x);
        }

        for (long x:arr2) {
            max = Math.max(max,x);
        }
        max++;
        // take 3 pointers , i , j , k
        // use i for arr1
        // use j for arr2
        // use k to put the minimum element
        // and k runs from 1st element of arr1 to last element of arr2
        int i = 0, j = 0, n = arr1.length, m = arr2.length, k = 0;
        // start a while loop till i < n , j < m and k < n + m
        while (i < n && j < m && k < (n + m)) {
            // get the e1 and e2 element from both the arrays by taking modulus with max
            // e1 is from arr1
            // e2 is from arr2
            long e1 = arr1[i] % max;
            long e2 = arr2[j] % max;

            // if e1 <= e2 => update value at k
            // if k < n , that means its in the first array , update => arr1[k]
            // if k > n , that means its in the second array, update => arr2[k - n] ( think!! )
            // we will
            // add e1 * max and update i ( b/c we found minimum in arr1 ) & k { if e1 <= e2 } OR
            // add e2 * max and update j ( b/c we found minimum in arr2 ) & k { if e2 > e1 }
            if (e1 <= e2) {
                if(k < n) {
                    arr1[k] += (e1 * max);
                } else {
                    arr2[k - n] += (e1 * max);
                }
                i++;
                k++;
            } else {
                if(k < n) {
                    arr1[k] += (e2 * max);
                } else {
                    arr2[k - n] += (e2 * max);
                }
                j++;
                k++;
            }
        }

        // As arr1 and arr 2 both are sorted => if one array is exhausted, that means all the remaining element are
        // from the remaining array ( think!! - try dry run )
        while (i < n) {
            long eI = arr1[i] % max;
            if(k < n) {
                arr1[k] += (eI * max);
            } else {
                arr2[k - n] += eI * max;
            }
            i++;
            k++;
        }

        while (j < m) {
            long eJ = arr2[j] % max;
            if(k < n) {
                arr1[k] += (eJ * max);
            } else {
                arr2[k - n] += (eJ * max);
            }
            j++;
            k++;
        }

        // Finally update elements by dividing
        // with maximum element in both the arrays
        for (int in = 0; in < n ; in++) {
            arr1[in] /= max;
        }

        for (int in = 0; in < m ; in++) {
            arr2[in] /= max;
        }
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 3, 5, 7};
        long[] arr2 = {0, 2, 6, 8, 9};

//        // brute force T.C. - O(n*logn) S.C. - O(n)
//        bruteForce(arr1,arr2);
//
//        // without using extra Space T.C. - O(n * m) S.C. - O(1)
//        outExtraSpace(arr1,arr2);

        // optimised Approach
        // we will use GAP Method to optimised our code
//        optimisedApproach(arr1,arr2);

        // Further Optimisation
        // best technique - T.C. - O(n + m ) where n = arr1.length & m = arr2.length , S.C. - O(1)
        furtherOptimised(arr1,arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
