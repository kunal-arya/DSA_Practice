package Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sno_6_Find_Union_And_Intersection {

    public static int pointersUnion(int [] a, int n , int[] b, int m){
        int i = 0 , j = 0;

        List<Integer> result = new ArrayList<>();

        while(i < n || j < m){

            // skipping duplicates
            if(i > 0 && i < n && a[i] == a[i - 1]){
                i++;
            }

            if(j > 0 && j < m && b[j] == b[j - 1]){
                j++;
            }

            // if one array is exhausted
            if(i >= n){
                result.add(b[j]);
                j++;
                continue;
            }

            if(j >= m){
                result.add(a[i]);
                i++;
                continue;
            }

            // comparison logic
            if(a[i] < b[j]){
                result.add(a[i]);
                i++;
            } else if(a[i] > b[j]){
                result.add(b[j]);
                j++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        System.out.println(result);
        return result.size();
    }
    public static int doUnion(int[] a, int n, int[] b, int m){
        Set<Integer> result = new HashSet<Integer>();

        for(int i = 0 ; i < n ; i++){
            result.add(a[i]);
        }

        for(int i = 0 ; i < m ; i++){
            result.add(b[i]);
        }

        return result.size();
    }

    public static int pointersIntersection(int[] a, int n , int[] b, int m){
        int i = 0 , j = 0;
        // just to print the intersected Array
        List<Integer> result = new ArrayList<>();

        while (i < n && j < m){
            // skipping duplicates
            if(i > 0 && i < n && a[i] == a[i - 1]){
                i++;
            }

            if(j > 0 && j < m && b[j] == b[j - 1]){
                j++;
            }
            // One Array Exhaust
            if(i >= n || j >= n){
                break;
            }

            // comparison
            if(a[i] < b[j]){
                i++;
            } else if(a[i] > b[j]){
                j++;
            } else {
                result.add(a[i]);
                i++;
                j++;
            }
        }
        System.out.println(result);
        return result.size();
    }

    public static int doIntersection(int[] a, int[] b){
        Set<Integer> result = new HashSet<Integer>();
        int count = 0;

        for(int x:a){
            result.add(x);
        }

        for (int x:b){
            if(result.contains(x)){
                count++;
                result.remove(x);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3};
        int n = a.length;
        int m = b.length;

        // union - ans => 5 elements

            // using set - this will take T.C. => O(m + n) and S.C. => O(m + n)
            int result = doUnion(a,n,b,m);
            System.out.println(result); // output - 5

            // using pointers - this will take S.C. of O(1) { we use arraylist just to print the union array but question is how many elements will be if two arrays will be added }
            int pointerUnion = pointersUnion(a,n,b,m);
            System.out.println(pointerUnion);

        // intersection - ans => 3 elements

            // using set - this will take T.C. => O(m + n) and S.C. => O(m + n)
            int intersection = doIntersection(a,b);
            System.out.println(intersection); // output - 3

            // using pointers - This will take S.C. of O(1)
            int pointerIntersection = pointersIntersection(a,n,b,m);
            System.out.println(pointerIntersection);
    }
}
