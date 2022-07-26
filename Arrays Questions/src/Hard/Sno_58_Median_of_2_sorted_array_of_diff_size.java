package Hard;

public class Sno_58_Median_of_2_sorted_array_of_diff_size {
    public static void main(String[] args) {
        int[] arr1 = {1,3,4,7,10,12};
        int[] arr2 = {2,3,6,15};
        int n1 = arr1.length;
        int n2 = arr2.length;

        // Brute Force => T.C. - O(n1 + n2) and S.C. - O(n1 + n2)
        int brute = bruteForce(arr1,arr2,n1,n2);
        System.out.println(brute);

        //optimised Solution => T.C. - O(n1 + n2) and  S.C. - O(1)
        int result = opSol(arr1,arr2,n1,n2);
        System.out.println(result);

        // further optimised solution => T.C. - O( log( min(n1,n2) ) )
        double ans = binarySearch(arr1,arr2,n1,n2);
        System.out.println(ans);
    }

    private static int bruteForce(int[] arr1, int[] arr2, int n1, int n2) {
        int[] mergedArr = new int[n1 + n2];
        int k = 0;
        int i = 0;
        int j = 0;
        // use two pointer to put elements in the mergedArr
        // one pointer at the start of arr1[i]
        // one pointer at the end of arr2[j]
        // whichever is smaller store that value in Merged Array
        while (i < n1 && j < n2) {
            if(arr1[i] <= arr2[j]){
                mergedArr[k] = arr1[i];
                k++;
                i++;
            } else {
                mergedArr[k] = arr2[j];
                k++;
                j++;
            }
        }

        // if one array is exhausted, put all the values of the remaining array to the merged Array
        while (i < n1) {
            mergedArr[k] = arr1[i];
            i++;
            k++;
        }

        while(j < n2) {
            mergedArr[k] = arr2[j];
            j++;
            k++;
        }

        // return the median , if length of mergedArray is odd, return n3/2 value
        // if value is even , add two b/w values and divide it by two
        int n3 = mergedArr.length;
        int m = n3/2;
        if(n3 % 2 == 1) {
            return mergedArr[m];
        } else {
            return ( mergedArr[m] + mergedArr[m - 1] )/2;
        }
    }

    private static int opSol(int[] arr1, int[] arr2, int n1, int n2) {
        int n3 = n1 + n2;
        int m1 = n3/2;
        int m2 = m1 - 1;

        int i = 0;
        int j = 0;
        int count = 0;
        int firstN = 0, secondN = 0;
        // rather than storing all the values to a different array , we are going to get two values we need
        // first one is n/2
        // second one is n/2 - 1
        // b/c if n is even => (arr[n/2] + arr[n/2 - 1]) / 2
        // if n is odd => ( arr[n/2] )
        // to keep count at which point we have reached , do count++
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if(count == m1) firstN = arr1[i];
                if(count == m2) secondN = arr1[i];
                i++;
                count++;
            } else {
                if(count == m1) firstN = arr2[j];
                if(count == m2) secondN = arr2[j];
                j++;
                count++;
            }
        }

        // if one array is exhausted, check of these two values in remaining array

        while (i < n1) {
            if(count == m1) firstN = arr1[i];
            if(count == m2) secondN = arr1[i];
            i++;
            count++;
        }

        while(j < n2) {
            if(count == m1) firstN = arr2[j];
            if(count == m2) secondN = arr2[j];
            j++;
            count++;
        }

        // if odd => return firstN = arr[n/2]
        // if even => return ( firstN + secondN ) / 2 = ( arr[n/2] + arr[n/2 - 1] ) / 2
        if(n3 % 2 == 1){
            return firstN;
        } else {
            return ( firstN + secondN ) / 2 ;
        }
    }

    static double binarySearch(int[] arr1, int[] arr2, int n1, int n2) {
        // we are swapping the arrays in such a way that arr1 will always be the smaller one b.c we are going
        // to put binary search on arr1. It will also bring down our complexity to O(log(min(n1,n2)))
        if(n1 > n2) {
            return binarySearch(arr2,arr1,n2,n1);
        }

        int lo = 0;
        int hi = n1;

        while(lo <= hi) {
            int cut1 = lo + (hi - lo)/2;
            int cut2 = (n1 + n2)/2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int h1 = cut1 == n1 ? Integer.MIN_VALUE : arr1[cut1];
            int h2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];

            if(l1 > h2) {
                hi = cut1 - 1;
            } else if(l2 > h1) {
                lo = cut1 + 1;
            } else {
                double maxl = Math.max(l1,l2);
                double minh = Math.min(h1,h2);
                return (n1 + n2) % 2 == 0 ? (maxl + minh)/2 : Math.min(h1,h2);
            }
        }
        return 0.0;
    }
}
