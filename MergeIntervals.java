/**
56. Merge Intervals

Given an array of intervals where merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
**/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int counter = 0;
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= interval[1]) {
                if (intervals[i][1] > interval[1]) {
                    interval[1] = intervals[i][1];
                }
            } else {
                intervals[counter++] = interval;
                interval = intervals[i];
            }
        }
        intervals[counter++] = interval;
        
        int[][] res = new int[counter][2];
        for (int i = 0; i < counter; i++) {
            res[i] = intervals[i];
        }
        return res;
    }
}
