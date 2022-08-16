package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sno_37_Merge_Intervals {

    private static int[][] optimisedSol (int[][] intervals ) {
        List<int[]> result = new ArrayList<>();

        // check edge cases
        if(intervals.length == 0 || intervals == null) {
            return new int[0][];
        }

        // sort the array first
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        // initialise the start and the end intervals by the first
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length ; i++) {
            // if ( intervals[i][0] <= end ) that means it should be included in the previous interval,
            // so we update the end point by choosing maximum b/w prev and current intervals
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1],end);
            } else {
                // if (intervals[i][0] > end ) that means it not going to be included in the previous interval,
                // we do two things here,
                // 1) add a new array to the result list with start and end
                // 2) update start and end with the current interval
                result.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // after for loops end, adding the last array into result list with start and end
        result.add(new int[]{start,end});

        // return the result after converting it to an array
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr =  {{8,9},{9,11},{15,18},{16,17},{1,3},{2,4},{2,6},{9,10}};

        // optimised Solution
        int[][] result = optimisedSol(arr);
        for (int[] i: result) {
            System.out.println(Arrays.toString(i));
        }
    }
}
