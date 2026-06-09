class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length < 2) return 0;

        /*
        sort the intervals by start and then end time.
        this means higher ends (which potentially overlap more intervals) lie on right side.
        our goal is to remove bigger overlaps, so when overlap happens, we remove the larger side.
        */

        Arrays.sort(intervals, 
            (a,b) ->  a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0],b[0]));
        int left =0, right=1;
        int removal = 0;
        while(right < intervals.length) {
            // find overlap and remove larger interval (one which ends later)
            if(intervals[right][0] < intervals[left][1]) {
                removal++;
                if(intervals[right][1] < intervals[left][1]) {
                    left = right; // if right ends sonner than left, we keep it
                }
                right++;
            } else {
                // no overlaps
                left = right;
                right ++;
            }
        }
        return removal;
    }
}
